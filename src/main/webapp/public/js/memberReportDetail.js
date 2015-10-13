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
	$("#preferredYMDPicker").click(function(){
		$("#hiddenPicker").datepicker("setDate", new Date());
		$("#hiddenPicker").datepicker("show");
	});
});
function guardianInfoPop(){
	window.open('/fa/members/reports/guardian?memKey='+$('#memKey').val()+'&memKeys='+$('#memKeys').val(), 'memberReportPop', 'width=630,height=480,scrollbars=yes,resizable=yes');
}
function addCommentCall(memKey, memName){
	window.open('/fa/members/reports/commentcall?memKey='+memKey+"&memName="+memName, 'memberReportPop', 'width=625,height=400,scrollbars=yes,resizable=yes');
}
function addAppointment(memKey, memName){
	window.open('/fa/members/reports/appointment?memKey='+memKey+"&memName="+memName, 'memberReportPop', 'width=625,height=400,scrollbars=yes,resizable=yes');
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
function close(){
	self.close();
}

