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
			if(!$.required("centerName","센터 이름")){
				return;
			}
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
			alert('검색 조건을 하나 이상 입력해주세요.');
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

function addCommentCall(memKey, memName){
	$.openPop('/ja/members/search/commentcall?memKey='+memKey+"&memName="+memName, 'memberReportPop', 'width=625,height=800,scrollbars=yes,resizable=no');
}
