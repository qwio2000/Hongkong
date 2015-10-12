package com.jeiglobal.hk.service.member;

import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.*;
import com.jeiglobal.hk.repository.member.*;
import com.jeiglobal.hk.service.*;
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
	
	@Autowired
	private CommonService commonService;
	
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
	 * @param loginInfo 
	 * @return MemberReportInfo
	 * @throws ParseException 
	 */
	public List<MemberReportInfo> getMemberReportInfo(MemMst memMst, LoginInfo loginInfo) throws ParseException {
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
		//(입회,퇴회) 취소 가능 여부
		memberReportInfos = getIsCancle(memberReportInfos, loginInfo.getJisaCD());
		return memberReportInfos;
	}

	/**
	 * 
	 * @param memberReportInfos
	 * @param jisaCD
	 * @return List<MemberReportInfo>
	 * @throws ParseException 
	 */
	private List<MemberReportInfo> getIsCancle(List<MemberReportInfo> memberReportInfos, String jisaCD) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentYMD = CommonUtils.getCurrentYMD();
		String yyyyMM = currentYMD.substring(0, 7);
		String closingDateStr = commonService.getClosingDate(jisaCD, yyyyMM);
		Date closingDate = sdf.parse(closingDateStr);
		cal.setTime(closingDate);
		cal.add(Calendar.DATE, 1);
		closingDate = cal.getTime();
		
		cal.setTime(closingDate);
		cal.add(Calendar.MONTH, -1);
		Date beforeClosingDate = cal.getTime();
		
		Date checkDate = null;
		for (MemberReportInfo memberReportInfo : memberReportInfos) {
			for (MemberReportSubjInfo memberReportSubjInfo : memberReportInfo.getMemberReportSubjInfos()) {
				if("1".equals(memberReportSubjInfo.getStatusCD())){
					checkDate = sdf.parse(memberReportSubjInfo.getRecentRegistFnlYMD());
				}else if("2".equals(memberReportSubjInfo.getStatusCD())){
					checkDate = sdf.parse(memberReportSubjInfo.getDropFnlYMD());
				}
				if(checkDate.compareTo(beforeClosingDate) > 0 && checkDate.compareTo(closingDate) <= 0){
					memberReportSubjInfo.setIsCancle("true");
				}else{
					memberReportSubjInfo.setIsCancle("false");
				}
			}
		}
		return memberReportInfos;
		
	}


}
