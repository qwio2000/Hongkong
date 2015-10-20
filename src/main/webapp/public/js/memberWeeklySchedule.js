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
					console.log(jsonData);
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
									rtnStr += "<a href='/fa/members/weeklyschedule/"+memSplitStr[0]+"' title='"+memSplitStr[2]+"' class='btn_schedule'>"+memSplitStr[0]+"("+memSplitStr[1]+")</a>";
								}else{
									return new Handlebars.SafeString("error");
								}
							}
						}else{
							if(str.indexOf("|")> -1){
								var memSplitStr = str.split("|");
								rtnStr += "<a href='/fa/members/weeklyschedule/"+memSplitStr[0]+"' title='"+memSplitStr[2]+"' class='btn_schedule'>"+memSplitStr[0]+"("+memSplitStr[1]+")</a>";
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
	$.getWeeklySchedule();
	$("input[name=subj]").change(function(){
		$("#subject").val($(this).val());
		$.getWeeklySchedule();
	});
});
