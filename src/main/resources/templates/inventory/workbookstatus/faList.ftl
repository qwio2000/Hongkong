<#include "/include/header.ftl">
<!-- Main Content -->
	<div class="content">
		<h2 class="conTit">Workbook Status</h2>
		<div class="tbl01">
			<table>
				<colgroup>
					<col width="140" />
					<col width="160" />
					<col width="140" />
					<col width="160" />
					<col />
				</colgroup>
				<thead>
					<tr>
						<th>Last Ship</th>
						<th>Ship Freq.</th>
						<th>Next Ship</th>
						<th>Promo Item</th>
						<th><div class="btn_w">Detail<a href="#" class="btn_q">?</a></div></th>
					</tr>
				</thead>
				<tbody>
					<#list mstlist as mstlistIndex>
						<tr>
							<td>${mstlistIndex.lastshipt }</td>
							<td>Every ${mstlistIndex.shipevery } days <br /> UPS</td>
							<td>${mstlistIndex.nextshipt }</td>
							<td>''</td>
							<td class="left">
								<select name="subjgo" id="subjgo_${mstlistIndex_index }" style="width:200px">
									<option value=""></option>
									<#list mstlistIndex.subj as subjIndex>
										<option value="${subjIndex.jisaCD },${subjIndex.deptCD },${subjIndex.subj },'' ">${subjIndex.subjnm }</option>
									</#list>
								</select>
								<p class="txt_select">
									Select a subject to view inventory detail.
								</p>
							</td>
						</tr>
					</#list>
				</tbody>
			</table>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/footer.ftl">