/**
 * 
 */
package com.jeiglobal.hk.service.center;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.center.CenterOfStateList;
import com.jeiglobal.hk.domain.center.MemFeeFreeTermList;
import com.jeiglobal.hk.domain.center.PopUpMsgList;
import com.jeiglobal.hk.repository.center.FreeEnrollRepository;
import com.jeiglobal.hk.utils.CommonUtils;

/**
 * 클래스명 : FreeEnrollment.java
 *
 * 작성일 : 2015. 10. 26.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 입회비 면제 구간 관리
 */
@Service
public class FreeEnrollService {
	
	@Autowired
	private FreeEnrollRepository freeEnrollRepository;
	
	// 입회비 면제 구간 리스트
	public int getFreeEnrollmentTermCount(String jisaCD) {
		return freeEnrollRepository.findFreeEnrollmentTermCount(jisaCD);
	}	
	public List<MemFeeFreeTermList> getFreeEnrollmentTermList(String jisaCD, int startRow,
			int rowBlockSize) throws ParseException {
		Map<String, Object> param = new HashMap<>();
		param.put("jisaCD", jisaCD);
		param.put("startRow", startRow);
		param.put("rowBlockSize", rowBlockSize);
		return freeEnrollRepository.findFreeEnrollmentTermList(param);
	}
	public MemFeeFreeTermList getFreeEnrollmentView(int idx) {
		return freeEnrollRepository.findFreeEnrollmentView(idx);
	}		
	
	public String getFreeEnrollmentTermSave(int idx, String jisaCD, String startYMD, String endYMD, String freeTitle, String freeType, String chk, String stateCD, String workId) {
		Map<String, Object> param = new HashMap<>();
		param.put("idx", idx);
		param.put("jisaCD", jisaCD);
		param.put("startYMD", startYMD);
		param.put("endYMD", endYMD);
		param.put("freeTitle", freeTitle);
		param.put("freeType", freeType);
		param.put("chk", chk);
		param.put("stateCD", stateCD);
		param.put("regID", workId);
		return freeEnrollRepository.freeEnrollmentTermSave(param);
	}	
	public void removeFreeEnrollmentTerm(int idx) {
		freeEnrollRepository.deleteFreeEnrollmentTermGroup(idx);
		freeEnrollRepository.deleteFreeEnrollmentTerm(idx);
	}		
	public List<CenterOfStateList> getCenterOfStateList(String jisaCD, String stateCD, int idx) {
		Map<String, Object> param = new HashMap<>();
		param.put("jisaCD", jisaCD);
		param.put("stateCD", stateCD);
		param.put("idx", idx);
		return freeEnrollRepository.findCenterOfStateList(param);
	}	
	
		

}
