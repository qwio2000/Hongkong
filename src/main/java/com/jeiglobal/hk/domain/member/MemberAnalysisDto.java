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
	
}
	
