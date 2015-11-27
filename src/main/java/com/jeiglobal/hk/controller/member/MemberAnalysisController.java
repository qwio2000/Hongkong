package com.jeiglobal.hk.controller.member;

import java.text.*;
import java.util.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.MemberAnalysisDto.*;
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
	public String getMemberAnalysisGradePage(Model model, @ModelAttribute LoginInfo loginInfo, String searchYYMM, String subj) throws ParseException{
		log.debug("Getting MemberAnalysis Grade Page");
		List<String> headerCss = new ArrayList<String>();
		headerCss.add("jui/jui.min");
		headerCss.add("jui/jennifer.theme.min");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("jui/jui.min");
		model.addAttribute("headerCss", headerCss);
		model.addAttribute("headerScript", headerScript);
		
		if(searchYYMM == null){
			searchYYMM = CommonUtils.changeDateFormat("yyyy-MM-dd", "yyyy-MM", CommonUtils.getCurrentYMD());
		}else{
			searchYYMM = CommonUtils.changeDateFormat("MM / yyyy", "yyyy-MM", searchYYMM);
		}
		subj = (subj == null ? "TT" : subj);
		if(!"TT".equals(subj)){
			model.addAttribute("byWbGrade", memberAnalysisService.getMemberByWbGrade(loginInfo.getJisaCD(), loginInfo.getDeptCD(), searchYYMM, subj));
		}
		model.addAttribute("multiSubj", memberAnalysisService.getMembersByMultiSubj(loginInfo.getJisaCD(), loginInfo.getDeptCD(), searchYYMM, subj));
		model.addAttribute("byGrade", memberAnalysisService.getMembersByGrade(loginInfo.getJisaCD(), loginInfo.getDeptCD(), searchYYMM, subj));
		model.addAttribute("subjs", commonService.getOpenSubjsByDeptCD(loginInfo.getJisaCD(), loginInfo.getDeptCD(), "2"));
		model.addAttribute("YYMMs", CommonUtils.getMonthsByOneYearBefore());
		model.addAttribute("searchSubj", subj);
		model.addAttribute("searchYYMM", CommonUtils.changeDateFormat("yyyy-MM", "MM / yyyy", searchYYMM));
		return "member/analysis/memberAnalysisGrade";
	}
	
	@RequestMapping(value={"/ja/members/analysis/grade"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberAnalysisGradeJAPage(Model model, @ModelAttribute LoginInfo loginInfo, String searchYYMM, String subj, 
			@RequestParam(defaultValue="") String deptName, @RequestParam(defaultValue="00000") String deptCD) throws ParseException{
		log.debug("Getting MemberAnalysis Grade JA Page");
		List<String> headerCss = new ArrayList<String>();
		headerCss.add("jui/jui.min");
		headerCss.add("jui/jennifer.theme.min");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("jui/jui.min");
		headerScript.add("memberAnalysis");
		model.addAttribute("headerCss", headerCss);
		model.addAttribute("headerScript", headerScript);
		
		if(searchYYMM == null){
			searchYYMM = CommonUtils.changeDateFormat("yyyy-MM-dd", "yyyy-MM", CommonUtils.getCurrentYMD());
		}else{
			searchYYMM = CommonUtils.changeDateFormat("MM / yyyy", "yyyy-MM", searchYYMM);
		}
		subj = (subj == null ? "TT" : subj);
		if(!"TT".equals(subj)){
			model.addAttribute("byWbGrade", memberAnalysisService.getMemberByWbGrade(loginInfo.getJisaCD(), deptCD, searchYYMM, subj));
		}
		model.addAttribute("multiSubj", memberAnalysisService.getMembersByMultiSubj(loginInfo.getJisaCD(), deptCD, searchYYMM, subj));
		model.addAttribute("byGrade", memberAnalysisService.getMembersByGrade(loginInfo.getJisaCD(), deptCD, searchYYMM, subj));
		model.addAttribute("subjs", commonService.getOpenSubjsByJisaCD(loginInfo.getJisaCD()));
		model.addAttribute("YYMMs", CommonUtils.getMonthsByOneYearBefore());
		model.addAttribute("searchSubj", subj);
		model.addAttribute("searchYYMM", CommonUtils.changeDateFormat("yyyy-MM", "MM / yyyy", searchYYMM));
		model.addAttribute("deptName", deptName);
		model.addAttribute("deptCD", deptCD);
		return "member/analysis/memberAnalysisGradeJA";
	}
	
	//지사 => Member => Member Analysis
	@RequestMapping(value={"/ja/members/analysis"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberAnalysisJAPage(Model model, @ModelAttribute LoginInfo loginInfo, String searchYYMM,
			@RequestParam(defaultValue="") String deptName, @RequestParam(defaultValue="00000") String deptCD) throws ParseException{
		log.debug("Getting Member Analysis JA Page");
		List<String> headerCss = new ArrayList<String>();
		headerCss.add("jui/jui.min");
		headerCss.add("jui/jennifer.theme.min");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("jui/jui.min");
		headerScript.add("memberAnalysis");
		model.addAttribute("headerCss", headerCss);
		model.addAttribute("headerScript", headerScript);
		
		if(searchYYMM == null){
			searchYYMM = CommonUtils.changeDateFormat("yyyy-MM-dd", "yyyy-MM", CommonUtils.getCurrentYMD());
		}else{
			searchYYMM = CommonUtils.changeDateFormat("MM / yyyy", "yyyy-MM", searchYYMM);
		}
		List<MemberByMonthFA> memberByMonths = null;
		List<MemberBySubject> bySubject = null;
		if("00000".equals(deptCD)){
			memberByMonths = memberAnalysisService.getMemberByMonths(loginInfo.getJisaCD(), searchYYMM);
			bySubject = memberAnalysisService.getMemberBySubject(loginInfo.getJisaCD(), searchYYMM);
		}else{
			memberByMonths = memberAnalysisService.getMemberByMonths(loginInfo.getJisaCD(), deptCD, searchYYMM);
			bySubject = memberAnalysisService.getMemberBySubject(loginInfo.getJisaCD(), deptCD, searchYYMM);
		}
		model.addAttribute("bySubject", bySubject);
		model.addAttribute("memberByMonths", memberByMonths);
		model.addAttribute("YYMMs", CommonUtils.getMonthsByOneYearBefore());
		model.addAttribute("searchYYMM", CommonUtils.changeDateFormat("yyyy-MM", "MM / yyyy", searchYYMM));
		model.addAttribute("deptName", deptName);
		model.addAttribute("deptCD", deptCD);
		return "member/analysis/memberAnalysisJA";
	}
	
	/**
	 * 조직찾기
	 */
	@RequestMapping(value={"/ja/members/analysis/deptSearchPop"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getDeptSearchPop(Model model, @ModelAttribute LoginInfo loginInfo) {
		List<Map<String, Object>> dataDeptSearchPop = memberAnalysisService.getDeptSearchPop(loginInfo.getJisaCD());
		log.debug("Getting Dept Search Pop Page");
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberAnalysis");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("deptSearchPop", dataDeptSearchPop);
		return "member/analysis/deptSearchPop";
	}
	
	//지사 => Member => SubjectReport
	@RequestMapping(value={"/ja/members/analysis/subject"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberSubjectReportPage(Model model, @ModelAttribute LoginInfo loginInfo,
			String searchYY, @RequestParam(defaultValue="") String deptName, @RequestParam(defaultValue="00000") String deptCD) throws ParseException{
		log.debug("Getting Subject Report Page {} , {}", deptCD, searchYY);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberAnalysis");
		model.addAttribute("headerScript", headerScript);
		if(searchYY == null){
			searchYY = CommonUtils.changeDateFormat("yyyy-MM-dd", "yyyy", CommonUtils.getCurrentYMD());
		}
		model.addAttribute("months", CommonUtils.getMonths(2));
		model.addAttribute("subjectReport", memberAnalysisService.getSubjectReport(loginInfo.getJisaCD(), deptCD, searchYY));
		model.addAttribute("searchYY", searchYY);
		model.addAttribute("displayYears", memberAnalysisService.getDisplayYears(searchYY));
		model.addAttribute("years", memberAnalysisService.getLastFiveYears());
		model.addAttribute("deptName", deptName);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("subjs", commonService.getOpenSubjsByJisaCD(loginInfo.getJisaCD()));
		return "member/analysis/subjectReport";
	}
	
	//지사 => Member => Drop Analysis
	@RequestMapping(value={"/ja/members/analysis/drop"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getDropAnalysisPage(Model model, @ModelAttribute LoginInfo loginInfo, String searchYY){
		log.debug("Getting Drop Analysis Page");
		List<String> headerCss = new ArrayList<String>();
		headerCss.add("jui/jui.min");
		headerCss.add("jui/jennifer.theme.min");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("jui/jui.min");
		headerScript.add("memberAnalysis");
		model.addAttribute("headerCss", headerCss);
		model.addAttribute("headerScript", headerScript);
		if(searchYY == null){
			searchYY = CommonUtils.getCurrentYMD().substring(0, 4);
		}
		model.addAttribute("dropReasons", commonService.getCodeDtls("0201", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("drops", memberAnalysisService.getDropAnalysis(loginInfo.getJisaCD(), searchYY));
		model.addAttribute("years", memberAnalysisService.getLastFiveYears());
		model.addAttribute("searchYY", searchYY);
		return "member/analysis/dropAnalysis";
	}
	//지사 => Member => Drop Analysis
	@RequestMapping(value={"/ja/members/analysis/drop/{deptCD}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getDropAnalysisPopPage(Model model, @ModelAttribute LoginInfo loginInfo, String searchYY, @PathVariable String deptCD, String deptName){
		log.debug("Getting Drop Analysis Page");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberAnalysis");
		model.addAttribute("headerScript", headerScript);
		if(searchYY == null){
			searchYY = CommonUtils.getCurrentYMD().substring(0, 4);
		}
		model.addAttribute("dropReasons", commonService.getCodeDtls("0201", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("drops", memberAnalysisService.getDropAnalysisPop(loginInfo.getJisaCD(), searchYY, deptCD));
		model.addAttribute("searchYY", searchYY);
		model.addAttribute("deptName", deptName);
		return "member/analysis/dropAnalysisPop";
	}
	
	@RequestMapping(value={"/ja/members/analysis/subjectReport"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getSubjReportJson(@ModelAttribute LoginInfo loginInfo,
			String deptCD, int pastMonth) throws ParseException{
		log.debug("Getting Subject Report, deptCD : {}, pastMonth : {}", deptCD, pastMonth);
		List<SubjectReportBottom> subjReports = memberAnalysisService.getSubjReportBottom(loginInfo.getJisaCD(), deptCD, pastMonth);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("subjReports", subjReports);
		map.put("pastMonth", pastMonth);
		return map;
	}
}
