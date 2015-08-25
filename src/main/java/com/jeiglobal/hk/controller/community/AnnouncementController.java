package com.jeiglobal.hk.controller.community;

import java.util.*;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.community.*;
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
	public String getAnnouncementsPage(Model model, @RequestParam(defaultValue="1") int pageNum){
		LOGGER.debug("Getting Notices List Page");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("announcement");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("pageNum", pageNum);
		return "community/announcement/list";
	}
	
	@RequestMapping(value="/page/{pageNum:[0-9]+}",method = {RequestMethod.GET, RequestMethod.HEAD}, produces = "application/json; charset=utf8")
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
	
	@RequestMapping(value="/{idx:[0-9]+}", method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getAnnouncementPage(Model model,
			@PathVariable int idx,
			@RequestParam(defaultValue="1") int pageNum){
		LOGGER.debug("Getting Announcement Content Page, Article No : {} ", idx);
		Announcement article = announcementService.getAnnouncementByIdx(idx);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("announcement");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("article", article);
		model.addAttribute("pageNum", pageNum);
		return "community/announcement/view";
	}
	
	@RequestMapping(value="/new", method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getAnnouncementWritePage(Model model){
		LOGGER.debug("Getting Announcement Write Page");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("announcement");
		model.addAttribute("headerScript", headerScript);
		return "community/announcement/write";
	}

	@RequestMapping(method = {RequestMethod.POST})
	public String addAnnouncement(Model model, 
			Announcement announcement, 
			HttpServletResponse response,
			Locale locale) throws Exception{
		LOGGER.debug("Add Adding Announcement : {}", announcement);
		int addIdx = announcementService.addAnnouncement(announcement);
		LOGGER.debug("After Adding Announcement idx : {}", addIdx);
		String alertMsg = "";
		Object[] MessageArgs = {"등록"};
		if(addIdx == 0) {
			LOGGER.error("announcement Insert Error : {}", announcement);
			alertMsg = messageSource.getMessage("Community.Announcement.Error", MessageArgs, locale);
		}else{
			LOGGER.info("announcement Insert Success : boardIdx = {}", addIdx);
			alertMsg = messageSource.getMessage("Community.Announcement.Success", MessageArgs, locale);
		}
		model.addAttribute("message", alertMsg);
		model.addAttribute("url", "/community/announcements");
		return "alertAndRedirect";
	}
	
	@RequestMapping(value="/{idx:[0-9]+}/edit",method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getAnnouncementEditForm(Model model,
			@PathVariable int idx) {
		LOGGER.debug("Getting Announcement Edit Form : idx = {}", idx);
		Announcement announcement = announcementService.getAnnouncementByIdx(idx);
		model.addAttribute("article", announcement);
		return "community/announcement/write";
	}
	
	@RequestMapping(value="/{idx:[0-9]+}",method = {RequestMethod.DELETE}, produces = "application/json; charset=utf8")
	@ResponseBody
	public Map<String, Object> deleteAnnouncementJson(@PathVariable int idx, Locale locale) {
		LOGGER.debug("Deleting Announcement : idx = {}", idx);
		int deleteRowCount = announcementService.removeAnnouncementByIdx(idx);
		String alertMsg = "";
		Object[] MessageArgs = {"삭제"};
		if(deleteRowCount > 0) {
			LOGGER.info("announcement Delete Success : idx = {}", idx);
			alertMsg = messageSource.getMessage("Community.Announcement.Success", MessageArgs, locale);
		}else{
			LOGGER.error("announcement Delete Error : idx = {}", idx);
			alertMsg = messageSource.getMessage("Community.Announcement.Error", MessageArgs,locale);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", alertMsg);
		return map;
	}
	
	@RequestMapping(value="/{idx:[0-9]+}",method = {RequestMethod.PUT})
	public String setAnnouncement(Model model,
			@PathVariable int idx, 
			@RequestParam(value="submitType") int submitType,
			Announcement announcement,
			Locale locale) {
		LOGGER.debug("Editing Announcement : idx = {}, announcement = {}", idx, announcement);
		int updateRowCount = announcementService.setAnnouncementByIdx(idx, announcement);
		String alertMsg = "";
		Object[] MessageArgs = {"수정"};
		if(updateRowCount > 0) {
			LOGGER.info("announcement Update Success : boardIdx = {}", idx);
			alertMsg = messageSource.getMessage("Community.Announcement.Success", MessageArgs, locale);
		}else{
			LOGGER.error("announcement Update Error : {}", announcement);
			alertMsg = messageSource.getMessage("Community.Announcement.Error", MessageArgs, locale);
		}
		model.addAttribute("message", alertMsg);
		model.addAttribute("url", "/community/announcements/"+idx);
		return "alertAndRedirect";
	}
}
