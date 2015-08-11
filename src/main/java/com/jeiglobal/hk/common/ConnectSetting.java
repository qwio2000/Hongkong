package com.jeiglobal.hk.common;

import lombok.*;

import org.springframework.boot.context.properties.*;

/**
 * 클래스명 : ConnectSetting.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * application.properties에 등록된 DB 정보를 담는 객체
 */
@Data
@ConfigurationProperties(value="mybatis")
public class ConnectSetting {
	private String driver;
	private String url;
	private String username;
	private String password;
}
