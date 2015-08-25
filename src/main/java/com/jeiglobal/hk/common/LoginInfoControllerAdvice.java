package com.jeiglobal.hk.common;

import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;

@ControllerAdvice
public class LoginInfoControllerAdvice {
	
	@ModelAttribute("loginInfo")
	public LoginInfo getLoginInfo(Authentication authentication){
		return (authentication == null) ? null : (LoginInfo) authentication.getPrincipal();
	}
}
