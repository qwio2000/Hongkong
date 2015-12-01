package com.jeiglobal.hk.repository.inventory;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.inventory.WorkbookShippingHistoryDto;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : WorkbookShippingHistoryRepository.java
 *
 * 작성일 : 2015. 11. 26.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface WorkbookShippingHistoryRepository {
	
	List<WorkbookShippingHistoryDto.RestockHistory> findRestockHistory(Map<String, Object> map);
	
	List<String> findgetRestockHistoryyy(Map<String, Object> map);
	
	List<WorkbookShippingHistoryDto.HistoryRestockpop> findHistoryRestockpop(Map<String, Object> map);
	
	List<WorkbookShippingHistoryDto.RequestHistory> findRequestHistory(Map<String, Object> map);
	
	List<WorkbookShippingHistoryDto.HistoryRequestpop> findHistoryRequestpop(Map<String, Object> map);
	
	List<WorkbookShippingHistoryDto.ShippingHistory> findShippingHistory(Map<String, Object> map);
	
	List<WorkbookShippingHistoryDto.ShippingHistoryDtlList> findShippingHistoryDtlList(Map<String, Object> map);
	
	
	
	
	
	
	

}
