/**
 * 
 */
package com.jeiglobal.hk.service.diagnosis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.diagnosis.InterimDto;
import com.jeiglobal.hk.domain.diagnosis.InterimDto.InterimSDErrAnalysis;
import com.jeiglobal.hk.domain.diagnosis.InterimDto.InterimSDJindoExpectLst;
import com.jeiglobal.hk.domain.diagnosis.InterimDto.InterimSDWolhakLst;
import com.jeiglobal.hk.domain.diagnosis.InterimDto.InterimSDWorkBasicLst;
import com.jeiglobal.hk.repository.diagnosis.InterimRepository;

/**
 * 클래스명 : InterimService.java
 *
 * 작성일 : 2015. 10. 23.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */
@Service
public class InterimService {
	@Autowired
	private InterimRepository interimRepository;

	public List<InterimDto.InterimWolJinDo> getInterimWolJinDo(
			String jisaCD, String memKey, String subj, String yy, String mm, String wk) {
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("memKey", memKey);		
		map.put("subj", subj);
		map.put("yy", yy);
		map.put("mm", mm);
		map.put("wk", wk);
		return interimRepository.findInterimWolJinDo(map);
	}

	public String addInterimMpiSave(String jisaCD, String deptCD, String memKey, String subj, String yy,
			String mm, String workId, String[] dataarrer) {
		String MpiSaveOK = "";
		String wk = "";
		String wkseq = ""; 
		String setques = ""; 
		String setsubq = "";
		int odabcnt = 0; 
	
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("deptCD", deptCD);		
		map.put("memKey", memKey);
		map.put("subj", subj);
		map.put("yy", yy);
		map.put("mm", mm);
		map.put("workId", workId);
	
		for (int i = 0; i < dataarrer.length; i++) {
			String[] splitArray = dataarrer[i].split(","); 
			wk = splitArray[0];					
			wkseq = splitArray[1];
			setques = splitArray[2];
			setsubq = splitArray[3];
			odabcnt = Integer.parseInt(splitArray[4]);
			
			map.put("wk", wk);
			map.put("wkseq", wkseq);
			map.put("setques", setques);
			map.put("setsubq", setsubq);
			map.put("odabcnt", odabcnt);
			
			MpiSaveOK = interimRepository.findInterimMpiSave(map);

		}
		
		return MpiSaveOK;
	}

	public String addInterimMpiGichoSave(String jisaCD, String deptCD, String memKey, String subj, String yy, String mm,
			String wolhak, String workId) {
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("deptCD", deptCD);		
		map.put("memKey", memKey);
		map.put("subj", subj);
		map.put("yy", yy);
		map.put("mm", mm);
		map.put("wolhak", wolhak);
		map.put("workId", workId);
		
		return interimRepository.findInterimMpiGichoSave(map);
	}

	public InterimDto.InterimSDGichoList getInerimSDGichoList(String jisaCD, String yy, String mm, String memKey, String subj,
			String lang) {
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("yy", yy);		
		map.put("mm", mm);
		map.put("memKey", memKey);
		map.put("subj", subj);
		map.put("lang", lang);
		
		return interimRepository.findInterimSDGichoList(map);
	}

	public List<InterimSDWolhakLst> getInerimSDWolhakLst(String jisaCD, String yy, String mm, String memKey,
			String subj, String lang) {
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("yy", yy);		
		map.put("mm", mm);
		map.put("memKey", memKey);
		map.put("subj", subj);
		map.put("lang", lang);
		
		return interimRepository.findInterimSDWolhakLst(map);
	}

	public List<InterimSDErrAnalysis> getInerimSDErrAnalysis(String jisaCD, String yy, String mm, String memKey,
			String subj, String lang) {		
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("yy", yy);		
		map.put("mm", mm);
		map.put("memKey", memKey);
		map.put("subj", subj);
		map.put("lang", lang);
		
		return interimRepository.findInterimSDErrAnalysis(map);
	}

	public List<InterimSDJindoExpectLst> getInerimSDJindoExpectLst(String jisaCD, String yy, String mm, String memKey,
			String subj, String lang) {
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("yy", yy);		
		map.put("mm", mm);
		map.put("memKey", memKey);
		map.put("subj", subj);
		map.put("lang", lang);
		
		return interimRepository.findInterimSDJindoExpectLst(map);
	}

	public InterimSDWorkBasicLst getInerimSDWorkBasicLst(String jisaCD, String grade, String birthday, String mm) {
		Map<String, Object> map = new HashMap<>();
		map.put("jisaCD", jisaCD);		
		map.put("grade", grade);		
		map.put("birthday", birthday);
		map.put("mm", mm);
		
		return interimRepository.findInterimSDWorkBasicLst(map);
	}


}
