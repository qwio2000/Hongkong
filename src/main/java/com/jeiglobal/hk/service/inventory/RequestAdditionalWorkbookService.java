package com.jeiglobal.hk.service.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.inventory.RequestAdditionalWorkbookDto;
import com.jeiglobal.hk.domain.inventory.RequestAdditionalWorkbookDto.IvnWorkBookRequestAWDungList;
import com.jeiglobal.hk.repository.inventory.RequestAdditionalWorkbookRepository;

/**
 * 클래스명 : RequestAdditionalWorkbookService.java
 *
 * 작성일 : 2015. 11. 20.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */

@Service
public class RequestAdditionalWorkbookService {

	@Autowired
	private RequestAdditionalWorkbookRepository requestAdditionalWorkbookRepository;

	Map<String, Object> param = new HashMap<>();
	
	public List<RequestAdditionalWorkbookDto.IvnWorkBookRequestAW> getIvnWorkBookRequestAW(String jisaCD, String deptCD, String subj) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("subj", subj);
		List<RequestAdditionalWorkbookDto.IvnWorkBookRequestAW> list = requestAdditionalWorkbookRepository.findIvnWorkBookRequestAW(param);
		for (RequestAdditionalWorkbookDto.IvnWorkBookRequestAW ivnWorkBookRequestAW : list){
			List<IvnWorkBookRequestAWDungList> dungList = new ArrayList<>();
			List<String> splitAry = Arrays.asList(ivnWorkBookRequestAW.getAlllist().split(","));
			for (String string : splitAry){
				String[] innerSplitAry = string.split("\\|");
				dungList.add(new IvnWorkBookRequestAWDungList(innerSplitAry[0], innerSplitAry[1], innerSplitAry[2], innerSplitAry[3], innerSplitAry[4], innerSplitAry[5], innerSplitAry[6]));
			}
			ivnWorkBookRequestAW.setDungList(dungList);
			
		}
		
		return list;
	}

	public List<RequestAdditionalWorkbookDto.ShipToCerritos> getShipToCerritos(String jisaCD, String deptCD, String additionalworkbook) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("additionalworkbook", additionalworkbook);
		
		return requestAdditionalWorkbookRepository.findShipToCerritos(param);
	}

	public List<RequestAdditionalWorkbookDto.ShipToCerritosDate> getShipToCerritosDate(String jisaCD, String deptCD) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		
		return requestAdditionalWorkbookRepository.findShipToCerritosDate(param);
	}

	public String addShipToCerritosUpt(String jisaCD, String deptCD, String additionalworkbook, String data, String signDate, String gubun,
			String workId) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("additionalworkbook", additionalworkbook);
		param.put("data", data);
		param.put("signDate", signDate);
		param.put("gubun", gubun);
		param.put("workId", workId);
		
		return requestAdditionalWorkbookRepository.findShipToCerritosUpt(param);
	}
}
