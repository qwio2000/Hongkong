package com.jeiglobal.hk.service.diagnosis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.diagnosis.AppointmentDto;
import com.jeiglobal.hk.domain.diagnosis.AppointmentDto.AppointmentSerch;
import com.jeiglobal.hk.repository.diagnosis.AppointmentRepository;
/**
 * 클래스명 : AppointmentService.java
 *
 * 작성일 : 2015. 10. 20.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */

@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;

	public List<AppointmentSerch> getAppointmentSearch(String name,
			String jisaCD, String deptCD, int pageNum, int pageSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);		
		map.put("jisaCD", jisaCD);		
		map.put("deptCD", deptCD);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		return appointmentRepository.findAppointmentSerch(map);
	}


	
}
