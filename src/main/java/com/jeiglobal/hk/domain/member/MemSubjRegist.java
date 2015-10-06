package com.jeiglobal.hk.domain.member;

import java.util.*;

import lombok.*;

/**
 * 클래스명 : MemSubjRegist.java
 *
 * 작성일 : 2015. 10. 5.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemSubjRegist {
	
	private int idx;
	private String registYMD;
	private String memKey;
	private String subj;
	private String registGubunCD;
	private String mFstName;
	private String mLstName;
	private String mBirthDay;
	private String gradeCD;
	private String schoolName;
	private String mEmail;
	private String eContact;
	private String ePhone;
	private String gFstName;
	private String gLstName;
	private String city;
	private String stateCD;
	private String zip;
	private String addr;
	private String gEmail;
	private String gPhone;
	private String gCellPhone;
	private String registWhy;
	private String registWhyEtc;
	private String registHow;
	private String registHowEtc;
	private String remarks;
	private String fstVisitYMD;
	private String yoil;
	private String visitHours;
	private int weekNum;
	private int studyNum;
	private int bookNum;
	private String digGrade;
	private String empKey;
	private String deptCD;
	private String jisaCD;
	private Date regDate;
	private String regID;
	private Date updDate;
	private String updID;
	private int apmIdx;
}
