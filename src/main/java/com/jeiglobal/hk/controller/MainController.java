/**
 * 
 */
package com.jeiglobal.hk.controller;

import java.util.*;

import javax.servlet.http.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.utils.*;

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
	
	@Value("${serverurl.globalbms}")
	private String globalbmsUrl;
	
	@RequestMapping(value={"/fa","/ja"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getMain(Model model, @ModelAttribute LoginInfo loginInfo, HttpServletRequest request) {
		String currentUrl = request.getRequestURL().toString();
		if(!currentUrl.contains(loginInfo.getUserType().toLowerCase())){
			if("ma".equalsIgnoreCase(loginInfo.getUserType())){
				return "redirect:"+globalbmsUrl+"/ma";
			}else{
				return "redirect:/"+loginInfo.getUserType().toLowerCase();
			}
		}
		log.debug("userType=" + loginInfo.getUserType());
/*		List<String> headerScript = new ArrayList<String>();
		headerScript.add("main");
		model.addAttribute("headerScript", headerScript);*/
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("main");
		model.addAttribute("headerScript", headerScript);		
		
		return "main";
	}
	
	
}
