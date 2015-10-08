package com.jeiglobal.hk.controller.member;

import java.text.*;
import java.util.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.service.member.*;
import com.jeiglobal.hk.utils.*;

/**
 * 
 * 클래스명 : MemberReportController.java
 *
 * 작성일 : 2015. 9. 17.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * FA : Members => Member Report
 */
@Slf4j
@Controller
public class MemberReportController {
	
	@Autowired
	private MemberReportService memberReportService;
	
	@Value("${page.size}")
	private int pageSize;
	
	@Value("${page.blockSize}")
	private int pageBlockSize;
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(value={"/fa/members/reports"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberReport(Model model,
			@ModelAttribute LoginInfo loginInfo,
			MemberDto.MemberSearch memberSearch){
		log.debug("report Page {}", memberSearch);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberReport");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("memberSearch", memberSearch);
		return "member/report/report";
	}
	
	@RequestMapping(value={"/fa/members/reports/{pageNum:[0-9]{1,4}}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getMemberReports(@ModelAttribute LoginInfo loginInfo,
			MemberDto.MemberSearch memberSearch,
			@PathVariable int pageNum){
		log.debug("get member reports {}",memberSearch);
		List<MemberDto.MemberSearchInfo> members = memberReportService.getSearchResults(memberSearch, loginInfo, pageNum, pageSize);
		int totalCnt = (members.size()>0)? members.get(0).getRCnt() : 0;
		PageUtil pageUtil = new PageUtil(pageNum, totalCnt, pageSize, pageBlockSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("members", members);
		map.put("pageInfo", pageUtil);
		return map;
	}
	
	//TODO 정규표현식
	@RequestMapping(value={"/fa/members/reports/{memKey:^[A-Z]{2}[0-9]{6}}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberReport(Model model,
			@ModelAttribute LoginInfo loginInfo,
			@PathVariable String memKey) throws ParseException{
		log.debug("Getting Member Report memKey : {}", memKey);
		MemMst memMst = memberReportService.getMemMstByMemKey(memKey);
		List<MemberDto.MemberReportInfo> memberReportInfos = memberReportService.getMemberReportInfo(memMst);
		model.addAttribute("guardianInfo", memMst);
		model.addAttribute("memberReportInfos", memberReportInfos);
		return "member/report/memberReport";
	}
	
}
