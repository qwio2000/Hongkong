package com.jeiglobal.hk.controller.common;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.utils.*;

/**
 * 클래스명 : HomeService.java
 *
 * 작성일 : 2015. 9. 10.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Service
public class HomeService {
	
	@Value("${cookieShare.domain}")
	private String cookieDomain;
	/**
	 * @param jisaAuthId
	 * @param jisaAuthKey
	 * @param response void
	 */
	public void setCookieValue(String jisaAuthId, String jisaAuthKey,
			HttpServletResponse response) {
		CommonUtils.addCookie("AUTHKey", jisaAuthKey, cookieDomain, response);
		CommonUtils.addCookie("AUTHId", jisaAuthId, cookieDomain, response);
	}
	/**
	 * @param response void
	 */
	public void removeCookieValue(HttpServletResponse response) {
		CommonUtils.removeCookie("JisaAUTHId", cookieDomain, response);
		CommonUtils.removeCookie("JisaAUTHKey", cookieDomain, response);
	}
	
}
