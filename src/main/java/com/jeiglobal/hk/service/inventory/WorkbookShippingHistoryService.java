package com.jeiglobal.hk.service.inventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.inventory.WorkbookShippingHistoryDto;
import com.jeiglobal.hk.repository.inventory.WorkbookShippingHistoryRepository;

/**
 * 클래스명 : WorkbookShippingHistoryService.java
 *
 * 작성일 : 2015. 11. 20.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */

@Service
public class WorkbookShippingHistoryService {

	@Autowired
	private WorkbookShippingHistoryRepository workbookShippingHistoryRepository;

	Map<String, Object> param = new HashMap<>();
	
	public List<WorkbookShippingHistoryDto.RestockHistory> getRestockHistory(String jisaCD, String deptCD, String yy) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("yy", yy);
		
		return workbookShippingHistoryRepository.findRestockHistory(param);
	}

	public List<String> getRestockHistoryyy(String jisaCD, String deptCD) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		
		return workbookShippingHistoryRepository.findgetRestockHistoryyy(param);
	}
}
