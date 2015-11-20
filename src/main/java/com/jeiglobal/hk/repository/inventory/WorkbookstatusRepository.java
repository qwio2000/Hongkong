package com.jeiglobal.hk.repository.inventory;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : WorkbookstatusRepository.java
 *
 * 작성일 : 2015. 11. 12.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */

@PrimaryRepositoryAnnoInterface
public interface WorkbookstatusRepository {
	List<WorkbookstatusDto.WorkbookStatusMstList> findWorkbookStatusMstList(Map<String, Object> map);
	
	List<WorkbookstatusDto.WorkbookStatusMstsubj> findWorkbookStatusMstsubj(Map<String, Object> map);
	
	List<WorkbookstatusDto.WorkbookStatusSetList> findWorkbookStatusSetList(Map<String, Object> map);
	
	List<WorkbookstatusDto.IvnWorkBookInOutPrint> findIvnWorkBookInOutPrint(Map<String, Object> map);
	
	List<String> findWorkbookStatusDungList(Map<String, Object> map);
	
	String findInventorySetrestockqtyUpt(Map<String, Object> map);
	
	String findInventoryShipInventoryUpt(Map<String, Object> map);
	
	List<WorkbookstatusDto.WorkbookInOutSubjList> findWorkbookInOutSubjList(Map<String, Object> map);
	
	List<WorkbookstatusDto.WorkbookStatusInventorySet> findWorkbookStatusInventorySet(Map<String, Object> map);
	
	
	

}
