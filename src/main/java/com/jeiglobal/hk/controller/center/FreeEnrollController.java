/**
 * 
 */
package com.jeiglobal.hk.controller.center;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.center.CenterOfStateList;
import com.jeiglobal.hk.domain.center.MemFeeFreeTermList;
import com.jeiglobal.hk.domain.center.PopUpMsgList;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.center.FreeEnrollService;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.MessageSourceAccessor;
import com.jeiglobal.hk.utils.PageUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 클래스명 : FreeEnrollment.java
 *
 * 작성일 : 2015. 10. 26.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 입회비 면제 구간 관리
 */
@Slf4j
@Controller
public class FreeEnrollController {
	
	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private FreeEnrollService freeEnrollService;
	
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.size}")
	private int pageSize;
	//페이지 블럭수	
	@Value("${page.blockSize}")
	private int pageBlockSize;	
	
	
	@RequestMapping(value={"/ja/centers/freeEnrollmentTerm"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getFreeEnrollmentTerm(Model model, @ModelAttribute LoginInfo loginInfo){
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerFreeEnrollmentTerm");
		model.addAttribute("headerScript", headerScript);
		return "center/freeEnrollmentTerm";
	}	
	@RequestMapping(value={"/ja/centers/freeEnrollmentTerm/{pageNum:[0-9]{1,4}}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getFreeEnrollmentTermList(Model model, @ModelAttribute LoginInfo loginInfo, 
		@PathVariable int pageNum) throws ParseException  {
		Map<String, Object> map = new HashMap<>();
		int totalRowCnt = freeEnrollService.getFreeEnrollmentTermCount(loginInfo.getJisaCD());
		PageUtil pageUtil = new PageUtil(pageNum, totalRowCnt, pageSize, pageBlockSize);
		if(pageUtil.getTotalRowCnt() > 0){
			List<MemFeeFreeTermList> dataFreeEnrollmentTermList = freeEnrollService.getFreeEnrollmentTermList(loginInfo.getJisaCD(), pageUtil.getStartRow(), pageUtil.getRowBlockSize());
			log.debug("Getting 입회비 면제 기간 리스트 Page, dataMemFeeFreeTermList : {}", dataFreeEnrollmentTermList);
			map.put("freeEnrollmentTermList", dataFreeEnrollmentTermList);
		}
		map.put("pageInfo", pageUtil);
		return map;
	}
	@RequestMapping(value={"/ja/centers/freeEnrollmentTermRegist"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getFreeEnrollmentTermRegist(Model model, @ModelAttribute LoginInfo loginInfo){
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerFreeEnrollmentTerm");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("freeTypeList", commonService.getCodeDtls("0204", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));		
		return "center/freeEnrollmentTermRegist";
	}	
	@RequestMapping(value={"/ja/centers/freeEnrollmentTermEdit"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getFreeEnrollmentTermEdit(Model model, @ModelAttribute LoginInfo loginInfo, 
			@RequestParam(defaultValue="0") int idx){
		MemFeeFreeTermList dataFreeEnrollmentTermInfo = freeEnrollService.getFreeEnrollmentView(idx);
		String chk = (dataFreeEnrollmentTermInfo == null)? "N" : "Y";
		log.debug("Getting 입회비면제기간수정 Page, dataFreeEnrollmentTermInfo : {}", dataFreeEnrollmentTermInfo);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerFreeEnrollmentTerm");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("freeTypeList", commonService.getCodeDtls("0204", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));		
		model.addAttribute("freeEnrollInfo", dataFreeEnrollmentTermInfo);
		model.addAttribute("idx", idx);
		model.addAttribute("chk", chk);
		return "center/freeEnrollmentTermEdit";
	}		
	@RequestMapping(value={"/ja/centers/freeEnrollmentTermRegist/save"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String saveFreeEnrollmentTerm(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request,
			String freeType, String freeTitle, String startYMD, String endYMD, String stateCD, String chk, int idx) {
		String workId = CommonUtils.getWorkId(request);
		String result = freeEnrollService.getFreeEnrollmentTermSave(idx, loginInfo.getJisaCD(), startYMD, endYMD, freeTitle, freeType, chk, stateCD, workId);
		String msgCode = "";
		if("N".equals(result)){
			msgCode = "freeEnrollmentTerm.save.error";
		}else{
			msgCode = "common.save.success";
		}
		return messageSource.getMessage(msgCode);
	}
	@RequestMapping(value={"/ja/centers/freeEnrollmentTerm/delete"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String removeFreeEnrollmentTerm(int idx) {
		freeEnrollService.removeFreeEnrollmentTerm(idx);
		return messageSource.getMessage("common.delete.success");
	}		
	@RequestMapping(value={"/ja/centers/freeEnrollmentTerm/centerOfState"},method = {RequestMethod.GET}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getPopupMsgCenterOfState(@ModelAttribute LoginInfo loginInfo,
		@RequestParam(defaultValue="") String stateCD, @RequestParam(defaultValue="0") int idx){
		List<CenterOfStateList> dataCenterOfStateList = freeEnrollService.getCenterOfStateList(loginInfo.getJisaCD(), stateCD, idx);
		int totalCnt = dataCenterOfStateList.size();		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("centerOfStateList", dataCenterOfStateList);
		map.put("totalCnt", totalCnt);
		return map;
	}	
	

}
