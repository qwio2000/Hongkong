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

import com.jeiglobal.hk.repository.accounting.PaymentRepository;

/**
 * 클래스명 : PaymentService.java
 *
 * 작성일 : 2015. 11. 12.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@Service
public class PaymentService {
	@Value("${cookieShare.domain}")
	private String cookieDomain;
	
	@Autowired
	private PaymentRepository paymentRepository;

	
	public List<Map<String, Object>> getRecordPayment(String jisaCD, String mgYY, String mgMM) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("mgYY", mgYY);
		param.put("mgMM", mgMM);
		return paymentRepository.recordPayment(param);				
	}
	public List<Map<String, Object>> getRecordPaymentList(String jisaCD, String deptCD, String mgYY, String mgMM, String jobFlag, String userType) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("mgYY", mgYY);
		param.put("mgMM", mgMM);
		param.put("jobFlag", jobFlag);
		param.put("userType", userType);
		return paymentRepository.recordPaymentList(param);				
	}	
	public String getRecordPaymentPopSave(String jisaCD, String deptCD, String payYMD, String mgYY, String mgMM, String payCD, String refNo, String memo, int amount, String workId, int idx) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("payYMD", payYMD);
		param.put("mgYY", mgYY);
		param.put("mgMM", mgMM);
		param.put("payCD", payCD);
		param.put("refNo", refNo);
		param.put("memo", memo);
		param.put("amount", amount);
		param.put("workId", workId);
		param.put("idx", idx);
		return paymentRepository.recordPaymentPopSave(param);				
	}		
	
}
