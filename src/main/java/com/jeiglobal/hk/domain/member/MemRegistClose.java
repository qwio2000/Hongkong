package com.jeiglobal.hk.domain.member;

import java.util.*;

import lombok.*;

/**
 * 클래스명 : DeptMst.java
 *
 * 작성일 : 2015. 10. 7.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * globalbiz.DeptMst
 */
@Data
public class MemRegistClose {

	private int idx;
	private String jisaCD;
	private String statusCD;
	private String closeReason;
	private Date regDate;
	private String regID;
	private Date updDate;
	private String updID;
}
