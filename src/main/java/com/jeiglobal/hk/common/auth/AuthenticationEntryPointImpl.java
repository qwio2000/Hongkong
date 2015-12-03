package com.jeiglobal.hk.common.auth;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.*;
/**
 * 
 * 클래스명 : AuthenticationEntryPointImpl.java
 *
 * 작성일 : 2015. 9. 7.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 1. login 페이지 경로 설정
 * 2. login 페이지로 Redirect
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
	
	private String loginFormPath;
	
	@Value("${serverurl.globalbms}")
	private String globalbmsUrl;
	
	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		if(loginFormPath == null || loginFormPath.isEmpty()){
			setLoginFormPath("/login");
		}
//		String url = globalbmsUrl + loginFormPath;
//		String encodedUrl = response.encodeRedirectURL(UrlUtils.buildRequestUrl(request));
//		String testEncode = URLEncoder.encode(URLEncoder.encode(UrlUtils.buildRequestUrl(request), "UTF-8"), "UTF-8");
//		if(!"/".equals(encodedUrl)){
//			url += "?returl="+testEncode;
//		}
		response.sendRedirect(globalbmsUrl + loginFormPath);
	}

	public void setLoginFormPath(String loginFormPath) {
		this.loginFormPath = loginFormPath;
	}
	
}
