package com.jeiglobal.hk.service.diagnosis;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.diagnosis.DiagnosisDto;
import com.jeiglobal.hk.domain.diagnosis.DiagnosisDto.DiagnosisRangeHlLang;
import com.jeiglobal.hk.repository.diagnosis.DiagnosisRepository;
import com.jeiglobal.hk.utils.CommonUtils;


@Service
public class DiagnosisService {

	@Autowired
	private DiagnosisRepository diagnosisRepository;
	
	public List<DiagnosisDto.Diagnosis> getDiagnosis(int page, int pagecnt, String JisaCD, String DeptCd, String Status, String LastName, String FirstName, String HomePhone, String CellPhone, String Email, String Grade, String Subject) {
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("pagecnt", pagecnt);
		map.put("JisaCD", JisaCD);
		map.put("DeptCd", DeptCd);

		map.put("Status", Status);
		map.put("LastName", LastName);
		map.put("FirstName", FirstName);
		map.put("HomePhone", HomePhone);
		map.put("CellPhone", CellPhone);
		map.put("Email", Email);
		map.put("Grade", Grade);
		map.put("Subject", Subject);
		
		return diagnosisRepository.findDiagnosis(map);
	}
	
	
	public DiagnosisDto.DiagnosisInputippr getDiagnosisInputippr(String JisaCD, String memKey, String subj, String freejindan){
		Map<String, Object> map = new HashMap<>();
		map.put("JisaCD", JisaCD);		
		map.put("memKey", memKey);		
		map.put("subj", subj);
		map.put("freejindan", freejindan);
		
		return diagnosisRepository.findDiagnosisIppr(map);
		
		
	}
	
	
	public DiagnosisDto.DiagnosisTotMunGet getDiagnosisTotMunGet(String jisaCD, String smaster, String subjname, String leveldung){
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("smaster", smaster);		
		map.put("subjname", subjname);
		map.put("leveldung", leveldung);
		
		return diagnosisRepository.findDiagnosisTotMunGet(map);
		
	}
	
	
	public List<DiagnosisDto.DiagnosisJDSys8070P> getDiagnosisJDSys8070P(String jisaCD, String smaster, String subjname, String leveldung){
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("smaster", smaster);		
		map.put("subjname", subjname);
		map.put("leveldung", leveldung);
		
		return diagnosisRepository.findDiagnosisJDSys8070P(map);
		
	}
	

	public Map<String, String> addDiagnosisOmrGicho(DiagnosisDto.DiagnosisOmrInsert omrInsert) throws ParseException{
		if (omrInsert.getMFstName().length() > 20 ){
			omrInsert.setMFstName(omrInsert.getMFstName().substring(0,20));
		}
		if (omrInsert.getMLstName().length() > 20 ){
			omrInsert.setMLstName(omrInsert.getMLstName().substring(0,20));
		}
		omrInsert.setOmrBirth(CommonUtils.changeDateFormat("MM/dd/yyyy", "yyyy-MM-dd", omrInsert.getOmrBirth()));
		return diagnosisRepository.findDiagnosisOmrGicho(omrInsert);
		
	}
	
	public List<DiagnosisDto.DiagnosisOmrChkG> getDiagnosisOmrChkG(String jisaCD, String subjname, String leveldung, String testType){
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("subjname", subjname);		
		map.put("leveldung", leveldung);
		map.put("testType", testType);
		
		return diagnosisRepository.findDiagnosisOmrChkG(map);
		
	}

	
	public String addDiagnosisOmrOdab(String jisaCD, String omrDate,
			String hkey, String kwamok, String omrGrd, String[] munchkarrer,
			String omrKind) {
		String mun = "";
		String chk = "";
		String omrOdabOK = "";
		
		Map<String, Object> map = new HashMap<>();
			map.put("jisaCD", jisaCD);		
			map.put("omrDate", omrDate);		
			map.put("hkey", hkey);
			map.put("kwamok", kwamok);
			map.put("omrGrd", omrGrd);
			
		for (int i = 0; i < munchkarrer.length; i++) {
			String[] splitArray = munchkarrer[i].split("\\|"); 
			mun = splitArray[0];					
			if((splitArray.length) >= 2){
				chk = splitArray[1];
			}else{
				chk = "";
			}
			
			map.put("mun", mun);
			map.put("chk", chk);	
			if( ("G").equals(CommonUtils.RightString(kwamok,1))) {   // 한글
				map.put("OmrKind", omrKind);
				omrOdabOK = diagnosisRepository.findDiagnosisOmrOdabG(map);
			}else{
				omrOdabOK =  diagnosisRepository.findDiagnosisOmrOdab(map);
			}
		}
		return omrOdabOK;
	}


