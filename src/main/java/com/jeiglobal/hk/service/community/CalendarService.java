package com.jeiglobal.hk.service.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.community.Calendar;
import com.jeiglobal.hk.repository.community.CalendarRepository;

/**
 * @since 2015-10-14
 * @author 이지은
 **/
@Service
public class CalendarService {
	
	@Autowired
	private CalendarRepository calendarrepo;
	

	public List<Calendar> CalendarList(LoginInfo loginInfo){
		return calendarrepo.CalendarList(loginInfo);
	};
	
	public Calendar CalendarDetail(int aidx){
		return calendarrepo.CalendarDetail(aidx);
	};

}
