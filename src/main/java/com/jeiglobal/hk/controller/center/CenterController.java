package com.jeiglobal.hk.controller.center;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeiglobal.hk.domain.CodeDtl;
import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.center.CenterSearchList;
import com.jeiglobal.hk.domain.center.CenterView;
import com.jeiglobal.hk.domain.center.MemFeeInfoList;
import com.jeiglobal.hk.domain.center.UserList;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.center.CenterService;
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
	private CommonService memberRegistService;	
	
	@Autowired
	private CenterService centerService;
	
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.size}")
	private int pageSize;
	
	//페이지 블럭수
	@Value("${page.blockSize}")
	private int blockSize;
	
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
		@RequestParam(defaultValue="1") String statusCD){		
		
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
		@RequestParam(defaultValue="1") String statusCD, 
		@RequestParam(defaultValue="") String sortKind, 
		@RequestParam(defaultValue="") String sort){
		
		List<CenterSearchList> dataCenterSearchList = centerService.getCenterSearchList(loginInfo.getJisaCD(), deptName, city, stateCD, statusCD, sortKind, sort, pageNum, pageSize);
		//log.debug("Getting centerSearchResult Page, dataCenterSearchList : {}", dataCenterSearchList);
		
		int totalCnt = (dataCenterSearchList.size()>0)? dataCenterSearchList.get(0).getRCnt() : 0;
		PageUtil pageUtil = new PageUtil(pageNum, totalCnt, pageSize, blockSize);		
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
	
	
	// 센터 등록
	@RequestMapping(value={"/ja/centers/centerRegist"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterRegist(Model model, @ModelAttribute LoginInfo loginInfo){
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerRegist");
		model.addAttribute("headerScript", headerScript);
		return "center/centerRegist";
	}	
	// 센터 상담 이력 등록
	@RequestMapping(value={"/ja/centers/centerCommentCallRegist"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterCommentCallRegist(Model model, @ModelAttribute LoginInfo loginInfo){
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerCommentCallRegist");
		model.addAttribute("headerScript", headerScript);
		return "center/centerCommentCallRegist";
	}		
	// 사용자 등록
	@RequestMapping(value={"/ja/centers/userRegist"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getUserRegist(Model model, @ModelAttribute LoginInfo loginInfo){
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("userRegist");
		model.addAttribute("headerScript", headerScript);
		return "center/userRegist";
	}
	// 사용자 정보 수정
	@RequestMapping(value={"/ja/centers/userEdit"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getUserEdit(Model model, @ModelAttribute LoginInfo loginInfo){
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("userEdit");
		model.addAttribute("headerScript", headerScript);
		return "center/userEdit";
	}	

	// 가맹점 정보 변경
	@RequestMapping(value={"/ja/centers/centerInfoEdit"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterInfoEdit(Model model, @ModelAttribute LoginInfo loginInfo){
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerInfoEdit");
		model.addAttribute("headerScript", headerScript);
		return "center/centerInfoEdit";
	}	
	// 가맹점 운영시간 변경
	@RequestMapping(value={"/ja/centers/centerHours"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterBusinessClassroomHours(Model model, @ModelAttribute LoginInfo loginInfo,
		String deptCD, String oHoursStart, String oHoursEnd, String cHoursStart, String cHoursEnd){
		
		//가맹점 시간 리스트
		//List<CodeDtl> manageTimes = memberRegistService.getManageTimes(loginInfo.getJisaCD(), deptCD);
		
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerHours");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("oHoursStart", oHoursStart);
		model.addAttribute("oHoursEnd", oHoursEnd);
		model.addAttribute("cHoursStart", cHoursStart);
		model.addAttribute("cHoursEnd", cHoursEnd);
		return "center/centerHours";
	}	
	// 가맹점 출시 상품 셋팅/변경
	@RequestMapping(value={"/ja/centers/centerSetSubjPreference"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterSetSubjPreference(Model model, @ModelAttribute LoginInfo loginInfo){
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerSetSubjPreference");
		model.addAttribute("headerScript", headerScript);
		return "center/centerSetSubjPreference";
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
