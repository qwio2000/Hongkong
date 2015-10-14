package com.jeiglobal.hk.domain.member;

import java.util.*;

import lombok.*;

/**
 * 클래스명 : MemAppointment.java
 *
 * 작성일 : 2015. 10. 14.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Data
public class MemAppointment {
	private int idx;
	private String apmRegistYMD;
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
	private String preferredYMD;
	private String preferredTimes;
	private String preferredNotes;
	private String apmStatusCD;
	private String subj;
	private String memKey;
	private String registYMD;
	private String freeDigYMD;
	private String deptCD;
	private String jisaCD;
	private Date regDate;
	private String regID;
	private Date updDate;
	private String updID;
}
