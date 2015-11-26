<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>Royalty Report</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_input">
			<div class="float_r">
				<a href="javascript:self.print();" class="btn_print m0">Print</a>
			</div>						
			<h2 class="conTit">${royaltyView.deptName } - Current Enrollment : ${royaltyView.mgMMName } ${royaltyView.mgYY }</h2>	
			<div class="tbl01 tbl_w70">
				<table>
					<thead>
						<tr class="line">
							<th class="no_line" rowspan="2" style="width:150px">Subject</th>
							<th rowspan="2">Begining</th>
							<th rowspan="2">Drop</th>
							<th colspan="4">New</th>
							<th rowspan="2">Ending</th>
						</tr>
						<tr class="line">
							<th>100%</th>
							<th>75%</th>
							<th>50%</th>
							<th>25%</th>
						</tr>
					</thead>
					<tbody>
						<#list royaltyViewOfSalesList as list>
						<tr class="line2 <#if list.subj =='TT'>total</#if >">
							<th class="no_line <#if list.subj =='TT'>>col_gray</#if >">${list.subjName }</th>
							<td>${list.subjBegin }</td>
							<td>${list.subjDrop }</td>
							<td>${list.subjNew1 }</td>
							<td>${list.subjNew2 }</td>
							<td>${list.subjNew3 }</td>
							<td>${list.subjNew4 }</td>
							<td class="col_bold">${list.subjEnd }</td>
						</tr>
						</#list>
						<tr class="line2 total">
							<th class="no_line col_gray">Subject Fee</th>
							<td>${royaltyView.subjBeginFee }</td>
							<td>-</td>
							<td>${royaltyView.sectionFee1 }</td>
							<td>${royaltyView.sectionFee2 }</td>
							<td>${royaltyView.sectionFee3 }</td>
							<td>${royaltyView.sectionFee4 }</td>
							<td class="col_bold">${royaltyView.subjEndFee }</td>
						</tr>
					</tbody>
				</table>
			</div>
			<h2 class="conTit mt40">Current Charge Summary</h2>
			<div class="tbl01">
				<table>
					<colgroup>
						<col style="width:180px" />
						<col style="width:180px" />
						<col style="width:50px" />
						<col />
						<col />
					</colgroup>
					<thead>
						<tr class="line">
							<th class="no_line"></th>
							<th>Description</th>
							<th>Qty</th>
							<th>Charges</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<tr class="line2">
							<td class="no_line left" rowspan="3">Royalty</td>
							<td class="left">Subject Fee</td>
							<td></td>
							<td>${royaltyView.subjectFee }</td>
							<td rowspan="3">${royaltyView.royalty }</td>
						</tr>
						<tr class="line2">
							<td class="left">Enrollment Fee</td>
							<td></td>
							<td>${royaltyView.enrollmentFee }</td>
						</tr>
						<tr class="line2">
							<td class="left">Credit / Debit</td>
							<td></td>
							<td>${royaltyView.royaltyCreditDebit }</td>
						</tr>
						<tr class="line2">
							<td class="no_line left" rowspan="5">Other Charges</td>
							<td class="left">Item charge*</td>
							<td></td>
							<td>${royaltyView.itemCharge }</td>
							<td rowspan="5">${royaltyView.totOtherCharge }</td>
						</tr>
						<tr class="line2">
							<td class="left">Chargeable Items</td>
							<td></td>
							<td>${royaltyView.chargeableItems }</td>
						</tr>						
						<tr class="line2">
							<td class="left">Freight charge</td>
							<td></td>
							<td>${royaltyView.freight }</td>
						</tr>
						<tr class="line2">
							<td class="left">Late Fee</td>
							<td></td>
							<td>${royaltyView.lateFee }</td>
						</tr>
						<tr class="line2">
							<td class="left">Other Credit / Debit</td>
							<td></td>
							<td>${royaltyView.otherCreditDebit }</td>
						</tr>
						<tr class="total line2">
							<td class="no_line left">This Month Charges</td>
							<td>Total</td>
							<td></td>
							<td></td>
							<td>${royaltyView.royalty + royaltyView.totOtherCharge }</td>
						</tr>
					</tbody>
				</table>
			</div>
			<#if recordChargeTotalCnt != 0 >
			<div class="conEtc pt10">
				<div class="conTit_sub">*** Other Charges Detail</div>
				<ul class="list02 pt10">
					<#list recordChargeList as list>
						<#if list.chargeCD=="99">
						<li class="pl20"><span class="blue">${list.chargeName }</span> ${list.chargeYMD } (<span class="blue btn_view_list"><a href="javascript:;" onMouseOver="$.getPromoItemOrderDtlOfRoyaltyView('${list.idx}');">${list.amount }</a></span>) ${list.memo }</li>
						<#else>
						<li class="pl20"><span class="blue">${list.chargeName }</span> ${list.chargeYMD } (${list.amount }) ${list.memo }</li>
						</#if>
					</#list>
				</ul>
			</div>
			<!-- 판촉물 주문 내역 레이어 팝업-->
			<div  class="layer_pop_list" style="display:none;" id="promoOrderDetailContent"></div>
			<!-- //세부내역 -->
			</#if>					
			<h2 class="conTit mt40">Total Due</h2>
			<div class="tbl01">
				<table>
					<colgroup>
						<col style="width:160px" />
						<col style="width:350px" />
						<col  />
					</colgroup>
					<tbody>
						<tr class="line2">
							<th class="no_line">Previous Balance</th>
							<td class="left"></td>
							<td>${royaltyView.prevBalance }</td>
						</tr>
						<tr class="line2">
							<th class="no_line">Payment Received</th>
							<td class="left">
								<#list recordPaymentList as list>
									${list.payName } (${list.refNo }) ${list.amount } received on ${list.payYMD } <br />
								</#list>						
							</td>
							<td>${royaltyView.payment }</td>
						</tr>
						<tr class="line2">
							<th class="no_line">This month Charges</th>
							<td class="left"></td>
							<td>${royaltyView.royalty + royaltyView.totOtherCharge }</td>
						</tr>
						<tr class="total line2">
							<td class="no_line left" colspan="2">Total Amount Due</td>
							<td>${royaltyView.totalCharge }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!--// Main Content -->

<!-- 판촉물 주문내역 레이어 팝업-->
<script id="promoOrderDetailContentTemplate" type="text/x-handlebars-template">
	<div class="line">
		<div class="tbl01">
			<table>
				<thead>
					<tr>
						<th>Item Name</th>
						<th style="width:60px">Price</th>
						<th style="width:60px">Order Qty</th>
						<th style="width:80px">Amount</th>
					</tr>
				</thead>
				<tbody>
					{{#each promoOrderDtllist}}
					<tr>
						<td class="left">{{itemName}}</td>
						<td>{{itemPrice}}</td>
						<td>{{orderQty}}</td>
						<td>{{orderAmt}}</td>
					</tr>
					{{/each}}
				</tbody>
			</table>
		</div>
	</div>
</script>
<!-- //판촉물 주문내역 -->
<#include "/include/popupfooter.ftl">