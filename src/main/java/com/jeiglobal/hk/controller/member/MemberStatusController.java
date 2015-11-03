package com.jeiglobal.hk.controller.member;

import java.text.*;
import java.util.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.MemberDto.MemberRegistDropStatus;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.service.member.*;
import com.jeiglobal.hk.utils.*;

/**
 * 
 * 클래스명 : MemberStatusController.java
 *
 * 작성일 : 2015. 11. 3.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * FA => Members => Regist / Drop Status
 */
@Slf4j
@Controller
public class MemberStatusController {
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MessageSourceAccessor msa;
	
	@Autowired
	private MemberStatusService memberStatusService;

	@Value("${page.size}")
	private int pageSize;
	
	@Value("${page.blockSize}")
	private int pageBlockSize;
	
	@RequestMapping(value={"/fa/members/status"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberStatusPage(Model model, @ModelAttribute LoginInfo loginInfo) throws ParseException{
		log.debug("Getting Member Status Page, Regist & Drop");
		List<String> headerScript = new ArrayList<>();
		headerScript.add("memberStatus");
		List<String> searchYYMM = CommonUtils.getMonthsByOneYearBefore();
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("searchYYMM", searchYYMM);
		model.addAttribute("currentMonthName", CommonUtils.changeDateFormat("MM / yyyy", "MMM", searchYYMM.get(0)));
		return "member/status/registDrop";
	}
	@RequestMapping(value={"/fa/members/status/registDrop/{pageNum:[0-9]{1,4}}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getMemberRegistDropStatus(@ModelAttribute LoginInfo loginInfo,
			String searchYYMM,
			@PathVariable int pageNum) throws ParseException{
		log.debug("Getting Member Regist & Drop Status {}", searchYYMM);
		searchYYMM = CommonUtils.changeDateFormat("MM / yyyy", "yyyy-MM", searchYYMM);
		PageUtil pageInfo = new PageUtil(pageNum, memberStatusService.getMemberRegistDropStatusCount(loginInfo, searchYYMM), pageSize, pageBlockSize);
		List<MemberRegistDropStatus> list = memberStatusService.getMemberRegistDropStatus(loginInfo, searchYYMM);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageInfo", pageInfo);
		map.put("list", list);
		map.put("month", CommonUtils.changeDateFormat("yyyy-MM", "MMM", searchYYMM));
		map.put("year", searchYYMM.split("-")[0]);
		return map;
	}
	
}
