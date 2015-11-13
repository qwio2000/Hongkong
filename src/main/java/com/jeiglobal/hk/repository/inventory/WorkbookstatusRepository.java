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
	
	List<String> findWorkbookStatusDungList(Map<String, Object> map);
	
	String findIventorySetrestockqtyUpt(Map<String, Object> map);
	
	

}
