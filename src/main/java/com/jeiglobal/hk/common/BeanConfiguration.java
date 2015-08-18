package com.jeiglobal.hk.common;

import org.springframework.boot.context.embedded.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.web.filter.*;

import com.jeiglobal.hk.util.*;

/**
 * 클래스명 : BeanConfiguration.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * Bean 설정 관련 파일
 */
@Configuration
public class BeanConfiguration {

	/**
	 * Message를 이용하기 위한 Bean 설정
	 * 
	 * @param messageSource
	 * @return
	 */
	@Bean
	public MessageSourceAccessor messageSourceAccesor(
			MessageSource messageSource) {
		return new MessageSourceAccessor(messageSource);
	}
	
	/**
	 * 필터 등록 Bean 설정
	 * 현재 : CharacterEncodingFilter 등록
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		registrationBean.setFilter(characterEncodingFilter);
		return registrationBean;
	}
	
	@Bean
	public MenuIntercepter menuIntercepter(){
		return new MenuIntercepter();
	}
}
