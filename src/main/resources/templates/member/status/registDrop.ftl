<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit" id="yymm">Register / Drop Analysis : (${.now?string("MMM") } ${.now?string("yyyy") })</h2>
	<div class="list02 pt20 clearfix">
		<input type="hidden" id="pageNum" value="1"/>
		<div class="float_l">
			<select name="searchYYMM" id="searchYYMM" style="width:162px">
			<#list searchYYMM as yymm>
				<option value="${yymm }">${yymm }</option>
			</#list>
			</select>
			<span class="btnArea"><a id="searchBtn" style="cursor: pointer;"><span style="width:70px">Go</span></a></span>
		</div>
	</div>
	<div class="tbl01 mt5">
		<table>
			<colgroup>
				<col width="80" />
				<col />
				<col width="120" />
				<col width="160" />
				<col width="300" />
			</colgroup>
			<thead>
				<tr>
					<th class="no_line">No</th>
					<th>Date</th>
					<th>Type</th>
					<th>Subject</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody id="mainContent">
			</tbody>
		</table>
	</div>
	<div class="paging">
		<span id="pageNavi"></span>
	</div>
</div>
<!--// Main Content -->
<script id="memberStatusTemplate" type="text/x-handlebars-template">
{{#each list}}
	<tr>
		<td class="no_line">{{inc @index}}</td>
		<td class="pl5">{{convDate}}</td>
		<td>{{type}}</td>
		<td>{{subj}}</td>
		<td class="pl5">{{memName}}</td>
	</tr>
{{else}}
	<tr>
		<td colspan="5">no search results</td>
	</tr>
{{/each}}
</script>
<#include "/include/footer.ftl">
