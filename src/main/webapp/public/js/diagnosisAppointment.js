$(function(){	
	$("#name").focus(function(){
		$("#comment").show();
	});
	$("#name").on("keyup", function(){
		var name = $.trim($("#name").val());
		if(name.length >= 3){
			var url = "/fa/diagnosis/a";
			$.ajax({
				url: url,
				type:"GET",
				cache: false,
				data: {"name":name},
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		}else{
			$("#mainContent").empty();
		}
	});
	
});