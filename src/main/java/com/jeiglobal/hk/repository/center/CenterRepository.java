package com.jeiglobal.hk.repository.center;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.center.CenterSearchList;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;


@PrimaryRepositoryAnnoInterface
public interface CenterRepository {
		// 센터 검색 리스트 SP
		public List<CenterSearchList> centerSearchList(Map<String, Object> param);
		
}
