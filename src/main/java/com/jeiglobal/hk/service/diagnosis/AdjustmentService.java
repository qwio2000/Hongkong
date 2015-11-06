package com.jeiglobal.hk.service.diagnosis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.diagnosis.AdjustmentDto;
import com.jeiglobal.hk.domain.diagnosis.AdjustmentDto.AdjustmentinputSaveJson;
import com.jeiglobal.hk.repository.diagnosis.AdjustmentRepository;
import com.jeiglobal.hk.utils.CommonUtils;

/**
 * 클래스명 : AdjustmentService.java
 *
 * 작성일 : 2015. 11. 4.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */

@Service
public class AdjustmentService {
	
	@Autowired
	private AdjustmentRepository adjustmentRepository;

	Map<String, Object> param = new HashMap<>();
	
	public List<AdjustmentDto.AdjustmentList> getAdjustmentList(String jisaCD, String memKey, String subj, String ayy, String amm, String byy, String bmm) {		
		param.put("jisaCD", jisaCD);		
		param.put("memKey", memKey);		
		param.put("subj", subj);
		param.put("ayy", ayy);
		param.put("amm", amm);
		param.put("byy", byy);
		param.put("bmm", bmm);

		return adjustmentRepository.findAdjustmentList(param);
	}

	public List<AdjustmentDto.AdjustmentJindoSetList> getAdjustmentJindoSetList(String jisaCD, String subj, String dung, String chk) {
		param.put("jisaCD", jisaCD);		
		param.put("subj", subj);
		param.put("dung", dung);
		param.put("chk", chk);

		return adjustmentRepository.findAdjustmentJindoSetList(param);
	}

	public Map<String, String> addAdjustmentJindoBokSave(AdjustmentinputSaveJson bokInsert, HttpServletRequest request) {
		// TODO Auto-generated method stub
		bokInsert.setWorkID(CommonUtils.getWorkId(request));
		
		return adjustmentRepository.findAdjustmentJindoBokSave(bokInsert);
	}

	

}
