package com.jeiglobal.hk.domain.menu;

import java.sql.Timestamp;

import lombok.*;

@Data
public class GlobalMenu {

	private Long mIdx;
	private Long mParentIdx;
	private String mJisaCD;
	private String mEmpKeyLvCD;
	private String mDepMngCD;
	private String mMenuName;
	private String mMenuLink;
	private String mAntPattern;
	private String mCon;
	private int mSort;
	private String mMenuCode;
	private String mHasChildren;
	private int mDepth;
	private Long m1;
	private Long m2;
	private Long m3;
	private Long m4;
	private Long m5;
	private Long m6;
	private Long m7;
	private Long m8;
	private Long m9;
	private Timestamp mRegDate;
	private Timestamp mUpdate;
	private String mUseState;
}
