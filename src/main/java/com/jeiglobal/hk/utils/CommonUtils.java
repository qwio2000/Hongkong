package com.jeiglobal.hk.utils;

import java.util.*;

import org.apache.commons.lang.*;


/**
 * 
 * 클래스명 : CommonUtils.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 공통 유틸 클래스
 */
public class CommonUtils {
	
	/**
	 * 파일 확장자만 추출
	 * @param originalFilename
	 * @return String
	 */
	public static String getExtension(String originalFilename){
		return originalFilename.substring(originalFilename.lastIndexOf(".")+1);
	}
	
	/**
	 * HTML 태그 동작 방지
	 * @param content
	 * @return String
	 */
	public static String escapeHtml(String content) {
		// TODO Auto-generated method stub
		return StringEscapeUtils.escapeHtml(content);
	}
	
	/**
	 * 서버에 저장할 고유한 파일명 생성
	 * @param originalFilename
	 * @return String
	 */
	public static String getFileName(String originalFilename) {
		return UUID.randomUUID().toString() + "." + getExtension(originalFilename);
	}
}
