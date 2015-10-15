package com.jeiglobal.hk.domain.member;

import java.util.*;

import lombok.*;

/**
 * 클래스명 : MemCommentCall.java
 *
 * 작성일 : 2015. 10. 15.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Data
public class MemCommentCall {
	private int idx;
	private String callDate;
	private String memKey;
	private String memName;
	private String callNotes;
	private String jisaCD;
	private String deptCD;
	private Date regDate;
	private String regID;
}
