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
		private String shipfreq;
		private String nextship;
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
	public static class WorkbookStatusSetList{
		private String jisaCD;
		private String deptCD;
		private String alllist;
		private List<WorkbookStatusSetDungList> dungList;
		
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

	
}
