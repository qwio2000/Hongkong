/**
 * 
 */
package com.jeiglobal.hk.domain.center;

import java.util.Date;

import lombok.Data;

/**
 * 클래스명 : CenterCommentCallList.java
 *
 * 작성일 : 2015. 10. 21.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
@Data
public class CenterCommentCallList {

	private int idx;
	private String callDate;
	private String callNotes;
	private String jisaCD;
	private String deptCD;
	private Date regDate;
	private String regID;
}
