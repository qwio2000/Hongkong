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
		private String grade;
		private String subjname;		
		private String inputdate;
		private String mBirthDay;
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
	
	
	
}
