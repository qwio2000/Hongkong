package com.jeiglobal.hk.common;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
/**
 * 
 * 클래스명 : CommonControllerAdvice.java
 *
 * 작성일 : 2015. 9. 7.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 컨트롤러 처리 전 ModelAttribute를 통해 로그인 사용자의 정보를 이용할 수 있도록 설정
 */
@ControllerAdvice
public class CommonControllerAdvice {
	
	@Value("${serverurl.globalbms}")
	private String globalbmsUrl;
	
	@ModelAttribute("loginInfo")
	public LoginInfo getLoginInfo(Authentication authentication){
		return (authentication == null) ? null : (LoginInfo) authentication.getPrincipal();
	}
	
	@ModelAttribute("globalbmsUrl")
	public String getGlobalbmsUrl(){
		return globalbmsUrl;
	}
	
	@ModelAttribute("jisaAuthInfo")
	public String getJisaAuthInfo(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		String id = "";
		String key = "";
		for (Cookie cookie : cookies) {
			if("JisaAUTHId".equals(cookie.getName())){
				id = cookie.getValue();
			}else if("JisaAUTHKey".equals(cookie.getName())){
				key = cookie.getValue();
			}
		}
		return (id.isEmpty() || id == null || key.isEmpty() || key == null)  ? null : id;
	}
	
	@ModelAttribute("bmsAuthInfo")
	public String getBmsAuthInfo(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		String id = "";
		String key = "";
		for (Cookie cookie : cookies) {
			if("BmsAUTHId".equals(cookie.getName())){
				id = cookie.getValue();
			}else if("BmsAUTHKey".equals(cookie.getName())){
				key = cookie.getValue();
			}
		}
		return (id.isEmpty() || id == null || key.isEmpty() || key == null)  ? null : id;
	}

}
