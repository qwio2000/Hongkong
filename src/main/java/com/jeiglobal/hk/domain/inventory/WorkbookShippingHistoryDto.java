package com.jeiglobal.hk.domain.inventory;

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
	
}
