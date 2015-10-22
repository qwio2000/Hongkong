package com.jeiglobal.hk.controller.diagnosis;

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
import com.jeiglobal.hk.domain.diagnosis.AppointmentDto.Appointment;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.service.diagnosis.*;
import com.jeiglobal.hk.utils.*;

/**
 * 
 * 클래스명 : AppointmentController.java
 *
 * 작성일 : 2015. 10. 21.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * Diagnosis -> Appointment
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
	@RequestMapping(value={"/fa/diagnosis/appointment"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getAppointmentsPage(Model model) {
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosisAppointment");
		log.debug("Getting Appointment List Page");
		model.addAttribute("headerScript", headerScript);
		return "diagnosis/appointment/list";
	}

	@RequestMapping(value={"/fa/diagnosis/appointment/search"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getAppointmentsSearchPage(Model model) {
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosisAppointment");
		log.debug("Getting Appointment List Page");
		model.addAttribute("headerScript", headerScript);
		return "diagnosis/appointment/search";
	}
	
	
	@RequestMapping(value={"/fa/diagnosis/appointment/search/{name}"}, method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getAppointmentSearchJson(Model model, @PathVariable String name, @ModelAttribute LoginInfo loginInfo){
		Map<String, Object> map = new HashMap<>();
		log.debug("Getting Appointment Search List, searchName : {}", name);
		List<Appointment> appointments = appointmentService.getAppointmentsByName(name, loginInfo.getJisaCD(), loginInfo.getDeptCD());
		map.put("appointments", appointments);
		return map;
	}
	
	@RequestMapping(value={"/fa/diagnosis/appointment/{pageNum:[0-9]{1,4}}"}, method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getAppointmentsJson(Model model, @PathVariable int pageNum, @ModelAttribute LoginInfo loginInfo){
		Map<String, Object> map = new HashMap<>();
		log.debug("Getting Appointments, DeptCD : {}", loginInfo.getDeptCD());
		PageUtil pageUtil = new PageUtil(pageNum, appointmentService.getAppointmentsCount(loginInfo.getJisaCD(), loginInfo.getDeptCD()), pageSize, blockSize);
		if(pageUtil.getTotalRowCnt() > 0){
			List<MemAppointment> appointments = appointmentService.getAppointments(loginInfo.getJisaCD(), loginInfo.getDeptCD(), pageUtil.getStartRow(), pageUtil.getEndRow());
			map.put("appointments", appointments);
		}
		map.put("pageInfo", pageUtil);
		return map;
	}
	@RequestMapping(value={"/fa/diagnosis/appointment/infopop"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getAppointmentUpdatePop(Model model, int idx, @ModelAttribute LoginInfo loginInfo) {
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosisAppointment");
		log.debug("Getting Appointment List Page");
		model.addAttribute("headerScript", headerScript);
		Appointment appointment = appointmentService.getAppointmentByIdx(idx);
		//가맹점 시간 리스트
		List<CodeDtl> manageTimes = commonService.getMemberManageTimes(loginInfo.getJisaCD(), loginInfo.getDeptCD());
		//가맹점 취급 과목 리스트
		List<SubjectOfDept> subjectOfDepts = commonService.getSubjectsOfDept(loginInfo.getJisaCD(),loginInfo.getDeptCD());
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("appointment", appointment);
		model.addAttribute("manageTimes", manageTimes);
		model.addAttribute("subjectOfDepts", subjectOfDepts);
		return "diagnosis/appointment/appointmentUpdate";
	}

	@RequestMapping(value={"/fa/diagnosis/appointment/{idx:[0-9]{1,4}}"}, method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String setAppointmentsJson(Model model, @PathVariable int idx, @ModelAttribute LoginInfo loginInfo, MemAppointment appointment,
			HttpServletRequest request) throws ParseException{
		log.debug("Update Appointment, idx : {}, {}", idx, appointment);
		String workId = CommonUtils.getWorkId(request);
		appointmentService.setAppointmentByIdx(appointment, workId);
		return messageSourceAccesor.getMessage("diagnosis.appointment.info.update");
	}
	
	/**
	 * Appointment & Free Diag 정보 등록 페이지
	 * @param model
	 * @param loginInfo
	 * @param type => 01 : 신규 Appointment, 02 : Free Diag, 03 : 기존 Appointment 회원 추가, 04 : 기존 Appointment 형제 회원 추가
	 * @param idx
	 * @return String
	 * @throws ParseException 
	 */
	@RequestMapping(value={"/fa/diagnosis/appointment/new"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getAppointmentRegistPage(Model model, @ModelAttribute LoginInfo loginInfo, String type,
			@RequestParam(defaultValue="0") int idx) throws ParseException {
		log.debug("Getting Appointment Regist Page, type : {}, idx : {}", type, idx);
		String returnPage = "diagnosis/appointment/regist";
		//학년 리스트
		List<CodeDtl> grades = commonService.getCodeDtls("0003", loginInfo.getJisaCD(), 1, "Y");
		//State 리스트
		List<CenterState> states = commonService.getCenterStates(loginInfo.getJisaCD());
		//가맹점 시간 리스트
		List<CodeDtl> manageTimes = commonService.getMemberManageTimes(loginInfo.getJisaCD(), loginInfo.getDeptCD());
		//가맹점 취급 과목 리스트
		List<SubjectOfDept> subjectOfDepts = commonService.getSubjectsOfDept(loginInfo.getJisaCD(),loginInfo.getDeptCD());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		if("02".equals(type)){
			//입회 경로 리스트
			List<CodeDtl> registHows = commonService.getCodeDtls("0009", loginInfo.getJisaCD(), 1, "Y");
			//입회 동기 리스트
			List<CodeDtl> registWhys = commonService.getCodeDtls("0202", loginInfo.getJisaCD(), 1, "Y");
			model.addAttribute("registHows", registHows);
			model.addAttribute("registWhys", registWhys);
			returnPage = "diagnosis/appointment/registFreeDiag";
		}
		MemAppointment appointment = null;
		if("03".equals(type) || "04".equals(type)){
			appointment = appointmentService.getAppointmentByIdx(idx, type);
			if("03".equals(type)){
				cal.setTime(sdf.parse(appointment.getMBirthDay()));
			}
		}else{
			appointment = new MemAppointment();
		}
		model.addAttribute("info", appointment);
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH)+1;
		int currentDay = cal.get(Calendar.DATE);
		//월 목록(short Type)
		List<MonthInfo> months = CommonUtils.getMonths(2);
		//현재 년 월의 최대 일자
		int maxDays = CommonUtils.getMaxDays(currentYear, currentMonth);

		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosisAppointment");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("type", type);
		model.addAttribute("grades", grades);
		model.addAttribute("states", states);
		model.addAttribute("manageTimes", manageTimes);
		model.addAttribute("subjectOfDepts", subjectOfDepts);
		model.addAttribute("currentYear", currentYear);
		model.addAttribute("currentMonth", new SimpleDateFormat("MM").format(cal.getTime()));
		model.addAttribute("currentDay", currentDay);
		model.addAttribute("months", months);
		model.addAttribute("maxDays", maxDays);
		return returnPage;
	}
	

}
