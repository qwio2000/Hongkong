$(function(){	
	$.extend({
		// 리스트
		getCenterSearchResult:function(){
			var paramData = {
					"pageNum"	:$("#pageNum").val()					
				,	"deptName"	:$("#deptName").val()
				,	"city"		:$("#city").val()
				,	"stateCD"	:$("#stateCD").val()					
				,	"statusCD"	:$("#statusCD").val()
				,	"sortKind"	:$("#sortKind").val()
				,	"sort"		:$("#sort").val()
				};
			var setUrl = "/ja/centers/searchResultJson";

			$.ajax({
				type:"GET",				
				url:setUrl,
				data: paramData,				
				cache: false,
				async: true,				
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var pageInfo = jsonData.pageInfo;
					var totalRowCnt = pageInfo.totalRowCnt;
					var pageNum = pageInfo.pageNum;
					var pageSize = pageInfo.rowBlockSize;
 
					if (totalRowCnt > pageSize){ // 2페이지 이상인경우만 보여주자	
						$("#pageNavi").html($.pageUtil(pageInfo.pageNum,pageInfo.totalPageCnt,pageInfo.pageBlockSize,pageInfo.startPageNum,pageInfo.endPageNum));
					}
					var source = $("#mainContentTemplate").html();
					var template = Handlebars.compile(source);
					// 번호
					Handlebars.registerHelper("inc", function(value, options){
						var num = (pageNum - 1) * pageSize + parseInt(value) + 1; // 정렬 : ASC
						//var num = totalRowCnt - ((pageNum - 1) * pageSize) - parseInt(value); // 정렬 : DESC
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
		// 센터 상담창 오픈
		openCenterCallLog:function(deptCD){
			alert("센터 상담창 오픈");
		},
		// 센터뷰
		goCenterView:function(deptCD){
			alert("센터뷰로 go~~");
		},
		// 자동로그인
		login:function(userId){
			location.href = "/ja/centers/login?memberId="+userId;
		}		
			
	});
	

	// 검색 초기화
	$("#searchInit").on("click", function() {
		$('#deptName').val("");
		$('#city').val("");				
		$('#stateCD').val("");
		$('#statusCD').getSetSSValue("1");		
		location.href = "/ja/centers/search";
	});
	
	// 검색 클릭	
	$("#searchSubmit").on("click", function() {
		if ($('#deptName').val()!="" && $.searchValueCheck("deptName") == false) return;		
		if ($('#city').val()!="" && $.searchValueCheck("city") == false) return;
		$('#searchForm').submit();
	});
	
	if(window.location.pathname == '/ja/centers/searchResults'){
		$.getCenterSearchResult();
	}
	// 정렬 클릭
	$("a[href=#btnSort]").on('click',function(){
		var sortKind = $(this).attr('sortKind');
		var sort = $("#sort").val();

		if(sort=='ASC'){
			sort = 'DESC';
		}else{
			sort = 'ASC';
		}
			
		$("#sortKind").val(sortKind);
		$("#sort").val(sort);
					
		$.getCenterSearchResult();
	});	
	
	// 페이징
	$(".paging").on("click","a.naviPage",function() {
		var pageNum = $(this).attr('pageNo');	
		$('#pageNum').val(pageNum);
		$.getCenterSearchResult();
	});	
});
