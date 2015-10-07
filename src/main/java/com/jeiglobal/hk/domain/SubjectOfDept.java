package com.jeiglobal.hk.domain;

import lombok.*;

/**
 * 클래스명 : SubjectOfDept.java
 *
 * 작성일 : 2015. 10. 1.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 가맹점이 취급하는 과목 정보
 */
@Data
public class SubjectOfDept {
	
	private String jisaCD;
	private String deptCD;
	private String subj;
	private int studyNum;
	private int bookNum;
	private int monthNum;
	private String digYN;
	private int sortCD;
}
