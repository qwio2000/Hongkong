$(function(){	
	$.extend({
		getCenterSearch:function(){

			var deptName 	= $("#centerName").val();
			var city 		= $("#centerCity").val();
			var stateCD 	= $("#centerState").val();
			var statusCD 	= $("#centerStatus").val();
			var sortKind 	= "";
			var sort 		= "";
			var pageNum 	= $("#pageNum").val();
			
			var paramData = {"pageNum":pageNum,"deptName":deptName,"city":city,"stateCD":stateCD,"statusCD":statusCD,"sortKind":sortKind, "sort":sort};
			var setUrl = "/ja/centers/searchResults";
			
			alert("paramData");
			/*
			$.ajax({
				url:setUrl,
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
			*/
		}
	});
	$("#centerSearchBtn").click(function(){
		var isChange = false;
		var userType = $("#userType").val();
		var centerName = $("#centerName").val();
		var centerCity = $("#centerCity").val();
		var centerState = $("#centerState").val();
		var centerStatus = $("#centerStatus").val();
		
		if(centerName != "" || centerCity != "" || centerState != "" || centerStatus != ""){
			isChange = true;
		}
		if(!isChange){
			alert('Please enter your search criteria.');
			return;
		}
		$('#centerSearchForm').submit();
	});
	
	$(".paging").on("click","a.naviPage",function() {
		var pageNum = $(this).attr('pageNo');	
		$('#pageNum').val(pageNum);
		$.getCenterSearch();
	});	
});
