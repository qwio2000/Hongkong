package com.jeiglobal.hk.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.*;
import com.jeiglobal.hk.repository.*;

/**
 * 클래스명 : CommonService.java
 *
 * 작성일 : 2015. 9. 15.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 공통 서비스
 */
@Service
public class CommonService {
	
	@Autowired
	private CommonRepository commonRepository;
	
	Map<String, Object> param = new HashMap<String, Object>();
	
	/**
	 * CodeDtl를 가져오는 메서드
	 * @param mstCD
	 * @param jisaCD
	 * @param dtlCD
	 * @return CodeDtl
	 */
	public CodeDtl getCodeDtl(String mstCD, String jisaCD, String dtlCD){
		param.clear();
		param.put("mstCD", mstCD);
		param.put("jisaCD", jisaCD);
		param.put("dtlCD", dtlCD);
		return commonRepository.findCodeDtl(param);
	}
	
	/**
	 * CodeDtl 리스트를 가져오는 메서드
	 * @param mstCD
	 * @param jisaCD
	 * @return List<CodeDtl>
	 */
	public List<CodeDtl> getCodeDtls(String mstCD, String jisaCD, int sortVal, String useVal){
		param.clear();
		param.put("mstCD", mstCD);
		param.put("jisaCD", jisaCD);
		param.put("sortVal", sortVal);
		param.put("useVal", useVal);
		return commonRepository.findCodeDtls(param);
	}

	/**
	 * 지사 별 State 리스트를 가져오는 메서드
	 * @param jisaCD 
	 * @return List<CenterState>
	 */
	public List<CenterState> getCenterStates(String jisaCD) {
		return commonRepository.findCenterStates(jisaCD);
	}
	
	/**
	 * 지사나 가맹점별로 운영중인 과목 리스트를 가져오는 메서드
	 * @param jisaCD
	 * @param deptCD
	 * @param type  =>  1 : 운영중인것, 2 : 한번이라도 운영된 적이 있었던 과목들
	 * @return List<String>
	 */
	public List<String> getOpenSubjsByDeptCD(String jisaCD, String deptCD, String type){
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("type", type);
		return commonRepository.findOpenSubjsByDeptCD(param);
	}
	
	/**
	 * 과목의 등급 정보를 가져오는 메서드
	 * @param jisaCD
	 * @param subj
	 * @param useYN
	 * @param digYN
	 * @return List<GradeOfSubject>
	 */
	public List<GradeOfSubject> getGradeOfSubject(String jisaCD, String subj, String useYN, String digYN){
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("subj", subj);
		param.put("useYN", useYN);
		param.put("digYN", digYN);
		return commonRepository.findGradeOfSubject(param);
	}

	/**
	 * 가맹점이 취급하는 과목 정보
	 * @param jisaCD
	 * @param deptCD : 지사인 경우 00000
	 * @return List<SubjectOfDept>
	 */
	public List<SubjectOfDept> getSubjectsOfDept(String jisaCD, String deptCD) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		return commonRepository.findSubjectsOfDept(param);
	}
	
	/**
	 * 가맹점의 정보를 가져오는 메서드
	 * @param deptCD
	 * @return DeptMst
	 */
	public DeptMst getDeptMstByDeptCD(String deptCD){
		return commonRepository.findDeptMstByDeptCD(deptCD);
	}
	/**
	 * 현재 달의 마감 날짜 가져옴
	 * @param jisaCD
	 * @param currentYYYYMM
	 * @return String
	 */
	public String getClosingDate(String jisaCD, String currentYYYYMM) {
		param.clear();
		param.put("currentYYYYMM", currentYYYYMM);
		param.put("jisaCD", jisaCD);
		return commonRepository.findClosingDate(param);
	}
	/**
	 * 해당 지사, 가맹점의 회원 관리 시간(cHours) 리스트를 가져오는 메서드
	 * @param jisaCD
	 * @param deptCD
	 * @return List<CodeDtl>
	 */
	public List<CodeDtl> getMemberManageTimes(String jisaCD, String deptCD) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		Map<String, Object> deptHour = commonRepository.findDeptOpenCloseTime(param);
		return getDeptAvailableTimes(jisaCD, deptHour.get("cHoursStart").toString(), deptHour.get("cHoursEnd").toString());
	}

	/**
	 * 해당 지사, 가맹점의 영업 시간(cHours) 리스트를 가져오는 메서드
	 * @param jisaCD
	 * @param deptCD
	 * @return List<CodeDtl>
	 */
	public List<CodeDtl> getBusinessTimes(String jisaCD, String deptCD) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		Map<String, Object> deptHour = commonRepository.findDeptOpenCloseTime(param);
		return getDeptAvailableTimes(jisaCD, deptHour.get("oHoursStart").toString(), deptHour.get("oHoursEnd").toString());
	}
	
	/**
	 * @param CodeDtl에서 시간 범위에 맞는 시간 리스트 가져오는 메서드 
	 * @param String
	 * @param String
	 * @return List<CodeDtl>
	 */
	private List<CodeDtl> getDeptAvailableTimes(String jisaCD, String start, Object end) {
		param.clear();
		param.put("start", start);
		param.put("end", end);
		param.put("jisaCD", jisaCD);
		return commonRepository.findDeptAvailableTimes(param);
		
	}

	/**
	 * 지사 운영중인 과목 가져오기
	 * @param jisaCD
	 * @return List<String>
	 */
	public List<String> getOpenSubjsByJisaCD(String jisaCD) {
		return commonRepository.findOpenSubjsByJisaCD(jisaCD);
	}
}
