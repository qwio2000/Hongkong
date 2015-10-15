package com.jeiglobal.hk.repository.center;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.center.CenterSearchList;
import com.jeiglobal.hk.domain.center.CenterView;
import com.jeiglobal.hk.domain.center.MemFeeInfoList;
import com.jeiglobal.hk.domain.center.UserList;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;


@PrimaryRepositoryAnnoInterface
public interface CenterRepository {
		// 센터 검색 리스트 SP
		public List<CenterSearchList> centerSearchList(Map<String, Object> param);
		
		// 센터 뷰 SP 
		public CenterView centerView(Map<String, Object> param);
		
		// User 리스트 SP
		public List<UserList> userList(Map<String, Object> param);
		
		// 회비 정보 SP
		public List<MemFeeInfoList> memFeeInfoList(Map<String, Object> param);
		
}
