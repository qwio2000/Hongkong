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
			
			var paramData = "jisaCD="+jisaCD+"&leveldung="+leveldung+"&subjname="+subjname;
			
			var searchUrl = "/fa/diagnosis/ipprinputJson";

			$.ajax({
				type: "post"
				,url: searchUrl
				,data: paramData	
				,error: function (data, textStatus) { 
					alert(textStatus); 			
				}
				,success: function(data){	

					$("#diagnosislist").html(data);
				}
				,async: false
			});
		 
			
		},
		
		getInputChk:function(id,input,jungdab,mun,chk){   //수학 오답 체크
			var temp
				temp = "<input type='text' id='"+mun+"' value='"+mun+"|"+chk+"'>"
			
				
			$(".chk_s01 [id^="+id+"]").each(function (i, v) {	
				if ( $(this).val() == jungdab){
					$(this).attr("checked", false); /* by ID */
					$(this).attr("disabled", "disabled"); /* by ID */
				}else if ( $(this).val() == input){			
					$(this).attr("checked", true); /* by ID */	
					$("#inputAnswer #"+mun+" ").remove();
				}else{
					$(this).attr("checked", false); /* by ID */
					$("#inputAnswer #"+mun+" ").remove();
				}
			});
			
			if($(".chk_s01 #chk"+mun+"_"+chk+"").is(":checked") == true ){
				$("#inputAnswer").append(temp)
			}
				
			//번호순서대로 정렬
			var items = $('#inputAnswer input').get();
			
			items.sort(function(a,b){
			  var keyA = Number($(a).attr('id'));
			  var keyB = Number($(b).attr('id'));

			  if (keyA < keyB) return -1;
			  if (keyA > keyB) return 1;
			  return 0;
			});

			$('#inputAnswer').html('');
			
			$.each(items, function(i, tr){			
				$('#inputAnswer').append(tr);
			});
		},
		
		getIpprSave:function(){  //오답입력 저장
			var searchUrl = "/fa/diagnosis/ipprInputSave";
		
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
			alert(SName)
			var paramData = {"omrDate":OmrDate, "hkey":Hkey, "kwamok":Kwamok, "rw":Rw, "nOmr":NOmr, "mFstName":MFstName, "mLstName":MLstName
					, "skey":Skey, "sName":SName, "omrGrd":OmrGrd, "omrHak":OmrHak, "omrBirth":OmrBirth, "OmrKind":OmrKind, "omrDay1":OmrDay1, "omrDay2":OmrDay2
					, "omrStudyNum":OmrStudyNum, "deptCD":DeptCD, "jisaCD":JisaCD, "deptName":DeptName, "workID":WorkID};
			
			$.ajax({
				url:searchUrl,
				type:"GET",
				cache: false,
				data: paramData,
				dataType: "json",
				success: function(jsonData, textStatus, XMLHttpRequest) {
					alert(12)
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