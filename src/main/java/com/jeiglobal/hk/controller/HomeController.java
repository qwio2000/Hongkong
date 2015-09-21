package com.jeiglobal.hk.controller;

import java.util.*;

import javax.servlet.http.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.web.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.utils.*;

/**
 * 
 * 클래스명 : HomeController.java
 *
 * 작성일 : 2015. 9. 7.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * HomeController
 */
@Slf4j
@Controller
public class HomeController {

	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private HomeService homeService;
	
	@Value("${serverurl.globalbms}")
	private String globalbmsUrl;

    
	@RequestMapping(value={"/fa","/fa/members","/fa/inventory","/fa/accounting","/fa/community","/fa/mypage"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getLayoutPage() {
		log.debug("Getting Layout Page");
		return "layout";
	}
	@RequestMapping(value={"/ja","/ja/members","/ja/inventory","/ja/accounting","/ja/community","/ja/leads","/ja/mypage"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getJALayoutPage() {
		log.debug("Getting JA Layout Page");
		return "layout";
	}
	
	/**
	 * 지사에서 Center Search에서 가맹점으로 로그인 한 사용자에 한하여 지사로 돌아가는 작업
	 * 1. 지사 인증 정보(JisaAUTHId, JisaAUTHKey)를 인증 정보(AUTHId, AUTHKey)에 값 변경 작업
	 * 2. 지사 인증 정보(JisaAUTHId, JisaAUTHKey) 쿠키 삭제
	 * 3. Security Context에 위치한 Authentication을 제거
	 * 4. Redirect 요청시 파라미터가 붙지 않도록 model clear
	 * @param jisaAuthId
	 * @param jisaAuthKey
	 * @param request
	 * @param response
	 * @param model
	 * @return 지사 계층으로 Redirect
	 */
	@RequestMapping(value="/returnjisa")
	public String returnJisaMode(@CookieValue(value="JisaAUTHId") String jisaAuthId,
			@CookieValue(value="JisaAUTHKey") String jisaAuthKey,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model){
		homeService.setCookieValue(jisaAuthId, jisaAuthKey, response);
		List<String> removeCookieName = new ArrayList<>();
		removeCookieName.add("JisaAUTHId");
		removeCookieName.add("JisaAUTHKey");
		homeService.removeCookieValue(removeCookieName, response);
		HttpSessionSecurityContextRepository hsscr = new HttpSessionSecurityContextRepository();
		HttpRequestResponseHolder hrrh = new HttpRequestResponseHolder(request, response);
		hsscr.loadContext(hrrh).setAuthentication(null);//기존 Authentication에 저장된 객체 제거
		model.asMap().clear();//ModelAttribute parameter 제거
		return "redirect:/ja/centers";
	}
	
	/**
	 * 본사에서 지사나 가맹점으로 로그인 한 사용자에 한하여 본사로 돌아가는 작업
	 * 1. 본사 인증 정보(BmsAUTHId, BmsAUTHKey)를 인증 정보(AUTHId, AUTHKey)에 값 변경 작업
	 * 2. 본사 인증 정보(BmsAUTHId, BmsAUTHKey) 쿠키 삭제
	 * 2-1. 가맹점에서 본사로 돌아갈 경우 지사 인증 정보(JisaAUTHId, JisaAUTHKey) 쿠키 삭제
	 * 3. Security Context에 위치한 Authentication을 제거
	 * 4. Redirect 요청시 파라미터가 붙지 않도록 model clear
	 * @param bmsAuthId
	 * @param bmsAuthKey
	 * @param request
	 * @param response
	 * @param model
	 * @return 본사 계층으로 Redirect
	 */
	@RequestMapping(value="/returnbms")
	public String returnBmsMode(@CookieValue(value="BmsAUTHId") String bmsAuthId,
			@CookieValue(value="BmsAUTHKey") String bmsAuthKey,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			@ModelAttribute(value="loginInfo") LoginInfo loginInfo){
		
		List<String> removeCookieName = new ArrayList<>();
		removeCookieName.add("BmsAUTHId");
		removeCookieName.add("BmsAUTHKey");
		if("FA".equalsIgnoreCase(loginInfo.getUserType())){
			removeCookieName.add("JisaAUTHId");
			removeCookieName.add("JisaAUTHKey");
		}
		homeService.setCookieValue(bmsAuthId, bmsAuthKey, response);
		homeService.removeCookieValue(removeCookieName, response);
		HttpSessionSecurityContextRepository hsscr = new HttpSessionSecurityContextRepository();
		HttpRequestResponseHolder hrrh = new HttpRequestResponseHolder(request, response);
		hsscr.loadContext(hrrh).setAuthentication(null);//기존 Authentication에 저장된 객체 제거
		model.asMap().clear();//ModelAttribute parameter 제거
		return "redirect:"+globalbmsUrl+"/ma/records";
	}
	/**
	 * favicon.ico 요청 시 No Mapping Log 방지하기 위해 만듬 
	 */
	@RequestMapping("favicon.ico")
    @ResponseBody
    void favicon() {}
}
