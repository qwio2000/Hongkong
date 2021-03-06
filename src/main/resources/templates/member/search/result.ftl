<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Member Search</h2>
	<input type="hidden" id="centerName" value="${memberSearch.centerName?default('') }"/>
	<input type="hidden" id="centerCity" value="${memberSearch.centerCity?default('') }"/>
	<input type="hidden" id="centerState" value="${memberSearch.centerState?default('') }"/>
	<input type="hidden" id="centerZipcode" value="${memberSearch.centerZipcode?default('') }"/>
	<input type="hidden" id="memberStatus" value="${memberSearch.memberStatus?default('') }"/>
	<input type="hidden" id="lastName" value="${memberSearch.lastName?default('') }"/>
	<input type="hidden" id="firstName" value="${memberSearch.firstName?default('') }"/>
	<input type="hidden" id="homePhone" value="${memberSearch.homePhone?default('') }"/>
	<input type="hidden" id="cellPhone" value="${memberSearch.cellPhone?default('') }"/>
	<input type="hidden" id="email" value="${memberSearch.email?default('') }"/>
	<input type="hidden" id="grade" value="${memberSearch.grade?default('') }"/>
	<input type="hidden" id="subject" value="${memberSearch.subject?default('') }"/>
	<input type="hidden" id="classDay" value="${memberSearch.classDay?default('') }"/>
	<input type="hidden" id="pageNum" value="1"/>
	<div class="tbl01">
		<table>
			<colgroup>
				<col width="40">
				<col width="90">
				<col width="60">
				<col width="*">
				<col width="60">
				<col width="60">
				<col width="120">
				<col width="90">
				<col width="90">
				<col width="90">
				<col width="90">
			</colgroup>
			<thead>
				<tr>
					<th></th>
					<th>State</th>
					<th>Center</th>
					<th>Member</th>
					<th>Grade</th>
					<th>Subject</th>
					<th>Guardian/Parent</th>
					<th>Phone</th>
					<th>Status</th>
					<th>Register</th>
					<th>Drop</th>
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
<script id="memberReportTemplate" type="text/x-handlebars-template">
	{{#each members}}
		<tr>
			<td>{{inc @index}}</td>
			<td>{{stateName}}</td>
			<td>{{deptName}}</td>
			<td class="left"><a href="javascript:addCommentCall('{{memKey}}','{{mfstName}} {{mlstName}}')"><img src="{{imgPath}}/ico_name.png" alt="" /></a><a class="blue" href="/ja/members/search/{{memKey}}">{{mfstName}} {{mlstName}}</a></td>
			<td>{{gradeName}}</td>
			<td>{{splitSubj memSubjStr}}</td>
			<td class="left">{{guardianName}}</td>
			<td>{{gphone}}</td>
			<td>{{statusName}}</td>
			<td>{{registFstYMD}}</td>
			<td>{{dropFnlYMD}}</td>
		</tr>
	{{else}}
		<tr>
			<td colspan="11">no search results</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl">