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
							<#if ippr.omrDate != ''>
								<a href="javascript:$.openIpprPost('${ippr.jisaCD }','${ippr.omrDate }','${ippr.memKey }','0','${ippr.subj }', '${ippr.subj?substring(0,1) }', 'Y', 'ipprDiv');" class="btn_search"><span class="blue">IPPR</span></a>
							<#else>
								<a href="#" class="btn_search"><span class="gray">IPPR</span></a>
							</#if>
						</#if>
						<span>${ippr.omrDate }</span>
					</li>
					</#list>
				</ul>
			</div>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">