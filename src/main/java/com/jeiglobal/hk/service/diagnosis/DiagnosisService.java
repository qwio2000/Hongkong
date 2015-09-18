package com.jeiglobal.hk.service.diagnosis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.diagnosis.Diagnosis;
import com.jeiglobal.hk.repository.diagnosis.DiagnosisRepository;


@Service
public class DiagnosisService {

	@Autowired
	private DiagnosisRepository diagnosisRepository;
	
	public List<Diagnosis> getDiagnosis(String page, String pagecnt) {
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("pagecnt", pagecnt);
			
		return diagnosisRepository.findDiagnosis(map);
	}

}
