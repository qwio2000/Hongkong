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

		<div class="add_new_list">
			<h3 class="tit"><strong>Add New Guardian </strong>to Start a new registration</h3> <span>No record found...</span>
		</div>
</div>
<!--// Main Content -->
<script id="memberRegistSearch" type="text/x-handlebars-template">
	{{#each result}}
		<tr>
			<td>{{inc @index}}</td>
			<td class="left"><img src="/public/img/ico_name.png" alt="" />{{mfstName}}{{mlstName}}</td>
			<td>{{gradeName}}</td>
			<td>{{splitSubj memSubjStr}}</td>
			<td>{{guardianName}}</td>
			<td>{{gphone}}</td>
			{{#xIf statusCD "==" 3}}
				<td colspan="3">
					<div class="appoint">
						<p>{{statusName}}</p>
						[<a href="#"><span class="font_blue">Register</span></a>] [<a href=""><span class="font_blue">Free Diad</span></a>] [<a href=""><span class="font_red">Delete</span></a>]
					</div>
				</td>
			{{else}}
				<td>{{statusName}}</td>
				<td>{{registFstYMD}}</td>
				<td>{{dropFnlYMD}}</td>
			{{/xIf}}
		</tr>
	{{else}}
		<tr>
			<td colspan="9">no search results</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl">