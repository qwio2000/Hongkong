<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Royalty Report</h2>
	<div class="list02 pt20 clearfix">
		<form id="searchForm" name="searchForm" action="" method="">
		<div class="float_l">
			Report Year &nbsp;
			<select name="selYY" id="selYY" style="width:100px">
				<#list selYY?number..selYY?number-2 as i>
					<option value="${i?c }" <#if i == selYY?number>selected</#if>>${i?c }</option>
				</#list>				
			</select>
			<span class="btnArea mt0"><a id="royaltyReportOfCenterSearchSubmit" href="javascript:;"><span style="width:70px">View</span></a></span>			
		</div>
		</form>
	</div>
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
			<tbody id="mainContent"></tbody>
		</table>
	</div>
</div>


<!--// Main Content -->
<script id="mainContentTemplate" type="text/x-handlebars-template">
	{{#each royaltyReportList}}
		<tr class="line2">
			<td class="no_line left pl5">
				<div class="clearfix">
					<div class="sel_name"><a href="javascript:;" onClick="$.openRoyaltyView('{{deptCD}}','{{mgYY}}','{{mgMM}}');" class="icon_search">{{mgMMName}}</a></div>
					<!-- div class="sel_print">
						<a href="#" class="icon_print"><span class="hidden">Print</span></a>
					</div -->
				</div>
			</td>
			<td>{{prevBalance}}</td>
			<td>{{payment}}</td>
			<td class="col_gray">{{currBalance}}</td>
			<td>{{royalty}}</td>
			<td>{{chargeItem}}</td>
			<td>{{freight}}</td>
			<td>{{lateFee}}</td>
			<td>{{otherCreditDebit}}</td>
			<td class="col_gray">{{totalCharge}}</td>
		</tr>

	{{else}}
		<tr>
			<td colspan="10">no search results</td>
		</tr>
	{{/each}}
</script>

<#include "/include/footer.ftl">
