<#include "/include/popupheader.ftl">
<script type="text/javascript">
<!--
	if ("${chk}"=="N") {
		alert("정보가 없습니다.");
		self.close();
	}
//-->
</script>
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>Set Subject Preference</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_jisa">
			<form action="" name="centerOpenSubjForm" id="centerOpenSubjForm">
			<input type="hidden" name="deptCD" value="${deptCD?default('')}"/>		
			<div class="list03">
				<p>Select subject(s) that this center offers.</p>
				<ul>
					<#list centerOpenSubjList as list>
					<li><span class="chk_s01"><input type="checkbox" name="openSubj" value="${list.subj }" id="chkOpenSubj_${list.subj }"  <#if list.openSubj != "">checked</#if>><label for="chkOpenSubj_${list.subj }">${list.subj }</label></span></li>
					</#list>
				</ul>			
			</div>
			</form>
			<div class="btnArea">
				<a href="javascript:;" id="saveCenterOpenSubj" ><span>Save Subject Preference</span></a>
			</div>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">