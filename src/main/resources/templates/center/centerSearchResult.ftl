<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Centers</h2>
	<input type="hidden" id="userType" value="${loginInfo.userType }"/>
	<input type="hidden" id="pageNum" value=""/>
	<input type="hidden" id="deptName" value="${deptName}">
	<input type="hidden" id="city" value="${city}">
	<input type="hidden" id="stateCD" value="${stateCD}">
	<input type="hidden" id="statusCD" value="${statusCD}">	
	<input type="hidden" id="sortKind" value="">
	<input type="hidden" id="sort" value="">
		
	<div class="tbl01">
		<table>
			<colgroup>
				<col width="40">
				<col width="70">
				<col width="*">
				<col width="80">
				<col width="80">
				<col width="150">
				<col width="100">
				<col width="70">
				<col width="100">
			</colgroup>
			<thead>
				<tr>
					<th></th>
					<th>State</th>
					<th class="left"><a href="#btnSort" sortKind="dp.deptName" sort="">Center Name ↑↓</a><br>(contract - open date)</th>		
					<th><a href="#btnSort" sortKind="memCnt" sort="">Member ↑↓</a></th>
					<th><a href="#btnSort" sortKind="memSubjCnt" sort="">Subject ↑↓</a></th>
					<th>Director</th>
					<th>Phone</th>
					<th>Status</th>
					<th><#if statusCD == "2">Close Date</#if></th>
				</tr>
			</thead>
			<tbody id="mainContent"></tbody>
		</table>
	</div>
	<div class="paging">
		<span id="pageNavi"></span>
	</div>
</div>
<!--// Main Content -->
 
<script id="mainContentTemplate" type="text/x-handlebars-template">
	{{#each centerSearchList}}
		<tr>
			<td>{{inc @index}}</td>
			<td>{{stateName}}</td>
			<td class="left"><a title="Comments/ Call Logs" href="javascript:$.openCenterCallLog('{{deptCD}}');"><img src="${imgPath }/icon_talk.png" alt="" /></a><a href="javascript:$.goCenterView('{{deptCD}}');"><span class="font_blue">{{deptName}}</span></a><br>{{contractDate}} - {{openDate}}</td>
			<td>{{memCnt}}</td>
			<td>{{memSubjCnt}}</td>
			<td class="left">{{empName}}</td>
			<td>{{phone}}</td>
			<td>{{statusName}}</td>
			<td>
				{{#xIf statusCD "==" 1 }}
					{{#xIf userId "!=" ''}}
						<a href="javascript:$.login('{{userId}}');"><span class="font_blue">Login </span></a>
					{{/xIf}}
				{{else}}
					{{closeDate}}
				{{/xIf}}
			</td>
		</tr>
	{{else}}
		<tr>
			<td colspan="9">no search results</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl">