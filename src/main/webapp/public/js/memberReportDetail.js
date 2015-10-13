var url = '';
$(function(){
	var currentPath = $(location).attr('href');
	
	if($.contains(currentPath, '/fa')){
		url = '/fa/members/reports/';
	}else if($.contains(currentPath, '/ja')){
		url = '/ja/members/search/';
	}
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
	$("a.gray").click(function(){
		alert('해당 정보가 없습니다.');
		return;
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
function dropMember(memKey, subj, memName){
	window.open(url+'drop?memKey='+memKey+"&memName="+memName+"&subj="+subj, 'memberReportPop', 'width=625,height=400,scrollbars=no,resizable=no');
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
		$.ajax({
			url:"/fa/members/reports/memsubjstudyinfo",
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
function dropMemberSubmit(){
	if(confirm('해당 회원의 과목을 퇴회하시겠습니까?')){
		var param = $("#dropMemberForm").serialize();
		console.log(param);
		$.ajax({
			url:url+"drop",
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
function dropCancelMember(memKey, subj, dropDate){
	if(confirm(memKey+' 회원의 '+subj+' 과목을 퇴회 취소 하시겠습니까?')){
		var param = {"memKey":memKey, "subj":subj, "dropDate":dropDate};
		console.log(param);
		$.ajax({
			url:url+"dropcancel",
			type:"POST",
			cache: true,
			data: param,
			dataType: "text",
			success: function(result, textStatus, XMLHttpRequest) {
				alert(result);
				self.close();
				location.reload();
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(thrownError);
			}
		});
	}
}

