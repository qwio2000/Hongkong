package com.jeiglobal.hk.domain.member;

import java.util.*;

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
		private int memAppIdx;
	}
	
	@Data
	public static class MemberRegistSearchInfo{
		private String memKey;
		private String memName;
		private String guardianName;
		private String address;
		private String city;
		private String phone;
		private String statusCD;
		private String statusName;
	}
	
	@Data
	public static class GuardianInfo{
		private String gFstName;
		private String gLstName;
		private String city;
		private String stateCD;
		private String zip;
		private String addr;
		private String gEmail;
		private String gPhone;
		private String gCellPhone;
	}
	
	@Data
	@AllArgsConstructor
	public static class MonthInfo{
		private String monthNum;
		private String monthStr;
	}
	
	@Data
	public static class RegistSubject{
		private String jisaCD;
		private String deptCD;
		private String subj;
		private int subjStudyNum;
		private int subjBookNum;
		private int subjMonthNum;
		private String subjDigYN;
		private int sortCD;
		private String memKey;
		private String statusCD;
		private String yoil;
		private String yoilName;
		private int studyNum;
		private int bookNum;
		private String visitHours;
		private String visitHoursName;
	}
	
	@Data
	public static class MemberReportInfo{
		private String memKey;
		private String mFstName;
		private String mLstName;
		private String mBirthDay;
		private String gradeCD;
		private String gradeName;
		private String schoolName;
		private String mEmail;
		private String eContact;
		private String ePhone;
		private String remarks;
		private Date regDate;
		private String statusCD;
		private String statusName;
		private List<MemberReportSubjInfo> memberReportSubjInfos;
		
	}
	
	@Data
	public static class MemberReportSubjInfo{
		private String memKey;
		private String subj;
		private String statusCD;
		private String yoil;
		private String yoilName;
		private String registFstYMD;
		private String registFnlYMD;
		private String convertRegistYMD;
		private String recentRegistFnlYMD;
		private String dropFnlYMD;
		private String convertDropYMD;
		private String visitHour;
		private String visitHourName;
		private String digYN;
		private String isCancle;
		private String jisaCD;
		private String omrDate;
	}
	
	@Data
	public static class MemberReportFreeDiagInfo{
		private String hkey;
		private String mFstName;
		private String mLstName;
		private String skey;
		private String sname;
		private String omrHak;
		private String omrHakName;
		private String omrBirth;
		private String schoolName;
		private String mEmail;
		private String eContact;
		private String ePhone;
		private String gFstName;
		private String gLstName;
		private String city;
		private String stateCD;
		private String stateName;
		private String zip;
		private String addr;
		private String gEmail;
		private String gPhone;
		private String gCellPhone;
		private String deptCD;
		private String jisaCD;
		private String deptName;
		private String registWhy;
		private String registWhyEtc;
		private String registHow;
		private String registHowEtc;
		private String memKey;
		private Date regDate;
		private String regID;
		private List<MemberReportFreeDiagSubjInfo> memberReportFreeDiagSubjInfos;
		
	}
	
	@Data
	public static class MemberReportFreeDiagSubjInfo{
		private String hkey;
		private String kwamok;
		private String omrDate;
		private String jisaCD;
		private String digYN;
	}
	
	@Data
	public static class MemberReportSubjStudyInfo{
		private String memKey;
		private String subj;
		private int studyNum;
		private int bookNum;
		private String yoil;
		private String yoilName;
		private String visitHours;
		private String visitHoursName;
	}
	/**
	 * 
	 * 클래스명 : MemberIpprInfo
	 *
	 * 작성일 : 2015. 10. 14.
	 *
	 * 작성자 : 전승엽(IT지원팀)
	 * 
	 * MemberReport => IPPR 전체 조회
	 */
	@Data
	public static class MemberIpprInfo{
		private String memKey;
		private String subj;
		private String omrDate;
		private String jisaCD;
		private String digYN;
	}
	/**
	 * 
	 * 클래스명 : MemberWorkbookInfo
	 *
	 * 작성일 : 2015. 10. 14.
	 *
	 * 작성자 : 전승엽(IT지원팀)
	 * 
	 * Workbook 정보
	 */
	@Data
	public static class MemberWorkbookInfo{
		private String memKey;
		private String mFstName;
		private String mLstname;
		private String gradeCD;
		private String gradeName;
		private List<MemberWorkbookSubjInfo> workbookSubjInfos;
	}
	
	/**
	 * 
	 * 클래스명 : MemberWorkbookSubjInfo
	 *
	 * 작성일 : 2015. 10. 14.
	 *
	 * 작성자 : 전승엽(IT지원팀)
	 * 
	 * Workbook 과목 정보
	 */
	@Data
	public static class MemberWorkbookSubjInfo{
		private String memKey;
		private String subj;
		private String yoil;
		private String yoilName;
		private String visitHours;
		private String visitHoursName;
		private String set1;
		private String setWbOutYMD1;
		private String set2;
		private String setWbOutYMD2;
		private String set3;
		private String setWbOutYMD3;
		private String set4;
		private String setWbOutYMD4;
		private String set5;
		private String setWbOutYMD5;
		private String set6;
		private String setWbOutYMD6;
		private String set7;
		private String setWbOutYMD7;
		private String set8;
		private String setWbOutYMD8;
		private String set9;
		private String setWbOutYMD9;
		private String set10;
		private String setWbOutYMD10;
	}
	
	@Data
	public static class MemberWeeklyScheduleInfo{
		private String visitHours;
		private String visitHoursName;
		private String memWeeklyInfo1;
		private String memWeeklyInfo2;
		private String memWeeklyInfo3;
		private String memWeeklyInfo4;
		private String memWeeklyInfo5;
		private String memWeeklyInfo6;
		private String memWeeklyInfo7;
		
	}
}
	
