package com.jeiglobal.hk.utils;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.web.util.*;

import com.jeiglobal.hk.domain.member.MemberDto.MonthInfo;

/**
 * 
 * 클래스명 : CommonUtils.java
 *
 * 작성일 : 2015. 9. 7.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 공통 유틸 클래스
 */
public class CommonUtils {

	/**
	 * 파일 확장자만 추출
	 * 
	 * @param originalFilename
	 * @return String
	 */
	public static String getExtension(String originalFilename) {
		return originalFilename
				.substring(originalFilename.lastIndexOf(".") + 1);
	}

	/**
	 * 서버에 저장할 고유한 파일명 생성
	 * 
	 * @param originalFilename
	 * @return String
	 */
	public static String getFileName(String originalFilename) {
		return UUID.randomUUID().toString() + "."
				+ getExtension(originalFilename);
	}

	/**
	 * 쿠키 추가
	 * 
	 * @param cookieName
	 * @param cookieValue
	 * @param cookieDomain
	 * @param response
	 */
	public static void addCookie(String cookieName, String cookieValue,
			String cookieDomain, HttpServletResponse response) {
		try {
			Cookie cookie = new Cookie(cookieName, URLEncoder.encode(
					cookieValue, "utf-8"));
			cookie.setPath("/");
			if (!"localhost".contains(cookieDomain)) {// localhost는 적용 안됨,
				cookie.setDomain(cookieDomain);
			}
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 쿠키 삭제
	 * 
	 * @param cookieName
	 * @param cookieDomain
	 * @param response
	 */
	public static void removeCookie(String cookieName, String cookieDomain,
			HttpServletResponse response) {
		Cookie cookie = new Cookie(cookieName, "");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		if (!"localhost".contains(cookieDomain)) {// localhost는 적용 안됨,
			cookie.setDomain(cookieDomain);
		}
		response.addCookie(cookie);
	}

	public static List<String> weekCalendar(String day) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yy");
		Calendar cal = Calendar.getInstance();
		if(!"".equals(day)){
			cal.setTime(sdf.parse(day));
		}
		List<String> rtnList = new ArrayList<String>();
		rtnList.add(String.valueOf(cal.get(Calendar.WEEK_OF_MONTH)));
		cal.add(Calendar.DATE, -(cal.get(Calendar.DAY_OF_WEEK) - 1));
		rtnList.add(sdf.format(cal.getTime()));
		cal.add(Calendar.DATE, 6);
		rtnList.add(sdf.format(cal.getTime()));
		return rtnList;
	}

	/**
	 * 
	 * @return List<CodeDtl>
	 */
	public static List<MonthInfo> getMonths() {
		List<MonthInfo> months = new ArrayList<MonthInfo>();
		DateFormatSymbols dateFormatSymbolsEng = new DateFormatSymbols(Locale.ENGLISH);
		String[] shortMonths = dateFormatSymbolsEng.getShortMonths();
		String[] monthNum = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		for (int i = 0; i < monthNum.length; i++) {
			months.add(new MonthInfo(monthNum[i], shortMonths[i]));
		}
		return months;
	}

	/**
	 * @param currentYear
	 * @param currentMonth
	 * @return int
	 */
	public static int getMaxDays(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 현재 사용자의 Id를 가져오기 
	 * 자동로그인으로 들어온 경우 원래 사용자 아이디 가져옴
	 * @param request
	 * @return String
	 */
	public static String getWorkId(HttpServletRequest request){
		String workId = "";
		Cookie cookie = WebUtils.getCookie(request, "BmsAUTHId");
		if(cookie != null){//Bms쿠키가 있는 경우
			workId = cookie.getValue();
		}else{//Bms 없는 경우 지사 쿠키 정보 찾기
			cookie = WebUtils.getCookie(request, "JisaAUTHId");
			if(cookie != null){
				workId = cookie.getValue();
			}else{
				workId = WebUtils.getCookie(request, "AUTHId").getValue();
			}
		}
		return workId;
	}
	
	/**
	 * 오늘 날짜 yyyy-MM-dd 형태로 가져오기
	 * @return String
	 */
	public static String getCurrentYMD(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	/**
	 * 입력 받은 날짜를 yyyy-MM-dd 형태로 가져오기
	 * @param date
	 * @return String
	 */
	public static String getDateForFormat(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static String changeDateFormat(String beforePattern, String afterPattern, String value) throws ParseException{
		SimpleDateFormat beforeSdf = new SimpleDateFormat(beforePattern);
		SimpleDateFormat afterSdf = new SimpleDateFormat(afterPattern);
		Date valueDate = beforeSdf.parse(value);
		return afterSdf.format(valueDate);
	}

	/**
	 * @param firstManageDate 
	 * @return int
	 * @throws ParseException 
	 */
	public static int getRemainWeekNum(String firstManageDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar end = Calendar.getInstance();
		int endDate = end.getMaximum(Calendar.DAY_OF_MONTH);
		end.setTime(sdf.parse(firstManageDate));
		int manageDay = end.get(Calendar.DATE);
		int week = (int) Math.ceil(((double)(endDate - manageDay)/7));
		week = (week > 4)? 4 : week; // 4주 이상 모두 4로 변경
		return week;
	}
}
