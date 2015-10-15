package com.jeiglobal.hk.controller.member;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeiglobal.hk.domain.CenterState;
import com.jeiglobal.hk.domain.CodeDtl;
import com.jeiglobal.hk.domain.SubjectOfDept;
import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.member.MemMst;
import com.jeiglobal.hk.domain.member.MemSubjMst;
import com.jeiglobal.hk.domain.member.MemSubjRegist;
import com.jeiglobal.hk.domain.member.MemSubjStudy;
import com.jeiglobal.hk.domain.member.MemSubjTuition;
import com.jeiglobal.hk.domain.member.MemberDto;
import com.jeiglobal.hk.domain.member.MemberDto.GuardianInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MonthInfo;
import com.jeiglobal.hk.domain.member.MemberDto.RegistSubject;
import com.jeiglobal.hk.service.CommonService;
import com.jeiglobal.hk.service.member.MemberRegistService;
import com.jeiglobal.hk.utils.CommonUtils;

/**
 * 
 * 클래스명 : MemberSearchController.java
 *
 * 작성일 : 2015. 9. 17.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * JA : Members => Member Search
 * FA : Members => Member Search
 */
@Slf4j
@Controller
public class MemberRegistController {
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MemberRegistService memberRegistService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//RequestMethod.HEAD : GET 요청에서 컨텐츠(자원)는 제외하고 헤더(Meta 정보)만 가져옴.
	@RequestMapping(value={"/fa/members/regist"},method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberRegistSearchPage(Model model,
			@ModelAttribute LoginInfo loginInfo){
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberRegist");
		log.debug("Getting MemberRegist Search Page");
		model.addAttribute("headerScript", headerScript);
		return "member/regist/memberSearch";
	}
	
	@RequestMapping(value={"/fa/members/regist/search"}, method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getMemberRegistSearchResultJson(Model model,
			String name,
			@ModelAttribute LoginInfo loginInfo){
		log.debug("get MemberRegist Search : {}", name);
		List<MemberDto.MemberRegistSearchInfo> registSearches = memberRegistService.getMemberRegistSearch(name, loginInfo.getJisaCD());
		Map<String, Object> map = new HashMap<>();
		map.put("result", registSearches);
		return map;
	}
	
	@RequestMapping(value={"/fa/members/regist/new"}, method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberRegistPage(Model model,
			String type, // 1 : 최초 신입, 2: 타과목, 3: 형제 회원
			String memKey,
			@ModelAttribute LoginInfo loginInfo) throws ParseException{
		log.debug("Getting MemberRegist Page");
		log.debug("Type : {}, memKey : {}", type, memKey);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberRegist");
		//학년 리스트
		List<CodeDtl> grades = commonService.getCodeDtls("0003", loginInfo.getJisaCD(), 1, "Y");
		//입회 경로 리스트
		List<CodeDtl> registHows = commonService.getCodeDtls("0009", loginInfo.getJisaCD(), 1, "Y");
		//입회 동기 리스트
		List<CodeDtl> registWhys = commonService.getCodeDtls("0202", loginInfo.getJisaCD(), 1, "Y");
		//첫 관리 방문일 리스트
		List<String> firstManageDates = memberRegistService.getFirstManageDates(loginInfo.getJisaCD());
		//State 리스트
		List<CenterState> states = commonService.getCenterStates(loginInfo.getJisaCD());
		//가맹점 시간 리스트
		List<CodeDtl> manageTimes = memberRegistService.getManageTimes(loginInfo.getJisaCD(), loginInfo.getDeptCD());
		//가맹점 취급 과목 리스트
		List<SubjectOfDept> subjectOfDepts = commonService.getSubjectsOfDept(loginInfo.getJisaCD(),loginInfo.getDeptCD());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		MemMst memMst = new MemMst();
		GuardianInfo guardianInfo = null;
		List<RegistSubject> registSubjects = null;
		if("2".equals(type)){//타 과목
			memMst = memberRegistService.getMemMst(memKey);
			cal.setTime(sdf.parse(memMst.getMBirthDay()));
			registSubjects = memberRegistService.getRegistSubjects(memKey, loginInfo);
		}else if("3".equals(type)){//형제 회원
			guardianInfo = memberRegistService.getGuardianInfo(memKey);
		}
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH)+1;
		int currentDay = cal.get(Calendar.DATE);
		
		//월 목록
		List<MonthInfo> months = CommonUtils.getMonths();
		//현재 년 월의 최대 일자
		int maxDays = CommonUtils.getMaxDays(currentYear, currentMonth);
		
		model.addAttribute("currentYear", currentYear);
		model.addAttribute("currentMonth", new SimpleDateFormat("MM").format(cal.getTime()));
		model.addAttribute("currentDay", currentDay);
		model.addAttribute("months", months);
		model.addAttribute("maxDays", maxDays);
		model.addAttribute("memMst", memMst);
		model.addAttribute("memKey", memKey);
		model.addAttribute("guardianInfo", guardianInfo);
		model.addAttribute("registSubjects", registSubjects);
		model.addAttribute("grades", grades);
		model.addAttribute("registHows", registHows);
		model.addAttribute("registWhys", registWhys);
		model.addAttribute("firstManageDates", firstManageDates);
		model.addAttribute("states", states);
		model.addAttribute("manageTimes", manageTimes);
		model.addAttribute("subjectOfDepts", subjectOfDepts);
		model.addAttribute("type", type);
		model.addAttribute("headerScript", headerScript);
		return "member/regist/registForm";
	}
	
	@RequestMapping(value="/fa/members/regist/maxDays", method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public int getMaxDayJson(int year, int month){
		log.debug("Getting Max Day, year : {} month : {}", year, month);
		int maxDays = CommonUtils.getMaxDays(year, month);
		return maxDays;
	}
	
	@RequestMapping(value="/fa/members/regist/feecalc", method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public int getFeeCalcJson(String firstManageDate, int bookNum, @ModelAttribute LoginInfo loginInfo) throws ParseException{
		log.debug("Getting Selected Fee, firstManageDate : {}, bookNum : {}", firstManageDate, bookNum);
		int fee = memberRegistService.getCalcFee(firstManageDate, loginInfo.getDeptCD(), bookNum);
		return fee;
	}
	
	@RequestMapping(value="/fa/members", method = {RequestMethod.POST})
	public String addMemberRegist(Model model, String type, MemMst memMst, 
			String[] subj, String[] firstManageDate, String[] manageTime, String[] fee, String[] bookNum, String[] studyNum, String[] monthNum, String[] isResume,
			String memKey,
			String dobMonth, String dobDay, String dobYear,
			@ModelAttribute LoginInfo loginInfo,
			HttpServletRequest request) throws ParseException{
		String newMemKey = "";
		Date currentDate = new Date();
		if("1".equals(type) || "3".equals(type)){//신입 or 형제회원 : 회원번호 생성
			newMemKey = memberRegistService.getNewMemKey();
			memMst.setMemKey(newMemKey);
		}else{
			memMst.setMemKey(memKey);
		}
		memMst.setMBirthDay(dobYear + "-" + dobMonth + "-" + dobDay);
		memMst.setRegID(CommonUtils.getWorkId(request));
		memMst.setUpdID(memMst.getRegID());
		memMst.setRegDate(currentDate);
		memMst.setUpdDate(currentDate);
		
		//MemMst 
		if("1".equals(type)){//최초 신입 : Insert
			memberRegistService.addNewMemMst(memMst);
		}else if("2".equals(type)){//타 과목 : Update
			memberRegistService.setMemMst(memMst, memKey, type);
		}else if("3".equals(type)){//형제 회원 : 형제의 MemMst의 부모 정보 업데이트 후 Insert
			memberRegistService.setGuadianInfoForMemMst(memMst, memKey, type);
			memberRegistService.addNewMemMst(memMst);
		}
		if(subj != null){
			//MemSubjMst, MemSubjStudy, MemSubjRegist, MemSubjTuition
			for (int i = 0; i < subj.length; i++) {
				MemSubjMst memSubjMst = memberRegistService.getMemSubjMst(memMst, loginInfo, subj[i], firstManageDate[i], bookNum[i], studyNum[i], monthNum[i], currentDate, isResume[i]);
				MemSubjStudy memSubjStudy = memberRegistService.getMemSubjStudy(memMst, loginInfo, subj[i], firstManageDate[i], bookNum[i], studyNum[i], manageTime[i], currentDate);
				MemSubjRegist memSubjRegist = memberRegistService.getMemSubjRegist(memMst, loginInfo, subj[i], type, firstManageDate[i], manageTime[i], bookNum[i], studyNum[i], currentDate, isResume[i]);
				MemSubjTuition memSubjTuition = memberRegistService.getMemSubjTution(i, currentDate, memMst, loginInfo, subj[i], bookNum[i], monthNum[i], firstManageDate[i], type, isResume[i]);
				log.debug("type : {}, isResume[{}] : {}", type, i, isResume[i]);
				if("2".equals(type) && "2".equals(isResume[i])){//타과목 입회과목이 복회인 경우 : MemSubjMst, MemSubjStudy Update
					memberRegistService.setMemSubjMst(memSubjMst, isResume[i]);//His 쌓을 때 UpdCD 구분하기 위해 isResume[i] 사용
					memberRegistService.setMemSubjStudy(memSubjStudy);
				}else{//그 외 : Insert
					memberRegistService.addNewMemSubjMst(memSubjMst);
					memberRegistService.addNewMemSubjStudy(memSubjStudy);
				}
				memberRegistService.addNewMemSubjRegist(memSubjRegist);
				memberRegistService.addNewMemSubjTuition(memSubjTuition);
			}
		}
		
		model.addAttribute("message", "성공");
		model.addAttribute("url", "/fa/members/regist");
		return "alertAndRedirect";
	}
}
