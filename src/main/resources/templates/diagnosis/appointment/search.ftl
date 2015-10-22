<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">New Appointment > Search Member</h2>
		<ul class="memSearch">
			<li>
				<label for="name">Name</label>
				<input type="text"  class="searchInput" style="width:334px" id="name" id="name"/>
			</li>
			<li id="comment" class="notice_txt" style="display: none;">Provide at least 3 letters of the name (first or last name)...</li>
		</ul>
		
		<div id="mainContent" class="add_new_list">
		</div>
</div>
<!--// Main Content -->
<script id="memAppointmentTemplate" type="text/x-handlebars-template">
<h3 class="tit"><a href="/fa/diagnosis/appointment/new?type=01"><strong>Add New Guardian </strong></a> 
	<span>{{#xIf appointments.length ">" 0}}  -or- <font color="blue">Click "Guardian's Name"</font> to <b>add a sibling</b>
										-or- <font color="blue">Click "Student's Name"</font> to <b>add a subject</b> 
		  {{else}}<b>No record found...</b>{{/xIf}}
	</span>
</h3>
	<div class="tbl01">
		<table>
			<colgroup>
				<col width="40">
				<col width="200">
				<col width="200">
				<col width="*">
				<col width="130">
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
				</tr>
			</thead>
			<tbody>
	{{#each appointments}}
		<tr>
			<td>{{inc @index}}</td>
			<td class="left"><a class="blue" href="/fa/diagnosis/appointment/new?type=03&idx={{idx}}">{{mfstName}} {{mlstName}}</a></td>
			<td class="left"><a class="blue" href="/fa/diagnosis/appointment/new?type=04&idx={{idx}}">{{gfstName}} {{glstName}}</a></td>
			<td class="left">{{addr}}</td>
			<td>{{city}}</td>
			<td>{{gphone}}</td>
		</tr>
	{{/each}}
			</tbody>
		</table>
	</div>
</script>
<#include "/include/footer.ftl">