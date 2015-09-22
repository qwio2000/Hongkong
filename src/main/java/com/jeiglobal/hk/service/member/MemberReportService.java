package com.jeiglobal.hk.service.member;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.MemberDto.MemberSearch;
import com.jeiglobal.hk.domain.member.MemberDto.MemberSearchInfo;
import com.jeiglobal.hk.repository.member.*;

/**
 * 클래스명 : MemberReportService.java
 *
 * 작성일 : 2015. 9. 17.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Service
public class MemberReportService {
	
	@Autowired
	private MemberReportRepository memberReportRepository;
	
	/**
	 * 
	 * @param loginInfo 
	 * @param pageNum 
	 * @param pageSize 
	 * @param MemberSearch
	 * @return List<MemberSearchInfo>
	 */
	public List<MemberSearchInfo> getSearchResults(MemberSearch memberSearch, LoginInfo loginInfo, int pageNum, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberSearch", memberSearch);
		map.put("loginInfo", loginInfo);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		return memberReportRepository.findSearchResults(map);
	}


}
