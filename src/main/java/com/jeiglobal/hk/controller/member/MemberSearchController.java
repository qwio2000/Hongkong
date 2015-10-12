package com.jeiglobal.hk.controller.member;

import java.util.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.service.member.*;
import com.jeiglobal.hk.utils.*;

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
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.size}")
	private int pageSize;
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.blockSize}")
	private int blockSize;
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(value={"/ja/members/search","/fa/members/search"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberSearchPage(Model model,
			@ModelAttribute LoginInfo loginInfo){
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberSearch");
		String userType = loginInfo.getUserType();
		log.debug("Getting MemberSearch Page, UserType : {}", userType);
		model.addAttribute("headerScript", headerScript);
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
			MemberDto.MemberSearch memberSearch,
			RedirectAttributes redirectAttributes){
		log.debug("member SearchResult Page {} ", memberSearch);
		if("JA".equalsIgnoreCase(loginInfo.getUserType())){
			List<String> headerScript = new ArrayList<>();
			headerScript.add("memberSearch");
			model.addAttribute("headerScript", headerScript);
			model.addAttribute("memberSearch", memberSearch);
			return "member/search/result";
		}else{
			redirectAttributes.addFlashAttribute("memberSearch", memberSearch);
			return "redirect:/fa/members/reports";
		}
	}
	@RequestMapping(value={"/ja/members/search/{pageNum:[0-9]+}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getMemberSearches(@ModelAttribute LoginInfo loginInfo,
			MemberDto.MemberSearch memberSearch,
			@PathVariable int pageNum){
		log.debug("get member searches {}",memberSearch);
		List<MemberDto.MemberSearchInfo> members = memberSearchService.getSearchResults(memberSearch, loginInfo, pageNum, pageSize);
		int totalCnt = (members.size()>0)? members.get(0).getRCnt() : 0;
		PageUtil pageUtil = new PageUtil(pageNum, totalCnt, pageSize, blockSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("members", members);
		map.put("pageInfo", pageUtil);
		return map;
	}
	
}
