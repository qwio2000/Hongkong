package com.jeiglobal.hk.service.member;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.member.MemberDto.MemberRegistDropStatus;
import com.jeiglobal.hk.domain.member.MemberDto.MemberRegistDropStatusJA;
import com.jeiglobal.hk.repository.member.*;

/**
 * 클래스명 : MemberStatusService.java
 *
 * 작성일 : 2015. 11. 3.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
@Service
public class MemberStatusService {

	@Autowired
	private MemberStatusRepository memberStatusRepository;
	
	Map<String, Object> param = new HashMap<>();
	
	/**
	 * 가맹점 입퇴회 현황 카운트 수
	 * @param loginInfo
	 * @param searchYYMM
	 * @return int
	 */
	public int getMemberRegistDropStatusCount(LoginInfo loginInfo,
			String searchYYMM) {
		param.clear();
		param.put("loginInfo", loginInfo);
		param.put("searchYYMM", searchYYMM);
		return memberStatusRepository.findMemberRegistDropStatusCount(param);
	}

	/**
	 * 가맹점 입퇴회 현황 리스트
	 * @param loginInfo
	 * @param searchYYMM
	 * @return List<MemberRegistDropStatus>
	 */
	public List<MemberRegistDropStatus> getMemberRegistDropStatus(
			LoginInfo loginInfo, String searchYYMM) {
		param.clear();
		param.put("loginInfo", loginInfo);
		param.put("searchYYMM", searchYYMM);
		return memberStatusRepository.findMemberRegistDropStatus(param);
	}

	/**
	 * 지사 입퇴회 현황
	 * @param loginInfo
	 * @param searchYYMM
	 * @return List<MemberRegistDropStatusJA>
	 */
	public List<MemberRegistDropStatusJA> getMemberRegistDropStatusJA(
			LoginInfo loginInfo, String searchYYMM) {
		param.clear();
		param.put("loginInfo", loginInfo);
		param.put("searchYYMM", searchYYMM);
		return memberStatusRepository.findMemberRegistDropStatusJA(param);
	}

	/**
	 * @param list
	 * @return MemberRegistDropStatusJA
	 */
	public MemberRegistDropStatusJA getTotalRegistDropStatusJA(
			List<MemberRegistDropStatusJA> list) {
		MemberRegistDropStatusJA total = new MemberRegistDropStatusJA();
		for (MemberRegistDropStatusJA memberRegistDropStatusJA : list) {
			total.setKMNew(total.getKMNew() + memberRegistDropStatusJA.getKMNew());
			total.setKKNew(total.getKKNew() + memberRegistDropStatusJA.getKKNew());
			total.setKGNew(total.getKGNew() + memberRegistDropStatusJA.getKGNew());
			total.setEMNew(total.getEMNew() + memberRegistDropStatusJA.getEMNew());
			total.setEENew(total.getEENew() + memberRegistDropStatusJA.getEENew());
			total.setKPNew(total.getKPNew() + memberRegistDropStatusJA.getKPNew());
			total.setKSNew(total.getKSNew() + memberRegistDropStatusJA.getKSNew());
			total.setPSNew(total.getPSNew() + memberRegistDropStatusJA.getPSNew());
			total.setERNew(total.getERNew() + memberRegistDropStatusJA.getERNew());
			total.setCPNew(total.getCPNew() + memberRegistDropStatusJA.getCPNew());
			total.setCLNew(total.getCLNew() + memberRegistDropStatusJA.getCLNew());
			total.setEPNew(total.getEPNew() + memberRegistDropStatusJA.getEPNew());
			total.setTTNew(total.getTTNew() + memberRegistDropStatusJA.getTTNew());
			
			total.setKMDrop(total.getKMDrop() + memberRegistDropStatusJA.getKMDrop());
			total.setKKDrop(total.getKKDrop() + memberRegistDropStatusJA.getKKDrop());
			total.setKGDrop(total.getKGDrop() + memberRegistDropStatusJA.getKGDrop());
			total.setEMDrop(total.getEMDrop() + memberRegistDropStatusJA.getEMDrop());
			total.setEEDrop(total.getEEDrop() + memberRegistDropStatusJA.getEEDrop());
			total.setKPDrop(total.getKPDrop() + memberRegistDropStatusJA.getKPDrop());
			total.setKSDrop(total.getKSDrop() + memberRegistDropStatusJA.getKSDrop());
			total.setPSDrop(total.getPSDrop() + memberRegistDropStatusJA.getPSDrop());
			total.setERDrop(total.getERDrop() + memberRegistDropStatusJA.getERDrop());
			total.setCPDrop(total.getCPDrop() + memberRegistDropStatusJA.getCPDrop());
			total.setCLDrop(total.getCLDrop() + memberRegistDropStatusJA.getCLDrop());
			total.setEPDrop(total.getEPDrop() + memberRegistDropStatusJA.getEPDrop());
			total.setTTDrop(total.getTTDrop() + memberRegistDropStatusJA.getTTDrop());
		}
		return total;
	}

}
