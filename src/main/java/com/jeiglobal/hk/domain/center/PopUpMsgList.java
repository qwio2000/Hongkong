/**
 * 
 */
package com.jeiglobal.hk.domain.center;

import java.util.Date;

import lombok.Getter;

/**
 * 클래스명 : PopUpMsgList.java
 *
 * 작성일 : 2015. 10. 28.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 팝업 메세지 관리
 */
@Getter
public class PopUpMsgList {
	private int idx;
	private String startYMD;
	private String endYMD;
	private String msgTitle;
	private String msg;
	private String jisaCD;
	private String stateCD;	
	private String stateName;
	private Date regDate;
	private String regID; 
		
}
