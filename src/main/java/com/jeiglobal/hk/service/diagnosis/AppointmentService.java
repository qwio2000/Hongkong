package com.jeiglobal.hk.service.diagnosis;

import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.diagnosis.AppointmentDto.Appointment;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.repository.diagnosis.*;
import com.jeiglobal.hk.utils.*;
/**
 * 
 * 클래스명 : AppointmentService.java
 *
 * 작성일 : 2015. 10. 21.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	Map<String, Object> param = new HashMap<>();

//	public List<AppointmentSerch> getAppointmentSearch(String name,
//			String jisaCD, String deptCD, int pageNum, int pageSize) {
//		map.put("name", name);		
//		map.put("jisaCD", jisaCD);		
//		map.put("deptCD", deptCD);
//		map.put("pageNum", pageNum);
//		map.put("pageSize", pageSize);
//		
//		return appointmentRepository.findAppointmentSerch(map);
//	}

	/**
	 * @param jisaCD
	 * @param deptCD
	 * @return int
	 */
	public int getAppointmentsCount(String jisaCD, String deptCD) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		return appointmentRepository.findAppointmentsCount(param);
	}

	/**
	 * @param jisaCD
	 * @param deptCD
	 * @param startRow
	 * @param endRow
	 * @return List<MemAppointment>
	 */
	public List<MemAppointment> getAppointments(String jisaCD, String deptCD,
			int startRow, int endRow) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("startRow", startRow);
		param.put("endRow", endRow);
		return appointmentRepository.findAppointments(param);
	}

	/**
	 * @param idx
	 * @return Appointment
	 */
	public Appointment getAppointmentByIdx(int idx) {
		return appointmentRepository.findAppointmentByIdx(idx);
	}

	/**
	 * Appointment 수정
	 * @param appointment
	 * @param workId 
	 * @throws ParseException 
	 */
	public void setAppointmentByIdx(MemAppointment appointment, String workId) throws ParseException {
		appointment.setPreferredYMD(CommonUtils.changeDateFormat("MM/dd/yyyy", "yyyy-MM-dd", appointment.getPreferredYMD()));
		param.clear();
		param.put("workId", workId);
		param.put("appointment", appointment);
		appointmentRepository.updateAppointmentByIdx(param);
		
	}


	
}
