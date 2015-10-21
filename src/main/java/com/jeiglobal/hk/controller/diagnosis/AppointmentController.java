package com.jeiglobal.hk.controller.diagnosis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.diagnosis.AppointmentDto;
import com.jeiglobal.hk.domain.member.MemberDto;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.diagnosis.AppointmentService;
import com.jeiglobal.hk.service.diagnosis.DiagnosisService;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

/**
 * 
 * 클래스명 : DiagnosisController.java
 *
 * 작성일 : 2015. 9. 16.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * [Diagnosis -> Appointment] Controller
 */

@Slf4j
@Controller
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MessageSourceAccessor messageSourceAccesor;
		
	//한 페이지에 출력할 레코드 개수
	@Value("${page.size}")
	private int pageSize;
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.blockSize}")
	private int blockSize;
	
	// Appointment 조회
	@RequestMapping(value={"/fa/diagnosis/Appointment"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String appointmentList(Model model, @ModelAttribute LoginInfo loginInfo) {
		log.debug("Getting Appointment List Page");	
		
		return "diagnosis/appointment/list";
	}
	
	@RequestMapping(value={"/fa/diagnosis/AppointmentNew"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String appointmentSerch(Model model, @ModelAttribute LoginInfo loginInfo) {
		log.debug("Getting Appointment serch Page");	
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosisAppointment");
		
		model.addAttribute("headerScript", headerScript);
		
		return "diagnosis/appointment/serch";
	}
	
	
	@RequestMapping(value={"/fa/diagnosis/AppointmentNewJson"}, method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getAppointmentSerchJson(Model model,	String name, @ModelAttribute LoginInfo loginInfo, @PathVariable int pageNum){
		log.debug("get Appointment Serch : {}", name);
	
		List<AppointmentDto.AppointmentSerch> appointmentSerch = appointmentService.getAppointmentSearch(name, loginInfo.getJisaCD(), loginInfo.getDeptCD(), pageNum, pageSize);
		Map<String, Object> map = new HashMap<>();
		map.put("result", appointmentSerch);
		return map;
	}

	
	

}
