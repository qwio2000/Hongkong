<#include "/include/header.ftl">
<!-- Main Content -->
<#assign curYear = .now?string('yyyy')>
<#assign yy = curYear?number - 1>
<div class="content">
	<h2 class="conTit">Workbook Report</h2>
	<div class="list02 pt20">
		<select name="month" id="month" style="width:162px">
			<#list months as month>
				<option value="${month.monthNum }">${month.monthStr }</option>
			</#list>
		</select>
		<select name="year" id="year" style="width:162px">
		<#list 1..3 as i>
			<option value="${yy?c }" <#if yy?c == curYear>selected</#if>>${yy?c }</option>
			<#assign yy = yy + 1>
		</#list>
		</select>
		<select name="week" id="week" style="width:350px">
			<option value="4">4 Week View</option>
			<option value="8">8 Week View</option>
		</select>
		<select name="subj" id="subj" style="width:162px">
			<option value="">All Subjects</option>
			<#list subjs as subj>
				<option value="${subj }">${subj }</option>
			</#list>
		</select>
	</div>
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
					<th>FirstName ↑ ↓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LastName ↑ ↓</th>
					<th>Grade</th>
					<th>Subject</th>
					<th>Guardian/Parent</th>
					<th>Phone</th>
					<th>Status</th>
					<th>Register</th>
					<th>Drop</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td class="left"><img src="${imgPath}/ico_name.png" alt="" />Aileen Ahn</td>
					<td>4TH</td>
					<td>ENGLISH MATH</td>
					<td>I Shil Ahn</td>
					<td>530-876-8489</td>
					<td>Avtive</td>
					<td>08/07/13</td>
					<td></td>
				</tr>
				<tr>
					<td>2</td>
					<td class="left"><img src="${imgPath}/ico_name.png" alt="" />Aileen Ahn</td>
					<td>4TH</td>
					<td>ENGLISH MATH</td>
					<td>I Shil Ahn</td>
					<td>530-876-8489</td>
					<td>Avtive</td>
					<td>08/07/13</td>
					<td></td>
				</tr>
				<tr>
					<td>3</td>
					<td class="left"><img src="${imgPath}/ico_name.png" alt="" />Aileen Ahn</td>
					<td>4TH</td>
					<td>ENGLISH MATH</td>
					<td>I Shil Ahn</td>
					<td>530-876-8489</td>
					<td>Avtive</td>
					<td>08/07/13</td>
					<td></td>
				</tr>
				<tr>
					<td>4</td>
					<td class="left"><img src="${imgPath}/ico_name.png" alt="" />Aileen Ahn</td>
					<td>4TH</td>
					<td>ENGLISH MATH</td>
					<td>I Shil Ahn</td>
					<td>530-876-8489</td>
					<td>Avtive</td>
					<td>08/07/13</td>
					<td></td>
				</tr>
				<tr>
					<td>5</td>
					<td class="left"><img src="${imgPath}/ico_name.png" alt="" />Aileen Ahn</td>
					<td>4TH</td>
					<td>ENGLISH MATH</td>
					<td>I Shil Ahn</td>
					<td>530-876-8489</td>
					<td>Avtive</td>
					<td>08/07/13</td>
					<td></td>
				</tr>
				<tr>
					<td>6</td>
					<td class="left"><img src="${imgPath}/ico_name.png" alt="" />Aileen Ahn</td>
					<td>4TH</td>
					<td>ENGLISH MATH</td>
					<td>I Shil Ahn</td>
					<td>530-876-8489</td>
					<td>Avtive</td>
					<td>08/07/13</td>
					<td></td>
				</tr>
				<tr>
					<td>7</td>
					<td class="left"><img src="${imgPath}/ico_name.png" alt="" />Aileen Ahn</td>
					<td>4TH</td>
					<td>ENGLISH MATH</td>
					<td>I Shil Ahn</td>
					<td>530-876-8489</td>
					<td>Avtive</td>
					<td>08/07/13</td>
					<td></td>
				</tr>
				<tr>
					<td>8</td>
					<td class="left"><img src="${imgPath}/ico_name.png" alt="" />Aileen Ahn</td>
					<td>4TH</td>
					<td>ENGLISH MATH</td>
					<td>I Shil Ahn</td>
					<td>530-876-8489</td>
					<td>Avtive</td>
					<td>08/07/13</td>
					<td></td>
				</tr>
				<tr>
					<td>9</td>
					<td class="left"><img src="${imgPath}/ico_name.png" alt="" />Aileen Ahn</td>
					<td>4TH</td>
					<td>ENGLISH MATH</td>
					<td>I Shil Ahn</td>
					<td>530-876-8489</td>
					<td>Avtive</td>
					<td>08/07/13</td>
					<td></td>
				</tr>
				<tr>
					<td>10</td>
					<td class="left"><img src="${imgPath}/ico_name.png" alt="" />Aileen Ahn</td>
					<td>4TH</td>
					<td>ENGLISH MATH</td>
					<td>I Shil Ahn</td>
					<td>530-876-8489</td>
					<td colspan="3">
						<div class="appoint">
							<p>Appointment</p>
							[<a href=""><span class="font_blue">Register</span></a>] [<a href=""><span class="font_blue">Free Diad</span></a>] [<a href=""><span class="font_red">Delete</span></a>]
						</div>
					</td>
				</tr>
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
				<a href="javascript:addCommentCall('{{memKey}}','{{mfstName}} {{mlstName}}')"><img src="/public/img/ico_name.png" alt="" /></a>
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
						[<a href="/fa/members/regist/new?type=&appIdx={{memAppIdx}}"><span class="font_blue">Register</span></a>] [<a href=""><span class="font_blue">Free Diad</span></a>] [<a href="javascript:deleteAppointment('{{memAppIdx}}');"><span class="font_red">Delete</span></a>]
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