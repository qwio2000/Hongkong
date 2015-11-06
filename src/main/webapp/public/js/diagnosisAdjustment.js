$(function(){
	$.extend({
		getOnchangewk:function(yy,mm,wk,set,jisaCD,subj,dung){   //형성평가 입력 save
			$("#pYear").val(yy);
			$("#pMonth").val(mm);
			$("#pWeek").val(wk);
			$("#pSet").val(set);
			
			$.getRefreshSet();  // 선택세트 초기화
	
			var searchUrl = "/fa/diagnosis/adjustmentinputJson";
			var paramData = "jisaCD="+jisaCD+"&subj="+subj+"&dung="+dung+"&set="+set;
			
			$.ajax({
				type: "GET"
				,url: searchUrl
				,data: paramData					
				,success: function(data){	
					$("#listSet").html(data);					
				}
				,error: function (data, textStatus) { 
					alert(textStatus); 			
				}
				,async: false
			});	
		},
		getSetban:function(defaultset,choiceset){   //세트 반영			
			if (defaultset <= choiceset){				
				alert($("#alertMsg1").val()); //'해당주차의 세트와 같거나 큰 세트 입니다. 다시 선택하세요'
				return;
			}
			
			$("input[name=bokGubun]:checked").each(function (i, v) {
				if($(this).val() == "B"){	
					if($("#setB1").val() != "" && $("#setB2").val() != ""){
						alert($("#alertMsg2").val()); //'모두 선택 하셨습니다.'
						return;
					}
					if($("#setB1").val() == ""){
						$("#setB1").val(choiceset)
					}else if($("#setB2").val() == ""){
						$("#setB2").val(choiceset)
					}
				}else if($(this).val() == "S"){
					if($("#setS1").val() != "" && $("#setS2").val() != "" && $("#setS3").val() != "" && $("#setS4").val() != "" && $("#setS5").val() != ""){
						alert($("#alertMsg2").val()); //'모두 선택 하셨습니다.'
						return;
					}
					
					if($("#setS1").val() == ""){
						$("#setS1").val(choiceset)
					}else if($("#setS2").val() == ""){
						$("#setS2").val(choiceset)
					}else if($("#setS3").val() == ""){
						$("#setS3").val(choiceset)
					}else if($("#setS4").val() == ""){
						$("#setS4").val(choiceset)
					}else if($("#setS5").val() == ""){
						$("#setS5").val(choiceset)
					}
					
				}
			});
			
		},
		getRefreshSet:function(){   // 세트 선택값들 초기화
			$("#setB1").val("");
			$("#setB2").val("");
			$("#setS1").val("");
			$("#setS2").val("");
			$("#setS3").val("");
			$("#setS4").val("");
			$("#setS5").val("");
		}
		
		
	
	
	});
	
});