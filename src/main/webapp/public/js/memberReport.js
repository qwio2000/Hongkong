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
			var classDay     = $("#classDay").val();
			var paramData = {"memberStatus":memberStatus, "lastName":lastName, "firstName":firstName, 
					"homePhone":homePhone, "cellPhone":cellPhone, "email":email, "grade":grade, 
					"subject":subject, "classDay":classDay};
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
					$("#pageNavi").html($.pageUtil(pageInfo.pageNum,pageInfo.totalPageCnt, 
							pageInfo.pageBlockSize,pageInfo.startPageNum,pageInfo.endPageNum));	
					var source = $("#memberReportTemplate").html();
					var template = Handlebars.compile(source);
					Handlebars.registerHelper("inc", function(value, options){
						return (pageNum - 1) * pageSize + parseInt(value) + 1;
					});
					Handlebars.registerHelper('splitStr', function(str, index) {
					  var t = str.split(",");
					  if(t[index].indexOf("|") > -1){
						  var dt = t[index].split("|");
						  return new Handlebars.SafeString(dt[0] + "<br/>" + dt[1]);
					  }else{
						  return new Handlebars.SafeString(t[index]);
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
});
