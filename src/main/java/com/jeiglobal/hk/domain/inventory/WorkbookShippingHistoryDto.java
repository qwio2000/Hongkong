package com.jeiglobal.hk.domain.inventory;

import java.util.List;

import com.jeiglobal.hk.domain.inventory.WorkbookstatusDto.WorkbookStatusSetDungList;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 클래스명 : WorkbookShippingHistoryDto.java
 *
 * 작성일 : 2015. 11. 26.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */
public class WorkbookShippingHistoryDto {
	
	@Data
	public static class RestockHistory{
		private String mon;
		private String inoutsignymd;
		private String wbinoutcal;
		private String wbinoutship;
	
	}
	
	@Data
	public static class HistoryRestockpop{
		private String subj;
		private String subjname;
		private String inoutsignymd;
		private String inoutsignymdt;
		private String wbinoutship;
		private String rewbinoutship;
		private String totship;
	}
	
	@Data
	public static class RequestHistory{
		private String aidx;
		private String jisacd;
		private String deptcd; 
		private String subj; 
		private String subjname; 
		private String inoutreqymd; 
		private String inoutreqymdt; 
		private String userfstname; 
		private String inoutreqnote; 
		private String inoutcal; 
		private String inoutship; 
		private String inoutsignymd;
		private String inoutsignymdt;
		private String balance;
	}
	
	@Data
	public static class HistoryRequestpop{
		private String inoutreqymd;	
		private String inoutreqymdt;	
		private String subj;	
		private String subjname;	
		private String wbname;	
		private String wbinoutcal;	
		private String inoutship;	
		private String userfstname;	
		private String inoutsignymd;	
		private String inoutsignymdt;	
		private String inoutreqnote;
	}
	
	@Data
	public static class ShippingHistory{
		private String jisaCD;
		private String deptCD;
		private String centername;
		private String st;
		private String avgsubj;
		private List<ShippingHistoryDtlList> dtlList;
	}
	
	@Data
	@AllArgsConstructor
	public static class ShippingHistoryDtlList{
		private String mon;
		private String inoutsignymd;		
		private String wbinoutship;	
	}
	
	
}
