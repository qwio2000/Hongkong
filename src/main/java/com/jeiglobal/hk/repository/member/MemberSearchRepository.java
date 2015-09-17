package com.jeiglobal.hk.repository.member;

import java.util.*;

import com.jeiglobal.hk.domain.member.MemberDto.MemberSearch;
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
public interface MemberSearchRepository {

	public List<MemberSearchInfo> findSearchResults(MemberSearch memberSearch);

}
