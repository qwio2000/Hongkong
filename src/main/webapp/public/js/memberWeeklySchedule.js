$(function(){	
	$.extend({
		getWeeklySchedule:function(){
			var subj = $("#subject").val();
			var searchUrl = "/fa/members/weeklyschedule/"+subj;
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var source = $("#weeklyScheduleTemplate").html();
					var template = Handlebars.compile(source);
					Handlebars.registerHelper("inc", function(value, options){
						return (pageNum - 1) * pageSize + parseInt(value) + 1;
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
					Handlebars.registerHelper('splitSchedule', function(str) {
						var rtnStr = "";
						if(str.indexOf(",") > -1){
							var splitStr = str.split(",");
							for (var i = 0; i < splitStr.length; i++) {
								if(splitStr[i].indexOf("|") > -1){
									var memSplitStr = splitStr[i].split("|");
									rtnStr += "<a href='javascript:changeManagePop(\""+memSplitStr[0]+"\",\""+memSplitStr[2]+"\",\""+memSplitStr[1]+"\");' title='"+memSplitStr[2]+"' class='btn_schedule'>"+memSplitStr[0]+"("+memSplitStr[1]+")</a>";
								}else{
									return new Handlebars.SafeString("error");
								}
							}
						}else{
							if(str.indexOf("|")> -1){
								var memSplitStr = str.split("|");
								rtnStr += "<a href='javascript:changeManagePop(\""+memSplitStr[0]+"\",\""+memSplitStr[2]+"\",\""+memSplitStr[1]+"\");' title='"+memSplitStr[2]+"' class='btn_schedule'>"+memSplitStr[0]+"("+memSplitStr[1]+")</a>";
							}else{
								return new Handlebars.SafeString("error");
							}
						}
						return new Handlebars.SafeString(rtnStr);
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
	if(window.location.pathname == '/fa/members/weeklyschedule'){
		$.getWeeklySchedule();
	}
	$("input[name=subj]").change(function(){
		$("#subject").val($(this).val());
		$.getWeeklySchedule();
	});
});

function changeManagePop(memKey, memName, subj){
	$.openPop('/fa/members/weeklyschedule/manageInfo?memKey='+memKey+'&memName='+memName+'&subj='+subj, 'weeklySchedulePop', 'width=350,height=250,scrollbars=yes,resizable=no');
}
function changeManageInfoSubmit(){
	if(confirm('회원의 관리요일/시간을 변경하시겠습니까?')){
		var param = $("#manageUpdateForm").serialize();
		$.ajax({
			url:"/fa/members/weeklyschedule/manageInfo",
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
