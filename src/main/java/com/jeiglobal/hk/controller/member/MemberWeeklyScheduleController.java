package com.jeiglobal.hk.controller.member;

import java.util.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.MemberDto.MemberWeeklyScheduleInfo;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.service.member.*;

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
	
	@RequestMapping(value={"/fa/members/weeklyschedule"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getWeeklySchedulePage(Model model, @ModelAttribute LoginInfo loginInfo){
		log.debug("member Weekly Schedule Page ");
		List<String> headerScript = new ArrayList<>();
		List<String> subjs = commonService.getOpenSubjsByDeptCD(loginInfo.getJisaCD(), loginInfo.getDeptCD());
		headerScript.add("memberWeeklySchedule");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("subjs", subjs);
		return "member/weeklyschedule/weeklyschedule";
	}
	
	@RequestMapping(value={"/fa/members/weeklyschedule/{subj}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getMemberWorkbookJson(@ModelAttribute LoginInfo loginInfo, @PathVariable String subj){
		log.debug("get member WeeklySchedule, subj : {}", subj);
		Map<String, Object> map = new HashMap<String, Object>();
		List<MemberWeeklyScheduleInfo> scheduleInfos = memberWeeklyScheduleService.getMemberWeeklySchedule(loginInfo.getJisaCD(), loginInfo.getDeptCD(), subj);
		for (MemberWeeklyScheduleInfo memberWeeklyScheduleInfo : scheduleInfos) {
			System.out.println(memberWeeklyScheduleInfo);
		}
		map.put("scheduleInfos", scheduleInfos);
		return map;
	}
	
}
