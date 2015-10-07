package com.jeiglobal.hk.domain.member;

import java.util.*;

import lombok.*;

/**
 * 클래스명 : MemSubjStudy.java
 *
 * 작성일 : 2015. 10. 5.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * globalbiz.MemSubjStudy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemSubjStudy {

	private String memKey;
	private String subj;
	private int studyNum;
	private int bookNum;
	private String yoil;
	private int yoilSeq;
	private int bookFlag;
	private String visitHours;
	private String empKey;
	private String deptCD;
	private String jisaCD;
	private Date regDate;
	private String regID;
	private Date updDate;
	private String updID;
}
