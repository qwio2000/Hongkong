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
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.accounting.ExchangeService;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

import lombok.extern.slf4j.Slf4j;

/**
 * 클래스명 : ExchangeController.java
 *
 * 작성일 : 2015. 11. 9.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@Slf4j
@Controller
public class ExchangeController {

	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private CommonService commonService;	
	
	@Autowired
	private ExchangeService exchangeService;
	
	
	/**
	 * 환율 입력 조회 : 지사
	 */
	@RequestMapping(value={"/ja/accounting/exchangeRate"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRoyaltyOverview(Model model, @ModelAttribute LoginInfo loginInfo, 
			@RequestParam(defaultValue="") String selYY) throws ParseException{
		
		Calendar cal = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("YYYY").format(cal.getTime());
		String currentMonth = new SimpleDateFormat("MM").format(cal.getTime());
		if("".equals(selYY)){
			selYY=currentYear;
		}
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingExchange");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("selYY", selYY);
		model.addAttribute("currentYear", currentYear);
		model.addAttribute("currentMonthName", CommonUtils.changeDateFormat("yyyy-MM", "MMM", currentYear + "-" + currentMonth));
		
		return "accounting/exchangeRate";
	}	
	@RequestMapping(value={"/ja/accounting/exchangeRateJson"},method = {RequestMethod.GET}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getExchangeRateJson(@ModelAttribute LoginInfo loginInfo, 
		@RequestParam(defaultValue="") String selYY) throws ParseException{
		List<Map<String, Object>> dataExchangeRateList = exchangeService.getExchangeRateList(loginInfo.getJisaCD(), selYY);
		log.debug("Getting royaltyOverview Page, dataRoyaltyReportList : {}", dataExchangeRateList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("exchangeRateList", dataExchangeRateList);
		return map;
	}		
	@RequestMapping(value={"/ja/accounting/exchangeRateSaveJson"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String getUserSaveJson(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request, 
			@RequestParam(defaultValue="0") String cny, @RequestParam(defaultValue="0") String sgd){
		
		Calendar cal = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("YYYY").format(cal.getTime());
		String currentMonth = new SimpleDateFormat("MM").format(cal.getTime());

		String workId = CommonUtils.getWorkId(request);
		String result = exchangeService.getExchangeRateSave(loginInfo.getJisaCD(),currentYear, currentMonth, cny, sgd, workId);		
		String msgCode = "";
		if("Y".equals(result)){
			msgCode = "common.save.success";
		}else{
			msgCode = "common.save.error";
		}

		return messageSource.getMessage(msgCode);
	}
	
	
}
