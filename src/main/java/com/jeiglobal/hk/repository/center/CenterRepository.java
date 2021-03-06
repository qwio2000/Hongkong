package com.jeiglobal.hk.repository.center;

import java.util.List;
import java.util.Map;

import com.jeiglobal.hk.domain.center.CenterCommentCallList;
import com.jeiglobal.hk.domain.center.CenterOpenSubjList;
import com.jeiglobal.hk.domain.center.CenterSearchList;
import com.jeiglobal.hk.domain.center.CenterTypeList;
import com.jeiglobal.hk.domain.center.CenterView;
import com.jeiglobal.hk.domain.center.MemFeeInfoList;
import com.jeiglobal.hk.domain.center.RtyChargeGroupList;
import com.jeiglobal.hk.domain.center.UserList;
import com.jeiglobal.hk.domain.center.UserView;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;


@PrimaryRepositoryAnnoInterface
public interface CenterRepository {
		/**
		 * Center 정보
		 */	
		// 센터 검색 리스트
		public List<CenterSearchList> centerSearchList(Map<String, Object> param);
		// 센터 뷰 
		public CenterView centerView(Map<String, Object> param);
		// 회비 정보
		public List<MemFeeInfoList> memFeeInfoList(Map<String, Object> param);
		// 로열티 그룹 정보
		public List<RtyChargeGroupList> rtyChargeGroupList(Map<String, Object> param);
		// 센터 사업 구조 정보
		public List<CenterTypeList> centerTypeList(Map<String, Object> param);
		// 가맹점 운영시간 셋팅/변경
		public String centerHoursSave(Map<String, Object> param);
		// 상품 정보
		public List<CenterOpenSubjList> centerOpenSubjList(Map<String, Object> param);
		public String centerOpenSubjSave(Map<String, Object> param);
		//센터 신규생성 및 정보변경 저장
		public String centerSave(Map<String, Object> param);
				
		/**
		 * Center CommentCall 정보
		 */		
		public int findCenterCommentCallsCount(String deptCD);
		public List<CenterCommentCallList> findCenterCommentCalls(Map<String, Object> param);
		public void deleteCenterCommentCall(int idx);
		public void insertCenterCommentCall(Map<String, Object> param);		
		
		/**
		 * User 정보
		 */
		public List<UserList> userList(Map<String, Object> param);
		public String userSave(Map<String, Object> param);
		public void changeUserPwdSave(Map<String, Object> param);
		public UserView userView(String userId);
		public int findUsersCount(String userId);
		

		
}
