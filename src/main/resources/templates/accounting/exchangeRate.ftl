<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<div class="clearfix">
		<div class="conLeft">
			<h2 class="conTit">Exchange Rate</h2>
			<form id="searchForm" name="searchForm" action="" method="">			
			<div class="list02 pt20 clearfix">
				<div class="float_l">
					<select name="selYY" id="selYY" style="width:100px">
						<#list selYY?number..selYY?number-2 as i>
							<option value="${i?c }" <#if i == selYY?number>selected</#if>>${i?c }</option>
						</#list>				
					</select>
					<span class="btnArea"><a id="searchSubmit" href="javascript:;"><span style="width:70px">Search</span></a></span>
				</div>
			</div>
			</form>
			<div class="tbl01 tbl_report">
				<table>
					<colgroup>
						<col style="width:130px" />
						<col />
						<col />
					</colgroup>
					<thead>
						<tr class="line">
							<th class="no_line">Month</th>
							<th>CNY</th>
							<th>SGD</th>
						</tr>
					</thead>
					<tbody id="mainContent"></tbody>
				</table>
			</div>
			<br />
			<#if currentYear == selYY>
			<div  id="exchangeRateRegist">
			<h2>Regist/Edit</h2>						
			<div class="tbl01 tbl_report">
				<form id="exchangeRateForm" name="exchangeRateForm" action="" method="">			
				<table>
					<colgroup>
						<col style="width:130px" />
						<col />
						<col />
					</colgroup>
					<thead>
						<tr>
							<th class="no_line">Month</th>
							<th>CNY</th>
							<th>SGD</th>
						</tr>
					</thead>
					<tbody>
						<tr class="line2">
							<td class="no_line">${currentMonthName?default('') }</td>
							<td><input type="text" name="cny" id="cny" onKeyUp="$.numericDecimalCheck();" class="searchInput" style="width:100px" maxlength="5" /></td>
							<td><input type="text" name="sgd" id="sgd" onKeyUp="$.numericDecimalCheck();" class="searchInput" style="width:100px" maxlength="5" /></td>
						</tr>
					</tbody>
				</table>
				</form>
			</div>
			<br />
			<span class="btnArea"><a id="saveExchangeRate" href="javascript:;"><span style="width:70px">Save</span></a></span>
			</div>
			</#if >			
		</div>
	</div>

</div>

<!--// Main Content -->
<script id="mainContentTemplate" type="text/x-handlebars-template">
	{{#each exchangeRateList}}
		<tr class="line2">
			<td class="no_line">{{mmName}}</td>
			<td>{{cny}}</td>
			<td>{{sgd}}</td>
		</tr>
	{{else}}
		<tr>
			<td colspan="3">no search results</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl">
