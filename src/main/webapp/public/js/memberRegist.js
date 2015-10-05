$(function(){	
	$("#name").focus(function(){
		$("#comment").show();
	});
	$("#name").on("keyup", function(){
		if($.trim($("#name").val()).length >= 3){
			$.ajax({
				url:"/fa/members/regist/"+$.trim($("#name").val()),
				type:"GET",
				cache: false,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					console.log(jsonData);
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		}
	});
});
