package com.jeiglobal.hk.repository.diagnosis;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.diagnosis.AppointmentDto;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : AppointmentRepository.java
 *
 * 작성일 : 2015. 10. 20.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 *  src/main/resource/mapper/diagnosis/appointment.xml
 */

@PrimaryRepositoryAnnoInterface
public interface AppointmentRepository {

	List<AppointmentDto.AppointmentSerch> findAppointmentSerch(Map<String, Object> map);

	List<AppointmentDto.AppointmentSerchJson> findAppointmentSerchJson(Map<String, Object> map);

}
