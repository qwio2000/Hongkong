/**
 * 
 */
package com.jeiglobal.hk.repository.accounting;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : ChargeRepository.java
 *
 * 작성일 : 2015. 11. 11.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface ChargeRepository {
	
	public List<Map<String, Object>> recordCharges(Map<String, Object> param);
	public List<Map<String, Object>> recordChargesList(Map<String, Object> param);
	public String recordChargesPopSave(Map<String, Object> param);
}
