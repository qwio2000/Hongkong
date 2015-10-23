/**
 * 
 */
package com.jeiglobal.hk.domain.center;

import lombok.Getter;

/**
 * 클래스명 : CenterTypeList.java
 *
 * 작성일 : 2015. 10. 22.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 센터타입 : 사업형태 + 관리형태 + 회비형태
 */
@Getter
public class CenterTypeList {
	private String jisaCD;
	private String deptType;
	private String memType;
	private String feeType;
	private String centerType;
	private String centerTypeName;
}
