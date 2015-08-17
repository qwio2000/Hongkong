package com.jeiglobal.hk.controller;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.repository.*;
import com.jeiglobal.hk.util.*;

/**
 * 클래스명 : HomeController.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * HomeController
 */
@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private TestMapper testMapper;
	@Autowired
	private MssqlRepository mssqlRepository;
	@Autowired
	private MessageSourceAccessor messageSource;// message 사용

	@RequestMapping("/")
	public String getHomePage() {
		LOGGER.debug("Getting Home Page");
		return "home";
	}

	@ResponseBody
	@RequestMapping("/mysql")
	public String getBoardSubject(
			@RequestParam(defaultValue = "1", required = false) int boardIdx, Locale locale) {
		//Default Locale : ko_KR => message_ko_KR.properties에 존재하는 메세지를 읽음
		LOGGER.info("### Get Board Subject : BoardIdx is {}", boardIdx);
		LOGGER.info("### ko_KR Message : Code is {}, Message is {}","MyName.FirstName", messageSource.getMessage("MyName.FirstName", locale));
		LOGGER.info("### ko_KR Message : Code is {}, Message is {}","MyName.SecondName", messageSource.getMessage("MyName.SecondName", locale));
		//Locale을 영어로 변경 => message_en_US.properties에 존재하는 메세지를 읽음
		Locale enLocale = new Locale("en_US");
		LOGGER.info("### en_US Message : Code is {}, Message is {}","MyName.FirstName", messageSource.getMessage("MyName.FirstName", enLocale));
		LOGGER.info("### en_US Message : Code is {}, Message is {}","MyName.SecondName", messageSource.getMessage("MyName.SecondName", enLocale));
		return "boardIdx : "+boardIdx+", boardSubject : "+testMapper.getBoardSubject(boardIdx);
	}
	@ResponseBody
	@RequestMapping("/mssql")
	public String getSHA256(
			@RequestParam(defaultValue = "00713", required = false) String empKey) {
		String pwdHash = mssqlRepository.getPwdHash(empKey);
		return "pwdHash : "+pwdHash;
	}
}
