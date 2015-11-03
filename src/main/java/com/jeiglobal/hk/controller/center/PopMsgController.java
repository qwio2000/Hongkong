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
import com.jeiglobal.hk.domain.center.PopUpMsgList;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.center.PopMsgService;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.MessageSourceAccessor;
import com.jeiglobal.hk.utils.PageUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 클래스명 : PopMsgController.java
 *
 * 작성일 : 2015. 10. 28.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 팝업 메세지 관리
 */
@Slf4j
@Controller
public class PopMsgController {
	
	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private PopMsgService popMsgService;	
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.size}")
	private int pageSize;
	//페이지 블럭수	
	@Value("${page.blockSize}")
	private int pageBlockSize;	
	
	
	@RequestMapping(value={"/ja/centers/popupMsg"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getPopupMsg(Model model, @ModelAttribute LoginInfo loginInfo){
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerPopupMsg");
		model.addAttribute("headerScript", headerScript);
		return "center/popupMsg";
	}	
	@RequestMapping(value={"/ja/centers/popupMsg/{pageNum:[0-9]{1,4}}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getPopupMsgList(Model model, @ModelAttribute LoginInfo loginInfo, 
		@PathVariable int pageNum) throws ParseException  {
		Map<String, Object> map = new HashMap<>();
		int totalRowCnt = popMsgService.getPopMsgCount(loginInfo.getJisaCD());
		PageUtil pageUtil = new PageUtil(pageNum, totalRowCnt, pageSize, pageBlockSize);
		if(pageUtil.getTotalRowCnt() > 0){
			List<PopUpMsgList> dataPopMsgList = popMsgService.getPopMsgList(loginInfo.getJisaCD(), pageUtil.getStartRow(), pageUtil.getRowBlockSize());
			log.debug("Getting 팝업메세지 리스트 Page, dataPopMsgList : {}", dataPopMsgList);
			map.put("popMsgList", dataPopMsgList);
		}
		map.put("pageInfo", pageUtil);
		return map;
	}
	@RequestMapping(value={"/ja/centers/popupMsgRegist"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getPopupMsgRegist(Model model, @ModelAttribute LoginInfo loginInfo){
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerPopupMsg");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));		
		return "center/popupMsgRegist";
	}
	@RequestMapping(value={"/ja/centers/popupMsgEdit"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getPopupMsgEdit(Model model, @ModelAttribute LoginInfo loginInfo, 
			@RequestParam(defaultValue="0") int idx){
		PopUpMsgList dataPopMsgInfo = popMsgService.getPopMsgView(idx);
		String chk = (dataPopMsgInfo == null)? "N" : "Y";
		log.debug("Getting 팝업메세지수정 Page, dataPopMsgInfo : {}", dataPopMsgInfo);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerPopupMsg");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));		
		model.addAttribute("popMsgInfo", dataPopMsgInfo);
		model.addAttribute("idx", idx);
		model.addAttribute("chk", chk);
		return "center/popupMsgEdit";
	}		
	@RequestMapping(value={"/ja/centers/popupMsg/save"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String savePopupMsg(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request,
			String msgTitle, String msg, String startYMD, String endYMD, String stateCD, String chk, int idx) {
		String workId = CommonUtils.getWorkId(request);
		msg = CommonUtils.subStrByte(msg, 0, 500, 3);
		String result = popMsgService.getPopMsgSave(idx, loginInfo.getJisaCD(), startYMD, endYMD, msgTitle, msg, chk, stateCD, workId);
		String msgCode = "";
		if("N".equals(result)){
			msgCode = "popMsg.insert.error";
		}else{
			msgCode = "common.save.success";
		}
		return messageSource.getMessage(msgCode);
	}
	@RequestMapping(value={"/ja/centers/popupMsg/delete"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String removePopupMsg(int idx) {
		popMsgService.removePopMsg(idx);
		return messageSource.getMessage("common.delete.success");
	}		
	@RequestMapping(value={"/ja/centers/popupMsg/centerOfState"},method = {RequestMethod.GET}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getPopupMsgCenterOfState(@ModelAttribute LoginInfo loginInfo,
		@RequestParam(defaultValue="") String stateCD, @RequestParam(defaultValue="0") int idx){
		List<CenterOfStateList> dataCenterOfStateList = popMsgService.getCenterOfStateList(loginInfo.getJisaCD(), stateCD, idx);
		int totalCnt = dataCenterOfStateList.size();		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("centerOfStateList", dataCenterOfStateList);
		map.put("totalCnt", totalCnt);
		return map;
	}	
	
}
