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
	
	@RequestMapping(value={"/fa/members/workbook", "/ja/members/workbook"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMembers(Model model,
			@ModelAttribute LoginInfo loginInfo, String jisaCD, String deptCD){
		log.debug("member Workbook Page {} ");
		List<String> headerScript = new ArrayList<>();
		List<MonthInfo> months = CommonUtils.getMonths(1);
		List<String> subjs = commonService.getOpenSubjsByDeptCD(loginInfo.getJisaCD(), loginInfo.getDeptCD(), "1");
		headerScript.add("memberWorkbook");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("months", months);
		model.addAttribute("subjs", subjs);
		model.addAttribute("jisaCD", jisaCD);
		model.addAttribute("deptCD", deptCD);
		return "member/workbook/reports"+("JA".equals(loginInfo.getUserType()) ? loginInfo.getUserType() : "");
	}
	@RequestMapping(value={"/fa/members/workbook/{pageNum:[0-9]+}", "/ja/members/workbook/{pageNum:[0-9]+}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getMemberWorkbookJson(@ModelAttribute LoginInfo loginInfo,
			int month, int year, int week, String subj, String jisaCD, String deptCD,
			@PathVariable int pageNum){
		log.debug("get member Workbook, year : {}, month : {}, week Range : {}", year, month, week);
		if("".equals(jisaCD)){jisaCD = loginInfo.getJisaCD();}
		if("".equals(deptCD)){deptCD = loginInfo.getDeptCD();}
		Map<String, Object> map = new HashMap<String, Object>();
		PageUtil pageUtil = new PageUtil(pageNum, memberWorkbookService.getMemberWorkbookCount(jisaCD, deptCD, subj), pageSize, blockSize);
		if(pageUtil.getTotalPageCnt() > 0){
			List<MemberWorkbookInfo> workbooks = memberWorkbookService.getMemberWorkbooks(year, month, week, subj, jisaCD, deptCD, pageUtil.getStartRow(), pageUtil.getRowBlockSize());
			map.put("workbooks", workbooks);
		}
		map.put("monthName", memberWorkbookService.getMonthName(month, CommonUtils.getMonths(2)));
		map.put("week", week);
		map.put("pageInfo", pageUtil);
		return map;
	}
	
}
