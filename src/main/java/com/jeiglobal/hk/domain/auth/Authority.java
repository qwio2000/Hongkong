package com.jeiglobal.hk.domain.auth;

import lombok.*;
/**
 * 
 * 클래스명 : Authority.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 로그인 사용자 권한 정보
 */
@Data
public class Authority {
	private String memberId;
	private String authority;
}
