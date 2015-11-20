<#include "/include/popupheader.ftl">
	<div class="popup">
		<div class="popup_top"><h1>${casKey }</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
		<div class="popup_content">
			<div class="pop_input">
				<div class="tbl01">
					<table>
						<colgroup>
							<col width="110" />
							<col />
							<col />
							<col width="80" />
							<col width="80" />
							<col width="80" />
						</colgroup>
						<thead>
							<tr>
								<th>Date</th>
								<th>Subject</th>
								<th>Action</th>
								<th>Qty(was)</th>
								<th>Qty</th>
								<th>Balance</th>
							</tr>
						</thead>
						<tbody>
							<#list invenlist as invenlistIndex>
								<tr>
									<td>${invenlistIndex.inoutsignymdt }</td>
									<td>${invenlistIndex.subjnm }(${invenlistIndex.wbname })</td>
									<td>${invenlistIndex.inoutreqcdnm }</td>
									<td>${invenlistIndex.wbstock }</td>
									<td>${invenlistIndex.wbinout }</td>
									<td class="col_gray">${invenlistIndex.balance }</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
<#include "/include/popupfooter.ftl">