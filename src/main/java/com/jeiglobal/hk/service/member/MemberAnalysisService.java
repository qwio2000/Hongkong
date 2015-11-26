package com.jeiglobal.hk.service.member;

import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.member.MemberAnalysisDto.MemberAnalysisByGrade;
import com.jeiglobal.hk.domain.member.MemberAnalysisDto.MemberByGrade;
import com.jeiglobal.hk.domain.member.MemberAnalysisDto.MemberByMonthFA;
import com.jeiglobal.hk.domain.member.MemberAnalysisDto.MemberByMultiSubj;
import com.jeiglobal.hk.domain.member.MemberAnalysisDto.MemberBySubject;
import com.jeiglobal.hk.domain.member.MemberAnalysisDto.SubjectReport;
import com.jeiglobal.hk.domain.member.MemberAnalysisDto.SubjectReportBottom;
import com.jeiglobal.hk.domain.member.MemberAnalysisDto.SubjectReportBottomSub;
import com.jeiglobal.hk.repository.member.*;
import com.jeiglobal.hk.utils.*;

/**
 * 클래스명 : MemberAnalysisService.java
 *
 * 작성일 : 2015. 11. 2.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Service
public class MemberAnalysisService {
	
	@Autowired
	private MemberAnalysisRepository memberAnalysisRepository;

	private Map<String, Object> param = new HashMap<>();
	
	private final static String DEFAULT_SUBJECT_REPORT = "0,0,0,0,0,0,0,0,0,0,0,0"; 
	/**
	 * @param jisaCD
	 * @param deptCD
	 * @param searchYYMM 
	 * @return List<MemberByMonthFA>
	 * @throws ParseException 
	 */
	public List<MemberByMonthFA> getMemberByMonths(String jisaCD, String deptCD, String searchYYMM) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		cal.setTime(simpleDateFormat.parse(searchYYMM));
		cal.add(Calendar.MONTH, -11);
		String beforeYYMM = simpleDateFormat.format(cal.getTime());
		
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("beforeYYMM", beforeYYMM);
		param.put("searchYYMM", searchYYMM);
		
		List<MemberByMonthFA> memberByMonths = memberAnalysisRepository.findMemberByMonths(param);
		for (MemberByMonthFA memberByMonthFA : memberByMonths) {
			String source = memberByMonthFA.getMgYY()+"-"+memberByMonthFA.getMgMM();
			memberByMonthFA.setDisplayYYMM(new SimpleDateFormat("MMM yyyy", Locale.ENGLISH).format(simpleDateFormat.parse(source)));
		}
		return memberByMonths;
	}

	/**
	 * @param jisaCD
	 * @param deptCD
	 * @param searchYYMM
	 * @return Object
	 */
	public List<MemberBySubject> getMemberBySubject(String jisaCD, String deptCD, String searchYYMM) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("searchYYMM", searchYYMM);
		return memberAnalysisRepository.findMemberBySubject(param);
	}

	/**
	 * @param jisaCD
	 * @param deptCD
	 * @param searchYYMM
	 * @param subj
	 * @return Object
	 */
	public List<MemberAnalysisByGrade> getMembersByGrade(String jisaCD, String deptCD,
			String searchYYMM, String subj) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("searchYYMM", searchYYMM);
		param.put("subj", subj);
		return memberAnalysisRepository.findMembersByGrade(param);
	}

	/**
	 * @param jisaCD
	 * @param deptCD
	 * @param searchYYMM
	 * @param subj
	 * @return Object
	 */
	public List<MemberByGrade> getMemberByWbGrade(String jisaCD, String deptCD,
			String searchYYMM, String subj) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("searchYYMM", searchYYMM);
		param.put("subj", subj);
		return memberAnalysisRepository.findMembersByWbGrade(param);
	}

	/**
	 * @param jisaCD
	 * @param deptCD
	 * @param searchYYMM
	 * @param subj
	 * @return Object
	 */
	public MemberByMultiSubj getMembersByMultiSubj(String jisaCD, String deptCD,
			String searchYYMM, String subj) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("searchYYMM", searchYYMM);
		param.put("subj", subj);
		return memberAnalysisRepository.findMembersByMultiSubj(param);
	}

	/**
	 * @param jisaCD
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String, Object>> getDeptSearchPop(String jisaCD) {
		return memberAnalysisRepository.findDeptSearchPop(jisaCD);
	}

	/**
	 * @param jisaCD
	 * @param deptCD
	 * @param searchYYMM 
	 * @return List<MemberByMonthFA>
	 * @throws ParseException 
	 */
	public List<MemberByMonthFA> getMemberByMonths(String jisaCD, String searchYYMM) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		cal.setTime(simpleDateFormat.parse(searchYYMM));
		cal.add(Calendar.MONTH, -11);
		String beforeYYMM = simpleDateFormat.format(cal.getTime());
		
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("beforeYYMM", beforeYYMM);
		param.put("searchYYMM", searchYYMM);
		
		List<MemberByMonthFA> memberByMonths = memberAnalysisRepository.findMembersByMonthsJA(param);
		for (MemberByMonthFA memberByMonthFA : memberByMonths) {
			String source = memberByMonthFA.getMgYY()+"-"+memberByMonthFA.getMgMM();
			memberByMonthFA.setDisplayYYMM(new SimpleDateFormat("MMM yyyy", Locale.ENGLISH).format(simpleDateFormat.parse(source)));
		}
		return memberByMonths;
	}

	/**
	 * @param jisaCD
	 * @param searchYYMM
	 * @return List<MemberBySubject>
	 */
	public List<MemberBySubject> getMemberBySubject(String jisaCD,
			String searchYYMM) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("searchYYMM", searchYYMM);
		return memberAnalysisRepository.findMemberBySubjectJA(param);
	}

	/**
	 * @return List<String>
	 */
	public List<String> getLastFiveYears() {
		Calendar cal = Calendar.getInstance();
		List<String> years = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		for (int i = 0; i < 5; i++) {
			years.add(sdf.format(cal.getTime()));
			cal.add(Calendar.YEAR, -1);
		}
		return years;
	}

	/**
	 * @param jisaCD
	 * @param deptCD
	 * @param searchYY
	 * @return List<SubjectReport>
	 */
	public List<SubjectReport> getSubjectReport(String jisaCD, String deptCD, String searchYY) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("searchYY", searchYY);
		return memberAnalysisRepository.findSubjectReport(param);
	}

	/**
	 * @param searchYY
	 * @return List<String>
	 */
	public List<String> getDisplayYears(String searchYY) {
		List<String> displayYears = new ArrayList<>();
		displayYears.add(String.valueOf((Integer.parseInt(searchYY) - 1)));
		displayYears.add(searchYY);
		return displayYears;
	}

	/**
	 * @param searchYYMM
	 * @param jisaCD
	 * @param deptCD
	 * @param pastMonth
	 * @return List<SubjectReportBottom>
	 * @throws ParseException 
	 */
	public List<SubjectReportBottom> getSubjReportBottom(
			String jisaCD, String deptCD, int pastMonth) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("totalFlag", ("00000".equals(deptCD)?"1":"2"));
		param.put("searchYYMM", sdf.format(cal.getTime()));
		List<SubjectReportBottom> subjReportBottom = memberAnalysisRepository.findSubjReportBottom(param);
		for (SubjectReportBottom subjectReportBottom : subjReportBottom) {
			subjectReportBottom.setSplitAry(subjectReportBottom.getSubjReport().split(","));
			if(pastMonth > 0){
				cal = Calendar.getInstance();
				cal.add(Calendar.MONTH, -1);
				List<SubjectReportBottomSub> subList = new ArrayList<>();
				for (int i = 1; i < pastMonth + 1; i++) {
					cal.add(Calendar.MONTH, -1);
					param.put("subYYMM", sdf.format(cal.getTime()));
					param.put("deptCD", subjectReportBottom.getDeptCD());
					SubjectReportBottomSub sub = memberAnalysisRepository.findSubjReportBottomSub(param);
					if(sub == null){
						sub = new SubjectReportBottomSub(CommonUtils.changeDateFormat("yyyy-MM", "yyyy/MM", String.valueOf(param.get("subYYMM"))), deptCD, DEFAULT_SUBJECT_REPORT, 0, DEFAULT_SUBJECT_REPORT.split(","));
					}else{
						sub.setSplitAry(sub.getSubjReport().split(","));
					}
					subList.add(sub);
				}
				subjectReportBottom.setSubs(subList);
			}
		}
		return subjReportBottom;
	}
	
}
