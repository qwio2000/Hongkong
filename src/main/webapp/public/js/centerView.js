$(function(){	
	$.extend({
		// 센터 상담창 오픈
		openCenterCallLog:function(deptCD){
			var url = "/ja/centers/centerCommentCallRegist?deptCD="+deptCD;
			$.openPop(url, "centerCommentCallRegist","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=600,height=700");
		},						
		// User 등록
		openAddNewUser:function(deptCD){
			var url = "/ja/centers/userRegist?deptCD="+deptCD;
			$.openPop(url, "userRegist","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=600,height=700");
		},
		// User 정보 변경
		openEditUser:function(deptCD){
			var url = "/ja/centers/userEdit?deptCD="+deptCD;
			$.openPop(url, "userEdit","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=600,height=700");
		},	
		//
		userPwdClear:function(userId){
			alert("비빌번호 초기화");
		},	
		
		// 가맹점 정보 변경
		openCenterInfoUpd:function(deptCD){
			var url = "/ja/centers/centerInfoEdit?deptCD="+deptCD;
			$.openPop(url, "centerInfoEdit","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=620,height=700");
		},
		// 가맹점 운영시간 셋팅/변경
		openCenterSetBusinessClassroomHours:function(deptCD,oHoursStart,oHoursEnd,cHoursStart,cHoursEnd ){
			var url = "/ja/centers/centerHours?deptCD="+deptCD+"&oHoursStart="+oHoursStart+"&oHoursEnd="+oHoursEnd+"&cHoursStart="+cHoursStart+"&cHoursEnd="+cHoursEnd;
			$.openPop(url, "centerHours","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=620,height=350");
		},		
		// 가맹점 출시 상품 셋팅/변경
		openCenterSetSubjPreference:function(deptCD){
			var url = "/ja/centers/centerSetSubjPreference?deptCD="+deptCD;
			$.openPop(url, "centerSetSubjPreference","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=600,height=700");
		},			
		// 상품별 적정재고 수량 셋팅/변경
		goCenterSetRestockQty:function(deptCD,subj){
			alert("상품별 적정재고 수량 셋팅/변경 으로 gogo");
			return;
		},	
		// 회비 정보
		openCenterSetTuitionMatrix:function(deptCD){
			var url = "/ja/centers/tuitionMatrix?deptCD="+deptCD;
			$.openPop(url, "tuitionMatrix","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=600,height=600");
		}		

			
	});

	
	
});
