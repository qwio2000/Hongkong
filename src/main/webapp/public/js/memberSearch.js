$(function(){	
	$.extend({
		getMemberSearch:function(){
			var pageNum = $("#pageNum").val();
			var searchUrl = "/ja/members/search/"+pageNum;
			var centerName = $("#centerName").val();
			var centerCity = $("#centerCity").val();
			var centerState = $("#centerState").val();
			var centerZipcode = $("#centerZipcode").val();
			var memberStatus = $("#memberStatus").val();
			var lastName     = $("#lastName").val();
			var firstName    = $("#firstName").val();
			var homePhone    = $("#homePhone").val();
			var cellPhone    = $("#cellPhone").val();
			var email        = $("#email").val();
			var grade        = $("#grade").val();
			var subject      = $("#subject").val();
			var classDay     = $("#classDay").val();
			var paramData = {"centerName":centerName,"centerCity":centerCity,"centerState":centerState,"centerZipcode":centerZipcode,
					"memberStatus":memberStatus, "lastName":lastName, "firstName":firstName, 
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
					$("#totalCnt").html(totalRowCnt);
					$("#pageNavi").html($.pageUtil(pageInfo.pageNum,pageInfo.totalPageCnt, 
							pageInfo.pageBlockSize,pageInfo.startPageNum,pageInfo.endPageNum));	
					var source = $("#memberReportTemplate").html();
					var template = Handlebars.compile(source);
					Handlebars.registerHelper("boardNo", function(index, options){
						return totalRowCnt - pageInfo.startRow - index;
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
	$("#memberSearchBtn").click(function(){
		var isChange = false;
		var userType = $("#userType").val();
		var centerName = $("#centerName").val();
		var centerCity = $("#centerCity").val();
		var centerState = $("#centerState").val();
		var centerZipcode = $("#centerZipcode").val();
		var memberStatus = $("#memberStatus").val();
		var lastName = $("#lastName").val();
		var firstName = $("#firstName").val();
		var homePhone = $("#homePhone").val();
		var cellPhone = $("#cellPhone").val();
		var email = $("#email").val();
		var grade = $("#grade").val();
		var subject = $("#subject").val();
		var classDay = $("input:checkbox[name='classDay']").is(":checked");
		if(userType == "JA"){
			if(centerName != "" || centerCity != "" || centerState != "" || centerZipcode != "" ||
				lastName != "" || firstName != "" || homePhone != "" || cellPhone != "" || 
				email != "" || grade != "" || subject != "" || classDay != ""){
				isChange = true;
			}
		}else{
			if(memberStatus == "1"){
				isChange = true;
			}else{
				if(lastName != "" || firstName != "" || homePhone != ""
					|| cellPhone != "" || email != "" || grade != "" || 
					subject != "" || classDay != ""){
					isChange = true;
				}
			}
		}
		if(!isChange){
			alert('Please enter your search criteria.');
			return;
		}
		$('#memberSearchForm').submit();
	});
	if(window.location.pathname == '/ja/members/searchResults'){
		$.getMemberSearch();
	}
	
	$(".paging").on("click","a.naviPage",function() {
		var pageNum = $(this).attr('pageNo');	
		$('#pageNum').val(pageNum);
		$.getMemberSearch();
	});	
});
