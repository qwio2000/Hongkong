package com.jeiglobal.hk.service.center;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.center.CenterCommentCallList;
import com.jeiglobal.hk.domain.center.CenterOpenSubjList;
import com.jeiglobal.hk.domain.center.CenterSearchList;
import com.jeiglobal.hk.domain.center.CenterView;
import com.jeiglobal.hk.domain.center.MemFeeInfoList;
import com.jeiglobal.hk.domain.center.RtyChargeGroupList;
import com.jeiglobal.hk.domain.center.UserList;
import com.jeiglobal.hk.domain.center.UserView;
import com.jeiglobal.hk.repository.center.CenterRepository;
import com.jeiglobal.hk.service.auth.AuthoritiesService;
import com.jeiglobal.hk.utils.CommonUtils;

/**
 * 클래스명 : CenterService.java
 *
 * 작성일 : 2015. 9. 10.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 수정자 : 노윤희(IT지원팀)
 * 
 * Centers 서비스
 */
@Service
public class CenterService {
	
	@Value("${cookieShare.domain}")
	private String cookieDomain;
	
	@Autowired
	private AuthoritiesService authoritiesService;
	
	@Autowired
	private CenterRepository centerRepository;
	
	
	/**
	 * Center 정보 
	 */		
	// 센터 검색 결과 리스트
	public List<CenterSearchList> getCenterSearchList(String jisaCD, String deptName, String city, String stateCD, String statusCD, String sortKind, String sort, int pageNum, int pageSize) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptName", deptName);		
		param.put("city", city);
		param.put("stateCD", stateCD);
		param.put("statusCD", statusCD);		
		param.put("sortKind", sortKind);
		param.put("sort", sort);
		param.put("pageNum", pageNum);
		param.put("pageSize", pageSize);		
		
		return centerRepository.centerSearchList(param);				
	}
	// 센터 뷰 getCenterView
	public CenterView getCenterView(String jisaCD, String deptCD) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		
		return centerRepository.centerView(param);				
	}	

	// 회비 정보 팝업
	public List<MemFeeInfoList> getMemFeeInfoList(String jisaCD, String deptCD) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		return centerRepository.memFeeInfoList(param);				
	}
	// 로열티 그룹 정보 팝업 
	public List<RtyChargeGroupList> getRtyChargeGroupInfoList(String jisaCD) {
		Map<String, Object> param = new HashMap<>();
		param.put("jisaCD", jisaCD);
		return centerRepository.rtyChargeGroupList(param);
	}		
	
	
	// 가맹점 운영시간 셋팅/변경 
	public String getCenterHoursSave(String jisaCD, String deptCD, String oHoursStart, String oHoursEnd, String cHoursStart, String cHoursEnd, String workId) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);		
		param.put("oHoursStart", oHoursStart);
		param.put("oHoursEnd", oHoursEnd);
		param.put("cHoursStart", cHoursStart);
		param.put("cHoursEnd", cHoursEnd);
		param.put("workId", workId);
		return centerRepository.centerHoursSave(param);				
	}
	// 상품 정보 팝업
	public List<CenterOpenSubjList> getCenterOpenSubjList(String jisaCD, String deptCD) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		return centerRepository.centerOpenSubjList(param);				
	}	
	public String getCenterOpenSubjSave(String jisaCD, String deptCD, String openSubj, String workId) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);		
		param.put("openSubj", openSubj);
		param.put("workId", workId);
		return centerRepository.centerOpenSubjSave(param);				
	}	
	
	
	/**
	 * 센터 상담 정보 
	 */	
	public int getCenterCommentCallsCount(String deptCD) {
		return centerRepository.findCenterCommentCallsCount(deptCD);
	}	
	public List<CenterCommentCallList> getCenterCommentCallList(String deptCD, int startRow,
			int rowBlockSize) throws ParseException {
		Map<String, Object> param = new HashMap<>();
		param.put("deptCD", deptCD);
		param.put("startRow", startRow);
		param.put("rowBlockSize", rowBlockSize);
		List<CenterCommentCallList> list = centerRepository.findCenterCommentCalls(param);
		if(list != null && !list.isEmpty()){
			for (CenterCommentCallList centerCommentCallList : list) {
				centerCommentCallList.setCallNotes(centerCommentCallList.getCallNotes().replaceAll("\r\n", "<br/>"));
				centerCommentCallList.setCallDate(CommonUtils.changeDateFormat("yyyy-MM-dd", "MM/dd/yyyy", centerCommentCallList.getCallDate()));
			}
		}
		return list;
	}	
	public void addCenterCommentCall(String jisaCD, String deptCD, String callNotes, String workId) {
		Map<String, Object> param = new HashMap<>();
		param.put("callDate", CommonUtils.getCurrentYMD());
		param.put("callNotes", callNotes);
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("regID", workId);
		centerRepository.insertCenterCommentCall(param);
	}	
	public void removeCenterCommentCall(int idx) {
		centerRepository.deleteCenterCommentCall(idx);
	}	
		
	/**
	 * User 정보 
	 */	
	public List<UserList> getUserList(String jisaCD, String deptCD) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		return centerRepository.userList(param);				
	}
	public String getUserSave(String jisaCD, String deptCD, String userId, String userType, String userLevel, String dutyCD, String userFstName, String userLstName, String email,  String phone,  String title,  String department, String userPwd, String statusCD,String workId) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		param.put("userId", userId);
		param.put("userType", userType);
		param.put("userLevel", userLevel);
		param.put("dutyCD", dutyCD);
		param.put("userFstName", userFstName);
		param.put("userLstName", userLstName);
		param.put("email", email);
		param.put("phone", phone);
		param.put("title", title);
		param.put("department", department);
		param.put("userPwd", userPwd);
		param.put("statusCD", statusCD);
		param.put("workId", workId);
		return centerRepository.userSave(param);				
	}	
	public void setChangeUserPwdSave(String userId, String userPwd,String workId) {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("userPwd", userPwd);
		param.put("workId", workId);
		centerRepository.changeUserPwdSave(param);				
	}	
	public UserView getUserView(String userId) {		
		return centerRepository.userView(userId);				
	}		
		
	
	
	
	
	
	
	/**
	 * @param authId
	 * @param authKey void
	 * @param response 
	 */
	public void addBackupCookies(String authId, String authKey, HttpServletResponse response) {
		CommonUtils.addCookie("JisaAUTHKey", authKey, cookieDomain, response);
		CommonUtils.addCookie("JisaAUTHId", authId, cookieDomain, response);
	}

	/**
	 * @param memberId
	 * @param response void
	 */
	public void addFACookies(String memberId, HttpServletResponse response) {
		StandardPasswordEncoder standrdPasswordEncoder = new StandardPasswordEncoder();
		String authKey = standrdPasswordEncoder.encode(memberId);
		authoritiesService.updateEncodeCookieById(memberId, authKey);
		CommonUtils.addCookie("AUTHKey", authKey, cookieDomain, response);
		CommonUtils.addCookie("AUTHId", memberId, cookieDomain, response);
	}

}
