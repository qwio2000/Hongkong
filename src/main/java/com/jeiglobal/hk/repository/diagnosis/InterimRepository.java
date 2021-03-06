package com.jeiglobal.hk.repository.diagnosis;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.diagnosis.InterimDto;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : InterimRepository.java
 *
 * 작성일 : 2015. 10. 23.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 
 * 설명
 * InterimRepository
 * src/main/resource/mapper/diagnosis/interim.xml
 * 
 */
@PrimaryRepositoryAnnoInterface
public interface InterimRepository {

	Map<String, Object> findInterimSDJindoExpectLst = null;

	List<InterimDto.InterimWolJinDo> findInterimWolJinDo(Map<String, Object> map);
	
	String findInterimMpiSave(Map<String, Object> map);
	
	String findInterimMpiGichoSave(Map<String, Object> map);

	InterimDto.InterimSDGichoList findInterimSDGichoList(Map<String, Object> map);

	List<InterimDto.InterimSDWolhakLst> findInterimSDWolhakLst(Map<String, Object> map);
	
	List<InterimDto.InterimSDErrAnalysis> findInterimSDErrAnalysis(Map<String, Object> map);
	
	List<InterimDto.InterimSDJindoExpectLst> findInterimSDJindoExpectLst(Map<String, Object> map);
	
	InterimDto.InterimSDWorkBasicLst findInterimSDWorkBasicLst(Map<String, Object> map);
	
	


	
}
