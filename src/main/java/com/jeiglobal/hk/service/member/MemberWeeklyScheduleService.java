package com.jeiglobal.hk.service.member;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.MemberWeeklyDetailInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberWeeklyScheduleInfo;
import com.jeiglobal.hk.repository.member.*;
import com.jeiglobal.hk.utils.*;

/**
 * 클래스명 : MemberWeeklyScheduleService.java
 *
 * 작성일 : 2015. 10. 19.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Service
public class MemberWeeklyScheduleService {

	@Autowired
	private MemberWeeklyScheduleRepository memberWeeklyScheduleRepository;
	
	@Autowired
	private MemberReportRepository memberReportRepository;
	
	Map<String, Object> param = new HashMap<>();
	/**
	 * @param jisaCD
	 * @param deptCD
	 * @param subj
	 * @return List<MemberWeeklyScheduleInfo>
	 */
	public List<MemberWeeklyScheduleInfo> getMemberWeeklySchedule(
			String jisaCD, String deptCD, String subj) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("subj", subj);
		return memberWeeklyScheduleRepository.findMemberWeeklySchedule(param);
	}
	/**
	 * @param memKey
	 * @param subj
	 * @return MemSubjStudy
	 */
	public MemSubjStudy getMemSubjStudyByMemKeyAndSubj(String memKey,
			String subj) {
		param.clear();
		param.put("memKey", memKey);
		param.put("subj", subj);
		return memberWeeklyScheduleRepository.findMemSubjStudyByMemKeyAndSubj(param);
	}
	/**
	 * @param memKey
	 * @param subj
	 * @param workId void
	 * @param yoil 
	 */
	public void setMemSubjMstByMemKeyAndSubj(String memKey, String subj,
			String workId, String yoil) {
		param.clear();
		param.put("memKey", memKey);
		param.put("subj", subj);
		param.put("workId", workId);
		param.put("yoil", yoil);
		param.put("currentYMD", CommonUtils.getCurrentYMD());
		memberReportRepository.insertMemSubjMstHis(param);
		memberWeeklyScheduleRepository.updateMemSubjMst(param);
	}
	/**
	 * @param memKey
	 * @param subj
	 * @param workId
	 * @param yoil
	 * @param manageTime void
	 */
	public void setMemSubjStudyByMemKeyAndSubj(String memKey, String subj,
			String workId, String yoil, String manageTime) {
		param.clear();
		param.put("memKey", memKey);
		param.put("subj", subj);
		param.put("workId", workId);
		param.put("yoil", yoil);
		param.put("manageTime", manageTime);
		param.put("currentYMD", CommonUtils.getCurrentYMD());
		memberReportRepository.insertMemSubjStudyHis(param);
		memberWeeklyScheduleRepository.updateMemSubjStudy(param);		
	}
	/**
	 * Weekly Schedule 지사
	 * @param jisaCD
	 * @param subj
	 * @return List<MemberWeeklyScheduleInfo>
	 */
	public List<MemberWeeklyScheduleInfo> getMemberWeeklyScheduleJA(
			String jisaCD, String subj) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("subj", ("All".equalsIgnoreCase(subj) ? "" : subj));
		return memberWeeklyScheduleRepository.findMemberWeeklyScheduleJA(param);
	}
	/**
	 * 지사 WeeklySchedule Detail Popup
	 * @param jisaCD
	 * @param time
	 * @param yoil
	 * @param subj 
	 * @return List<MemberWeeklyDetailInfo>
	 */
	public List<MemberWeeklyDetailInfo> getMemberWeeklyDetailInfo(
			String jisaCD, String time, String yoil, String subj) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("time", time);
		param.put("yoil", yoil);
		param.put("subj", subj);
		return memberWeeklyScheduleRepository.findMemberWeeklyDetailInfo(param);
	}

}
