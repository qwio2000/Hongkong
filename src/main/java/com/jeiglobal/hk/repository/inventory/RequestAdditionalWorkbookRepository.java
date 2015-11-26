package com.jeiglobal.hk.repository.inventory;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.inventory.RequestAdditionalWorkbookDto;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : RequestAdditionalWorkbookRepository.java
 *
 * 작성일 : 2015. 11. 20.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */

@PrimaryRepositoryAnnoInterface
public interface RequestAdditionalWorkbookRepository {
	
	List<RequestAdditionalWorkbookDto.IvnWorkBookRequestAW> findIvnWorkBookRequestAW(Map<String, Object> map);
	
	List<RequestAdditionalWorkbookDto.ShipToCerritos> findShipToCerritos(Map<String, Object> map);
	
	List<RequestAdditionalWorkbookDto.ShipToCerritosDate> findShipToCerritosDate(Map<String, Object> map);
	
	String findShipToCerritosUpt(Map<String, Object> map);
	
	
	

}
