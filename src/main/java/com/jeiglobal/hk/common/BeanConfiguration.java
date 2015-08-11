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
