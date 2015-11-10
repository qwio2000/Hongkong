$(function(){	
	$.extend({
		getMemberReport:function(){
			var pageNum = $("#pageNum").val();
			var searchUrl = "/fa/members/reports/"+pageNum;
			var memberStatus = $("#memberStatus").val();
			var lastName     = $("#lastName").val();
			var firstName    = $("#firstName").val();
			var homePhone    = $("#homePhone").val();
			var cellPhone    = $("#cellPhone").val();
			var email        = $("#email").val();
			var grade        = $("#grade").val();
			var subject      = $("#subject").val();
			var orderBy      = $("#orderBy").val();
			var direction      = $("#direction").val();
			var classDay     = $("#classDay").val();
			var paramData = {"memberStatus":memberStatus, "lastName":lastName, "firstName":firstName, 
					"homePhone":homePhone, "cellPhone":cellPhone, "email":email, "grade":grade, 
					"subject":subject, "orderBy":orderBy, "direction":direction, "classDay":classDay};
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				data: paramData,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var pageInfo = jsonData.pageInfo;
					var totalRowCnt = pageInfo.totalRowCnt;
					var pageNum = pageInfo.pageNum;
					var pageSize = pageInfo.rowBlockSize;
					$("#totalCnt").html(totalRowCnt);
					if(pageInfo.totalPageCnt > 1){
						$("#pageNavi").html($.pageUtil(pageInfo.pageNum,pageInfo.totalPageCnt, 
								pageInfo.pageBlockSize,pageInfo.startPageNum,pageInfo.endPageNum));	
					}
					var source = $("#memberReportTemplate").html();
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
	
	$.getMemberReport();
	
	$(".paging").on("click","a.naviPage",function() {
		var pageNum = $(this).attr('pageNo');	
		$('#pageNum').val(pageNum);
		$.getMemberReport();
	});	
	$("a[href=#btnSort]").on('click',function(){
		var sortKind = $(this).attr('sortKind');
		var sort = $("#direction").val();

		if(sort=='ASC' || sort==''){
			sort = 'DESC';
		}else{
			sort = 'ASC';
		}
			
		$("#orderBy").val(sortKind);
		$("#direction").val(sort);
					
		$.getMemberReport();
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
				$.getMemberReport();
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(thrownError);
			}
		});
	}
}
function addCommentCall(memKey, memName){
	$.openPop('/fa/members/reports/commentcall?memKey='+memKey+"&memName="+memName, 'memberReportPop', 'width=625,height=800,scrollbars=yes,resizable=no');
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

function addFreeDiagOtherSubj(key, type){
	$.openPop('/fa/members/reports/freeDiagOtherSubj?key='+key+'&type='+type, 'memberReportPop', 'width=625,height=400,scrollbars=yes,resizable=no');
}
function freeDiagOtherSubj(){
	var freeJindan = '';
	var key = $('#key').val();
	var subj = $('#subj').val();
	if(key.length == '8'){
		freeJindan = 'I';
	}else{
		freeJindan = 'A';
	}
	self.close();
	$.openPop('/fa/diagnosis/ippr?memKey='+key+'&subj='+subj+'&freejindan='+freeJindan, 'FilePop', 'width=1024,height=800,left=300,scrollbars=yes,resizable=yes');
}
