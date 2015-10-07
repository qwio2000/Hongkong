package com.jeiglobal.hk.controller.center;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.center.CenterSearchList;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.center.CenterService;
import com.jeiglobal.hk.utils.MessageSourceAccessor;
import com.jeiglobal.hk.utils.PageUtil;

/**
 * 
 * 클래스명 : CenterController.java
 *
 * 작성일 : 2015. 9. 10.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * [Centers] Controller
 */
@Slf4j
@Controller

public class CenterController {

	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private CenterService centerService;
	
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.size}")
	private int pageSize;
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.blockSize}")
	private int blockSize;
	
	// 센터검색
	@RequestMapping(value={"/ja/centers/search"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterSearch(Model model, @ModelAttribute LoginInfo loginInfo){
		String userType = loginInfo.getUserType();
		log.debug("Getting centerSearch Page, UserType : {}", userType);
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerSearch");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("statusCDList", commonService.getCodeDtls("0307", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));
		return "center/centerSearch";
	}
	
	// 센터 검색 결과 리스트
	@RequestMapping(value={"/ja/centers/searchResults"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterSearchResult(Model model, @ModelAttribute LoginInfo loginInfo,
		@RequestParam(defaultValue="1") int pageNum,String deptName, String city, String stateCD, String statusCD, String sortKind, String sort){
		
		List<CenterSearchList> centerSearchResultList = centerService.getCenterSearchList(loginInfo.getJisaCD(), deptName, city, stateCD, statusCD, sortKind, sort, pageNum, pageSize);
		
		int totalCnt = (centerSearchResultList.size()>0)? centerSearchResultList.get(0).getRCnt() : 0;
		PageUtil pageUtil = new PageUtil(pageNum, totalCnt, pageSize, blockSize);		
		
		model.addAttribute("centerSearchList", centerSearchResultList);
		model.addAttribute("pageInfo", pageUtil);
		return "center/centerSearchResult";
	}	
	
	
	
	
	
	
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(value="/ja/centers",method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCentersPage(){
		log.debug("Getting Centers Page");
		return "center/centers";
	}
	/**
	 * 지사에서 가맹점으로 로그인 할 경우 로그인 처리
	 * 1. 현재 쿠키(AUTHId, AUTHKey)를 다른 쿠키(JisaAUTHId, JisaAUTHKey)에 백업
	 * 2. 로그인 하고자 하는 지사 정보를 AUTHId, AUTHKey로 쿠키 값 변경
	 * 3. Security Context에 위치한 Authentication을 제거
	 * 4. Redirect 요청시 파라미터가 붙지 않도록 model clear
	 * @param memberId 로그인 하고자 하는 가맹점 아이디
	 * @param AuthId 현재 인증 정보를 담고 있는 쿠키의 AUTHId 값
	 * @param AuthKey 현재 인증 정보를 담고 있는 쿠키의 AUTHKey 값
	 * @param request
	 * @param response
	 * @param model
	 * @return 가맹점 계층으로 Redirect
	 */
	@RequestMapping(value="/login",method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getFALogin(String memberId, 
			@CookieValue(value="AUTHId") String AuthId, 
			@CookieValue(value="AUTHKey") String AuthKey,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model){
		centerService.addBackupCookies(AuthId, AuthKey, response);
		centerService.addFACookies(memberId, response);
		HttpSessionSecurityContextRepository hsscr = new HttpSessionSecurityContextRepository();
		HttpRequestResponseHolder hrrh = new HttpRequestResponseHolder(request, response);
		hsscr.loadContext(hrrh).setAuthentication(null);//기존 Authentication에 저장된 객체 제거
		model.asMap().clear();//ModelAttribute parameter 제거
		return "redirect:/fa";
	}
}
