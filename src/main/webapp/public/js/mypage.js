$(function(){	
	$.extend({
		// User 정보 변경
		openMyEditUser:function(deptCD,userId){
			var url = "/fa/mypage/userEdit?deptCD="+deptCD+"&userId="+userId;
			$.openPop(url, "userEdit","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=620,height=700");
		},	
		// 가맹점 정보 변경
		openCenterInfoUpd:function(deptCD){
			var url = "/fa/mypage/centerInfoEdit?deptCD="+deptCD;
			$.openPop(url, "centerInfoEdit","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=620,height=700");
		},
		// 가맹점 운영시간 셋팅/변경
		openCenterSetBusinessClassroomHours:function(deptCD,oHoursStart,oHoursEnd,cHoursStart,cHoursEnd ){
			var url = "/fa/mypage/centerSetHours?deptCD="+deptCD+"&oHoursStart="+oHoursStart+"&oHoursEnd="+oHoursEnd+"&cHoursStart="+cHoursStart+"&cHoursEnd="+cHoursEnd;
			$.openPop(url, "centerSetHours","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=620,height=350");
		}
			
	});
	
	//Center 수정
	$("#saveCenterInfo").on("click", function() {
		
		if(!($.required("deptName","Center Name"))){return;}
		if(!($.required("empFstName","Director’s First Name"))){return;}
		if(!($.required("empLstName","Director’s Last Name"))){return;}
		if(!($.required("stateCD","State"))){return;}
		if(!($.required("phone","Phone"))){return;}
		if($.trim($("#email").val()) != ''){
			if(!$.emailCheck("email")){
				$("#email").focus();
				return;
			}
		}
		var contractDateSplit = $("#contractMMDDYY").val().split("/");
		var contractDate = contractDateSplit[2] + "-" + contractDateSplit[0] + "-" +  contractDateSplit[1]; // YYYY-MM-DD	
		$("#contractDate").val(contractDate);
		var openDateSplit = $("#openMMDDYY").val().split("/");
		var openDate = openDateSplit[2] + "-" + openDateSplit[0] + "-" +  openDateSplit[1]; // YYYY-MM-DD	
		$("#openDate").val(openDate);
		
		var param = $("#centerForm").serialize();
		$.ajax({
			url:"/fa/mypage/centerSaveJson",
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

	//User 수정
	$("#saveMypageUserInfo").on("click", function() {
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
		
		//비밀번호
		if($("#userPwd").val()!=''){ // 비번 변경하는 경우
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
			$("#pwdChgFlag").val("Y");
		}else{ 
			$("#pwdChgFlag").val("");
		}
		if(window.location.pathname.indexOf('/fa/mypage/')<0){
			var url = "/ja/mypage/userSaveJson";
		}else{
			var url = "/fa/mypage/userSaveJson";
		}		
		var param = $("#userForm").serialize();
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
				if($("#pwdChgFlag").val()=="Y"){
					alert("비밀번호가 변경되었습니다\n로그인 후 이용해 주십시요.");
					opener.location.href="/logout";
				}else{
					opener.location.reload();
				}
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(_THROWNERROR);
			}
		});
		
	});	
	
	
	


});
