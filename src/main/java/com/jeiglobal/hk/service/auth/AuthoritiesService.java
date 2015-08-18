package com.jeiglobal.hk.service.auth;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.repository.auth.*;

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
