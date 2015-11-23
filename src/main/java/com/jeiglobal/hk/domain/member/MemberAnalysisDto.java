package com.jeiglobal.hk.domain.member;

import lombok.*;

/**
 * 
 * 클래스명 : MemberAnalysisDto.java
 *
 * 작성일 : 2015. 11. 2.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
public class MemberAnalysisDto {
	
	@Data
	public static class MemberAnalysisByGrade{
		private String dtlCD;
		private String dtlCDNM;
		private int countOfGrades;
		private double ratio;
	}
	
	@Data
	public static class MemberByMonthFA{
		private String mgYY;
		private String mgMM;
		private String displayYYMM;
		private int memBegin;
		private int memNew;
		private int memDrop;
		private int memNet;
		private int memEnd;
		private double memNewRate;
		private double memDropRate;
	}
	
	@Data
	public static class MemberBySubject{
		private String subj;
		private int subjEnd;
		private double subjRatio;
		private int subjEndSum;
	}
	
}
	
