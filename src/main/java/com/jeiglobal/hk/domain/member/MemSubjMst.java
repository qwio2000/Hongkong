package com.jeiglobal.hk.domain.member;

import java.util.*;

import lombok.*;

/**
 * 클래스명 : MemSubjMst.java
 *
 * 작성일 : 2015. 10. 1.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * globalbiz.MemSubjMst 테이블
 */
@Data
public class MemSubjMst {
	private String memKey;
	private String subj;
	private String statusCD;
	private String memName;
	private String yoil;
	private String studyNum;
	private String bookNum;
	private String digGrade;
	private String registFstYMD;
	private String registFnlYMD;
	private String dropFnlYMD;
	private String expireYMD;
	private String feeFnlYMD;
	private String yoilChgYMD;
	private String studyNumChgYMD;
	private String bookNumChgYMD;
	private String befoYoil;
	private String befoStudyNum;
	private String befoBookNum;
	private String empKey;
	private String deptCD;
	private String jisaCD;
	private Date regDate;
	private String regID;
	private Date updDate;
	private String updID;

}
