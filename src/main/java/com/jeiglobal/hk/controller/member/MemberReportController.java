package com.jeiglobal.hk.controller.member;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.service.member.*;

/**
 * 
 * 클래스명 : MemberReportController.java
 *
 * 작성일 : 2015. 9. 17.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * FA : Members => Member Report
 */
@Slf4j
@Controller
public class MemberReportController {
	
	@Autowired
	private MemberSearchService memberSearchService;
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(value={"/fa/members/report"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberReport(Model model,
			@ModelAttribute LoginInfo loginInfo){
		log.debug("report Page");
		return "member/report/report";
	}
	
}
