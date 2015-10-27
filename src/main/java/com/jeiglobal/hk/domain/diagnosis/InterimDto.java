package com.jeiglobal.hk.domain.diagnosis;

import lombok.Data;

public class InterimDto {
	@Data
	public static class InterimWolJinDo {

		private String subj;
		private String memkey;
		private String yy;
		private String mm;
		private String wk;
		private String wkseq;
		private String yoil;
		private String wbset;	
		private String setno;
		private String setques;
		private String setsubq;
		private int cntno;
	}
}
