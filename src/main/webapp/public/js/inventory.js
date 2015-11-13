$(function(){
	$.extend({
		
		
	});
	
	
	$("#subjgo").change(function() {
		var myArray = $("#subj").val().split(',');	    
	    var jisaCD = myArray[0];
	    var deptCD = myArray[1];
	    var subj = myArray[2];
	    
		document.location.href = "/ja/inventory/workbookstatusSubj?jisaCD="+jisaCD+"&deptCD="+deptCD+"&subj="+subj+" ";
	});
	
});