package com.jeiglobal.hk.service.diagnosis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.diagnosis.AdjustmentDto;
import com.jeiglobal.hk.domain.diagnosis.AdjustmentDto.AdjustmentJindoChk;
import com.jeiglobal.hk.domain.diagnosis.AdjustmentDto.AdjustmentJindoSetListAdmin;
import com.jeiglobal.hk.domain.diagnosis.AdjustmentDto.AdjustmentinputSaveJson;
import com.jeiglobal.hk.repository.diagnosis.AdjustmentRepository;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

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
	
	@Autowired
	private MessageSourceAccessor messageSourceAccesor;

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
	
	public Map<String, String> addAdjustmentJindoBokSaveAdmin(AdjustmentinputSaveJson bokInsert, HttpServletRequest request) {
		// TODO Auto-generated method stub
		bokInsert.setWorkID(CommonUtils.getWorkId(request));
		
		return adjustmentRepository.findAdjustmentJindoBokSaveAdmin(bokInsert);
	}
	
	public Map<String, String> addAdjustmentJindoDangSave(AdjustmentinputSaveJson bokInsert, HttpServletRequest request) {
		bokInsert.setWorkID(CommonUtils.getWorkId(request));	
		
		return adjustmentRepository.findAdjustmentJindoDangSave(bokInsert);
		
	}
	
	public Map<String, String> addAdjustmentJindoDangSaveAdmin(AdjustmentinputSaveJson bokInsert, HttpServletRequest request) {
		bokInsert.setWorkID(CommonUtils.getWorkId(request));	
		
		return adjustmentRepository.findAdjustmentJindoDangSaveAdmin(bokInsert);
	}


	public AdjustmentJindoChk addAdjustmentJindoChk(String jisaCD, String memKey, String subj, String bokGubun,
			String set1, String set3) {
		param.put("jisaCD", jisaCD);		
		param.put("memKey", memKey);
		param.put("subj", subj);
		param.put("bokGubun", bokGubun);
		param.put("set1", set1);
		param.put("set3", set3);

		return adjustmentRepository.findAdjustmentJindoChk(param);
	}

	
	
	public String jindochk(AdjustmentDto.AdjustmentJindoChk jindoChk) {
		String alertMsg = "";
		if(("1").equals(jindoChk.getNosayu())){
			alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error1"); // 유지 회원만 가능합니다.
		}else if(("2").equals(jindoChk.getNosayu())){
			alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error2"); // 진단 후 진도 조정이 가능합니다.
		}else if(("3").equals(jindoChk.getNosayu())){
			alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error3"); // [진도 당김]을 할 수 없습니다.\n 입.복회일로부터 3주 이내만 가능합니다.
		}else if(("4").equals(jindoChk.getNosayu())){
			alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error4"); // 진도조정 하루에 한번만 가능
		}else if(("5").equals(jindoChk.getNosayu())){
			alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error5"); // 복습은 월 2회까지만 가능합니다.이번달에 이미 진도조정(복습)을 두번 하셨습니다!
		}else if(("6").equals(jindoChk.getNosayu())){
			alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error6"); // 당김은 월 1회까지만 가능합니다.이번달에 이미 진도조정을 하셨습니다!
		}else if(("7").equals(jindoChk.getNosayu())){
			alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error7"); // 복습 세트수가 45세트를 넘었습니다.
		}else if(("8").equals(jindoChk.getNosayu())){
			alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error8"); //복습 세트수가 15세트를 넘었습니다.
		}
		return alertMsg;
	}

	public List<AdjustmentJindoSetListAdmin> getAdjustmentJindoSetListAdmin(String jisaCD, String subj) {
		param.put("jisaCD", jisaCD);		
		param.put("subj", subj);

		return adjustmentRepository.findAdjustmentJindoSetListAdmin(param);
	}

	

	

}
