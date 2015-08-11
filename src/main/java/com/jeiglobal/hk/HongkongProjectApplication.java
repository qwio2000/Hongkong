package com.jeiglobal.hk;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;
import org.springframework.boot.context.properties.*;
import org.springframework.boot.context.web.*;

import com.jeiglobal.hk.common.*;

/**
 * 클래스명 : HongkongProjectApplication.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 스프링 부트를 실행하는 클래스
 */
@SpringBootApplication
@EnableConfigurationProperties({ ConnectSetting.class })
public class HongkongProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HongkongProjectApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(HongkongProjectApplication.class);
	}
}
