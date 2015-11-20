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

import com.jeiglobal.hk.domain.*;
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
		//메인 페이지 요청 시 권한에 맞게 들어온 건지 체크 후 권한에 맞는 페이지로 redirect
		String currentUrl = request.getRequestURL().toString();
		if(!currentUrl.contains(loginInfo.getUserType().toLowerCase())){
			if("ma".equalsIgnoreCase(loginInfo.getUserType())){
				return "redirect:"+globalbmsUrl+"/ma";
			}else{
				return "redirect:/"+loginInfo.getUserType().toLowerCase();
			}
		}
		log.debug("userType=" + loginInfo.getUserType());
		//팝업
		if("fa".equalsIgnoreCase(loginInfo.getUserType())){
			String idxs = mainService.getPopupMsgIdx(loginInfo.getJisaCD(), loginInfo.getDeptCD(), CommonUtils.getCurrentYMD());
			model.addAttribute("idxs", idxs);		
		}
//		List<String> headerScript = new ArrayList<String>();
//		headerScript.add("main");
//		model.addAttribute("headerScript", headerScript);		
//		
		return "main";
	}
	
	@RequestMapping(value={"/fa/popupMsg"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getMainPopupMsg(Model model, @ModelAttribute LoginInfo loginInfo, String idxs) {
		List<String> idxList = new ArrayList<>();
		if(idxs.indexOf(",") > 0){ // 팝업 두 개 이상
			idxList = Arrays.asList(idxs.split(","));
		}else{
			idxList.add(idxs);
		}
		List<PopUpMsgGroup> popup = mainService.getPopupMsgIdx(idxList);
		model.addAttribute("popupMsgs", popup);
		return "mainPopMsg";
	}
	

	
	
}
