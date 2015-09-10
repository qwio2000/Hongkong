package com.jeiglobal.hk.service.center;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.service.common.auth.*;
import com.jeiglobal.hk.utils.*;

/**
 * 클래스명 : CenterService.java
 *
 * 작성일 : 2015. 9. 10.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Service
public class CenterService {
	
	@Value("${cookieShare.domain}")
	private String cookieDomain;
	
	@Autowired
	private AuthoritiesService authoritiesService;
	
	/**
	 * @param authId
	 * @param authKey void
	 * @param response 
	 */
	public void addBackupCookies(String authId, String authKey, HttpServletResponse response) {
		CommonUtils.addCookie("JisaAUTHKey", authKey, cookieDomain, response);
		CommonUtils.addCookie("JisaAUTHId", authId, cookieDomain, response);
	}

	/**
	 * @param memberId
	 * @param response void
	 */
	public void addFACookies(String memberId, HttpServletResponse response) {
		StandardPasswordEncoder standrdPasswordEncoder = new StandardPasswordEncoder();
		String authKey = standrdPasswordEncoder.encode(memberId);
		authoritiesService.updateEncodeCookieById(memberId, authKey);
		CommonUtils.addCookie("AUTHKey", authKey, cookieDomain, response);
		CommonUtils.addCookie("AUTHId", memberId, cookieDomain, response);
	}

}
