$(function(){
	$.extend({
		getSetrestockqtySave:function(){   // 적정재고 수정 저장
			var cnt = "";
			var wbgrade = "";
			var caskey = "";
			var data = "";
			var jisaCD = $("#jisaCD").val();
			var deptCD = $("#deptCD").val();
			var subj = $("#subj").val();
			
			$("#allset").html("");
			
			$("[id^=input_]").each(function (i, v) {
				cnt = $("#"+$(this).attr("id")).val();
				wbgrade =$(this).attr("wbgrade");
				caskey = $(this).attr("caskey");
				$("#allset").append(cnt+","+wbgrade+","+caskey+"@@");
			});
			
			data = $("#allset").html();
			
			$(".btnArea").css("display","none");
			var searchUrl = "/ja/inventory/workbookstatusSetrestockqtyJson";
			var paramData = {"jisaCD":jisaCD, "deptCD":deptCD, "subj":subj, "data":data};		
			//console.log(data)
			 $.ajax({
				url:searchUrl,
				type:"GET",
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
});
