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

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.diagnosis.FormativeevaluationDto;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.diagnosis.FormativeevaluationService;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

/**
 * 
 * 클래스명 : MpiController.java
 *
 * 작성일 : 2015. 9. 16.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * [Diagnosis -> formativeevaluation] Formativeevaluation
 */

@Slf4j
@Controller

public class FormativeevaluationController {
	
	@Autowired
	private FormativeevaluationService formativeevaluation;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MessageSourceAccessor messageSourceAccesor;
	
	// 형성평가 입력 화면
	@RequestMapping(value={"/fa/diagnosis/formativeevaluationMpi"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String diagnosisMpi(Model model, @ModelAttribute LoginInfo loginInfo, String memKey, String subj, String yy, String mm, String mfstname, String mlstname) {
		log.debug("Getting formativeevaluationMpi Page, UserType : {}");
		
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("formativeevaluation");		
		model.addAttribute("headerScript", headerScript);	
		
		
		String jisaCD = loginInfo.getJisaCD();
		
		List<FormativeevaluationDto.FormativeevaluationWolJinDo> formativeevaluationWolJinDo1 = formativeevaluation.getFormativeevaluationWolJinDo(jisaCD,memKey,subj,yy,mm,"1");
		List<FormativeevaluationDto.FormativeevaluationWolJinDo> formativeevaluationWolJinDo2 = formativeevaluation.getFormativeevaluationWolJinDo(jisaCD,memKey,subj,yy,mm,"2");
		List<FormativeevaluationDto.FormativeevaluationWolJinDo> formativeevaluationWolJinDo3 = formativeevaluation.getFormativeevaluationWolJinDo(jisaCD,memKey,subj,yy,mm,"3");
		List<FormativeevaluationDto.FormativeevaluationWolJinDo> formativeevaluationWolJinDo4 = formativeevaluation.getFormativeevaluationWolJinDo(jisaCD,memKey,subj,yy,mm,"4");
		List<FormativeevaluationDto.FormativeevaluationWolJinDo> formativeevaluationWolJinDo5 = formativeevaluation.getFormativeevaluationWolJinDo(jisaCD,memKey,subj,yy,mm,"5");
		
		model.addAttribute("memKey", memKey);
		model.addAttribute("subj", subj);
		model.addAttribute("yy", yy);
		model.addAttribute("mm", mm);
		model.addAttribute("mfstname", mfstname);
		model.addAttribute("mlstname", mlstname);
		model.addAttribute("wolJinDo1", formativeevaluationWolJinDo1);
		model.addAttribute("wolJinDo2", formativeevaluationWolJinDo2);
		model.addAttribute("wolJinDo3", formativeevaluationWolJinDo3);
		model.addAttribute("wolJinDo4", formativeevaluationWolJinDo4);
		model.addAttribute("wolJinDo5", formativeevaluationWolJinDo5);
		return "diagnosis/formativeevaluation/input";
	}
	


}