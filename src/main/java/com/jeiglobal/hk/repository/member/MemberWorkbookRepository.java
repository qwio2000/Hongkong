package com.jeiglobal.hk.repository.member;

import java.util.*;

import com.jeiglobal.hk.domain.member.MemberDto.MemberWorkbookInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberWorkbookSubjInfo;
import com.jeiglobal.hk.repository.*;

/**
 * 클래스명 : MemberWorkbookRepository.java
 *
 * 작성일 : 2015. 10. 19.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * MemberWorkbook Repository
 */
@PrimaryRepositoryAnnoInterface
public interface MemberWorkbookRepository {

	public int findMemberWorkbookCount(Map<String, Object> param);

	public List<MemberWorkbookInfo> findMemberWorkbookInfo(
			Map<String, Object> param);

	public List<MemberWorkbookSubjInfo> findMemberWorkbookSubjInfo(
			Map<String, Object> param);

}
