$(function(){	
	$.extend({
		// Royalty Charge 정보
		openRoyaltyGroupInfo:function(){
			var url = "/ja/centers/royaltyGroupInfo";
			$.openPop(url, "royaltyGroupInfo","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=620,height=700");
		}	
			
	});

	//Center 등록/수정
	$("#saveCenterInfo").on("click", function() {
		alert('save');
/*		
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
		
		var param = $("#centerForm").serialize();
		$.ajax({
			url:"/ja/centers/centerSaveJson",
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
*/		
	});	
	

});
