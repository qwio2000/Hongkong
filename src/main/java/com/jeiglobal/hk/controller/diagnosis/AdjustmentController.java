package com.jeiglobal.hk.controller.diagnosis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeiglobal.hk.domain.diagnosis.AdjustmentDto;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.diagnosis.AdjustmentService;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 클래스명 : AdjustmentController.java
 *
 * 작성일 : 2015. 11. 4.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * [Diagnosis -> Adjustment] Controller
 */
@Slf4j
@Controller
public class AdjustmentController {

	@Autowired
	private AdjustmentService adjustmentService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MessageSourceAccessor messageSourceAccesor;
	
	// 처방 조회
	@RequestMapping(value={"/fa/diagnosis/adjustmentinput"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String adjustmentinput(Model model, String jisaCD, String memKey, String subj) {
		
		log.debug("Getting adjustment input");
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosisAdjustment");		
		model.addAttribute("headerScript", headerScript);	
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat nowAyy = new SimpleDateFormat("yyyy");
		SimpleDateFormat nowAmm = new SimpleDateFormat("MM");
		String ayy = nowAyy.format(cal.getTime());
		String amm = nowAmm.format(cal.getTime());
		
		cal.add(Calendar.MONTH, 6);
		String byy = nowAyy.format(cal.getTime());
		String bmm = nowAmm.format(cal.getTime());
		
		
		
		
		
		// 진도 조정 세트 주차  리스트 
		List<AdjustmentDto.AdjustmentList> adjustmentList = adjustmentService.getAdjustmentList(jisaCD, memKey, subj, ayy, amm, byy, bmm);
		
		
		model.addAttribute("jisaCD", jisaCD);	
		model.addAttribute("subj", subj);	
		model.addAttribute("adjustmentList", adjustmentList);		
		
		return "diagnosis/adjustment/bokinput";
	}
	
	@RequestMapping(value={"/fa/diagnosis/adjustmentinputJson"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String adjustmentinputJson(Model model, String jisaCD,  String subj, String dung, String set) {
		log.debug("Getting adjustment inputJson");
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosisAdjustment");		
		model.addAttribute("headerScript", headerScript);	
		
		
		String alertMsg1 = messageSourceAccesor.getMessage("Adjustmentinput.Choiceset.Error"); //'해당주차의 세트와 같거나 큰 세트 입니다. 다시 선택하세요'
		String alertMsg2 = messageSourceAccesor.getMessage("Adjustmentinput.Choiceset.all"); //'모두 선택 하셨습니다.'
		
		List<AdjustmentDto.AdjustmentJindoSetList> adjustmentJindoSetList1 = adjustmentService.getAdjustmentJindoSetList(jisaCD, subj, dung, "0");
		List<AdjustmentDto.AdjustmentJindoSetList> adjustmentJindoSetList2 = adjustmentService.getAdjustmentJindoSetList(jisaCD, subj, dung, "1");
		List<AdjustmentDto.AdjustmentJindoSetList> adjustmentJindoSetList3 = adjustmentService.getAdjustmentJindoSetList(jisaCD, subj, dung, "2");
		
		model.addAttribute("alertMsg1", alertMsg1);
		model.addAttribute("alertMsg2", alertMsg2);	
		model.addAttribute("defaultset", set);
		model.addAttribute("dung1", adjustmentJindoSetList1);	
		model.addAttribute("dung2", adjustmentJindoSetList2);	
		model.addAttribute("dung3", adjustmentJindoSetList3);	
		
		return "diagnosis/adjustment/bokinputJson";
		
	}
}

