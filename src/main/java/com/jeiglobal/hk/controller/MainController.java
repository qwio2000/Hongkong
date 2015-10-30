/**
 * 
 */
package com.jeiglobal.hk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.service.MainService;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

import lombok.extern.slf4j.Slf4j;

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
	
	@RequestMapping(value={"/fa","/ja"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getMain(Model model, @ModelAttribute LoginInfo loginInfo) {
		
		System.out.println("userType=" + loginInfo.getUserType());
/*		List<String> headerScript = new ArrayList<String>();
		headerScript.add("main");
		model.addAttribute("headerScript", headerScript);*/
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("main");
		model.addAttribute("headerScript", headerScript);		
		
		return "main";
	}
	
	
}
