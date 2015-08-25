package com.jeiglobal.hk.service.community;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;

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
		return announcementRepository.findAnnouncement(idx);
	}

	public int addAnnouncement(Announcement announcement) {
		// TODO Auto-generated method stub
		announcement.setMemberId(((LoginInfo)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getMemberId());
		announcementRepository.insertAnnouncement(announcement);
		return announcement.getBoardIdx();
	}

	public int removeAnnouncementByIdx(int idx) {
		// TODO Auto-generated method stub
		return announcementRepository.deleteAnnouncement(idx);
	}
	
}
