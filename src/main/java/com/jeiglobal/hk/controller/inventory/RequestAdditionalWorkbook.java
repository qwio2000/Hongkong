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
import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.inventory.RequestAdditionalWorkbookService;
import com.jeiglobal.hk.service.inventory.WorkbookstatusService;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

import lombok.extern.slf4j.Slf4j;

/**
 * 클래스명 : RequestAdditionalWorkbook.java
 *
 * 작성일 : 2015. 11. 20.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */

@Slf4j
@Controller
public class RequestAdditionalWorkbook {
	@Autowired
	private RequestAdditionalWorkbookService requestAdditionalWorkbookService;
	
	@Autowired
	private WorkbookstatusService workbookstatusService;

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MessageSourceAccessor messageSourceAccesor;
	
	
	// 가맹점 긴급교재 신청 화면 Request Additional Workbook
	@RequestMapping(value={"/ja/inventory/requestAdditionalWorkbook"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String workbookstatus(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam(defaultValue="") String subj) {
		log.debug("Getting inventory workbookstatus");

		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);	
		
		String jisaCD = loginInfo.getJisaCD();
		String deptCD = loginInfo.getDeptCD();				
		String subjdeptCD = deptCD;
	
		// 가맹점 과목 리스트
		List<WorkbookstatusDto.WorkbookStatusMstsubj> workbookStatusMstsubj = workbookstatusService.getWorkbookStatusMstsubj(jisaCD, subjdeptCD);
		
		if(("").equals(subj)){
			for(WorkbookstatusDto.WorkbookStatusMstsubj subjlist : workbookStatusMstsubj){
					subj = subjlist.getSubj();
					break;
			}
		}

		//과목 등급 리스트
		List<String> workbookStatusDungList = workbookstatusService.getWorkbookStatusDungList(jisaCD, subj);
		
		//가맹점 세트별 수량 리스트
		List<WorkbookstatusDto.WorkbookStatusSetList> workbookStatusSetList = workbookstatusService.getWorkbookStatusSetList(jisaCD, deptCD, subj);
		
		model.addAttribute("jisaCD", jisaCD);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("subj", subj);
		
		model.addAttribute("subjlist", workbookStatusMstsubj);
		model.addAttribute("wbdung", workbookStatusDungList);
		model.addAttribute("setlist", workbookStatusSetList);
		
		return "inventory/requestAdditionalWorkbook/setsubj";
	}
}
