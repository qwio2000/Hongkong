<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>Yearly Royalty Report</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_input">
			<h2 class="conTit">Royalty Report</h2>
			<form id="searchForm" name="searchForm" action="" method="">
			<input type="hidden" name="deptCD" id="deptCD" value="${deptCD?default('')}"> 
			<div class="list02 pt20 clearfix">
				<div class="float_l">
					Report Year &nbsp;
					<select name="selYY" id="selYY" style="width:100px">
						<#list currentYear?number..currentYear?number-2 as i>
							<option value="${i?c }" <#if i == selYY?number>selected</#if>>${i?c }</option>
						</#list>				
					</select>
					<span class="btnArea mt0"><a id="royaltyReportPopSearchSubmit" href="javascript:;"><span style="width:70px">View</span></a></span>
				</div>
				<div class="float_r">
					<div class="notice_state">State : ${stateName?default('')}, Center : <em>${deptName?default('')}</em></div>
				</div>
			</div>
			</form>
			<div class="tbl01 mt5 tbl_w100">
				<table>
					<thead>
						<tr class="line">
							<th class="no_line" style="width:200px">Month</th>
							<th>Previous <br />Balance</th>
							<th>Payment</th>
							<th>Balance <br />Forward</th>
							<th>Royalty</th>
							<th>Chargeable <br />Item</th>
							<th>Freight <br />Charge</th>
							<th>Late Fee</th>
							<th>Other <br />Credit / Debit</th>
							<th>Total <br />Charge</th>
						</tr>
					</thead>
					<tbody>
						<#list royaltyReportList as list>
						<tr class="line2">
							<td class="no_line left pl5">
								<div class="clearfix">
									<div class="sel_name"><a href="javascript:;" onClick="$.openRoyaltyView('${list.deptCD}','${list.mgYY}','${list.mgMM}');" class="icon_search">${list.mgMMName}</a></div>
									<div class="sel_print">
										<a href="#" class="icon_print"><span class="hidden">Print</span></a>
									</div>
								</div>
							</td>
							<td>${list.prevBalance}</td>
							<td>${list.payment}</td>
							<td class="col_gray">${list.currBalance}</td>
							<td>${list.royalty}</td>
							<td>${list.chargeItem}</td>
							<td>${list.freight}</td>
							<td>${list.lateFee}</td>
							<td>${list.otherCreditDebit}</td>
							<td class="col_gray">${list.totalCharge}</td>
						</tr>
						<#else>
						<tr class="line2"><td colspan="10">no search results</td></tr>
						</#list>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">