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
		private String mgYY;
		private String mgMM;
		private String subj;
		private String gradeCD;
		private String gradeCDNM;
		private int membersCnt;
		private double membersRate;
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
	
	@Data
	public static class MemberByGrade{
		private String subj;
		private String wbGrade;
		private int subjCnt;
		private double subjRate;
	}
	
	@Data
	public static class MemberByMultiSubj{
		private String deptName;
		private String monthSale;
		private int multi1;
		private double multi1Rate;
		private int multi2;
		private double multi2Rate;
		private int multi3;
		private double multi3Rate;
		private int multi4;
		private double multi4Rate;
		private int multi5;
		private double multi5Rate;
		private int multi6;
		private double multi6Rate;
	}
	
	
}
	
