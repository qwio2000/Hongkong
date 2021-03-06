package com.jeiglobal.hk.repository;

import java.util.*;

import com.jeiglobal.hk.domain.*;

/**
 * 클래스명 : CommonRepository.java
 *
 * 작성일 : 2015. 9. 15.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * mapper/CommonRepository.xml
 */
@PrimaryRepositoryAnnoInterface
public interface CommonRepository {

	public CodeDtl findCodeDtl(Map<String, Object> param);

	public List<CodeDtl> findCodeDtls(Map<String, Object> param);

	public List<CenterState> findCenterStates(String jisaCD);

	public List<String> findOpenSubjsByDeptCD(Map<String, Object> param);

	public List<GradeOfSubject> findGradeOfSubject(Map<String, Object> param);

	public List<SubjectOfDept> findSubjectsOfDept(Map<String, Object> param);

	public DeptMst findDeptMstByDeptCD(String deptCD);

	public String findClosingDate(Map<String, Object> param);
	
	public Map<String, Object> findDeptOpenCloseTime(Map<String, Object> param);

	public List<CodeDtl> findDeptAvailableTimes(Map<String, Object> param);

	public List<String> findOpenSubjsByJisaCD(String jisaCD);
}
