package com.jeiglobal.hk.controller.community;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.community.Calendar;
import com.jeiglobal.hk.service.community.CalendarService;



/**
 * @since	2015-10-01
 * @author	이지은
 * @see		
 */
 
@Slf4j
@Controller
public class CalendarController {
	
	@Autowired
	private CalendarService calendarservice;
	
	
	//리스트 가져오기
	@RequestMapping(value={"/ja/community/calendar","/ja/community"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String List(Model model, @ModelAttribute LoginInfo loginInfo){
		String userType = loginInfo.getUserType();
		log.debug("Getting List Page, UserType : {}", userType);
		
		List<Calendar> callist = calendarservice.CalendarList(loginInfo);
		//String jsonlist = JSONArray.toJSONString(callist);
		
		String jsonlist = new Gson().toJson(callist);
		
		model.addAttribute("callist",jsonlist);
		
		return "community/main";
	}
	
	// 캘린더 상세보기
	@RequestMapping(value={"/ja/community/calendardetail","/ja/community"}, method={RequestMethod.POST,RequestMethod.HEAD})
	public String DetailCal(Model model, @ModelAttribute LoginInfo loginInfo , @RequestParam int aidx){
		Calendar calone = calendarservice.CalendarDetail(aidx);
		model.addAttribute("calone",calone);
		return "community/caldetail";
	}
	
	@RequestMapping(value={"/ja/community/calendarwrite","/ja/community"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String WriteCal(Model model, @ModelAttribute LoginInfo loginInfo , @RequestParam String startdate){
		model.addAttribute("startdate",startdate);
		return "community/calwrite";
	}
}
