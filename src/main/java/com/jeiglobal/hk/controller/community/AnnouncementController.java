package com.jeiglobal.hk.controller.community;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.service.community.*;
import com.jeiglobal.hk.utils.*;

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
	private static final int PAGE_BLOCK_SIZE = 10;
	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private AnnouncementService announcementService;
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getAnnouncementsPage(Model model){
		LOGGER.debug("Getting Notices List Page");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("announcement");
		model.addAttribute("headerScript", headerScript);
		return "community/announcement/list";
	}
	
	@RequestMapping(value="/{pageNum:[0-9]+}",method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getAnnouncementsListJson(Model model, 
			@PathVariable int pageNum,
			@RequestParam(value="searchField", required=false) String searchField,
			@RequestParam(value="searchValue", required=false) String searchValue){
		LOGGER.debug("Getting Notices List Articles");
		LOGGER.debug("searchField : {}, searchValue : {}", searchField, searchValue);
		int totalRowCnt = announcementService.getArticleCnt(searchField, searchValue);
		LOGGER.debug("totalRowCount : {}", totalRowCnt);
		PageUtil pageUtil = new	PageUtil(pageNum, totalRowCnt, PAGE_SIZE, PAGE_BLOCK_SIZE);
		
		Map<String,Object> map = new HashMap<>();
		map.put("pageInfo",pageUtil);
		map.put("articles",announcementService.getArticles(pageUtil.getStartRow(),pageUtil.getEndRow(), searchField, searchValue));
		
		return map;
	}
	
//	@RequestMapping(value="/{boardIdx}", method = {RequestMethod.GET, RequestMethod.HEAD})
//	public String getAnnouncementPage(Model model){
//		LOGGER.debug("Getting Notices List Page");
//		List<String> headerScript = new ArrayList<String>();
//		headerScript.add("announcement");
//		model.addAttribute("headerScript", headerScript);
//		return "community/announcement/list";
//	}
	
}
