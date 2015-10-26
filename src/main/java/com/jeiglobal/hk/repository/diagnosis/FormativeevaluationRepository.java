/**
 * 
 */
package com.jeiglobal.hk.repository.diagnosis;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.diagnosis.FormativeevaluationDto;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : FormativeevaluationRepository.java
 *
 * 작성일 : 2015. 10. 23.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 * FormativeevaluationRepository
 * src/main/resource/mapper/diagnosis/formativeevaluation.xml
 */
@PrimaryRepositoryAnnoInterface
public interface FormativeevaluationRepository {

	List<FormativeevaluationDto.FormativeevaluationWolJinDo> findFormativeevaluationWolJinDo(Map<String, Object> map);

}
