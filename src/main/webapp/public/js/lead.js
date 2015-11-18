$(function(){	
	$.extend({
		getLeadSearch:function(){
			var pageNum = $("#pageNum").val();
			var searchUrl = "/ja/leads/"+pageNum;
			var contactName = $("#contactName").val();
			var statusCD = $("#statusCD").val();
			var orderBy = $("#orderBy").val();
			var ord = $("#ord").val();
			var paramData = {"contactName":contactName,"statusCD":statusCD,"orderBy":orderBy,"ord":ord};
			console.log(paramData);
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				data: paramData,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					console.log(jsonData);
					var pageInfo = jsonData.pageInfo;
					var totalRowCnt = pageInfo.totalRowCnt;
					var pageNum = pageInfo.pageNum;
					var pageSize = pageInfo.rowBlockSize;
					if(pageInfo.totalPageCnt > 1){
					$("#pageNavi").html($.pageUtil(pageInfo.pageNum,pageInfo.totalPageCnt, 
							pageInfo.pageBlockSize,pageInfo.startPageNum,pageInfo.endPageNum));
					}
					var source = $("#leadsTemplate").html();
					var template = Handlebars.compile(source);
					Handlebars.registerHelper("inc", function(value, options){
						return (pageNum - 1) * pageSize + parseInt(value) + 1;
					});
					$("#mainContent").empty();
					$("#mainContent").append(template(jsonData));
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		},
		getNotes:function(){
			var idx = $("#idx").val();
			var searchUrl = "/ja/leads/notes/"+idx;
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var source = $("#notesTemplate").html();
					var template = Handlebars.compile(source);
					$("#mainContent").empty();
					$("#mainContent").append(template(jsonData));
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		}
	});
	if(window.location.pathname == '/ja/leads'){
		$.getLeadSearch();
	}
	var pattern = new RegExp("\/ja\/leads\/([0-9]+)");
	if(pattern.test($.trim(window.location.pathname))){
		$.getNotes();
	}
	
	$(".paging").on("click","a.naviPage",function() {
		var pageNum = $(this).attr('pageNo');	
		$('#pageNum').val(pageNum);
		$.getLeadSearch();
	});	
});

function addNewLead(){
	var param = $("#leadForm").serialize();
	console.log(param);
	$.ajax({
		url:"/ja/leads",
		type:"POST",
		cache: false,
		data: param,
		dataType: "text",
		success: function(jsonData, textStatus, XMLHttpRequest) {
			alert(jsonData);
			location.href="/ja/leads";
		},
		error:function (xhr, ajaxOptions, thrownError){	
			alert(thrownError);
		}
	});
}

function sort(orderBy){
	$("#orderBy").val(orderBy);
	var ord = $("#ord").val();
	if(ord == "" || ord == "DESC"){
		ord = "ASC";
	}else{
		ord = "DESC";
	}
	$("#ord").val(ord);
	$.getLeadSearch();
}

function leadSearch(){
	var contactName = $("#contactName").val();
	var statusCD = $("#statusCD").val();
	if(contactName == "" && statusCD == ""){
		alert("검색조건을 한 가지 이상 입력해주세요");
		return;
	}
	$.getLeadSearch();
}

function addNewNote(){
	var idx = $("#idx").val();
	var notes = $("#notes").val();
	if(!($.required("notes","Notes"))){return;}
	$.ajax({
		url:"/ja/leads/notes/"+idx,
		type:"POST",
		cache: false,
		data: {"notes":notes},
		dataType: "text",
		success: function(jsonData, textStatus, XMLHttpRequest) {
			$("#notes").val("");
			alert(jsonData);
			$.getNotes();
		},
		error:function (xhr, ajaxOptions, thrownError){	
			alert(thrownError);
		}
	});
}
