package com.jeiglobal.hk.service.member;

import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.*;
import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.GuardianInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberRegistSearchInfo;
import com.jeiglobal.hk.domain.member.MemberDto.RegistSubject;
import com.jeiglobal.hk.repository.member.*;

/**
 * 클래스명 : MemberRegistService.java
 *
 * 작성일 : 2015. 9. 22.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 입회 서비스
 */
@Service
public class MemberRegistService {
	
	@Autowired
	private MemberRegistRepository memberRegistRepository;
	
	@Value("${flag.fstVisit}")
	private int fstVisit;
	
	@Value("${flag.mgFstVisit}")
	private int mgFstVisit;
	/**
	 * 입회 시 첫관리 방문일 목록 가져오는 메서드
	 * @param jisaCD
	 * @return List<String>
	 * @throws ParseException 
	 */
	public List<String> getFirstManageDates(String jisaCD) throws ParseException{
		//현재 날짜 가져옴
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat yyyymmFormatter = new SimpleDateFormat("yyyy-MM");
		//현재 달의 마감날짜 가져옴
		String closingDate = getClosingDate(jisaCD, yyyymmFormatter.format(cal.getTime()));
		//마감 날짜 +8
		Calendar limitDate = getLimitManageDate(closingDate); 
		List<String> firstManageDates = new ArrayList<String>();
		SimpleDateFormat dateFommater = new SimpleDateFormat("MM/dd/yyyy");
		
		for (int i = 0; i < fstVisit; i++) {
			cal.add(Calendar.DATE, 1);
			if(limitDate.after(cal)){
				firstManageDates.add(dateFommater.format(cal.getTime()));
			}else{
				break;
			}
		}
		return firstManageDates;
	}
	/**
	 * 첫관리 방문일 최대 허용일 가져옴
	 * @param closingDate
	 * @return Calendar
	 * @throws ParseException 
	 */
	private Calendar getLimitManageDate(String closingDate) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		cal.setTime(sdf.parse(closingDate));
		cal.add(Calendar.DATE, mgFstVisit + 1);//AM 0:00 기준이라 8을 더해줌
		return cal;
	}
	/**
	 * 현재 달의 마감 날짜 가져옴
	 * @param jisaCD
	 * @param currentYYYYMM
	 * @return String
	 */
	private String getClosingDate(String jisaCD, String currentYYYYMM) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("currentYYYYMM", currentYYYYMM);
		param.put("jisaCD", jisaCD);
		return memberRegistRepository.getClosingDate(param);
	}
	/**
	 * 입회시 회비 계산하는 메서드
	 * @param manageDate : 첫 관리 방문일 선택 일
	 * @param deptCD : 가맹점 코드
	 * @param bookNum : 불출 수
	 * @return int : 회비
	 * @throws ParseException 
	 */
	public int getCalcFee(String manageDate, String deptCD, int bookNum) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar end = Calendar.getInstance();
		int endDate = end.getMaximum(Calendar.DAY_OF_MONTH);
		end.setTime(sdf.parse(manageDate));
		int manageDay = end.get(Calendar.DATE);
		int week = (int) Math.ceil(((double)(endDate - manageDay)/7));
		week = (week > 4)? 4 : week; // 4주 이상 모두 4로 변경
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("deptCD", deptCD);
		param.put("bookNum", bookNum);
		param.put("week", week);
		return memberRegistRepository.getCalcFee(param);
	}
	/**
	 * @param name
	 * @param jisaCD 
	 * @return List<MemberRegistSearchInfo>
	 */
	public List<MemberRegistSearchInfo> getMemberRegistSearch(String name, String jisaCD) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", name);
		paramMap.put("jisaCD", jisaCD);
		return memberRegistRepository.findMemberRegistSearch(paramMap);
	}
	/**
	 * @param jisaCD
	 * @param deptCD
	 * @return List<CodeDtl>
	 */
	public List<CodeDtl> getManageTimes(String jisaCD, String deptCD) {
		Map<String, Object> param = new HashMap<>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		Map<String, Object> deptHour = memberRegistRepository.findDeptOpenCloseTime(param);
		param.put("mstCD", "0206");
		param.put("deptHour", deptHour);
		return memberRegistRepository.findDeptAvailableTimes(param);
	}
	/**
	 * @param memKey
	 * @return MemMst
	 */
	public MemMst getMemMst(String memKey) {
		return memberRegistRepository.findMemMst(memKey);
	}
	/**
	 * @param memKey
	 * @return GuardianInfo
	 */
	public GuardianInfo getGuardianInfo(String memKey) {
		return memberRegistRepository.findGuardianInfo(memKey);
	}
	/**
	 * @param memKey
	 * @param loginInfo
	 * @return List<RegistSubject>
	 */
	public List<RegistSubject> getRegistSubjects(String memKey,
			LoginInfo loginInfo) {
		Map<String, Object> param = new HashMap<>();
		param.put("memKey", memKey);
		param.put("jisaCD", loginInfo.getJisaCD());
		param.put("deptCD", loginInfo.getDeptCD());
		return memberRegistRepository.findRegistSubjects(param);
	}
	/**
	 * @return String
	 */
	public String getNewMemKey() {
		return memberRegistRepository.getKeyGenSelect();
	}
}
