$(function(){	
	$.extend({
		// 리스트
		getRoyaltyOverviewResult:function(){
			var paramData = {"selYY":$("#selYY").val(),	"selMM":$("#selMM").val()};
			var setUrl = "/ja/accounting/royaltyOverviewJson";
			$.ajax({
				type:"GET",				
				url:setUrl,
				data: paramData,				
				cache: false,
				async: true,				
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var source = $("#mainContentTemplate").html();
					var template = Handlebars.compile(source);				
					$("#mainContent").empty();
					$("#mainContent").append(template(jsonData));
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(_THROWNERROR);
				}
			});
		},	
		getChargeDetailOfRoyaltyReport:function(deptCD,selYY,selMM,chargeCD){
			var paramData = {"deptCD":deptCD, "selYY":selYY, "selMM":selMM, "chargeCD":chargeCD};
			var setUrl = "/ja/accounting/chargeDetailOfRoyaltyReportJson";
			$.ajax({
				type:"GET",				
				url:setUrl,
				data: paramData,				
				cache: false,
				async: true,				
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var source = $("#chargeDetailContentTemplate").html();
					var template = Handlebars.compile(source);				
					$("#chargeDetailContent").empty();
					$("#chargeDetailContent").append(template(jsonData));

					if(jsonData.totalCnt == 0){
						$('.report_detail').hide();
						e.preventDefault();
					}
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(_THROWNERROR);
				}
			});
		},
		// 로열티 상세 팝업에서 판촉물 상세 레이어
		getPromoItemOrderDtlOfRoyaltyView:function(aidx){
			var paramData = {"aidx":aidx};
			if(window.location.pathname.indexOf('/fa/accounting/')<0){
				var setUrl = "/ja/accounting/promoitemOrderDtlJson";
			}else{
				var setUrl = "/fa/accounting/promoitemOrderDtlJson";
			}					
			$.ajax({
				type:"GET",				
				url:setUrl,
				data: paramData,				
				cache: false,
				async: true,				
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var source = $("#promoOrderDetailContentTemplate").html();
					var template = Handlebars.compile(source);				
					$("#promoOrderDetailContent").empty();
					$("#promoOrderDetailContent").append(template(jsonData));					
					$('.btn_view_list').each(function(){
						$(this).mouseenter(function(e){
							var top = $(this).position().top+$(this).height(); //top 위치
							var left = $(this).position().left; //left위치
							$.scheduleBox($('.layer_pop_list'), top, left);
							e.preventDefault();
						});
						$(this).mouseleave(function(e){
							$('.layer_pop_list').hide();
							e.preventDefault();
						});
					});		
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(_THROWNERROR);
				}
			});
		},			
		getRoyaltyReportResult:function(){
			var paramData = {"selYY":$("#selYY").val(),	"selMM":$("#selMM").val()};
			var setUrl = "/ja/accounting/royaltyReportJson";
			$.ajax({
				type:"GET",				
				url:setUrl,
				data: paramData,				
				cache: false,
				async: true,				
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var source = $("#mainContentTemplate").html();
					var template = Handlebars.compile(source);				
					$("#mainContent").empty();
					$("#mainContent").append(template(jsonData));
					
					//Royalty Report : btn_schedule 클래스 클릭시 스케줄 박스 오픈					
					$('.btn_report').each(function(){
						$(this).mouseenter(function(e){
							var top = $(this).position().top+$(this).height(); //top 위치
							var left = $(this).position().left; //left위치
							$('.btn_report').removeClass('on');
							$(this).addClass('on');
							$.scheduleBox($('.report_detail'), top, left);
							e.preventDefault();
						});
						$(this).mouseleave(function(e){
							$('.report_detail').hide();
							e.preventDefault();
						});
					});						
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(_THROWNERROR);
				}
			});
		}, 
		getRoyaltyReportOfCenterResult:function(){
			var paramData = {"selYY":$("#selYY").val()};
			var setUrl = "/fa/accounting/royaltyReportJson";
			$.ajax({
				type:"GET",				
				url:setUrl,
				data: paramData,				
				cache: false,
				async: true,				
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					var source = $("#mainContentTemplate").html();
					var template = Handlebars.compile(source);				
					$("#mainContent").empty();
					$("#mainContent").append(template(jsonData));
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(_THROWNERROR);
				}
			});
		},		
		openRoyaltyReport:function(deptCD,selYY,selMM){
			var url = "/ja/accounting/royaltyReportPop?deptCD="+deptCD+"&selYY="+selYY+"&selMM="+selMM;
			$.openPop(url, "royaltyReportPop","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=1000,height=700");			
		},
		openRoyaltyView:function(deptCD,selYY,selMM){ 
			if(window.location.pathname.indexOf('/fa/accounting/')<0){
				var url = "/ja/accounting/royaltyViewPop?deptCD="+deptCD+"&selYY="+selYY+"&selMM="+selMM;
			}else{
				var url = "/fa/accounting/royaltyViewPop?deptCD="+deptCD+"&selYY="+selYY+"&selMM="+selMM;
			}			
			$.openPop(url, "royaltyViewPop","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=1000,height=700");			
		},
		scheduleBox:function(el, top, left){
			//박스크기가 범위를 벗어날때 위치조정
			if(el.width()+left < el.parent().width()){
				el.css({display:'block',top:top, left:left});
			}else{
				el.css({display:'block',top:top, right:0, left:'inherit'});
			}
			//박스닫기
			el.find('.btn_close').click(function(e){
				el.hide();
				e.preventDefault();
			});
		},
		// 엑셀 다운로드
		royaltyReportExcel:function(el, top, left){
			var selYY = $("#selYY").val();
			var selMM = $("#selMM").val();
			var form = "<form action='/ja/accounting/royaltyReport/excel' method='post'>"; 
			form += "<input type='hidden' name='selYY' value='"+selYY+"' />"; 
			form += "<input type='hidden' name='selMM' value='"+selMM+"' />";
			form += "</form>"; 
			jQuery(form).appendTo("body").submit().remove(); 
		}	
	
	});
	

	// 검색 초기화
	$("#searchInit").on("click", function() {
		$('#selYY').getSetSSValue($.toDay().split("-")[0]);		
		$('#selMM').getSetSSValue($.toDay().split("-")[1]);
		location.href = "/ja/accounting/royaltyOverview";
	});
	
	// royaltyOverView 검색 클릭	
	$("#searchSubmit").on("click", function() {
		$.getRoyaltyOverviewResult();
	});
	
	if(window.location.pathname == '/ja/accounting/royaltyOverview'){
		$.getRoyaltyOverviewResult();
	}
	// royaltyReport 검색 초기화	
	$("#royaltyReportSearchInit").on("click", function() {
		$('#selYY').getSetSSValue($.toDay().split("-")[0]);		
		$('#selMM').getSetSSValue($.toDay().split("-")[1]);
		location.href = "/ja/accounting/royaltyReport";
	});
	// royaltyReport 검색 클릭	
	$("#royaltyReportSearchSubmit").on("click", function() {
		$.getRoyaltyReportResult();
	});	
	if(window.location.pathname == '/ja/accounting/royaltyReport'){
		$.getRoyaltyReportResult();
	}	
	// 가맹점 : royaltyReport 검색 클릭	
	$("#royaltyReportOfCenterSearchSubmit").on("click", function() {
		$.getRoyaltyReportOfCenterResult();
	});	
	if(window.location.pathname == '/fa/accounting/royaltyReport'){
		$.getRoyaltyReportOfCenterResult();
	}		
	
	// 특정가맹점의 년도별 로열티 팝업 레포트 검색
	$("#royaltyReportPopSearchSubmit").on("click", function() {
		location.href = "/ja/accounting/royaltyReportPop?deptCD="+$("#deptCD").val() + "&selYY="+$("#selYY > option:selected").val();
	});	
	
	
});
