/**
 * 
 */
package com.jeiglobal.hk.domain.center;

import java.util.Date;

import lombok.Getter;

/**
 * 클래스명 : MemFeeFreeTermList.java
 *
 * 작성일 : 2015. 10. 27.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 입회비 면제 구간 리스트	
 */
@Getter
public class MemFeeFreeTermList {
	private int idx;
	private String startYMD;
	private String endYMD;
	private String freeTitle;
	private String freeType;
	private String jisaCD;
	private String stateCD;
	private String stateName;
	private Date regDate;
	private String regID;
	private String regDateConv;
	private String freeTypeName;
	private String delFlag; // 삭제 가능 여부 
	
}
