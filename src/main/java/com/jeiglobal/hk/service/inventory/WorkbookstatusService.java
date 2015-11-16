package com.jeiglobal.hk.service.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto;
import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto.WorkbookStatusMstList;
import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto.WorkbookStatusSetDungList;
import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto.WorkbookStatusSetList;
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
			param.put("jisaCD", workbookStatusMstList.getJisaCD());
			param.put("deptCD", workbookStatusMstList.getDeptCD());
			workbookStatusMstList.setSubj(workbookstatusRepository.findWorkbookStatusMstsubj(param));
		}
		
		return list;
	}

	public List<WorkbookstatusDto.WorkbookStatusMstsubj> getWorkbookStatusMstsubj(String jisaCD, String deptCD) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		return workbookstatusRepository.findWorkbookStatusMstsubj(param);
	}

	public List<WorkbookstatusDto.WorkbookStatusSetList> getWorkbookStatusSetList(String jisaCD, String deptCD, String subj) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("subj", subj);	
		List<WorkbookStatusSetList> list = workbookstatusRepository.findWorkbookStatusSetList(param);
		for (WorkbookStatusSetList workbookStatusSetList : list) {
			List<WorkbookStatusSetDungList> dungList = new ArrayList<>();
			List<String> splitAry = Arrays.asList(workbookStatusSetList.getAlllist().split(","));
			for (String string : splitAry) {
				String[] innerSplitAry = string.split("\\|");
				dungList.add(new WorkbookStatusSetDungList(innerSplitAry[0], innerSplitAry[1], innerSplitAry[2], innerSplitAry[3], innerSplitAry[4], innerSplitAry[5], innerSplitAry[6]));
			}
			workbookStatusSetList.setDungList(dungList);
		}
		
		return list;
	}

	public List<String> getWorkbookStatusDungList(String jisaCD, String subj) {
		param.put("jisaCD", jisaCD);
		param.put("subj", subj);
		return workbookstatusRepository.findWorkbookStatusDungList(param);
	}

	public String addIventorySetrestockqtyUpt(String jisaCD, String deptCD, String subj, String allset, String workId) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("subj", subj);
		param.put("allset", allset);
		param.put("workId", workId);
		return workbookstatusRepository.findIventorySetrestockqtyUpt(param);
		
	}

	public String addIventoryShipInventoryUpt(String jisaCD, String deptCD, String subj, String allset, String workId) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("subj", subj);
		param.put("allset", allset);
		param.put("workId", workId);
		return workbookstatusRepository.findIventoryShipInventoryUpt(param);
		
	}

	
}
