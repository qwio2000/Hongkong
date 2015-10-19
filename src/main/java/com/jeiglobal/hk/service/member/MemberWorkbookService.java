package com.jeiglobal.hk.service.member;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.member.MemberDto.MemberWorkbookInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MonthInfo;
import com.jeiglobal.hk.repository.member.*;
import com.jeiglobal.hk.utils.*;

/**
 * 클래스명 : MemberWorkbookService.java
 *
 * 작성일 : 2015. 10. 19.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * Workbook Service
 */
@Service
public class MemberWorkbookService {

	@Autowired
	private MemberWorkbookRepository memberWorkbookRepository;
	
	Map<String, Object> param = new HashMap<>();
	/**
	 * workbook Count
	 * @param jisaCD
	 * @param deptCD
	 * @param subj
	 * @return int
	 */
	public int getMemberWorkbookCount(String jisaCD, String deptCD, String subj) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("subj", subj);
		return memberWorkbookRepository.findMemberWorkbookCount(param);
	}
	/**
	 * WorkBook 가져오기
	 * @param year
	 * @param month
	 * @param week
	 * @param subj
	 * @param jisaCD
	 * @param deptCD
	 * @param rowBlockSize 
	 * @param startRow 
	 * @return List<MemberWorkbookInfo>
	 */
	public List<MemberWorkbookInfo> getMemberWorkbooks(int year,
			int month, int week, String subj, String jisaCD, String deptCD, int startRow, int rowBlockSize) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("subj", subj);
		param.put("startRow", startRow);
		param.put("rowBlockSize", rowBlockSize);
		param.put("week", week);
		List<MemberWorkbookInfo> workbooks = memberWorkbookRepository.findMemberWorkbookInfo(param);
		Map<String, String> weekMap = getSearchWeekMap(year, month, week);
		param.put("weekMap", weekMap);
		for (MemberWorkbookInfo memberWorkbookInfo : workbooks) {
			param.put("memKey", memberWorkbookInfo.getMemKey());
			memberWorkbookInfo.setWorkbookSubjInfos(memberWorkbookRepository.findMemberWorkbookSubjInfo(param));
		}
		return workbooks;
	}
	/**
	 * 진도 가져올 yymmwk 구하기
	 * @param year
	 * @param month
	 * @param week
	 * @return Map<String,String>
	 */
	private Map<String, String> getSearchWeekMap(int year, int month,
			int week) {
		Map<String, String> weekMap = new HashMap<>();
		String yymmwk = "";
		int wk = 1;
		for (int i = 1; i <= 10; i++) {
			yymmwk = year + CommonUtils.getMonthAttachZero(month) + wk;
			if(i <= week){
				weekMap.put("set"+i, yymmwk);
			}else{
				weekMap.put("set"+i, "");
			}
			if(wk + 1 > 5){
				if(month + 1 > 12){
					year += 1;
					month = 1;
				}else{
					month += 1;
				}
				wk = 1;
			}else{
				wk += 1;
			}
		}
		return weekMap;
	}
	/**
	 * @param month
	 * @param months
	 * @return Object
	 */
	public List<String> getMonthName(int month, List<MonthInfo> months) {
		List<String> monthNum = new ArrayList<>();
		for (MonthInfo monthInfo : months) {
			if(Integer.parseInt(monthInfo.getMonthNum()) == month){
				monthNum.add(monthInfo.getMonthStr());
			}
		}
		for (MonthInfo monthInfo : months) {
			if(Integer.parseInt(monthInfo.getMonthNum()) == month + 1){
				monthNum.add(monthInfo.getMonthStr());
			}
		}
		return monthNum;
	}

}
