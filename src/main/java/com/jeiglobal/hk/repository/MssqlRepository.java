package com.jeiglobal.hk.repository;

/**
 * 
 * 클래스명 : MssqlRepository.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * Mssql 전용 Repository
 * src/main/resource/mapper/MssqlRepository.xml
 */
@AnotherRepositoryAnnoInterface
public interface MssqlRepository {
	public int selectTest();
	
	public String getPwdHash(String empKey);
}
