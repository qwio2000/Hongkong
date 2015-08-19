package com.jeiglobal.hk.controller;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.util.*;

/**
 * 클래스명 : HomeController.java
 *
 * 버전 정보 : 1.0
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

	@RequestMapping(value={"/","/login"})
	public String getLoginPage(Model model, 
			@RequestParam(value="error", required=false) String error,
			@RequestParam(value="returl", required=false) String returl) {
		if(error != null) {
    		model.addAttribute("error",error);
    		LOGGER.debug("Getting login page, error={}", error);
    	}else{
    		LOGGER.debug("Getting Login Page");
    	}
		model.addAttribute("returl", returl);
		LOGGER.debug("### Return Url : {}", returl);
		return "login";
	}

	@RequestMapping(value={"mMenuLink","","/agree","/board","/classChange","/emptyHakjuk","/huheiList","/inventory"
			,"/ipgum","/iphei","/jindo","/manageFA","/manageInfo","/memberCard","/misu","/monthSiljuk","/qna"
			,"/saleResult","/siljuk","/study","/studyState","/subul"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getLayoutPage() {
		LOGGER.debug("Getting Layout Page");
		return "layout";
	}

	@ResponseBody
	@RequestMapping("/message")
	public String getBoardSubject(Locale locale) {
		//Default Locale : ko_KR => message_ko_KR.properties에 존재하는 메세지를 읽음
		LOGGER.info("### ko_KR Message : Code is {}, Message is {}","MyName.FirstName", messageSource.getMessage("MyName.FirstName", locale));
		LOGGER.info("### ko_KR Message : Code is {}, Message is {}","MyName.SecondName", messageSource.getMessage("MyName.SecondName", locale));
		//Locale을 영어로 변경 => message_en_US.properties에 존재하는 메세지를 읽음
		Locale enLocale = new Locale("en_US");
		LOGGER.info("### en_US Message : Code is {}, Message is {}","MyName.FirstName", messageSource.getMessage("MyName.FirstName", enLocale));
		LOGGER.info("### en_US Message : Code is {}, Message is {}","MyName.SecondName", messageSource.getMessage("MyName.SecondName", enLocale));
		return "Message Test in Log";
	}
	/**
	 * favicon.ico 요청 시 No Mapping Log 방지하기 위해 만듬 
	 */
	@RequestMapping("favicon.ico")
    @ResponseBody
    void favicon() {}
	
}
