$(function(){	
	$.extend({

		// charge report 리스트
		getChargeReportResult:function(){
			var paramData = {"selYY":$("#selYY").val(),	"selMM":$("#selMM").val()};
			var setUrl = "/ja/accounting/chargeReportJson";			
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
		openRecordChargesPop:function(deptCD,selYY,selMM){
			var url = "/ja/accounting/recordChargesPop?deptCD="+deptCD+"&selYY="+selYY+"&selMM="+selMM;
			$.openPop(url, "royaltyReportPop","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=1000,height=700");			
		},
		addCharge:function(){
			$("#addCharge").toggle();
		},
		deleteRecordCharge:function(idx){
			if(confirm("정보를 삭제 하시겠습니까?")) {
				var param = {"idx":idx};
				$.ajax({
					url:"/ja/accounting/recordCharges/delete",
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
 
	
	// charge Report 검색 클릭	
	$("#searchSubmit").on("click", function() {
		$.getChargeReportResult();
	});
	// 검색 초기화
	$("#searchInit").on("click", function() {
		$('#selYY').getSetSSValue($.toDay().split("-")[0]);		
		$('#selMM').getSetSSValue($.toDay().split("-")[1]);
		location.href = "/ja/accounting/chargeReport";
	});
	if(window.location.pathname == '/ja/accounting/chargeReport'){
		$.getChargeReportResult();
	}
	
	// 기타정산 검색
	$("#recordChargeSearchSubmit").on("click", function() {
		location.href = "/ja/accounting/recordChargesPop?deptCD="+$("#deptCD").val() + "&selYY="+$("#selYY > option:selected").val()+ "&selMM="+$("#selMM > option:selected").val();
	});	
	

	//기타정산 저장
	$("#saveRecordCharge").on("click", function() {
		if(!($.required("chargeMMDDYY","Date"))){return;}
		if(!($.required("chargeCD","Type"))){return;}
		if(!($.required("amount","Amount"))){return;}
		if(!($.numeric("amount","amount"))){return;}
		if(!($.required("memo","memo"))){return;}
		
		var chargeYMDSplit = $("#chargeMMDDYY").val().split("/");
		var chargeYMD = chargeYMDSplit[2] + "-" + chargeYMDSplit[0] + "-" +  chargeYMDSplit[1];
		if(chargeYMD.substr(0,7) != $.toDay().substr(0,7)){
			alert("금월로 입력해 주세요.");
			return;
		}		
		$("#chargeYMD").val(chargeYMD);
		

		if(confirm("정보를 저장 하시겠습니까?")) {
			var param = $("#recordChargeForm").serialize();
			$.ajax({
				url:"/ja/accounting/recordChargesPopSaveJson",
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
		
	});	
	
	$("#chargeMMDDYY").datepicker({
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
			var chargeDate = yy + "-" + mm + "-" +  dd;
			if(chargeDate.substr(0,7) != $.toDay().substr(0,7)){
				alert('금월로 입력하십시요.');
				$("#chargeMMDDYY").val('');	
				return;
			}
		}	
    });		
	$("#chargeDatePicker, #chargeMMDDYY").click(function(){
		$("#chargeMMDDYY").val(''); 		
		$("#chargeMMDDYY").datepicker("show");
	});		
	
	
	
});
