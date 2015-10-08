package com.jeiglobal.hk.service.member;

import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberSearch;
import com.jeiglobal.hk.domain.member.MemberDto.MemberSearchInfo;
import com.jeiglobal.hk.repository.member.*;
import com.jeiglobal.hk.utils.*;

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

	/**
	 * @param memKey
	 * @return MemMst
	 */
	public MemMst getMemMstByMemKey(String memKey) {

		return memberReportRepository.findMemMstByMemKey(memKey);
	}

	/**
	 * @param memMst
	 * @return MemberReportInfo
	 * @throws ParseException 
	 */
	public List<MemberReportInfo> getMemberReportInfo(MemMst memMst) throws ParseException {
		Map<String, Object> param = new HashMap<>();
		param.put("gFstName", memMst.getGFstName());
		param.put("gLstName", memMst.getGLstName());
		List<MemberReportInfo> memberReportInfos = memberReportRepository.findMemMstsByGuardianName(param);
		for (MemberReportInfo memberReportInfo : memberReportInfos) {
			//생일 출력 방식 변경
			if(!memberReportInfo.getMBirthDay().equals("")){
				memberReportInfo.setMBirthDay(CommonUtils.changeDateFormat("yyyy-MM-dd", "MM/dd/yyyy", memberReportInfo.getMBirthDay()));
			}
			memberReportInfo.setMemberReportSubjInfos(memberReportRepository.findMemSubjMstsByMemKey(memberReportInfo.getMemKey()));
		}
		return memberReportInfos;
	}


}
