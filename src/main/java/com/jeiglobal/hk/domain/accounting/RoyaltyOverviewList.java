/**
 * 
 */
package com.jeiglobal.hk.domain.accounting;

import lombok.Getter;

/**
 * 클래스명 : RoyaltyOverviewList.java
 *
 * 작성일 : 2015. 11. 9.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@Getter
public class RoyaltyOverviewList {
	
	private String mgYYMM;
	private String jisaCD;
	private String deptCD;	
	private int memRegistFee;
	private int memSectionFee;
	private int memMonthFee;
	private int MemFee;
	private int memRoyaltyRate;
	private int memRoyalty;
	private int itemCharge;
	private int freightCharge;
	private int lateFee;
	private int otherCharge;
	private int royalty;
	private int prevBalance;
	private int payment;
	private int currBalance;
	private int totalCharge;
	private String payInDate;
	private String payInState;
	private String deptType;
	private String memType;
	private String feeType;
	private String rtyType;
	private String deptName;
	private String mgYY;
	private String mgMM;
	private String subj;
	private int subjBegin;
	private int subjNew;
	private int subjDrop;
	private int subjNet;
	private int subjEnd;
	private String stateName;	
	private String feeUnitNM;
	private String mgMMName;
	

}
