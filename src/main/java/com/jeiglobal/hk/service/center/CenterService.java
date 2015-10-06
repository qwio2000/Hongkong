package com.jeiglobal.hk.service.center;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.center.CenterSearchList;
import com.jeiglobal.hk.repository.center.CenterRepository;
import com.jeiglobal.hk.service.auth.AuthoritiesService;
import com.jeiglobal.hk.utils.CommonUtils;

/**
 * 클래스명 : CenterService.java
 *
 * 작성일 : 2015. 9. 10.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * Centers 서비스
 */
@Service
public class CenterService {
	
	@Value("${cookieShare.domain}")
	private String cookieDomain;
	
	@Autowired
	private AuthoritiesService authoritiesService;
	
	@Autowired
	private CenterRepository centerRepository;
	
	Map<String, Object> param = new HashMap<String, Object>();
	
	// 센터 검색
	public List<CenterSearchList> getCenterSearchList(String jisaCD,String deptName,String city,String stateCD,String statusCD,String sortKind,String sort, int pageNum, int pageSize) {		
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptName", deptName);		
		param.put("city", city);
		param.put("stateCD", stateCD);
		param.put("statusCD", statusCD);		
		param.put("sortKind", sortKind);
		param.put("sort", sort);
		param.put("pageNum", pageNum);
		param.put("pageSize", pageSize);		
		
		return centerRepository.findSearchResults(param);				
	}
	
	
	
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
