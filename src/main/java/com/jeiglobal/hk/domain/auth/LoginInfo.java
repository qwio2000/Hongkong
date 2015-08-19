package com.jeiglobal.hk.domain.auth;

import lombok.*;
/**
 * 
 * 클래스명 : LoginInfo.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 로그인 사용자 정보
 */
@Data
@AllArgsConstructor
public class LoginInfo {
	private String memberId;
	private String memberPassword;
	private String memberEnabled;
	private String jisaCD;
	private String depid1;
	private String depid2;
	private String empKey;
	private String empName;
	private String empKeyLvCD;
	private String depMngCD;
	private String encodeCookie;
}
