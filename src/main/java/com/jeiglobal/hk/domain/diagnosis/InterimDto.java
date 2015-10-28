package com.jeiglobal.hk.domain.diagnosis;

import lombok.Data;

public class InterimDto {
	@Data
	public static class InterimWolJinDo {

		private String subj;
		private String memkey;
		private String yy;
		private String mm;
		private String wk;
		private String wkseq;
		private String yoil;
		private String wbset;	
		private String setno;
		private String setques;
		private String setsubq;
		private int cntno;
	}
	
	@Data
	public static class InterimSDGichoList{	
		private String hkey;
		private String kwamok;
		private String SDYY;
		private String SDMM;
		private String mFstName;
		private String mLstName;
		private String registFstYMD;	
		private String registFnlYMD;
		private String dropFnlYMD;
		private String omrHak;
		private String omrBirth;	
		private String omrBookNum;	
		private String omrDay1;	
		private String deptCD;	
		private String skey;	
		private String sname;	
		private String wolhak;	
		private String regID;	
		private String regDate;	
		private String gradenm;	
		private String cyoilnm;	
		private String subjnm;	
		private String hakgigan;		
	}
}
