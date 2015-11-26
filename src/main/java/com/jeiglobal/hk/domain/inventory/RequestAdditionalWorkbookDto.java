package com.jeiglobal.hk.domain.inventory;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 클래스명 : RequestAdditionalWorkbookDto.java
 *
 * 작성일 : 2015. 11. 24.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */
public class RequestAdditionalWorkbookDto {
	@Data
	public static class IvnWorkBookRequestAW{
		private String jisaCD;
		private String deptCD;
		private String subj;
		private String alllist;
		private String inoutreqnote;
		private List<IvnWorkBookRequestAWDungList> dungList;	
	}
	
	@Data
	@AllArgsConstructor
	public static class IvnWorkBookRequestAWDungList{
		private String caskey;
		private String casset;
		private String wbset;
		private String wbgrade;
		private String wbname;
		private String wbinoutcal;
		private String wbinoutship;		
	}
	
	@Data
	public static class ShipToCerritos{
		private String aidx;	
		private String fidx;	
		private String jisacd;	
		private String deptcd;	
		private String subj;	
		private String subjnm;	
		private String inoutreqymd;
		private String inoutreqymdt;		
		private String caskey;	
		private String wbname;	
		private String wbinoutship;	
		private String inoutreqnote;
	}
	
	@Data
	public static class ShipToCerritosDate{		
		private String jisaCD;
		private String deptCD;
		private String inoutreqymd;
		private String inoutreqymdt;
	}

}
