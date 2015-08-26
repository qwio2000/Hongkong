$(function(){
	$.extend({
		getBoardList:function(){
			var pageNum = $("#pageNum").val();
			var searchUrl = "/community/announcements/page/"+pageNum;
			var searchField = $("#searchField").val();
			var searchValue = $.trim($("#searchValue").val());
			var paramData = {"searchField":searchField, "searchValue":searchValue};
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
							pageInfo.rowBlockSize,pageInfo.startPageNum,pageInfo.endPageNum));	
					var source = $("#announcementsTemplate").html();
					var template = Handlebars.compile(source);
					Handlebars.registerHelper("boardNo", function(index, options){
						return totalRowCnt - pageInfo.startRow - index;
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
		},
		fileDelete:function(boardIdx, fileIdx, index){
			if(!confirm('정말 첨부파일을 삭제 하시겠습니까?')){
				return;
			}
			alert(boardIdx);
			alert(fileIdx);
			$.ajax({
				url: "/community/announcements/"+boardIdx+"/"+fileIdx,
				type:"delete",
				cache: false,
				async: true,
				success: function(jsonData, textStatus, XMLHttpRequest) {
					$("#attachFile"+index).empty();
					$("#attachFile"+index).append("<input type='file' name='attachFile'/>");
					alert(jsonData.msg);
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		}
	});
	
	//리스트 페이지인 경우 getBoardList 호출
	if(window.location.pathname == '/community/announcements')
		$.getBoardList();
	// paging 클릭
	$(".paging").on("click","a.naviPage",function() {
		var pageNum = $(this).attr('pageNo');	
		$('#pageNum').val(pageNum);
		$.getBoardList();
	});	
	
	$("#searchBtn").on("click",function() {
		$("#pageNum").val("1");
		$.getBoardList();
	});
	
	$("#submitBtn").on("click",function() {
		var submitType = $("#submitType").val();
		if(submitType == "0"){
			$("#announcementFrm").submit();
		}else if(submitType == "1"){
			$("#announcementFrm").submit();
		}
		
	});
	
	$("#deleteBtn").on("click",function() {
		if(!confirm('정말 삭제 하시겠습니까?')){
			return;
		}
		var boardIdx = $('#boardIdx').val();
		$.ajax({
			url: "/community/announcements/"+boardIdx,
			type:"delete",
			cache: false,
			async: true,
			success: function(jsonData, textStatus, XMLHttpRequest) {
				alert(jsonData.msg);
				location.href="/community/announcements";
			},
			error:function (xhr, ajaxOptions, thrownError){	
				alert(thrownError);
			}
		});
	});
	
});
