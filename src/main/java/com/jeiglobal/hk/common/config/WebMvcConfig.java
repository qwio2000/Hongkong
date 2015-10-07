package com.jeiglobal.hk.common.config;

import com.jeiglobal.hk.common.FileDownload;
import com.jeiglobal.hk.common.MenuIntercepter;
import com.jeiglobal.hk.utils.MessageSourceAccessor;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;

/**
 * 
 * 클래스명 : WebMvcConfig.java
 *
 * 작성일 : 2015. 9. 7.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * Web MVC 설정
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * Message를 이용하기 위한 Bean 설정
	 * 
	 * @param messageSource
	 * @return MessageSourceAccessor
	 */
	@Bean
	public MessageSourceAccessor messageSourceAccesor(
			MessageSource messageSource) {
		return new MessageSourceAccessor(messageSource);
	}
	
	/**
	 * 메뉴 인터셉터 Bean 설정
	 * @return MenuIntercepter
	 */
	@Bean
	public MenuIntercepter menuIntercepter(){
		return new MenuIntercepter();
	}
	/**
	 * PUT method Filter
	 * @return FilterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean httpPutFormContentFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new HiddenHttpMethodFilter());
		filterRegistrationBean.setOrder(10);
		return filterRegistrationBean;
	}
	/**
	 * XSS 대응 필터
	 * @return FilterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean xssEscapeServletFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new XssEscapeServletFilter());
		filterRegistrationBean.setOrder(1);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
	
	/**
	 * 정적자원 설정 브라우져에서 캐쉬기간 1년 362~3 page
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/public/js/**")
		.addResourceLocations("/public/js/")
		.setCachePeriod(31556926);
		registry.addResourceHandler("/public/css/**")
		.addResourceLocations("/public/css/")
		.setCachePeriod(31556926);
		registry.addResourceHandler("/public/img/**")
		.addResourceLocations("/public/img/")
		.setCachePeriod(31556926);
		registry.addResourceHandler("/public/promotion/**")
		.addResourceLocations("/public/promotion/");
	}
	
	//Interceptor 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(menuIntercepter()).addPathPatterns("/**").excludePathPatterns("","/","/login","/public/**","/error","/favicon.ico","/returnjisa","/returnbms");
	}
	
	/**
	 * 파일다운로드 뷰 설정
	 * @return FileDownload
	 */
	@Bean(name="download")
	public FileDownload download() {
		return new FileDownload();
	}
	/**
	 * Default Locale 설정
	 * @return LocaleResolver
	 */
	@Bean
	public LocaleResolver localeResolver(){
		CookieLocaleResolver resolver = new CookieLocaleResolver();
//		resolver.setDefaultLocale(new Locale(Locale.KOREA.getLanguage(), Locale.KOREA.getCountry()));
		resolver.setDefaultLocale(new Locale(Locale.US.getLanguage(), Locale.US.getCountry()));
//		resolver.setDefaultLocale(new Locale(Locale.CHINA.getLanguage(), Locale.CHINA.getLanguage()));
		return resolver;
	}
	
}
