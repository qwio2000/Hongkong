$(function(){	
	$("#hiddenPicker").datepicker({
		changeMonth: true,
		changeYear: true,
		yearRange: '1950:2015',
		dateFormat: 'mm/dd/yy',
		onSelect: function(dataText, inst){
			$("#preferredYMD").val(dataText);
		}
	});
	$("#preferredYMDPicker, #preferredYMD, #mBirthDayPicker, #mBirthDay").click(function(){
		$("#hiddenPicker").datepicker("setDate", new Date());
		$("#hiddenPicker").datepicker("show");
	});
	$("input[name='subj']").click(function(){
		var isChecked = $(this).prop('checked');
		var subj = $(this).val();
		if(isChecked){
			$("#manageTimes_"+subj).attr("disabled",false);
			$("#studyNum_"+subj).attr("disabled",false);
			$("#yoil_"+subj).attr("disabled",false);
		}else{
			$("#manageTimes_"+subj).attr("disabled",true);
			$("#studyNum_"+subj).attr("disabled",true);
			$("#yoil_"+subj).attr("disabled",true);
		}
	});
});
function guardianInfoPop(){
	window.open('/fa/members/reports/guardian?memKey='+$('#memKey').val()+'&memKeys='+$('#memKeys').val(), 'memberReportPop', 'width=630,height=480,scrollbars=no,resizable=no');
}
function addCommentCall(memKey, memName){
	window.open('/fa/members/reports/commentcall?memKey='+memKey+"&memName="+memName, 'memberReportPop', 'width=625,height=400,scrollbars=no,resizable=no');
}
function addAppointment(memKey, memName){
	window.open('/fa/members/reports/appointment?memKey='+memKey+"&memName="+memName, 'memberReportPop', 'width=625,height=400,scrollbars=no,resizable=no');
}
function setMemberInfo(memKey){
	window.open('/fa/members/reports/memberinfo?memKey='+memKey, 'memberReportPop', 'width=625,height=650,scrollbars=no,resizable=no');
}
function setMemSubjStudyInfo(memKey){
	window.open('/fa/members/reports/memsubjstudyinfo?memKey='+memKey, 'memberReportPop', 'width=625,height=400,scrollbars=no,resizable=no');
}

function guardianInfoSubmit(){
	if(confirm('부모 정보를 변경 하시겠습니까?')){
		var param = $("#guardianForm").serialize();
		$.ajax({
			url:"/fa/members/reports/guardian",
			type:"POST",
			cache: true,
			data: param,
			dataType: "text",
			success: function(result, textStatus, XMLHttpRequest) {
				alert(result);
				self.close();
				opener.location.reload();
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(thrownError);
			}
		});
	}
}
function commentCallSubmit(){
	if(confirm('상담 이력을 입력하시겠습니까?')){
		var param = $("#commentCallForm").serialize();
		$.ajax({
			url:"/fa/members/reports/commentcall",
			type:"POST",
			cache: true,
			data: param,
			dataType: "text",
			success: function(result, textStatus, XMLHttpRequest) {
				alert(result);
				self.close();
				opener.location.reload();
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(thrownError);
			}
		});
	}
}
function appointmentSubmit(){
	if(confirm('입회상담 약속을 입력하시겠습니까?')){
		var param = $("#appointmentForm").serialize();
		$.ajax({
			url:"/fa/members/reports/appointment",
			type:"POST",
			cache: true,
			data: param,
			dataType: "text",
			success: function(result, textStatus, XMLHttpRequest) {
				alert(result);
				self.close();
				opener.location.reload();
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(thrownError);
			}
		});
	}
}
function memberInfoSubmit(){
	if(confirm('회원 정보를 변경하시겠습니까?')){
		var param = $("#memberInfoForm").serialize();
		$.ajax({
			url:"/fa/members/reports/memberinfo",
			type:"POST",
			cache: true,
			data: param,
			dataType: "text",
			success: function(result, textStatus, XMLHttpRequest) {
				alert(result);
				self.close();
				opener.location.reload();
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(thrownError);
			}
		});
	}
}
function memSubjStudyInfoSubmit(){
	if(confirm('관리요일 및 관리시간을 변경하시겠습니까?')){
		var param = $("#memSubjStudyForm").serialize();
		console.log(param);
//		$.ajax({
//			url:"/fa/members/reports/memberinfo",
//			type:"POST",
//			cache: true,
//			data: param,
//			dataType: "text",
//			success: function(result, textStatus, XMLHttpRequest) {
//				alert(result);
//				self.close();
//				opener.location.reload();
//			},
//			error:function (xhr, ajaxOptions, thrownError){	
//				alert(thrownError);
//			}
//		});
	}
}

