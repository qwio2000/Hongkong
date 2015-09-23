package com.jeiglobal.hk.domain.member;

import lombok.*;

/**
 * 클래스명 : MemberDto.java
 *
 * 작성일 : 2015. 9. 17.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
public class MemberDto {
	
	@Data
	public static class MemberSearch{
		private String centerName;
		private String centerCity;
		private String centerState;
		private String centerZipcode;
		private String memberStatus;
		private String lastName;
		private String firstName;
		private String homePhone;
		private String cellPhone;
		private String email;
		private String grade;
		private String subject;
		private String orderBy;
		private String direction;
		private String classDay;
	}
	
	@Data
	public static class MemberSearchInfo{
		private int rCnt;
		private String memGubun;
		private String memKey;
		private String mFstName;
		private String mLstName;
		private String gradeName;
		private String guardianName;
		private String gPhone;
		private String memSubjStr;
		private String statusCD;
		private String statusName;
		private String registFstYMD;
		private String dropFnlYMD;
		private String stateName;
		private String deptName;
		
	}
}
