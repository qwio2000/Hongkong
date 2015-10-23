package com.jeiglobal.hk.controller.diagnosis;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeiglobal.hk.domain.auth.LoginInfo;

/**
 * 
 * 클래스명 : MpiController.java
 *
 * 작성일 : 2015. 9. 16.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * [Diagnosis -> Diagnosis] Controller
 */

@Slf4j
@Controller

public class MpiController {
	
	// 형성평가 입력 화면
	@RequestMapping(value={"/fa/diagnosis/formativeevaluationMpi"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String diagnosisMpi(Model model, @ModelAttribute LoginInfo loginInfo) {
		String userType = loginInfo.getUserType();
		log.debug("Getting mpi Page, UserType : {}", userType);
		
		return "diagnosis/formativeevaluation/input";
	}
	


}