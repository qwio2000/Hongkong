package com.jeiglobal.hk.domain.inventory;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * 클래스명 : WorkbookstatusDto.java
 *
 * 작성일 : 2015. 11. 4.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * [Inventory -> Workbookstatus] domain
 */

public class WorkbookstatusDto {
	@Data
	public static class WorkbookStatusMstList{
		private String jisaCD;
		private String deptCD;
		private String centeername;
		private String st;
		private String lastship;
		private String lastshipt;
		private String shipevery;
		private String nextship;
		private String nextshipt;
		
		private String promoitem;
		private String additionalworkbook;
		private List<WorkbookstatusDto.WorkbookStatusMstsubj> subj;
	}
	
	@Data
	public static class WorkbookStatusMstsubj{
		private String jisaCD;
		private String deptCD;
		private String subj;
		private String subjnm;
	}
	
	@Data
	public static class WorkbookInOutSubjList{
		private String subj;
		private String subjnm;
	}
	
	@Data
	public static class WorkbookStatusSetList{
		private String jisaCD;
		private String deptCD;
		private String alllist;
		private List<WorkbookStatusSetDungList> dungList;
		private String shipevery;
		
	}
	
	@Data
	@AllArgsConstructor
	public static class WorkbookStatusSetDungList{
		private String caskey;
		private String casset;
		private String wbset;
		private String wbgrade;
		private String wbname;
		private String stocqty;
		private String stableqty;		
	}

	@Data
	public static class IvnWorkBookInOutPrint{
		private String jisaCD;
		private String deptCD;
		private String subj;
		private String alllist;
		private List<IvnWorkBookInOutPrintDungList> dungList;	
	}
	
	@Data
	@AllArgsConstructor
	public static class IvnWorkBookInOutPrintDungList{
		private String caskey;
		private String casset;
		private String wbset;
		private String wbgrade;
		private String wbname;
		private String wbinoutcal;
		private String wbinoutship;		
	}
	
	@Data
	public static class WorkbookStatusInventorySet{
		private String inoutsignymd;
		private String inoutsignymdt;
		private String subj;	
		private String subjnm;	
		private String caskey;	
		private String wbname;	
		private String inoutreqcd;	
		private String inoutreqcdnm;
		private String wbstock;	
		private String wbinout;	
		private String balance;
	}
	
}
