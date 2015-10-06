package com.jeiglobal.hk.domain.diagnosis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diagnosis {
	
	private int totalCnt;
	private int totalPageNum;
	private String mFirstName;
	private String mLastName;
	private String grade;
	private String subjname;
	private String gFstName;
	private String gLstName;
	private String ePhone;
	private String statusNM;	
	private String omrDate;	
	
}
