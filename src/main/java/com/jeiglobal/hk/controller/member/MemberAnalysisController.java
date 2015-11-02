package com.jeiglobal.hk.controller.member;

import java.util.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.MemberAnalysisDto.MemberAnalysisByGrade;
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
	public String getMemberAnalysisPage(Model model, @ModelAttribute LoginInfo loginInfo){
//		List<String> headerScript = new ArrayList<String>();
//		headerScript.add("memberAnalysis");
		log.debug("Getting MemberAnalysis Search Page");
		List<MemberAnalysisByGrade> analysisByGrade = memberAnalysisService.getMemberAnalysisByGrade(loginInfo);  
		model.addAttribute("analysisByGrade", analysisByGrade);
//		model.addAttribute("headerScript", headerScript);
		return "member/analysis/memberAnalysis";
	}
	
}
