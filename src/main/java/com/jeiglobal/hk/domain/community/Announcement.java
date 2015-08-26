package com.jeiglobal.hk.domain.community;

import java.util.*;

import lombok.*;

/**
 * 클래스명 : Announcement.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Data
public class Announcement {
	private int boardIdx;
	private String memberId;
	private String boardSubject;
	private String boardContent;
	private String boardReadCount;
	private String boardRegDate;
	private List<AttachFile> attachFiles;
}