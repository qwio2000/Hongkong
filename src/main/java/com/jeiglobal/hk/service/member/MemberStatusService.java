package com.jeiglobal.hk.service.member;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.MemberDto.MemberRegistDropStatus;
import com.jeiglobal.hk.repository.member.*;

/**
 * 클래스명 : MemberStatusService.java
 *
 * 작성일 : 2015. 11. 3.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Service
public class MemberStatusService {

	@Autowired
	private MemberStatusRepository memberStatusRepository;
	
	Map<String, Object> param = new HashMap<>();
	
	/**
	 * 가맹점 입퇴회 현황 카운트 수
	 * @param loginInfo
	 * @param searchYYMM
	 * @return int
	 */
	public int getMemberRegistDropStatusCount(LoginInfo loginInfo,
			String searchYYMM) {
		param.clear();
		param.put("loginInfo", loginInfo);
		param.put("searchYYMM", searchYYMM);
		return memberStatusRepository.findMemberRegistDropStatusCount(param);
	}

	/**
	 * 가맹점 입퇴회 현황 리스트
	 * @param loginInfo
	 * @param searchYYMM
	 * @return List<MemberRegistDropStatus>
	 */
	public List<MemberRegistDropStatus> getMemberRegistDropStatus(
			LoginInfo loginInfo, String searchYYMM) {
		param.clear();
		param.put("loginInfo", loginInfo);
		param.put("searchYYMM", searchYYMM);
		return memberStatusRepository.findMemberRegistDropStatus(param);
	}

}
