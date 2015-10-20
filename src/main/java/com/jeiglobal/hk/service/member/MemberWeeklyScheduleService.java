package com.jeiglobal.hk.service.member;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.member.MemberDto.MemberWeeklyScheduleInfo;
import com.jeiglobal.hk.repository.member.*;

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
	
	Map<String, Object> param = new HashMap<>();
	/**
	 * @param jisaCD
	 * @param deptCD
	 * @param subj
	 * @return List<MemberWeeklyScheduleInfo>
	 */
	public List<MemberWeeklyScheduleInfo> getMemberWeeklySchedule(
			String jisaCD, String deptCD, String subj) {
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("subj", subj);
		List<MemberWeeklyScheduleInfo> memberWeeklyScheduleInfos = memberWeeklyScheduleRepository.findMemberWeeklySchedule(param);
		for (MemberWeeklyScheduleInfo memberWeeklyScheduleInfo : memberWeeklyScheduleInfos) {
			param.put("visitHours", memberWeeklyScheduleInfo.getDtlCD());
			param.put("yoil", 1);
			memberWeeklyScheduleInfo.setSunMembers(memberWeeklyScheduleRepository.findMemberByYoilAndVisitHours(param));
			param.put("yoil", 2);
			memberWeeklyScheduleInfo.setMonMembers(memberWeeklyScheduleRepository.findMemberByYoilAndVisitHours(param));
			param.put("yoil", 3);
			memberWeeklyScheduleInfo.setTueMembers(memberWeeklyScheduleRepository.findMemberByYoilAndVisitHours(param));
			param.put("yoil", 4);
			memberWeeklyScheduleInfo.setWedMembers(memberWeeklyScheduleRepository.findMemberByYoilAndVisitHours(param));
			param.put("yoil", 5);
			memberWeeklyScheduleInfo.setThuMembers(memberWeeklyScheduleRepository.findMemberByYoilAndVisitHours(param));
			param.put("yoil", 6);
			memberWeeklyScheduleInfo.setFriMembers(memberWeeklyScheduleRepository.findMemberByYoilAndVisitHours(param));
			param.put("yoil", 7);
			memberWeeklyScheduleInfo.setSatMembers(memberWeeklyScheduleRepository.findMemberByYoilAndVisitHours(param));
		}
		return memberWeeklyScheduleInfos;
	}

}
