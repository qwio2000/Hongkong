package com.jeiglobal.hk.domain.diagnosis;

import lombok.Data;


public class DiagnosisDto {
	
	@Data
	public static class Diagnosis {
		
		private int totalCnt;
		private int totalPageNum;
		private String mFirstName;
		private String mLastName;
		private String grade;
		private String subjname;
		private String gFstName;
		private String gLstName;
		private String ePhone;
		private String statusNM;	
		private String omrDate;
		private String omrHak;			
	}
	
	@Data
	public static class DiagnosisInputippr{
		private String memName;
		private String gradeNM;
		private String subjname;		
		private String inputdate;
		private String mBirthDay;
		private String gradeCD;
		private String yoil;
		private String studyNum;
		private String bookNum;
		private String jisaCD;
		private String deptCd;
		
		
	}
	
	@Data
	public static class DiagnosisTotMunGet{
		private int tot;
	}
	
	@Data
	public static class DiagnosisJDSys8070P{
		private String jungkey;
		private String jungdab;
		private String junghang;
	}
	
	
	@Data
	public static class DiagnosisOmrInsert{
		private String omrDate; 
		private String hkey; 
		private String kwamok; 
		private String rw;
		private String nOmr;		
		private String mFstName; 
		private String mLstName;
		private String skey;
		private String sName; 
		private String omrGrd; 
		private String omrHak; 
		private String omrBirth; 
		private String omrKind;		
		private String omrDay1;	
		private String omrDay2; 
		private String omrStudyNum; 
		private String omrBookNum;
		private String deptCD;
		private String jisaCD; 
		private String deptName; 
		private String workID;		
	}
	
	@Data
	public static class DiagnosisOmrChkG{
		private String munno;
		private String sset;
	}
	
	@Data
	public static class DiagnosisOmrPrint{
		private String hkey;
		private String omrBirth;
		private String omrKindNM;
		private String omrYoil;
		private String omrYoilNM;
		private String mName;
		private String omrDate;
		private String sname;
		private String omrGrd;
		private String omrHak;
		private String omrHakNM;
		private String regDate;
		private String deptCD;
		private String sp;
		private String SPNM;
	}
	
}
