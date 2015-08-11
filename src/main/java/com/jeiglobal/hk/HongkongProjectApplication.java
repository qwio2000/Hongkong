package com.jeiglobal.hk;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;
import org.springframework.boot.context.properties.*;
import org.springframework.boot.context.web.*;

import com.jeiglobal.hk.common.*;

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
