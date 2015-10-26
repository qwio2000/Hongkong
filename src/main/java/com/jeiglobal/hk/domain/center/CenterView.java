/**
 * 
 */
package com.jeiglobal.hk.domain.center;

import lombok.Getter;

/**
 * 클래스명 : CenterView.java
 *
 * 작성일 : 2015. 10. 13.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 :  센터 뷰 SP
 * 
 */
@Getter
public class CenterView {
	
	private String jisaCD;
	private String deptCD;
	private String deptName;
	private String deptType;
	private String memType;
	private String feeType;
	private String rtyType;
	private String openSubj;
	private String empKey;
	private String empFstName;
	private String empLstName;
	private String city;
	private String stateCD;
	private String email;
	private String phone;
	private String fax;
	private String zip;
	private String addr;
	private String contractDate;
	private String openDate;
	private String closeDate;
	private int contractTerm;
	private String oHoursStart;
	private String oHoursEnd;
	private String cHoursStart;
	private String cHoursEnd;
	private String statusCD;
	private int sortCD;
	private String groupCD;
	private String rangeCD;
	
	private String empName;
	private String deptTypeName;
	private String memTypeName;
	private String feeTypeName;
	private String rtyTypeName;
	private String statusName;
	
	private String addUserFlag;  // 사용자 등록 가능 여부
	private String openSubjFlag; // 상품 설정 여부
	private String hoursFlag;	// 운영시간 설정 여부
	
	
	
}
