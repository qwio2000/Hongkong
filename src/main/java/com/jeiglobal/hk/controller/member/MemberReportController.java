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
import com.jeiglobal.hk.domain.member.MemberDto.MemberIpprInfo;
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
		if(memMst == null){
			model.addAttribute("message", msa.getMessage("member.report.notfound"));
			model.addAttribute("url", "/fa/members/reports");
			return "alertAndRedirect";
		}
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
	
	@RequestMapping(value={"/fa/members/reports/{hkey:^[A-Z]{1}[0-9]{7}}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberReportByFreeDiag(Model model,
			@ModelAttribute LoginInfo loginInfo,
			@PathVariable String hkey) throws ParseException {
		log.debug("Getting Member Report By FreeDiag , hkey : {}", hkey);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		List<MemberDto.MemberReportFreeDiagInfo> memberReportFreeDiagInfos = memberReportService.getMemberReportFreeDiagInfoByHkey(hkey);
		String hKeys = memberReportService.getHKeys(memberReportFreeDiagInfos);
		model.addAttribute("memberReportFreeDiagInfos", memberReportFreeDiagInfos);
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("hKeys", hKeys);
		return "member/report/memberReportFreeDiag";
	}
	
	@RequestMapping(value={"/fa/members/reports/guardian"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getGuardianInfoPop(Model model,
			@ModelAttribute LoginInfo loginInfo,
			String memKey, String memKeys, 
			String type // 01 : 기존 유지/퇴회회원  02: 무료 진단
			) {
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		GuardianInfo guardianInfos = null;
		if("01".equals(type)){
			guardianInfos = memberRegistService.getGuardianInfoByMemberReport(memKey);
		}else if("02".equals(type)){
			guardianInfos = memberRegistService.getGuardianInfoByFreeDiagReport(memKey);
		}
		//State 정보
		List<CenterState> states = commonService.getCenterStates(loginInfo.getJisaCD());
		model.addAttribute("memKey", memKey);
		model.addAttribute("states", states);
		model.addAttribute("memKeys", memKeys);
		model.addAttribute("type", type);
		model.addAttribute("guardianInfos", guardianInfos);
		model.addAttribute("headerScript", headerScript);
		return "member/report/guardianInfo";
	}
	@RequestMapping(value={"/fa/members/reports/guardian"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String setGuardianInfoPop(GuardianInfo guardianInfo, String memKeys, String type, HttpServletRequest request) {
		String workId = CommonUtils.getWorkId(request);
		//MemMst의 부모 정보 Update
		memberReportService.setGuardianInfo(guardianInfo, memKeys, workId, type);
		return msa.getMessage("member.report.guardianInfo.update.success");
	}
	
	@RequestMapping(value={"/fa/members/reports/commentcall/{pageNum:[0-9]{1,4}}","/ja/members/search/commentcall/{pageNum:[0-9]{1,4}}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getCommentCalls(Model model,
			String memKey, @PathVariable int pageNum) throws ParseException {
		Map<String, Object> map = new HashMap<>();
		PageUtil pageUtil = new PageUtil(pageNum, memberReportService.getMemCommentCallsCount(memKey), 5, pageBlockSize);
		if(pageUtil.getTotalRowCnt() > 0){
			List<MemCommentCall> commentCalls = memberReportService.getMemCommentCalls(memKey, pageUtil.getStartRow(), pageUtil.getRowBlockSize());
			map.put("commentCalls", commentCalls);
		}
		map.put("pageInfo", pageUtil);
		return map;
	}
	
	@RequestMapping(value={"/fa/members/reports/commentcall", "/ja/members/search/commentcall"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String addCommentCallPop(String memKey, String memName, String callNotes, @ModelAttribute LoginInfo loginInfo, HttpServletRequest request) {
		String workId = CommonUtils.getWorkId(request);
		callNotes = CommonUtils.subStrByte(callNotes, 0, 500, 3);
		memberReportService.addCommentCall(memKey, memName, callNotes, loginInfo, workId);
		return msa.getMessage("member.report.commentcall.insert.success");
	}
	
	@RequestMapping(value={"/fa/members/reports/commentcall/delete", "/ja/members/search/commentcall/delete"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String removeCommentCall(int idx) {
		memberReportService.removeCommentCall(idx);
		return msa.getMessage("member.report.commentcall.delete.success");
	}
	
	@RequestMapping(value={"/fa/members/reports/commentcall", "/ja/members/search/commentcall"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCommentCallPop(Model model,
			String memKey, String memName) {
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		model.addAttribute("memKey", memKey);
		model.addAttribute("memName", memName);
		model.addAttribute("headerScript", headerScript);
		return "member/report/commentCall";
	}
	
	@RequestMapping(value={"/fa/members/reports/appointment"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getAppointmentPop(Model model,
			String memKey, 
			String memName,
			@ModelAttribute LoginInfo loginInfo) {
		//가맹점 시간 리스트
		List<CodeDtl> manageTimes = commonService.getMemberManageTimes(loginInfo.getJisaCD(), loginInfo.getDeptCD());
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
		//학년 정보
		List<CodeDtl> grades = commonService.getCodeDtls("0003", loginInfo.getJisaCD(), 1, "Y");
		MemMst memMst = null;
		if(!"M".equals(memKey.substring(0,1))){//회원
			memMst = memberRegistService.getMemMst(memKey);
		}else{//무료진단
			memMst = memberRegistService.getFreeGicho(memKey);
		}
		log.debug("memMst : {}", memMst);
		//MM/dd/yyyy 형태로 변경
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
		//TODO StatusCD 업데이트 하는 부분 논의 후 추가
		String workId = CommonUtils.getWorkId(request);
		memberReportService.setMemberInfoByFreeGicho(memMst, loginInfo, workId);
		if(!"M".equals(memMst.getMemKey().substring(0, 1))){
			memMst.setRemarks(CommonUtils.subStrByte(memMst.getRemarks(), 0, 500, 3));
			memberReportService.setMemberInfo(memMst, loginInfo, workId);
		}
		return msa.getMessage("member.report.memberInfo.update.success");
	}
	@RequestMapping(value={"/fa/members/reports/memsubjstudyinfo"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemSubjStudyInfoPop(Model model,
			String memKey, 
			@ModelAttribute LoginInfo loginInfo) {
		//가맹점 관리 시간
		List<CodeDtl> manageTimes = commonService.getMemberManageTimes(loginInfo.getJisaCD(), loginInfo.getDeptCD());
		//요일 목록
		List<CodeDtl> yoils = commonService.getCodeDtls("0006", loginInfo.getJisaCD(), 1, "Y");
		//회원 과목의 학습 정보
		List<MemberReportSubjStudyInfo> subjStudys = memberReportService.getMemberReportSubjStudys(memKey);
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
			//MemSubjMst & MemSubjStudy Update
			memberReportService.setMemSubjStudyInfo(subj[i], studyNum[i], yoil[i], manageTimes[i], workId, memKey);
			//MemSubjProgress Update
			memberReportService.setMemSubjProgressMst(loginInfo.getJisaCD(), memKey, subj[i], yoil[i], workId);
		}
		return msa.getMessage("member.report.memberInfo.update.success");
	}
	@RequestMapping(value={"/fa/members/reports/drop","/ja/members/search/drop"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberDropPop(Model model,
			String memKey, String subj, String memName,
			@ModelAttribute LoginInfo loginInfo) {
		//퇴회 사유
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
		//SubjMst Update : statusCD, dropFnlYMD
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
	@RequestMapping(value={"/fa/members/reports/removeappointment"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String removeMemAppointment(int idx,
			@ModelAttribute LoginInfo loginInfo, HttpServletRequest request) throws ParseException {
		memberReportService.removeMemAppointment(idx);
		return msa.getMessage("member.report.memappointment.delete.success");
	}
	@RequestMapping(value={"/fa/members/reports/ipprs"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getIpprsPop(Model model,
			String memKey, String memName,
			@ModelAttribute LoginInfo loginInfo) {
		
		List<MemberIpprInfo> ipprs = memberReportService.getMemberIpprs(memKey, loginInfo);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		model.addAttribute("memKey", memKey);
		model.addAttribute("memName", memName);
		model.addAttribute("ipprs", ipprs);
		model.addAttribute("headerScript", headerScript);
		return "member/report/ipprs";
	}
	@RequestMapping(value={"/fa/members/reports/registCancel"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> removeMemAppointment(String memKey, String subj,
			@ModelAttribute LoginInfo loginInfo, HttpServletRequest request) throws ParseException {
		String workId = CommonUtils.getWorkId(request);
		MemSubjRegist memberRegist = memberReportService.getMemSubjRegistByMemKeyAndSubj(memKey, subj);
		String type = memberRegist.getRegistGubunCD();
		Map<String, Object> returnMap = new HashMap<>();
		String hUpdCD = "01".equals(type) ? "16" : "02".equals(type) ? "18" : "17";
		returnMap.put("result", "false");
		if("01".equals(type)){
			int otherSubjCount = memberReportService.getMemSubjRegistOtherSubj(memberRegist);
			if(otherSubjCount > 0){
				returnMap.put("result", "true"); //다른 과목 존재 => 입회 취소 실패
			}else{
				//MemMst
				memberReportService.removeMemMstByMemKey(memberRegist, workId, hUpdCD);
			}
		}
		if("false".equals(returnMap.get("result").toString())){
			if("02".equals(type)){
				//MemSubjMst
				memberReportService.setMemSubjMstByMemKeyAndSubj(memberRegist, workId, hUpdCD);
				//MemSubjStudy
				memberReportService.setMemSubjStudyByMemKeyAndSubj(memberRegist, workId, hUpdCD);
			}else{
				//MemSubjMst
				memberReportService.removeMemSubjMstByMemKeyAndSubj(memberRegist, workId, hUpdCD);
				//MemSubjStudy
				memberReportService.removeMemSubjStudyByMemKeyAndSubj(memberRegist, workId, hUpdCD);
			}
			//MemSubjRegist
			memberReportService.removeMemSubjRegistByMemKeyAndSubj(memberRegist, workId, hUpdCD);
			//MemSubjTuition
			memberReportService.removeMemSubjTuitionByMemKeyAndSubj(memberRegist, workId, hUpdCD);
			if(!"02".equals(type)){
				//MemSubjProgress
				memberReportService.removeMemSubjProgressByMemKeyAndSubj(memberRegist, workId, hUpdCD);
			}
		}
		returnMap.put("count", memberReportService.getMemSubjRegistOtherSubj(memberRegist));
		return returnMap;
	}
	
	@RequestMapping(value={"/fa/members/reports/freeDiagOtherSubj"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getFreeDiagOtherSubj(Model model,
			String key, String type, // 1 : freeDiag Report, 2: Appointment List
			@ModelAttribute LoginInfo loginInfo) {
		log.debug("type : {}",type);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReportDetail");
		List<String> freeDiagOtherSubjs = null;
		if("1".equals(type)){
			freeDiagOtherSubjs = memberReportService.getFreeDiagOtherSubj(key);
		}else{
			freeDiagOtherSubjs = memberReportService.getSubjsInMemAppointment(key, loginInfo);
		}
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("freeDiagOtherSubjs", freeDiagOtherSubjs);
		model.addAttribute("key", key);
		return "member/report/freeDiagOtherSubj";
	}
	
	
}
