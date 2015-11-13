package com.jeiglobal.hk.domain.inventory;

import java.util.List;

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
		private String jisacd;
		private String deptcd;
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
		private String jisacd;
		private String deptcd;
		private String subj;
		private String subjnm;
	}
}
