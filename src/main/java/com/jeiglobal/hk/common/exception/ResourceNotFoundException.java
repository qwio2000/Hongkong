package com.jeiglobal.hk.common.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 * 클래스명 : ResourceNotFoundException.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5260199543615666860L;

}
