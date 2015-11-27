$(function(){	
	$.extend({
		//조직찾기
		openDeptSearch:function(){
			var url = "/ja/members/analysis/deptSearchPop";
			$.openPop(url, "deptSearchPop","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=600,height=600");		
		},
		deptSearchSelect:function(jisaCD,deptCD,deptName){
			opener.$("#deptCD").val(deptCD);			
			opener.$("#deptName").val(deptName);
			self.close();
		},
		getSubjReport:function(){
			var searchUrl = "/ja/members/analysis/subjectReport";
			var deptCD = $("#deptCD").val();
			var searchYYMM     = $("#searchYYMM").val();
			var pastMonth = $("#pastMonth").val();
			var paramData = {"deptCD":deptCD, "searchYYMM":searchYYMM, "pastMonth":pastMonth};
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				data: paramData,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var source = $("#subjReportTemplate").html();
					var template = Handlebars.compile(source);
					Handlebars.registerHelper("inc", function(value, options){
						return parseInt(value) + 1;
					});
					Handlebars.registerHelper("zeroNonDisplay", function(value, options){
						if(value == 0){
							return "";
						}else{
							return value;
						}
					});
					Handlebars.registerHelper("getRate", function(totEnd, value, options){
						if(totEnd != 0){
							return (value/totEnd * 100).toFixed(2);
						}else{
							return 0.00;
						}
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
	
	$("#memberAnalysisJASubmit").click(function(){
		$("#searchForm").submit();
	});
	
	$("#memberAnalysisJAInit").click(function(){
		location.href="/ja/members/analysis";
	});
	
	$("#memberAnalysisGradeJASubmit").click(function(){
		$("#searchForm").submit();
	});
	
	$("#memberAnalysisGradeJAInit").click(function(){
		location.href="/ja/members/analysis/grade";
	});
	
	$("#subjectReportSubmit").click(function(){
		$("#searchForm").submit();
	});
	
	$("#subjectReportInit").click(function(){
		location.href="/ja/members/analysis/subject";
	});
	
	$("#subjectReportBtn").click(function(){
		$.getSubjReport();
	});
	
	if(window.location.pathname == '/ja/members/analysis/subject'){
		$.getSubjReport();
	}
});
function dropDetail(searchYY, deptCD, deptName){
	$.openPop('/ja/members/analysis/drop/'+deptCD+'?searchYY='+searchYY+'&deptName='+deptName, 'memberReportPop', 'width=1200,height=800,scrollbars=yes,resizable=no');
}
