/**
 * 
 */
package com.jeiglobal.hk.service.accounting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.repository.accounting.ChargeRepository;

/**
 * 클래스명 : ChargeService.java
 *
 * 작성일 : 2015. 11. 11.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@Service
public class ChargeService {
	@Value("${cookieShare.domain}")
	private String cookieDomain;
	
	@Autowired
	private ChargeRepository chargeRepository;

	public List<Map<String, Object>> getRecordCharge(String jisaCD, String mgYY, String mgMM) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("mgYY", mgYY);
		param.put("mgMM", mgMM);
		return chargeRepository.recordCharges(param);				
	}
	public List<Map<String, Object>> getRecordChargeList(String jisaCD, String deptCD, String mgYY, String mgMM, String jobFlag, String userType) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("mgYY", mgYY);
		param.put("mgMM", mgMM);
		param.put("jobFlag", jobFlag);
		param.put("userType", userType);
		return chargeRepository.recordChargesList(param);				
	}	
	public String getRecordChargesPopSave(String jisaCD, String deptCD, String chargeYMD, String mgYY, String mgMM, String chargeCD, String memo, int amount, String workId, int idx) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("chargeYMD", chargeYMD);
		param.put("mgYY", mgYY);
		param.put("mgMM", mgMM);
		param.put("chargeCD", chargeCD);
		param.put("memo", memo);
		param.put("amount", amount);
		param.put("workId", workId);
		param.put("idx", idx);
		return chargeRepository.recordChargesPopSave(param);				
	}		
	
	
}
