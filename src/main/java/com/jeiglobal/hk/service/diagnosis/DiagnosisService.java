package com.jeiglobal.hk.service.diagnosis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.diagnosis.DiagnosisDto;
import com.jeiglobal.hk.repository.diagnosis.DiagnosisRepository;


@Service
public class DiagnosisService {

	@Autowired
	private DiagnosisRepository diagnosisRepository;
	
	public List<DiagnosisDto.Diagnosis> getDiagnosis(int page, int pagecnt, String JisaCD, String DeptCd, String Status, String LastName, String FirstName, String HomePhone, String CellPhone, String Email, String Grade, String Subject) {
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("pagecnt", pagecnt);
		map.put("JisaCD", JisaCD);
		map.put("DeptCd", DeptCd);

		map.put("Status", Status);
		map.put("LastName", LastName);
		map.put("FirstName", FirstName);
		map.put("HomePhone", HomePhone);
		map.put("CellPhone", CellPhone);
		map.put("Email", Email);
		map.put("Grade", Grade);
		map.put("Subject", Subject);
		
		return diagnosisRepository.findDiagnosis(map);
	}
	
	
	public DiagnosisDto.DiagnosisInputippr getDiagnosisInputippr(String JisaCD, String memKey, String subj, String Freejindan){
		Map<String, Object> map = new HashMap<>();
		map.put("JisaCD", JisaCD);		
		map.put("memKey", memKey);		
		map.put("subj", subj);
		map.put("Freejindan", Freejindan);
		
		return diagnosisRepository.findDiagnosisIppr(map);
		
		
	}

	
	

}
