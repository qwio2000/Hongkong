package com.jeiglobal.hk.service.member;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.MemberAnalysisDto.MemberAnalysisByGrade;
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
	 * @param loginInfo
	 * @return List<MemberAnalysis>
	 */
	public List<MemberAnalysisByGrade> getMemberAnalysisByGrade(LoginInfo loginInfo) {
		param.clear();
		int count = memberAnalysisRepository.findMemberAnalysisByGradeCount(loginInfo);
		param.put("totCount", count);
		param.put("jisaCD", loginInfo.getJisaCD());
		param.put("deptCD", loginInfo.getDeptCD());
		return memberAnalysisRepository.findMemberAnalysisByGrade(param);
	}
	
}
