package com.jeiglobal.hk.controller.member;

import java.text.*;
import java.util.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.service.member.*;
import com.jeiglobal.hk.utils.*;

/**
 * 
 * 클래스명 : MemberAnalysisController.java
 *
 * 작성일 : 2015. 11. 02.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 */
@Slf4j
@Controller
public class MemberAnalysisController {
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MessageSourceAccessor msa;
	
	@Autowired
	private MemberAnalysisService memberAnalysisService;

	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(value={"/fa/members/analysis"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberAnalysisPage(Model model, @ModelAttribute LoginInfo loginInfo, String searchYYMM) throws ParseException{
		log.debug("Getting MemberAnalysis Search Page, {}", searchYYMM);
		if(searchYYMM == null){
			searchYYMM = CommonUtils.changeDateFormat("yyyy-MM-dd", "yyyy-MM", CommonUtils.getCurrentYMD());
		}else{
			searchYYMM = CommonUtils.changeDateFormat("MM / yyyy", "yyyy-MM", searchYYMM);
		}
		List<String> headerCss = new ArrayList<String>();
		headerCss.add("jui/jui.min");
		headerCss.add("jui/jennifer.theme.min");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("jui/jui.min");
		model.addAttribute("headerCss", headerCss);
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("memberByMonths", memberAnalysisService.getMemberByMonths(loginInfo.getJisaCD(), loginInfo.getDeptCD(), searchYYMM));
		model.addAttribute("bySubject", memberAnalysisService.getMemberBySubject(loginInfo.getJisaCD(), loginInfo.getDeptCD(), searchYYMM));
		model.addAttribute("YYMMs", CommonUtils.getMonthsByOneYearBefore());
		model.addAttribute("searchYYMM", CommonUtils.changeDateFormat("yyyy-MM", "MM / yyyy", searchYYMM));
		
		return "member/analysis/memberAnalysis";
	}
	@RequestMapping(value={"/fa/members/analysis/grade"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberAnalysisGradePage(Model model, @ModelAttribute LoginInfo loginInfo) throws ParseException{
		log.debug("Getting MemberAnalysis Grade Page");
		model.addAttribute("analysisByGrade", memberAnalysisService.getMemberAnalysisByGrade(loginInfo));
		return "member/analysis/memberAnalysisGrade";
	}
	
	//지사 => Member => Member Analysis
	@RequestMapping(value={"/ja/members/analysis"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberAnalysisJAPage(Model model, @ModelAttribute LoginInfo loginInfo){
		log.debug("Getting Member Analysis JA Page");
		return "member/analysis/memberAnalysisJA";
	}
	
	//지사 => Member => SubjectReport
	@RequestMapping(value={"/ja/members/analysis/subject"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberSubjectReportPage(Model model, @ModelAttribute LoginInfo loginInfo){
		log.debug("Getting Subject Report Page");
		return "member/analysis/subjectReport";
	}
	
	//지사 => Member => Drop Analysis
	@RequestMapping(value={"/ja/members/analysis/drop"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getDropAnalysisPage(Model model, @ModelAttribute LoginInfo loginInfo){
		log.debug("Getting Drop Analysis Page");
		return "member/analysis/dropAnalysis";
	}
	
	
	
}
