package com.jeiglobal.hk.domain.community;

import lombok.*;

/**
 * 
 * 클래스명 : Comment.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 댓글 정보
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	private int commentIdx;			//댓글 번호(PK)
	private int boardIdx;			//게시글 번호
	private String memberId;		//댓글 작성자
	private String commentContent;	//댓글 내용
	private String commentRegDate;	//댓글 등록일
	
}
