$(function(){
	$.extend({
		getBoardList:function(){
			var pageNum = $("#pageNum").val();
			var searchUrl = "/fa/diagnosis/diagnosisSearch/searchJson";
		
			var pageNum = $("#pageNum").val();
			var pagecnt = $.trim($("#pagecnt").val());
			var jisaCD = $.trim($("#jisaCD").val());
			var deptCd = $.trim($("#deptCd").val());
			var status = $.trim($("#status").val());
			var lastName = $.trim($("#lastName").val());
			var firstName = $.trim($("#firstName").val());
			var homePhone = $.trim($("#homePhone").val());
			var cellPhone = $.trim($("#cellPhone").val());
			var email = $.trim($("#email").val());
			var grade = $.trim($("#grade").val());
			var subject = $.trim($("#subject").val());
		
			
			var paramData = {"pageNum":pageNum, "pagecnt":pagecnt, "jisaCD":jisaCD, "deptCd":deptCd, "status":status, "lastName":lastName
					, "firstName":firstName, "homePhone":homePhone, "cellPhone":cellPhone, "email":email, "grade":grade, "subject":subject};
			
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				data: paramData,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					//console.log(jsonData)
					var pageInfo = jsonData.pageUtil;
					var totalRowCnt = pageInfo.totalRowCnt;
					$("#totalCnt").html(totalRowCnt);
					$("#pageNavi").html($.pageUtil(pageInfo.pageNum,pageInfo.totalPageCnt, 
							pageInfo.pageBlockSize,pageInfo.startPageNum,pageInfo.endPageNum));	
					var source = $("#listTemplate").html();
					var template = Handlebars.compile(source);
					Handlebars.registerHelper("boardNo", function(index, options){
						return totalRowCnt - pageInfo.startRow - index;
					});
					$("#diagnosislist").empty();
					$("#diagnosislist").append(template(jsonData));
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		}
	});

	
	
	//리스트 페이지인 경우 getBoardList 호출
	if(window.location.pathname == '/fa/diagnosis/diagnosisSearch/search'){
		$.getBoardList();
	}
	// paging 클릭
	$(".paging").on("click","a.naviPage",function() {
		var pageNum = $(this).attr('pageNo');	
		$('#pageNum').val(pageNum);
		$.getBoardList();
	});	
	
});
