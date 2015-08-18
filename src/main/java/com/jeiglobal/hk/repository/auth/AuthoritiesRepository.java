package com.jeiglobal.hk.repository.auth;

import java.util.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.repository.*;

/**
 * 
 * 클래스명 : AuthoritiesRepository.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * Mysql 사용 인증 관련 Repository
 * src/main/resource/mapper/auth/AuthoritiesRepository.xml
 */
@PrimaryRepositoryAnnoInterface
public interface AuthoritiesRepository {
	public LoginInfo findMemberById(String memberId);

	public List<Authority> findPermissionById(String memberId);

	public void updateEncodeCookieById(Map<String, Object> map);

	public long countMemberByIdAndEncodeCookie(Map<String, Object> map);
}
