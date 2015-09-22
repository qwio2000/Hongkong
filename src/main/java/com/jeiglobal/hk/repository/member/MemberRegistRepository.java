package com.jeiglobal.hk.repository.member;

import java.util.*;

import com.jeiglobal.hk.repository.*;

/**
 * 클래스명 : MemberRegistRepository.java
 *
 * 작성일 : 2015. 9. 22.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface MemberRegistRepository {

	public String getClosingDate(Map<String, Object> param);

	public int getCalcFee(Map<String, Object> param);

}
