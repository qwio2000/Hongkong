package com.jeiglobal.hk.repository.member;

import java.util.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.MemberAnalysisDto.MemberAnalysisByGrade;
import com.jeiglobal.hk.repository.*;

/**
 * 클래스명 : MemberAnalysisRepository.java
 *
 * 작성일 : 2015. 11. 2.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface MemberAnalysisRepository {

	public int findMemberAnalysisByGradeCount(LoginInfo loginInfo);

	public List<MemberAnalysisByGrade> findMemberAnalysisByGrade(
			Map<String, Object> param);

}
