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

import com.jeiglobal.hk.domain.CodeDtl;
import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.inventory.WorkbookShippingHistoryDto;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.inventory.WorkbookShippingHistoryService;
import com.jeiglobal.hk.service.inventory.WorkbookstatusService;

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

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private WorkbookstatusService workbookstatusService;
	
	// 가맹점 교재 신청내역 및 지사에서 발송한 내역 조회 WorkbookShippingHistory
	@RequestMapping(value={"/fa/inventory/workbookShippingHistory"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String workbookShippingHistory(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam(defaultValue="") String yy) {
		log.debug("Getting inventory workbookShippingHistory");

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
		
		//가맹점 긴급교재 신청 내역
		List<WorkbookShippingHistoryDto.RequestHistory> requestHistory = workbookShippingHistoryService.getRequestHistory(jisaCD, deptCD, yy);
				
		model.addAttribute("jisaCD", jisaCD);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("yy", yy);
		model.addAttribute("yylist", restockHistoryyy);
		model.addAttribute("restocklist", restockHistory);
		model.addAttribute("requestlist", requestHistory);
		
		return "inventory/workbookShippingHistory/list";
	}
	
	// 교재 신청내역 및 지사에서 발송한 내역 조회 세부내역 팝업
	@RequestMapping(value={"/fa/inventory/historyRestockpop"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String historyRestockpop(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam(defaultValue="") String yy, String jisaCD, String deptCD, String mm) {
		log.debug("Getting inventory historyRestockpop");

		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);	
		
		
		CodeDtl mmnm = commonService.getCodeDtl("0207", jisaCD, mm);
		String mmname = mmnm.getDtlCDNMK();
		
		//전산 및 실제 발송 수량 리스트
		List<WorkbookShippingHistoryDto.HistoryRestockpop> historyRestockpop = workbookShippingHistoryService.getHistoryRestockpop(jisaCD, deptCD, yy, mm);
				
		model.addAttribute("yy", yy);
		model.addAttribute("mmname", mmname);
		model.addAttribute("list", historyRestockpop);
		
		return "inventory/workbookShippingHistory/historyRestockpop";
	}
	
	// 긴급교재신청 내역 조회 세부내역 팝업
	@RequestMapping(value={"/fa/inventory/historyRequestpop"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String historyRequestpop(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam(defaultValue="") String aidx, String inoutreqymd) {
		log.debug("Getting inventory workbookstatus");
		
		String jisaCD = loginInfo.getJisaCD();
		String deptCD = loginInfo.getDeptCD();		
		
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);	
		
		//전산 및 실제 발송 수량 리스트
		List<WorkbookShippingHistoryDto.HistoryRequestpop> historyRequestpop = workbookShippingHistoryService.getHistoryRequestpop(jisaCD, deptCD, aidx);
				
		
		model.addAttribute("list", historyRequestpop);
		
		return "inventory/workbookShippingHistory/historyRequestpop";
	}
	
	
	// 지사 교재 신청내역 및 본사에서 발송한 내역 조회 shippingHistory
	@RequestMapping(value={"/ja/inventory/shippingHistory"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String ShippingHistory(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam(defaultValue="") String yy) {
		log.debug("Getting inventory shippingHistory");

		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);	
		
		String jisaCD = loginInfo.getJisaCD();
		String deptCD = loginInfo.getDeptCD();		
		String statusCD = "1";
		
		// 조회 년도 리스트
		List<String> restockHistoryyy = workbookShippingHistoryService.getRestockHistoryyy(jisaCD, deptCD);
		
		if(("").equals(yy)){
			for(String yylist : restockHistoryyy){
				yy = yylist;
				break;
			}
		}
		
		//전산 및 실제 발송 수량 리스트
		List<WorkbookShippingHistoryDto.ShippingHistory> shippingHistory = workbookShippingHistoryService.getShippingHistory(jisaCD, "", statusCD, yy);
				
				
		model.addAttribute("yy", yy);
		model.addAttribute("yylist", restockHistoryyy);
		model.addAttribute("shlist", shippingHistory);
	
		
		return "inventory/workbookShippingHistory/jalist";
	}
	
	
	
	
}
