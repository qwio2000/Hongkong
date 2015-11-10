<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Royalty Overview</h2>
	<div class="list02 pt20 clearfix">
		<form id="searchForm" name="searchForm" action="" method="">
		<div class="float_l">
			<select name="selYY" id="selYY" style="width:100px">
				<#list selYY?number..selYY?number-2 as i>
					<option value="${i?c }" <#if i == selYY?number>selected</#if>>${i?c }</option>
				</#list>				
			</select>
			<select name="selMM" id="selMM" style="width:162px">
				<#list months as month>
					<option value="${month.monthNum }" <#if month.monthNum == selMM>selected</#if> >${month.monthStr }</option>
				</#list>				
			</select>
			<span class="btnArea"><a id="searchSubmit" href="javascript:;"><span style="width:70px">View</span></a> <a id="searchInit" href="javascript:;"><span style="width:70px">Reset</span></a></span>
		</div>
		</form>
	</div>
	<div class="tbl01 mt5">
		<table>
			<colgroup>
				<col style="width:40px" />
				<col style="width:180px" />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line">State</th>
					<th>Center</th>
					<th>Begin</th>
					<th>New</th>
					<th>Drop</th>
					<th>Net</th>
					<th>End</th>
					<th>Previous <br />Balance</th>
					<th>Payment</th>
					<th>Balance <br />Forward</th>
					<th>Royalty</th>
					<th>Total <br />Charge</th>
				</tr>
			</thead>
			<tbody id="mainContent"></tbody>
		</table>
	</div>
</div>
<!--// Main Content -->
<script id="mainContentTemplate" type="text/x-handlebars-template">
	{{#each royaltyOverviewList}}
		<tr class="line2">
			<td class="no_line">{{stateName}}</td>
			<td class="left pl10"><a href="javascript:;" onClick="$.openRoyaltyReport('{{deptCD}}','{{mgYY}}','');" class="click">{{deptName}}</td>
			<td>{{subjBegin}}</td>
			<td>{{subjNew}}</td>
			<td>{{subjDrop}}</td>
			<td>{{subjNet}}</td>
			<td>{{subjEnd}}</td>
			<td>{{prevBalance}}</td>
			<td>{{payment}}</td>
			<td>{{currBalance}}</td>
			<td><a href="javascript:;" onClick="$.openRoyaltyView('{{deptCD}}','{{mgYY}}','{{mgMM}}');" class="click">{{royalty}}</a></td>
			<td>{{totalCharge}}</td>
		</tr>
	{{else}}
		<tr>
			<td colspan="12">no search results</td>
		</tr>
	{{/each}}
	{{#each royaltyOverviewTot}}
		<tr class="total line2">
			<td colspan="2" class="no_line">TOTAL</td>
			<td>{{subjBegin}}</td>
			<td>{{subjNew}}</td>
			<td>{{subjDrop}}</td>
			<td>{{subjNet}}</td>
			<td>{{subjEnd}}</td>
			<td>{{prevBalance}}</td>
			<td>{{payment}}</td>
			<td>{{currBalance}}</td>
			<td>{{royalty}}</td>
			<td>{{totalCharge}}</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl">
