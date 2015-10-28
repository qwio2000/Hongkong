$(function(){
	$.extend({
		getSDInput:function(){   //형성평가 입력 save
			$(".btnArea").css("display","none")
			var data;
			var jisaCD = $.trim($("#jisaCD").val());
			var deptCD = $("#deptCD").val();
			var memKey = $.trim($("#memKey").val());
			var subj = $.trim($("#subj").val());
			var yy = $.trim($("#yy").val());  //DUNG
			var mm = $.trim($("#mm").val());  
			var wolhak = $.trim($("input[name=wolhak]:checked").val());
		
			$("[id^=setsubq]").each(function (i, v) {	
				$("#odabs").css("display","none");
				$("#odabs").append($(this).val(),"##")
			});
			
			data = $("#odabs").html();
			
			$.getSDGichoSave(jisaCD,deptCD,memKey,subj,yy,mm,wolhak,data);
			$("#odabs").html('');
		},
		getSDGichoSave:function(jisaCD,deptCD,memKey,subj,yy,mm,wolhak,data){   //형성평가 저장
			var searchUrl = "/fa/diagnosis/interimMpiJson";
			var paramData = {"jisaCD":jisaCD, "deptCD":deptCD, "memKey":memKey, "subj":subj, "yy":yy, "mm":mm, "wolhak":wolhak, "data":data};		
			//console.log(data)
			 $.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				data: paramData,
				dataType: "JSON",			
				success: function(jsonData, textStatus, XMLHttpRequest) {
					
					if (jsonData.saveOK != 'Y'){			
						alert(jsonData.alertErrorMsg);							
					}else{						
						alert(jsonData.alertsuccessMsg);						
					}	
					self.close();
				
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		}
	});
	
});