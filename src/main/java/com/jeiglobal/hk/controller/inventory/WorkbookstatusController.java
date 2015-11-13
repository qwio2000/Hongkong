package com.jeiglobal.hk.controller.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.diagnosis.AdjustmentDto;
import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.inventory.WorkbookstatusService;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 클래스명 : WorkbookstatusController.java
 *
 * 작성일 : 2015. 11. 4.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * [ Inventory ->  Workbookstatus] Controller
 */

@Slf4j
@Controller
public class WorkbookstatusController {

	@Autowired
	private WorkbookstatusService  workbookstatusService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MessageSourceAccessor messageSourceAccesor;
	
	// 가맹점 재고관리화면
	@RequestMapping(value={"/ja/inventory/workbookstatus"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String workbookstatus(Model model, @ModelAttribute LoginInfo loginInfo) {
		log.debug("Getting inventory workbookstatus");
		
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);	
		
		String jisaCD = loginInfo.getJisaCD();
		String statusCD = "1";
		
		//가맹점 메인 리스트
		List<WorkbookstatusDto.WorkbookStatusMstList> workbookStatusMstList = workbookstatusService.getWorkbookStatusMstList(jisaCD, statusCD);

		
		model.addAttribute("mstlist", workbookStatusMstList);
		
		return "inventory/workbookstatus/jaList";
	}
	
	// 가맹점 재고관리화면
	@RequestMapping(value={"/ja/inventory/workbookstatusSubj"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String workbookstatusSubj(Model model, String jisaCD, String deptCD, String subj) {
		log.debug("Getting inventory workbookstatusCalgary");
		
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);	
				
		List<WorkbookstatusDto.WorkbookStatusMstsubj> workbookStatusMstsubj = workbookstatusService.getWorkbookStatusMstsubj(jisaCD, deptCD);
	
		model.addAttribute("subj", subj);
		model.addAttribute("subjlist", workbookStatusMstsubj);
		
		return "inventory/workbookstatus/subj";
	}
	
	
	
	
}
