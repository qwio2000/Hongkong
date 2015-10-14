<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top"><h1>${memName } : Subject History</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
		<div class="popup_content">
			<div class="pop_gm">
					<ul class="list02">
					<#if ipprs?has_content>
					</#if>
					<#list ipprs as ippr>
					<li>
						<label for="subj" class="tit">${ippr.subj }</label>
						<#if ippr.digYN == "Y">
						<a href="javascript:viewIppr('${ippr.jisaCD }','${ippr.omrDate }','${ippr.memKey }','${ippr.subj }');" class="btn_search"><span>IPPR</span></a>
						</#if>
					</li>
					</#list>
				</ul>
			</div>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">