<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Member Report</h2>
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
				<col width="70">
				<col width="70">
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
			<td class="left"><img src="/public/img/ico_name.png" alt="" />{{memName}}</td>
			<td>{{gradeName}}</td>
			<td>{{splitStr memSubjStr 0}}</td>
			<td>{{guardianName}}</td>
			<td>{{gphone}}</td>
			<td>{{splitStr memSubjStr 1}}</td>
			<td>{{splitStr memSubjStr 2}}</td>
			<td>{{splitStr memSubjStr 3}}</td>
		</tr>
	{{else}}
		<tr>
			<td colspan="5">데이터가 없습니다.</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl">