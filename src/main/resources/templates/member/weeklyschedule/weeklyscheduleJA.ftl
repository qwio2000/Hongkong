<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit" id="titleSubj">Weekly Schedule - All</h2>
	<form id="weeklyForm" action="/ja/members/weeklyschedule" method="get">
	<div class="list02 pt20 clearfix">
		<div class="float_l">
			<span class="radio_wrap"><input type="radio" value="All" name="subj" id="subj_All" <#if subj == 'All'>checked="checked"</#if>><label class="radio_label" for="subj_All"> All</label></span>
			<#list subjs as subject>
				<span class="radio_wrap"><input type="radio" value="${subject }" name="subj" id="subj_${subject }" <#if subj = subject>checked="checked"</#if>><label class="radio_label" for="subj_${subject }"> ${subject }</label></span>
			</#list>
		</div>
		<input type="hidden" id="subject" value="All"/>
		<div class="float_r">
			<a href="javascript:window.print();" class="btn_print m0">Print</a>
		</div>
	</div>
	<div class="tbl01 tbl_schedule">
		<table>
			<colgroup>
				<col width="240" />
				<col width="120" />
				<col width="120" />
				<col width="120" />
				<col width="120" />
				<col width="120" />
				<col width="120" />
				<col width="120" />
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line">Time</th>
					<th>Sunday</th>
					<th>Monday</th>
					<th>Tuesday</th>
					<th>Wednesday</th>
					<th>Thursday</th>
					<th>Friday</th>
					<th>Saturday</th>
				</tr>
			</thead>
			<tbody id="mainContent">
				<#list scheduleInfos as info>
					<tr class="line2">
						<td class="no_line">${info.visitHoursName}</td>
						<td class="<#if info.memWeeklyInfo1 == '0'>col_gray</#if>">
							<#if info.memWeeklyInfo1 != '0'>
								<a href="#" class="btn_schedule" value="${info.visitHours},1">${info.memWeeklyInfo1}</a>
							</#if>
						</td>
						<td class="<#if info.memWeeklyInfo2 == '0'>col_gray</#if>">
							<#if info.memWeeklyInfo2 != '0'>
								<a href="#" class="btn_schedule" value="${info.visitHours},2">${info.memWeeklyInfo2}</a>
							</#if>
						</td>
						<td class="<#if info.memWeeklyInfo3 == '0'>col_gray</#if>">
							<#if info.memWeeklyInfo3 != '0'>
								<a href="#" class="btn_schedule" value="${info.visitHours},3">${info.memWeeklyInfo3}</a>
							</#if>
						</td>
						<td class="<#if info.memWeeklyInfo4 == '0'>col_gray</#if>">
							<#if info.memWeeklyInfo4 != '0'>
								<a href="#" class="btn_schedule" value="${info.visitHours},4">${info.memWeeklyInfo4}</a>
							</#if>
						</td>
						<td class="<#if info.memWeeklyInfo5 == '0'>col_gray</#if>">
							<#if info.memWeeklyInfo5 != '0'>
								<a href="#" class="btn_schedule" value="${info.visitHours},5">${info.memWeeklyInfo5}</a>
							</#if>
						</td>
						<td class="<#if info.memWeeklyInfo6 == '0'>col_gray</#if>">
							<#if info.memWeeklyInfo6 != '0'>
								<a href="#" class="btn_schedule" value="${info.visitHours},6">${info.memWeeklyInfo6}</a>
							</#if>
						</td>
						<td class="<#if info.memWeeklyInfo7 == '0'>col_gray</#if>">
							<#if info.memWeeklyInfo7 != '0'>
								<a href="#" class="btn_schedule" value="${info.visitHours},7">${info.memWeeklyInfo7}</a>
							</#if>
						</td>
					</tr>
				</#list>
			</tbody>
		</table>
		<div class="schedule_detail">
			<div class="detail_list" id="detailContent">
				
			</div>
		</div>
	</div>
	</form>
</div>
<!--// Main Content -->
<script id="weeklyScheduleDetailTemplate" type="text/x-handlebars-template">
<div class="txt_time"><strong>{{list.[0].visitHoursName}}</strong></div>
<ul>
{{#each list}}
	<li>{{deptName}}({{cnt}})</li>
{{/each}}
</ul>
</script>
<#include "/include/footer.ftl">