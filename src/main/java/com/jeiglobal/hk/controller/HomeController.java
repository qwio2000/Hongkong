package com.jeiglobal.hk.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.utils.*;

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

	@RequestMapping(value={"mMenuLink","","/agree","/classChange","/emptyHakjuk","/huheiList","/inventory"
			,"/ipgum","/manageFA","/manageInfo","/memberCard","/misu","/monthSiljuk","/qna"
			,"/saleResult","/siljuk","/study","/studyState","/subul"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getLayoutPage() {
		LOGGER.debug("Getting Layout Page");
		return "layout";
	}
	
	@RequestMapping(value="/jindo")
	public String getRuntimeError(){
		LOGGER.debug("RuntimeException!!!!!!!!!!!!!");
		throw new RuntimeException("낄낄");
	}
	/**
	 * favicon.ico 요청 시 No Mapping Log 방지하기 위해 만듬 
	 */
	@RequestMapping("favicon.ico")
    @ResponseBody
    void favicon() {}
	
}
