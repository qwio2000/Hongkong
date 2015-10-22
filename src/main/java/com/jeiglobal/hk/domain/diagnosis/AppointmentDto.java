package com.jeiglobal.hk.domain.diagnosis;

import java.util.*;

import lombok.*;

public class AppointmentDto {
	@Data
	public static class Appointment {
		private int idx;
		private String type;
		private String apmRegistYMD;
		private String mFstName;
		private String mLstName;
		private String mBirthDay;
		private String gradeCD;
		private String gradeName;
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
		private String convPreferredYMD;
		private String preferredTimes;
		private String timeName;
		private String preferredNotes;
		private String apmStatusCD;
		private String subj;
		private String memKey;
		private String registYMD;
		private String freeDigYMD;
		private String deptCD;
		private String jisaCD;
		private String registWhy;
		private String registWhyEtc;
		private String registHow;
		private String registHowEtc;
		private Date regDate;
		private String regID;
		private Date updDate;
		private String updID;
	}
}
