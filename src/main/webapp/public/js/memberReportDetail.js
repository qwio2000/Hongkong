var url = '';
$(function(){
	var currentPath = window.location.pathname;
	
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
	$("#preferredYMDPicker, #preferredYMD").click(function(){
		$("#hiddenPicker").datepicker("setDate", new Date());
		$("#hiddenPicker").datepicker("show");
	});
	
	$("#hiddenBirthPicker").datepicker({
		changeMonth: true,
		changeYear: true,
		yearRange: '1950:2015',
		dateFormat: 'mm/dd/yy',
		onSelect: function(dataText, inst){
			var today = new Date();
			var dataSplit = dataText.split("/");
			var yy = dataSplit[2];
			var mm = dataSplit[0];
			var dd = dataSplit[1];
			var dob = new Date(yy, mm-1, dd);
			if(today < dob){
				alert('DOB가 오늘 날짜보다 클 수는 없습니다');
				return;
			}
			$("#mBirthDay").val(dataText);
		}
	});
	
	$("#mBirthDayPicker, #mBirthDay").click(function(){
		var date = null;
		var birthDay = $('#mBirthDay').val();
		var dataSplit = $('#mBirthDay').val().split("/");
		var yy = dataSplit[2];
		var mm = dataSplit[0];
		var dd = dataSplit[1];
		$("#hiddenBirthPicker").datepicker("setDate", new Date(yy, mm-1, dd));
		$("#hiddenBirthPicker").datepicker("show");
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
	$(".paging").on("click","a.naviPage",function() {
		var pageNum = $(this).attr('pageNo');	
		$('#pageNum').val(pageNum);
		getCommentCalls();
	});	
	if(currentPath == '/fa/members/reports/commentcall'){
		getCommentCalls();
	}
	
});
function guardianInfoPop(){
	$.openPop('/fa/members/reports/guardian?memKey='+$('#memKey').val()+'&memKeys='+$('#memKeys').val(), 'memberReportPop', 'width=630,height=480,scrollbars=yes,resizable=no');
}
function addCommentCall(memKey, memName){
	$.openPop('/fa/members/reports/commentcall?memKey='+memKey+"&memName="+memName, 'memberReportPop', 'width=625,height=800,scrollbars=yes,resizable=no');
}
function addAppointment(memKey, memName){
	$.openPop('/fa/members/reports/appointment?memKey='+memKey+"&memName="+memName, 'memberReportPop', 'width=625,height=400,scrollbars=yes,resizable=no');
}
function setMemberInfo(memKey){
	$.openPop('/fa/members/reports/memberinfo?memKey='+memKey, 'memberReportPop', 'width=625,height=650,scrollbars=yes,resizable=no');
}
function setMemSubjStudyInfo(memKey){
	$.openPop('/fa/members/reports/memsubjstudyinfo?memKey='+memKey, 'memberReportPop', 'width=625,height=400,scrollbars=yes,resizable=no');
}
function dropMember(memKey, subj, memName, registDate, isCancle, today){
	if(isCancle){
		if(registDate == today){
			alert('당일 입회 회원입니다. 입회 취소를 해 주십시오.');
			return;
		}else{
			if(!confirm('당월 입회 회원이므로 입회 취소가 가능합니다. \n그래도 퇴회를 하시겠습니까?')){
				return;
			}
		}
	}
	$.openPop(url+'drop?memKey='+memKey+"&memName="+memName+"&subj="+subj, 'memberReportPop', 'width=625,height=400,scrollbars=yes,resizable=no');
}
function getIpprs(memKey, memName){
	$.openPop(url+'ipprs?memKey='+memKey+"&memName="+memName, 'memberReportPop', 'width=610,height=400,scrollbars=yes,resizable=no');
}
function viewIppr(jisaCD, omrDate, memKey, subj){
	var lang = subj.substring(0,1);
	if(omrDate != ''){
		if(subj == 'KM' || subj == 'EM'){
			$.openPop('/fa/diagnosis/OmrPrintJD?jisa='+jisaCD+'&mujin=0&omrdate='+omrDate+'&memKey='+memKey+'&subj='+subj, 'FilePop', 'menubar=yes,toolbar=yes,status=no,resizable=yes,scrollbars=yes,width=730,height=700');
		}else{
			$.openPop('/fa/diagnosis/OmrPrint?jisa='+jisaCD+'&mujin=0&omrdate='+omrDate+'&memKey='+memKey+'&subj='+subj+'&lang='+lang+'&avg=Y=', 'FilePop', 'width=700,height=450,marginwidth=0,marginheight=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes');
			
		}
	}else{
		alert(subj+' 과목의 처방 내역이 존재하지 않습니다.');
		return;
	}
}

function guardianInfoSubmit(){
	if(confirm('부모 정보를 변경 하시겠습니까?')){
		if(!$.required('gFstName','학부모 First Name')){
			$("#gFstName").focus();
			return;
		}
		if(!$.required('gLstName','학부모 Last Name')){
			$("#gLstName").focus();
			return;
		}
		//학부모 주소
		if(!$.required('addr','주소')){
			$("#addr").focus();
			return;
		}
		//학부모 연락처
		if($.trim($("#gPhone").val()) == '' && $.trim($("#gCellPhone").val()) == ''){
			alert('학부모 연락처를 하나 이상 입력해 주십시오.');
			$("#gPhone").focus();
			return;
		}
		//학부모 이메일
		if($.trim($("#gEmail").val()) != ''){
			if(!$.emailCheck("gEmail")){
				$("#gEmail").focus();
				return;
			}
		}
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
				location.reload();
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
		//회원 이름
		if(!$.required('mFstName','Member First Name')){
			$("#mFstName").focus();
			return;
		}
		if(!$.required('mLstName','Member Last Name')){
			$("#mLstName").focus();
			return;
		}
		//회원 생년월일
		if(!$.required('mBirthDay','DOB')){
			$("#mBirthDay").focus();
			return;
		}
		//회원 학년
		if(!$.required('gradeCD','Grade')){
			$("#gradeCD").focus();
			return;
		}
		//회원 학교
		if(!$.required('schoolName','School Name')){
			$("#schoolName").focus();
			return;
		}
		//회원 이메일
		if($.trim($("#mEmail").val()) != ''){
			if(!$.emailCheck("mEmail")){
				$("#mEmail").focus();
				return;
			}
		}
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
		if(!$.required('dropReason','Drop Reason')){
			$("#dropReason").focus();
			return;
		}
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
function getCommentCalls(){
	var pageNum = $("#pageNum").val();
	var memKey = $("#memKey").val();
	var param = {"memKey":memKey};
	$.ajax({
		url:"/fa/members/reports/commentcall/"+pageNum,
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
				var source = $("#commentCallTemplate").html();
				var template = Handlebars.compile(source);
				$("#mainContent").append(template(jsonData));
			}
		},
		error:function (xhr, ajaxOptions, thrownError){	
			alert(thrownError);
		}
	});
}
function deleteCommentCall(idx){
	if(confirm('메모를 삭제 하시겠습니까?')){
		var param = {"idx":idx};
		$.ajax({
			url:"/fa/members/reports/commentcall/delete",
			type:"POST",
			cache: true,
			data: param,
			dataType: "text",
			success: function(result, textStatus, XMLHttpRequest) {
				alert(result);
				getCommentCalls();
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(thrownError);
			}
		});
	}
}
