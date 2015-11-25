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
import com.jeiglobal.hk.repository.member.*;

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
	
}
