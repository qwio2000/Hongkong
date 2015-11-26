package com.jeiglobal.hk.controller.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.inventory.WorkbookShippingHistoryDto;
import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto;
import com.jeiglobal.hk.service.inventory.WorkbookShippingHistoryService;

import lombok.extern.slf4j.Slf4j;

/**
 * 클래스명 : WorkbookShippingHistory.java
 *
 * 작성일 : 2015. 11. 26.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */

@Slf4j
@Controller
public class WorkbookShippingHistory {
	@Autowired
	private WorkbookShippingHistoryService workbookShippingHistoryService;

	
	// 교재 신청내역 및 지사에서 발송한 내역 조회 WorkbookShippingHistory
	@RequestMapping(value={"/fa/inventory/workbookShippingHistory"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String workbookShippingHistory(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam(defaultValue="") String yy) {
		log.debug("Getting inventory workbookstatus");

		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);	
		
		String jisaCD = loginInfo.getJisaCD();
		String deptCD = loginInfo.getDeptCD();			
		
		// 조회 년도 리스트
		List<String> restockHistoryyy = workbookShippingHistoryService.getRestockHistoryyy(jisaCD, deptCD);
		
		if(("").equals(yy)){
			for(String yylist : restockHistoryyy){
				yy = yylist;
				break;
			}
		}
		
		//전산 및 실제 발송 수량 리스트
		List<WorkbookShippingHistoryDto.RestockHistory> restockHistory = workbookShippingHistoryService.getRestockHistory(jisaCD, deptCD, yy);
				
		model.addAttribute("yy", yy);
		model.addAttribute("yylist", restockHistoryyy);
		model.addAttribute("restocklist", restockHistory);
		
		return "inventory/workbookShippingHistory/list";
	}
	
	// 교재 신청내역 및 지사에서 발송한 내역 조회 세뷰내역 팝업
	@RequestMapping(value={"/fa/inventory/historyRestock"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String historyRestock(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam(defaultValue="") String yy) {
		log.debug("Getting inventory workbookstatus");

		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);	
		
		
		model.addAttribute("restocklist", "");
		
		return "inventory/workbookShippingHistory/historyRestock";
	}
	
	
	
}
