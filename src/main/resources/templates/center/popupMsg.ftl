<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Pop-up Messages</h2>
	<input type="hidden" id="pageNum" value="1"/>
	<div class="clearfix pb10 pt30">
		<div class="float_l">
			<div class="btnArea_txt p0"><a href="javascript:;" onClick="$.goPopUpMsgRegist();" class="btn_doc m0">Add New</a></div>
		</div>
	</div>
	<div class="tbl01 m0">
		<table>
			<colgroup>
				<col width="40">
				<col width="200">
				<col width="*">
				<col width="30">
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line"></th>
					<th>Date</th>
					<th>Message Title</th>
					<th class="no_line"></th>
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
	{{#each popMsgList}}
		<tr>
			<td>{{inc @index}}</td>
			<td>{{startYMD}}~{{endYMD}}</td>
			<td class="left"><a href="javascript:$.goPopUpMsgView('{{idx}}')" >{{msgTitle}}</a></td>
			<td><a href="javascript:$.deletePopUpMsg('{{idx}}')" class="btn_delete">Del</a></td>
		</tr>
	{{else}}
		<tr>
			<td colspan="4">no search results</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl">