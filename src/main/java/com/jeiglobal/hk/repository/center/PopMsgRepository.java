/**
 * 
 */
package com.jeiglobal.hk.repository.center;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.center.CenterOfStateList;
import com.jeiglobal.hk.domain.center.PopUpMsgList;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * 클래스명 : PopMsgRepository.java
 *
 * 작성일 : 2015. 10. 28.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 팝업 메세지 관리
 */
@PrimaryRepositoryAnnoInterface
public interface PopMsgRepository {
	
	// 팝업 메세지 리스트
	public int findPopMsgCount(String jisaCD);
	public List<PopUpMsgList> findPopMsgList(Map<String, Object> param);
	public PopUpMsgList findPopMsgView(int idx);
	
	// 팝업 메세지 등록/수정/삭제	
	public String popMsgSave(Map<String, Object> param);		
	public void deletePopMsgGroup(int idx);
	public void deletePopMsg(int idx);
	public List<CenterOfStateList> findCenterOfStateList(Map<String, Object> param);
		
}
