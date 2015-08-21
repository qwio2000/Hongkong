package com.jeiglobal.hk.controller.community;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.util.*;

/**
 * 클래스명 : AnnouncementController.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * [Community -> Announcement] Controller
 */
@Controller
@RequestMapping(value="/community/announcements")
public class AnnouncementController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AnnouncementController.class);
	
	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getNoticesPage(Model model){
		LOGGER.debug("Getting Notices List Page");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("announcement");
		model.addAttribute("headerScript", headerScript);
		return "community/announcement/list";
	}
	
	
}
