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
import com.jeiglobal.hk.domain.member.MemberDto.GuardianInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportSubjStudyInfo;
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
	
	@Value("${flag.studyNum}")
	private int studyNum;
	
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
	
	@RequestMapping(value={"/fa/members/reports/appointment"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String addAppointmentPop(String memKey, String memName, String preferredYMD, String preferredTimes, String preferredNotes, 
			String subj, @ModelAttribute LoginInfo loginInfo, HttpServletRequest request) throws ParseException {
		String workId = CommonUtils.getWorkId(request);
		memberReportService.addAppointment(memKey, memName, preferredYMD, preferredTimes, preferredNotes, subj, loginInfo, workId);
		return msa.getMessage("member.report.appointment.insert.success");
	}
	@RequestMapping(value={"/fa/members/reports/memberinfo"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberInfoPop(Model model,
			String memKey, 
			@ModelAttribute LoginInfo loginInfo) throws ParseException {
		List<CodeDtl> grades = commonService.getCodeDtls("0003", loginInfo.getJisaCD(), 1, "Y");
		MemMst memMst = memberRegistService.getMemMst(memKey);
		memMst.setMBirthDay(CommonUtils.changeDateFormat("yyyy-MM-dd", "MM/dd/yyyy", memMst.getMBirthDay()));
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		model.addAttribute("memKey", memKey);
		model.addAttribute("memMst", memMst);
		model.addAttribute("grades", grades);
		model.addAttribute("headerScript", headerScript);
		return "member/report/memberInfo";
	}
	
	@RequestMapping(value={"/fa/members/reports/memberinfo"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String addMemberInfoPop(MemMst memMst, @ModelAttribute LoginInfo loginInfo, HttpServletRequest request) throws ParseException {
		//TODO StatusCD 업데이트 할 경우 
		String workId = CommonUtils.getWorkId(request);
		memberReportService.setMemberInfo(memMst, loginInfo, workId);
		return msa.getMessage("member.report.memberInfo.update.success");
	}
	@RequestMapping(value={"/fa/members/reports/memsubjstudyinfo"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemSubjStudyInfoPop(Model model,
			String memKey, 
			@ModelAttribute LoginInfo loginInfo) {
		List<CodeDtl> manageTimes = memberRegistService.getManageTimes(loginInfo.getJisaCD(), loginInfo.getDeptCD());
		List<MemberReportSubjStudyInfo> subjStudys = memberReportService.getMemberReportSubjStudys(memKey);
		List<CodeDtl> yoils = commonService.getCodeDtls("0006", loginInfo.getJisaCD(), 1, "Y");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		model.addAttribute("memKey", memKey);
		model.addAttribute("subjStudys", subjStudys);
		model.addAttribute("manageTimes", manageTimes);
		model.addAttribute("studyNum", studyNum);
		model.addAttribute("yoils", yoils);
		model.addAttribute("headerScript", headerScript);
		return "member/report/changeYoil";
	}
	
	@RequestMapping(value={"/fa/members/reports/memsubjstudyinfo"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String setMemSubjStudyInfoPop(String[] subj, int[] studyNum, String[] yoil, String[] manageTimes, 
			String memKey, @ModelAttribute LoginInfo loginInfo, HttpServletRequest request) {
		String workId = CommonUtils.getWorkId(request);
		for (int i = 0; i < subj.length; i++) {
			//TODO 관리 요일 변경 시 진도 업데이트
			memberReportService.setMemSubjStudyInfo(subj[i], studyNum[i], yoil[i], manageTimes[i], workId, memKey);
		}
		return msa.getMessage("member.report.memberInfo.update.success");
	}
	@RequestMapping(value={"/fa/members/reports/drop","/ja/members/search/drop"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberDropPop(Model model,
			String memKey, String subj, String memName,
			@ModelAttribute LoginInfo loginInfo) {
		List<CodeDtl> dropReasons = commonService.getCodeDtls("0021", loginInfo.getJisaCD(), 1, "Y");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		model.addAttribute("memKey", memKey);
		model.addAttribute("subj", subj);
		model.addAttribute("memName", memName);
		model.addAttribute("dropReasons", dropReasons);
		model.addAttribute("headerScript", headerScript);
		return "member/report/memberDrop";
	}
	
	@RequestMapping(value={"/fa/members/reports/drop", "/ja/members/search/drop"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String setMemberDropPop(String memKey, String subj, String dropReason, String notes, String memName, 
			@ModelAttribute LoginInfo loginInfo, HttpServletRequest request) {
		String currentYMD = CommonUtils.getCurrentYMD();
		String workId = CommonUtils.getWorkId(request);
		memberReportService.setMemSubjMstByDrop(memKey, subj, currentYMD, workId);
		memberReportService.addMemSubjDrop(memKey, subj, dropReason, notes, memName, loginInfo, currentYMD, workId);
		String[] args = {memKey, subj};
		return msa.getMessage("member.report.member.drop.success", args);
	}
	@RequestMapping(value={"/fa/members/reports/dropcancel", "/ja/members/search/dropcancel"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String setMemberDropCancelPop(String memKey, String subj, String dropDate,
			@ModelAttribute LoginInfo loginInfo, HttpServletRequest request) throws ParseException {
		String workId = CommonUtils.getWorkId(request);
		String convDropDate = CommonUtils.changeDateFormat("MM/dd/yyyy", "yyyy-MM-dd", dropDate);
		memberReportService.setMemSubjMstByDropCancel(memKey, subj, workId);
		memberReportService.removeMemSubjDropByDropCancel(memKey, subj, workId, convDropDate);
		String[] args = {memKey, subj};
		return msa.getMessage("member.report.member.dropcancel.success", args);
	}
}
