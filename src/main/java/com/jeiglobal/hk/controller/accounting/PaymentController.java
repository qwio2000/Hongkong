/**
 * 
 */
package com.jeiglobal.hk.controller.accounting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.accounting.RoyaltyService;
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
	private RoyaltyService royaltyService;
	
	
	/**
	 * 가맹점별 로열티 입금내역 입력 화면 : 지사
	 */
	@RequestMapping(value={"/ja/accounting/recordPayment"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRoyaltyOverview(Model model, @ModelAttribute LoginInfo loginInfo, String yy, String mm){
		
		//List<UserList> dataUserList = centerService.getUserList(loginInfo.getJisaCD(), yy, mm);
		//log.debug("Getting centerView Page, royaltyOverview : {}", dataUserList);
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingPayment");
		model.addAttribute("headerScript", headerScript);
		//model.addAttribute("userList", dataUserList);
		return "accounting/recordPayment";
	}	
	/**
	 * 가맹점별 로열티 입금 입력 내역 현황 조회 : 지사
	 */
	@RequestMapping(value={"/ja/accounting/paymentReport"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getRoyaltyReport(Model model, @ModelAttribute LoginInfo loginInfo, String yy, String mm){
		
		//List<UserList> dataUserList = centerService.getUserList(loginInfo.getJisaCD(), yy, mm);
		//log.debug("Getting centerView Page, royaltyOverview : {}", dataUserList);
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("accountingPayment");
		model.addAttribute("headerScript", headerScript);
		//model.addAttribute("userList", dataUserList);
		return "accounting/paymentReport";
	}	
}
