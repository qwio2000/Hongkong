<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="content">
		<h2 class="conTit">Adjustment</h2>
		<div class="list02 pt20">
			<select name="jindoGubun" id="jindoGubun" style="width:365px">
				<option value="">choice</option>
				<option value="40">Review</option>
				<option value="41">Skip week</option>
			</select>
		</div>
		
			<input type="hidden" id="jisaCD" value="${jisaCD }">
			<input type="hidden" id="memKey" value="${memKey }">
			<input type="hidden" id="subj" value="${subj }">
			<input type="hidden" id="yoil" value="${yoil }">
			<input type="hidden" id="set1" value="">
			<input type="hidden" id="set2" value="">
			<input type="hidden" id="set3" value="">
			<input type="hidden" id="set4" value="">
			<input type="hidden" id="set5" value="">
			<input type="hidden" id="alertMsg3" value="${alertMsg3 }">
</div>



<!--// Main Content -->
<#include "/include/popupfooter.ftl">
