$(function(){
	$.extend({
		getBoardList:function(){   //처방 조회 리스트
			var pageNum = $("#pageNum").val();
			var searchUrl = "/fa/diagnosis/diagnosisSearch/searchJson";
		
			var pageNum = $("#pageNum").val();
			var pagecnt = $.trim($("#pagecnt").val());
			var jisaCD = $.trim($("#jisaCD").val());
			var deptCd = $.trim($("#deptCd").val());
			var status = $.trim($("#status").val());
			var lastName = $.trim($("#lastName").val());
			var firstName = $.trim($("#firstName").val());
			var homePhone = $.trim($("#homePhone").val());
			var cellPhone = $.trim($("#cellPhone").val());
			var email = $.trim($("#email").val());
			var grade = $.trim($("#grade").val());
			var subject = $.trim($("#subject").val());
		
			
			var paramData = {"pageNum":pageNum, "pagecnt":pagecnt, "jisaCD":jisaCD, "deptCd":deptCd, "status":status, "lastName":lastName
					, "firstName":firstName, "homePhone":homePhone, "cellPhone":cellPhone, "email":email, "grade":grade, "subject":subject};
			
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				data: paramData,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					//console.log(jsonData)
					var pageInfo = jsonData.pageUtil;
					var totalRowCnt = pageInfo.totalRowCnt;
					$("#totalCnt").html(totalRowCnt);
					$("#pageNavi").html($.pageUtil(pageInfo.pageNum,pageInfo.totalPageCnt, 
							pageInfo.pageBlockSize,pageInfo.startPageNum,pageInfo.endPageNum));	
					var source = $("#listTemplate").html();
					var template = Handlebars.compile(source);
					Handlebars.registerHelper("boardNo", function(index, options){
						return totalRowCnt - pageInfo.startRow - index;
					});
					$("#diagnosislist").empty();
					$("#diagnosislist").append(template(jsonData));
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		},
		
		getIpprinput:function(){   //처방 조회 리스트
			var jisaCD = $("#jisaCD").val();
			var leveldung = $("#leveldung").val();
			var subjname = $("#subjname").val();
			var testType = $.trim($("#testType").val());
			
			var paramData = "jisaCD="+jisaCD+"&leveldung="+leveldung+"&subjname="+subjname+"&testType="+testType;
			
			var searchUrl = "/fa/diagnosis/ipprinputJson";

			$.ajax({
				type: "post"
				,url: searchUrl
				,data: paramData					
				,success: function(data){	

					$("#diagnosislist").html(data);
				}
				,error: function (data, textStatus) { 
					alert(textStatus); 			
				}
				,async: false
			});
		},
		
		getInputChk:function(id,input,mun,chk){   //오답 체크 한글 제외
			// 오답 체크정보 임시 temp
			var temp = "<input type='text' id='"+mun+"' value='"+mun+"|"+chk+"' mun='"+mun+"' chk='"+chk+"' >"
			
			// 문항 체크박스 하나만 선택 
			$(".chk_s01 [id^="+id+"]").each(function (i, v) {	
				if ( $(this).val() == input){			
					$(this).attr("checked", true); 
					$("#inputAnswer #"+mun+" ").remove();
				}else{
					$(this).attr("checked", false);
					$("#inputAnswer #"+mun+" ").remove();
				}
			});
			
			// 오답 체크 정보 담기
			if($(".chk_s01 #chk"+mun+"_"+chk+"").is(":checked") == true ){
				$("#inputAnswer").append(temp)
			}
			
			$.getOrderByChk();
		},
		
		getInputChkG:function(id,mun,sset){   //한글 오답 체크			
			var Odablisttemp = "<li id="+id+''+mun+"><span class='q_num'>"+mun+"</span><span class='icon'></span><span class='loss_set'>"+sset+"</span></li>"
			var inputAnswertemp = "<input type='text' id='"+mun+"' value='"+mun+"' mun='"+mun+"' chk='' >"
			
			
			
			if($("#"+id).is(":checked") == true ){
				$("#Odablist").append(Odablisttemp)
				$("#inputAnswer").append(inputAnswertemp)
			}else{
				$("#"+id+''+mun+" ").remove();
				$("#inputAnswer #"+mun+" ").remove();
			}
			
			$.getOrderByChk();
		},
		getOrderByChk:function(){  //번호순서대로 정렬 start
			
			//번호순서대로 정렬 start
			var items = $('#inputAnswer input').get();			
			items.sort(function(a,b){
			  var keyA = Number($(a).attr('id'));
			  var keyB = Number($(b).attr('id'));
	
			  if (keyA < keyB) return -1;
			  if (keyA > keyB) return 1;
			  return 0;
			});				
			$.each(items, function(i, input){			
				$('#inputAnswer').append(input);
			});
			//번호순서대로 정렬 end

		},	
		
		getIpprSave:function(){  //omrGicho 저장
			var OmrDate = $("#omrdate").val();
			var Hkey = $.trim($("#Hkey").val());
			var Kwamok = $.trim($("#Kwamok").val());
			var Rw = $.trim($("#Rw").val());
			var NOmr = $.trim($("#NOmr").val());
			var MFstName = $.trim($("#MFstName").val());
			var MLstName =$.trim($("#MLstName").val());;
			var Skey = $.trim($("#Skey").val());
			var SName = $.trim($("#SName").val());
			var OmrGrd = $.trim($("#OmrGrd").val());
			var OmrHak = $.trim($("#OmrHak").val());
			var OmrBirth = $.trim($("#OmrBirth").val());
			var OmrKind = $.trim($("#OmrKind").val());
			var OmrDay1 = $.trim($("#OmrDay1").val());
			var OmrDay2 = $.trim($("#OmrDay2").val());
			var OmrStudyNum = $.trim($("#OmrStudyNum").val());
			var OmrBookNum = $.trim($("#OmrBookNum").val());
			var DeptCD = $.trim($("#deptCd").val());
			var JisaCD = $.trim($("#jisaCD").val());
			var DeptName = $.trim($("#DeptName").val());
			var WorkID = $.trim($("#WorkID").val());
			var freejindan = $.trim($("#freejindan").val());
			
			var searchUrl = "/fa/diagnosis/ipprInputSave";
			
			var paramData = {"omrDate":OmrDate, "hkey":Hkey, "kwamok":Kwamok, "rw":Rw, "nOmr":NOmr, "mFstName":MFstName, "mLstName":MLstName
					, "skey":Skey, "sName":SName, "omrGrd":OmrGrd, "omrHak":OmrHak, "omrBirth":OmrBirth, "OmrKind":OmrKind, "omrDay1":OmrDay1, "omrDay2":OmrDay2
					, "omrStudyNum":OmrStudyNum, "omrBookNum":OmrBookNum, "deptCD":DeptCD, "jisaCD":JisaCD, "deptName":DeptName, "workID":WorkID};
		
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				data: paramData,
				dataType: "JSON",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					if (jsonData.omrGichoisOK == 'Y'){
						$.getOmrOdab();
					}else{
						alert(jsonData.alertMsg);
					}
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
		},		
		
		getOmrOdab:function(){  //오답입력
	
			var JisaCD = $.trim($("#jisaCD").val());
			var OmrDate = $("#omrdate").val();
			var Hkey = $.trim($("#Hkey").val());
			var Kwamok = $.trim($("#Kwamok").val());
			var OmrGrd = $.trim($("#OmrGrd").val());  //DUNG
			var OmrKind = $.trim($("#OmrKind").val());  
						
			var ipuntOdab = $('#inputAnswer input');
			
			var munarrer = "";			
			
			$.getOrderByChk(); //번호순서대로 정렬
								
			ipuntOdab.each(function (a, v) {
				var munNo = "";  //문제 3자리로 변환
				var chkNo = "";
				var mun = $(this).attr('mun');
				var chk = $(this).attr('chk');		
				
				if (mun.length == "1" ){
					munNo = "00"+mun;	
				}else if (mun.length == "2" ){
					munNo = "0"+mun;
				}
				
				
				if (chk.length == "1" ){
					chkNo = "0"+chk;
				}
				munarrer += munNo+"|"+chkNo+"##"			
			});	
			
			
			var searchUrl = "/fa/diagnosis/ipprOdabSave";
			var paramData = {"jisaCD":JisaCD, "omrDate":OmrDate, "hkey":Hkey, "kwamok":Kwamok, "omrGrd":OmrGrd, "munchk":munarrer, "omrKind":OmrKind};		
			console.log(munarrer);
			 $.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				data: paramData,
				dataType: "JSON",			
				success: function(jsonData, textStatus, XMLHttpRequest) {
					
					if (jsonData.omrOmrOdabOK == 'N'){			
						$("#lastOK").val(jsonData.alertMsg)								
					}
					
					if($("#lastOK").val() == "Y" ){
						$.getOmrBan();				
					}else{
						alert($("#lastOK").val());
						return;
					}
				},
				error:function (xhr, ajaxOptions, thrownError){	
					alert(thrownError);
				}
			});
			
		},
		
		getOmrBan:function(){  //처방 분석
			var jisaCD = $("#jisaCD").val();
			var OmrDate = $("#omrdate").val();
			var Hkey = $.trim($("#Hkey").val());
			var Kwamok = $.trim($("#Kwamok").val());
			var Rw = $.trim($("#Rw").val());
			var NOmr = $.trim($("#NOmr").val());
			var OmrGrd = $.trim($("#OmrGrd").val());
			var OmrHak = $.trim($("#OmrHak").val());
			var OmrKind = $.trim($("#OmrKind").val());
			var OmrDay1 = $.trim($("#OmrDay1").val());
			var OmrBirth = $.trim($("#OmrBirth").val());
			var OmrSetCnt = $.trim($("#OmrSetCnt").val());
			var OmrWeekCnt = $.trim($("#OmrWeekCnt").val());
			var OmrDay2 = $.trim($("#OmrDay2").val());
			var WorkID = $.trim($("#WorkID").val());
		
				
			var searchUrl = "/fa/diagnosis/ipprOmrBan";
			var paramData = {"jisaCD":jisaCD, "omrDate":OmrDate, "hkey":Hkey, "kwamok":Kwamok, "rw":Rw, "nOmr":NOmr, "omrGrd":OmrGrd, "omrHak":OmrHak
			, "omrKind":OmrKind, "omrDay1":OmrDay1, "omrBirth":OmrBirth, "omrSetCnt":OmrSetCnt, "omrWeekCnt":OmrWeekCnt, "omrDay2":OmrDay2, "workID":WorkID};
			
				
				 $.ajax({
					url:searchUrl,
					type:"GET",
					cache: false,
					data: paramData,
					dataType: "JSON",			
					success: function(jsonData, textStatus, XMLHttpRequest) {
						if (jsonData.omrBanOK = "Y"){
							alert(jsonData.alertMsg);
						}else{
							alert(jsonData.alertMsg);							
						}
						
						self.close();
					},
					error:function (xhr, ajaxOptions, thrownError){	
						alert(thrownError);
					}
				});
				
				
				//window.self.close();
			
		},
		
		getReload:function(){  //페이지 새로고침
			location.reload();
		}
	});

	
	
	//처방조회 리스트 getBoardList 호출
	if(window.location.pathname == '/fa/diagnosis/diagnosisSearch/search'){
		$.getBoardList();
	}
	
	//처방입력화면 getIpprinput 호출
	if(window.location.pathname == '/fa/diagnosis/ipprinput'){
		$.getIpprinput();
	}
	
	
	// paging 클릭
	$(".paging").on("click","a.naviPage",function() {
		var pageNum = $(this).attr('pageNo');	
		$('#pageNum').val(pageNum);
		$.getBoardList();
	});	
	
});