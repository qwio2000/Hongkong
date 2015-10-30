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
import com.jeiglobal.hk.domain.center.PopUpMsgList;
import com.jeiglobal.hk.repository.center.PopMsgRepository;

/**
 * 클래스명 : PopupMsgService.java
 *
 * 작성일 : 2015. 10. 28.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 팝업 메세지 관리 
 */
@Service
public class PopMsgService {
	
	@Autowired
	private PopMsgRepository popMsgRepository;
	

	public int getPopMsgCount(String jisaCD) {
		return popMsgRepository.findPopMsgCount(jisaCD);
	}	
	public List<PopUpMsgList> getPopMsgList(String jisaCD, int startRow,
			int rowBlockSize) throws ParseException {
		Map<String, Object> param = new HashMap<>();
		param.put("jisaCD", jisaCD);
		param.put("startRow", startRow);
		param.put("rowBlockSize", rowBlockSize);
		return popMsgRepository.findPopMsgList(param);
	}
	public PopUpMsgList getPopMsgView(int idx) {
		return popMsgRepository.findPopMsgView(idx);
	}	
	public String getPopMsgSave(int idx, String jisaCD, String startYMD, String endYMD, String msgTitle, String msg, String chk, String stateCD, String workId) {
		Map<String, Object> param = new HashMap<>();
		param.put("idx", idx);
		param.put("jisaCD", jisaCD);
		param.put("startYMD", startYMD);
		param.put("endYMD", endYMD);
		param.put("msgTitle", msgTitle);
		param.put("msg", msg);
		param.put("chk", chk);
		param.put("stateCD", stateCD);
		param.put("regID", workId);
		return popMsgRepository.popMsgSave(param);
		
	}	
	public void removePopMsg(int idx) {
		popMsgRepository.deletePopMsgGroup(idx);
		popMsgRepository.deletePopMsg(idx);
	}		
	public List<CenterOfStateList> getCenterOfStateList(String jisaCD, String stateCD, int idx) {
		Map<String, Object> param = new HashMap<>();
		param.put("jisaCD", jisaCD);
		param.put("stateCD", stateCD);
		param.put("idx", idx);
		return popMsgRepository.findCenterOfStateList(param);
	}	
		
}
