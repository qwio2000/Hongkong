/**
 * 
 */
package com.jeiglobal.hk.repository.accounting;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : PaymentRepository.java
 *
 * 작성일 : 2015. 11. 12.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface PaymentRepository {
	
	public List<Map<String, Object>> recordPayment(Map<String, Object> param);
	public List<Map<String, Object>> recordPaymentList(Map<String, Object> param);
	public String recordPaymentPopSave(Map<String, Object> param);
}
