<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Record Payment</h2>
	<div class="list02 pt20 clearfix">
		<div class="float_l">
			Input Month : ${currentMonthName?default('') } ${currentYear?default('') }
		</div>
	</div>
	<div class="tbl01 mt5">
		<table>
			<colgroup>
				<col width="150" />
				<col />
				<col width="150" />
				<col width="150" />
				<col width="150" />
				<col width="110" />
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line">State</th>
					<th>Center</th>
					<th>Balance</th>
					<th>Amount</th>
					<th>Current Balance</th>
					<th>Add Payment</th>
				</tr>
			</thead>
			<tbody>
				<#list recordPayment as list>
				<tr class="line2" >
					<td class="no_line left">${list.stateName }</td>
					<td class="left">${list.deptName }</td>
					<td>${list.balance }</td>
					<td>${list.amount }</td>
					<td>${list.currentBalance }</td>
					<td><a href="javascript:;" onClick="$.openRecordPaymentPop('${list.deptCD }','${list.mgYY }','${list.mgMM }');" class="btn_icon_one btn_doc2">View detail</a></td>
				</tr>
				</#list>
			</tbody>
		</table>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
