$(function(){	
	$.extend({
		// 리스트
		getExchangeRateResult:function(){
			var paramData = {"selYY":$("#selYY").val()};
			var setUrl = "/ja/accounting/exchangeRateJson";
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
					if($("#selYY > option:selected").val()==$.toDay().substr(0,4)){
						$("#exchangeRateRegist").show();	
					}else{
						$("#exchangeRateRegist").hide();
					}
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(_THROWNERROR);
				}
			});
		}
	});

	
	//환율 정보 저장
	$("#saveExchangeRate").on("click", function() {
		if(!($.required("cny","CNY"))){return;}
		if(!($.required("sgd","SGD"))){return;}
		if(!($.numericDecimal("cny","CNY"))){return;}
		if(!($.numericDecimal("sgd","SGD"))){return;}
		
		if(confirm("정보를 저장 하시겠습니까?")) {
			var param = $("#exchangeRateForm").serialize();
			$.ajax({
				url:"/ja/accounting/exchangeRateSaveJson",
				type:"POST",
				cache: false,
				async: true,
				data: param,
				dataType: "text",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					alert(jsonData);
					location.reload();
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(_THROWNERROR);
				}
			});
		}		
		
	});	
	
	// royaltyOverView 검색 클릭	
	$("#searchSubmit").on("click", function() {
		$.getExchangeRateResult();
	});
	
	if(window.location.pathname == '/ja/accounting/exchangeRate'){
		$.getExchangeRateResult();
	}
});
