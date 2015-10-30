<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Free Enrollment Term</h2>		
	<input type="hidden" id="pageNum" value="1"/>	
	<div class="clearfix pb10 pt30">
		<div class="float_l">
			<div class="btnArea_txt p0"><a href="javascript:;" onClick="$.goFreeEnrollRegist();" class="btn_doc m0">Add New</a></div>
		</div>
	</div>		
	<div class="tbl01 m0">
		<table>
			<colgroup>
				<col width="40">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="150">
				<col width="*">
				<col width="40">
			</colgroup>
			<thead>
				<tr>
					<th></th>
					<th>Reg. Date</th>
					<th>From</th>
					<th>To</th>
					<th>Event Name</th>
					<th>Event Title</th>
					<th></th>
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
	{{#each freeEnrollmentTermList}}
		<tr>
			<td>{{inc @index}}</td>
			<td>{{regDateConv}}</td>
			<td>{{startYMD}}</td>
			<td>{{endYMD}}</td>
			<td>{{freeTypeName}}</td>
			<td class="left"><a href="javascript:$.goFreeEnrollView('{{idx}}')" >{{freeTitle}}</a></td>
			<td>
				{{#xIf delFlag "==" 'Y' }}
					<a href="javascript:$.deleteFreeEnrollmentTerm('{{idx}}')" class="btn_delete">Del</a>
				{{/xIf}}
			</td>
		</tr>
	{{else}}
		<tr>
			<td colspan="7">no search results</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl">