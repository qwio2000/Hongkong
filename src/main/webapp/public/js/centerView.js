$(function(){	
	$.extend({
		// 센터 상담창 오픈
		openCenterCallLog:function(deptCD){
			var url = "/ja/centers/centerCommentCallRegist?deptCD="+deptCD;
			$.openPop(url, "centerCommentCallRegist","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=620,height=700");
		},	
		getCenterCommentCallList:function(){
			var pageNum = $("#pageNum").val();
			var deptCD = $("#deptCD").val();
			var param = {"deptCD":deptCD};
			$.ajax({
				url:"/ja/centers/centerCommentCallRegist/"+pageNum,
				type:"GET",
				cache: true,
				data: param,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var pageInfo = jsonData.pageInfo;
					var totalRowCnt = pageInfo.totalRowCnt;
					var pageNum = pageInfo.pageNum;
					var pageSize = pageInfo.rowBlockSize;
					$("#mainContent").empty();
					if(totalRowCnt > 0){
						if(pageInfo.totalPageCnt > 1){
							$("#pageNavi").html($.pageUtil(pageInfo.pageNum,pageInfo.totalPageCnt, 
									pageInfo.pageBlockSize,pageInfo.startPageNum,pageInfo.endPageNum));	
						}
						var source = $("#mainContentTemplate").html();
						var template = Handlebars.compile(source);
						$("#mainContent").append(template(jsonData));
					}
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(_THROWNERROR);
				}
			});
		},	
		deleteCenterCommentCall:function(idx){
			if(confirm('메모를 삭제 하시겠습니까?')){
				var param = {"idx":idx};
				$.ajax({
					url:"/ja/centers/centerCommentCall/delete",
					type:"POST",
					cache: true,
					data: param,
					dataType: "text",
					success: function(result, textStatus, XMLHttpRequest) {
						//alert(result);
						$.getCenterCommentCallList();
					},
					error:function (xhr, ajaxOptions, thrownError){	
						alert(_THROWNERROR);
					}
				});
			}
		},
		
		
		// User 등록
		openAddNewUser:function(deptCD, addUserFlag, jobFlag){
			if(addUserFlag != "Y"){
				alert("사용자 등록 권한이 없습니다.\n가맹점 오픈일 이후부터 사용자 등록이 가능합니다.");
				return;
			}
			var url = "/ja/centers/userRegist?deptCD="+deptCD+"&jobFlag="+jobFlag;
			$.openPop(url, "userRegist","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=600,height=700");
		},
		// User 정보 변경(관리자)
		openEditUser:function(deptCD,userId,jobFlag){
			var url = "/ja/centers/userEdit?deptCD="+deptCD+"&userId="+userId+"&jobFlag="+jobFlag;
			$.openPop(url, "userEdit","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=600,height=700");
		},	
		// User 정보 변경(자신)
		openMyEditUser:function(deptCD,userId){
			var url = "/ja/mypage/userEdit?deptCD="+deptCD+"&userId="+userId;		
			$.openPop(url, "userEdit","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=620,height=700");
		},			
		userPwdClear:function(userId){
			if(confirm("비밀번호를 초기화 하시겠습니까?\n\n초기화 하시면 비밀번호는 User ID 로 초기화 됩니다.")) {
				var param = $("#userForm").serialize();
				$.ajax({
					url:"/ja/centers/changeUserPwdSaveJson",
					type:"POST",
					cache: false,
					async: true,
					data: param,
					dataType: "text",
					success: function(jsonData, textStatus, XMLHttpRequest) {
						alert(jsonData);
						self.location.reload();
					},
					error:function (xhr, ajaxOptions, thrownError){	
						alert(_THROWNERROR);
					}
				});			
			}
		},	
		
		// 가맹점 정보 변경
		openCenterInfoUpd:function(deptCD){
			var url = "/ja/centers/centerInfoEdit?deptCD="+deptCD;
			$.openPop(url, "centerInfoEdit","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=620,height=700");
		},
		// 가맹점 운영시간 셋팅/변경
		openCenterSetBusinessClassroomHours:function(deptCD,oHoursStart,oHoursEnd,cHoursStart,cHoursEnd ){
			var url = "/ja/centers/centerSetHours?deptCD="+deptCD+"&oHoursStart="+oHoursStart+"&oHoursEnd="+oHoursEnd+"&cHoursStart="+cHoursStart+"&cHoursEnd="+cHoursEnd;
			$.openPop(url, "centerSetHours","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=620,height=350");
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

	// 운영시간 셋팅/변경	
	$("#saveCenterHours").on("click", function() {		
		if(!($.required("oHoursStart","Operating Hours"))){return;}							
		if(!($.required("oHoursEnd","Operating Hours"))){return;}
		if(!($.required("cHoursStart","Class Hours"))){return;}
		if(!($.required("cHoursEnd","Class Hours"))){return;}
		if($("#oHoursStart").val() >= $("#oHoursEnd").val() || $("#cHoursStart").val() >= $("#cHoursEnd").val() ){
			alert("Confirm Hours!!");
			return;
		}
		if(window.location.pathname.indexOf('/fa/mypage/')<0){
			var url = "/ja/centers/centerHoursSaveJson";
		}else{
			var url = "/fa/mypage/centerHoursSaveJson";
		}
		var param = $("#centerHoursForm").serialize();		
		$.ajax({
			url:url,
			type:"POST",
			cache: false,
			async: true,
			data: param,
			dataType: "text",
			success: function(jsonData, textStatus, XMLHttpRequest) {
				alert(jsonData);
				self.close();
				opener.location.reload();
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(_THROWNERROR);
			}
		});
	});	
	
	 
	// 상품 셋팅
	$("#saveCenterOpenSubj").on("click", function() {
		if($.btn_check("update","openSubj")) {
			if(confirm("정보를 변경하시겠습니까?")) {
				var param = $("#centerOpenSubjForm").serialize();
				$.ajax({
					url:"/ja/centers/centerSubjPreferenceSaveJson",
					type:"POST",
					cache: false,
					async: true,
					data: param,
					dataType: "text",
					success: function(jsonData, textStatus, XMLHttpRequest) {
						alert(jsonData);
						self.close();
						opener.location.reload();
					},
					error:function (xhr, ajaxOptions, thrownError){	
						alert(_THROWNERROR);
					}
				});
			}
		}
	});
	
	// 상담 등록
	$("#saveCenterCommentCall").on("click", function() {
		if(confirm('상담 이력을 입력하시겠습니까?')){
			var param = $("#centerCommentCallForm").serialize();
			$.ajax({
				url:"/ja/centers/centerCommentCall/insert",
				type:"POST",
				cache: true,
				data: param,
				dataType: "text",
				success: function(result, textStatus, XMLHttpRequest) {
					//alert(result);
					location.reload();
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(_THROWNERROR);
				}
			});
		}	
	});	
	if(window.location.pathname == '/ja/centers/centerCommentCallRegist'){
		$.getCenterCommentCallList();
	}	
	$(".paging").on("click","a.naviPage",function() {
		var pageNum = $(this).attr('pageNo');	
		$('#pageNum').val(pageNum);
		$.getCenterCommentCallList();
	});	
	
	
	//User 등록/수정
	$("#saveUserInfo").on("click", function() {
		if(!($.required("dutyCD","User Duty"))){return;}		
		if(!($.required("userLevel","User Privilege"))){return;}
		if(!($.required("userFstName","User's First Name"))){return;}
		if(!($.required("userLstName","User's Last Name"))){return;}
		if(!($.required("phone","Phone"))){return;}
		
		if($.trim($("#email").val()) != ''){
			if(!$.emailCheck("email")){
				$("#email").focus();
				return;
			}
		}
		if($("#userId").val()==''){ // 신규등록일때만 체크
			if(!($.required("userPwd","Password"))){return;}
			if(!($.required("reTypeUserPwd","Retype Password"))){return;}
			if(!$.passwordCheck("userPwd","Password")){
				$("#userPwd").focus();
				return;
			}
			if($.trim($("#userPwd").val()) != $.trim($("#reTypeUserPwd").val())){
				alert("Confirm Retype Password!!");
				$("#reTypeUserPwd").focus();
				return;
			}		
		}		
		
		var param = $("#userForm").serialize();
		$.ajax({
			url:"/ja/centers/userSaveJson",
			type:"POST",
			cache: false,
			async: true,
			data: param,
			dataType: "text",
			success: function(jsonData, textStatus, XMLHttpRequest) {
				alert(jsonData);
				self.close();
				opener.location.reload();
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(_THROWNERROR);
			}
		});
		
	});	
	

});
