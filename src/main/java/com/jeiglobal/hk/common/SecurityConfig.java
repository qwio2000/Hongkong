package com.jeiglobal.hk.common;

import org.springframework.boot.autoconfigure.security.*;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;

/**
 * 클래스명 : SecurityConfig.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 시큐리티 설정 파일
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	  http.authorizeRequests()
		          .antMatchers("/**").permitAll()
		          .anyRequest().authenticated();
    }
}