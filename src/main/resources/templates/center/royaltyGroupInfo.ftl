<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>Royalty Charge Group</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_jisa">
			<div class="tbl01">
				<table>
					<colgroup>
						<col width="50%" />
						<col width="50%" />
					</colgroup>
					<thead>
						<tr>
							<th class="left">Subjects</th>
							<th class="left">Royalty Chagre(%)</th>
						</tr>
					</thead>
					<tbody>
						<#assign group = ''>
						<#list rtyChargeGroupList as list>
							<#if group != list.rtyType>
								<tr class="total">
									<td colspan="2" class="left">${list.rtyTypeName}</td>
								</tr>			
							</#if>
						<tr>
							<td class="left">${list.startCnt}~${list.endCnt}</td>
							<td class="left">${list.rtyRate}</td>
						</tr>
						<#assign group = list.rtyType>
						</#list>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">