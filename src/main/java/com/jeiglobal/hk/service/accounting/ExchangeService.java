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

import com.jeiglobal.hk.repository.accounting.ExchangeRepository;

/**
 * 클래스명 : ExchangeService.java
 *
 * 작성일 : 2015. 11. 10.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@Service
public class ExchangeService {

	@Value("${cookieShare.domain}")
	private String cookieDomain;
	
	@Autowired
	private ExchangeRepository exchangeRepository;

	public List<Map<String, Object>> getExchangeRateList(String jisaCD, String selYY) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("selYY", selYY);
		return exchangeRepository.exchangeRateList(param);				
	}
	public String getExchangeRateSave(String jisaCD, String yy, String mm, String cny, String sgd, String workId) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("yy", yy);
		param.put("mm", mm);
		param.put("cny", cny);
		param.put("sgd", sgd);
		param.put("workId", workId);
		return exchangeRepository.exchangeRateSave(param);				
	}		
	
	
	
}
