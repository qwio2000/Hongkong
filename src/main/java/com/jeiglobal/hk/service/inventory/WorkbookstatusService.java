package com.jeiglobal.hk.service.inventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto;
import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto.WorkbookStatusMstList;
import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto.WorkbookStatusMstsubj;
import com.jeiglobal.hk.repository.inventory.WorkbookstatusRepository;

/**
 * 클래스명 : WorkbookstatusService.java
 *
 * 작성일 : 2015. 11. 12.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */

@Service
public class WorkbookstatusService {

	@Autowired
	private WorkbookstatusRepository workbookstatusRepository;

	Map<String, Object> param = new HashMap<>();
	
	public List<WorkbookstatusDto.WorkbookStatusMstList> getWorkbookStatusMstList(String jisaCD, String statusCD) {
		param.put("jisaCD", jisaCD);
		param.put("statusCD", statusCD);
		List<WorkbookstatusDto.WorkbookStatusMstList> list = workbookstatusRepository.findWorkbookStatusMstList(param);
		for (WorkbookStatusMstList workbookStatusMstList : list) {
			param.put("jisaCD", workbookStatusMstList.getJisacd());
			param.put("deptCD", workbookStatusMstList.getDeptcd());
			workbookStatusMstList.setSubj(workbookstatusRepository.findWorkbookStatusMstsubj(param));
		}
		
		return list;
	}

	public List<WorkbookStatusMstsubj> getWorkbookStatusMstsubj(String jisaCD, String deptCD) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		return workbookstatusRepository.findWorkbookStatusMstsubj(param);
	}
}
