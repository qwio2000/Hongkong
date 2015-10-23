package com.jeiglobal.hk.controller.center;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.center.CenterCommentCallList;
import com.jeiglobal.hk.domain.center.CenterOpenSubjList;
import com.jeiglobal.hk.domain.center.CenterSearchList;
import com.jeiglobal.hk.domain.center.CenterTypeList;
import com.jeiglobal.hk.domain.center.CenterView;
import com.jeiglobal.hk.domain.center.MemFeeInfoList;
import com.jeiglobal.hk.domain.center.RtyChargeGroupList;
import com.jeiglobal.hk.domain.center.UserList;
import com.jeiglobal.hk.domain.center.UserView;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.center.CenterService;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.MessageSourceAccessor;
import com.jeiglobal.hk.utils.PageUtil;

/**
 * 
 * 클래스명 : CenterController.java
 *
 * 작성일 : 2015. 9. 10.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 수정자 : 노윤희(IT지원팀)
 * 
 * [Centers] Controller
 */
@Slf4j
@Controller

public class CenterController {

	@Autowired
	private MessageSourceAccessor messageSource;// message 사용
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private CenterService centerService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;	
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.size}")
	private int pageSize;
	//페이지 블럭수	
	@Value("${page.blockSize}")
	private int pageBlockSize;	
	


	
	// 센터검색
	@RequestMapping(value={"/ja/centers/centerSearch"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterSearch(Model model, @ModelAttribute LoginInfo loginInfo){
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerSearch");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("statusCDList", commonService.getCodeDtls("0307", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));
		return "center/centerSearch";
	}
	
	// 센터 검색 결과
	@RequestMapping(value={"/ja/centers/centerSearchResults"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterSearchResult(Model model, @ModelAttribute LoginInfo loginInfo,
		@RequestParam(defaultValue="") String deptName, 
		@RequestParam(defaultValue="") String city, 
		@RequestParam(defaultValue="") String stateCD, 
		@RequestParam(defaultValue="") String statusCD){		
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerSearch");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("deptName", deptName);
		model.addAttribute("city", city);
		model.addAttribute("stateCD", stateCD);
		model.addAttribute("statusCD", statusCD);
		return "center/centerSearchResult";
	}	
	
	// 센터 검색 결과 리스트 JSON
	@RequestMapping(value={"/ja/centers/centerSearchResultJson"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getCenterSearchResultJson(@ModelAttribute LoginInfo loginInfo,
		@RequestParam(defaultValue="1") int pageNum, 
		@RequestParam(defaultValue="") String deptName, 
		@RequestParam(defaultValue="") String city, 
		@RequestParam(defaultValue="") String stateCD, 
		@RequestParam(defaultValue="") String statusCD, 
		@RequestParam(defaultValue="") String sortKind, 
		@RequestParam(defaultValue="") String sort){
		
		List<CenterSearchList> dataCenterSearchList = centerService.getCenterSearchList(loginInfo.getJisaCD(), deptName, city, stateCD, statusCD, sortKind, sort, pageNum, pageSize);
		//log.debug("Getting centerSearchResult Page, dataCenterSearchList : {}", dataCenterSearchList);
		
		int totalCnt = (dataCenterSearchList.size()>0)? dataCenterSearchList.get(0).getRCnt() : 0;
		PageUtil pageUtil = new PageUtil(pageNum, totalCnt, pageSize, pageBlockSize);		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("centerSearchList", dataCenterSearchList);
		map.put("pageInfo", pageUtil);
		return map;
	}	
		
	// 센터 뷰
	@RequestMapping(value={"/ja/centers/centerView"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterView(Model model, @ModelAttribute LoginInfo loginInfo, String deptCD){
		// 센터 정보
		CenterView dataCenterInfo = centerService.getCenterView(loginInfo.getJisaCD(), deptCD);
		// User list 
		List<UserList> dataUserList = centerService.getUserList(loginInfo.getJisaCD(), deptCD);
		log.debug("Getting centerView Page, dataUserList : {}", dataUserList);

		String chk = (dataCenterInfo == null)? "N" : "Y";
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerView");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("centerInfo", dataCenterInfo);
		model.addAttribute("userList", dataUserList);
		model.addAttribute("chk", chk);
		return "center/centerView";
	}

	
	// 가맹점 운영시간 셋팅
	@RequestMapping(value={"/ja/centers/centerSetHours"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterBusinessClassroomHours(Model model, @ModelAttribute LoginInfo loginInfo,
			String deptCD, String oHoursStart, String oHoursEnd, String cHoursStart, String cHoursEnd){
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerView");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("centerTimes", commonService.getCodeDtls("0206", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("deptCD", deptCD);		
		model.addAttribute("oHoursStart", oHoursStart);
		model.addAttribute("oHoursEnd", oHoursEnd);
		model.addAttribute("cHoursStart", cHoursStart);
		model.addAttribute("cHoursEnd", cHoursEnd);
		return "center/centerSetHours";
	}
	@RequestMapping(value={"/ja/centers/centerHoursSaveJson"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String getCenterHoursSaveJson(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request,
		String deptCD, String oHoursStart, String oHoursEnd, String cHoursStart, String cHoursEnd){
		
		String workId = CommonUtils.getWorkId(request);
		String rerult = centerService.getCenterHoursSave(loginInfo.getJisaCD(),deptCD, oHoursStart, oHoursEnd, cHoursStart, cHoursEnd, workId);		
		String msgCode = "";
		if("Y".equals(rerult)){
			msgCode = "common.save.success";
		}else{
			msgCode = "common.save.error";
		}

		return messageSource.getMessage(msgCode);
	}
	
	// 가맹점 출시 상품 셋팅/변경
	@RequestMapping(value={"/ja/centers/centerSetSubjPreference"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterSetSubjPreference(Model model, @ModelAttribute LoginInfo loginInfo,
		String deptCD){
		
		List<CenterOpenSubjList> dataCenterOpenSubjList = centerService.getCenterOpenSubjList(loginInfo.getJisaCD(), deptCD);
		String 	chk = (dataCenterOpenSubjList.size()>0)? "Y" : "N";
		log.debug("Getting centerView Page, dataCenterOpenSubjList : {}", dataCenterOpenSubjList);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerView");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("centerOpenSubjList", dataCenterOpenSubjList);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("chk", chk);
		return "center/centerSetSubjPreference";
	}
	@RequestMapping(value={"/ja/centers/centerSubjPreferenceSaveJson"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String getCenterOpenSubjSaveJson(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request,
		String deptCD, String openSubj){
		
		String workId = CommonUtils.getWorkId(request);
		String rerult = centerService.getCenterOpenSubjSave(loginInfo.getJisaCD(),deptCD, openSubj, workId);		
		String msgCode = "";
		if("Y".equals(rerult)){
			msgCode ="common.save.success";
		}else{
			msgCode = "common.save.error";
		}
		return messageSource.getMessage(msgCode);
	}	
	// 회비 정보
	@RequestMapping(value={"/ja/centers/tuitionMatrix"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getTuitionMatrix(Model model, @ModelAttribute LoginInfo loginInfo, String deptCD){
		
		List<MemFeeInfoList> dataMemFeeInfoList = centerService.getMemFeeInfoList(loginInfo.getJisaCD(), deptCD);
		log.debug("Getting centerView Page, dataMemFeeInfoList : {}", dataMemFeeInfoList);
		
		int 	registFee 	= (dataMemFeeInfoList.size()>0)? dataMemFeeInfoList.get(0).getRegistFee() : 0;
		int 	monthFee 	= (dataMemFeeInfoList.size()>0)? dataMemFeeInfoList.get(0).getMonthFee() : 0;
		String 	feeUnitName = (dataMemFeeInfoList.size()>0)? dataMemFeeInfoList.get(0).getFeeUnitName() : "";
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("tuitionMatrix");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("memFeeInfoList", dataMemFeeInfoList);
		model.addAttribute("registFee", registFee);
		model.addAttribute("monthFee", monthFee);
		model.addAttribute("feeUnitName", feeUnitName);
		return "center/tuitionMatrix";
	}		
	// 로열티그룹 정보 팝업
	@RequestMapping(value={"/ja/centers/royaltyGroupInfo"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterRoyaltyGroupInfo(Model model, @ModelAttribute LoginInfo loginInfo){
		List<RtyChargeGroupList> dataRtyChargeGroupList = centerService.getRtyChargeGroupInfoList(loginInfo.getJisaCD());
		log.debug("Getting centerView Page, dataRtyChargeGroupList : {}", dataRtyChargeGroupList);
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerRegist");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("rtyChargeGroupList", dataRtyChargeGroupList);
		return "center/royaltyGroupInfo";
	}	

	/**
	 * 
	 * 센터 등록
	 * 등록/수정
	 * 
	 */ 
	@RequestMapping(value={"/ja/centers/centerRegist"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterRegist(Model model, @ModelAttribute LoginInfo loginInfo){
		List<CenterTypeList> dataCenterTypeList = centerService.getCenterTypeList(loginInfo.getJisaCD());		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerRegist");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("rtyTypeList", commonService.getCodeDtls("0304", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));
		model.addAttribute("centerTypeList", dataCenterTypeList);		
		
		return "center/centerRegist";
	}	
	@RequestMapping(value={"/ja/centers/centerSaveJson"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String getCenterSaveJson(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request,
		String deptCD, String deptName, String deptType, String memType, String feeType, String empFstName, String empLstName,
		String addr, String zip, String city, String stateCD, String email, String phone, String fax, 
		String contractTerm, String contractDate, String openDate, String rtyType, String statusCD){
		
		String workId = CommonUtils.getWorkId(request);
		String rerult = centerService.getCenterSave(loginInfo.getJisaCD(), deptCD, deptName, deptType, memType, feeType, empFstName, empLstName,addr, zip, city, stateCD, email, phone, fax, contractTerm, contractDate, openDate, rtyType, statusCD, workId);
		String msgCode = "";
		if("N1".equals(rerult)){
			msgCode = "user.save.error.n1";
		}else if("N2".equals(rerult)){
			msgCode = "user.save.error.n2";
		}else{
			msgCode = "common.save.success";
		}

		return messageSource.getMessage(msgCode);
	}	
	@RequestMapping(value={"/ja/centers/centerInfoEdit"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterInfoEdit(Model model, @ModelAttribute LoginInfo loginInfo, String deptCD){
		List<CenterTypeList> dataCenterTypeList = centerService.getCenterTypeList(loginInfo.getJisaCD());
		CenterView dataCenterInfo = centerService.getCenterView(loginInfo.getJisaCD(), deptCD);
		String chk = (dataCenterInfo == null)? "N" : "Y";	
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerRegist");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("statusCDList", commonService.getCodeDtls("0307", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("rtyTypeList", commonService.getCodeDtls("0304", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));
		model.addAttribute("centerTypeList", dataCenterTypeList);
		model.addAttribute("centerInfo", dataCenterInfo);
		model.addAttribute("chk", chk);
		return "center/centerInfoEdit";
	}
	
	
		
		
	/**
	 * 센터 상담 팝업
	 * 상담내용 등록/삭제/리스트
	 */
	@RequestMapping(value={"/ja/centers/centerCommentCallRegist"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterCommentCallRegist(Model model, @ModelAttribute LoginInfo loginInfo, String deptCD){
		CenterView dataCenterInfo = centerService.getCenterView(loginInfo.getJisaCD(), deptCD);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerView");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("centerInfo", dataCenterInfo);
		model.addAttribute("deptCD", deptCD);
		return "center/centerCommentCallRegist";
	}	
	@RequestMapping(value={"/ja/centers/centerCommentCallRegist/{pageNum:[0-9]{1,4}}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getCenterCommentCallList(Model model,
			String deptCD, @PathVariable int pageNum) throws ParseException  {
		Map<String, Object> map = new HashMap<>();
		PageUtil pageUtil = new PageUtil(pageNum, centerService.getCenterCommentCallsCount(deptCD), 5, pageBlockSize);
		if(pageUtil.getTotalRowCnt() > 0){
			List<CenterCommentCallList> dataCommentCalls = centerService.getCenterCommentCallList(deptCD, pageUtil.getStartRow(), pageUtil.getRowBlockSize());
			log.debug("Getting centerView Page, commentCalls : {}", dataCommentCalls);
			map.put("commentCalls", dataCommentCalls);
		}
		map.put("pageInfo", pageUtil);
		return map;
	}
	@RequestMapping(value={"/ja/centers/centerCommentCall/insert"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String addCenterCommentCall(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request,
			String deptCD, String callNotes) {
		String workId = CommonUtils.getWorkId(request);
		callNotes = CommonUtils.subStrByte(callNotes, 0, 500, 3);
		centerService.addCenterCommentCall(loginInfo.getJisaCD(), deptCD, callNotes, workId);
		return messageSource.getMessage("common.insert.success");
	}
	@RequestMapping(value={"/ja/centers/centerCommentCall/delete"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String removeCenterCommentCall(int idx) {
		centerService.removeCenterCommentCall(idx);
		return messageSource.getMessage("common.delete.success");
	}	
	
		
	
	/**
	 * 사용자 팝업
	 * 등록/수정/비번초기화
	 */
	@RequestMapping(value={"/ja/centers/userRegist"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getUserRegist(Model model, @ModelAttribute LoginInfo loginInfo, String deptCD){
		// 센터 정보
		CenterView dataCenterInfo = centerService.getCenterView(loginInfo.getJisaCD(), deptCD);
		String chk = (dataCenterInfo == null)? "N" : "Y";
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerView");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("userLevelList", commonService.getCodeDtls("0401", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("centerInfo", dataCenterInfo);
		model.addAttribute("chk", chk);
		model.addAttribute("deptCD", deptCD);		
		
		return "center/userRegist";
	}
	@RequestMapping(value={"/ja/centers/userSaveJson"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String getUserSaveJson(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request,
		String deptCD, String userId, String dutyCD, String userLevel, String userFstName, String userLstName,
		String email, String phone, String title, String department, String userPwd, String statusCD){
		
		String userType = "FA";
		String newUserPwd = "";
		if("".equals(userId)){
			newUserPwd = passwordEncoder.encode(userPwd);
		}else{
			newUserPwd = userPwd;
		}
		String workId = CommonUtils.getWorkId(request);
		String rerult = centerService.getUserSave(loginInfo.getJisaCD(),deptCD, userId, userType, userLevel, dutyCD, userFstName, userLstName, email,  phone,  title,  department, newUserPwd, statusCD, workId);		
		String msgCode = "";
		if("N1".equals(rerult)){
			msgCode = "user.save.error.n1";
		}else if("N2".equals(rerult)){
			msgCode = "user.save.error.n2";
		}else{
			msgCode = "common.save.success";
		}

		return messageSource.getMessage(msgCode);
	}
	@RequestMapping(value={"/ja/centers/changeUserPwdSaveJson"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String getChangeUserPwdSaveJson(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request,
		String deptCD, String userId){
		log.debug(loginInfo.toString());
		String newUserPwd = passwordEncoder.encode(userId);
		String workId = CommonUtils.getWorkId(request);
		centerService.setChangeUserPwdSave(userId, newUserPwd, workId);		
		String msgCode = "common.save.success";
		return messageSource.getMessage(msgCode);
	}
	@RequestMapping(value={"/ja/centers/userEdit"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getUserEdit(Model model, @ModelAttribute LoginInfo loginInfo, String deptCD, String userId){
		
		UserView dataUserInfo = centerService.getUserView(userId);
		String chk = (dataUserInfo == null)? "N" : "Y";
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerView");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("userLevelList", commonService.getCodeDtls("0401", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("userInfo", dataUserInfo);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("userId", userId);
		model.addAttribute("chk", chk);
		return "center/userEdit";
	}	
	
	
	/**
	 * 지사에서 가맹점으로 로그인 할 경우 로그인 처리
	 * 1. 현재 쿠키(AUTHId, AUTHKey)를 다른 쿠키(JisaAUTHId, JisaAUTHKey)에 백업
	 * 2. 로그인 하고자 하는 지사 정보를 AUTHId, AUTHKey로 쿠키 값 변경
	 * 3. Security Context에 위치한 Authentication을 제거
	 * 4. Redirect 요청시 파라미터가 붙지 않도록 model clear
	 * @param memberId 로그인 하고자 하는 가맹점 아이디
	 * @param AuthId 현재 인증 정보를 담고 있는 쿠키의 AUTHId 값
	 * @param AuthKey 현재 인증 정보를 담고 있는 쿠키의 AUTHKey 값
	 * @param request
	 * @param response
	 * @param model
	 * @return 가맹점 계층으로 Redirect
	 */
	@RequestMapping(value="/ja/centers/login",method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getFALogin(String memberId, 
			@CookieValue(value="AUTHId") String AuthId, 
			@CookieValue(value="AUTHKey") String AuthKey,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model){
		centerService.addBackupCookies(AuthId, AuthKey, response);
		centerService.addFACookies(memberId, response);
		HttpSessionSecurityContextRepository hsscr = new HttpSessionSecurityContextRepository();
		HttpRequestResponseHolder hrrh = new HttpRequestResponseHolder(request, response);
		hsscr.loadContext(hrrh).setAuthentication(null);//기존 Authentication에 저장된 객체 제거
		model.asMap().clear();//ModelAttribute parameter 제거
		return "redirect:/fa";
	}
}
