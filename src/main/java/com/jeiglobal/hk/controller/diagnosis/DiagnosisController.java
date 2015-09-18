package com.jeiglobal.hk.controller.diagnosis;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeiglobal.hk.controller.HomeController;
import com.jeiglobal.hk.domain.CodeDtl;
import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.diagnosis.Diagnosis;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.diagnosis.DiagnosisService;

/**
 * 
 * 클래스명 : DiagnosisController.java
 *
 * 작성일 : 2015. 9. 16.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * [Diagnosis -> Diagnosis] Controller
 */

@Slf4j
@Controller

public class DiagnosisController {
	
	//페이징 범위
	private static final int PAGE_BLOCK_SIZE = 10;
	//한 페이지에 출력할 게시물 개수
	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private DiagnosisService diagnosisService;
	
	@Autowired
	private CommonService commonService;
		
	

	@RequestMapping(value={"/fa/diagnosis"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String diagnosis(Model model, @RequestParam(defaultValue="1") String page, @RequestParam(defaultValue="10") String pagecnt) {
		log.debug("Getting diagnosis Page");
		List<Diagnosis> diagnosis = diagnosisService.getDiagnosis(page,pagecnt);
		
		model.addAttribute("page", diagnosis);
		
		return "diagnosis/diagnosis";
	}
	
	@RequestMapping(value={"/fa/diagnosis/diagnosisSerch"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String diagnosisSerch(Model model, @ModelAttribute LoginInfo loginInfo) {
		log.debug("Getting diagnosisSerch Page");
		
		List<CodeDtl> codeDtls =  commonService.getCodeDtls("0003", loginInfo.getJisaCD());		
		model.addAttribute("codeDtls", codeDtls);
		
		List<CodeDtl> codeSubject =  commonService.getCodeDtls("0002", loginInfo.getJisaCD());		
		model.addAttribute("codeSubject", codeSubject);
		
		return "diagnosis/diagnosisSearch/search";
	}

}
