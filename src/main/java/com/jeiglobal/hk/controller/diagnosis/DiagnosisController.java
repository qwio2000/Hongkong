package com.jeiglobal.hk.controller.diagnosis;

import java.text.ParseException;
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

import com.jeiglobal.hk.domain.DeptMst;
import com.jeiglobal.hk.domain.GradeOfSubject;
import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.diagnosis.DiagnosisDto;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.diagnosis.DiagnosisService;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.MessageSourceAccessor;
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
	
	@Autowired
	private MessageSourceAccessor messageSourceAccesor;
		
	
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
		
		DiagnosisDto.DiagnosisInputippr diagnosisInputippr = diagnosisService.getDiagnosisInputippr(jisaCD, memKey, subj, freejindan);	 //회원정보
		
		List<GradeOfSubject> gradeOfSubject = commonService.getGradeOfSubject(jisaCD, subj, "Y", "Y");   //등급정보
		
		if (diagnosisInputippr == null) {
			model.addAttribute("message", "No member");
			model.addAttribute("mode", "close");
			return "alertAndRedirect";
		}
		
		model.addAttribute("memKey", memKey);
		model.addAttribute("ippr", diagnosisInputippr);
		model.addAttribute("level", gradeOfSubject);
		
		return "diagnosis/diagnosis/ippr";	
	}
	
	// ippr 오답 입력
	@RequestMapping(value={"/fa/diagnosis/ipprinput"}, method={RequestMethod.POST,RequestMethod.HEAD})  
	public String diagnosisIpprinput(Model model, @ModelAttribute LoginInfo loginInfo,String memKey, String jisaCD, String deptCd, String memName, String gradeNM, String gradeCD,  String subjname 
			, String leveldung, String inputdate, String mBirthDay, String testType, String readchk, String nomr, String yoil, String studyNum, String bookNum) {
		log.debug("Getting ipprinput List Page");
		//header에 포함할 스크립트 
		//announcement를 추가했기 때문에 /public/js/announcement.js 를 header에 추가
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("diagnosis");		
		model.addAttribute("headerScript", headerScript);	
		
		String omrdate = CommonUtils.getCurrentYMD();  // 오늘 날짜
		DeptMst deptMst = commonService.getDeptMstByDeptCD(deptCd);
		String empKey = deptMst.getEmpKey();  // 원장번호
		String empName = deptMst.getEmpFstName()+" "+deptMst.getEmpLstName();  // 원장이름
		String userId = loginInfo.getUserId();		//작업자
	

		String yoil1 = "";
		String yoil2 = "";
		
		String[] yoils = yoil.split(",");
		for( int i = 0; i < yoils.length; i++ ){
			if( (i+1) == 1){
				yoil1	=  yoils[i]	;
			}else if((i+1) == 2){
				yoil2	=  yoils[i]	;
			}
		}
		
		model.addAttribute("omrdate", omrdate);  //처방일자		
		model.addAttribute("memKey", memKey);	//회원번호
		model.addAttribute("empKey", empKey);    //원장번호
		model.addAttribute("empName", empName);    //원장번호
		model.addAttribute("memName", memName);
		model.addAttribute("leveldung", leveldung);
		model.addAttribute("gradeCD", gradeCD);
		model.addAttribute("mBirthDay", mBirthDay);
		model.addAttribute("OmrKind", testType);
		model.addAttribute("studyNum", studyNum);
		model.addAttribute("bookNum", bookNum);
		model.addAttribute("deptCd", deptCd);   
		model.addAttribute("jisaCD", jisaCD);
		model.addAttribute("userId", userId);
		model.addAttribute("yoil1", yoil1);
		model.addAttribute("yoil2", yoil2);
		model.addAttribute("gradeNM", gradeNM);		
		model.addAttribute("subjname", subjname);
		model.addAttribute("leveldung", leveldung);
		model.addAttribute("inputdate", inputdate);
		model.addAttribute("testType", testType);
		model.addAttribute("readchk", readchk);
		model.addAttribute("nomr", nomr);
	
		return "diagnosis/diagnosis/ipprinput";	
	}

	
	@RequestMapping(value={"/fa/diagnosis/ipprinputJson"}, method={RequestMethod.POST,RequestMethod.HEAD})
	public String diagnosisIpprinputJson(Model model, String jisaCD, String leveldung, String subjname, String testType) {

		String smaster = "";
		String jdmaster = "";
		
		if(("M").equals(CommonUtils.RightString(subjname,1)) ){
			smaster 	= "JDNSys8" ;	
			jdmaster  	= "JDNSys8070P";
		}else{
			if(("3").equals(testType) && ( ("K").equals(CommonUtils.RightString(subjname,1)) || ("E").equals(CommonUtils.RightString(subjname,1)) 
			|| ("P").equals(CommonUtils.RightString(subjname,1))|| ("S").equals(CommonUtils.RightString(subjname,1))|| ("G").equals(CommonUtils.RightString(subjname,1))	) ){
				smaster 	= "NSys83" ;
			}else{
				smaster 	= "NSys8" ;
			}
		}
	
		DiagnosisDto.DiagnosisTotMunGet diagnosisTotMunGet = diagnosisService.getDiagnosisTotMunGet(jisaCD, smaster, subjname, leveldung);
				
		int totalCnt = 0;
		
		if (diagnosisTotMunGet == null) {
			totalCnt = 0;
		}else{
			totalCnt = diagnosisTotMunGet.getTot();	
		}
		
		model.addAttribute("subjname", CommonUtils.RightString(subjname,1));    //과목
		model.addAttribute("leveldung", leveldung);  //등급
		model.addAttribute("totalCnt", totalCnt);      //문항수
		
		String returnurl = "";
		int iOdabCnt = 0 ;
		int iOdabFor = 0 ;
		
		if( ("G").equals(CommonUtils.RightString(subjname,1))) { 
			
			List<DiagnosisDto.DiagnosisOmrChkG> diagnosisOmrChkG = diagnosisService.getDiagnosisOmrChkG(jisaCD, subjname, leveldung, testType);
			
			iOdabCnt = 5;
			iOdabFor = totalCnt/iOdabCnt;
			
			model.addAttribute("iOdabCnt", iOdabCnt);
			model.addAttribute("iOdabFor", iOdabFor);
			model.addAttribute("leveldung", leveldung);
			model.addAttribute("omrChkG", diagnosisOmrChkG);
			
		}else{
			iOdabCnt = 10;
			iOdabFor = totalCnt/iOdabCnt;
			
			model.addAttribute("iOdabCnt", iOdabCnt);
			model.addAttribute("iOdabFor", iOdabFor);
			model.addAttribute("leveldung", leveldung);
		}
		
		
		if( ("G").equals(CommonUtils.RightString(subjname,1))) {   // 한글
			returnurl =  "diagnosis/diagnosis/JindoGInput";	
		}else if(("M").equals(CommonUtils.RightString(subjname,1))){  //수학
			List<DiagnosisDto.DiagnosisJDSys8070P> diagnosisJDSys8070P = diagnosisService.getDiagnosisJDSys8070P(jisaCD, jdmaster, subjname, leveldung);			
			model.addAttribute("jdSys8070P", diagnosisJDSys8070P);			
			returnurl = "diagnosis/diagnosis/JDJindoMInput";
			
		}else{ //그외 과목		
			returnurl = "diagnosis/diagnosis/JindoInput";
		}
		return returnurl;	
	}
	
	
	
	// 처방 기초 정보 저장
	@RequestMapping(value={"/fa/diagnosis/ipprInputSave"}, method={RequestMethod.GET,RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> diagnosisIpprOmrGichoJson(Model model,DiagnosisDto.DiagnosisOmrInsert omrInsert ) throws ParseException {

		String alertMsg = "";
		String omrGichoisOK = diagnosisService.getDiagnosisOmrGicho(omrInsert);
		if ("N".equals(omrGichoisOK)) {
			alertMsg = messageSourceAccesor.getMessage("Ippr.OmrGicho.Insert.Error");
		}
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("alertMsg", alertMsg);
		map.put("omrGichoisOK", omrGichoisOK);
		
		return map;
	}
	
	// 오답 입력 저장
	@RequestMapping(value={"/fa/diagnosis/ipprOdabSave"}, method={RequestMethod.GET,RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> diagnosisIpprOdabSaveJson(Model model, String jisaCD, String omrDate, String hkey, String kwamok, String omrGrd, String munchk, String omrKind) {
		
		String alertMsg = "";
		String omrOdabOK = "";
		
		String[] munchkarrer = munchk.split("##");
		
		omrOdabOK = diagnosisService.addDiagnosisOmrOdab(jisaCD, omrDate, hkey, kwamok, omrGrd, munchkarrer, omrKind);
		
	
		
		
		if ("N".equals(omrOdabOK)) {
			alertMsg = messageSourceAccesor.getMessage("Ippr.Odab.Insert.Error");
		}
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("alertMsg", alertMsg);
		map.put("omrOmrOdabOK", omrOdabOK);
		
		return map;
	}
	
	// ippr 처방 분석
	@RequestMapping(value={"/fa/diagnosis/ipprOmrBan"}, method={RequestMethod.GET,RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> diagnosisIpprOmrBanJson(Model model, String jisaCD, String omrDate, String hkey, String kwamok, String rw, String nOmr, String omrGrd
			, String omrHak, String omrKind, String omrDay1, String omrBirth, String omrSetCnt, String omrWeekCnt, String omrDay2, String workID) {
		
		String alertMsg = "";
		String omrBanOK = "";
		
		omrBanOK = diagnosisService.addDiagnosisOmrBan(jisaCD, omrDate, hkey, kwamok, rw, nOmr, omrGrd, omrHak, omrKind, omrDay1, omrBirth, omrSetCnt, omrWeekCnt, omrDay2, workID);
		
		if ("N".equals(omrBanOK)) {
			alertMsg = messageSourceAccesor.getMessage("Ippr.Ban.Insert.Error");
		}
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("alertMsg", alertMsg);
		map.put("omrBanOK", omrBanOK);
		
		return map;
	}
	
	
	// ippr 처방 기록부 KM
	@RequestMapping(value={"/fa/diagnosis/OmrPrintJD"}, method={RequestMethod.GET,RequestMethod.HEAD})  
	public String diagnosisIpprOmrPrintKM(Model model, String jisa, String omrdate, String memKey, String subj, String mujin)  {
		log.debug("Getting OmrPrint List Page");
		String lang = "";
		int odabWidth = 22;
		int MaxOdabLine = 0;
		if ("EM".equals(subj)) {
			MaxOdabLine = 27;
		}else{
			MaxOdabLine = 26;
		}
		 
		//회원 기초정보
		DiagnosisDto.DiagnosisOmrPrint diagnosisOmrPrint = diagnosisService.getDiagnosisOmrPrint(jisa, omrdate, memKey, subj, mujin, lang);	 
		/* 오답내용 */
		List<DiagnosisDto.DiagnosisOdab> diagnosisOdabLeft = diagnosisService.getDiagnosisOdab(jisa, omrdate, memKey, subj, mujin, lang, "L");		
		List<DiagnosisDto.DiagnosisOdab> diagnosisOdabRight = diagnosisService.getDiagnosisOdab(jisa, omrdate, memKey, subj, mujin, lang, "R");

		String omrGrd = diagnosisOmrPrint.getOmrGrd();
		String omrPath = diagnosisOmrPrint.getOmrPath();
		String omrKind = diagnosisOmrPrint.getOmrKind();
		String omrHak = diagnosisOmrPrint.getOmrHak();
		String omrBirth = diagnosisOmrPrint.getOmrBirth();
		
		/* 영역별 분석 */
		//영역명가져오기
		DiagnosisDto.DiagnosisRangeAllGet diagnosisRangeAllGet = diagnosisService.getDiagnosisRangeAllGet(jisa, subj, omrGrd, omrPath, lang);
		//문항수
		DiagnosisDto.DiagnosisRange diagnosisRange = diagnosisService.getDiagnosisRange(jisa, omrdate, memKey, subj, mujin, lang);

		/* 오답내용 분석 */
		//학습내용별 분석
		List<DiagnosisDto.DiagnosisOdab12> diagnosisOdab12 = diagnosisService.getDiagnosisOdab12(jisa, omrdate, memKey, subj, omrGrd, omrKind, mujin, lang);
		//학습기능별 분석
		List<DiagnosisDto.DiagnosisOdab2> diagnosisOdab2 = diagnosisService.getDiagnosisOdab2(jisa, omrdate, memKey, subj, mujin, lang);
		//학습기능별 분석
		List<DiagnosisDto.DiagnosisOdab4> diagnosisOdab4 = diagnosisService.getDiagnosisOdab4(jisa, omrdate, memKey, subj, omrGrd, omrKind, mujin, lang);

		/* 학습 수준 분석 기준 */
		DiagnosisDto.DiagnosisSooJun diagnosisSooJun = diagnosisService.getDiagnosisSooJun(jisa, omrdate, memKey, subj, omrKind, omrGrd, omrHak, omrBirth, omrPath, lang);
		
		/* 처방프로그램 */
		// 월 가져오기
		DiagnosisDto.DiagnosisStartYYMM diagnosisStartYYMM = diagnosisService.getDiagnosisStartYYMM(jisa, omrdate, memKey, subj, omrPath, lang);
		// 진도 가져오기	
		List<DiagnosisDto.DiagnosisJindo> diagnosisJindo1 = diagnosisService.getDiagnosisJindo(jisa, omrdate, memKey, subj, "1", mujin);
		List<DiagnosisDto.DiagnosisJindo> diagnosisJindo2 = diagnosisService.getDiagnosisJindo(jisa, omrdate, memKey, subj, "2", mujin);
		List<DiagnosisDto.DiagnosisJindo> diagnosisJindo3 = diagnosisService.getDiagnosisJindo(jisa, omrdate, memKey, subj, "3", mujin);
		List<DiagnosisDto.DiagnosisJindo> diagnosisJindo4 = diagnosisService.getDiagnosisJindo(jisa, omrdate, memKey, subj, "4", mujin);
		List<DiagnosisDto.DiagnosisJindo> diagnosisJindo5 = diagnosisService.getDiagnosisJindo(jisa, omrdate, memKey, subj, "5", mujin);		
		/* 예상진도 */
		List<DiagnosisDto.DiagnosisNext> diagnosisNext = diagnosisService.getDiagnosisNext(jisa, omrdate, memKey, subj, mujin);
		
		
		
		model.addAttribute("odabWidth", odabWidth);	
		model.addAttribute("maxOdabLine", MaxOdabLine);
		
		model.addAttribute("omrgicho", diagnosisOmrPrint);	
		model.addAttribute("omrOdabLeft", diagnosisOdabLeft);
		model.addAttribute("omrOdabRight", diagnosisOdabRight);
		
		model.addAttribute("rangeAllGet", diagnosisRangeAllGet);
		model.addAttribute("range", diagnosisRange);	
		
		model.addAttribute("odab12", diagnosisOdab12);
		model.addAttribute("odab2", diagnosisOdab2);
		model.addAttribute("odab4", diagnosisOdab4);
		
		model.addAttribute("sooJun", diagnosisSooJun);
		
		model.addAttribute("startYYMM", diagnosisStartYYMM);
		model.addAttribute("jindo1", diagnosisJindo1);
		model.addAttribute("jindo2", diagnosisJindo2);
		model.addAttribute("jindo3", diagnosisJindo3);
		model.addAttribute("jindo4", diagnosisJindo4);
		model.addAttribute("jindo5", diagnosisJindo5);


		model.addAttribute("next", diagnosisNext);
		
		if ("EM".equals(subj)) {
			return "diagnosis/diagnosis/OmrPrintEM";	
		}else{
			return "diagnosis/diagnosis/OmrPrintKM";	
		}
		
	}
	
	


}

