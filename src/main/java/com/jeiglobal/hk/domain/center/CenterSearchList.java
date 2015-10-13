package com.jeiglobal.hk.domain.center;

import lombok.Data;

/**
 * Centers : 센터 검색 리스트 SP
 */
@Data
public class CenterSearchList {
	
	/**
	 * 레코드수
	 */
	private int rCnt;
	/**
	 * 페이지수
	 */
	private int pageNum;	
	
	private String jisaCD;
	private String deptCD;
	private String deptName;
	private String empName;
	private String phone;
	private String contractDate;
	private String openDate;
	private String closeDate;
	private String statusCD;
	private String stateName;
	private String userId;
	private int memCnt;
	private int memSubjCnt;
	private String statusName;
		
}
