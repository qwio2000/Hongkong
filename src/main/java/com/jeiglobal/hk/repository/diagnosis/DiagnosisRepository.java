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
	
	DiagnosisDto.DiagnosisTotMunGet findDiagnosisTotMunGet(Map<String, Object> map);
	
	List<DiagnosisDto.DiagnosisJDSys8070P> findDiagnosisJDSys8070P(Map<String, Object> map);	
	
	Map<String, String> findDiagnosisOmrGicho(DiagnosisDto.DiagnosisOmrInsert omrInsert);
	
	String findDiagnosisOmrOdab(Map<String, Object> map);
	
	String findDiagnosisOmrOdabG(Map<String, Object> map);
	
	List<DiagnosisDto.DiagnosisOmrChkG> findDiagnosisOmrChkG(Map<String, Object> map);

	String findDiagnosisOmrBan(Map<String, Object> map);

	DiagnosisDto.DiagnosisOmrPrint findDiagnosisOmrPrint(Map<String, Object> map);
	DiagnosisDto.DiagnosisOmrPrintLang findDiagnosisOmrPrintLang(Map<String, Object> map);

	List<DiagnosisDto.DiagnosisOdab> findDiagnosisOdab(Map<String, Object> map);
	List<DiagnosisDto.DiagnosisOdabLang> findDiagnosisOdabLang(Map<String, Object> map);

	DiagnosisDto.DiagnosisRangeAllGet findDiagnosisRangeAllGet(Map<String, Object> map);

	DiagnosisDto.DiagnosisRange findDiagnosisRange(Map<String, Object> map);
	DiagnosisDto.DiagnosisRangeGrpLang findDiagnosisRangeGrpLang(Map<String, Object> map);

	List<DiagnosisDto.DiagnosisOdab12> findDiagnosisOdab12(Map<String, Object> map);

	List<DiagnosisDto.DiagnosisOdab2> findDiagnosisOdab2(Map<String, Object> map);

	List<DiagnosisDto.DiagnosisOdab4> findDiagnosisOdab4(Map<String, Object> map);

	DiagnosisDto.DiagnosisSooJun findDiagnosisSooJun(Map<String, Object> map);

	DiagnosisDto.DiagnosisStartYYMM findDiagnosisStartYYMM(Map<String, Object> map);
	DiagnosisDto.DiagnosisStartYYMMLang findDiagnosisStartYYMMLang(Map<String, Object> map);
	
	List<DiagnosisDto.DiagnosisJindo> findDiagnosisJindo(Map<String, Object> map);
	List<DiagnosisDto.DiagnosisJindoLang> findDiagnosisJindoLang(Map<String, Object> map);

	List<DiagnosisDto.DiagnosisNext> findDiagnosisNext(Map<String, Object> map);
	List<DiagnosisDto.DiagnosisNextLang> findDiagnosisNextLang(Map<String, Object> map);
	
	DiagnosisDto.DiagnosisRangeHlLang findDiagnosisRangeHlLang(Map<String, Object> map);

}