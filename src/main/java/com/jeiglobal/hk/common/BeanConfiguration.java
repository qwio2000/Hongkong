package com.jeiglobal.hk.common;

import org.springframework.boot.context.embedded.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.web.filter.*;
import org.springframework.web.servlet.config.annotation.*;

import com.jeiglobal.hk.utils.*;

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
public class BeanConfiguration extends WebMvcConfigurerAdapter {

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
	 * 메뉴 인터셉터 Bean 설정
	 * @return
	 */
	@Bean
	public MenuIntercepter menuIntercepter(){
		return new MenuIntercepter();
	}
	/**
	 * PUT method Filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean httpPutFormContentFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new HiddenHttpMethodFilter());
		filterRegistrationBean.setOrder(10);
		return filterRegistrationBean;
	}
}
