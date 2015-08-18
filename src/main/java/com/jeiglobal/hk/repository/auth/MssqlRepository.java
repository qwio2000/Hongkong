package com.jeiglobal.hk.repository.auth;

import com.jeiglobal.hk.repository.*;

/**
 * 
 * 클래스명 : MssqlRepository.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * Mssql 전용 Repository src/main/resource/mapper/auth/MssqlRepository.xml
 */
@AnotherRepositoryAnnoInterface
public interface MssqlRepository {
	public String selectEncryptPassWord(String password);
}
