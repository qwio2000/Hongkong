package com.jeiglobal.hk.domain.member;

import java.util.*;

import lombok.*;

/**
 * 클래스명 : MemMst.java
 *
 * 작성일 : 2015. 10. 1.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * globalbiz.MemMst 테이블
 */
@Data
public class MemMst {
	private String memKey;
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
	private Date regDate;
	private String regID;
	private Date updDate;
	private String updID;
}
