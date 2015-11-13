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
							<td class="left pl10"><a href="#" class="blue">${mstlistIndex.centeername }</a></td>
							<td>
								05/16/2014 <a href="#" class="icon_print"><span class="hidden">Print</span></a>
							</td>
							<td>
								<span class="radio_wrap">
									<input type="radio" value="" name="" id="radio1"><label class="radio_label" for="radio1">30 days</label><br />
									<input type="radio" value="" name="" id="radio2"><label class="radio_label" for="radio2">60 days</label>
								</span>
							</td>
							<td>
								<span class="txt_area">05/16/2014</span> <a href="#" class="icon_print"><span class="hidden">Print</span></a>
							</td>
							<td>
								<span class="txt_area">05/16/2014</span>
								<div class="tbl_btn_area">
									<a href="#" class="icon_print"><span class="hidden">Print</span></a>
									<a href="#" class="icon_delivery"><span class="hidden">Delivery</span></a>
								</div>
							</td>
							<td>
								<span class="txt_area">05/16/2014 / Qty.35</span>
								<div class="tbl_btn_area">
									<a href="#" class="icon_print"><span class="hidden">Print</span></a>
									<a href="#" class="icon_delivery"><span class="hidden">Delivery</span></a>
								</div>
							</td>
							<td>
								<select name="subjgo" id="subjgo" style="width:125px">
									<option value=""></option>
									<#list mstlistIndex.subj as subjIndex>
										<option value="${subjIndex.jisacd },${subjIndex.deptcd },${subjIndex.subj }">${subjIndex.subjnm }</option>
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