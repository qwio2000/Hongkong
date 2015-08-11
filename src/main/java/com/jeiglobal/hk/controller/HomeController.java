package com.jeiglobal.hk.controller;


import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.repository.*;

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
    private TestMapper mapper;
    
    @RequestMapping("/")
    public String getHomePage() {
        LOGGER.debug("Getting Home Page");
        return "home";
    }
    
    @ResponseBody
    @RequestMapping("/test")
    public String getBoardSubject(@RequestParam(defaultValue="1", required=false)int boardIdx){
    	LOGGER.info("### Get Board Subject : BoardIdx is {}", boardIdx);
    	return boardIdx+". boardSubject : "+mapper.getBoardSubject(boardIdx);
    }
}
