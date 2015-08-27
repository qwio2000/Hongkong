package com.jeiglobal.hk.service.community;

import java.io.*;
import java.util.*;

import org.apache.commons.lang.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.community.*;
import com.jeiglobal.hk.repository.community.*;
/**
 * 
 * 클래스명 : AnnouncementService.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 알림에 관련된 비즈니스 로직을 처리하는 서비스
 */
@Service
public class AnnouncementService {
	
	@Autowired
	private AnnouncementRepository announcementRepository;

	@Value("${uploadpath.announcements}")
	private String uploadPath;

	public int getArticleCnt(String searchField, String searchValue) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchField", searchField);
		paramMap.put("searchValue", searchValue);
		return announcementRepository.findTotalArticleCount(paramMap);
	}

	public List<Announcement> getArticles(int startRow, int endRow, String searchField, String searchValue) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		paramMap.put("searchField", searchField);
		paramMap.put("searchValue", searchValue);
		return announcementRepository.findAnnouncements(paramMap);
	}

	public Announcement getAnnouncementByIdx(int idx) {
		announcementRepository.updateAnnouncementReadCount(idx);
		Announcement article = announcementRepository.findAnnouncement(idx);
		article.setAttachFiles(getAttachFiles(idx));
		article.setBoardContent(article.getBoardContent().replaceAll("\r\n", "<br/>"));
		return article;
	}

	public int addAnnouncement(Announcement announcement, List<MultipartFile> mf) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		announcement.setBoardContent(escapeHtml(announcement));
		announcement.setMemberId(((LoginInfo)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getMemberId());
		announcementRepository.insertAnnouncement(announcement);
		insertAttachFiles(mf, announcement.getBoardIdx());
		return announcement.getBoardIdx();
	}

	private void insertAttachFiles(List<MultipartFile> mf, int boardIdx) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		File dir = new File(uploadPath);
		if(!dir.isDirectory()){
			dir.mkdirs();
		}
		for (int i = 0; i < mf.size(); i++) {
			if(!"".equals(mf.get(i).getOriginalFilename())){
				AttachFile attachFile = new AttachFile(0,
						boardIdx,
						mf.get(i).getOriginalFilename(), 
						getFileName(mf.get(i).getOriginalFilename()),
						mf.get(i).getSize(), 
						uploadPath,
						getExtension(mf.get(i).getOriginalFilename()), 
						0);
				String savePath = uploadPath + File.separator + attachFile.getFileName();
				mf.get(i).transferTo(new File(savePath));
				announcementRepository.insertAttachFile(attachFile);
			}
		}
	}

	private String getFileName(String originalFilename) {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString() + "." + getExtension(originalFilename);
	}

	public int removeAnnouncementByIdx(int idx) {
		// TODO Auto-generated method stub
		announcementRepository.deleteCommentByBoardIdx(idx);
		return announcementRepository.deleteAnnouncement(idx);
	}

	public int setAnnouncementByIdx(int idx, Announcement announcement, List<MultipartFile> mf) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		insertAttachFiles(mf, idx);
		announcement.setBoardContent(escapeHtml(announcement));
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("idx", idx);
		paramMap.put("announcement", announcement);
		return announcementRepository.updateAnnouncement(paramMap);
	}
	
	private String escapeHtml(Announcement announcement) {
		// TODO Auto-generated method stub
		return StringEscapeUtils.escapeHtml(announcement.getBoardContent());
	}

	private String getExtension(String originalFilename) {
		// TODO Auto-generated method stub
		return originalFilename.substring(originalFilename.lastIndexOf(".")+1);
	}

	public List<AttachFile> getAttachFiles(int idx) {
		// TODO Auto-generated method stub
		return announcementRepository.findAttachFiles(idx);
	}

	public int setFileDownloadCount(int fileIdx) {
		// TODO Auto-generated method stub
		return announcementRepository.updateFileDownloadCount(fileIdx);
	}

	public File getDownloadFile(String fileName) {
		// TODO Auto-generated method stub
		return new File(uploadPath + File.separator + fileName);
	}

	public int removeAttachFileByFileIdx(int fileIdx) {
		// TODO Auto-generated method stub
		AttachFile attachFile = announcementRepository.findAttachFile(fileIdx);
		deleteAttachFile(attachFile);
		return announcementRepository.deleteAttachFileByFileIdx(fileIdx);
	}

	private void deleteAttachFile(AttachFile attachFile) {
		// TODO Auto-generated method stub
		File realFile = new File(attachFile.getFileUrl()+File.separator+attachFile.getFileName());
		if(realFile.exists()){
			realFile.delete();
		}
	}

	public void addComment(int idx, String commentContent, String memberId) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("idx", idx);
		paramMap.put("content", commentContent);
		paramMap.put("memberId", memberId);
		announcementRepository.insertComment(paramMap);
	}

	public List<Comment> getComments(int idx) {
		// TODO Auto-generated method stub
		return announcementRepository.findCommentsByIdx(idx);
	}

	public int removeCommentByCommentIdx(int commentIdx) {
		// TODO Auto-generated method stub
		return announcementRepository.deleteCommentByCommentIdx(commentIdx);
	}
}
