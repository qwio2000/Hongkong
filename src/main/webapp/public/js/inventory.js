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
			
			$.getInventorySave(jisaCD, deptCD, subj, allset, '12');
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
			
			$.getInventorySave(jisaCD, deptCD, subj, allset, '11');
		},
		
		getInventorySave:function(jisaCD, deptCD, subj, allset, reqCD){
			var searchUrl = "/ja/inventory/workbookstatusShipInventorySave";
			var paramData = {"jisaCD":jisaCD, "deptCD":deptCD, "subj":subj, "allset":allset, "reqCD":reqCD};		
			//console.log(paramData)
			 $.ajax({
				url:searchUrl,
				type:"POST",
				cache: false,
				data: paramData,
				dataType: "JSON",			
				success: function(jsonData, textStatus, XMLHttpRequest) {
					alert(jsonData.saveOK);
					//$.getReload();
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
			
			$("#allset").html("");
			
			$("[id^=input_]").each(function (i, v) {
				cnt = parseInt($("#"+$(this).attr("id")).val());
				wbgrade =$(this).attr("wbgrade");
				caskey = $(this).attr("caskey");
				$("#allset").append(cnt+","+wbgrade+","+caskey+"@");
			});
			
			data = $("#allset").html();
			alert(data.length)
			
			var searchUrl = "/ja/inventory/workbookstatusSetrestockqtySave";
			var paramData = {"jisaCD":jisaCD, "deptCD":deptCD, "subj":subj, "allset": data};


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
			var subj = "";
			
			$("[id^=subjlist_]").each(function (i, v) {
				subj = $(this).val();
				
				var searchUrl = "/ja/inventory/workbookstatusSubj";
				var paramData = "jisaCD="+jisaCD+"&deptCD="+deptCD+"&subj="+subj+"&gubun="+gubun;
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
		
		getReload:function(){  //페이지 새로고침
			location.reload();
		}
	});
	
	
	$("#subjgo").change(function() {
		var myArray = $("#subjgo").val().split(',');	    
	    var jisaCD = myArray[0];
	    var deptCD = myArray[1];
	    var subj = myArray[2];
	    var gubun = myArray[3];
    	document.location.href = "/ja/inventory/workbookstatusSubj?jisaCD="+jisaCD+"&deptCD="+deptCD+"&subj="+subj+"&gubun="+gubun+" ";
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
});
