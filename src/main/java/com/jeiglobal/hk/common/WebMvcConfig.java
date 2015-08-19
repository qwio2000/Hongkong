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
 * Web MVC 설정
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private BeanConfiguration beanConfiguration;
	
	/**
	 * 정적자원 설정 브라우져에서 캐쉬기간 1년 362~3 page
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/public/js/**")
		.addResourceLocations("/public/js/")
		.setCachePeriod(31556926);
		registry.addResourceHandler("/public/css/**")
		.addResourceLocations("/public/css/")
		.setCachePeriod(31556926);
		registry.addResourceHandler("/public/img/**")
		.addResourceLocations("/public/img/")
		.setCachePeriod(31556926);
	}
	
	//Interceptor 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(beanConfiguration.menuIntercepter()).addPathPatterns("/**").excludePathPatterns("","/","/login","/public/**","/error","/favicon.ico");
	}
	
}
