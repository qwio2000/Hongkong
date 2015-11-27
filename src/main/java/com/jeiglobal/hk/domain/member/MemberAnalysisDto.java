package com.jeiglobal.hk.domain.member;

import java.util.*;

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
		private int subjBegin;
		private int subjNew;
		private int subjDrop;
		private int subjNet;
		private int subjEnd;
		private double subjNewRate;
		private double subjDropRate;
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
	
	@Data
	public static class SubjectReport{
		private String subj;
		private String subjName;
		private String subjShortName;
		private int prevMgMM01;
		private int prevMgMM02;
		private int prevMgMM03;
		private int prevMgMM04;
		private int prevMgMM05;
		private int prevMgMM06;
		private int prevMgMM07;
		private int prevMgMM08;
		private int prevMgMM09;
		private int prevMgMM10;
		private int prevMgMM11;
		private int prevMgMM12;
		private int mgMM01;
		private int mgMM02;
		private int mgMM03;
		private int mgMM04;
		private int mgMM05;
		private int mgMM06;
		private int mgMM07;
		private int mgMM08;
		private int mgMM09;
		private int mgMM10;
		private int mgMM11;
		private int mgMM12;
	}
	
	@Data
	public static class SubjectReportBottom{
		private String mgYYMM;
		private String deptCD;
		private String deptName;
		private String stateName;
		private String subjReport;
		private int totEnd;
		private List<SubjectReportBottomSub> subs;
		private String[] splitAry;
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class SubjectReportBottomSub{
		private String mgYYMM;
		private String deptCD;
		private String subjReport;
		private int totEnd;
		private String[] splitAry;
	}
	
	@Data
	@NoArgsConstructor
	public static class DropAnalysis{
		private String deptCD;
		private String deptName;
		private Integer dropCnt01;
		private Integer dropCnt02;
		private Integer dropCnt03;
		private Integer dropCnt04;
		private Integer dropCnt05;
		private Integer dropCnt06;
		private Integer dropCnt07;
		private Integer dropCnt08;
		private Integer dropCnt09;
		private Integer dropCnt10;
		private Integer totalDrop;
		
		public DropAnalysis(String deptCD, String deptName, Integer dropCnt01, Integer dropCnt02, Integer dropCnt03, Integer dropCnt04, Integer dropCnt05, Integer dropCnt06, Integer dropCnt07, Integer dropCnt08, Integer dropCnt09, Integer dropCnt10){
			this.deptCD = deptCD;
			this.deptName = deptName;
			this.dropCnt01 = dropCnt01;
			this.dropCnt02 = dropCnt02;
			this.dropCnt03 = dropCnt03;
			this.dropCnt04 = dropCnt04;
			this.dropCnt05 = dropCnt05;
			this.dropCnt06 = dropCnt06;
			this.dropCnt07 = dropCnt07;
			this.dropCnt08 = dropCnt08;
			this.dropCnt09 = dropCnt09;
			this.dropCnt10 = dropCnt10;
			this.totalDrop = dropCnt01 + dropCnt02 + dropCnt03 + dropCnt04 + dropCnt05 + dropCnt06 + dropCnt07 + dropCnt08 + dropCnt09 + dropCnt10;
		}
	}                  
	                   
	@Data
	@NoArgsConstructor
	public static class DropAnalysisPop{
		private String jisaCD;
		private String month;
		private String monthName;
		private Integer dropCnt01;
		private Integer dropCnt02;
		private Integer dropCnt03;
		private Integer dropCnt04;
		private Integer dropCnt05;
		private Integer dropCnt06;
		private Integer dropCnt07;
		private Integer dropCnt08;
		private Integer dropCnt09;
		private Integer dropCnt10;
		private Integer totalDrop;
		
		public DropAnalysisPop(String jisaCD, String month, String monthName, Integer dropCnt01, Integer dropCnt02, Integer dropCnt03, Integer dropCnt04, Integer dropCnt05, Integer dropCnt06, Integer dropCnt07, Integer dropCnt08, Integer dropCnt09, Integer dropCnt10){
			this.jisaCD = jisaCD;
			this.month = month;
			this.monthName = monthName;
			this.dropCnt01 = dropCnt01;
			this.dropCnt02 = dropCnt02;
			this.dropCnt03 = dropCnt03;
			this.dropCnt04 = dropCnt04;
			this.dropCnt05 = dropCnt05;
			this.dropCnt06 = dropCnt06;
			this.dropCnt07 = dropCnt07;
			this.dropCnt08 = dropCnt08;
			this.dropCnt09 = dropCnt09;
			this.dropCnt10 = dropCnt10;
			this.totalDrop = dropCnt01 + dropCnt02 + dropCnt03 + dropCnt04 + dropCnt05 + dropCnt06 + dropCnt07 + dropCnt08 + dropCnt09 + dropCnt10;
		}
	}                  
	
}                      
	                   
