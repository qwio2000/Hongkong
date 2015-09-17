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
public class MemberSearchController {
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MemberSearchService memberSearchService;
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(value={"/ja/members/search","/fa/members/search"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberSearchPage(Model model,
			@ModelAttribute LoginInfo loginInfo){
		String userType = loginInfo.getUserType();
		log.debug("Getting MemberSearch Page, UserType : {}", userType);
		model.addAttribute("memberStatuses", commonService.getCodeDtls("0008", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("grades", commonService.getCodeDtls("0003", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("subjects", commonService.getCodeDtls("0002", loginInfo.getJisaCD(), 1, "Y"));
		if ("JA".equals(userType)) {
			model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));
		}
		return "member/search/searchForm";
	}
	
	@RequestMapping(value={"/ja/members/searchResults","/fa/members/searchResults"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMembers(Model model,
			@ModelAttribute LoginInfo loginInfo,
			String centerName,
			String centerCity,
			String centerState,
			String centerZipcode,
			MemberDto.MemberSearch memberSearch){
		List<MemberDto.MemberSearchInfo> members = memberSearchService.getSearchResults(memberSearch);
		model.addAttribute("members", members);
		log.debug("memberSearch : {}", memberSearch);
		return "member/search/result";
	}
	
}
