package com.jeiglobal.hk.service.auth;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.repository.auth.*;
/**
 * 
 * 클래스명 : AuthoritiesService.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 로그인에 관련된 비즈니스 로직을 처리하는 서비스
 */
@Service
public class AuthoritiesService {
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	@Autowired
	private MssqlRepository mssqlRepository;
	
	public LoginInfo findMemberById(String memberId){
		return authoritiesRepository.findMemberById(memberId);
	}
	
	public List<Authority> findPermissionById(String memberId){
		return authoritiesRepository.findPermissionById(memberId);
	}
	
	public String selectEncryptPassWord(String password){
		return mssqlRepository.selectEncryptPassWord(password);
	}
	
	public void updateEncodeCookieById(String memberId,String encodeCookie){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("encodeCookie", encodeCookie);
		
		authoritiesRepository.updateEncodeCookieById(map);
	}
	
	public long countMemberByIdAndEncodeCookie(String memberId,String encodeCookie){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("encodeCookie", encodeCookie);
		
		return authoritiesRepository.countMemberByIdAndEncodeCookie(map);
	}
	
}
