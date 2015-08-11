package com.jeiglobal.hk.common;

import lombok.*;

import org.springframework.boot.context.properties.*;

//application.properties 에 저장된 DB 정보를 담을 객체
@Data
@ConfigurationProperties(value="mybatis")
public class ConnectSetting {
	private String driver;
	private String url;
	private String username;
	private String password;
}
