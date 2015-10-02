package com.jeiglobal.hk.repository.member;

import java.util.*;

import com.jeiglobal.hk.domain.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.GuardianInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberRegistSearchInfo;
import com.jeiglobal.hk.domain.member.MemberDto.RegistSubject;
import com.jeiglobal.hk.repository.*;

/**
 * 클래스명 : MemberRegistRepository.java
 *
 * 작성일 : 2015. 9. 22.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface MemberRegistRepository {

	public String getClosingDate(Map<String, Object> param);

	public int getCalcFee(Map<String, Object> param);

	public List<MemberRegistSearchInfo> findMemberRegistSearch(Map<String, Object> paramMap);

	public Map<String, Object> findDeptOpenCloseTime(Map<String, Object> param);

	public List<CodeDtl> findDeptAvailableTimes(Map<String, Object> param);

	public MemMst findMemMst(String memKey);

	public GuardianInfo findGuardianInfo(String memKey);

	public List<RegistSubject> findRegistSubjects(Map<String, Object> param);

	public String getKeyGenSelect();

}
