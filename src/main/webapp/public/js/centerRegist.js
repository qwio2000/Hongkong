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
		
		if(!($.required("centerType","Center Type"))){return;}
		if(!($.required("deptName","Center Name"))){return;}
		if(!($.required("empFstName","Director’s First Name"))){return;}
		if(!($.required("empLstName","Director’s Last Name"))){return;}
		if(!($.required("stateCD","State"))){return;}
		if(!($.required("phone","Phone"))){return;}		
		if(!($.required("contractTerm","Contract Term"))){return;}
		if(!($.required("contractMMDDYY","Contract Date"))){return;}
		
		var centerType = $("#centerType > option:selected").val();
		if(centerType != ''){
			var centerTypeSplit = centerType.split(",");
			$("#deptType").val(centerTypeSplit[0]);
			$("#memType").val(centerTypeSplit[1]);
			$("#feeType").val(centerTypeSplit[2]);			
		}
		if($.trim($("#email").val()) != ''){
			if(!$.emailCheck("email")){
				$("#email").focus();
				return;
			}
		}
		var contractDateSplit = $("#contractMMDDYY").val().split("/");
		var contractDate = contractDateSplit[2] + "-" + contractDateSplit[0] + "-" +  contractDateSplit[1]; // YYYY-MM-DD	
		$("#contractDate").val(contractDate);
		if($("#openMMDDYY").val() != ''){
			var openDateSplit = $("#openMMDDYY").val().split("/");
			var openDate = openDateSplit[2] + "-" + openDateSplit[0] + "-" +  openDateSplit[1]; // YYYY-MM-DD	
			$("#openDate").val(openDate);
			if($("#openDate").val() < $("#contractDate").val()){
				alert("오픈일을 계약일 이후로 설정해 주세요.");
				return;
			}			
		}else{
			$("#openDate").val('');
		}
	
		if($("#deptCD").val()!=""){
			if(!$("input:radio[name='statusCD']").is(":checked")){
				alert('Status 를 선택해 주십시오');
				return;
			}			
			if($("input:radio[name='statusCD']:checked").val()=="1"){
				if($("#openMMDDYY").val() == ''){
					alert('오픈일을 선택해 주십시오');
					return;
				}
			}
			if($("input:radio[name='statusCD']:checked").val()=="2"){
				if($("#contractDate").val() > $.toDay() || $("#openDate").val() > $.toDay() ){
					alert('계약일과 오픈일을 확인 해 주세요.\n가맹점 폐쇄일보다 이전이어야 합니다.');
					return;
				}
				if($("#openMMDDYY").val() == '' ){
					alert('오픈일을 입력 해 주세요.');
					return;
				}				
				
			}				
		}
		if(!$("input:radio[name='rtyType']").is(":checked")){
			alert('Royalty Charge 를 선택해 주십시오');
			return;
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
				if($("#deptCD").val()!=""){
					self.close();
					opener.location.reload();
				}
				else{
					location.replace("/ja/centers/centerRegist");					
				}
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(_THROWNERROR);
			}
		});
		
	});	
	$("#contractMMDDYY").datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		yearRange: 'c-1:c+1',
		dateFormat: 'mm/dd/yy'
    });		
	$("#contractDatePicker, #contractMMDDYY").click(function(){
		$("#contractMMDDYY").val(''); 	
		$("#contractMMDDYY").datepicker("show");
	});		
	$("#openMMDDYY").datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		yearRange: 'c-1:c+1',
		dateFormat: 'mm/dd/yy',
		onSelect: function(dataText, inst){
			var dataSplit = dataText.split("/");
			var yy = dataSplit[2];
			var mm = dataSplit[0];
			var dd = dataSplit[1];
			var openDate = yy + "-" + mm + "-" +  dd;
			if(openDate < $.toDay()){
				alert('Open Date를 오늘 이후로 입력하십시요.');
				$("#openMMDDYY").val('');	
				return;
			}
		}	
    });		
	$("#openDatePicker, #openMMDDYY").click(function(){
		$("#openMMDDYY").val(''); 		
		$("#openMMDDYY").datepicker("show");
	});	

});
