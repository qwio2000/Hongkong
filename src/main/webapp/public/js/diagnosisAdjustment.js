$(function(){
	$.extend({
		getOnchangebokwk:function(yy,mm,wk,set,jisaCD,subj,dung){   //진도조정 복습 셋트 선택
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
		getOnchangedangwk:function(yy,mm,wk,set,jisaCD,subj,dung){   //진도조정 당김
			$("#pYear").val(yy);
			$("#pMonth").val(mm);
			$("#pWeek").val(wk);
			$("#pSet").val(set);
			
		},
		getSetban:function(defaultset,choiceset){   //세트 반영			
			if (defaultset <= choiceset){				
				alert($("#alertMsg1").val()); //'해당주차의 세트와 같거나 큰 세트 입니다. 다시 선택하세요'
				return;
			}
			
			if($("input[name=bokGubun]:checked").val() == "B"){	
				if($("#setB1").val() != "" && $("#setB3").val() != ""){
					alert($("#alertMsg2").val()); //'모두 선택 하셨습니다.'
					return;
				}
				if($("#setB1").val() == ""){
					$("#setB1").val(choiceset);
					$("#set1").val(choiceset);
				}else if($("#setB3").val() == ""){
					$("#setB3").val(choiceset);
					$("#set3").val(choiceset);
				}
			}else if($("input[name=bokGubun]:checked").val() == "S"){
				if($("#setS1").val() != "" && $("#setS2").val() != "" && $("#setS3").val() != "" && $("#setS4").val() != "" && $("#setS5").val() != ""){
					alert($("#alertMsg2").val()); //'모두 선택 하셨습니다.'
					return;
				}
				
				if($("#setS1").val() == ""){
					$("#setS1").val(choiceset);
					$("#set1").val(choiceset);
				}else if($("#setS2").val() == ""){
					$("#setS2").val(choiceset);
					$("#set2").val(choiceset);
				}else if($("#setS3").val() == ""){
					$("#setS3").val(choiceset);
					$("#set3").val(choiceset);
				}else if($("#setS4").val() == ""){
					$("#setS4").val(choiceset);
					$("#set4").val(choiceset);
				}else if($("#setS5").val() == ""){
					$("#setS5").val(choiceset);
					$("#set5").val(choiceset);
				}
				
			}
		
			
		},
		getJindoSave:function(){   //진도 조정 저장
			$(".btnArea").css("display","none")
			var jindoGubun = $("#jindoGubun").val();
			var jisaCD = $("#jisaCD").val();
			var memKey = $("#memKey").val();
			var subj = $("#subj").val();
			var yy = $("#pYear").val();
			var mm = $("#pMonth").val();
			var wk = $("#pWeek").val();	
			var yoil = $("#yoil").val();
			var bokGubun = $("input[name=bokGubun]:checked").val(); 
			var set1 = $("#set1").val();
			var set2 = $("#set2").val();
			var set3 = $("#set3").val();
			var set4 = $("#set4").val();
			var set5 = $("#set5").val();	
			
			
			
			if(set1 == ""){
				alert($("#alertMsg3").val()); //세트를 선택해주세요
				$(".btnArea").css("display","")
				return;
			}
			var searchUrl = "/fa/diagnosis/adjustmentinputSaveJson";			
			var paramData = {"jindoGubun":jindoGubun, "jisaCD":jisaCD, "memKey":memKey, "subj":subj, "yy":yy, "mm":mm, "wk":wk, "yoil":yoil
					, "bokGubun":bokGubun, "set1":set1, "set2":set2, "set3":set3, "set4":set4, "set5":set5};		
			
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				data: paramData,
				dataType: "JSON",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					alert(jsonData.alertMsg);
					if(jsonData.chkMsg=="N"){
						$(".btnArea").css("display","")
					}else{
						self.close();
					}
					
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		
		},
		
		getRefreshSet:function(){   // 세트 선택값들 초기화
			$("#setB1").val("");
			$("#setB3").val("");
			$("#setS1").val("");
			$("#setS2").val("");
			$("#setS3").val("");
			$("#setS4").val("");
			$("#setS5").val("");
			
			$("#set1").val("");
			$("#set2").val("");
			$("#set3").val("");
			$("#set4").val("");
			$("#set5").val("");			
		},
		
		
		
		/* 관리자 작업 */ 
		getOnchangebokwkAdmin:function(yy,mm,wk,set,jisaCD,subj,dung){   //관리자 복습 선택
			$("#pYear").val(yy);
			$("#pMonth").val(mm);
			$("#pWeek").val(wk);
			$("#pSet").val(set);
			
			$.getRefreshSet();  // 선택세트 초기화
		},
		getOnchangedangwkAdmin:function(yy,mm,wk,set,jisaCD,subj,dung){   // 관리자 진도조정 당김, 삭제, 조정
			$("#pYear").val(yy);
			$("#pMonth").val(mm);
			$("#pWeek").val(wk);
			$("#pSet").val(set);
			
			
			
		},
		getSetbanAdmin:function(choiceset){   //관리자 복습 세트 반영	
			if($("#pYear").val() == "" && $("#pMonth").val() == "" && $("#pWeek").val() == "" && $("#pSet").val() == "" ){
				alert($("#alertMsg3").val()); //세트를 선택해주세요
				return;
			}
			
			
			if($("input[name=bokGubun]:checked").val() == "B"){	
				if($("#setB1").val() != "" && $("#setB3").val() != ""){
					alert($("#alertMsg2").val()); //'모두 선택 하셨습니다.'
					return;
				}
				if($("#setB1").val() == ""){
					$("#setB1").val(choiceset);
					$("#set1").val(choiceset);
				}else if($("#setB3").val() == ""){
					$("#setB3").val(choiceset);
					$("#set3").val(choiceset);
				}
			}else if($("input[name=bokGubun]:checked").val() == "S"){
				if($("#setS1").val() != "" && $("#setS2").val() != "" && $("#setS3").val() != "" && $("#setS4").val() != "" && $("#setS5").val() != ""){
					alert($("#alertMsg2").val()); //'모두 선택 하셨습니다.'
					return;
				}
				
				if($("#setS1").val() == ""){
					$("#setS1").val(choiceset);
					$("#set1").val(choiceset);
				}else if($("#setS2").val() == ""){
					$("#setS2").val(choiceset);
					$("#set2").val(choiceset);
				}else if($("#setS3").val() == ""){
					$("#setS3").val(choiceset);
					$("#set3").val(choiceset);
				}else if($("#setS4").val() == ""){
					$("#setS4").val(choiceset);
					$("#set4").val(choiceset);
				}else if($("#setS5").val() == ""){
					$("#setS5").val(choiceset);
					$("#set5").val(choiceset);
				}
				
			}
		
			
		},
		getSetbanDangAdmin:function(choiceset){   //관리자 조정 세트 변경
			var yy = $("#pYear").val();
			var mm = $("#pMonth").val();
			var wk = $("#pWeek").val();
			
			
			
			if(yy == "" && mm == "" && wk == "" && $("#pSet").val() == "" ){
				alert($("#alertMsg3").val()); //세트를 선택해주세요
				return;
			}			
			$("#dset"+yy+mm+wk).attr('disabled', true);
			$("#dset"+yy+mm+wk).val(choiceset);
			$("#choiceset"+yy+mm+wk).text(choiceset);
			
			
		},
		getSetDelAdmin:function(yy,mm,wk){   //관리자 조정 삭제		
			$("#dset"+yy+mm+wk).attr('disabled', false);
			$("#dset"+yy+mm+wk).val("");
			$("#choiceset"+yy+mm+wk).text("");
			$("#dset"+yy+mm+wk).attr('checked', true);
			
			
		},
		
		
		getMinSetAdmin:function(){   //체크 값중 최저 년 월 주차 확인
			var totcnt = $("input[id^=dset]").length
			
			$("input[id^=dset]").each(function (i, v) {
				if(i == 0){
					$("#minYear").val($(this).attr("yy"))
					$("#minMonth").val($(this).attr("mm"))
					$("#minWeek").val($(this).attr("wk"))
				}
				/*if(totcnt == (parseInt(i) + 1)){
					$("#maxYear").val($(this).attr("yy"))
					$("#maxMonth").val($(this).attr("mm"))
					$("#maxWeek").val($(this).attr("wk"))
				}*/
			});
		},
		
		getJindoSaveAdmin:function(){   //관리자 진도 조정 저장
			$(".btnArea").css("display","none")
			var jindoGubun = $("#jindoGubunAdmin").val();
			var jisaCD = $("#jisaCD").val();
			var memKey = $("#memKey").val();
			var subj = $("#subj").val();
			var yy = $("#pYear").val();
			var mm = $("#pMonth").val();
			var wk = $("#pWeek").val();	
			var yoil = $("#yoil").val();
			var bokGubun = $("input[name=bokGubun]:checked").val(); 
			var set1 = $("#set1").val();
			var set2 = $("#set2").val();
			var set3 = $("#set3").val();
			var set4 = $("#set4").val();
			var set5 = $("#set5").val();	
			var minyy = "";
			var minmm = ""; 
			var minwk = ""; 
			var allset = "";
			if(jindoGubun == "41"){  //관리자 진도 조정 복습 외 
				$.getMinSetAdmin();
				
				minyy = $("#minYear").val();
				minmm = $("#minMonth").val();
				minwk = $("#minWeek").val();	
			
				
				$("#allset").html("");
				$("input[id^=dset]").each(function (i, v) {
					$("#allset").append($(this).attr("yy")+","+$(this).attr("mm")+","+$(this).attr("wk")+","+$(this).val()+"@@");
					
				});
				
				allset = $("#allset").html();
				
			}
			
			var searchUrl = "/fa/diagnosis/adjustmentinputSaveAdminJson";			
			var paramData = {"jindoGubun":jindoGubun, "jisaCD":jisaCD, "memKey":memKey, "subj":subj, "yy":yy, "mm":mm, "wk":wk, "yoil":yoil
					, "bokGubun":bokGubun, "set1":set1, "set2":set2, "set3":set3, "set4":set4, "set5":set5, "minyy":minyy, "minmm":minmm, "minwk":minwk, "allset":allset };		
			
			if($("input[name=bokGubun]:checked").val() == "B"){	
				if ($("#setB1").val() >= $("#setB3").val()){				
					alert($("#alertMsg1").val()); //'해당주차의 세트와 같거나 큰 세트 입니다. 다시 선택하세요'
					
					$.getRefreshSet();  // 선택세트 초기화
					$(".btnArea").css("display","")
					return;
				}
			}
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				data: paramData,
				dataType: "JSON",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					alert(jsonData.alertMsg);
					if(jsonData.chkMsg=="N"){
						$(".btnArea").css("display","")
					}else{
						location.reload();
					}
					
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		
		}
	
	});	
	
	$("#jindoGubun").change(function() {
		document.location.href = "/fa/diagnosis/adjustmentinput?jisaCD="+$("#jisaCD").val()+"&memKey="+$("#memKey").val()+"&yoil="+$("#yoil").val()+"&subj="+$("#subj").val()+"&jindoGubun="+$("#jindoGubun").val()+"";
	});
	
	$("#jindoGubunAdmin").change(function() {
		document.location.href = "/fa/diagnosis/adjustmentinputAdmin?jisaCD="+$("#jisaCD").val()+"&memKey="+$("#memKey").val()+"&yoil="+$("#yoil").val()+"&subj="+$("#subj").val()+"&jindoGubun="+$("#jindoGubunAdmin").val()+"";
	});
});


