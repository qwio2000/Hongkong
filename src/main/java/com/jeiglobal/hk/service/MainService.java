package com.jeiglobal.hk.service;

import java.util.*;

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
 * 홈 서비스
 */
@Service
public class MainService {
	
	@Value("${cookieShare.domain}")
	private String cookieDomain;
	
	/** 로그인 하고자 하는 값으로 쿠키 값 변경 작업
	 * @param jisaAuthId
	 * @param jisaAuthKey
	 * @param response void
	 */
	public void setCookieValue(String jisaAuthId, String jisaAuthKey,
			HttpServletResponse response) {
		CommonUtils.addCookie("AUTHKey", jisaAuthKey, cookieDomain, response);
		CommonUtils.addCookie("AUTHId", jisaAuthId, cookieDomain, response);
	}
	
	/** 쿠키 삭제
	 * @param removeCookieName 
	 * @param response void
	 */
	public void removeCookieValue(List<String> removeCookieName, HttpServletResponse response) {
		for (String cookieName : removeCookieName) {
			CommonUtils.removeCookie(cookieName, cookieDomain, response);
		}
	}
	
}
