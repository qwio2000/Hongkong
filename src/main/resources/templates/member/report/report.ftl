<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Member Report</h2>
	<input type="hidden" id="memberStatus" value="${memberSearch.memberStatus?default('1') }"/>
	<input type="hidden" id="lastName" value="${memberSearch.lastName?default('') }"/>
	<input type="hidden" id="firstName" value="${memberSearch.firstName?default('') }"/>
	<input type="hidden" id="homePhone" value="${memberSearch.homePhone?default('') }"/>
	<input type="hidden" id="cellPhone" value="${memberSearch.cellPhone?default('') }"/>
	<input type="hidden" id="email" value="${memberSearch.email?default('') }"/>
	<input type="hidden" id="grade" value="${memberSearch.grade?default('') }"/>
	<input type="hidden" id="subject" value="${memberSearch.subject?default('') }"/>
	<input type="hidden" id="classDay" value="${memberSearch.classDay?default('') }"/>
	<input type="hidden" id="pageNum" value="1"/>
	<input type="hidden" id="orderBy" value=""/>
	<input type="hidden" id="direction" value=""/>
	<div class="tbl01">
		<table>
			<colgroup>
				<col width="40">
				<col width="*">
				<col width="70">
				<col width="130">
				<col width="130">
				<col width="90">
				<col width="90">
				<col width="90">
				<col width="110">
			</colgroup>
			<thead>
				<tr>
					<th></th>
					<th>
						FirstName<a href="#btnSort" sortKind="a.mFstName" sort=""> ↑↓</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						LastName<a href="#btnSort" sortKind="a.mLstName" sort=""> ↑↓</a>
					</th>
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
<!--//TODO Appointment 데이터 추가 시 추가 작업 필요 -->
<script id="memberReportTemplate" type="text/x-handlebars-template">
	{{#each members}}
		<tr>
			<td>{{inc @index}}</td>
			<td class="left">
				<a href="javascript:addCommentCall('{{memKey}}','{{mfstName}} {{mlstName}}')"><img src="{{imgPath}}/ico_name.png" alt="" /></a>
				{{#xIf statusCD "!=" 3}}<a class="blue" href="/fa/members/reports/{{memKey}}">{{/xIf}}
				{{mfstName}} {{mlstName}}
				{{#xIf statusCD "!=" 3}}</a>{{/xIf}}
			</td>
			<td>{{gradeName}}</td>
			<td>{{splitSubj memSubjStr}}</td>
			<td>{{guardianName}}</td>
			<td>{{gphone}}</td>
			{{#xIf statusCD "==" 3}}
				<td colspan="3">
					<div class="appoint">
						<p>{{statusName}}</p>
						[<a href="/fa/members/regist/new?type=&appIdx={{memAppIdx}}"><span class="font_blue">Register</span></a>] 
						[<a href="javascript:addFreeDiagOtherSubj('{{memAppIdx}}','2');"><span class="font_blue">Free Diad</span></a>] 
						[<a href="javascript:deleteAppointment('{{memAppIdx}}');"><span class="font_red">Delete</span></a>]
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