package com.jeiglobal.hk.common;

import javax.sql.*;

import org.apache.commons.dbcp2.*;
import org.apache.ibatis.session.*;
import org.mybatis.spring.*;
import org.mybatis.spring.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.embedded.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.*;
import org.springframework.jdbc.datasource.*;
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
@MapperScan(basePackages = "com.jeiglobal.hk.repository")
public class BeanConfiguration {

	@Autowired
	private ConnectSetting connectConfiguration;

	// application.properties 파일에 등록된 DB 정보를 이용하여 Datasource Bean 생성
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(connectConfiguration.getDriver());
		dataSource.setUrl(connectConfiguration.getUrl());
		dataSource.setUsername(connectConfiguration.getUsername());
		dataSource.setPassword(connectConfiguration.getPassword());
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory
				.setMapperLocations(new PathMatchingResourcePatternResolver()
						.getResources("classpath:mapper/**/*.xml"));
		return sessionFactory.getObject();
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

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
}
