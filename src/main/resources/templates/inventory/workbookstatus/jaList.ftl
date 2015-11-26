<#include "/include/header.ftl">
<!-- Main Content -->
	<div class="content">
		<h2 class="conTit">Workbook Status(Center)</h2>
		<div class="tbl01">
			<table>
				<colgroup>
					<col width="40" />
					<col />
					<col width="120" />
					<col width="120" />
					<col width="120" />
					<col width="120" />
					<col width="150" />
					<col width="140" />
				</colgroup>
				<thead>
					<tr class="line">
						<th class="no_line">ST</th>
						<th>Center Name</th>
						<th>Last Ship</th>
						<th>Ship Freq.</th>
						<th>Next Ship</th>
						<th>Promo Item</th>
						<th>Additional Workbook</th>
						<th>Subject</th>
					</tr>
				</thead>
				<tbody>
					<#list mstlist as mstlistIndex>
						<tr class="line2">
							<td class="no_line">${mstlistIndex.st }</td>
							<td class="left pl10"><a href="/ja/members/workbook?jisaCD=${mstlistIndex.jisaCD }&deptCD=${mstlistIndex.deptCD}" class="blue">${mstlistIndex.centeername }</a></td>
							<td>
								<#if mstlistIndex.lastshipt != "">
									<a href="javascript:$.getInOutPrint('${mstlistIndex.jisaCD }','${mstlistIndex.deptCD }','${mstlistIndex.lastship }','')">${mstlistIndex.lastshipt }</a> 
									<a href="javascript:$.getInOutPrint('${mstlistIndex.jisaCD }','${mstlistIndex.deptCD }','${mstlistIndex.lastship }','P')" class="icon_print"><span class="hidden">Print</span></a>
								</#if>
							</td>
							<td>
								<span class="radio_wrap">
									<input type="radio" value="30" name="shipevery${mstlistIndex_index }" id="radio1${mstlistIndex_index }" disabled="disabled" <#if mstlistIndex.shipevery == "30">checked="checked"</#if>>
									<label class="radio_label" for="radio1${mstlistIndex_index }">30 days</label><br />
									<input type="radio" value="60" name="shipevery${mstlistIndex_index }" id="radio2${mstlistIndex_index }" disabled="disabled" <#if mstlistIndex.shipevery == "60">checked="checked"</#if>>
									<label class="radio_label" for="radio2${mstlistIndex_index }">60 days</label>
								</span>
							</td>
							<td>	
								<#if mstlistIndex.nextshipt != "">
								<a href="javascript:$.getNextPrint('${mstlistIndex.jisaCD }','${mstlistIndex.deptCD }','','print','')"><span class="txt_area">${mstlistIndex.nextshipt }</span></a> 
								<a href="javascript:$.getNextPrint('${mstlistIndex.jisaCD }','${mstlistIndex.deptCD }','','print','P')" class="icon_print"><span class="hidden">Print</span></a>
								</#if>
							</td>
							<td>
								<span class="txt_area">''</span>
								<div class="tbl_btn_area">
									<a href="#" class="icon_print"><span class="hidden">Print</span></a>
									<a href="#" class="icon_delivery"><span class="hidden">Delivery</span></a>
								</div>
							</td>
							<td>
								<#if mstlistIndex.additionalworkbook != "">
								<span class="txt_area">${mstlistIndex.additionalworkbookt } Qty.${mstlistIndex.gradetotinoutship }</span>
								<div class="tbl_btn_area">
									<a href="javascript:$.getAdditionalworkbook('${mstlistIndex.jisaCD }','${mstlistIndex.deptCD }','${mstlistIndex.additionalworkbook }') " class="icon_print">
										<span class="hidden">Print</span>
									</a>
									<a href="javascript:$.getAdditionalworkbook('${mstlistIndex.jisaCD }','${mstlistIndex.deptCD }','${mstlistIndex.additionalworkbook }') " class="icon_delivery">
										<span class="hidden">Delivery</span>
									</a>
								</div>
								</#if>
							</td>
							<td>
								${mstlistIndex.deptCD }
								<select name="subjgo" id="subjgo_${mstlistIndex_index }" style="width:125px">
									<option value=""></option>
									<#list mstlistIndex.subj as subjIndex>
										<option value="${subjIndex.jisaCD },${subjIndex.deptCD },${subjIndex.subj },'' ">${subjIndex.subjnm }</option>
									</#list>
								</select>
								
							</td>
						</tr>
					</#list>
				</tbody>
			</table>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/footer.ftl">