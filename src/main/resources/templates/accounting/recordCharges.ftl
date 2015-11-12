<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Record Charges</h2>
	<div class="list02 pt20 clearfix">
		<div class="float_l">
			Input Month : ${currentMonthName?default('') } ${currentYear?default('') }
		</div>
	</div>
	<ul class="list05 mt10">
		<li class="record1">
			<div class="tbl01 mt0 pb10">
				<table>
					<colgroup>
						<col style="width:70px" />
						<col />
						<col style="width:100px" />
						<col style="width:100px" />
						<col style="width:100px" />
						<col style="width:100px" />
						<col style="width:100px" />
						<col style="width:100px" />						
						<col style="width:60px" />
					</colgroup>
					<thead>
						<tr class="line">
							<th class="no_line">State</th>
							<th>Center</th>
							<th>Royalty <br />Credit / Debit</th>
							<th>Chargeable <br />Items</th>
							<th>Freight</th>
							<th>LateFee</th>
							<th>Other <br />Credit / Debit</th>
							<th>Total</th>
							<th>Add Charge</th>
						</tr>
					</thead>
					<tbody>
						<#list recordCharge as list>
						<tr class="line2">
							<td class="no_line">${list.stateName }</td>
							<td class="left">${list.deptName }</td>
							<td>${list.royaltyCreditDebit }</td>
							<td>${list.chargeableItems }</td>
							<td>${list.freight }</td>
							<td>${list.lateFee }</td>
							<td>${list.otherCreditDebit }</td>
							<td class="col_gray">${list.total }</td>
							<td><a href="javascript:;" onClick="$.openRecordChargesPop('${list.deptCD }','${list.mgYY }','${list.mgMM }');" class="btn_icon_one btn_doc2">View detail</a></td>
						</tr>
						<#else>
						<tr ><td colspan="9">no search results</td></tr>
						</#list>
					</tbody>
				</table>
			</div>
		</li>
	</ul>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
