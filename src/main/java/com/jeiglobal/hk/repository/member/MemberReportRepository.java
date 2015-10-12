package com.jeiglobal.hk.repository.member;

import java.util.*;

import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportSubjInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberSearchInfo;
import com.jeiglobal.hk.repository.*;

/**
 * 클래스명 : MemberSearchRepository.java
 *
 * 작성일 : 2015. 9. 17.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface MemberReportRepository {

	public List<MemberSearchInfo> findSearchResults(Map<String, Object> map);

	public MemMst findMemMstByMemKey(String memKey);

	public List<MemberReportInfo> findMemMstsByGuardianName(
			Map<String, Object> param);

	public List<MemberReportSubjInfo> findMemSubjMstsByMemKey(String memKey);

	public void insertMemMstHis(Map<String, Object> param);

	public void updateGuardianInfo(Map<String, Object> param);

	public void insertMemCommentCall(Map<String, Object> param);

	public List<String> getMemberSubjects(String memKey);

}