	public String addDiagnosisOmrBan(String jisaCD, String omrDate,
			String hkey, String kwamok, String rw, String nOmr, String omrGrd,
			String omrHak, String omrKind, String omrDay1, String omrBirth,
			String omrSetCnt, String omrWeekCnt, String omrDay2, String workID) {

		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("omrDate", omrDate);		
		map.put("hkey", hkey);
		map.put("kwamok", kwamok);
		map.put("rw", rw);
		map.put("nOmr", nOmr);
		map.put("omrGrd", omrGrd);
		map.put("omrHak", omrHak);
		map.put("omrKind", omrKind);
		map.put("omrDay1", omrDay1);
		map.put("omrBirth", omrBirth);
		map.put("omrSetCnt", omrSetCnt);
		map.put("omrWeekCnt", omrWeekCnt);
		map.put("omrDay2", omrDay2);
		map.put("workID", workID);
		
		return diagnosisRepository.findDiagnosisOmrBan(map);
	}

	/** 개인별 처방기록부 **/
		//회원 기초정보
		public DiagnosisDto.DiagnosisOmrPrint getDiagnosisOmrPrint(String jisa, String omrdate,
				String memKey, String subj, String mujin, String lang) {
			
				Map<String, Object> map = new HashMap<>();
				map.put("jisa", jisa);		
				map.put("omrdate", omrdate);		
				map.put("memKey", memKey);
				map.put("subj", subj);
				map.put("mujin", mujin);
				map.put("lang", lang);
				
				return diagnosisRepository.findDiagnosisOmrPrint(map);
		}
		
		//회원 기초정보 수학외
		public DiagnosisDto.DiagnosisOmrPrintLang getDiagnosisOmrPrintLang(String jisa, String omrdate,
				String memKey, String subj, String lang, String mujin) {
			
				Map<String, Object> map = new HashMap<>();
				map.put("jisa", jisa);		
				map.put("omrdate", omrdate);		
				map.put("memKey", memKey);
				map.put("subj", subj);
				map.put("lang", lang);
				map.put("mujin", mujin);				
				
				return diagnosisRepository.findDiagnosisOmrPrintLang(map);
		}
	
	
		//오답내용
		public List<DiagnosisDto.DiagnosisOdab> getDiagnosisOdab(String jisa, String omrdate,
				String memKey, String subj, String mujin, String lang, String gubun) {
	
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("mujin", mujin);
			map.put("lang", lang);
			map.put("gubun", gubun);
			
			return diagnosisRepository.findDiagnosisOdab(map);		
		}
		//오답내용 수학 외
		public List<DiagnosisDto.DiagnosisOdabLang> getDiagnosisOdabLang(String jisa, String omrdate,
				String memKey, String subj, String mujin) {
	
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("mujin", mujin);
		
			
			return diagnosisRepository.findDiagnosisOdabLang(map);		
		}
		

		//영역별 분석 항목
		public DiagnosisDto.DiagnosisRangeAllGet getDiagnosisRangeAllGet(String jisa,
				String subj, String omrGrd, String omrPath, String lang) {
				Map<String, Object> map = new HashMap<>();
				map.put("jisa", jisa);		
				map.put("subj", subj);		
				map.put("omrGrd", omrGrd);
				map.put("omrPath", omrPath);
				map.put("lang", lang);
			
			return diagnosisRepository.findDiagnosisRangeAllGet(map);		
		}

