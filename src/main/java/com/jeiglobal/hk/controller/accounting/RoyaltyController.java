/**
 * 
 */
package com.jeiglobal.hk.controller.accounting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeiglobal.hk.domain.accounting.RoyaltyOverviewList;
import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MonthInfo;
import com.jeiglobal.hk.service.accounting.ChargeService;
import com.jeiglobal.hk.service.accounting.RoyaltyService;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

import lombok.extern.slf4j.Slf4j;

/**
 * 클래스명 : AccountingController.java
 *
 * 작성일 : 2015. 11. 9.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명	: Accounting > Royalty 지사 + 가맹
 */
@Slf4j
@Controller
public class RoyaltyController {

	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private ChargeService chargeService;	
	
	@Autowired
	private RoyaltyService royaltyService;
	

	/**
	 * 월별 로열티 금액 조회 : 지사 Royalty Overview 
	 */
	@RequestMapping(value={"/ja/accounting/royaltyOverview"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRoyaltyOverview(Model model, @ModelAttribute LoginInfo loginInfo, 
			@RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM){
		Calendar cal = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("YYYY").format(cal.getTime());
		String currentMonth = new SimpleDateFormat("MM").format(cal.getTime());
		List<MonthInfo> months = CommonUtils.getMonths(1);	//월 목록(short Type:2)
		
		if("".equals(selYY)){
			selYY=currentYear;
		}
		if("".equals(selMM)){
			selMM=currentMonth;
		}
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingRoyalty");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("selYY", selYY);
		model.addAttribute("selMM", selMM);
		model.addAttribute("months", months);		
		return "accounting/royaltyOverview";
	}
	@RequestMapping(value={"/ja/accounting/royaltyOverviewJson"},method = {RequestMethod.GET}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getRoyaltyOverviewJson(@ModelAttribute LoginInfo loginInfo, 
		@RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM) throws ParseException{

		List<RoyaltyOverviewList> dataRoyaltyOverviewList = royaltyService.getRoyaltyOverviewList(loginInfo.getJisaCD(), "", selYY, selMM, loginInfo.getUserType());
		List<RoyaltyOverviewList> dataRoyaltyOverviewTot = royaltyService.getRoyaltyOverviewTot(loginInfo.getJisaCD(), "", selYY, selMM, loginInfo.getUserType());
		log.debug("Getting royaltyOverview Page, dataRoyaltyOverviewList : {}", dataRoyaltyOverviewList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("royaltyOverviewList", dataRoyaltyOverviewList);
		map.put("royaltyOverviewTot", dataRoyaltyOverviewTot);
		return map;
	}		
	/**
	 * 가맹점 년도별 로열티 세부내역 조회리스트 : 가맹점 Royalty Report
	 */	
	@RequestMapping(value={"/fa/accounting/royaltyReport"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRoyaltyReportOfCenter(Model model, @ModelAttribute LoginInfo loginInfo, 
			@RequestParam(defaultValue="") String selYY){
		Calendar cal = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("YYYY").format(cal.getTime());
		if("".equals(selYY)){
			selYY=currentYear;
		}
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingRoyalty");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("selYY", selYY);		
		return "accounting/royaltyReportOfCenter";
	}	
	@RequestMapping(value={"/fa/accounting/royaltyReportJson"},method = {RequestMethod.GET}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getRoyaltyReportOfCenterJson(@ModelAttribute LoginInfo loginInfo, 
		@RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM) throws ParseException{
		List<RoyaltyOverviewList> dataRoyaltyReportList = royaltyService.getRoyaltyOverviewList(loginInfo.getJisaCD(), loginInfo.getDeptCD(), selYY, selMM, loginInfo.getUserType());
		log.debug("Getting royaltyOverview Page, dataRoyaltyReportList : {}", dataRoyaltyReportList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("royaltyReportList", dataRoyaltyReportList);
		return map;
	}		
		
	/**
	 * 월별/가맹점별 로열티 세부내역 조회리스트 : 지사 Royalty Report
	 */
	@RequestMapping(value={"/ja/accounting/royaltyReport"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRoyaltyReport(Model model, @ModelAttribute LoginInfo loginInfo, 
			@RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM){
		Calendar cal = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("YYYY").format(cal.getTime());
		String currentMonth = new SimpleDateFormat("MM").format(cal.getTime());
		List<MonthInfo> months = CommonUtils.getMonths(1);	//월 목록(short Type)
		
		if("".equals(selYY)){
			selYY=currentYear;
		}
		if("".equals(selMM)){
			selMM=currentMonth;
		}
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingRoyalty");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("selYY", selYY);
		model.addAttribute("selMM", selMM);
		model.addAttribute("months", months);		
		return "accounting/royaltyReport";
	}
	@RequestMapping(value={"/ja/accounting/royaltyReportJson"},method = {RequestMethod.GET}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getRoyaltyReportJson(@ModelAttribute LoginInfo loginInfo, 
		@RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM) throws ParseException{

		List<RoyaltyOverviewList> dataRoyaltyReportList = royaltyService.getRoyaltyOverviewList(loginInfo.getJisaCD(), "", selYY, selMM, loginInfo.getUserType());
		List<RoyaltyOverviewList> dataRoyaltyReportTot = royaltyService.getRoyaltyOverviewTot(loginInfo.getJisaCD(), "", selYY, selMM, loginInfo.getUserType());
		log.debug("Getting royaltyOverview Page, dataRoyaltyReportList : {}", dataRoyaltyReportList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("royaltyReportList", dataRoyaltyReportList);
		map.put("royaltyReportTot", dataRoyaltyReportTot);
		return map;
	}	
	@RequestMapping(value={"/ja/accounting/chargeDetailOfRoyaltyReportJson","/fa/accounting/chargeDetailOfRoyaltyReportJson"},method = {RequestMethod.GET}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getChargeDetailOfRoyaltyReportJson(@ModelAttribute LoginInfo loginInfo, 
		@RequestParam(defaultValue="") String deptCD, @RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM,
		@RequestParam(defaultValue="") String chargeCD) throws ParseException{

		List<Map<String, Object>> dataRecordChargeList = chargeService.getRecordChargeList(loginInfo.getJisaCD(), deptCD, selYY, selMM, chargeCD);
		log.debug("Getting royaltyReport Page, dataRecordChargeList : {}", dataRecordChargeList);
		int totalCnt = (dataRecordChargeList.size()>0)? dataRecordChargeList.size() : 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("recordChargeList", dataRecordChargeList);
		map.put("totalCnt", totalCnt);
		return map;
	}	
	@RequestMapping(value={"/ja/accounting/royaltyReportPop"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRoyaltyReportPop(Model model, @ModelAttribute LoginInfo loginInfo, 
			@RequestParam(defaultValue="") String deptCD, @RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM){
		Calendar cal = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("YYYY").format(cal.getTime());
		if("".equals(selYY)){
			selYY=currentYear;
		}
		List<RoyaltyOverviewList> dataRoyaltyReportList = royaltyService.getRoyaltyOverviewList(loginInfo.getJisaCD(), deptCD, selYY, selMM, loginInfo.getUserType());
		String deptName = "";
		String stateName = "";
		if (dataRoyaltyReportList.size()>0) {
			deptName = dataRoyaltyReportList.get(0).getDeptName();
			stateName = dataRoyaltyReportList.get(0).getStateName();
		}
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingRoyalty");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("royaltyReportList", dataRoyaltyReportList);
		model.addAttribute("currentYear", currentYear);
		model.addAttribute("selYY", selYY);
		model.addAttribute("deptCD", deptCD);		
		model.addAttribute("deptName", deptName);
		model.addAttribute("stateName", stateName);
		
		return "accounting/royaltyReportPop";
	}
	/**
	 * 로열티 세부내역 팝업 : 지사 + 가맹 
	 */	
	@RequestMapping(value={"/ja/accounting/royaltyViewPop","/fa/accounting/royaltyViewPop"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRoyaltyViewPop(Model model, @ModelAttribute LoginInfo loginInfo, 
			@RequestParam(defaultValue="") String deptCD, @RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM){

		List<RoyaltyOverviewList> dataRoyaltyReportList = royaltyService.getRoyaltyOverviewList(loginInfo.getJisaCD(), deptCD, selYY, selMM, loginInfo.getUserType());
		String deptName = "";
		String stateName = "";
		String feeUnitName = "";
		if (dataRoyaltyReportList.size()>0) {
			deptName = dataRoyaltyReportList.get(0).getDeptName();
			stateName = dataRoyaltyReportList.get(0).getStateName();
			feeUnitName = dataRoyaltyReportList.get(0).getFeeUnitNM();
		}
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingRoyalty");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("royaltyReportList", dataRoyaltyReportList);
		model.addAttribute("selYY", selYY);
		model.addAttribute("deptCD", deptCD);		
		model.addAttribute("deptName", deptName);
		model.addAttribute("stateName", stateName);
		model.addAttribute("feeUnitName", feeUnitName);

		return "accounting/royaltyViewPop";
	}

	
}
