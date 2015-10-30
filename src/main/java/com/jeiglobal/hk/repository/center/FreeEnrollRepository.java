/**
 * 
 */
package com.jeiglobal.hk.repository.center;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.center.CenterOfStateList;
import com.jeiglobal.hk.domain.center.MemFeeFreeTermList;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : FreeEnrollRepository.java
 *
 * 작성일 : 2015. 10. 26.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 입회비 면제 구간 관리
 */
@PrimaryRepositoryAnnoInterface
public interface FreeEnrollRepository {
	
	// 입회비 면제 구간 리스트
	public int findFreeEnrollmentTermCount(String jisaCD);
	public List<MemFeeFreeTermList> findFreeEnrollmentTermList(Map<String, Object> param);
	
	// 입회비 면제 구간 등록/수정/삭제	
	public String freeEnrollmentTermSave(Map<String, Object> param);
	public void deleteFreeEnrollmentTermGroup(int idx);	
	public void deleteFreeEnrollmentTerm(int idx);
	public List<CenterOfStateList> findCenterOfStateList(Map<String, Object> param);
	public MemFeeFreeTermList findFreeEnrollmentView(int idx);
	
}
