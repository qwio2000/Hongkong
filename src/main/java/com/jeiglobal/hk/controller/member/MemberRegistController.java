package com.jeiglobal.hk.controller.member;

import java.text.*;
import java.util.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.*;
import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.service.member.*;
import com.jeiglobal.hk.utils.*;

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
	
	@RequestMapping(value={"/fa/members/regist/{name}"},method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public Map<String, Object> getMemberRegistSearchResultJson(Model model,
			@PathVariable String name,
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
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
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
	
	@RequestMapping(value="/fa/members/regist/maxDays", method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public int getMaxDayJson(int year, int month){
		log.debug("Getting Max Day, year : {} month : {}", year, month);
		int maxDays = CommonUtils.getMaxDays(year, month);
		return maxDays;
	}
	
	@RequestMapping(value="/fa/members/regist/feecalc", method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public int getFeeCalcJson(String firstManageDate, int bookNum, @ModelAttribute LoginInfo loginInfo) throws ParseException{
		log.debug("Getting Selected Fee, firstManageDate : {}, bookNum : {}", firstManageDate, bookNum);
		int fee = memberRegistService.getCalcFee(firstManageDate, loginInfo.getDeptCD(), bookNum);
		return fee;
	}
	
	@RequestMapping(value="/fa/members", method = {RequestMethod.POST})
	public String addMemberRegist(String type, 
			MemMst memMst, 
			String[] subj, 
			String[] firstManageDate, 
			String[] manageTime, 
			String[] fee,
			String memKey,
			String dobMonth,
			String dobDay,
			String dobYear,
			@ModelAttribute LoginInfo loginInfo){
		String newMemKey = "";
		if("1".equals(type) || "3".equals(type)){
			newMemKey = memberRegistService.getNewMemKey();
			memMst.setMemKey(newMemKey);
		}else{
			memMst.setMemKey(memKey);
		}
		memMst.setMBirthDay(dobMonth + "/" + dobDay + "/" + dobYear);
		//TODO 본사 or 지사에서 자동 로그인으로 접속한 경우 RegId가 달라짐
		memMst.setRegID(loginInfo.getUserId());
		switch (type) {
		case "1"://최초 신입
			//TODO MemMst Insert newMemKey 이용
			//TODO MemSubjMst Insert
			//TODO MemSubjStudy Insert
			//TODO MemSubjRegist Insert
			//TODO MemSubjTution Insert
			break;
		case "2"://타과목
			//TODO MemMst Update memKey 이용
			//TODO MemSubjMst Insert or Update : 해당 과목 최초인 경우 Insert, 해당 과목 복회인 경우 Update
			//TODO MemSubjStudy Insert or Update : 해당 과목 최초인 경우 Insert, 해당 과목 복회인 경우 Update
			//TODO MemSubjRegist Insert
			//TODO MemSubjTution Insert
			break;
		case "3"://형제 회원
			//TODO MemMst Insert or Update : 부모 정보 변경 시 입회 페이지 요청시 넘어온 memKey인 아이의 부모정보만 Update, memKey와 newMemKey 둘다 이용
			//TODO MemSubjMst Insert
			//TODO MemSubjStudy Insert
			//TODO MemSubjRegist Insert
			//TODO MemSubjTution Insert
			break;

		default:
			break;
		}
		log.debug(memMst.toString());
		log.debug("===============================");
		for (String string : subj) {
			log.debug(string);
		}
		log.debug("===============================");
		for (String string : firstManageDate) {
			log.debug(string);
		}
		log.debug("===============================");
		for (String string : manageTime) {
			log.debug(string);
		}
		return null;
	}
}
