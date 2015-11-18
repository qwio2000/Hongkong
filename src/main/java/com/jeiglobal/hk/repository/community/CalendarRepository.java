package com.jeiglobal.hk.repository.community;

import java.util.List;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.community.Calendar;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * @since  2015-11-04
 * @author 이지은
 * @see 
 */
@PrimaryRepositoryAnnoInterface
public interface CalendarRepository {
	
	List<Calendar> CalendarList(LoginInfo loginInfo);
	Calendar CalendarDetail(int aidx);
	
	
}
