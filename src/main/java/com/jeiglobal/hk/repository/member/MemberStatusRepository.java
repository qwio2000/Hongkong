package com.jeiglobal.hk.repository.member;

import java.util.*;

import com.jeiglobal.hk.domain.member.MemberDto.MemberRegistDropStatus;
import com.jeiglobal.hk.repository.*;

/**
 * 클래스명 : MemberStatusRepository.java
 *
 * 작성일 : 2015. 11. 3.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface MemberStatusRepository {

	public int findMemberRegistDropStatusCount(Map<String, Object> param);

	public List<MemberRegistDropStatus> findMemberRegistDropStatus(
			Map<String, Object> param);

}
