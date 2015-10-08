$(function(){	
	$("#name").focus(function(){
		$("#comment").show();
	});
	$("#name").on("keyup", function(){
		var name = $.trim($("#name").val());
		if(name.length >= 3){
			var url = "/fa/members/regist/search";
			$.ajax({
				url: url,
				type:"GET",
				cache: false,
				data: {"name":name},
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var source = $("#memberRegistSearch").html();
					var template = Handlebars.compile(source);
					Handlebars.registerHelper("inc", function(value, options){
						return value + 1;
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
	$("#hiddenPicker").datepicker({
		changeMonth: true,
		changeYear: true,
		yearRange: '1950:2015',
		dateFormat: 'dd/mm/yy',
		onSelect: function(dataText, inst){
			var dataSplit = dataText.split("/");
			var yy = dataSplit[2];
			var mm = dataSplit[1];
			var dd = dataSplit[0];
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
					console.log(jsonData);
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
	$("input[name='subj']").click(function(){
		var isChecked = $(this).prop('checked');
		var subj = $(this).val();
		if(isChecked){
			$("#firstManageDate_"+subj).attr("disabled",false);
			$("#manageTime_"+subj).attr("disabled",false);
			$("#bookNum_"+subj).attr("disabled",false);
			$("#monthNum_"+subj).attr("disabled",false);
			$("#studyNum_"+subj).attr("disabled",false);
			$("#fee_"+subj).attr("disabled",false);
			$("#isResume_"+subj).attr("disabled",false);
			feeCalc(subj);
		}else{
			$("#firstManageDate_"+subj).attr("disabled",true);
			$("#manageTime_"+subj).attr("disabled",true);
			$("#bookNum_"+subj).attr("disabled",true);
			$("#monthNum_"+subj).attr("disabled",true);
			$("#studyNum_"+subj).attr("disabled",true);
			$("#fee_"+subj).attr("disabled",true);
			$("#isResume_"+subj).attr("disabled",true);
			$("#fee_"+subj).val('');
		}
	});
	
	$("#registBtn").click(function(){
		var isValid = submitValid();
		if(!isValid){
			return;
		}
		$("#registForm").submit();
	});
	
	$('select[id^=firstManageDate_]').change(function(){
		var subj = $(this).attr('id').substring($(this).attr('id').length-2, $(this).attr('id').length);
		feeCalc(subj);
	});
	$('input[name=registWhy]').click(function(){
		if(this.value == '99'){
			$("#registWhyEtc").attr("disabled", false);
		}else{
			$("#registWhyEtc").attr("disabled", true);
		}
	});
	$('input[name=registHow]').click(function(){
		if(this.value == '99'){
			$("#registHowEtc").attr("disabled", false);
		}else{
			$("#registHowEtc").attr("disabled", true);
		}
	});
});
//회비 계산
function feeCalc(subj){
	var bookNum = $("#bookNum_"+subj).val();
	var firstManageDate = $("#firstManageDate_"+subj).val();
	var param = {"firstManageDate":firstManageDate, "bookNum":bookNum};
	var fee;
	$.ajax({
		url:"/fa/members/regist/feecalc",
		type:"GET",
		data: param,
		cache: false,
		dataType: "text",
		success: function(jsonData, textStatus, XMLHttpRequest) {
			$("#fee_"+subj).val(jsonData);
		},
		error:function (xhr, ajaxOptions, thrownError){	
			alert(thrownError);
		}
	});
}

function submitValid(){
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
	//회원 학교
	if(!$.required('schoolName','학교 명')){
		$("#schoolName").focus();
		return false;
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
	
	//학부모 이메일
	if($.trim($("#gEmail").val()) != ''){
		if(!$.emailCheck("gEmail")){
			$("#gEmail").focus();
			return false;
		}
	}
	//회원 이메일
	if($.trim($("#mEmail").val()) != ''){
		if(!$.emailCheck("mEmail")){
			$("#mEmail").focus();
			return false;
		}
	}
	
	if(!$("input:checkbox[name='subj']").is(":checked")){
		alert('입회 하려는 과목을 선택해 주십시오');
		return false;
	}
	return true;
}
