package com.jeiglobal.hk.common;

import java.text.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.utils.*;
/**
 * 
 * 클래스명 : CommonControllerAdvice.java
 *
 * 작성일 : 2015. 9. 7.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 컨트롤러 처리 전 ModelAttribute를 통해 정보를 이용할 수 있도록 설정
 */
@ControllerAdvice
public class CommonControllerAdvice {
	
	@ModelAttribute("loginInfo")
	public LoginInfo getLoginInfo(Authentication authentication){
		return (authentication == null) ? null : (LoginInfo) authentication.getPrincipal();
	}
	
	@ModelAttribute("mainWeek")
	public List<String> getMainWeek() throws ParseException{
		return CommonUtils.weekCalendar("");
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
	
	@Value("${filePath.img}")
	private String imgPath;
	
	@Value("${filePath.css}")
	private String cssPath;
	
	@Value("${filePath.js}")
	private String jsPath;
	
	@ModelAttribute("imgPath")
	public String getImgPath(){return imgPath;}
	@ModelAttribute("cssPath")
	public String getCssPath(){return cssPath;}
	@ModelAttribute("jsPath")
	public String getJsPath(){return jsPath;}

}
