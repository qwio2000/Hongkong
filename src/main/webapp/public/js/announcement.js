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
		var searchValue = $('#searchValue');
		if(searchValue.val().trim() == ""){
			alert("검색어를 입력해 주세요");
			searchValue.focus();
			return false;
		}
		$("#pageNum").val("1");
		$.getBoardList();
	});
	
	$("#submitBtn").on("click",function() {
		var boardSubject = $("#boardSubject");
		var boardContent = $("#boardContent");
		
		if(boardSubject.val().trim() == ""){
			alert("제목을 입력해 주세요");
			boardSubject.focus();
			return false;
		}else if(boardContent.val().trim() == ""){
			alert("내용을 입력해 주세요");
			boardContent.focus();
			return false;
		}
		$("#announcementFrm").submit();
		
	});
	$(".attachFile").on("change",function() {
		var f = this.files[0];
		if(f.size > 5 * 1024 * 1024){
			alert('파일 첨부는 5MB까지 가능합니다.');
			this.value = "";
			this.focus();
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
