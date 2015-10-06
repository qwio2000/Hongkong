package com.jeiglobal.hk.service.member;

import java.text.*;
import java.util.*;

import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.jeiglobal.hk.domain.*;
import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.GuardianInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberRegistSearchInfo;
import com.jeiglobal.hk.domain.member.MemberDto.RegistSubject;
import com.jeiglobal.hk.repository.member.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.utils.*;

/**
 * 클래스명 : MemberRegistService.java
 *
 * 작성일 : 2015. 9. 22.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 입회 서비스
 */
@Transactional
@Service
public class MemberRegistService {
	
	@Autowired
	private MemberRegistRepository memberRegistRepository;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Value("${flag.fstVisit}")
	private int fstVisit;
	
	@Value("${flag.mgFstVisit}")
	private int mgFstVisit;
	/**
	 * 입회 시 첫관리 방문일 목록 가져오는 메서드
	 * @param jisaCD
	 * @return List<String>
	 * @throws ParseException 
	 */
	public List<String> getFirstManageDates(String jisaCD) throws ParseException{
		//현재 날짜 가져옴
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat yyyymmFormatter = new SimpleDateFormat("yyyy-MM");
		//현재 달의 마감날짜 가져옴
		String closingDate = getClosingDate(jisaCD, yyyymmFormatter.format(cal.getTime()));
		//마감 날짜 +8
		Calendar limitDate = getLimitManageDate(closingDate); 
		List<String> firstManageDates = new ArrayList<String>();
		SimpleDateFormat dateFommater = new SimpleDateFormat("MM/dd/yyyy");
		
		for (int i = 0; i < fstVisit; i++) {
			cal.add(Calendar.DATE, 1);
			if(limitDate.after(cal)){
				firstManageDates.add(dateFommater.format(cal.getTime()));
			}else{
				break;
			}
		}
		return firstManageDates;
	}
	/**
	 * 첫관리 방문일 최대 허용일 가져옴
	 * @param closingDate
	 * @return Calendar
	 * @throws ParseException 
	 */
	private Calendar getLimitManageDate(String closingDate) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		cal.setTime(sdf.parse(closingDate));
		cal.add(Calendar.DATE, mgFstVisit + 1);//AM 0:00 기준이라 8을 더해줌
		return cal;
	}
	/**
	 * 현재 달의 마감 날짜 가져옴
	 * @param jisaCD
	 * @param currentYYYYMM
	 * @return String
	 */
	private String getClosingDate(String jisaCD, String currentYYYYMM) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("currentYYYYMM", currentYYYYMM);
		param.put("jisaCD", jisaCD);
		return memberRegistRepository.getClosingDate(param);
	}
	/**
	 * 입회시 회비 계산하는 메서드
	 * @param manageDate : 첫 관리 방문일 선택 일
	 * @param deptCD : 가맹점 코드
	 * @param bookNum : 불출 수
	 * @return int : 회비
	 * @throws ParseException 
	 */
	public int getCalcFee(String manageDate, String deptCD, int bookNum) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar end = Calendar.getInstance();
		int endDate = end.getMaximum(Calendar.DAY_OF_MONTH);
		end.setTime(sdf.parse(manageDate));
		int manageDay = end.get(Calendar.DATE);
		int week = (int) Math.ceil(((double)(endDate - manageDay)/7));
		week = (week > 4)? 4 : week; // 4주 이상 모두 4로 변경
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("deptCD", deptCD);
		param.put("bookNum", bookNum);
		param.put("week", week);
		return memberRegistRepository.getCalcFee(param);
	}
	/**
	 * @param name
	 * @param jisaCD 
	 * @return List<MemberRegistSearchInfo>
	 */
	public List<MemberRegistSearchInfo> getMemberRegistSearch(String name, String jisaCD) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", name);
		paramMap.put("jisaCD", jisaCD);
		return memberRegistRepository.findMemberRegistSearch(paramMap);
	}
	/**
	 * @param jisaCD
	 * @param deptCD
	 * @return List<CodeDtl>
	 */
	public List<CodeDtl> getManageTimes(String jisaCD, String deptCD) {
		Map<String, Object> param = new HashMap<>();
		param.put("jisaCD", jisaCD);
		param.put("deptCD", deptCD);
		Map<String, Object> deptHour = memberRegistRepository.findDeptOpenCloseTime(param);
		param.put("mstCD", "0206");
		param.put("deptHour", deptHour);
		return memberRegistRepository.findDeptAvailableTimes(param);
	}
	/**
	 * @param memKey
	 * @return MemMst
	 */
	public MemMst getMemMst(String memKey) {
		return memberRegistRepository.findMemMst(memKey);
	}
	/**
	 * @param memKey
	 * @return GuardianInfo
	 */
	public GuardianInfo getGuardianInfo(String memKey) {
		return memberRegistRepository.findGuardianInfo(memKey);
	}
	/**
	 * @param memKey
	 * @param loginInfo
	 * @return List<RegistSubject>
	 */
	public List<RegistSubject> getRegistSubjects(String memKey,
			LoginInfo loginInfo) {
		Map<String, Object> param = new HashMap<>();
		param.put("memKey", memKey);
		param.put("jisaCD", loginInfo.getJisaCD());
		param.put("deptCD", loginInfo.getDeptCD());
		return memberRegistRepository.findRegistSubjects(param);
	}
	/**
	 * @return String
	 */
	public String getNewMemKey() {
		return memberRegistRepository.getKeyGenSelect();
	}
	/**
	 * @param memMst void
	 */
	public void addNewMemMst(MemMst memMst) {
		memberRegistRepository.insertNewMemMst(memMst);
	}

	/**
	 * @param firstManageDate
	 * @return String
	 * @throws ParseException 
	 */
	private String getYoil(String firstManageDate) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		cal.setTime(sdf.parse(firstManageDate));
		return Integer.toString(cal.get(Calendar.DAY_OF_WEEK));
	}
	/**
	 * 
	 * @param memMst
	 * @param loginInfo
	 * @param subj
	 * @param firstManageDate
	 * @param bookNum
	 * @param studyNum
	 * @param monthNum
	 * @param currentDate 
	 * @param isResume 
	 * @return MemSubjMst
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	public MemSubjMst getMemSubjMst(MemMst memMst, LoginInfo loginInfo,
			String subj, String firstManageDate, String bookNum, String studyNum, String monthNum, Date currentDate, String isResume) throws NumberFormatException, ParseException {
		//복회 시 복회일자, before, feeFnl, HIS
		String registFstYMD = ("2".equals(isResume))? "" : CommonUtils.getCurrentYMD();
		String registFnlYMD = ("2".equals(isResume))? CommonUtils.getCurrentYMD() : "";
		return new MemSubjMst(memMst.getMemKey(), subj, "1", memMst.getMFstName()+memMst.getMLstName(), getYoil(firstManageDate), Integer.parseInt(studyNum), Integer.parseInt(bookNum), "", registFstYMD, registFnlYMD, "", getExpireYMD(Integer.parseInt(monthNum)), CommonUtils.getCurrentYMD(), "", "", "", "", 0, 0, commonService.getEmpKeyByDeptCD(loginInfo.getDeptCD()), loginInfo.getDeptCD(), loginInfo.getJisaCD(), currentDate, memMst.getRegID(), currentDate, memMst.getRegID());
	}
	/**
	 * @return String
	 */
	private String getExpireYMD(int monthNum) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, monthNum);
		cal.set(Calendar.DATE, CommonUtils.getMaxDays(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1));
		return CommonUtils.getDateForFormat(cal.getTime());
	}
	/**
	 * 
	 * @param memMst
	 * @param loginInfo
	 * @param subj
	 * @param firstManageDate
	 * @param bookNum
	 * @param studyNum
	 * @param manageTime
	 * @param currentDate 
	 * @return MemSubjStudy
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	public MemSubjStudy getMemSubjStudy(MemMst memMst, LoginInfo loginInfo,
			String subj, String firstManageDate, String bookNum, String studyNum, String manageTime, Date currentDate) throws NumberFormatException, ParseException {
		return new MemSubjStudy(memMst.getMemKey(), subj, Integer.parseInt(studyNum), Integer.parseInt(bookNum), getYoil(firstManageDate), 1, 1, manageTime, commonService.getEmpKeyByDeptCD(loginInfo.getDeptCD()), loginInfo.getDeptCD(), loginInfo.getJisaCD(), currentDate, memMst.getRegID(), currentDate, memMst.getUpdID());
	}
	/**
	 * 
	 * @param memMst
	 * @param loginInfo
	 * @param subj
	 * @param type
	 * @param firstManageDate
	 * @param manageTime
	 * @param bookNum
	 * @param studyNum
	 * @param currentDate
	 * @param isResume 
	 * @return MemSubjRegist
	 * @throws ParseException 
	 */
	public MemSubjRegist getMemSubjRegist(MemMst memMst, LoginInfo loginInfo,
			String subj, String type, String firstManageDate, String manageTime, String bookNum,
			String studyNum, Date currentDate, String isResume) throws ParseException {
		MemSubjRegist memSubjRegist = modelMapper.map(memMst, MemSubjRegist.class);
		memSubjRegist.setRegistYMD(CommonUtils.getDateForFormat(currentDate));
		memSubjRegist.setSubj(subj);
		memSubjRegist.setRegistGubunCD(("1".equals(type) || "3".equals(type)) ? "01" : ("1".equals(isResume)) ? "03" : "02");//신입
		memSubjRegist.setFstVisitYMD(CommonUtils.changeDateFormat("MM/dd/yyyy", "yyyy-MM-dd", firstManageDate));
		memSubjRegist.setYoil(getYoil(firstManageDate));
		memSubjRegist.setVisitHours(manageTime);
		memSubjRegist.setWeekNum(CommonUtils.getRemainWeekNum(firstManageDate));//잔여주차
		memSubjRegist.setStudyNum(Integer.parseInt(studyNum));
		memSubjRegist.setBookNum(Integer.parseInt(bookNum));
		memSubjRegist.setDigGrade("");
		memSubjRegist.setEmpKey(commonService.getEmpKeyByDeptCD(loginInfo.getDeptCD()));
		memSubjRegist.setDeptCD(loginInfo.getDeptCD());
		memSubjRegist.setJisaCD(loginInfo.getJisaCD());
		//TODO Appointment로 입회 넘어온 경우 apmIdx 추가
		return memSubjRegist;
	}
	/**
	 * 
	 * @param i 
	 * @param currentDate
	 * @param memMst
	 * @param loginInfo
	 * @param subj
	 * @param bookNum
	 * @param monthNum
	 * @param firstManageDate 
	 * @param type 
	 * @return MemSubjTuition
	 * @throws ParseException 
	 */
	public MemSubjTuition getMemSubjTution(int i, Date currentDate, MemMst memMst,
			LoginInfo loginInfo, String subj, String bookNum, String monthNum, String firstManageDate, String type, String isResume) throws ParseException {
		int weekNum = CommonUtils.getRemainWeekNum(firstManageDate);
		Map<String, Object> param = new HashMap<>();
		param.put("deptCD", loginInfo.getDeptCD());
		param.put("weekNum", weekNum);
		//Key : registFee, monthFee, sectionFee, feeUnit, freeType
		Map<String, Object> resultMap = memberRegistRepository.findMemFeeInfo(param);
		String feeGubun = ("1".equals(type) || "3".equals(type)) ? "01" : ("1".equals(isResume)) ? "03" : ("2".equals(isResume)) ? "02" : "04";
		//TODO feeKind : 입금 종류 (일반, 할인, 면제)
		String feeKind = "1";
		int registFee = ("2".equals(type))? 0 : (i == 0)? Integer.parseInt(resultMap.get("registFee").toString()) : 0;
		int longFee = Integer.parseInt(resultMap.get("monthFee").toString()) * (Integer.parseInt(monthNum) - 1);
		int totalFee = registFee
				+ Integer.parseInt(resultMap.get("sectionFee").toString())
				+ Integer.parseInt(resultMap.get("monthFee").toString())
				+ longFee;
		return new MemSubjTuition(0, CommonUtils.getDateForFormat(currentDate), memMst.getMemKey(), subj, memMst.getMFstName()+memMst.getMLstName(), feeGubun, feeKind, resultMap.get("freeType").toString(), registFee, Integer.parseInt(resultMap.get("sectionFee").toString()), Integer.parseInt(resultMap.get("monthFee").toString()), longFee, totalFee, getExpireYMD(Integer.parseInt(monthNum)), Integer.parseInt(bookNum), weekNum, Integer.parseInt(monthNum), resultMap.get("feeUnit").toString(), commonService.getEmpKeyByDeptCD(loginInfo.getDeptCD()), loginInfo.getDeptCD(), loginInfo.getJisaCD(), currentDate, memMst.getRegID());
	}
	/**
	 * @param memSubjMst void
	 */
	public void addNewMemSubjMst(MemSubjMst memSubjMst) {
		memberRegistRepository.insertNewMemSubjMst(memSubjMst);
		
	}
	/**
	 * @param memSubjStudy void
	 */
	public void addNewMemSubjStudy(MemSubjStudy memSubjStudy) {
		memberRegistRepository.insertNewMemSubjStudy(memSubjStudy);
		
	}
	/**
	 * @param memSubjRegist void
	 */
	public void addNewMemSubjRegist(MemSubjRegist memSubjRegist) {
		memberRegistRepository.insertNewMemSubjRegist(memSubjRegist);
	}
	/**
	 * @param memSubjTuition void
	 */
	public void addNewMemSubjTuition(MemSubjTuition memSubjTuition) {
		memberRegistRepository.insertNewMemSubjTuition(memSubjTuition);
	}
	/**
	 * @param memMst void
	 * @param type 
	 * @param memKey 
	 * @param type 
	 * @param memKey 
	 */
	public void setMemMst(MemMst memMst, String memKey, String type) {
		Map<String, Object> param = new HashMap<>();
		param.put("type", type);
		param.put("memMst", memMst);
		param.put("memKey", memMst.getMemKey());
		memberRegistRepository.insertMemMstHis(param);
		memberRegistRepository.updateMemMst(memMst);
	}
	/**
	 * @param memSubjMst void
	 * @param isResume 
	 */
	public void setMemSubjMst(MemSubjMst memSubjMst, String isResume) {
		Map<String, Object> param = new HashMap<>();
		param.put("isResume", isResume);
		param.put("memSubjMst", memSubjMst);
		memberRegistRepository.insertMemSubjMstHis(param);
		memberRegistRepository.updateMemSubjMst(memSubjMst);
		
	}
	/**
	 * @param memSubjStudy void
	 */
	public void setMemSubjStudy(MemSubjStudy memSubjStudy) {
		memberRegistRepository.insertMemSubjStudyHis(memSubjStudy);
		memberRegistRepository.updateMemSubjStudy(memSubjStudy);
	}
	/**
	 * @param memMst
	 * @param memKey void
	 * @param type 
	 */
	public void setGuadianInfoForMemMst(MemMst memMst, String memKey, String type) {
		Map<String, Object> param = new HashMap<>();
		param.put("type", type);
		param.put("memMst", memMst);
		param.put("memKey", memKey);
		memberRegistRepository.insertMemMstHis(param);
		memberRegistRepository.updateGuadianInfoForMemMst(param);		
	}
	
}
