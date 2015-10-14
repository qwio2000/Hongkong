package com.jeiglobal.hk.controller.member;

import java.util.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.MemberDto.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.utils.*;

/**
 * 
 * 클래스명 : MemberWorkbookController.java
 *
 * 작성일 : 2015. 10. 14.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * FA : Members => Member Workbook
 */
@Slf4j
@Controller
public class MemberWorkbookController {
	
	@Autowired
	private CommonService commonService;
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.size}")
	private int pageSize;
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.blockSize}")
	private int blockSize;
	
	@RequestMapping(value={"/fa/members/workbook"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMembers(Model model,
			@ModelAttribute LoginInfo loginInfo){
		log.debug("member Workbook Page {} ");
		List<String> headerScript = new ArrayList<>();
		List<MonthInfo> months = CommonUtils.getMonths(1);
		List<String> subjs = commonService.getOpenSubjsByDeptCD(loginInfo.getJisaCD(), loginInfo.getDeptCD());
		headerScript.add("memberWorkbook");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("months", months);
		model.addAttribute("subjs", subjs);
		return "member/workbook/reports";
	}
//	@RequestMapping(value={"/ja/members/search/{pageNum:[0-9]+}"},method = {RequestMethod.GET, RequestMethod.HEAD})
//	@ResponseBody
//	public Map<String, Object> getMemberSearches(@ModelAttribute LoginInfo loginInfo,
//			MemberDto.MemberSearch memberSearch,
//			@PathVariable int pageNum){
//		log.debug("get member searches {}",memberSearch);
//		List<MemberDto.MemberSearchInfo> members = memberSearchService.getSearchResults(memberSearch, loginInfo, pageNum, pageSize);
//		int totalCnt = (members.size()>0)? members.get(0).getRCnt() : 0;
//		PageUtil pageUtil = new PageUtil(pageNum, totalCnt, pageSize, blockSize);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("members", members);
//		map.put("pageInfo", pageUtil);
//		return map;
//	}
	
}
