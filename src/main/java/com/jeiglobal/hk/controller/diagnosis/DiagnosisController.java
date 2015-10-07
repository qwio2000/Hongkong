package com.jeiglobal.hk.controller.diagnosis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeiglobal.hk.domain.GradeOfSubject;
import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.diagnosis.DiagnosisDto;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.diagnosis.DiagnosisService;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.PageUtil;

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
		
	
	// 처방 조회
	@RequestMapping(value={"/fa/diagnosis/diagnosisSearch","/fa/diagnosis"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String diagnosisSerch(Model model, @ModelAttribute LoginInfo loginInfo) {
		String userType = loginInfo.getUserType();
		log.debug("Getting Diagnosis Page, UserType : {}", userType);
		model.addAttribute("memberStatuses", commonService.getCodeDtls("0008", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("grades", commonService.getCodeDtls("0003", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("subjects", commonService.getCodeDtls("0002", loginInfo.getJisaCD(), 1, "Y"));
		
		return "diagnosis/search";
	}
	
	// 처방 조회2
	@RequestMapping(value={"/fa/diagnosis/diagnosisSearch/search"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String diagnosisSerchFrom(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="10") int pagecnt, String status, String lastName, String firstName, String homePhone, String cellPhone, String email, String grade, String subject) {
		log.debug("Getting diagnosis Search List Page");
		
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosis");		
		model.addAttribute("headerScript", headerScript);	
		
		String userType = loginInfo.getUserType();
		log.debug("Getting Diagnosis Page, UserType : {}", userType);
		
		String jisaCD = loginInfo.getJisaCD();
		String deptCd = loginInfo.getDeptCD();		
		
		model.addAttribute("page", page);
		model.addAttribute("pagecnt", pagecnt);
		model.addAttribute("jisaCD", jisaCD);
		model.addAttribute("deptCd", deptCd);
		model.addAttribute("status", status);
		model.addAttribute("lastName", lastName);
		model.addAttribute("firstName", firstName);
		model.addAttribute("homePhone", homePhone);
		model.addAttribute("cellPhone", cellPhone);
		model.addAttribute("email", email);
		model.addAttribute("grade", grade);
		model.addAttribute("subject", subject);
		
		return "diagnosis/diagnosisSearch/list";		
	}
		
	// 처방 조회 3
	@RequestMapping(value={"/fa/diagnosis/diagnosisSearch/searchJson"}, method={RequestMethod.GET,RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> diagnosisSerchlistJson(Model model,int pageNum, int pagecnt, String jisaCD, String deptCd, String status, String lastName, String firstName, String homePhone, String cellPhone, String email, String grade, String subject) {
		
		Map<String, Object> diagnosisList = new HashMap<>();		
		
		List<DiagnosisDto.Diagnosis> diagnosis = diagnosisService.getDiagnosis(pageNum,pagecnt,jisaCD,deptCd,status,lastName,firstName,homePhone,cellPhone,email,grade,subject);
		int totalCnt = 0;
		if(diagnosis.size() > 0){
			totalCnt = diagnosis.get(0).getTotalCnt();
		}
		//페이징 처리에 사용하는 유틸 클래스
		PageUtil pageUtil = new	PageUtil(pageNum, totalCnt, PAGE_SIZE, PAGE_BLOCK_SIZE);

		diagnosisList.put("pageUtil", pageUtil);
		diagnosisList.put("page", diagnosis);
		System.out.println(diagnosis);		
		return diagnosisList;
	}
	
	
	//ippr 입력
	@RequestMapping(value={"/fa/diagnosis/diagnosis"}, method={RequestMethod.GET,RequestMethod.HEAD})	
	public String diagnosisdiagnosis() {
		log.debug("Getting diagnosis List Page");
		return "diagnosis/diagnosis";	
	}
	
	// ippr 정보 등급선택
	@RequestMapping(value={"/fa/diagnosis/ippr"}, method={RequestMethod.GET,RequestMethod.HEAD}) 
	public String diagnosisIppr(Model model, @ModelAttribute LoginInfo loginInfo, String memKey, String subj, String freejindan) {
		log.debug("Getting ippr Popup Page");
		
		String jisaCD = loginInfo.getJisaCD();
		
		DiagnosisDto.DiagnosisInputippr diagnosisInputippr = diagnosisService.getDiagnosisInputippr(jisaCD, memKey, subj, freejindan);	
		
		List<GradeOfSubject> gradeOfSubject = commonService.getGradeOfSubject(jisaCD, subj, "Y", "Y");
		
		if (diagnosisInputippr == null) {
			model.addAttribute("message", "No member");
			model.addAttribute("mode", "close");
			return "alertAndRedirect";
		}
		
		model.addAttribute("memKey", memKey);
		model.addAttribute("jisaCD", jisaCD);
		model.addAttribute("ippr", diagnosisInputippr);
		model.addAttribute("level", gradeOfSubject);
		
		return "diagnosis/diagnosis/ippr";	
	}
	
	// ippr 오답 입력
	@RequestMapping(value={"/fa/diagnosis/ipprinput"}, method={RequestMethod.POST,RequestMethod.HEAD})  
	public String diagnosisIpprinput(Model model,String memKey, String jisaCD, String memName, String grade, String subjname 
			, String leveldung, String inputdate, String mBirthDay, String testType, String readchk, String nomr) {
		log.debug("Getting ipprinput List Page");
		
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosis");		
		model.addAttribute("headerScript", headerScript);	
		
	
		model.addAttribute("memKey", memKey);
		model.addAttribute("jisaCD", jisaCD);
		model.addAttribute("memName", memName);
		model.addAttribute("grade", grade);
		model.addAttribute("subjname", subjname);
		model.addAttribute("leveldung", leveldung);
		model.addAttribute("inputdate", inputdate);
		model.addAttribute("mBirthDay", mBirthDay);
		model.addAttribute("testType", testType);
		model.addAttribute("readchk", readchk);
		model.addAttribute("nomr", nomr);
		
		return "diagnosis/diagnosis/ipprinput";	
	}

	
	@RequestMapping(value={"/fa/diagnosis/ipprinputJson"}, method={RequestMethod.POST,RequestMethod.HEAD})
	public String diagnosisIpprinputJson(Model model,String memKey, String jisaCD, String leveldung, String subjname, String mBirthDay) {

		String smaster = "NSys8";
		String jdmaster = "";
		
		if(CommonUtils.RightString(subjname,1).equals("M") ){
			smaster 	= "JDNSys8" ;	
			jdmaster  	= "JDNSys8070P";
		}
	
		DiagnosisDto.DiagnosisTotMunGet diagnosisTotMunGet = diagnosisService.getDiagnosisTotMunGet(jisaCD, smaster, subjname, leveldung);

		List<DiagnosisDto.DiagnosisJDSys8070P> diagnosisJDSys8070P = diagnosisService.getDiagnosisJDSys8070P(jisaCD, jdmaster, subjname, leveldung);
		
		int totalCnt = 0;
		
		if (diagnosisTotMunGet == null) {
			totalCnt = 0;
		}else{
			totalCnt = diagnosisTotMunGet.getTot();	
		}
		
		model.addAttribute("memKey", memKey);   //회원번호
		model.addAttribute("subjname", CommonUtils.RightString(subjname,1));    //과목
		model.addAttribute("leveldung", leveldung);  //등급
		model.addAttribute("totalCnt", totalCnt);      //문항수
		model.addAttribute("MBirthDay", mBirthDay);   //생년월일
		
		String returnurl = "";
		int iOdabCnt = 10;
		int iOdabFor = totalCnt/iOdabCnt;
		
		if( CommonUtils.RightString(subjname,1).equals("G") ) {   // 한글
			returnurl =  "diagnosis/diagnosis/JindoGInput";	
		}else if(CommonUtils.RightString(subjname,1).equals("M")){  //수학
			
			model.addAttribute("jdSys8070P", diagnosisJDSys8070P);
			model.addAttribute("iOdabCnt", iOdabCnt);
			model.addAttribute("iOdabFor", iOdabFor);
			model.addAttribute("leveldung", leveldung);
			
			returnurl = "diagnosis/diagnosis/JDJindoMInput";
			
		}else{ //그외 과목
			returnurl = "diagnosis/diagnosis/JindoMInput";
		}
		return returnurl;	
	}
	
	
	


		


}

