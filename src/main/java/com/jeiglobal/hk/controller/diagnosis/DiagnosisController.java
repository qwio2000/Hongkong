package com.jeiglobal.hk.controller.diagnosis;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeiglobal.hk.controller.HomeController;
import com.jeiglobal.hk.domain.CodeDtl;
import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.diagnosis.Diagnosis;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.diagnosis.DiagnosisService;
import com.jeiglobal.hk.utils.PageUtil;

/**
 * 
 * 클래스명 : DiagnosisController.java
 *
 * 작성일 : 2015. 9. 16.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * [Diagnosis -> Diagnosis] Controller
 */

@Slf4j
@Controller

public class DiagnosisController {
	
	//페이징 범위
	private static final int PAGE_BLOCK_SIZE = 10;
	//한 페이지에 출력할 게시물 개수
	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private DiagnosisService diagnosisService;
	
	@Autowired
	private CommonService commonService;
		
	

	@RequestMapping(value={"/fa/diagnosis/diagnosisSerch","/fa/diagnosis"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String diagnosisSerch(Model model, @ModelAttribute LoginInfo loginInfo) {
		String userType = loginInfo.getUserType();
		log.debug("Getting Diagnosis Page, UserType : {}", userType);
		model.addAttribute("memberStatuses", commonService.getCodeDtls("0008", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("grades", commonService.getCodeDtls("0003", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("subjects", commonService.getCodeDtls("0002", loginInfo.getJisaCD(), 1, "Y"));
		
		return "diagnosis/diagnosisSerch";
	}
	/**
	public String diagnosis(Model model, @RequestParam(defaultValue="1") String page, @RequestParam(defaultValue="10") String pagecnt) {
		log.debug("Getting diagnosis Page");
		List<Diagnosis> diagnosis = diagnosisService.getDiagnosis(page,pagecnt);
		
		model.addAttribute("page", diagnosis);
		
		return "diagnosis/diagnosis";
	}
	**/
	
	@RequestMapping(value={"/fa/diagnosis/diagnosisSerch/search"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String diagnosisSerchFrom(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="2") int pagecnt, String Status, String LastName, String FirstName, String HomePhone, String CellPhone, String Email, String Grade, String Subject) {
		String userType = loginInfo.getUserType();
		log.debug("Getting Diagnosis Page, UserType : {}", userType);
		
		String JisaCD = loginInfo.getJisaCD();
		String DeptCd = loginInfo.getDeptCD();		
		
		List<Diagnosis> diagnosis = diagnosisService.getDiagnosis(page,pagecnt,JisaCD,DeptCd,Status,LastName,FirstName,HomePhone,CellPhone,Email,Grade,Subject);
		
		//페이징 처리에 사용하는 유틸 클래스
		PageUtil pageUtil = new	PageUtil(page, diagnosis.get(0).getTotalCnt(), 2, 10);
System.out.println(pageUtil);
		model.addAttribute("pageUtil", pageUtil);
		model.addAttribute("page", diagnosis);
		
		return "diagnosis/diagnosisSearch/search";
	}

}
