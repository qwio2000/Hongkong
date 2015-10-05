package com.jeiglobal.hk.controller.member;

import java.util.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.service.member.*;

/**
 * 
 * 클래스명 : MemberSearchController.java
 *
 * 작성일 : 2015. 9. 17.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * JA : Members => Member Search
 * FA : Members => Member Search
 */
@Slf4j
@Controller
public class MemberRegistController {
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MemberRegistService memberRegistService;
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(value={"/fa/members/regist"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberRegistPage(Model model,
			@ModelAttribute LoginInfo loginInfo){
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberRegist");
		log.debug("Getting MemberRegist Page");
		model.addAttribute("headerScript", headerScript);
		return "member/regist/memberSearch";
	}
	
	@RequestMapping(value={"/fa/members/regist/{name}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getMemberRegistSearchResultJson(Model model,
			@PathVariable String name,
			@ModelAttribute LoginInfo loginInfo){
		log.debug("get MemberRegist Search : {}", name);
		List<MemberDto.MemberRegistSearchInfo> registSearches = memberRegistService.getMemberRegistSearch(name, loginInfo.getJisaCD());
		Map<String, Object> map = new HashMap<>();
		map.put("result", registSearches);
		return map;
	}
}
