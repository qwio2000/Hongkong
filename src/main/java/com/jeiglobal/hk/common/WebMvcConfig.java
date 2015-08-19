package com.jeiglobal.hk.common;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 
 * 클래스명 : WebMvcConfig.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * MVC 관련 설정(인터셉터 등록)
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private BeanConfiguration beanConfiguration;
	
	//Interceptor 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(beanConfiguration.menuIntercepter()).addPathPatterns("/**").excludePathPatterns("","/","/login","/public/**","/error","/favicon.ico");
	}
	
}
