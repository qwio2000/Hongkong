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
import com.jeiglobal.hk.service.member.*;
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
	
	@Autowired
	private MemberWorkbookService memberWorkbookService;
	
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
	@RequestMapping(value={"/fa/members/workbook/{pageNum:[0-9]+}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getMemberWorkbookJson(@ModelAttribute LoginInfo loginInfo,
			int month, int year, int week, String subj,
			@PathVariable int pageNum){
		log.debug("get member Workbook, year : {}, month : {}, week Range : {}", year, month, week);
		Map<String, Object> map = new HashMap<String, Object>();
		PageUtil pageUtil = new PageUtil(pageNum, memberWorkbookService.getMemberWorkbookCount(loginInfo.getJisaCD(), loginInfo.getDeptCD(), subj), pageSize, blockSize);
		if(pageUtil.getTotalPageCnt() > 0){
			List<MemberWorkbookInfo> workbooks = memberWorkbookService.getMemberWorkbooks(year, month, week, subj, loginInfo.getJisaCD(), loginInfo.getDeptCD(), pageUtil.getStartRow(), pageUtil.getRowBlockSize());
			map.put("workbooks", workbooks);
		}
		map.put("monthName", memberWorkbookService.getMonthName(month, CommonUtils.getMonths(2)));
		map.put("week", week);
		map.put("pageInfo", pageUtil);
		return map;
	}
	
}
