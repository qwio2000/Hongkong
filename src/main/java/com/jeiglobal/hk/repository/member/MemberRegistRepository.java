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

	public int getCalcFee(Map<String, Object> param);

	public List<MemberRegistSearchInfo> findMemberRegistSearch(Map<String, Object> paramMap);

	public Map<String, Object> findDeptOpenCloseTime(Map<String, Object> param);

	public List<CodeDtl> findDeptAvailableTimes(Map<String, Object> param);

	public MemMst findMemMst(String memKey);

	public GuardianInfo findGuardianInfo(String memKey);

	public List<RegistSubject> findRegistSubjects(Map<String, Object> param);

	public String getKeyGenSelect();

	public void insertNewMemMst(MemMst memMst);

	public Map<String, Object> findMemFeeInfo(Map<String, Object> param);

	public void insertNewMemSubjMst(MemSubjMst memSubjMst);

	public void insertNewMemSubjStudy(MemSubjStudy memSubjStudy);

	public void insertNewMemSubjRegist(MemSubjRegist memSubjRegist);

	public void insertNewMemSubjTuition(MemSubjTuition memSubjTuition);

	public void updateMemMst(MemMst memMst);

	public void updateMemSubjMst(MemSubjMst memSubjMst);

	public void updateMemSubjStudy(MemSubjStudy memSubjStudy);

	public void insertMemMstHis(Map<String, Object> param);

	public void insertMemSubjMstHis(Map<String, Object> param);

	public void insertMemSubjStudyHis(MemSubjStudy memSubjStudy);

	public void updateGuadianInfoForMemMst(Map<String, Object> param);

}
