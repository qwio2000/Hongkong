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

import com.jeiglobal.hk.domain.accounting.RoyaltyOverviewList;
import com.jeiglobal.hk.repository.accounting.RoyaltyRepository;

/**
 * 클래스명 : RoyaltyService.java
 *
 * 작성일 : 2015. 11. 9.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명	: Accounting > Royalty
 */
@Service
public class RoyaltyService {
	@Value("${cookieShare.domain}")
	private String cookieDomain;
	
	@Autowired
	private RoyaltyRepository royaltyRepository;

	public List<RoyaltyOverviewList> getRoyaltyOverviewList(String jisaCD, String deptCD, String selYY, String selMM, String userType) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("selYY", selYY);
		param.put("selMM", selMM);
		param.put("userType", userType);
		return royaltyRepository.royaltyOverviewList(param);				
	}	
	public List<RoyaltyOverviewList> getRoyaltyOverviewTot(String jisaCD, String deptCD, String selYY, String selMM, String userType) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("selYY", selYY);
		param.put("selMM", selMM);
		param.put("userType", userType);
		return royaltyRepository.royaltyOverviewTot(param);				
	}	
}
