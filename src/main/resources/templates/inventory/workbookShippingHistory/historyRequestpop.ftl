<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top">
			<h1></h1> 
			<a href="javascript:self.close();" class="btn_popup_close">close</a>
		</div>
		<div class="popup_content">
			<div class="pop_input">
				<!-- <div class="clearfix list02 pt20">
					<div class="float_l">
						<strong>Packing Ship</strong>
					</div>
				</div> -->
				<div class="tbl01 mt5">
					<table>
						<colgroup>
							<col width="60" />
							<col width="60"/>
							<col width="60"/>
							<col width="60" />
							<col width="60" />
							<col width="60" />
							<col width="60" />
							<col width="210" />
						</colgroup>
						<thead>
							<tr>
								<th>Request Date</th>
								<th>Subject</th>
								<th>Level</th>
								<th>Requested</th>
								<th>ShipQty</th>
								<th>Requested By</th>
								<th>Ship Date</th>
								<th>Note</th>
							</tr>
						</thead>
						<tbody>
							<#assign wbinoutcalSum = 0?number><#assign inoutshipSum = 0?number>
							<#list list as listIndex>
							<tr>
								<td>${listIndex.inoutreqymdt }</td>
								<td>${listIndex.subjname }</td>
								<td>${listIndex.wbname }</td>
								<td>${listIndex.wbinoutcal }</td>
								<td>${listIndex.inoutship }</td>
								<td>${listIndex.userfstname }</td>
								<td>${listIndex.inoutsignymdt }</td>
								<td>${listIndex.inoutreqnote }</td>
								<#assign wbinoutcalSum = wbinoutcalSum + listIndex.wbinoutcal?number>
								<#assign inoutshipSum = inoutshipSum + listIndex.inoutship?number>
							</tr>
							</#list>
							<tr class="total">
								<td colspan="3"></td>
								<td>${wbinoutcalSum }</td>
								<td>${inoutshipSum }</td>
								<td colspan="3"></td>								
							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">