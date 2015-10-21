$(function(){	
	$("#name").focus(function(){
		$("#comment").show();
	});
	$("#name").on("keyup", function(){
		var name = $.trim($("#name").val());
		if(name.length >= 3){
			var url = "/fa/diagnosis/appointmentNewJson";
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
	
});



function addAppointment(memKey, memName){
	$.openPop('/fa/members/reports/appointment?memKey='+memKey+"&memName="+memName, 'memberReportPop', 'width=625,height=400,scrollbars=yes,resizable=no');
}