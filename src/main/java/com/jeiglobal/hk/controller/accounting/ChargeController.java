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
import com.jeiglobal.hk.domain.member.MemberDto.MonthInfo;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.accounting.ChargeService;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

import lombok.extern.slf4j.Slf4j;

/**
 * 클래스명 : ChargeController.java
 *
 * 작성일 : 2015. 11. 9.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@Slf4j
@Controller
public class ChargeController {

	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private CommonService commonService;	
	
	@Autowired
	private ChargeService chargeService;
	
	
	/**
	 * 기타입금 입력화면 : 지사
	 */
	@RequestMapping(value={"/ja/accounting/recordCharges"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRecordCharges(Model model, @ModelAttribute LoginInfo loginInfo) throws ParseException{
		
		Calendar cal = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("YYYY").format(cal.getTime());
		String currentMonth = new SimpleDateFormat("MM").format(cal.getTime());
		
		List<Map<String, Object>> dataRecordCharge = chargeService.getRecordCharge(loginInfo.getJisaCD(), currentYear, currentMonth);
		log.debug("Getting recordCharges Page, dataRecordCharge : {}", dataRecordCharge);
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingCharges");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("recordCharge", dataRecordCharge);
		model.addAttribute("currentYear", currentYear);
		model.addAttribute("currentMonthName", CommonUtils.changeDateFormat("yyyy-MM", "MMMM", currentYear + "-" + currentMonth));		
		
		return "accounting/recordCharges";
	}	
	@RequestMapping(value={"/ja/accounting/recordChargesPop"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRecordChargesPop(Model model, @ModelAttribute LoginInfo loginInfo, 
			@RequestParam(defaultValue="") String deptCD, 
			@RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM,
			@RequestParam(defaultValue="") String deptName) throws ParseException{
		
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
		
		List<Map<String, Object>> dataRecordChargeList = chargeService.getRecordChargeList(loginInfo.getJisaCD(), deptCD, selYY, selMM, "", loginInfo.getUserType());
		log.debug("Getting recordCharges Page, dataRecordChargeList : {}", dataRecordChargeList);
		
		int totAmount = 0;
		int totCnt = 0;
		if (dataRecordChargeList.size()>0) {
			totAmount = Integer.parseInt(dataRecordChargeList.get(0).get("totAmount").toString());
			totCnt = dataRecordChargeList.size();
		}
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingCharges");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("chargeCDList", commonService.getCodeDtls("0306", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("recordChargeList", dataRecordChargeList);
		model.addAttribute("totAmount", totAmount);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("selYY", selYY);
		model.addAttribute("selMM", selMM);
		model.addAttribute("deptName", deptName);
		model.addAttribute("currentYear", currentYear);
		model.addAttribute("currentMonth", currentMonth);
		model.addAttribute("currentMonthName", CommonUtils.changeDateFormat("yyyy-MM", "MMMM", currentYear + "-" + currentMonth));
		model.addAttribute("months", months);
		
		return "accounting/recordChargesPop";
	}		
	@RequestMapping(value={"/ja/accounting/recordChargesPopSaveJson","/ja/accounting/recordCharges/delete"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String getRecordChargesPopSaveJson(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request, 
			@RequestParam(defaultValue="") String deptCD,
			@RequestParam(defaultValue="") String chargeYMD, @RequestParam(defaultValue="") String chargeCD,
			@RequestParam(defaultValue="") String memo, @RequestParam(defaultValue="0") int amount,
			@RequestParam(defaultValue="0") int idx){
		
		Calendar cal = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("YYYY").format(cal.getTime());
		String currentMonth = new SimpleDateFormat("MM").format(cal.getTime());

		String workId = CommonUtils.getWorkId(request);
		String result = chargeService.getRecordChargesPopSave(loginInfo.getJisaCD(),deptCD,chargeYMD, currentYear, currentMonth, chargeCD, memo, amount, workId, idx);
		log.debug("Getting recordCharges Page, result : {}", result);
		String msgCode = "";
		if("Y".equals(result)){
			if (idx>0){
				msgCode = "common.delete.success";
			}else{
				msgCode = "common.insert.success";
			}			
		}else{
			msgCode = "common.save.error";
		}

		return messageSource.getMessage(msgCode);
	}
	
	/**
	 * 기타입금 입력내역 조회 화면 : 지사
	 */
	@RequestMapping(value={"/ja/accounting/chargeReport"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getChargeReport(Model model, @ModelAttribute LoginInfo loginInfo, 
			@RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM) throws ParseException{
		
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
		headerScript.add("accountingCharges");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("selYY", selYY);
		model.addAttribute("selMM", selMM);
		model.addAttribute("months", months);			
		
		return "accounting/chargeReport";
	}
	@RequestMapping(value={"/ja/accounting/chargeReportJson"},method = {RequestMethod.GET}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getChargeReportJson(@ModelAttribute LoginInfo loginInfo, 
		@RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM) throws ParseException{

		List<Map<String, Object>> dataChargeReportList = chargeService.getRecordChargeList(loginInfo.getJisaCD(), "", selYY, selMM, "", loginInfo.getUserType());
		log.debug("Getting chargeReport Page, dataRecordChargeList : {}", dataChargeReportList);
		
		int totAmount = 0;
		int totCnt = 0;
		if (dataChargeReportList.size()>0) {
			totAmount = Integer.parseInt(dataChargeReportList.get(0).get("totAmount").toString());
			totCnt = dataChargeReportList.size();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("chargeReportList", dataChargeReportList);
		map.put("totAmount", totAmount);
		map.put("totCnt", totCnt);
		return map;
	}		
	
}
