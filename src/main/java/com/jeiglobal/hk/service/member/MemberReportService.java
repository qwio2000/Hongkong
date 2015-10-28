package com.jeiglobal.hk.service.member;

import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.*;
import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.GuardianInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberIpprInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportFreeDiagInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportSubjInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportSubjStudyInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberSearch;
import com.jeiglobal.hk.domain.member.MemberDto.MemberSearchInfo;
import com.jeiglobal.hk.repository.member.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.utils.*;

/**
 * 클래스명 : MemberReportService.java
 *
 * 작성일 : 2015. 9. 17.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Service
public class MemberReportService {
	
	@Autowired
	private MemberReportRepository memberReportRepository;
	
	@Autowired
	private CommonService commonService;
	
	/**
	 * 
	 * @param loginInfo 
	 * @param pageNum 
	 * @param pageSize 
	 * @param MemberSearch
	 * @return List<MemberSearchInfo>
	 */
	public List<MemberSearchInfo> getSearchResults(MemberSearch memberSearch, LoginInfo loginInfo, int pageNum, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberSearch", memberSearch);
		map.put("loginInfo", loginInfo);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		return memberReportRepository.findSearchResults(map);
	}

	/**
	 * @param memKey
	 * @return MemMst
	 */
	public MemMst getMemMstByMemKey(String memKey) {

		return memberReportRepository.findMemMstByMemKey(memKey);
	}

	/**
	 * @param memMst
	 * @param loginInfo 
	 * @return MemberReportInfo
	 * @throws ParseException 
	 */
	public List<MemberReportInfo> getMemberReportInfo(MemMst memMst, LoginInfo loginInfo) throws ParseException {
		Map<String, Object> param = new HashMap<>();
		param.put("gFstName", memMst.getGFstName());
		param.put("gLstName", memMst.getGLstName());
		param.put("jisaCD", loginInfo.getJisaCD());
		param.put("deptCD", loginInfo.getDeptCD());
		List<MemberReportInfo> memberReportInfos = memberReportRepository.findMemMstsByGuardianName(param);
		for (MemberReportInfo memberReportInfo : memberReportInfos) {
			//생일 출력 방식 변경
			if(!memberReportInfo.getMBirthDay().equals("")){
				memberReportInfo.setMBirthDay(CommonUtils.changeDateFormat("yyyy-MM-dd", "MM/dd/yyyy", memberReportInfo.getMBirthDay()));
			}
			param.put("memKey", memberReportInfo.getMemKey());
			memberReportInfo.setMemberReportSubjInfos(memberReportRepository.findMemSubjMstsByMemKey(param));
			memberReportInfo.setRemarks(memberReportInfo.getRemarks().replaceAll("\r\n", "<br/>"));
		}
		//(입회,퇴회) 취소 가능 여부
		memberReportInfos = getIsCancle(memberReportInfos, loginInfo.getJisaCD());
		return memberReportInfos;
	}

	/**
	 * 
	 * @param memberReportInfos
	 * @param jisaCD
	 * @return List<MemberReportInfo>
	 * @throws ParseException 
	 */
	private List<MemberReportInfo> getIsCancle(List<MemberReportInfo> memberReportInfos, String jisaCD) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentYMD = CommonUtils.getCurrentYMD();
		String yyyyMM = currentYMD.substring(0, 7);
		String closingDateStr = commonService.getClosingDate(jisaCD, yyyyMM);
		Date closingDate = sdf.parse(closingDateStr);
		cal.setTime(closingDate);
		cal.add(Calendar.DATE, 1);
		closingDate = cal.getTime();
		
		cal.setTime(closingDate);
		cal.add(Calendar.MONTH, -1);
		Date beforeClosingDate = cal.getTime();
		
		Date checkDate = null;
		for (MemberReportInfo memberReportInfo : memberReportInfos) {
			for (MemberReportSubjInfo memberReportSubjInfo : memberReportInfo.getMemberReportSubjInfos()) {
				if("1".equals(memberReportSubjInfo.getStatusCD())){
					checkDate = sdf.parse(memberReportSubjInfo.getRecentRegistFnlYMD());
				}else if("2".equals(memberReportSubjInfo.getStatusCD())){
					checkDate = sdf.parse(memberReportSubjInfo.getDropFnlYMD());
				}
				if(checkDate.compareTo(beforeClosingDate) > 0 && checkDate.compareTo(closingDate) <= 0){
					memberReportSubjInfo.setIsCancle("true");
				}else{
					memberReportSubjInfo.setIsCancle("false");
				}
			}
		}
		return memberReportInfos;
		
	}

	/**
	 * 부모 정보 업데이트 시 적용할 회원 번호 리스트 생성
	 * @param memberReportInfos
	 * @return String
	 */
	public String getMemKeys(List<MemberReportInfo> memberReportInfos) {
		String memKeys = "";
		for (MemberReportInfo memberReportInfo : memberReportInfos) {
			memKeys += ("".equals(memKeys))?"" : "|";
			memKeys += memberReportInfo.getMemKey();
		}
		return memKeys;
	}

	/**
	 * 부모 정보 변경
	 * @param guardianInfo
	 * @param memKeys
	 * @param workId 
	 * @param loginInfo 
	 * @return String
	 */
	public void setGuardianInfo(GuardianInfo guardianInfo, String memKeys, String workId) {
		Map<String, Object> param = new HashMap<>();
		param.put("guardianInfo", guardianInfo);
		param.put("memKeys", memKeys.split("\\|"));
		param.put("workId", workId);
		memberReportRepository.insertMemMstHisForGuadianInfo(param);
		memberReportRepository.updateGuardianInfo(param);
	}

	/**
	 * 회원/학부모 상담이력 입력
	 * @param memKey
	 * @param memName
	 * @param callNotes
	 * @param loginInfo
	 * @param workId 
	 */
	public void addCommentCall(String memKey, String memName, String callNotes,
			LoginInfo loginInfo, String workId) {
		Map<String, Object> param = new HashMap<>();
		param.put("callDate", CommonUtils.getCurrentYMD());
		param.put("memKey", memKey);
		param.put("memName", memName);
		param.put("callNotes", callNotes);
		param.put("jisaCD", loginInfo.getJisaCD());
		param.put("deptCD", loginInfo.getDeptCD());
		param.put("regID", workId);
		memberReportRepository.insertMemCommentCall(param);
	}

	/**
	 * 가맹점에서 진행하는 과목에서 현재 회원이 진행하고 있는 과목을 제외한 목록
	 * @param memKey
	 * @param loginInfo 
	 * @return List<String>
	 */
	public List<SubjectOfDept> getMemberSubjects(String memKey, LoginInfo loginInfo) {
		List<SubjectOfDept> subjectsOfDept = commonService.getSubjectsOfDept(loginInfo.getJisaCD(),loginInfo.getDeptCD());
		List<String> subjects = memberReportRepository.getMemberSubjects(memKey);
		for (int i = 0; i < subjectsOfDept.size(); i++) {
			for (String subj : subjects) {
				if (subjectsOfDept.get(i).getSubj().equals(subj)) {
					subjectsOfDept.remove(i);
				}
			}
		}
		return subjectsOfDept;
	}

	/**
	 * MemberReport => 입회 상담 약속 등록
	 * @param memKey
	 * @param memName
	 * @param preferredYMD
	 * @param preferredTimes
	 * @param preferredNotes
	 * @param subj 
	 * @param loginInfo
	 * @param workId 
	 * @throws ParseException 
	 */
	public void addAppointment(String memKey, String memName,
			String preferredYMD, String preferredTimes, String preferredNotes,
			String subj, LoginInfo loginInfo, String workId) throws ParseException {
		String currentYMD = CommonUtils.getCurrentYMD();
		Map<String, Object> param = new HashMap<>();
		param.put("currentYMD", currentYMD);
		param.put("memKey", memKey);
		param.put("memName", memName);
		param.put("subj", subj);
		param.put("preferredYMD", CommonUtils.changeDateFormat("MM/dd/yyyy", "yyyy-MM-dd", preferredYMD));
		param.put("preferredTimes", preferredTimes);
		param.put("preferredNotes", preferredNotes);
		param.put("loginInfo", loginInfo);
		param.put("workId", workId);
		memberReportRepository.insertMemAppointment(param);
	}

	/**
	 * 회원 정보 변경
	 * @param memMst
	 * @param loginInfo
	 * @param workId void
	 * @throws ParseException 
	 */
	public void setMemberInfo(MemMst memMst, LoginInfo loginInfo, String workId) throws ParseException {
		Map<String, Object> param = new HashMap<>();
		memMst.setMBirthDay(CommonUtils.changeDateFormat("MM/dd/yyyy", "yyyy-MM-dd", memMst.getMBirthDay()));
		param.put("memMst", memMst);
		param.put("loginInfo", loginInfo);
		param.put("workId", workId);
		//MemMst History
		memberReportRepository.insertMemMstHisForMemberInfo(param);
		//MemMst Update
		memberReportRepository.updateMemMst(param);
		//MemSubjMst memName Update
		memberReportRepository.updateMemSubjMstForMemName(param);
		//TODO 다른 테이블들 memName 변경 여부?
		
	}

	/**
	 * 관리요일 변경 시 필요한 과목정보
	 * @param memKey
	 * @return List<MemberReportSubjStudy>
	 */
	public List<MemberReportSubjStudyInfo> getMemberReportSubjStudys(String memKey) {
		return memberReportRepository.findMemberReportSubjStudys(memKey);
	}

	/**
	 * 관리요일 변경
	 * @param subj
	 * @param studyNum
	 * @param yoil
	 * @param manageTimes
	 * @param workId
	 * @param memKey 
	 */
	public void setMemSubjStudyInfo(String subj, int studyNum, String yoil,
			String manageTimes, String workId, String memKey) {
		String type = "";
		//TODO 2불출 가능 시 변경, 현재는 2불출 고려 안함
		Map<String, Object> param = new HashMap<>();
		param.put("memKey", memKey);
		param.put("subj", subj);
		param.put("studyNum", studyNum);
		param.put("yoil", yoil);
		param.put("manageTimes", manageTimes);
		param.put("workId", workId);
		param.put("currentYMD", CommonUtils.getCurrentYMD());
		MemSubjStudy subjStudy = memberReportRepository.findMemSubjStudyByMemKeyAndSubj(param);
		if(!subjStudy.getYoil().equals(yoil)){
			if(subjStudy.getStudyNum() != studyNum){
				type = "3";
			}else{
				type = "1";
			}
		}else if(subjStudy.getStudyNum() != studyNum){
			type = "2";
		}else{
			type = "0";
		}
		param.put("type", type);
		memberReportRepository.insertMemSubjMstHis(param);
		memberReportRepository.updateMemSubjMstForStudyNum(param);
		memberReportRepository.insertMemSubjStudyHis(param);
		memberReportRepository.updateMemSubjStudy(param);
	}

	/**
	 * MemSubjMstHis Insert & MemSubjMst Update
	 * @param memKey
	 * @param subj
	 * @param currentYMD
	 * @param workId 
	 */
	public void setMemSubjMstByDrop(String memKey, String subj,
			String currentYMD, String workId) {
		Map<String, Object> param = new HashMap<>();
		param.put("memKey", memKey);
		param.put("subj", subj);
		param.put("currentYMD", currentYMD);
		param.put("workId", workId);
		memberReportRepository.insertMemSubjMstHisByDrop(param);
		memberReportRepository.updateMemSubjMstByDrop(param);
	}

	/**
	 * 퇴회 정보 Insert
	 * @param memKey
	 * @param subj
	 * @param dropReason
	 * @param notes
	 * @param memName
	 * @param loginInfo
	 * @param currentYMD
	 * @param workId
	 */
	public void addMemSubjDrop(String memKey, String subj, String dropReason,
			String notes, String memName, LoginInfo loginInfo, String currentYMD, String workId) {
		Map<String, Object> param = new HashMap<>();
		param.put("memKey", memKey);
		param.put("subj", subj);
		param.put("dropReason", dropReason);
		param.put("notes", notes);
		param.put("memName", memName);
		param.put("loginInfo", loginInfo);
		param.put("currentYMD", currentYMD);
		param.put("workId", workId);
		memberReportRepository.insertMemSubjDrop(param);
	}

	/**
	 * 퇴회 취소 시 정보 변경
	 * @param memKey
	 * @param subj
	 * @param workId 
	 */
	public void setMemSubjMstByDropCancel(String memKey, String subj, String workId) {
		Map<String, Object> param = new HashMap<>();
		param.put("memKey", memKey);
		param.put("subj", subj);
		param.put("workId", workId);
		//MemSubjMstHis Insert
		memberReportRepository.insertMemSubjMstHisByDropCancel(param);
		//MemSubjMst delete
		memberReportRepository.deleteMemSubjMstByDropCancel(param);
		//MemSubjMst 복구
		memberReportRepository.insertMemSubjMstByDropCancel(param);
	}

	/**
	 * 퇴회 취소로 인한 퇴회 정보 삭제
	 * @param memKey
	 * @param subj
	 * @param workId
	 * @param convDropDate
	 */
	public void removeMemSubjDropByDropCancel(String memKey, String subj,
			String workId, String convDropDate) {
		Map<String, Object> param = new HashMap<>();
		param.put("memKey", memKey);
		param.put("subj", subj);
		param.put("workId", workId);
		param.put("convDropDate", convDropDate);
		//MemSubjDropHis Insert
		memberReportRepository.insertMemSubjDropHisByDropCancel(param);
		//MemSubjDrop Delete
		memberReportRepository.deleteMemSubjDropByDropCancel(param);
	}

	/**
	 * MemAppointment 삭제
	 * @param idx void
	 */
	public void removeMemAppointment(int idx) {
		memberReportRepository.deleteMemAppointment(idx);
		
	}

	/**
	 * @param memKey
	 * @return List<Map<String,Object>>
	 */
	public List<MemberIpprInfo> getMemberIpprs(String memKey) {
		return memberReportRepository.findMemberIpprs(memKey);
	}

	/**
	 * @param memKey
	 * @return int
	 */
	public int getMemCommentCallsCount(String memKey) {
		return memberReportRepository.findMemCommentCallsCount(memKey);
	}

	/**
	 * @param memKey
	 * @param startRow
	 * @param rowBlockSize
	 * @return List<MemCommentCall>
	 * @throws ParseException 
	 */
	public List<MemCommentCall> getMemCommentCalls(String memKey, int startRow,
			int rowBlockSize) throws ParseException {
		Map<String, Object> param = new HashMap<>();
		param.put("memKey", memKey);
		param.put("startRow", startRow);
		param.put("rowBlockSize", rowBlockSize);
		List<MemCommentCall> list = memberReportRepository.findMemCommentCalls(param);
		if(list != null && !list.isEmpty()){
			for (MemCommentCall memCommentCall : list) {
				memCommentCall.setCallNotes(memCommentCall.getCallNotes().replaceAll("\r\n", "<br/>"));
				memCommentCall.setCallDate(CommonUtils.changeDateFormat("yyyy-MM-dd", "MM/dd/yyyy", memCommentCall.getCallDate()));
			}
		}
		return list;
	}

	/**
	 * @param idx void
	 */
	public void removeCommentCall(int idx) {
		memberReportRepository.deleteCommentCall(idx);
	}

	/**
	 * @param memKey
	 * @param subj
	 * @return MemSubjRegist
	 */
	public MemSubjRegist getMemSubjRegistByMemKeyAndSubj(String memKey, String subj) {
		Map<String, Object> param = new HashMap<>();
		param.put("memKey", memKey);
		param.put("subj", subj);
		return memberReportRepository.findMemSubjRegistByMemKeyAndSubj(param);
	}

	/**
	 * @param memberRegist
	 * @return int
	 */
	public int getMemSubjRegistOtherSubj(MemSubjRegist memberRegist) {
		return memberReportRepository.findMemSubjRegistOtherSubjCount(memberRegist);
	}

	/**
	 * @param memberRegist
	 * @param workId 
	 */
	public void removeMemMstByMemKey(MemSubjRegist memberRegist, String workId, 
			String hUpdCD) {
		Map<String, Object> param = new HashMap<>();
		param.put("memberRegist", memberRegist);
		param.put("workId", workId);
		param.put("hUpdCD", hUpdCD);
		memberReportRepository.insertMemMstHisByRegistCancel(param);
		memberReportRepository.deleteMemMstByRegistCancel(param);
	}

	/**
	 * @param memberRegist
	 * @param workId
	 */
	public void removeMemSubjMstByMemKeyAndSubj(MemSubjRegist memberRegist,
			String workId, String hUpdCD) {
		Map<String, Object> param = new HashMap<>();
		param.put("memberRegist", memberRegist);
		param.put("workId", workId);
		param.put("hUpdCD", hUpdCD);
		memberReportRepository.insertMemSubjMstHisByRegistCancel(param);
		memberReportRepository.deleteMemSubjMstByRegistCancel(param);
		
	}

	/**
	 * @param memberRegist
	 * @param workId void
	 */
	public void removeMemSubjStudyByMemKeyAndSubj(MemSubjRegist memberRegist,
			String workId, String hUpdCD) {
		Map<String, Object> param = new HashMap<>();
		param.put("memberRegist", memberRegist);
		param.put("workId", workId);
		param.put("hUpdCD", hUpdCD);
		memberReportRepository.insertMemSubjStudyHisByRegistCancel(param);
		memberReportRepository.deleteMemSubjStudyByRegistCancel(param);
	}

	/**
	 * @param memberRegist
	 * @param workId void
	 */
	public void removeMemSubjRegistByMemKeyAndSubj(MemSubjRegist memberRegist,
			String workId, String hUpdCD) {
		Map<String, Object> param = new HashMap<>();
		param.put("memberRegist", memberRegist);
		param.put("workId", workId);
		param.put("hUpdCD", hUpdCD);
		memberReportRepository.insertMemSubjRegistHisByRegistCancel(param);
		memberReportRepository.deleteMemSubjRegistByRegistCancel(param);
		
	}

	/**
	 * @param memberRegist
	 * @param workId void
	 */
	public void removeMemSubjTuitionByMemKeyAndSubj(MemSubjRegist memberRegist,
			String workId, String hUpdCD) {
		Map<String, Object> param = new HashMap<>();
		param.put("memberRegist", memberRegist);
		param.put("workId", workId);
		param.put("hUpdCD", hUpdCD);
		memberReportRepository.insertMemSubjTuitionHisByRegistCancel(param);
		memberReportRepository.deleteMemSubjTuitionByRegistCancel(param);
		
	}

	/**
	 * @param memberRegist
	 * @param workId void
	 */
	public void removeMemSubjProgressByMemKeyAndSubj(
			MemSubjRegist memberRegist, String workId, String hUpdCD) {
		Map<String, Object> param = new HashMap<>();
		param.put("memberRegist", memberRegist);
		param.put("workId", workId);
		param.put("hUpdCD", hUpdCD);
		memberReportRepository.insertMemSubjProgressHisByRegistCancel(param);
		memberReportRepository.deleteMemSubjProgressByRegistCancel(param);
		
	}

	/**
	 * @param memberRegist
	 * @param workId
	 * @param hUpdCD void
	 */
	public void setMemSubjMstByMemKeyAndSubj(MemSubjRegist memberRegist,
			String workId, String hUpdCD) {
		Map<String, Object> param = new HashMap<>();
		param.put("memberRegist", memberRegist);
		param.put("workId", workId);
		param.put("hUpdCD", hUpdCD);
		memberReportRepository.insertMemSubjMstHisByRegistCancel(param);
		memberReportRepository.updateMemSubjMstByRegistCancel(param);
	}

	/**
	 * @param memberRegist
	 * @param workId
	 * @param hUpdCD void
	 */
	public void setMemSubjStudyByMemKeyAndSubj(MemSubjRegist memberRegist,
			String workId, String hUpdCD) {
		Map<String, Object> param = new HashMap<>();
		param.put("memberRegist", memberRegist);
		param.put("workId", workId);
		param.put("hUpdCD", hUpdCD);
		memberReportRepository.insertMemSubjStudyHisByRegistCancel(param);
		memberReportRepository.updateMemSubjStudyByRegistCancel(param);
	}

	/**
	 * @param hkey
	 * @return MemberReportFreeDiagInfo
	 * @throws ParseException 
	 */
	public List<MemberReportFreeDiagInfo> getMemberReportFreeDiagInfoByHkey(
			String hkey) throws ParseException {
		List<MemberReportFreeDiagInfo> memberReportFreeDiagInfos = memberReportRepository.findMemberReportFreeDiagInfoByHkey(hkey);
		for (MemberReportFreeDiagInfo memberReportFreeDiagInfo : memberReportFreeDiagInfos) {
			if(memberReportFreeDiagInfo.getOmrBirth() != null && !memberReportFreeDiagInfo.getOmrBirth().isEmpty()){
				memberReportFreeDiagInfo.setOmrBirth(CommonUtils.changeDateFormat("yyyy-MM-dd", "MM/dd/yyyy", memberReportFreeDiagInfo.getOmrBirth()));
			}
			if(memberReportFreeDiagInfo.getMemKey() == null || memberReportFreeDiagInfo.getMemKey().isEmpty()){
				if(memberReportFreeDiagInfo.getAidx() != 0){
					memberReportFreeDiagInfo.setMemberReportFreeDiagSubjInfos(memberReportRepository.findMemberReportFreeDiagSubjInfosByHkey(memberReportFreeDiagInfo.getAidx()));
				}
			}else{
				memberReportFreeDiagInfo.setMemberReportFreeDiagSubjInfos(memberReportRepository.findMemberReportFreeDiagSubjInfosByMemKey(memberReportFreeDiagInfo.getMemKey()));
			}
		}
		return memberReportFreeDiagInfos;
	}


}
