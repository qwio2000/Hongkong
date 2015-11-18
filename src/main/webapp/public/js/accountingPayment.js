$(function(){	
	$.extend({

		// payment report 리스트
		getPaymentReportResult:function(){
			var paramData = {"selYY":$("#selYY").val(),	"selMM":$("#selMM").val()};
			var setUrl = "/ja/accounting/paymentReportJson";			
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
		openRecordPaymentPop:function(deptCD,selYY,selMM){
			var url = "/ja/accounting/recordPaymentPop?deptCD="+deptCD+"&selYY="+selYY+"&selMM="+selMM;
			$.openPop(url, "recordPaymentPop","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=1000,height=700");			
		},
		addPayment:function(){
			$("#addPayment").toggle();
		},
		deleteRecordPayment:function(idx,deptCD){
			if(confirm("정보를 삭제 하시겠습니까?")) {
				var param = {"idx":idx,"deptCD":deptCD};
				$.ajax({
					url:"/ja/accounting/recordPayment/delete",
					type:"POST",
					cache: false,
					async: true,
					data: param,
					dataType: "text",
					success: function(jsonData, textStatus, XMLHttpRequest) {
						alert(jsonData);
						location.reload();
						opener.location.reload();
					},
					error:function (xhr, ajaxOptions, thrownError){	
						alert(_THROWNERROR);
					}
				});
			}					
		}
	});
 
	
	// payment Report 검색 클릭	
	$("#searchSubmit").on("click", function() {
		$.getPaymentReportResult();
	});
	// 검색 초기화
	$("#searchInit").on("click", function() {
		$('#selYY').getSetSSValue($.toDay().split("-")[0]);		
		$('#selMM').getSetSSValue($.toDay().split("-")[1]);
		location.href = "/ja/accounting/paymentReport";
	});
	if(window.location.pathname == '/ja/accounting/paymentReport'){
		$.getPaymentReportResult();
	}
	
	// 미수금 입금 검색
	$("#recordPaymentSearchSubmit").on("click", function() {
		location.href = "/ja/accounting/recordPaymentPop?deptCD="+$("#deptCD").val() + "&selYY="+$("#selYY > option:selected").val()+ "&selMM="+$("#selMM > option:selected").val();
	});	
	

	//미수금 저장
	$("#saveRecordPayment").on("click", function() {
		if(!($.required("payMMDDYY","Date"))){return;}
		if(!($.required("payCD","Type"))){return;}
		//if(!($.required("refNo","refNo"))){return;}
		if(!($.required("amount","amount"))){return;}
		if(!($.numeric("amount","Amount"))){return;}
		if(!($.required("memo","Memo"))){return;}
		
		var payYMDSplit = $("#payMMDDYY").val().split("/");
		var payYMD = payYMDSplit[2] + "-" + payYMDSplit[0] + "-" +  payYMDSplit[1];
		if(payYMD.substr(0,7) != $.toDay().substr(0,7)){
			alert("금월로 입력해 주세요.");
			return;
		}		
		$("#payYMD").val(payYMD);
		if(parseInt($("#amount").val(),10)<=0){
			alert("0이상으로 입력 해 주세요.");
			return;
		}
		if(parseInt($("#balance").val(),10) < parseInt($("#amount").val(),10)+ parseInt($("#currAmount").val(),10)){
			alert("미수금을 오버 하였습니다.");
			return;
		}
		
		if(confirm("정보를 저장 하시겠습니까?")) {
			var param = $("#recordPaymentForm").serialize();
			$.ajax({
				url:"/ja/accounting/recordPaymentPopSaveJson",
				type:"POST",
				cache: false,
				async: true,
				data: param,
				dataType: "text",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					alert(jsonData);
					//location.reload();
					location.href = "/ja/accounting/recordPaymentPop?deptCD="+$("#deptCD").val() + "&selYY="+$.toDay().substr(0,4)+ "&selMM="+$.toDay().substr(5,2);
					opener.location.reload();
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(_THROWNERROR);
				}
			});
		}		
		
	});	
	
	$("#payMMDDYY").datepicker({
		changeMonth: false,
		changeYear: false,
		showButtonPanel: true, 
		yearRange: 'c-0:c+0',
		dateFormat: 'mm/dd/yy',
		onSelect: function(dataText, inst){
			var dataSplit = dataText.split("/");
			var yy = dataSplit[2];
			var mm = dataSplit[0];
			var dd = dataSplit[1];
			var payDate = yy + "-" + mm + "-" +  dd;
			if(payDate.substr(0,7) != $.toDay().substr(0,7)){
				alert('금월로 입력하십시요.');
				$("#payMMDDYY").val('');	
				return;
			}
		}	
    });		
	$("#payDatePicker, #payMMDDYY").click(function(){
		$("#payMMDDYY").val(''); 		
		$("#payMMDDYY").datepicker("show");
	});		
	
	
	
});
