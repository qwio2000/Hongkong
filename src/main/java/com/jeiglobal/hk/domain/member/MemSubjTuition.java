package com.jeiglobal.hk.domain.member;

import java.util.*;

import lombok.*;

/**
 * 클래스명 : MemSubjTuition.java
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
public class MemSubjTuition {
	
	private int idx;
	private String feeYMD;
	private String memKey;
	private String subj;
	private String memName;
	private String feeGubunCD;
	private String feeKindCD;
	private String freeType;
	private int registFee;
	private int sectionFee;
	private int monthFee;
	private int longFee;
	private int totalFee;
	private String expireYMD;
	private int bookNum;
	private int weekNum;
	private int monthNum;
	private String feeUnit;
	private String fstVisitYMD;
	private String empKey;
	private String deptCD;
	private String jisaCD;
	private Date regDate;
	private String regID;
}
