$(function(){
	$.extend({
		getShipInventorySave:function(){   // Ship 재고 수량 저장
			var cnt = "";
			var wbgrade = "";
			var caskey = "";
			var autoqty = "";
			var allset = "";
			var jisaCD = $("#jisaCD").val();
			var deptCD = $("#deptCD").val();
			var subj = $("#subj").val();
			
			$("#allset").html("");
			
			$("[id^=input_]").each(function (i, v) {
				cnt = $("#"+$(this).attr("id")).val();
				wbgrade =$(this).attr("wbgrade");
				caskey = $(this).attr("caskey");
				autoqty = $(this).attr("autoqty");
				if(cnt != ""){
					$("#allset").append(cnt+","+wbgrade+","+caskey+","+autoqty+"@@");
				}
			});
			
			allset = $("#allset").html();
			
			$(".btnArea").css("display","none");
			
			$.getInventorySave(jisaCD, deptCD, subj, allset, '', '12');
		},
		
		getAdjustInventorySave:function(){   // Adjust 재고 수량 저장
			var cnt = "";
			var wbgrade = "";
			var caskey = "";
			var autoqty = ""; //전산자동계산
			var stocqty = ""; //현재고
			var allset = "";
			var jisaCD = $("#jisaCD").val();
			var deptCD = $("#deptCD").val();
			var subj = $("#subj").val();
			
			$("#allset").html("");
			
			$("[id^=input_]").each(function (i, v) {
				cnt = $("#"+$(this).attr("id")).val();
				wbgrade =$(this).attr("wbgrade");
				caskey = $(this).attr("caskey");
				autoqty = $(this).attr("autoqty");
				stocqty = $(this).attr("stocqty");
				cnt = cnt - stocqty
				if(cnt != "0"){
					$("#allset").append(cnt+","+wbgrade+","+caskey+","+autoqty+"@@");
				}
			});
			
			allset = $("#allset").html();
			
			$(".btnArea").css("display","none");
			
			$.getInventorySave(jisaCD, deptCD, subj, allset, '', '11');
		},
		
		getRequestAWSave:function(){  // 가맹점 긴급교재 신청 
			var cnt = "";
			var wbgrade = "";
			var caskey = "";
			var jisaCD = $("#jisaCD").val();
			var deptCD = $("#deptCD").val();
			var subj = $("#subj").val();
			var inOutReqNote = $("#inOutReqNote").val();
			
			if(inOutReqNote == "" || inOutReqNote.length > 200){
				$.inputValueCheck("inOutReqNote","Reson", 200);
				return ;
			}
			
			$("#allset").html("");
			
			$("[id^=input_]").each(function (i, v) {
				cnt = $("#"+$(this).attr("id")).val();
				wbgrade =$(this).attr("wbgrade");
				caskey = $(this).attr("caskey");
		
				if(cnt != ""){
					$("#allset").append(cnt+","+wbgrade+","+caskey+","+cnt+"@@");
				}
			});
			
			allset = $("#allset").html();
			
			$(".btnArea").css("display","none");
			
			$.getInventorySave(jisaCD, deptCD, subj, allset, inOutReqNote, '13');
		},		
		
		getInventorySave:function(jisaCD, deptCD, subj, allset, inOutReqNote, reqCD){
			var searchUrl = "/ja/inventory/workbookstatusShipInventorySave";
			var paramData = {"jisaCD":jisaCD, "deptCD":deptCD, "subj":subj, "allset":allset, "inOutReqNote":inOutReqNote, "reqCD":reqCD};		
		
			 $.ajax({
				url:searchUrl,
				type:"POST",
				cache: false,
				data: paramData,
				dataType: "JSON",			
				success: function(jsonData, textStatus, XMLHttpRequest) {
					alert(jsonData.saveOK);
					$.getReload();
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		},
		
		getSetrestockqtySave:function(){   // 적정재고 수정 저장
			$("#btnArea").css("display","none");
			var cnt = "";
			var wbgrade = "";
			var caskey = "";
			var data = "";
			var jisaCD = $("#jisaCD").val();
			var deptCD = $("#deptCD").val();
			var subj = $("#subj").val();
			var shipevery = $("#shipevery").val();
			
			$("#allset").html("");
			
			$("[id^=input_]").each(function (i, v) {
				cnt = parseInt($("#"+$(this).attr("id")).val());
				wbgrade =$(this).attr("wbgrade");
				caskey = $(this).attr("caskey");
				$("#allset").append(cnt+","+wbgrade+","+caskey+"@");
			});
			
			data = $("#allset").html();
			
			var searchUrl = "/ja/inventory/workbookstatusSetrestockqtySave";
			var paramData = {"jisaCD":jisaCD, "deptCD":deptCD, "subj":subj, "shipevery":shipevery, "allset": data};


			$.ajax({
				url:searchUrl,
				type:"POST",
				cache: false,
				data: paramData,
				dataType: "JSON",			
				success: function(jsonData, textStatus, XMLHttpRequest) {
					alert(jsonData.saveOK);
					$.getReload();
				},
				error:function (request,status,error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					
				}
			});
			
		},
		
		getPrint:function(){ 
			var jisaCD = $("#jisaCD").val();
			var deptCD = $("#deptCD").val();			
			var gubun = $("#gubun").val();
			var pgubun = $("#pgubun").val();
			var subj = "";
			
			$("[id^=subjlist_]").each(function (i, v) {
				subj = $(this).val();
				
				var searchUrl = "/ja/inventory/workbookstatusSubj";
				var paramData = "jisaCD="+jisaCD+"&deptCD="+deptCD+"&subj="+subj+"&gubun="+gubun+"&pgubun="+pgubun;
				//console.log(paramData)
				$.ajax({
					type: "GET"
					,url: searchUrl
					,data: paramData					
					,success: function(data){	
						$("#printlist").append(data)
					}
					,error: function (data, textStatus) { 
						alert(textStatus); 			
					}
					,async: false
				});
				
			});
			
		},
		
		getGoPrint:function(){ 
			$("#printlist").printThis({
			    debug: false,             // show the iframe for debugging
			    importCSS: false,          // import page CSS
			    printContainer: true,     // grab outer container as well as the contents of the selector
			    loadCSS: "/public/css/common.css", // path to additional css file
			    pageTitle: "",             // add title to print page
			    removeInline: false        // remove all inline styles from print elements
			});
		}, 
		
		getInOutallPrint:function(){ 
			var jisaCD = $("#jisaCD").val();
			var deptCD = $("#deptCD").val();	
			var lastship = $("#lastship").val();
			var pgubun = $("#pgubun").val();
			var subj = "";
			
			$("[id^=subjlist_]").each(function (i, v) {
				subj = $(this).val();
		
				var searchUrl = "/ja/inventory/IvnWorkBookInOutPrintSubj";
				var paramData = "jisaCD="+jisaCD+"&deptCD="+deptCD+"&subj="+subj+"&lastship="+lastship+"&pgubun="+pgubun;
				//console.log(paramData)
				$.ajax({
					type: "GET"
					,url: searchUrl
					,data: paramData					
					,success: function(data){	
						$("#printlist").append(data)
					}
					,error: function (data, textStatus) { 
						alert(textStatus); 			
					}
					,async: false
				});
				
			});
		},
		
		getShipTCUpt:function(gubun){  //지사 긴급교재 삭제
			var myArray = $("#subjShip").val().split(',');				
		    var jisaCD = myArray[0];
		    var deptCD = myArray[1];
		    var additionalworkbook = myArray[2];	
		    var inOutSignYMD = $("#inOutSignYMD").val();
		    
		
			if(gubun == "D"){
				if (confirm("정말 삭제하시겠습니까?") == true){    //확인
					 $(".btnArea").hide();
					$.getShipTCDtlUpt(jisaCD,deptCD,additionalworkbook,inOutSignYMD,gubun);
				}else{   //취소
				    return;
				}
			}else{
				if(inOutSignYMD == ""){
					alert("Ship Date 입력바랍니다. ");
					return;
				}else{
					 $(".btnArea").hide();
					$.getShipTCDtlUpt(jisaCD,deptCD,additionalworkbook,inOutSignYMD,gubun);
				}
			}
			

			
		},
		
		getShipTCDtlUpt:function(jisaCD,deptCD,additionalworkbook,inOutSignYMD,gubun){  //지사 긴급교재 dtl 삭제		    
		    var data = "";
		    var cnt = "";
		    var aidx = "";
		    var fidx = "";
		    
		    $("#allset").html("");
		    
			$("[id^=ShipQty_]").each(function (i, v) {
				cnt = $("#"+$(this).attr("id")).val();
				aidx =$(this).attr("aidx");
				fidx = $(this).attr("fidx");
				
				$("#allset").append(cnt+","+aidx+","+fidx+"@@");
				
			});
			
			data = $("#allset").html();

			 $(".btnArea").hide();
			
			var searchUrl = "/ja/inventory/requestAWShipToCerritosUpt";						
			var paramData = "jisaCD="+jisaCD+"&deptCD="+deptCD+"&additionalworkbook="+additionalworkbook+"&data="+data+"&inOutSignYMD="+inOutSignYMD+"&gubun="+gubun;
	
			$.ajax({
				type: "POST"
				,url: searchUrl
				,data: paramData					
				,success: function(data){	
					alert(data.saveOK);
					document.location.href = "/ja/inventory/workbookstatus";
				}
				,error: function (data, textStatus) { 
					alert(textStatus); 			
				}
				
			});
		},
		
		getEditmodify:function(id,gubun){
			var OrderQtysum = 0;
			var ShipQtysum = 0;
			
			if(gubun == "modify"){
				$("#modify_"+id).css("display","none");
				$("#edit_"+id).css("display","");
				$("#OrderQty_"+id).attr("readonly",false);//제거 input 요소를 readonly 속성
				$("#OrderQty_"+id).focus();
			}else if(gubun == "edit"){
				$("#modify_"+id).css("display","");
				$("#edit_"+id).css("display","none");
				$("#OrderQty_"+id).attr("readonly",true);
				if($("#OrderQty_"+id).val() == ""){
					$("#OrderQty_"+id).val(0);
				}
				$("#ShipQty_"+id).val(parseInt($("#OrderQty_"+id).val()) );
				
				$("[id^=OrderQty_]").each(function (i, v) {
						OrderQtysum = parseInt(OrderQtysum) + parseInt($(this).val());
			    });
				$("[id^=ShipQty_]").each(function (i, v) {
						ShipQtysum = parseInt(ShipQtysum) + parseInt($(this).val());
			    });
				
				$("#OrderQtysum").text(OrderQtysum);
				$("#ShipQtysum").text(ShipQtysum);
				
			}
		},
		
		getBtnCalendar:function(){
	
			$("#hiddenPicker").datepicker("setDate", new Date());
	
			$("#hiddenPicker").datepicker("show");
		},
		

		getNextPrint:function(jisaCD,deptCD,subj,gubun,pgubun){ 
			location.href="/ja/inventory/workbookstatusPrint?jisaCD="+jisaCD+"&deptCD="+deptCD+"&subj="+subj+"&gubun="+gubun+"&pgubun="+pgubun+" "	
		},
		
		getInOutPrint:function(jisaCD,deptCD,lastship,pgubun){ 
			location.href="/ja/inventory/IvnWorkBookInOutPrint?jisaCD="+jisaCD+"&deptCD="+deptCD+"&lastship="+lastship+"&pgubun="+pgubun+" "	
		},
		
		getAdditionalworkbook:function(jisaCD,deptCD,additionalworkbook){ 
			location.href="/ja/inventory/requestAWShipToCerritos?jisaCD="+jisaCD+"&deptCD="+deptCD+"&additionalworkbook="+additionalworkbook+" "	
		},
		
		getReload:function(){  //페이지 새로고침
			location.reload();
		}
	});
	

	$("[id^=subjgo]").change(function() {
		var myArray = $(this).val().split(',');	    
	    var jisaCD = myArray[0];
	    var deptCD = myArray[1];
	    var subj = myArray[2];
	    var gubun = myArray[3];
    	document.location.href = "/ja/inventory/workbookstatusSubj?jisaCD="+jisaCD+"&deptCD="+deptCD+"&subj="+subj+"&gubun="+gubun+" ";
	});
	
	
	$("#subjRAW").change(function() {
		var myArray = $(this).val().split(',');	    
	    var jisaCD = myArray[0];
	    var deptCD = myArray[1];
	    var subj = myArray[2];	   
    	document.location.href = "/fa/inventory/requestAdditionalWorkbook?subj="+subj+" ";	  
	});
	
	$("#subjShip").change(function() {
		var myArray = $(this).val().split(',');	    
	    var jisaCD = myArray[0];
	    var deptCD = myArray[1];
	    var additionalworkbook = myArray[2];	   
    	document.location.href = "/ja/inventory/requestAWShipToCerritos?jisaCD="+jisaCD+"&deptCD="+deptCD+"&additionalworkbook="+additionalworkbook+" ";  
	});
	
	$("#yyRestock").change(function() { 	// 가맹점 history
		document.location.href = "/fa/inventory/workbookShippingHistory?yy="+$("#yyRestock").val()+" ";
	});
	
	$("#yyjaRestock").change(function() {   // 지사 history
		document.location.href = "/ja/inventory/shippingHistory?yy="+$("#yyRestock").val()+" ";
	});
	
	
	$("[id^=select_]").change(function (i, v) {	
		var myArray = $(this).val().split(',');	   
		var dung = myArray[0];
	    var cnt = myArray[1];

	    $("[id^=input_"+dung+"]").each(function (i, v) {
	    	$(this).val(cnt);
	    });
	    
	});
	
	
	// 상품별 print
	if(window.location.pathname == '/ja/inventory/workbookstatusPrint'){
		$.getPrint();
	}
	
	// 최근 발송한 교재의 발송일 및 상품 세트별 세부 수량 조회 리스트 print
	if(window.location.pathname == '/ja/inventory/IvnWorkBookInOutPrint'){
		$.getInOutallPrint();
	}
	
	
	$("[id^=OrderQty_]").keyup(function(event){		
        $(this).val( $(this).val().replace(/[^0-9]/gi,"") );
    });
	
	$("[id^=input_]").keyup(function(event){
			$(this).val( $(this).val().replace(/[^0-9]/gi,"") );
    });
	
	
	$("#hiddenPicker").datepicker({
		changeMonth: true,
		changeYear: true,
		yearRange: '1950:2015',
		dateFormat: 'mm/dd/yy',
		onSelect: function(dataText, inst){
			var today = new Date();
			var dataSplit = dataText.split("/");
			var yy = dataSplit[2];
			var mm = dataSplit[0];
			var dd = dataSplit[1];
			var dob = new Date(yy, mm-1, dd);
	
			if(today > dob){
				alert('당일 이후부터 선택이 가능합니다.');
				return;
			}
			$("#searchInput").val(dd+"/"+mm+"/"+yy)
			$("#inOutSignYMD").val(yy+"-"+mm+"-"+dd)
		}
	});
	
});
