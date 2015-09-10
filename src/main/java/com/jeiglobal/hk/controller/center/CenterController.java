package com.jeiglobal.hk.controller.center;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.web.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.service.center.*;
import com.jeiglobal.hk.utils.*;

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
@Controller
@RequestMapping(value="/ja/centers")
public class CenterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CenterController.class);
	
	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private CenterService centerService;
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCentersPage(){
		LOGGER.debug("Getting Centers Page");
		return "center/centers";
	}
	
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
		return "redirect:/fa/members";
	}
}
