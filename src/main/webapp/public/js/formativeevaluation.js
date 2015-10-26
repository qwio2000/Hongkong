$(function(){
	$.extend({
		getSDInput:function(){   //형성평가 입력 save
			$("[id^=setsubq]").each(function (i, v) {	
				$("#odabs").css("display","");
				$("#odabs").append($(this).val(),"##")
			});
		},
		getSDGichoSave:function(){   //형성평가 저장
			$("[id^=setsubq]").each(function (i, v) {	
				$("#odabs").css("display","");
				$("#odabs").append($(this).val(),"##")
			});
		}
	});
	
});