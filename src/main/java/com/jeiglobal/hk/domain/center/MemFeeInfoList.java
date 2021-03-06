/**
 * 
 */
package com.jeiglobal.hk.domain.center;

import lombok.Getter;

/**
 * 클래스명 : MemFeeInfoList.java
 *
 * 작성일 : 2015. 10. 14.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명	: 회비 정보 팝업
 */
@Getter
public class MemFeeInfoList {
	private String jisaCD;
	private String deptCD;
	private String deptType;
	private String memType;
	private String feeType;
	private String subj;
	private int bookNum;
	private int registFee;
	private int monthFee;
	private int sectionFee1;
	private int sectionFee2;
	private int sectionFee3;
	private int sectionFee4;
	private String feeUnit;
	private String feeUnitName;

}
