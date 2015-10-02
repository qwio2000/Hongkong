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
	 * @return List<String>
	 */
	public List<String> getOpenSubjsByDeptCD(String jisaCD, String deptCD){
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		String openSubjs = commonRepository.findOpenSubjsByDeptCD(param);
		return Arrays.asList(openSubjs.split(","));
	}
	
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
}
