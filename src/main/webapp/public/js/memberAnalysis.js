$(function(){	
	$.extend({
		//조직찾기
		openDeptSearch:function(){
			var url = "/ja/members/analysis/deptSearchPop";
			$.openPop(url, "deptSearchPop","menubar=no,toolbar=no,status=no,resizable=yes,scrollbars=yes,width=600,height=600");		
		},
		deptSearchSelect:function(jisaCD,deptCD,deptName){
			opener.$("#deptCD").val(deptCD);			
			opener.$("#deptName").val(deptName);
			self.close();
		}		
	});
	
	$("#memberAnalysisJASubmit").click(function(){
		$("#searchForm").submit();
	});
	
	$("#memberAnalysisJAInit").click(function(){
		location.href="/ja/members/analysis";
	});
	
	$("#memberAnalysisGradeJASubmit").click(function(){
		$("#searchForm").submit();
	});
	
	$("#memberAnalysisGradeJAInit").click(function(){
		location.href="/ja/members/analysis/grade";
	});
});