		//영역별 분석 문항
		public DiagnosisDto.DiagnosisRange getDiagnosisRange(String jisa, String omrdate,
				String memKey, String subj, String mujin, String lang) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("mujin", mujin);
			map.put("lang", lang);
			return diagnosisRepository.findDiagnosisRange(map);		
		}
		
		//영역별 분석 문항 수학외
		public DiagnosisDto.DiagnosisRangeGrpLang getDiagnosisRangeGrpLang(String jisa, String omrdate,
				String memKey, String subj, String mujin) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("mujin", mujin);
			return diagnosisRepository.findDiagnosisRangeGrpLang(map);		
		}
		
		


		public List<DiagnosisDto.DiagnosisOdab12> getDiagnosisOdab12(String jisa, String omrdate,
				String memKey, String subj, String omrGrd, String omrKind,
				String mujin, String lang) {
			
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("omrGrd", omrGrd);
			map.put("omrKind", omrKind);
			map.put("mujin", mujin);
			map.put("lang", lang);
			return diagnosisRepository.findDiagnosisOdab12(map);	
		}


		public List<DiagnosisDto.DiagnosisOdab2> getDiagnosisOdab2(String jisa,
				String omrdate, String memKey, String subj, String mujin,
				String lang) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("mujin", mujin);
			map.put("lang", lang);
			return diagnosisRepository.findDiagnosisOdab2(map);	
		}


		public List<DiagnosisDto.DiagnosisOdab4> getDiagnosisOdab4(String jisa,
				String omrdate, String memKey, String subj, String omrGrd,
				String omrKind, String mujin, String lang) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("omrGrd", omrGrd);
			map.put("omrKind", omrKind);
			map.put("mujin", mujin);
			map.put("lang", lang);
			return diagnosisRepository.findDiagnosisOdab4(map);	
		}


		public DiagnosisDto.DiagnosisSooJun getDiagnosisSooJun(String jisa, String omrdate,
				String memKey, String subj, String omrKind, String omrGrd,
				String omrHak, String omrBirth, String omrPath, String lang) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("omrKind", omrKind);
			map.put("omrGrd", omrGrd);
			map.put("omrHak", omrHak);
			map.put("omrBirth", omrBirth);
			map.put("omrPath", omrPath);
			map.put("lang", lang);
			return diagnosisRepository.findDiagnosisSooJun(map);	
		}

		// 예상진도 월
		public DiagnosisDto.DiagnosisStartYYMM getDiagnosisStartYYMM(String jisa,
				String omrdate, String memKey, String subj, String omrPath,
				String lang) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("omrPath", omrPath);
			map.put("lang", lang);
			
			return diagnosisRepository.findDiagnosisStartYYMM(map);	
		}
		// 예상진도 월 수학 외
		public DiagnosisDto.DiagnosisStartYYMMLang getDiagnosisStartYYMMLang(String jisa,
				String omrdate, String memKey, String subj,
				String mujin) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("mujin", mujin);
			
			return diagnosisRepository.findDiagnosisStartYYMMLang(map);	
		}

		
		//예상 진도
		public List<DiagnosisDto.DiagnosisJindo> getDiagnosisJindo(String jisa,
				String omrdate, String memKey, String subj, String weeks,
				String mujin) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("weeks", weeks);
			map.put("mujin", mujin);
			
			return diagnosisRepository.findDiagnosisJindo(map);	
		}
		//예상 진도 수학 외
		public List<DiagnosisDto.DiagnosisJindoLang> getDiagnosisJindoLang(String jisa,
				String omrdate, String memKey, String subj, String weeks,
				String mujin) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("weeks", weeks);
			map.put("mujin", mujin);
			
			return diagnosisRepository.findDiagnosisJindoLang(map);	
		}
		


		public List<DiagnosisDto.DiagnosisNext> getDiagnosisNext(String jisa,
				String omrdate, String memKey, String subj, String mujin) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("mujin", mujin);
			
			return diagnosisRepository.findDiagnosisNext(map);	
		}
		
		public List<DiagnosisDto.DiagnosisNextLang> getDiagnosisNextLang(String jisa,
				String omrdate, String memKey, String subj, String lang, String mujin) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("lang", lang);
			map.put("mujin", mujin);
			
			return diagnosisRepository.findDiagnosisNextLang(map);	
		}
		


		public DiagnosisDto.DiagnosisRangeHlLang getDiagnosisRangeHlLang(String jisa,
				String omrdate, String memKey, String subj, String mujin) {
			Map<String, Object> map = new HashMap<>();
			map.put("jisa", jisa);		
			map.put("omrdate", omrdate);		
			map.put("memKey", memKey);
			map.put("subj", subj);
			map.put("mujin", mujin);			
			
			return diagnosisRepository.findDiagnosisRangeHlLang(map);	
		}



		

		



	
	/** //개인별 처방기록부 **/

}
