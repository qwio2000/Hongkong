package com.jeiglobal.hk.domain.diagnosis;

import lombok.Data;

/**
 * 
 * 클래스명 : AdjustmentDto.java
 *
 * 작성일 : 2015. 11. 4.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * [Diagnosis -> Adjustment] Controller
 */
public class AdjustmentDto {
	
	@Data
	public static class AdjustmentList{
		private String rowcnt;
		private String yy;
		private String mm;
		private String juset1;
		private String jusetDung1;
		private String juset1YN;		
		private String juset2;
		private String jusetDung2;
		private String juset2YN;
		private String juset3;
		private String jusetDung3;
		private String juset3YN;
		private String juset4;
		private String jusetDung4;
		private String juset4YN;
		private String juset5;
		private String jusetDung5;
		private String juset5YN;
		private String juset21;
		private String jusetDung21;
		private String juset21YN;
		private String juset22;
		private String jusetDung22;
		private String juset22YN;
		private String juset23;
		private String jusetDung23;
		private String juset23YN;
		private String juset24;
		private String jusetDung24;
		private String juset24YN;
		private String juset25;
		private String jusetDung25;
		private String juset25YN;
	}
	
	@Data
	public static class AdjustmentJindoSetList{
		private String dung;
		private String casKey;
		private String casNset;
	}
	
	@Data
	public static class AdjustmentinputSaveJson{
		private String jisaCD;
		private String memKey;	
		private String subj;		
		private String yy;		
		private String mm;		
		private String wk;		
		private String yoil;		
		private String bokGubun;	
		private String set1;		
		private String set2;		
		private String set3;		
		private String set4;		
		private String set5;		
		private String workID;	
	}	
}
