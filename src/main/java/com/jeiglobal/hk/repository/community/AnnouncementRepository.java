package com.jeiglobal.hk.repository.community;

import java.util.*;

import com.jeiglobal.hk.domain.community.*;
import com.jeiglobal.hk.repository.*;

/**
 * 
 * 클래스명 : AnnouncementRepository.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * Mysql 커뮤니티 -> 알림 관련 Repository
 * src/main/resource/mapper/community/AnnouncementRepository.xml
 */
@PrimaryRepositoryAnnoInterface
public interface AnnouncementRepository {

	public int findTotalArticleCount(Map<String, Object> paramMap);

	public List<Announcement> findAnnouncements(Map<String, Object> paramMap);
	
}
