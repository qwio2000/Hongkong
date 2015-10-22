package com.jeiglobal.hk.domain.diagnosis;

import lombok.Data;


public class DiagnosisDto {
	
	@Data
	public static class Diagnosis {
		
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
		private String omrHak;			
	}
	
	@Data
	public static class DiagnosisInputippr{
		private String memName;
		private String gradeNM;
		private String subjname;		
		private String inputdate;
		private String mBirthDay;
		private String gradeCD;
		private String yoil;
		private String studyNum;
		private String bookNum;
		private String jisaCD;
		private String deptCd;
	}
	
	@Data
	public static class DiagnosisTotMunGet{
		private int tot;
	}
	
	@Data
	public static class DiagnosisJDSys8070P{
		private String jungkey;
		private String jungdab;
		private String junghang;
	}
	
	
	@Data
	public static class DiagnosisOmrInsert{
		private String omrDate; 
		private String hkey; 
		private String kwamok; 
		private String rw;
		private String nOmr;		
		private String mFstName; 
		private String mLstName;
		private String skey;
		private String sName; 
		private String omrGrd; 
		private String omrHak; 
		private String omrBirth; 
		private String omrKind;		
		private String omrDay1;	
		private String omrDay2; 
		private String omrStudyNum; 
		private String omrBookNum;
		private String deptCD;
		private String jisaCD; 
		private String deptName; 
		private String workID;		
	}
	
	@Data
	public static class DiagnosisOmrChkG{
		private String munno;
		private String sset;
	}
	
	@Data  // 개인별 처방기록부 회원정보
	public static class DiagnosisOmrPrint{
		private String hkey;
		private String omrBirth;
		private String omrKind;
		private String omrKindNM;
		private String omrYoil;
		private String omrYoilNM;
		private String mName;
		private String omrDate;
		private String sname;
		private String omrGrd;
		private String omrHak;
		private String omrHakNM;
		private String regDate;
		private String deptCD;
		private String sp;
		private String spnm;
		private String omrPath;
		private String pan;
		private String bosetsu;
		private String kwamok;
	}
	
	@Data  // 개인별 처방기록부 회원정보 수학외
	public static class DiagnosisOmrPrintLang{
		private String hkey;
		private String omrBirth;
		private String omrKind;
		private String omrKindNM;
		private String omrYoil;
		private String omrYoilNM;
		private String mName;
		private String omrDate;
		private String sname;
		private String omrGrd;
		private String omrHak;
		private String omrHakNM;
		private String regDate;
		private String deptCD;
		private String sp;
		private String spnm;
		private String omrPath;
		private String pan;
		private String bosetsu;
		private String kwamok;
	}
	
	@Data  // 종합 성취도 수학 외 
	public static class DiagnosisRangeHlLang{
		private String hsung;
		private String hrange;
		private String hsprt;
	}
	
	
	
	@Data  // 개인별 처방기록부 오답내용
	public static class DiagnosisOdab{
		private String odab1;
		private String odab2;
		private String odab2NM;
		private String hakGubun;
		private String odabNM;
		private String odabSchool;
		private String odabGrp;		
	}
	
	@Data // 개인별 처방기록부 오답내용 수학 외
	public static class DiagnosisOdabLang{
		private String odab1;
		private String odab2;
		private String odabnm;
		private String odabschool;
		private String odabrange;
		private String sprt;
		private String cnt;
	}
	
	@Data  // 개인별 처방기록부 영역명가져오기
	public static class DiagnosisRangeAllGet{
		private String cnt;
		private String range1;
		private String range2;
		private String range3;
		private String range4;
		private String range5;
		private String range6;
		private String range7;
		private String range8;
		private String range9;
		
	}
	
	@Data  // 개인별 처방기록부 문항수
	public static class DiagnosisRange{
		private String tot1;
		private String r1;
		private String tot2;
		private String r2;
		private String tot3;
		private String r3;
		private String tot4;
		private String r4;
		private String tot5;
		private String r5;
		private String tot6;
		private String r6;
		private String tot7;
		private String r7;
		private String tot8;
		private String r8;
		private String tot9;
		private String r9;
		private String totAll;
		private String rAll;		
	}
	
	@Data  // 개인별 처방기록부 문항수 수학 외 
	public static class DiagnosisRangeGrpLang{
		private String tot1;
		private String r1;
		private String tot2;
		private String r2;
		private String tot3;
		private String r3;
		private String tot4;
		private String r4;
		private String tot5;
		private String r5;
		private String tot6;
		private String r6;
		private String tot7;
		private String r7;
		private String tot8;
		private String r8;
		private String tot9;
		private String r9;
		private String tot;
		private String jung;
		private String all1;
		private String all2;
		private String all3;
		private String all4;
		private String all5;
		private String all6;
		private String all7;
		private String all8;
		private String all9;		
	}
	
	
	
	@Data  // 학습내용별 분석
	public static class DiagnosisOdab12{
		private String odabNM;
		private String odab1;
		private String odab2;
		private String setList;
		private String odabGrp;
		
	}
	
	@Data  // 학습기능별분석
	public static class DiagnosisOdab2{
		private String dbdes;
		private String odab1;
		private String odab2;
		private String omrSet;
		private String odabGrp;
		
	}
	
	@Data  // 오답사례별 분석
	public static class DiagnosisOdab4{
		private String scode;
		private String odab1;
		private String odab2;
		private String odab_nm;
		private String setlist;
	}
	
	@Data  // 학습수준 분석기준
	public static class DiagnosisSooJun{
		private String silSu1;
		private String silSu2;
		private String silSu3;
		private String silSu4;
	}

	@Data  // 처방프로그램 월 가져오기
	public static class DiagnosisStartYYMM{
		private String ryYMM1;
		private String ryYMM2;
		private String ryYMM3;
		private String ryYMM4;
		private String ryYMM5;
		private String ryYMM6;
		private String ryYMM7;
		private String ryYMM8;
		private String ryYMM9;
		private String ryYMM10;
		private String ryYMM11;
		private String ryYMM12;		
	}
	@Data  // 처방프로그램 월 가져오기 수학 외 
	public static class DiagnosisStartYYMMLang{
		private String ryYMM1;
		private String ryYMM2;
		private String ryYMM3;
		private String ryYMM4;
		private String ryYMM5;
		private String ryYMM6;
		private String ryYMM7;
		private String ryYMM8;
		private String ryYMM9;
		private String ryYMM10;
		private String ryYMM11;
		private String ryYMM12;		
	}
	
	
	
	@Data  // 처방프로그램 진도 가져오기
	public static class DiagnosisJindo{
		private String ryy;
		private String rmm;
		private String rset;
		
	}
	@Data  // 처방프로그램 진도 가져오기 수학 외
	public static class DiagnosisJindoLang{
		private String ryy;
		private String rmm;
		private String rset1;
		private String rset21;
		private String rset2;
		private String rset22;
		
	}
	
	
	
	
	@Data  // 예상진도
	public static class DiagnosisNext{
		private String ryy;
		private String rmm;
		private String rweek;
		private String rset;
		private String ynm;		
	}
	
	@Data  // 예상진도 수학 외
	public static class DiagnosisNextLang{
		private String ryy;
		private String rmm;
		private String rweek;
		private String rsort;
		private String ryoil;		
		private String rkey;
		private String rset;
		private String rset2;
		private String ynm;
		private String ryoilnm;
	}
	
	
	
	
	
	
	
}
