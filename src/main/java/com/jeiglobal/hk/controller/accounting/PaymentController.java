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
import com.jeiglobal.hk.service.accounting.PaymentService;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

import lombok.extern.slf4j.Slf4j;

/**
 * 클래스명 : PaymentController.java
 *
 * 작성일 : 2015. 11. 9.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@Slf4j
@Controller
public class PaymentController {

	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private CommonService commonService;	
	
	@Autowired
	private PaymentService paymentService;
	
	
	/**
	 * 가맹점별 로열티 입금 관리 : 지사
	 */	
	@RequestMapping(value={"/ja/accounting/recordPayment"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRecordPayment(Model model, @ModelAttribute LoginInfo loginInfo) throws ParseException{
		
		Calendar cal = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("YYYY").format(cal.getTime());
		String currentMonth = new SimpleDateFormat("MM").format(cal.getTime());
		
		List<Map<String, Object>> dataRecordPayment = paymentService.getRecordPayment(loginInfo.getJisaCD(), currentYear, currentMonth);
		log.debug("Getting recordPayment Page, dataRecordPayment : {}", dataRecordPayment);
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingPayment");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("recordPayment", dataRecordPayment);
		model.addAttribute("currentYear", currentYear);
		model.addAttribute("currentMonthName", CommonUtils.changeDateFormat("yyyy-MM", "MMMM", currentYear + "-" + currentMonth));		
		
		return "accounting/recordPayment";
	}	
	@RequestMapping(value={"/ja/accounting/recordPaymentPop"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRecordPaymentPop(Model model, @ModelAttribute LoginInfo loginInfo, 
			@RequestParam(defaultValue="") String deptCD, 
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
		
		List<Map<String, Object>> dataRecordPaymentCurrent = paymentService.getRecordPaymentList(loginInfo.getJisaCD(), deptCD, selYY, selMM, "current", loginInfo.getUserType());
		List<Map<String, Object>> dataRecordPaymentList = paymentService.getRecordPaymentList(loginInfo.getJisaCD(), deptCD, selYY, selMM, "", loginInfo.getUserType());
		log.debug("Getting recordPayment Page, dataRecordPaymentList : {}", dataRecordPaymentList);
		
		int balance = 0;
		int currAmount = 0;
		String deptName = "";
		if (dataRecordPaymentCurrent.size()>0) {
			balance = Integer.parseInt(dataRecordPaymentCurrent.get(0).get("balance").toString());
			currAmount = Integer.parseInt(dataRecordPaymentCurrent.get(0).get("currAmount").toString());
			deptName = dataRecordPaymentCurrent.get(0).get("deptName").toString();
		} 		
		int totAmount = 0;
		int totCnt = 0;
		if (dataRecordPaymentList.size()>0) {
			totAmount = Integer.parseInt(dataRecordPaymentList.get(0).get("totAmount").toString());
			totCnt = dataRecordPaymentList.size();
		} 
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingPayment");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("payCDList", commonService.getCodeDtls("0305", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("recordPaymentList", dataRecordPaymentList);
		model.addAttribute("totAmount", totAmount);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("selYY", selYY);
		model.addAttribute("selMM", selMM);
		model.addAttribute("balance", balance);
		model.addAttribute("currAmount", currAmount);
		model.addAttribute("deptName", deptName);
		model.addAttribute("currentMonth", currentMonth);
		model.addAttribute("currentMonthName", CommonUtils.changeDateFormat("yyyy-MM", "MMMM", currentYear + "-" + currentMonth));
		model.addAttribute("months", months);
		
		return "accounting/recordPaymentPop";
	}		
	@RequestMapping(value={"/ja/accounting/recordPaymentPopSaveJson","/ja/accounting/recordPayment/delete"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String getRecordPaymentPopSaveJson(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request, 
			@RequestParam(defaultValue="") String deptCD,
			@RequestParam(defaultValue="") String payYMD, @RequestParam(defaultValue="") String payCD, @RequestParam(defaultValue="") String refNo,
			@RequestParam(defaultValue="") String memo, @RequestParam(defaultValue="0") int amount,
			@RequestParam(defaultValue="0") int idx){
		
		Calendar cal = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("YYYY").format(cal.getTime());
		String currentMonth = new SimpleDateFormat("MM").format(cal.getTime());

		String workId = CommonUtils.getWorkId(request);
		String result = paymentService.getRecordPaymentPopSave(loginInfo.getJisaCD(),deptCD,payYMD, currentYear, currentMonth, payCD, refNo, memo, amount, workId, idx);
		log.debug("Getting recordPayment Page, result : {}", result);
		String msgCode = "";
		if("N1".equals(result)){
			msgCode = "payment.save.error.n1";
		}else if("N2".equals(result)){
			msgCode = "payment.save.error.n2";
		}else if("N3".equals(result)){
			msgCode = "payment.save.error.n3";			
		}else{
			if (idx>0){
				msgCode = "common.delete.success";
			}else{
				msgCode = "common.insert.success";
			}
		}
		return messageSource.getMessage(msgCode);
	}
	
	/**
	 * 로열티 미수금 입력내역 조회 화면 : 지사
	 */
	@RequestMapping(value={"/ja/accounting/paymentReport"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getPaymentReport(Model model, @ModelAttribute LoginInfo loginInfo, 
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
		headerScript.add("accountingPayment");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("selYY", selYY);
		model.addAttribute("selMM", selMM);
		model.addAttribute("months", months);			
		
		return "accounting/paymentReport";
	}
	@RequestMapping(value={"/ja/accounting/paymentReportJson"},method = {RequestMethod.GET}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getPaymentReportJson(@ModelAttribute LoginInfo loginInfo, 
		@RequestParam(defaultValue="") String selYY, @RequestParam(defaultValue="") String selMM) throws ParseException{

		List<Map<String, Object>> dataPaymentReportList = paymentService.getRecordPaymentList(loginInfo.getJisaCD(), "", selYY, selMM, "", loginInfo.getUserType());
		log.debug("Getting paymentReport Page, dataPaymentReportList : {}", dataPaymentReportList);
		
		int totAmount = 0;
		int totCnt = 0;
		if (dataPaymentReportList.size()>0) {
			totAmount = Integer.parseInt(dataPaymentReportList.get(0).get("totAmount").toString());
			totCnt = dataPaymentReportList.size();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paymentReportList", dataPaymentReportList);
		map.put("totAmount", totAmount);
		map.put("totCnt", totCnt);
		
		return map;
		
	}		
}
