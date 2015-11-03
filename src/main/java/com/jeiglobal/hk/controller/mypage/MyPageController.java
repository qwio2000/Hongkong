/**
 * 
 */
package com.jeiglobal.hk.controller.mypage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.center.CenterTypeList;
import com.jeiglobal.hk.domain.center.CenterView;
import com.jeiglobal.hk.domain.center.UserList;
import com.jeiglobal.hk.domain.center.UserView;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.center.CenterService;
import com.jeiglobal.hk.utils.CommonUtils;
import com.jeiglobal.hk.utils.MessageSourceAccessor;

import lombok.extern.slf4j.Slf4j;

/**
 * 클래스명 : MyPageController.java
 *
 * 작성일 : 2015. 10. 29.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 지사 + 가맹점 My Page 
 */
@Slf4j
@Controller
public class MyPageController {

	@Autowired
	private MessageSourceAccessor messageSource;
	
	@Autowired
	private CommonService commonService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private CenterService centerService;
	
	/**
	 * 
	 * 가맹점 My Page
	 */
	@RequestMapping(value={"/fa/mypage"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getMyPageOfFA(Model model, @ModelAttribute LoginInfo loginInfo) {
		
		// 센터 정보
		CenterView dataCenterInfo = centerService.getCenterView(loginInfo.getJisaCD(), loginInfo.getDeptCD());
		// User 정보 
		UserView dataUserInfo = centerService.getUserView(loginInfo.getUserId());
		String chk = (dataCenterInfo == null)? "N" : "Y";
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("mypage");
		model.addAttribute("headerScript", headerScript);		
		model.addAttribute("centerInfo", dataCenterInfo);
		model.addAttribute("userInfo", dataUserInfo);
		model.addAttribute("chk", chk);		
		
		return "mypage/myPageOfCenter";
	}
	@RequestMapping(value={"/fa/mypage/centerInfoEdit"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getCenterInfoEdit(Model model, @ModelAttribute LoginInfo loginInfo, String deptCD){
		List<CenterTypeList> dataCenterTypeList = centerService.getCenterTypeList(loginInfo.getJisaCD());
		CenterView dataCenterInfo = centerService.getCenterView(loginInfo.getJisaCD(), deptCD);
		String chk = (dataCenterInfo == null)? "N" : "Y";	
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("mypage");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("statusCDList", commonService.getCodeDtls("0307", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("rtyTypeList", commonService.getCodeDtls("0304", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));
		model.addAttribute("centerTypeList", dataCenterTypeList);
		model.addAttribute("centerInfo", dataCenterInfo);
		model.addAttribute("chk", chk);
		return "mypage/centerInfoEdit";
	}
	
	@RequestMapping(value={"/ja/mypage/userEdit","/fa/mypage/userEdit"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getUserEdit(Model model, @ModelAttribute LoginInfo loginInfo, String deptCD, String userId){
		
		UserView dataUserInfo = centerService.getUserView(userId);
		String chk = (dataUserInfo == null)? "N" : "Y";
		
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("mypage");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("userLevelList", commonService.getCodeDtls("0401", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("userInfo", dataUserInfo);
		model.addAttribute("deptCD", deptCD);
		model.addAttribute("userId", userId);
		model.addAttribute("chk", chk);
		return "mypage/userEdit";
	}	
	@RequestMapping(value={"/ja/mypage/userSaveJson","/fa/mypage/userSaveJson"},method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String getUserSaveJson(@ModelAttribute LoginInfo loginInfo, HttpServletRequest request,
		String deptCD, String userId, String dutyCD, String userLevel, String userFstName, String userLstName,
		String email, String phone, String title, String department, String userPwd, String statusCD, String oldUserPwd, String pwdChgFlag, String userType){
		
		String newUserPwd = "";
		if("Y".equals(pwdChgFlag)){
			newUserPwd = passwordEncoder.encode(userPwd);
		}else{
			newUserPwd = oldUserPwd;
		}
		String workId = CommonUtils.getWorkId(request);
		String result = centerService.getUserSave(loginInfo.getJisaCD(),deptCD, userId, userType, userLevel, dutyCD, userFstName, userLstName, email,  phone,  title,  department, newUserPwd, statusCD, workId);		
		String msgCode = "";
		if("N1".equals(result)){
			msgCode = "user.save.error.n1";
		}else if("N2".equals(result)){
			msgCode = "user.save.error.n2";
		}else{
			msgCode = "common.save.success";
		}
		return messageSource.getMessage(msgCode);
	}	
	
	/**
	 * 
	 * 지사 My Page
	 */	
	@RequestMapping(value={"/ja/mypage"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String getMyPageOfJA(Model model, @ModelAttribute LoginInfo loginInfo) {
		// User 정보		
		CenterView dataCenterInfo = centerService.getCenterView(loginInfo.getJisaCD(), loginInfo.getDeptCD()); 
		UserView dataUserInfo = centerService.getUserView(loginInfo.getUserId());
		List<UserList> dataUserList = centerService.getUserList(loginInfo.getJisaCD(),  loginInfo.getDeptCD());
		String chk = (dataCenterInfo == null)? "N" : "Y";
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("centerView");
		model.addAttribute("headerScript", headerScript);		
		model.addAttribute("centerInfo", dataCenterInfo);
		model.addAttribute("userInfo", dataUserInfo);
		model.addAttribute("userList", dataUserList);
		model.addAttribute("chk", chk);		
		
		return "mypage/myPage";
		
	}
	
	
}
