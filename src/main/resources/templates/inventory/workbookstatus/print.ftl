<#include "/include/header.ftl">
<!-- Main Content -->
	<div class="content">
		<h2 class="conTit">Workbook Status(Center)</h2>
		<a href="javascript:$.getGoPrint();" class="btn_print">Print</a>
		
		<input type="hidden" id="jisaCD" value="${jisaCD }">
		<input type="hidden" id="deptCD" value="${deptCD }">
		<input type="hidden" id="gubun" value="${gubun }">
		<input type="hidden" id="pgubun" value="${pgubun }">
		
		
		<#list subjlist as subjlistIndex>	
			<input type="hidden" id="subjlist_${subjlistIndex.subj }" value="${subjlistIndex.subj }">
		</#list>
		
		<div id="printlist"></div>
	</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
