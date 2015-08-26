package com.jeiglobal.hk.domain.community;

import lombok.*;

/**
 * 첨부파일 정보를 저장하는 객체
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachFile {
	private int fileIdx;					//파일번호(PK)
	private int boardIdx;
	private String fileOriginalName;		//원본파일명
	private String fileName;				//서버에 저장될 파일명
	private long fileSize;					//파일 크기
	private String fileUrl;					//파일 경로
	private String fileExt;					//파일 확장자
	private int fileDownloadCount;			//파일 다운로드 횟수
}