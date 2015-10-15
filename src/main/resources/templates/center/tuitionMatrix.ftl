<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>Set Tuition Matrix</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_jisa">
			<div class="selection_list pt20">
				<p>Tuition</p>
				<ul>
					<li><span class="title line2">Month Fee</span> <span class="input_w">${feeUnitName?default('')} <input type="text" value="${monthFee?default('')}" class="searchInput" style="width:218px" readOnly /></span></li>
					<#list memFeeInfoList as list>
					<li><span class="title line2">Remaining Week${list.weekNum}</span> <span class="input_w">${list.feeUnitName} <input type="text" value="${list.sectionFee}" class="searchInput" style="width:218px" readOnly /></span></li>
					</#list>
				</ul>
			</div>
			<div class="selection_list pt20">
				<p>Other Fees</p>
				<ul>
					<li><span class="title line2">Registration Fee</span> <span class="input_w">${feeUnitName?default('')} <input type="text" value="${registFee?default('')}" class="searchInput" style="width:218px" readOnly /></span></li>
				</ul>
			</div>		
		</div>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">