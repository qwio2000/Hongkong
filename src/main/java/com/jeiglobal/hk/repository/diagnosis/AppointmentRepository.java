package com.jeiglobal.hk.repository.diagnosis;

import java.util.*;

import com.jeiglobal.hk.domain.diagnosis.AppointmentDto.Appointment;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.repository.*;
/**
 * 
 * 클래스명 : AppointmentRepository.java
 *
 * 작성일 : 2015. 10. 21.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * src/main/resource/mapper/diagnosis/AppointmentRepository.xml
 * 
 */
@PrimaryRepositoryAnnoInterface
public interface AppointmentRepository {

	public int findAppointmentsCount(Map<String, Object> param);

	public List<MemAppointment> findAppointments(Map<String, Object> param);

	public Appointment findAppointmentByIdx(int idx);

	public void updateAppointmentByIdx(Map<String, Object> param);

}
