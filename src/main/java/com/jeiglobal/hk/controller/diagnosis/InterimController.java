package com.jeiglobal.hk.controller.diagnosis;

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

import com.jeiglobal.hk.domain.diagnosis.InterimDto;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.diagnosis.InterimService;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * 클래스명 : MpiController.java
 *
 * 작성일 : 2015. 9. 16.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * [Diagnosis -> Interim] Interim
 */

@Slf4j
@Controller

public class InterimController {
	
	@Autowired
	private InterimService interimService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MessageSourceAccessor messageSourceAccesor;
	
	// 형성평가 입력 화면
	@RequestMapping(value={"/fa/diagnosis/interimMpi"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String interimMpi(Model model, String jisaCD, String deptCD, String memKey, String subj, String yy, String mm, String mfstname, String mlstname) {
		log.debug("Getting interimMpi Page, UserType : {}");
		
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosisinterim");		
		model.addAttribute("headerScript", headerScript);	
		
		
		String[]  noArrer = new String[18];
		System.out.println( CommonUtils.LeftString(subj,1) );
		if( ("M").equals(CommonUtils.RightString(subj,1))) { 
			if(("E").equals(CommonUtils.LeftString(subj,1))){
				noArrer[0] = "A"; noArrer[1] = "B"; noArrer[2] = "C"; noArrer[3] = "D"; noArrer[4] = "E";
				noArrer[5] = "F"; noArrer[6] = "G"; noArrer[7] = "H"; noArrer[8] = "I"; noArrer[9] = "J";
				noArrer[10] = "K"; noArrer[11] = "L"; noArrer[12] = "M"; noArrer[13] = "N"; noArrer[14] = "O";
				noArrer[15] = "P"; noArrer[16] = "Q"; noArrer[17] = "R";
			}else{
				noArrer[0] = "가"; noArrer[1] = "나"; noArrer[2] = "다"; noArrer[3] = "라"; noArrer[4] = "마";
				noArrer[5] = "바"; noArrer[6] = "사"; noArrer[7] = "아"; noArrer[8] = "자"; noArrer[9] = "차";
				noArrer[10] = "카"; noArrer[11] = "타"; noArrer[12] = "파"; noArrer[13] = "하"; noArrer[14] = "거";
				noArrer[15] = "너"; noArrer[16] = "더"; noArrer[17] = "러";
			}
		}else{
			noArrer[0] = "1"; noArrer[1] = "2"; noArrer[2] = "3"; noArrer[3] = "4"; noArrer[4] = "5";
			noArrer[5] = "6"; noArrer[6] = "7"; noArrer[7] = "8"; noArrer[8] = "9"; noArrer[9] = "10";
			noArrer[10] = "11"; noArrer[11] = "12"; noArrer[12] = "13"; noArrer[13] = "14"; noArrer[14] = "15";
			noArrer[15] = "16"; noArrer[16] = "17"; noArrer[17] = "18";		
		}
		
		
		
		List<InterimDto.InterimWolJinDo> interimWolJinDo1 = interimService.getInterimWolJinDo(jisaCD,memKey,subj,yy,mm,"1");
		List<InterimDto.InterimWolJinDo> interimWolJinDo2 = interimService.getInterimWolJinDo(jisaCD,memKey,subj,yy,mm,"2");
		List<InterimDto.InterimWolJinDo> interimWolJinDo3 = interimService.getInterimWolJinDo(jisaCD,memKey,subj,yy,mm,"3");
		List<InterimDto.InterimWolJinDo> interimWolJinDo4 = interimService.getInterimWolJinDo(jisaCD,memKey,subj,yy,mm,"4");
		List<InterimDto.InterimWolJinDo> interimWolJinDo5 = interimService.getInterimWolJinDo(jisaCD,memKey,subj,yy,mm,"5");
		
		model.addAttribute("noArrer", noArrer);
		model.addAttribute("jisaCD", jisaCD);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("memKey", memKey);
		model.addAttribute("subj", subj);
		model.addAttribute("yy", yy);
		model.addAttribute("mm", mm);
		model.addAttribute("mfstname", mfstname);
		model.addAttribute("mlstname", mlstname);
		model.addAttribute("wolJinDo1", interimWolJinDo1);
		model.addAttribute("wolJinDo2", interimWolJinDo2);
		model.addAttribute("wolJinDo3", interimWolJinDo3);
		model.addAttribute("wolJinDo4", interimWolJinDo4);
		model.addAttribute("wolJinDo5", interimWolJinDo5);
		return "diagnosis/interim/input";
	}
	
	// 형성평가 입력 저장	
	@RequestMapping(value={"/fa/diagnosis/interimMpiJson"}, method={RequestMethod.GET,RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> interimMpiJson(Model model, HttpServletRequest request, String jisaCD, String deptCD, String memKey, String subj, String yy, String mm, String wolhak, String data) {
		String alertErrorMsg = "";
		String alertsuccessMsg = "";
		String MpiSaveOK = "";
		String[] dataarrer = data.split("##");

		String workId = CommonUtils.getWorkId(request);
		
		//기초 정보 저장
		String GichoSaveOK = interimService.addInterimMpiGichoSave(jisaCD, deptCD, memKey, subj, yy, mm, wolhak, workId);
		
		alertErrorMsg = messageSourceAccesor.getMessage("Mpi.Input.Insert.Error");
		alertsuccessMsg = messageSourceAccesor.getMessage("Mpi.Input.Insert.success");
		
		if (!"Y".equals(GichoSaveOK)) {
			MpiSaveOK = "N";
			alertErrorMsg = messageSourceAccesor.getMessage("Mpi.Input.Insert.Error");
		}else{
		
		//입력 저장
			MpiSaveOK = interimService.addInterimMpiSave(jisaCD, deptCD, memKey, subj, yy, mm, workId, dataarrer);			
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("alertErrorMsg", alertErrorMsg);
		map.put("alertsuccessMsg", alertsuccessMsg);
		map.put("saveOK", MpiSaveOK);
		
		return map;
	}
	

	//형성평가 기록부 
	@RequestMapping(value={"/fa/diagnosis/interimPrint"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String interimPrint(Model model, String jisaCD, String deptCD, String memKey, String subj, String yy, String mm, String lang) {
		log.debug("Getting interimPrint Page");
		
		//회원 기초정보
		InterimDto.InterimSDGichoList interimSDGichoList =interimService.getInerimSDGichoList(jisaCD,yy,mm,memKey,subj,lang); 
		
		//학습내용 및 성취율
		List<InterimDto.InterimSDWolhakLst> interimSDWolhakLst =interimService.getInerimSDWolhakLst(jisaCD,yy,mm,memKey,subj,lang);
		
		//형성평가 오답내용 분석
		List<InterimDto.InterimSDErrAnalysis> interimSDErrAnalysis =interimService.getInerimSDErrAnalysis(jisaCD,yy,mm,memKey,subj,lang);
		
		//진도현황 (금월/예상)
		List<InterimDto.InterimSDJindoExpectLst> interimSDJindoExpectLst =interimService.getInerimSDJindoExpectLst(jisaCD,yy,mm,memKey,subj,lang);
		
		String grade = interimSDGichoList.getOmrhak();
		String birthday = interimSDGichoList.getOmrbirth();
		//월의 학습환경
		InterimDto.InterimSDWorkBasicLst interimSDWorkBasicLst =interimService.getInerimSDWorkBasicLst(jisaCD,grade,birthday,mm);
		
		
		SimpleDateFormat now = new SimpleDateFormat("yyyy-MM");
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(yy), Integer.parseInt(mm) -1 , 1);
		cal.add(Calendar.MONTH, 1);
		String convYYMM = now.format(cal.getTime());
		model.addAttribute("convYYMM1", convYYMM);
		cal.add(Calendar.MONTH, 1);
		convYYMM = now.format(cal.getTime());
		model.addAttribute("convYYMM2", convYYMM);
		cal.add(Calendar.MONTH, 1);
		convYYMM = now.format(cal.getTime());
		model.addAttribute("convYYMM3", convYYMM);
		
		String setdata1 = interimSDWorkBasicLst.getSetdata1();
		String setdata2 = interimSDWorkBasicLst.getSetdata2();
		String setdata3 = interimSDWorkBasicLst.getSetdata3();
		String setdata4 = interimSDWorkBasicLst.getSetdata4();
		String setdata5 = interimSDWorkBasicLst.getSetdata5();
		
		String setdata = setdata1 + setdata2 +setdata3 + setdata4 + setdata5;		

		
		
		model.addAttribute("subj", subj);
		model.addAttribute("sdgicho", interimSDGichoList);
		model.addAttribute("sdwolhak", interimSDWolhakLst);
		model.addAttribute("sderr", interimSDErrAnalysis);
		model.addAttribute("jindo", interimSDJindoExpectLst);
		model.addAttribute("setdata", setdata);

		
		if ("C".equals(lang)){
			return "diagnosis/interim/interimPrintCha";
		}else if ("E".equals(lang)) {
			return "diagnosis/interim/interimPrintEng";
		}else if ("K".equals(lang)) {
			return "diagnosis/interim/interimPrintkor";
		}else{		
			String alertMsg = messageSourceAccesor.getMessage("Ippr.interim.MprList");
			model.addAttribute("message", alertMsg);
			model.addAttribute("mode", "close");
			return "alertAndRedirect";
		}
		
	}
	


}