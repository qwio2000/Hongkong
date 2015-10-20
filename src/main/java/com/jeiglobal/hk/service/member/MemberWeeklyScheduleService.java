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
		return memberWeeklyScheduleRepository.findMemberWeeklySchedule(param);
	}

}
