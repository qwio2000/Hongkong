package com.jeiglobal.hk.repository;

import java.util.*;

import com.jeiglobal.hk.domain.*;

/**
 * 클래스명 : MainRepository.java
 *
 * 작성일 : 2015. 11. 20.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface MainRepository {

	public String findPopupMsgIdx(Map<String, Object> param);

	public List<PopUpMsgGroup> findPopupMsg(List<String> idxList);

}
