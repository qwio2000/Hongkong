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
		private String sdyy;
		private String sdmm;
		private String mfstname;
		private String mlstname;
		private String registfstymd;	
		private String registfnlymd;
		private String dropfnlymd;
		private String omrhak;
		private String omrbirth;	
		private String omrbooknum;	
		private String omrday1;	
		private String deptcd;	
		private String skey;	
		private String sname;	
		private String wolhak;	
		private String regid;	
		private String regdate;	
		private String gradenm;	
		private String cyoilnm;	
		private String subjnm;	
		private String hakgigan;		
	}
	
	@Data
	public static class InterimSDWolhakLst{
		private String jisacd;
		private String memkey;
		private String subj;
		private String sdyy;
		private String sdmm;
		private String sdwk;
		private String sdsort;
		private String sdcyoil;
		private String sdset;
		private String itemtot;
		private String errtot;
		private String pcnt;
		private String ed;
		private String yetext;
		private String yetextlen;
	}
}
