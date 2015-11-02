$(function(){	
	$.extend({
		getMemAppointments:function(){
			var pageNum = $("#pageNum").val();
			var searchUrl = "/fa/diagnosis/appointment/"+pageNum;
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var pageInfo = jsonData.pageInfo;
					var totalRowCnt = pageInfo.totalRowCnt;
					var pageNum = pageInfo.pageNum;
					var pageSize = pageInfo.rowBlockSize;
					if(pageInfo.totalPageCnt > 1){
						$("#pageNavi").html($.pageUtil(pageInfo.pageNum,pageInfo.totalPageCnt, 
								pageInfo.pageBlockSize,pageInfo.startPageNum,pageInfo.endPageNum));	
					}
					var source = $("#memAppointmentTemplate").html();
					var template = Handlebars.compile(source);
					Handlebars.registerHelper("inc", function(value, options){
						return (pageNum - 1) * pageSize + parseInt(value) + 1;
					});
					Handlebars.registerHelper("imgPath", function(options){
						return imgPath;
					});
					Handlebars.registerHelper('splitSubj', function(str) {
						var rtnStr = "";
						if(str.indexOf(",") > -1){
							var splitStr = str.split(",");
							for (var i = 0; i < splitStr.length; i++) {
								rtnStr += (i != splitStr.length -1) ? splitStr[i]+"<br/>": splitStr[i];
							}
							return new Handlebars.SafeString(rtnStr);
						}else{
							return new Handlebars.SafeString(str);
						}
					});
					Handlebars.registerHelper('getSubj', function(str, idx) {
						var rtnStr = "";
						if(str.indexOf(",") > -1){
							var splitStr = str.split(",");
							if(splitStr.length -1 >= idx){
								rtnStr += splitStr[idx];
							}
							return new Handlebars.SafeString(rtnStr);
						}else{
							return new Handlebars.SafeString(str);
						}
					});
					Handlebars.registerHelper('xIf', function (lvalue, operator, rvalue, options) {
					    var operators, result;
					    if (arguments.length < 3) {
					        throw new Error("Handlerbars Helper 'compare' needs 2 parameters");
					    }
					    if (options === undefined) {
					        options = rvalue;
					        rvalue = operator;
					        operator = "===";
					    }
					    operators = {
					        '==': function (l, r) { return l == r; },
					        '===': function (l, r) { return l === r; },
					        '!=': function (l, r) { return l != r; },
					        '!==': function (l, r) { return l !== r; },
					        '<': function (l, r) { return l < r; },
					        '>': function (l, r) { return l > r; },
					        '<=': function (l, r) { return l <= r; },
					        '>=': function (l, r) { return l >= r; },
					        'typeof': function (l, r) { return typeof l == r; }
					    };

					    if (!operators[operator]) {
					        throw new Error("'xIf' doesn't know the operator " + operator);
					    }

					    result = operators[operator](lvalue, rvalue);
					    if (result) {
					        return options.fn(this);
					    } else {
					        return options.inverse(this);
					    }
					});
					$("#mainContent").empty();
					$("#mainContent").append(template(jsonData));
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		}
	});
	if(window.location.pathname == '/fa/diagnosis/appointment' && $('#type').val() == '01'){
		$.getMemAppointments();
	}
	
	$("#hiddenPicker").datepicker({
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
			$("#dobMonth").val(mm);
			$("#dobDay").val(dd);
			$("#dobYear").val(yy);
		}
	});
	$("#dobDatePicker").click(function(){
		var mm = $("#dobMonth").val();
		var dd = $("#dobDay").val();
		var yy = $("#dobYear").val();
		$("#hiddenPicker").datepicker("setDate", new Date(yy, mm-1, dd));
		$("#hiddenPicker").datepicker("show");
	});
	
	$("#hiddenPrePicker").datepicker({
		changeMonth: true,
		changeYear: true,
		yearRange: '1950:2015',
		dateFormat: 'mm/dd/yy',
		onSelect: function(dataText, inst){
			$("#preferredYMD").val(dataText);
		}
	});
	$("#preferredYMDPicker, #preferredYMD").click(function(){
		var date = null;
		var birthDay = $('#preferredYMD').val();
		var dataSplit = birthDay.split("/");
		var yy = dataSplit[2];
		var mm = dataSplit[0];
		var dd = dataSplit[1];
		$("#hiddenPrePicker").datepicker("setDate", new Date(yy, mm-1, dd));
		$("#hiddenPrePicker").datepicker("show");
	});
	$("#name").focus(function(){
		$("#comment").show();
	});
	$("#name").on("keyup", function(){
		var name = $.trim($("#name").val());
		if(name.length >= 3){
			var url = "/fa/diagnosis/appointment/search/"+name;
			$.ajax({
				url: url,
				type:"GET",
				cache: false,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var source = $("#memAppointmentTemplate").html();
					var template = Handlebars.compile(source);
					Handlebars.registerHelper("inc", function(value, options){
						return value + 1;
					});
					Handlebars.registerHelper('xIf', function (lvalue, operator, rvalue, options) {
					    var operators, result;
					    if (arguments.length < 3) {
					        throw new Error("Handlerbars Helper 'compare' needs 2 parameters");
					    }
					    if (options === undefined) {
					        options = rvalue;
					        rvalue = operator;
					        operator = "===";
					    }
					    operators = {
					        '==': function (l, r) { return l == r; },
					        '===': function (l, r) { return l === r; },
					        '!=': function (l, r) { return l != r; },
					        '!==': function (l, r) { return l !== r; },
					        '<': function (l, r) { return l < r; },
					        '>': function (l, r) { return l > r; },
					        '<=': function (l, r) { return l <= r; },
					        '>=': function (l, r) { return l >= r; },
					        'typeof': function (l, r) { return typeof l == r; }
					    };

					    if (!operators[operator]) {
					        throw new Error("'xIf' doesn't know the operator " + operator);
					    }

					    result = operators[operator](lvalue, rvalue);
					    if (result) {
					        return options.fn(this);
					    } else {
					        return options.inverse(this);
					    }
					});
					$("#mainContent").empty();
					$("#mainContent").append(template(jsonData));
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		}else{
			$("#mainContent").empty();
		}
	});
	$("#dobMonth").change(function(){
		var month = $("#dobMonth").val();
		var year = $("#dobYear").val();
		var day = $("#dobDay").val();
		if($.trim(month) != '' && $.trim(year) != ''){
			var param = {"year" : year, "month" : month};
			$.ajax({
				url:"/fa/members/regist/maxDays",
				type:"GET",
				data: param,
				cache: false,
				dataType: "text",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					$("#dobDay option").each(function(){
						$(this).remove();
					});
					for (var i = 1; i <= jsonData; i++) {
						if(i < 10){
							if(i == day){
								$("#dobDay").append("<option value='0"+i+"' selected>"+"0"+i+"</option>");
							}else{
								$("#dobDay").append("<option value='0"+i+"'>"+"0"+i+"</option>");
							}
						}else{
							if(i == day){
								$("#dobDay").append("<option value='"+i+"' selected>"+i+"</option>");
							}else{
								$("#dobDay").append("<option value='"+i+"'>"+i+"</option>");
							}
						}
					}
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		}
	});
	$("#registBtn").click(function(){
		var type = $('#type').val();
		if(!submitValid(type)){
			return;
		}
		$("#registForm").submit();
	});
	
	$("#freeDiagBtn").click(function(){
		if(confirm('무료 진단을 하시겠습니까?')){
			var idx = $("#idx").val();
			var subj = $("#subj").val();
			$.openPop('/fa/diagnosis/ippr?memKey='+idx+'&subj='+subj+'&freejindan=A', 'FilePop', 'width=1024,height=800,left=300,scrollbars=yes,resizable=yes');
		}
	});
	
	$('input[name=registWhy]').click(function(){
		if(this.value == '99'){
			$("#registWhyEtc").attr("disabled", false);
		}else{
			$("#registWhyEtc").val('');
			$("#registWhyEtc").attr("disabled", true);
		}
	});
	$('input[name=registHow]').click(function(){
		if(this.value == '99'){
			$("#registHowEtc").attr("disabled", false);
		}else{
			$("#registHowEtc").val('');
			$("#registHowEtc").attr("disabled", true);
		}
	});
});

function deleteAppointment(idx){
	if(confirm('입회 상담 정보를 삭제 하시겠습니까?')){
		$.ajax({
			url:"/fa/members/reports/removeappointment",
			type:"POST",
			cache: true,
			data: {"idx":idx},
			dataType: "text",
			success: function(result, textStatus, XMLHttpRequest) {
				alert(result);
				$.getMemAppointments();
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(thrownError);
			}
		});
	}
}

function updateAppointmentPop(idx){
	$.openPop('/fa/diagnosis/appointment/infopop?idx='+idx, 'memberAppointmentPop', 'width=625,height=400,scrollbars=yes,resizable=no');
}

function appointmentUpdateSubmit(){
	if(confirm('입회상담 약속을 수정하시겠습니까?')){
		var idx = $("#idx").val();
		var param = $("#appointmentForm").serialize();
		$.ajax({
			url:"/fa/diagnosis/appointment/"+idx,
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

function submitValid(type){
	
	if(type == "01" || type == "02"){
		//학부모 이름
		if(!$.required('gFstName','학부모 First Name')){
			$("#gFstName").focus();
			return false;
		}
		if(!$.required('gLstName','학부모 Last Name')){
			$("#gLstName").focus();
			return false;
		}
		//학부모 주소
		if(!$.required('addr','주소')){
			$("#addr").focus();
			return false;
		}
		//학부모 연락처
		if($.trim($("#gPhone").val()) == '' && $.trim($("#gCellPhone").val()) == ''){
			alert('학부모 연락처를 하나 이상 입력해 주십시오.');
			$("#gPhone").focus();
			return false;
		}
		//학부모 이메일
		if($.trim($("#gEmail").val()) != ''){
			if(!$.emailCheck("gEmail")){
				$("#gEmail").focus();
				return false;
			}
		}
	}
	if(type != "03"){
		//회원 이름
		if(!$.required('mFstName','회원 First Name')){
			$("#mFstName").focus();
			return false;
		}
		if(!$.required('mLstName','회원 Last Name')){
			$("#mLstName").focus();
			return false;
		}
		//회원 생년월일
		if(!$.required('dobMonth','생년월일 중 월')){
			$("#dobMonth").focus();
			return false;
		}
		if(!$.required('dobDay','생년월일 중 일')){
			$("#dobDay").focus();
			return false;
		}
		if(!$.required('dobYear','생년월일 중 년')){
			$("#dobYear").focus();
			return false;
		}
		//회원 학년
		if(!$.required('gradeCD','학년')){
			$("#gradeCD").focus();
			return false;
		}
		if(type != "02"){
			//회원 학교
			if(!$.required('schoolName','학교 명')){
				$("#schoolName").focus();
				return false;
			}
		}
		//회원 생년월일 년도
		if($.trim($("#dobYear").val()) == ''){
			alert('회원의 생일을 입력해 주세요.');
			$("#dobYear").focus();
			return false;
		}else if($.trim($("#dobYear").val()).length != 4){
			alert('년도를 4자리로 입력해주세요 ex)2000');
			$("#dobYear").focus();
			return false;
		}
		var today = new Date();
		var date = new Date($.trim($("#dobYear").val()),$("#dobMonth").val()-1,$("#dobDay").val());
		if(today < date){
			alert('DOB가 오늘 보다 클 수는 없습니다.');
			return false;
		}
		//회원 이메일
		if($.trim($("#mEmail").val()) != ''){
			if(!$.emailCheck("mEmail")){
				$("#mEmail").focus();
				return false;
			}
		}
		
	}
	if(type != "02"){
		//입회 상담 예약 날짜
		if(!$.required('preferredYMD','입회상담 예약 날짜')){
			$("#preferredYMD").focus();
			return false;
		}
		//입회상담 예약 시간
		if(!$.required('preferredTimes','입회상담 예약 시간')){
			$("#preferredTimes").focus();
			return false;
		}
		//입회상담 예약 내용
		if(!$.required('preferredNotes','입회상담 예약 내용')){
			$("#preferredNotes").focus();
			return false;
		}
		
		if(!$("input:checkbox[name='subj']").is(":checked")){
			alert('입회 상담을 원하는 과목을 선택해 주십시오');
			return false;
		}
	}
	
	return true;
}
function addFreeDiagOtherSubj(key, type){
	$.openPop('/fa/members/reports/freeDiagOtherSubj?key='+key+'&type='+type, 'memberReportPop', 'width=625,height=400,scrollbars=yes,resizable=no');
}

