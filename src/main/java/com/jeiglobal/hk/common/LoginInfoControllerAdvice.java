package com.jeiglobal.hk.common;

import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
/**
 * 
 * 클래스명 : LoginInfoControllerAdvice.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 컨트롤러 처리 전 ModelAttribute를 통해 로그인 사용자의 정보를 이용할 수 있도록 설정
 * 
 */
@ControllerAdvice
public class LoginInfoControllerAdvice {
	
	@ModelAttribute("loginInfo")
	public LoginInfo getLoginInfo(Authentication authentication){
		return (authentication == null) ? null : (LoginInfo) authentication.getPrincipal();
	}
	
	//TODO ExceptionHandler 선언하여 예외처리 추가
}
