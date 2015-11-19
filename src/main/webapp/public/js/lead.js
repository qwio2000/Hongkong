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

//Lead 등록
function addNewLead(){
	if(!validLead()){return;}
	if(!confirm('등록하시겠습니까?')){return;}
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
//정렬
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
//Lead => Note 등록
function addNewNote(){
	var idx = $("#idx").val();
	var notes = $("#notes").val();
	if(!($.required("notes","Notes"))){return;}
	if(!confirm('등록하시겠습니까?')){return;}
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
//Lead 수정
function updateLead() {
	if(!validLead()){return;}
	if(!confirm('수정하시겠습니까?')){return;}
	var idx = $("#idx").val();
	var param = $("#leadForm").serialize();
	$.ajax({
		url:"/ja/leads/"+idx,
		type:"POST",
		cache: false,
		data: param,
		dataType: "text",
		success: function(jsonData, textStatus, XMLHttpRequest) {
			alert(jsonData);
			location.href="/ja/leads/"+idx;
		},
		error:function (xhr, ajaxOptions, thrownError){	
			alert(thrownError);
		}
	});
}

function validLead(){
	if(!($.required("contactFstName","Contact First Name"))){return false;}
	if(!($.required("contactLstName","Contact Last Name"))){return false;}
	if(!($.required("contactEmail","Contact Email"))){return false;}
	if($.trim($("#contactEmail").val()) != ''){
		if(!$.emailCheck("contactEmail")){
			$("#contactEmail").focus();
			return false;
		}
	}
	if($.trim($("#partnerEmail").val()) != ''){
		if(!$.emailCheck("partnerEmail")){
			$("#partnerEmail").focus();
			return false;
		}
	}
	//Phone
	if($.trim($("#phone").val()) == '' && $.trim($("#cellPhone").val()) == ''){
		alert('연락처를 하나 이상 입력해주십시오.');
		$("#phone").focus();
		return false;
	}
	if($.trim($("#phone").val()) != ''){
		if(!$.phoneCheck('phone','Phone')){
			$("#phone").focus();
			return false;
		}
	}
	if($.trim($("#cellPhone").val()) != ''){
		if(!$.phoneCheck('cellPhone','Cell Phone')){
			$("#cellPhone").focus();
			return false;
		}
	}
	return true;
	
}