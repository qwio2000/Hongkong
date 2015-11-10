package com.jeiglobal.hk.controller.member;

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
import com.jeiglobal.hk.domain.member.MemberDto.MemberWeeklyDetailInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberWeeklyScheduleInfo;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.service.member.*;
import com.jeiglobal.hk.utils.*;

/**
 * 
 * 클래스명 : MemberWorkbookController.java
 *
 * 작성일 : 2015. 10. 14.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * FA : Members => Member Weekly Schedule
 */
@Slf4j
@Controller
public class MemberWeeklyScheduleController {
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MemberWeeklyScheduleService memberWeeklyScheduleService;
	
	@Autowired
	private MessageSourceAccessor msa;
	
	@Autowired
	private MemberReportService memberReportService;
	
	@RequestMapping(value={"/fa/members/weeklyschedule", "/ja/members/weeklyschedule"}, method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getWeeklySchedulePage(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam(value="subj", defaultValue="All", required=false) String subj){
		log.debug("member Weekly Schedule Page ");
		List<String> headerScript = new ArrayList<>();
		List<String> subjs = commonService.getOpenSubjsByJisaCD(loginInfo.getJisaCD());
		headerScript.add("memberWeeklySchedule");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("subjs", subjs);
		String viewName = "alertAndRedirect";
		if("JA".equalsIgnoreCase(loginInfo.getUserType())){
			List<MemberWeeklyScheduleInfo> scheduleInfos = memberWeeklyScheduleService.getMemberWeeklyScheduleJA(loginInfo.getJisaCD(), subj);
			model.addAttribute("subj", subj);
			model.addAttribute("scheduleInfos", scheduleInfos);
			viewName = "member/weeklyschedule/weeklyscheduleJA";
		}else if("FA".equalsIgnoreCase(loginInfo.getUserType())){
			viewName = "member/weeklyschedule/weeklyschedule";
		}else{
			model.addAttribute("message", msa.getMessage("members.weeklyschedule.error"));
			model.addAttribute("url", "/"+loginInfo.getUserType().toLowerCase()+"/members/weeklyschedule");
		}
		return viewName;
	}
	
	@RequestMapping(value={"/fa/members/weeklyschedule/{subj}"}, method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getMemberWorkbookJson(@ModelAttribute LoginInfo loginInfo, @PathVariable String subj){
		log.debug("get member WeeklySchedule, subj : {}", subj);
		Map<String, Object> map = new HashMap<String, Object>();
		List<MemberWeeklyScheduleInfo> scheduleInfos = memberWeeklyScheduleService.getMemberWeeklySchedule(loginInfo.getJisaCD(), loginInfo.getDeptCD(), subj);
		map.put("scheduleInfos", scheduleInfos);
		return map;
	}
	
	@RequestMapping(value={"/ja/members/weeklyschedule/detail"}, method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getMemberWeeklyDetailJson(@ModelAttribute LoginInfo loginInfo, String time, String yoil, String subj){
		log.debug("Getting member WeeklySchedule Detail");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MemberWeeklyDetailInfo> list = memberWeeklyScheduleService.getMemberWeeklyDetailInfo(loginInfo.getJisaCD(), time, yoil, subj);
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value={"/fa/members/weeklyschedule/manageInfo"}, method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getManageUpdatePage(Model model, @ModelAttribute LoginInfo loginInfo, String memKey, String memName, String subj){
		log.debug("member ManageInfo Update {} : {}", memKey, subj);
		List<String> headerScript = new ArrayList<>();
		//가맹점 시간 리스트
		List<CodeDtl> manageTimes = commonService.getMemberManageTimes(loginInfo.getJisaCD(), loginInfo.getDeptCD());
		//요일 목록
		List<CodeDtl> yoils = commonService.getCodeDtls("0006", loginInfo.getJisaCD(), 1, "Y");
		MemSubjStudy memSubjStudy = memberWeeklyScheduleService.getMemSubjStudyByMemKeyAndSubj(memKey, subj);
		headerScript.add("memberWeeklySchedule");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("manageTimes", manageTimes);
		model.addAttribute("yoils", yoils);
		model.addAttribute("memSubjStudy", memSubjStudy);
		model.addAttribute("memName", memName);
		return "member/weeklyschedule/manageUpdate";
	}
	
	@RequestMapping(value={"/fa/members/weeklyschedule/manageInfo"}, method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String setManageUpdateJson(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request, 
			String memKey, String subj, String yoil, String manageTime){
		log.debug("Update Member ManageUpdate, memKey : {}, subj : {}", memKey, subj);
		String workId = CommonUtils.getWorkId(request);
		memberWeeklyScheduleService.setMemSubjMstByMemKeyAndSubj(memKey, subj, workId, yoil);
		memberWeeklyScheduleService.setMemSubjStudyByMemKeyAndSubj(memKey, subj, workId, yoil, manageTime);
		memberReportService.setMemSubjProgressMst(loginInfo.getJisaCD(), memKey, subj, yoil, workId);
		return msa.getMessage("member.weeklyschedule.update.success");
	}
	
}
