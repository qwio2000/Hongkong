/**
 * 
 */
package com.jeiglobal.hk.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.service.MainService;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

/**
 * 클래스명 : MainController.java
 *
 * 작성일 : 2015. 10. 8.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 지사 + 가맹점 메인 
 */

@Slf4j
@Controller
public class MainController {

	@Autowired
	private MessageSourceAccessor messageSource;
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping(value={"/ja"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getMain(Model model, @ModelAttribute LoginInfo loginInfo) {
		
/*		List<String> headerScript = new ArrayList<String>();
		headerScript.add("main");
		model.addAttribute("headerScript", headerScript);*/
		
		return "main";
	}
	
	
	
	
}
