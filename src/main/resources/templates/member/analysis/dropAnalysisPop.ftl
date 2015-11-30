<#include "/include/popupheader.ftl">
<#macro zeroNonDisplay arg>
	<#if arg != 0>
		${arg }
	</#if>
</#macro>
<!-- Main Content -->
<div class="popup" style="min-width:300px">
	<div class="popup_top"><h1>${deptName }</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_gm">
		<h2 class="conTit">Drop Analysis by Month (Year ${searchYY }) </h2>
			<div class="tbl01 tbl_w100">
				<table>
					<colgroup>
						<col />
						<col style="width:75px" />
						<col style="width:75px" />
						<col style="width:75px" />
						<col style="width:75px" />
						<col style="width:75px" />
						<col style="width:75px" />
						<col style="width:75px" />
						<col style="width:75px" />
						<col style="width:75px" />
						<col style="width:75px" />
						<col style="width:75px" />
					</colgroup>
					<thead>
						<tr class="line">
							<th class="no_line"></th>
							<#list dropReasons as reason>
								<th>${reason.dtlCDNM }</th>
							</#list>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<#list drops as drop>
						<#if drop?has_next>
						<tr class="line2">
							<td class="no_line">${drop.monthName }</td>
							<td><@zeroNonDisplay drop.dropCnt01 /></td>
							<td><@zeroNonDisplay drop.dropCnt02 /></td>
							<td><@zeroNonDisplay drop.dropCnt03 /></td>
							<td><@zeroNonDisplay drop.dropCnt04 /></td>
							<td><@zeroNonDisplay drop.dropCnt05 /></td>
							<td><@zeroNonDisplay drop.dropCnt06 /></td>
							<td><@zeroNonDisplay drop.dropCnt07 /></td>
							<td><@zeroNonDisplay drop.dropCnt08 /></td>
							<td><@zeroNonDisplay drop.dropCnt09 /></td>
							<td><@zeroNonDisplay drop.dropCnt10 /></td>
							<td class="col_gray"><@zeroNonDisplay drop.totalDrop /></td>
						</tr>
						<#else>
							<tr class="total line2">
								<td class="no_line">${drop.monthName }</td>
								<td>${drop.dropCnt01 }</td>
								<td>${drop.dropCnt02 }</td>
								<td>${drop.dropCnt03 }</td>
								<td>${drop.dropCnt04 }</td>
								<td>${drop.dropCnt05 }</td>
								<td>${drop.dropCnt06 }</td>
								<td>${drop.dropCnt07 }</td>
								<td>${drop.dropCnt08 }</td>
								<td>${drop.dropCnt09 }</td>
								<td>${drop.dropCnt10 }</td>
								<td>${drop.totalDrop }</td>
							</tr>
						</#if>
						</#list>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">
