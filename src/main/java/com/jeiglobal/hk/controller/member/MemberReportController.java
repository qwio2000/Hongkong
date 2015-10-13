package com.jeiglobal.hk.controller.member;

import java.text.*;
import java.util.*;

import javax.servlet.http.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.*;
import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.service.member.*;
import com.jeiglobal.hk.utils.*;

/**
 * 
 * 클래스명 : MemberReportController.java
 *
 * 작성일 : 2015. 9. 17.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * FA : Members => Member Report
 */
@Slf4j
@Controller
public class MemberReportController {
	
	@Autowired
	private MemberReportService memberReportService;
	
	@Autowired
	private MemberRegistService memberRegistService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MessageSourceAccessor msa;
	
	@Value("${page.size}")
	private int pageSize;
	
	@Value("${page.blockSize}")
	private int pageBlockSize;
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(value={"/fa/members/reports"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberReport(Model model,
			@ModelAttribute LoginInfo loginInfo,
			MemberDto.MemberSearch memberSearch){
		log.debug("report Page {}", memberSearch);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReport");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("memberSearch", memberSearch);
		return "member/report/report";
	}
	
	@RequestMapping(value={"/fa/members/reports/{pageNum:[0-9]{1,4}}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getMemberReports(@ModelAttribute LoginInfo loginInfo,
			MemberDto.MemberSearch memberSearch,
			@PathVariable int pageNum){
		log.debug("get member reports {}",memberSearch);
		List<MemberDto.MemberSearchInfo> members = memberReportService.getSearchResults(memberSearch, loginInfo, pageNum, pageSize);
		int totalCnt = (members.size()>0)? members.get(0).getRCnt() : 0;
		PageUtil pageUtil = new PageUtil(pageNum, totalCnt, pageSize, pageBlockSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("members", members);
		map.put("pageInfo", pageUtil);
		return map;
	}
	
	@RequestMapping(value={"/fa/members/reports/{memKey:^[A-Z]{2}[0-9]{6}}", "/ja/members/search/{memKey:^[A-Z]{2}[0-9]{6}}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberReport(Model model,
			@ModelAttribute LoginInfo loginInfo,
			@PathVariable String memKey) throws ParseException{
		log.debug("Getting Member Report memKey : {}", memKey);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		MemMst memMst = memberReportService.getMemMstByMemKey(memKey);
		List<MemberDto.MemberReportInfo> memberReportInfos = memberReportService.getMemberReportInfo(memMst, loginInfo);
		String memKeys = memberReportService.getMemKeys(memberReportInfos);
		model.addAttribute("guardianInfo", memMst);
		model.addAttribute("memberReportInfos", memberReportInfos);
		model.addAttribute("memKey", memKey);
		model.addAttribute("memKeys", memKeys);
		model.addAttribute("headerScript", headerScript);
		String view = ("FA".equalsIgnoreCase(loginInfo.getUserType())) ? "member/report/memberReport" 
				: ("JA".equalsIgnoreCase(loginInfo.getUserType())) ? "member/search/memberReport" : ""; 
		return view;
	}
	@RequestMapping(value={"/fa/members/reports/guardian"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getGuardianInfoPop(Model model,
			@ModelAttribute LoginInfo loginInfo,
			String memKey, String memKeys) {
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		GuardianInfo guardianInfos = memberRegistService.getGuardianInfo(memKey);
		List<CenterState> states = commonService.getCenterStates(loginInfo.getJisaCD());
		model.addAttribute("memKey", memKey);
		model.addAttribute("states", states);
		model.addAttribute("memKeys", memKeys);
		model.addAttribute("guardianInfos", guardianInfos);
		model.addAttribute("headerScript", headerScript);
		return "member/report/guardianInfo";
	}
	@RequestMapping(value={"/fa/members/reports/guardian"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String setGuardianInfoPop(GuardianInfo guardianInfo, String memKeys, HttpServletRequest request) {
		String workId = CommonUtils.getWorkId(request);
		memberReportService.setGuardianInfo(guardianInfo, memKeys, workId);
		return msa.getMessage("member.report.guardianInfo.update.success");
	}
	
	@RequestMapping(value={"/fa/members/reports/commentcall"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCommentCallPop(Model model,
			String memKey, String memName) {
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		model.addAttribute("memKey", memKey);
		model.addAttribute("memName", memName);
		model.addAttribute("headerScript", headerScript);
		return "member/report/commentCall";
	}
	
	@RequestMapping(value={"/fa/members/reports/commentcall"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String addCommentCallPop(String memKey, String memName, String callNotes, @ModelAttribute LoginInfo loginInfo, HttpServletRequest request) {
		String workId = CommonUtils.getWorkId(request);
		memberReportService.addCommentCall(memKey, memName, callNotes, loginInfo, workId);
		return msa.getMessage("member.report.commentcall.insert.success");
	}
	@RequestMapping(value={"/fa/members/reports/appointment"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getAppointmentPop(Model model,
			String memKey, 
			String memName,
			@ModelAttribute LoginInfo loginInfo) {
		//가맹점 시간 리스트
		List<CodeDtl> manageTimes = memberRegistService.getManageTimes(loginInfo.getJisaCD(), loginInfo.getDeptCD());
		//회원이 진행 중인 과목 리스트를 제외한 가맹점 취급 과목 리스트
		List<SubjectOfDept> subjects = memberReportService.getMemberSubjects(memKey, loginInfo);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		model.addAttribute("memKey", memKey);
		model.addAttribute("memName", memName);
		model.addAttribute("manageTimes", manageTimes);
		model.addAttribute("subjects", subjects);
		model.addAttribute("headerScript", headerScript);
		return "member/report/appointment";
	}
}
