/**
 * 
 */
package com.jeiglobal.hk.repository.accounting;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : ExchangeRepository.java
 *
 * 작성일 : 2015. 11. 10.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface ExchangeRepository {
	
	public List<Map<String, Object>> exchangeRateList(Map<String, Object> param);
	public String exchangeRateSave(Map<String, Object> param);

	
}
