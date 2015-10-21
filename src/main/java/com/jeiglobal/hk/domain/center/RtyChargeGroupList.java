/**
 * 
 */
package com.jeiglobal.hk.domain.center;

import lombok.Getter;

/**
 * 클래스명 : RtyChargeGroupInfo.java
 *
 * 작성일 : 2015. 10. 21.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 * 
 */
@Getter
public class RtyChargeGroupList {

	private String jisaCD;
	private String rtyType;
	private int startCnt;
	private int endCnt;
	private int rtyRate;
	private double convOfRate;	// 로열티율 : 소수점 두자리   decimal(10,2)
	private String deptType;
	private String memType;
	private String feeType;
	private String rtyTypeName;	
}
