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
					console.log(jsonData);
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
	if(window.location.pathname == '/fa/diagnosis/appointment'){
		$.getMemAppointments();
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
		var date = null;
		var birthDay = $('#preferredYMD').val();
		var dataSplit = birthDay.split("/");
		var yy = dataSplit[2];
		var mm = dataSplit[0];
		var dd = dataSplit[1];
		$("#hiddenPicker").datepicker("setDate", new Date(yy, mm-1, dd));
		$("#hiddenPicker").datepicker("show");
	});
//	$("#name").focus(function(){
//		$("#comment").show();
//	});
//	$("#name").on("keyup", function(){
//		var name = $.trim($("#name").val());
//		if(name.length >= 3){
//			var url = "/fa/diagnosis/a";
//			$.ajax({
//				url: url,
//				type:"GET",
//				cache: false,
//				data: {"name":name},
//				dataType: "json",
//				success: function(jsonData, textStatus, XMLHttpRequest) {
//					
//				},
//				error:function (xhr, ajaxOptions, thrownError){	
//					alert(thrownError);
//				}
//			});
//		}else{
//			$("#mainContent").empty();
//		}
//	});
	
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
		console.log(param);
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

