<#include "/include/header.ftl">
<!-- Main Content -->
	<div class="content">
		<h2 class="conTit">Restock History</h2>
		<div class="list02 pt20 clearfix">
			<div class="float_l">
				<select name="yyRestock" id="yyRestock" style="width:162px">
					<#list yylist as yylistIndex>
						<#if yy == yylistIndex>
							<option value="${yylistIndex }" selected="selected">${yylistIndex }</option>
						<#else>
							<option value="${yylistIndex }">${yylistIndex }</option>
						</#if>
					</#list>
				</select>			
			</div>
		</div>
		<div class="tbl01 mt5">
			<table>
				<colgroup>
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="60">
				</colgroup>
				<thead>
					<tr class="line">
						<th class="no_line font_blue" colspan="13">Actual Shipped Qty.</th>						
					</tr>					
				</thead>
				<tbody>
					<tr class="line2">
						<td class="no_line font_green" colspan="13">Used Qty</td>						
					</tr>
					<tr class="line">						
						<th class="no_line">JAN</th>
						<th>FEB</th>
						<th>MAR</th>
						<th>APR</th>
						<th>MAY</th>
						<th>JUN</th>
						<th>JUL</th>
						<th>AUG</th>
						<th>SEP</th>
						<th>OCT</th>
						<th>NOV</th>
						<th>DEC</th>
						<th>TOTAL</th>						
					</tr>	
					<tr class="line2">
						<#assign wbinoutshipSum = 0><#assign wbinoutcalSum = 0>
						<#list restocklist as restocklistIndex>
							<#assign wbinoutshipSum = wbinoutshipSum + restocklistIndex.wbinoutship?number>
							<#assign wbinoutcalSum = wbinoutcalSum + restocklistIndex.wbinoutcal?number>
							<#if restocklistIndex_index == 0>
								<td class="no_line">
									<div class="font_blue">
										<#if restocklistIndex.wbinoutship != "0">
										<a href="javascript:$.openPop('/fa/inventory/HistoryRestockPopup?yy=${yy }&mon=${restocklistIndex.mon }','historyRestockPopup','width=924,height=700,left=300,scrollbars=yes,resizable=yes')">
											${restocklistIndex.wbinoutship?number }
										</a>
										<#else>
											${restocklistIndex.wbinoutship?number }
										</#if>
									</div>
									<div class="font_green">${restocklistIndex.wbinoutcal?number }</div>									
								</td>
							<#else>
								<td>
									<div class="font_blue">
										<#if restocklistIndex.wbinoutship != "0">
										<a href="javascript:$.openPop('/fa/inventory/historyRestock?yy=${yy }&mon=${restocklistIndex.mon }','historyRestockPopup','width=924,height=700,left=300,scrollbars=yes,resizable=yes')">
											${restocklistIndex.wbinoutship?number }
										</a>
										<#else>
											${restocklistIndex.wbinoutship?number }
										</#if>
									</div>
									<div class="font_green">${restocklistIndex.wbinoutcal?number }</div>
								</td>
							</#if>
						</#list>	
							<td>
								<div class="font_blue">${wbinoutshipSum }</div>
								<div class="font_green">${wbinoutcalSum }</div>
							</td>										
					</tr>
				</tbody>
			</table>
		</div>
		
		<h2 class="conTit">Workbook Request History</h2>
		<div class="tbl01 mt5">
			<table>
				<colgroup>
					<col width="60">
					<col width="40">
					<col width="260">
					<col width="40">
					<col width="40">
					<col width="60">
					<col width="40">
				</colgroup>
				<thead>
					<tr class="line">
						<th class="no_line">Request Date</th>
						<th>Requested By</th>
						<th>Note</th>
						<th>Requested</th>
						<th>ShipQty</th>
						<th>ShipDate</th>
						<th>Balance</th>				
					</tr>					
				</thead>
				<tbody>
					<tr class="line2">
						<td class="no_line">1</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr class="line2 total">
						<td colspan="3" class="no_line"></td>
						<td>152</td>
						<td>152</td>
						<td>152</td>
						<td>152</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/footer.ftl">