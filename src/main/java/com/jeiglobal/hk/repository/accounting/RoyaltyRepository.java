/**
 * 
 */
package com.jeiglobal.hk.repository.accounting;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.accounting.RoyaltyOverviewList;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : RoyaltyRepository.java
 *
 * 작성일 : 2015. 11. 9.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface RoyaltyRepository {
	
	public List<RoyaltyOverviewList> royaltyOverviewList(Map<String, Object> param);
	public List<RoyaltyOverviewList> royaltyOverviewTot(Map<String, Object> param);
	public List<Map<String, Object>> royaltyViewOfSalesList(Map<String, Object> param);
	public Map<String, Object> royaltyView(Map<String, Object> param);
	
}
