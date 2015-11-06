package com.jeiglobal.hk.repository.member;

import java.util.*;

import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.MemberWeeklyScheduleInfo;
import com.jeiglobal.hk.repository.*;

/**
 * 클래스명 : MemberWeeklyScheduleRepository.java
 *
 * 작성일 : 2015. 10. 19.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface MemberWeeklyScheduleRepository {

	public List<MemberWeeklyScheduleInfo> findMemberWeeklySchedule(
			Map<String, Object> param);

	public MemSubjStudy findMemSubjStudyByMemKeyAndSubj(
			Map<String, Object> param);

	public void updateMemSubjMst(Map<String, Object> param);

	public void updateMemSubjStudy(Map<String, Object> param);

	public List<MemberWeeklyScheduleInfo> findMemberWeeklyScheduleJA(
			Map<String, Object> param);

}
