/**
 * 
 */
package com.jeiglobal.hk.service.diagnosis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.diagnosis.FormativeevaluationDto.FormativeevaluationWolJinDo;
import com.jeiglobal.hk.repository.diagnosis.FormativeevaluationRepository;

/**
 * 클래스명 : FormativeevaluationService.java
 *
 * 작성일 : 2015. 10. 23.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */
@Service
public class FormativeevaluationService {
	@Autowired
	private FormativeevaluationRepository formativeevaluationRepository;

	public List<FormativeevaluationWolJinDo> getFormativeevaluationWolJinDo(
			String jisaCD, String memKey, String subj, String yy, String mm, String wk) {
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("memKey", memKey);		
		map.put("subj", subj);
		map.put("yy", yy);
		map.put("mm", mm);
		map.put("wk", wk);
		return formativeevaluationRepository.findFormativeevaluationWolJinDo(map);
	}


}
