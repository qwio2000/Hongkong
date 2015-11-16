package com.jeiglobal.hk.controller.inventory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.inventory.WorkbookstatusService;
import com.jeiglobal.hk.utils.CommonUtils;
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
	
	// 지사 재고 메인 리스트
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
		
		//가맹점 리스트
		List<WorkbookstatusDto.WorkbookStatusMstList> workbookStatusMstList = workbookstatusService.getWorkbookStatusMstList(jisaCD, statusCD);

		
		model.addAttribute("mstlist", workbookStatusMstList);
		
		return "inventory/workbookstatus/jaList";
	}
	
	// 상품별 세부수량 조회
	@RequestMapping(value={"/ja/inventory/workbookstatusSubj"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String workbookstatusSubj(Model model, String jisaCD, String deptCD, String subj, @RequestParam(defaultValue="") String gubun) {
		log.debug("Getting inventory workbookstatusCalgary");
		
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);	
		
		// 가맹점 과목 리스트
		List<WorkbookstatusDto.WorkbookStatusMstsubj> workbookStatusMstsubj = workbookstatusService.getWorkbookStatusMstsubj(jisaCD, deptCD);
		
		//과목 등급 리스트
		List<String> workbookStatusDungList = workbookstatusService.getWorkbookStatusDungList(jisaCD, subj);
		
		//가맹점 세트별 수량 리스트
		List<WorkbookstatusDto.WorkbookStatusSetList> workbookStatusSetList = workbookstatusService.getWorkbookStatusSetList(jisaCD, deptCD, subj);
		
		/*log.debug("===============================================================");
		for (WorkbookstatusDto.WorkbookStatusSetList workbookStatusSetList2 : workbookStatusSetList) {
			log.debug("jisaCD : {}, deptCD : {}", workbookStatusSetList2.getJisaCD(), workbookStatusSetList2.getDeptCD());
			for (WorkbookstatusDto.WorkbookStatusSetDungList zz : workbookStatusSetList2.getDungList()) {
				log.debug("===============================================================");
				log.debug("dung : {}", zz.toString());
			}
		}*/
	
		String subjnm = "";
		for(WorkbookstatusDto.WorkbookStatusMstsubj subjlist : workbookStatusMstsubj){
			if((subj).equals(subjlist.getSubj())){
				subjnm = subjlist.getSubjnm();
			}			
		}
		
		/*1/28/2015 at 12:00AM*/
		Date today = new Date(); 
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy 'at' HH:mm a");
		
		
		model.addAttribute("jisaCD", jisaCD);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("subj", subj);
		model.addAttribute("gubun", gubun);
		model.addAttribute("subjnm", subjnm);
		model.addAttribute("date", format.format(today));
		model.addAttribute("subjlist", workbookStatusMstsubj);
				
		model.addAttribute("wbdung", workbookStatusDungList);
		model.addAttribute("setlist", workbookStatusSetList);

		if(("print").equals(gubun)){
			return "inventory/workbookstatus/printAjax";
		}else if(("ship").equals(gubun)){
			return "inventory/workbookstatus/shipInventory";
		}else if(("adjust").equals(gubun)){
			return "inventory/workbookstatus/adjustInventory";	
		}else if(("setrestockqty").equals(gubun)){
			return "inventory/workbookstatus/setrestockqty";		
		}else{
			return "inventory/workbookstatus/subj";
		}
		
	}
	
	
	// 상품별 print
	@RequestMapping(value={"/ja/inventory/workbookstatusPrint"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String workbookstatusPrint(Model model, String jisaCD, String deptCD, String subj, @RequestParam(defaultValue="") String gubun) {
		log.debug("Getting inventory workbookstatusPrint");
		
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("inventory");		
		model.addAttribute("headerScript", headerScript);	
		
		// 가맹점 과목 리스트
		List<WorkbookstatusDto.WorkbookStatusMstsubj> workbookStatusMstsubj = workbookstatusService.getWorkbookStatusMstsubj(jisaCD, deptCD);
		
		model.addAttribute("jisaCD", jisaCD);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("subj", subj);
		model.addAttribute("gubun", gubun);
		model.addAttribute("subjlist", workbookStatusMstsubj);
		
		return "inventory/workbookstatus/print";
	}
	
	//지사 적정재고 수정
	@RequestMapping(value={"/ja/inventory/workbookstatusSetrestockqtyJson"}, method={RequestMethod.GET,RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> workbookstatusSetrestockqtyJson(Model model, HttpServletRequest request, String jisaCD, String deptCD, String subj, String allset) {
		String workId = CommonUtils.getWorkId(request);
		

		workbookstatusService.addIventorySetrestockqtyUpt(jisaCD, deptCD, subj, allset, workId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("saveOK", messageSourceAccesor.getMessage("Inventory.workbookstatus.Setrestockqty.success"));		
		return map;
	}
	
	
	
}
