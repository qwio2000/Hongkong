<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Royalty Report</h2>
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
			<span class="btnArea"><a id="royaltyReportSearchSubmit" href="javascript:;"><span style="width:70px">View</span></a> <a id="royaltyReportSearchInit" href="javascript:;"><span style="width:70px">Reset</span></a></span>
		</div>
		</form>

		<div class="float_r">
			<a href="#" class="btn_print m0">Print</a>
		</div>
	</div>
	<div class="tbl01 tbl_report">
		<table>
			<colgroup>
				<col style="width:40px" />
				<col />
				<col style="width:85px" />
				<col style="width:85px" />
				<col style="width:85px" />
				<col style="width:85px" />
				<col style="width:85px" />
				<col style="width:85px" />
				<col style="width:85px" />
				<col style="width:85px" />
				<col style="width:85px" />
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line">State</th>
					<th>Center<!-- div class="all"><span class="chk_s01"><input type="checkbox" name="chkAll" id="chkAll" onClick="javascript:$.check_all('chkAll','chk');" ><label for="chkAll"><strong>Center</strong></label></span></div --></th>
					<th>Previous <br />Balance</th>
					<th>Payment</th>
					<th>Current <br />Balence</th>
					<th>Royalty</th>
					<th>Charge</th>
					<th>Freight</th>
					<th>Late Fee</th>
					<th>Other</th>
					<th>Total <br />Charge</th>
				</tr>
			</thead>
			<tbody id="mainContent"></tbody>
		</table>
		<!-- 세부내역 레이어 팝업-->
		<div  class="report_detail" style="display:none;" id="chargeDetailContent"></div>
		<!-- //세부내역 -->		
	</div>

</div>

<!--// Main Content -->

<!-- 세부내역 레이어 팝업-->
<script id="chargeDetailContentTemplate" type="text/x-handlebars-template">
	<div class="detail_list">
		{{#each recordChargeList}}
		<div class="txt_date">{{chargeYMD}} : {{amount}}</div>
		<ul>
			<li class="line">{{memo}}</li>
		</ul>
		{{/each}}
	</div>
</script>
<!-- //세부내역 -->
<script id="mainContentTemplate" type="text/x-handlebars-template">
	{{#each royaltyReportList}}
		<tr class="line2">
			<td class="no_line">{{stateName}}</td>
			<td class="left pl10">
				<!-- span class="chk_s01"><input type="checkbox" name="chk"  id="chk_{{deptCD}}" value="{{deptCD}}" ><label for="chk_{{deptCD}}"><a href="javascript:;" onClick="$.openRoyaltyReport('{{deptCD}}','{{mgYY}}','');" class="click">{{deptName}}</a></label></span -->
				<a href="javascript:;" onClick="$.openRoyaltyReport('{{deptCD}}','{{mgYY}}','');" class="click">{{deptName}}</a>
			</td>
			<td>{{prevBalance}}</td>
			<td>{{payment}}</td>
			<td>{{currBalance}}</td>
			<td><a href="javascript:;" onClick="$.openRoyaltyView('{{deptCD}}','{{mgYY}}','{{mgMM}}');" class="click">{{royalty}}</a></td>
			<td><a href="javascript:;" onMouseOver="$.getChargeDetailOfRoyaltyReport('{{deptCD}}','{{mgYY}}','{{mgMM}}','02');" class="btn_report">{{itemCharge}}</a></td>
			<td class="gray">{{freight}}</td>
			<td class="gray">{{lateFee}}</td>
			<td><a href="javascript:;" onMouseOver="$.getChargeDetailOfRoyaltyReport('{{deptCD}}','{{mgYY}}','{{mgMM}}','05');" class="btn_report">{{otherCreditDebit}}</a></td>
			<td>{{totalCharge}}</td>
		</tr>
	{{else}}
		<tr>
			<td colspan="11">no search results</td>
		</tr>
	{{/each}}
	{{#each royaltyReportTot}}
		<tr class="total line2">
			<td colspan="2" class="no_line">TOTAL</td>
			<td>{{prevBalance}}</td>
			<td>{{payment}}</td>
			<td>{{currBalance}}</td>
			<td>{{royalty}}</td>
			<td>{{chargeItem}}</td>
			<td>{{freight}}</td>
			<td>{{lateFee}}</td>
			<td>{{otherCreditDebit}}</td>
			<td>{{totalCharge}}</td>
		</tr>
	{{/each}}
</script>

<#include "/include/footer.ftl">
