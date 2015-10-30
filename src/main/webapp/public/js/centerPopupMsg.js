$(function(){	
	$.extend({
		// 팝업메세지 등록화면으로 GOGO
		goPopUpMsgRegist:function(){
			var url = "/ja/centers/popupMsgRegist";
			location.href=url;
		},	
		goPopUpMsgView:function(idx){
			var url = "/ja/centers/popupMsgEdit?idx="+idx;
			location.href=url;
		},
		// State 소속 센터리스트
		getCenterOfStateList:function(){
			var stateCD = $("#stateCD > option:selected").val();
			var idx = $("#idx").val();
			var param = {"stateCD":stateCD, "idx":idx};
			$.ajax({
				url:"/ja/centers/popupMsg/centerOfState",
				type:"GET",
				cache: true,
				data: param,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					$("#mainContent").empty();					
					if(jsonData.totalCnt > 0){		
						var source = $("#mainContentTemplate").html();
						var template = Handlebars.compile(source);		
						
						// IF
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
						$("#mainContent").append(template(jsonData));	
					}
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(_THROWNERROR);
				}
			});
		},		
		// 리스트
		getPopUpMsgList:function(){
			var pageNum = $("#pageNum").val();
			var param = "";
			$.ajax({
				url:"/ja/centers/popupMsg/"+pageNum,
				type:"GET",
				cache: true,
				data: param,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var pageInfo = jsonData.pageInfo;
					var totalRowCnt = pageInfo.totalRowCnt;
					var pageNum = pageInfo.pageNum;
					var pageSize = pageInfo.rowBlockSize;
					
					if(totalRowCnt > 0){
						if(pageInfo.totalPageCnt > 1){
							$("#pageNavi").html($.pageUtil(pageInfo.pageNum,pageInfo.totalPageCnt, 
									pageInfo.pageBlockSize,pageInfo.startPageNum,pageInfo.endPageNum));	
						}
					}	
					var source = $("#mainContentTemplate").html();
					var template = Handlebars.compile(source);
					
					// 번호
					Handlebars.registerHelper("inc", function(value, options){
						var num = (pageNum - 1) * pageSize + parseInt(value) + 1;
						return num; 
					});
					// IF
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
					alert(_THROWNERROR);
				}
			});
		},
		// 삭제
		deletePopUpMsg:function(idx){
			if(confirm('삭제 하시겠습니까?')){
				var param = {"idx":idx};
				$.ajax({
					url:"/ja/centers/popupMsg/delete", 
					type:"POST",
					cache: true,
					data: param,
					dataType: "text",
					success: function(result, textStatus, XMLHttpRequest) {
						alert(result);
						$.getPopUpMsgList();
					},
					error:function (xhr, ajaxOptions, thrownError){	
						alert(_THROWNERROR);
					}
				});
			}
		}		
		
	});

	
	// 팝업 메세지 등록
	$("#savePopupMsg").on("click", function() {
		if(!($.required("startMMDDYY","From"))){return;}
		if(!($.required("endMMDDYY","To"))){return;}
		if(!($.required("msgTitle","Title"))){return;}
		if(!($.required("msg","Message"))){return;}		
		
		var startYMDSplit = $("#startMMDDYY").val().split("/");
		var startYMD = startYMDSplit[2] + "-" + startYMDSplit[0] + "-" +  startYMDSplit[1]; // YYYY-MM-DD
		var endYMDSplit = $("#endMMDDYY").val().split("/");
		var endYMD = endYMDSplit[2] + "-" + endYMDSplit[0] + "-" +  endYMDSplit[1];
		if(endYMD < startYMD){
			alert("종료일을 시작일 이후로 설정해 주세요.");
			return;
		}		
		$("#startYMD").val(startYMD);
		$("#endYMD").val(endYMD);		
		
		if($("#stateCD").val()=="ALL" || $("#stateCD").val()=="" ){
			alert("Region : 필수 입력입니다.");
			return;
		}
		if($.btn_check("등록","chk")) {		
			if(confirm('팝업 메세지를 저장 하시겠습니까?')){			
				var param = $("#popupMsgForm").serialize();
				$.ajax({
					url:"/ja/centers/popupMsg/save",
					type:"POST",
					cache: true,
					data: param,
					dataType: "text",
					success: function(result, textStatus, XMLHttpRequest) {
						alert(result);
						location.replace("/ja/centers/popupMsg");
					},
					error:function (xhr, ajaxOptions, thrownError){	
						alert(_THROWNERROR);
					}
				});
			}	
		}
		
	});	
	//Region 셀렉트박스 
	$("#stateCD").on("change", function() {		
		$.getCenterOfStateList();
	});
	// 달력 : 날짜 선택
	$("#startMMDDYY").datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		yearRange: 'c-0:c+2',
		dateFormat: 'mm/dd/yy'		
    });		
	$("#startYMDPicker, #startMMDDYY").click(function(){
		$("#startMMDDYY").val(''); 	
		$("#startMMDDYY").datepicker("show");
	});		
	$("#endMMDDYY").datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		yearRange: 'c-0:c+2',
		dateFormat: 'mm/dd/yy'
    });		
	$("#endYMDPicker, #endMMDDYY").click(function(){
		$("#endMMDDYY").val(''); 		
		$("#endMMDDYY").datepicker("show");
	});		
	
	if(window.location.pathname == '/ja/centers/popupMsg'){
		$.getPopUpMsgList();
	}	
	$(".paging").on("click","a.naviPage",function() {
		var pageNum = $(this).attr('pageNo');	
		$('#pageNum').val(pageNum);
		$.getPopUpMsgList();
	});	
	
	if(window.location.pathname == '/ja/centers/popupMsgEdit'){
		$.getCenterOfStateList();
	}		
	
});
