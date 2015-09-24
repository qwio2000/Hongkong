package com.jeiglobal.hk.repository.diagnosis;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.diagnosis.DiagnosisDto;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 
 * 클래스명 : DiagnosisRepository.java
 *
 * 작성일 : 2015. 9. 18.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * Diagnosis Repository
 * src/main/resource/mapper/diagnosis/diagnosis.xml
 */

@PrimaryRepositoryAnnoInterface
public interface DiagnosisRepository {
	List<DiagnosisDto.Diagnosis> findDiagnosis(Map<String, Object> map);	
	
	DiagnosisDto.DiagnosisInputippr findDiagnosisIppr(Map<String, Object> map);
	
	
}
