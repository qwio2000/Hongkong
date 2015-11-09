package com.jeiglobal.hk.controller.diagnosis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	// 진도조정
	@RequestMapping(value={"/fa/diagnosis/adjustmentinput"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String adjustmentinput(Model model, String jisaCD, String memKey, String subj, String yoil, String jindoGubun) {
		
		log.debug("Getting adjustment input");
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosisAdjustment");		
		model.addAttribute("headerScript", headerScript);	
		
		
		if(("").equals(jindoGubun) || jindoGubun == null){
			jindoGubun = "40";
		}
	
		// 진도 조정 체크
		/*String alertMsg = "";
		AdjustmentDto.AdjustmentJindoChk jindoChk = adjustmentService.addAdjustmentJindoChk(jisaCD,memKey,subj,jindoGubun,"","");		
		if(("N").equals(jindoChk.getMsgchk())){
			if(("1").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error1"); // 유지 회원만 가능합니다.
			}else if(("2").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error2"); // 진단 후 진도 조정이 가능합니다.
			}else if(("3").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error3"); // [진도 당김]을 할 수 없습니다.\n 입.복회일로부터 3주 이내만 가능합니다.
			}else if(("4").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error4"); // 진도조정 하루에 한번만 가능
			}else if(("5").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error5"); // 복습은 월 2회까지만 가능합니다.이번달에 이미 진도조정(복습)을 두번 하셨습니다!
			}else if(("6").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error6"); // 당김은 월 1회까지만 가능합니다.이번달에 이미 진도조정을 하셨습니다!
			}else if(("7").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error7"); // 복습 세트수가 45세트를 넘었습니다.
			}else if(("8").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error8"); //복습 세트수가 15세트를 넘었습니다.
			}
			model.addAttribute("message",alertMsg);
			model.addAttribute("mode", "close");
			return "alertAndRedirect";		
		}*/
		
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
		model.addAttribute("memKey", memKey);
		model.addAttribute("subj", subj);
		model.addAttribute("yoil", yoil);
		model.addAttribute("adjustmentList", adjustmentList);		
		if(("41").equals(jindoGubun)){
			return "diagnosis/adjustment/danginput";
		}else{
			return "diagnosis/adjustment/bokinput";
		}
		
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
	
	// 진도 조정 SAVE	
	@RequestMapping(value={"/fa/diagnosis/adjustmentinputSaveJson"}, method={RequestMethod.GET,RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> adjustmentinputSaveJson(Model model,AdjustmentDto.AdjustmentinputSaveJson bokInsert, HttpServletRequest request ) throws ParseException {
		
		String alertMsg = "";
		
		// 진도 조정 체크
		AdjustmentDto.AdjustmentJindoChk  jindoChk = adjustmentService.addAdjustmentJindoChk(bokInsert.getJisaCD(),bokInsert.getMemKey(),bokInsert.getSubj(),bokInsert.getBokGubun(),bokInsert.getSet1(),bokInsert.getSet3());		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		if(("Y").equals(jindoChk.getMsgchk())){
			if(("41").equals(bokInsert.getJindoGubun())){
				// 진도당김 저장
				adjustmentService.addAdjustmentJindoDangSave(bokInsert, request);			
				
			}else{
				// 진도복습
				adjustmentService.addAdjustmentJindoBokSave(bokInsert, request);			
				
			}
			alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.success"); // 진도조정 성공	
			
			
		}else{
			if(("1").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error1"); // 유지 회원만 가능합니다.
			}else if(("2").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error2"); // 진단 후 진도 조정이 가능합니다.
			}else if(("3").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error3"); // [진도 당김]을 할 수 없습니다.\n 입.복회일로부터 3주 이내만 가능합니다.
			}else if(("4").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error4"); // 진도조정 하루에 한번만 가능
			}else if(("5").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error5"); // 복습은 월 2회까지만 가능합니다.이번달에 이미 진도조정(복습)을 두번 하셨습니다!
			}else if(("6").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error6"); // 당김은 월 1회까지만 가능합니다.이번달에 이미 진도조정을 하셨습니다!
			}else if(("7").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error7"); // 복습 세트수가 45세트를 넘었습니다.
			}else if(("8").equals(jindoChk.getNosayu())){
				alertMsg = messageSourceAccesor.getMessage("Adjustmentinput.change.error8"); //복습 세트수가 15세트를 넘었습니다.
			}
		}

		map.put("alertMsg", alertMsg);
		
		return map;
	}
}

