package com.jeiglobal.hk.domain;

import java.util.*;

import lombok.*;

/**
 * 클래스명 : PopUpMsgGroup.java
 *
 * 작성일 : 2015. 11. 20.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Data
public class PopUpMsgGroup {
	private int  idx;
	private String startYMD;
	private String endYMD;
	private String msgTitle;
	private String msg;
	private String jisaCD;
	private String stateCD;
	private String stateName;
	private Date regDate;
	private String regID;
	private Date updDate;
	private String updID;
}
