package com.jeiglobal.hk.controller.common;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.web.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.utils.*;

/**
 * 
 * 클래스명 : HomeController.java
 *
 * 작성일 : 2015. 9. 7.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * HomeController
 */
@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private HomeService homeService;

	@RequestMapping(value={"/fa/members","/fa/diagnosis","/fa/inventory","/fa/accounting","/fa/mypage"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getLayoutPage() {
		LOGGER.debug("Getting Layout Page");
		return "common/layout";
	}
	@RequestMapping(value={"/ja/members","/ja/inventory","/ja/accounting","/ja/community","/ja/leads","/ja/mypage"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getJALayoutPage() {
		LOGGER.debug("Getting JA Layout Page");
		return "common/layout";
	}

	@RequestMapping(value="/returnjisa")
	public String returnJisaMode(@CookieValue(value="JisaAUTHId") String jisaAuthId,
			@CookieValue(value="JisaAUTHKey") String jisaAuthKey,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model){
		homeService.setCookieValue(jisaAuthId, jisaAuthKey, response);
		homeService.removeCookieValue(response);
		HttpSessionSecurityContextRepository hsscr = new HttpSessionSecurityContextRepository();
		HttpRequestResponseHolder hrrh = new HttpRequestResponseHolder(request, response);
		hsscr.loadContext(hrrh).setAuthentication(null);//기존 Authentication에 저장된 객체 제거
		model.asMap().clear();//ModelAttribute parameter 제거
		return "redirect:/ja/centers";
	}
	/**
	 * favicon.ico 요청 시 No Mapping Log 방지하기 위해 만듬 
	 */
	@RequestMapping("favicon.ico")
    @ResponseBody
    void favicon() {}
}
