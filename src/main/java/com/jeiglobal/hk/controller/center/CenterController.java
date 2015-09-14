package com.jeiglobal.hk.controller.center;

import javax.servlet.http.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.web.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.service.center.*;
import com.jeiglobal.hk.utils.*;

/**
 * 
 * 클래스명 : CenterController.java
 *
 * 작성일 : 2015. 9. 10.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * [Centers] Controller
 */
@Slf4j
@Controller
@RequestMapping(value="/ja/centers")
public class CenterController {

	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private CenterService centerService;
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCentersPage(){
		log.debug("Getting Centers Page");
		return "center/centers";
	}
	
	/**
	 * 지사에서 가맹점으로 로그인 할 경우 로그인 처리
	 * 1. 현재 쿠키(AUTHId, AUTHKey)를 다른 쿠키(JisaAUTHId, JisaAUTHKey)에 백업
	 * 2. 로그인 하고자 하는 지사 정보를 AUTHId, AUTHKey로 쿠키 값 변경
	 * 3. Security Context에 위치한 Authentication을 제거
	 * 4. Redirect 요청시 파라미터가 붙지 않도록 model clear
	 * @param memberId 로그인 하고자 하는 가맹점 아이디
	 * @param AuthId 현재 인증 정보를 담고 있는 쿠키의 AUTHId 값
	 * @param AuthKey 현재 인증 정보를 담고 있는 쿠키의 AUTHKey 값
	 * @param request
	 * @param response
	 * @param model
	 * @return 가맹점 계층으로 Redirect
	 */
	@RequestMapping(value="/login",method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getFALogin(String memberId, 
			@CookieValue(value="AUTHId") String AuthId, 
			@CookieValue(value="AUTHKey") String AuthKey,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model){
		centerService.addBackupCookies(AuthId, AuthKey, response);
		centerService.addFACookies(memberId, response);
		HttpSessionSecurityContextRepository hsscr = new HttpSessionSecurityContextRepository();
		HttpRequestResponseHolder hrrh = new HttpRequestResponseHolder(request, response);
		hsscr.loadContext(hrrh).setAuthentication(null);//기존 Authentication에 저장된 객체 제거
		model.asMap().clear();//ModelAttribute parameter 제거
		return "redirect:/fa/members";
	}
}
