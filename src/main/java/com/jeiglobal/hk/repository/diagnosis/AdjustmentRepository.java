package com.jeiglobal.hk.repository.diagnosis;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.diagnosis.AdjustmentDto;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : AdjustmentRepository.java
 *
 * 작성일 : 2015. 11. 4.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface AdjustmentRepository {

	List<AdjustmentDto.AdjustmentList> findAdjustmentList(Map<String, Object> map);
	
	List<AdjustmentDto.AdjustmentJindoSetList> findAdjustmentJindoSetList(Map<String, Object> map);
	
	Map<String, String> findAdjustmentJindoBokSave(AdjustmentDto.AdjustmentinputSaveJson bokInsert);
}


