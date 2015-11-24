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

		getNextPrint:function(jisaCD,deptCD,subj,gubun,pgubun){ 
			location.href="/ja/inventory/workbookstatusPrint?jisaCD="+jisaCD+"&deptCD="+deptCD+"&subj="+subj+"&gubun="+gubun+"&pgubun="+pgubun+" "	
		},
		
		getInOutPrint:function(jisaCD,deptCD,lastship,pgubun){ 
			location.href="/ja/inventory/IvnWorkBookInOutPrint?jisaCD="+jisaCD+"&deptCD="+deptCD+"&lastship="+lastship+"&pgubun="+pgubun+" "	
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
	   
    	document.location.href = "/ja/inventory/requestAdditionalWorkbook?subj="+subj+" ";
	  
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
	
});
