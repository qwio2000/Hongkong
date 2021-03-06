package com.jeiglobal.hk.controller.member;

import java.text.*;
import java.util.*;

import javax.servlet.http.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.*;
import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.GuardianInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberRegistFreeDiagInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MonthInfo;
import com.jeiglobal.hk.domain.member.MemberDto.RegistSubject;
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
	
	@Autowired
	private MessageSourceAccessor msa;
	
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
		List<MemberDto.MemberRegistSearchInfo> registSearches = memberRegistService.getMemberRegistSearch(name, loginInfo.getJisaCD(), loginInfo.getDeptCD());
		Map<String, Object> map = new HashMap<>();
		map.put("result", registSearches);
		return map;
	}
	
	/**
	 * 입회 페이지 
	 */
	@RequestMapping(value={"/fa/members/regist/new"}, method = {RequestMethod.GET, RequestMethod.HEAD})
	public String getMemberRegistPage(Model model,
			String type, // 1 : 최초 신입, 2: 타과목, 3: 형제 회원
			String memKey,
			Integer appIdx,
			MemberRegistFreeDiagInfo freeDiagInfo,
			@ModelAttribute LoginInfo loginInfo) throws ParseException{
		//본사에서 입회 불가 처리 여부 확인
		MemRegistClose registCloseInfo = memberRegistService.getRegistCloseInfoByJisaCD(loginInfo.getJisaCD());
		if("1".equals(registCloseInfo.getStatusCD())){
			Object[] args = {registCloseInfo.getCloseReason()};
			model.addAttribute("message", msa.getMessage("member.regist.close", args));
			model.addAttribute("mode", "back");
			return "alertAndRedirect";
		}
		
		log.debug("Getting MemberRegist Page");
		log.debug("Type : {}, memKey : {}, freeDiag : {}", type, memKey, freeDiagInfo);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("memberRegist");
		log.debug("appIdx : {}", appIdx);
		List<String> appSubjs = null;
		MemAppointment memAppointment = null;
		//Appointment 연결 여부
		if(appIdx != null && appIdx != 0){
			memAppointment = memberRegistService.getAppointmentByIdx(appIdx);
			if(memAppointment.getMemKey() != null && !memAppointment.getMemKey().isEmpty()){
				type="2";
				memKey = memAppointment.getMemKey();
			}else{
				type="1";
			}
			if(memAppointment.getSubj() != null && !memAppointment.getSubj().isEmpty()){
				appSubjs = Arrays.asList(memAppointment.getSubj().split(","));
			}
		}
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
		List<CodeDtl> manageTimes = commonService.getMemberManageTimes(loginInfo.getJisaCD(), loginInfo.getDeptCD());
		//가맹점 취급 과목 리스트
		List<SubjectOfDept> subjectOfDepts = commonService.getSubjectsOfDept(loginInfo.getJisaCD(),loginInfo.getDeptCD());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		MemMst memMst = new MemMst();
		GuardianInfo guardianInfo = null;
		List<RegistSubject> registSubjects = null;
		if("2".equals(type)){//타 과목
			int count = memberRegistService.getMemSubjMstCount(memKey, loginInfo.getDeptCD());
			if(count > 0){//다른 가맹점에 이미 유지중인 과목이 있는 경우
				model.addAttribute("message", msa.getMessage("member.regist.already.anotherdept"));
				model.addAttribute("mode", "back");
				return "alertAndRedirect";
			}
			memMst = memberRegistService.getMemMst(memKey);
			cal.setTime(sdf.parse(memMst.getMBirthDay()));
			registSubjects = memberRegistService.getRegistSubjects(memKey, loginInfo);
		}else if("3".equals(type)){//형제 회원
			guardianInfo = memberRegistService.getGuardianInfoByMemberReport(memKey);
		}else if("1".equals(type) && memAppointment != null){
			cal.setTime(sdf.parse(memAppointment.getMBirthDay()));
		}
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH)+1;
		int currentDay = cal.get(Calendar.DATE);
		//월 목록(short Type)
		List<MonthInfo> months = CommonUtils.getMonths(2);
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
		model.addAttribute("appIdx", appIdx);
		model.addAttribute("appSubjs", appSubjs);
		model.addAttribute("memAppointment", memAppointment);
		model.addAttribute("freeDiagInfo", freeDiagInfo);
		return "member/regist/registForm";
	}
	
	@RequestMapping(value="/fa/members/regist/maxDays", method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public int getMaxDayJson(int year, int month){
		log.debug("Getting Max Day, year : {} month : {}", year, month);
		int maxDays = CommonUtils.getMaxDays(year, month);
		return maxDays;
	}
	
	/**
	 * 회비 계산 
	 */
	@RequestMapping(value="/fa/members/regist/feecalc", method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public int getFeeCalcJson(String firstManageDate, int bookNum, @ModelAttribute LoginInfo loginInfo) throws ParseException{
		log.debug("Getting Selected Fee, firstManageDate : {}, bookNum : {}", firstManageDate, bookNum);
		int fee = memberRegistService.getCalcFee(firstManageDate, loginInfo.getDeptCD(), bookNum);
		return fee;
	}
	
	/**
	 * 입회 처리
	 */
	@RequestMapping(value="/fa/members", method = {RequestMethod.POST})
	public String addMemberRegist(Model model, String type, MemMst memMst, 
			String[] subj, String[] firstManageDate, String[] manageTime, String[] fee, String[] bookNum, String[] studyNum, String[] monthNum, String[] isResume,
			String memKey, int appIdx,
			String dobMonth, String dobDay, String dobYear,
			@ModelAttribute LoginInfo loginInfo,
			MemberRegistFreeDiagInfo freeDiagInfo, //무료진단 진도 연결 정보
			HttpServletRequest request) throws ParseException{
		String newMemKey = "";
		Date currentDate = new Date();
		if("1".equals(type) || "3".equals(type)){//신입 or 형제회원 : 회원번호 생성
			newMemKey = memberRegistService.getNewMemKey();
			memMst.setMemKey(newMemKey);
		}else{
			memMst.setMemKey(memKey);
		}
		memMst.setRemarks(CommonUtils.subStrByte(memMst.getRemarks(), 0, 500, 3));
		memMst.setMBirthDay(dobYear + "-" + dobMonth + "-" + dobDay);
		String workId = CommonUtils.getWorkId(request);
		memMst.setRegID(workId);
		memMst.setUpdID(memMst.getRegID());
		memMst.setRegDate(currentDate);
		memMst.setUpdDate(currentDate);
		
		if(subj != null){
			//MemSubjMst, MemSubjStudy, MemSubjRegist, MemSubjTuition
			for (int i = 0; i < subj.length; i++) {
				MemSubjMst memSubjMst = memberRegistService.getMemSubjMst(memMst, loginInfo, subj[i], firstManageDate[i], bookNum[i], studyNum[i], monthNum[i], currentDate, isResume[i]);
				MemSubjStudy memSubjStudy = memberRegistService.getMemSubjStudy(memMst, loginInfo, subj[i], firstManageDate[i], bookNum[i], studyNum[i], manageTime[i], currentDate);
				MemSubjRegist memSubjRegist = memberRegistService.getMemSubjRegist(i, memMst, loginInfo, subj[i], type, firstManageDate[i], manageTime[i], bookNum[i], studyNum[i], currentDate, isResume[i], memKey, appIdx);
				MemSubjTuition memSubjTuition = memberRegistService.getMemSubjTution(i, currentDate, memMst, loginInfo, subj[i], bookNum[i], monthNum[i], firstManageDate[i], type, isResume[i]);
				log.debug("type : {}, isResume[{}] : {}", type, i, isResume[i]);
				if("2".equals(type) && "2".equals(isResume[i])){//타과목 입회과목이 복회인 경우 : MemSubjMst, MemSubjStudy Update
					memberRegistService.setMemSubjMst(memSubjMst);//His 쌓을 때 UpdCD 구분하기 위해 isResume[i] 사용
					memberRegistService.setMemSubjStudy(memSubjStudy);
				}else{//그 외 : Insert
					memberRegistService.addNewMemSubjMst(memSubjMst);
					memberRegistService.addNewMemSubjStudy(memSubjStudy);
				}
				memberRegistService.addNewMemSubjRegist(memSubjRegist);
				memberRegistService.addNewMemSubjTuition(memSubjTuition);
				//무료진단 진도 연결
				if(subj[i].equals(freeDiagInfo.getFreeSubj())){
					String isOk = memberRegistService.addMemProgressByFreeDiag(freeDiagInfo, loginInfo, memMst.getMemKey());
					if(!"Y".equals(isOk)){
						log.error("무료진단 진도 연결 중 오류 발생  memKey : {}, subj : {}, omrDate : {}", memMst.getMemKey(), freeDiagInfo.getFreeSubj(), freeDiagInfo.getFreeOmrDate());
					}
				}
			}
		}
		
		//MemMst 
		if("1".equals(type)){//최초 신입 : Insert
			memberRegistService.addNewMemMst(memMst);
		}else if("2".equals(type)){//타 과목 : Update
			memberRegistService.setMemMst(memMst, memKey, type);
		}else if("3".equals(type)){//형제 회원 : 형제의 MemMst의 부모 정보 업데이트 후 Insert
			memberRegistService.setGuadianInfoForMemMst(memMst, memKey, type);
			memberRegistService.addNewMemMst(memMst);
		}
		//Appointment, FreeGicho 업데이트
		if(appIdx != 0){
			memberRegistService.setMemAppointRegistYMD(appIdx, currentDate, workId, memMst.getMemKey());
			if(freeDiagInfo != null && !"".equals(freeDiagInfo.getFreeSubj())){
				memberRegistService.setFreeGichoByRegist(freeDiagInfo, memMst.getMemKey());
			}
		}
		
		model.addAttribute("message", msa.getMessage("member.regist.success"));
		model.addAttribute("url", "/fa/members/reports/"+memMst.getMemKey());
		return "alertAndRedirect";
	}
}
