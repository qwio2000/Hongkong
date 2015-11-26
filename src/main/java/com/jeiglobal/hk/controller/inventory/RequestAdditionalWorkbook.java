package com.jeiglobal.hk.controller.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.inventory.RequestAdditionalWorkbookDto;
import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto;
import com.jeiglobal.hk.service.inventory.RequestAdditionalWorkbookService;
import com.jeiglobal.hk.service.inventory.WorkbookstatusService;
import com.jeiglobal.hk.utils.CommonUtils;
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

/*	@Autowired
	private CommonService commonService;
*/
	@Autowired
	private MessageSourceAccessor messageSourceAccesor;
	
	
	// 가맹점 긴급교재 신청 화면 Request Additional Workbook
	@RequestMapping(value={"/fa/inventory/requestAdditionalWorkbook"}, method={RequestMethod.GET,RequestMethod.HEAD})
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
		
		//가맹점 상품 세트별 세부 수량 조회 리스트
		List<RequestAdditionalWorkbookDto.IvnWorkBookRequestAW> ivnWorkBookRequestAW = requestAdditionalWorkbookService.getIvnWorkBookRequestAW(jisaCD, deptCD, subj);
				
		model.addAttribute("jisaCD", jisaCD);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("subj", subj);
		
		model.addAttribute("subjlist", workbookStatusMstsubj);
		model.addAttribute("wbdung", workbookStatusDungList);
		model.addAttribute("setlist", ivnWorkBookRequestAW);
		
		return "inventory/requestAdditionalWorkbook/setsubj";
	}
	
	
	
	
	// 지사 [가맹점 긴급교재신청 승인]
	@RequestMapping(value={"/ja/inventory/requestAWShipToCerritos"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String requestAWShipToCerritos(Model model, String jisaCD, String deptCD, String additionalworkbook) {
		log.debug("Getting inventory requestAWShipToCerritos");

		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);	
		
		//가맹점 긴급교재 신청한 내역 날짜 리스트
		List<RequestAdditionalWorkbookDto.ShipToCerritosDate> shipToCerritosDate = requestAdditionalWorkbookService.getShipToCerritosDate(jisaCD, deptCD);
		
		//가맹점 긴급교재 요청 리스트
		List<RequestAdditionalWorkbookDto.ShipToCerritos> shipToCerritos = requestAdditionalWorkbookService.getShipToCerritos(jisaCD, deptCD, additionalworkbook);
				
		model.addAttribute("additionalworkbook", additionalworkbook);
		model.addAttribute("shiplist", shipToCerritos);
		model.addAttribute("inoutreqymd", shipToCerritosDate);

		
		return "inventory/requestAdditionalWorkbook/shiptocerritos";
	}
	
	// 지사 [가맹점 긴급교재신청 삭제]
	@RequestMapping(value={"/ja/inventory/requestAWShipToCerritosUpt"}, method={RequestMethod.POST,RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> requestAWShipToCerritosUpt(Model model, HttpServletRequest request, String jisaCD, String deptCD, String additionalworkbook, String data
			, String gubun, String signDate) {
		log.debug("Getting inventory requestAWShipToCerritosUpt");
		
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);
		
		String message = "";
		String workId = CommonUtils.getWorkId(request);
		
		//가맹점 긴급교재 신청한 승인 or 반려 
		String shipToCerritosUpt = requestAdditionalWorkbookService.addShipToCerritosUpt(jisaCD, deptCD, additionalworkbook, data, signDate, gubun, workId);
		
		if(("D").equals(gubun)){
			message = messageSourceAccesor.getMessage("Inventory.workbookstatus.requestAWShipToCerritos.delete");
		}else{
			message = messageSourceAccesor.getMessage("Inventory.workbookstatus.requestAWShipToCerritos.update");
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("saveOK", message);		
		return map;
		
	}
}
