package com.jeiglobal.hk.common;

import javax.sql.*;

import org.apache.commons.dbcp2.*;
import org.apache.ibatis.session.*;
import org.mybatis.spring.*;
import org.mybatis.spring.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.*;
import org.springframework.jdbc.datasource.*;

/**
 * 클래스명 : BeanConfiguration.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * ConnectSetting에 저장된 정보를 이용하여 DB 연결 설정
 */
@Configuration
@MapperScan(basePackages="com.jeiglobal.hk.repository")
public class BeanConfiguration {
	
	@Autowired
	private ConnectSetting connectConfiguration;
	
	//application.properties 파일에 등록된 DB 정보를 이용하여 Datasource Bean 생성
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
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml"));
		return sessionFactory.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
