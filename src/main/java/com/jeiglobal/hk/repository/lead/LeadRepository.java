package com.jeiglobal.hk.repository.lead;

import java.util.*;

import com.jeiglobal.hk.domain.lead.*;
import com.jeiglobal.hk.repository.*;

/**
 * 클래스명 : LeadRepository.java
 *
 * 작성일 : 2015. 11. 18.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * Lead Repository
 */
@PrimaryRepositoryAnnoInterface
public interface LeadRepository {

	public List<CenterLeads> findLeads(Map<String, Object> param);

	public int findLeadsCount(Map<String, Object> param);

	public void insertCenterLead(CenterLeads centerLead);

	public CenterLeads findCenterLeadByIdx(int idx);

	public List<CenterLeadsNote> findLeadNotesByIdx(int idx);

	public void insertCenterLeadNote(CenterLeadsNote note);

}
