<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Registration</h2>
		<ul class="memSearch">
			<li>
				<label for="">Name</label>
				<input type="text"  class="searchInput" style="width:334px" id="name"/>
			</li>
			<li id="comment" class="notice_txt" style="display: none;">Provide at least 3 letters of the name (first or last name)...</li>
		</ul>
		
		<div id="mainContent" class="add_new_list">
		</div>
</div>
<!--// Main Content -->
<script id="memberRegistSearch" type="text/x-handlebars-template">
<h3 class="tit"><a href="/fa/members/regist/new?type=1"><strong>Add New Guardian </strong></a>to Start a new registration 
	<span>{{#xIf result.length ">" 0}}  -or- <font color="blue">Click "Guardian's Name"</font> to <b>add a sibling</b>
										-or- <font color="blue">Click "Student's Name"</font> to <b>add a subject</b> 
		  {{else}}<b>No record found...</b>{{/xIf}}
	</span>
</h3>
	<div class="tbl01">
		<table>
			<colgroup>
				<col width="40">
				<col width="150">
				<col width="150">
				<col width="*">
				<col width="130">
				<col width="100">
				<col width="100">
			</colgroup>
			<thead>
				<tr>
					<th></th>
					<th>Student</th>
					<th>Guardian</th>
					<th>Address</th>
					<th>City</th>
					<th>Phone</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
	{{#each result}}
		<tr>
			<td>{{inc @index}}</td>
			<td class="left"><a class="blue" href="/fa/members/regist/new?type=2&memKey={{memKey}}">{{memName}}</a></td>
			<td class="left"><a class="blue" href="/fa/members/regist/new?type=3&memKey={{memKey}}">{{guardianName}}</a></td>
			<td class="left">{{address}}</td>
			<td>{{city}}</td>
			<td>{{phone}}</td>
			<td>{{statusName}}</td>
		</tr>
	{{/each}}
			</tbody>
		</table>
	</div>
</script>
<#include "/include/footer.ftl">