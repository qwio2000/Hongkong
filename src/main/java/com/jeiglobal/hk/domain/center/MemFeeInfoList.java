/**
 * 
 */
package com.jeiglobal.hk.domain.center;

import lombok.Data;

/**
 * 클래스명 : MemFeeInfoList.java
 *
 * 작성일 : 2015. 10. 14.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명	: 회비 정보 팝업
 */
@Data
public class MemFeeInfoList {
	private String jisaCD;
	private String deptCD;
	private String deptType;
	private String memType;
	private String feeType;
	private String subj;
	private int bookNum;
	private int weekNum;
	private int registFee;
	private int monthFee;
	private int sectionFee;
	private String feeUnit;
	private String feeUnitName;

}
