<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Charge Report</h2>
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
			<span class="btnArea mt0"><a id="searchSubmit" href="javascript:;"><span style="width:70px">Search</span></a> <a id="searchInit" href="javascript:;"><span style="width:70px">Reset</span></a></span>
		</div>
		</form>	
	</div>
	<div class="tbl01 mt5">
		<table>
			<colgroup>
				<col style="width:70px" />
				<col />
				<col style="width:80px" />
				<col style="width:150px" />
				<col style="width:120px" />
				<col style="width:350px" />
				<col style="width:100px" />
			</colgroup>
			<thead>
				<tr>
					<th>State</th>
					<th>Center</th>
					<th>Date</th>
					<th>Type</th>
					<th>Amount</th>
					<th colspan="2">Memo</th>
				</tr>
			</thead>
			<tbody id="mainContent"></tbody>
		</table>
	</div>
</div>
<!--// Main Content -->
<script id="mainContentTemplate" type="text/x-handlebars-template">
	{{#each chargeReportList}}
		<tr>
			<td>{{stateName}}</td>
			<td class="left">{{deptName}}</td>
			<td>{{chargeYMD}}</td>
			<td>{{chargeName}}</td>
			<td>{{amount}}</td>
			<td class="left">{{memo}}</td>
			<td>
				{{#xIf delFlag "==" 'Y' }}
					<a href="javascript:$.deleteRecordCharge('{{idx}}')" class="btn_delete">delete</a>
				{{/xIf}}
			</td>
		</tr>
	{{else}}
		<tr>
			<td colspan="7">no search results</td>
		</tr>
	{{/each}}
	{{#xIf totCnt ">" 0 }}
		<tr class="total">
			<td colspan="4"></td>
			<td>{{totAmount}}</td>
			<td colspan="2"></td>
		</tr>
	{{/xIf}}
</script>
<#include "/include/footer.ftl">
