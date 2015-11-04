package com.jeiglobal.hk.repository.member;

import java.util.*;

import com.jeiglobal.hk.domain.member.*;
import com.jeiglobal.hk.domain.member.MemberDto.MemberIpprInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportFreeDiagInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportFreeDiagSubjInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportSubjInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberReportSubjStudyInfo;
import com.jeiglobal.hk.domain.member.MemberDto.MemberSearchInfo;
import com.jeiglobal.hk.repository.*;

/**
 * 클래스명 : MemberSearchRepository.java
 *
 * 작성일 : 2015. 9. 17.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@PrimaryRepositoryAnnoInterface
public interface MemberReportRepository {

	public List<MemberSearchInfo> findSearchResults(Map<String, Object> map);

	public MemMst findMemMstByMemKey(String memKey);

	public List<MemberReportInfo> findMemMstsByGuardianName(
			Map<String, Object> param);

	public List<MemberReportSubjInfo> findMemSubjMstsByMemKey(Map<String, Object> param);

	public void insertMemMstHisForGuadianInfo(Map<String, Object> param);

	public void updateGuardianInfo(Map<String, Object> param);

	public void insertMemCommentCall(Map<String, Object> param);

	public List<String> getMemberSubjects(String memKey);

	public void insertMemAppointment(Map<String, Object> param);

	public void insertMemMstHisForMemberInfo(Map<String, Object> param);

	public void updateMemMst(Map<String, Object> param);

	public void updateMemSubjMstForMemName(Map<String, Object> param);

	public List<MemberReportSubjStudyInfo> findMemberReportSubjStudys(String memKey);

	public void insertMemSubjMstHis(Map<String, Object> param);

	public void updateMemSubjMstForStudyNum(Map<String, Object> param);

	public void insertMemSubjStudyHis(Map<String, Object> param);

	public void updateMemSubjStudy(Map<String, Object> param);

	public void insertMemSubjMstHisByDrop(Map<String, Object> param);

	public void updateMemSubjMstByDrop(Map<String, Object> param);

	public void insertMemSubjDrop(Map<String, Object> param);

	public void insertMemSubjMstHisByDropCancel(Map<String, Object> param);

	public void deleteMemSubjMstByDropCancel(Map<String, Object> param);

	public void insertMemSubjMstByDropCancel(Map<String, Object> param);

	public void insertMemSubjDropHisByDropCancel(Map<String, Object> param);

	public void deleteMemSubjDropByDropCancel(Map<String, Object> param);

	public void deleteMemAppointment(int idx);

	public List<MemberIpprInfo> findMemberIpprs(Map<String, Object> param);

	public MemSubjStudy findMemSubjStudyByMemKeyAndSubj(
			Map<String, Object> param);

	public int findMemCommentCallsCount(String memKey);

	public List<MemCommentCall> findMemCommentCalls(Map<String, Object> param);

	public void deleteCommentCall(int idx);

	public MemSubjRegist findMemSubjRegistByMemKeyAndSubj(
			Map<String, Object> param);

	public int findMemSubjRegistOtherSubjCount(MemSubjRegist memberRegist);

	public void insertMemMstHisByRegistCancel(Map<String, Object> param);

	public void deleteMemMstByRegistCancel(Map<String, Object> param);

	public void insertMemSubjMstHisByRegistCancel(Map<String, Object> param);

	public void deleteMemSubjMstByRegistCancel(Map<String, Object> param);

	public void insertMemSubjStudyHisByRegistCancel(Map<String, Object> param);

	public void deleteMemSubjStudyByRegistCancel(Map<String, Object> param);
	
	public void insertMemSubjRegistHisByRegistCancel(Map<String, Object> param);
	
	public void deleteMemSubjRegistByRegistCancel(Map<String, Object> param);
	
	public void insertMemSubjTuitionHisByRegistCancel(Map<String, Object> param);
	
	public void deleteMemSubjTuitionByRegistCancel(Map<String, Object> param);
	
	public void insertMemSubjProgressHisByRegistCancel(Map<String, Object> param);

	public void updateMemSubjMstByRegistCancel(Map<String, Object> param);

	public void updateMemSubjStudyByRegistCancel(Map<String, Object> param);

	public List<MemberReportFreeDiagInfo> findMemberReportFreeDiagInfoByHkey(
			String hkey);

	public List<MemberReportFreeDiagSubjInfo> findMemberReportFreeDiagSubjInfosByAidx(
			int aidx);

	public List<MemberReportFreeDiagSubjInfo> findMemberReportFreeDiagSubjInfosByMemKey(
			String memKey);

	public void updateGuardianInfoFreeGicho(Map<String, Object> param);

	public void updateGuardianInfoMemAppointment(Map<String, Object> param);

	public void updateFreeGicho(Map<String, Object> param);

	public void updateMemAppointment(Map<String, Object> param);

	public List<String> findFreeDiagOtherSubjByMemKey(String key);

	public List<String> findFreeDiagOtherSubjByIdx(String key);

	public String findSubjsInMemAppointment(String key);

	public List<String> findSubjsExceptDigN(Map<String, Object> param);

	public void updateMemSubjProgressMst(Map<String, Object> param);

}
