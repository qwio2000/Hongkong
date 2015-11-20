/**
 * 
 */
package com.jeiglobal.hk.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.*;
import com.jeiglobal.hk.repository.*;

/**
 * 클래스명 : MainService.java
 *
 * 작성일 : 2015. 10. 8.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */

@Service
public class MainService {

	@Autowired
	private MainRepository mainRepository;
	
	private Map<String, Object> param = new HashMap<>();
	/**
	 * 팝업 게시 정보 가져오기
	 * @param jisaCD
	 * @param deptCD
	 * @param currentYMD
	 * @return List<Integer>
	 */
	public String getPopupMsgIdx(String jisaCD, String deptCD,
			String currentYMD) {
		param.clear();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("currentYMD", currentYMD);
		return mainRepository.findPopupMsgIdx(param);
	}
	/**
	 * 팝업 정보 가져오기
	 * @param idxList
	 * @return List<PopUpMsgGroup>
	 */
	public List<PopUpMsgGroup> getPopupMsgIdx(List<String> idxList) {
		List<PopUpMsgGroup> popupMsgs = mainRepository.findPopupMsg(idxList);
		for (PopUpMsgGroup popUpMsgGroup : popupMsgs) {
			popUpMsgGroup.setMsg(popUpMsgGroup.getMsg().replaceAll("\r\n", "<br/>"));
		}
		return popupMsgs;
	}

}
