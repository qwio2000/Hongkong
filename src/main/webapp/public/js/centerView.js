$(function(){	
	$.extend({
		// 센터 상담창 오픈
		openCenterCallLog:function(deptCD){
			var url = "/ja/centers/centerCommentCallRegist?deptCD="+deptCD;
			$.openPop(url, "centerCommentCallRegist","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=600,height=700");
		}		
			
	});

	
	
});
