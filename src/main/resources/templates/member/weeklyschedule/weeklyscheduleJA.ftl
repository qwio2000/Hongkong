<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit" id="titleSubj">Weekly Schedule - All</h2>
		<div class="list02 pt20 clearfix">
			<div class="float_l">
				<span class="radio_wrap"><input type="radio" value="All" name="subj" id="subj_All" checked="checked"><label class="radio_label" for="subj_All"> All</label></span>
				<#list subjs as subj>
					<span class="radio_wrap"><input type="radio" value="${subj }" name="subj" id="subj_${subj }"><label class="radio_label" for="subj_${subj }"> ${subj }</label></span>
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
				</tbody>
			</table>
		</div>
</div>
<!--// Main Content -->
<script id="weeklyScheduleTemplate" type="text/x-handlebars-template">
{{#each scheduleInfos}}
	<tr class="line2">
		<td class="no_line">{{visitHoursName}}</td>

		<td class="{{#xIf memWeeklyInfo1 "==" "0"}}col_gray{{/xIf}}">
			{{#xIf memWeeklyInfo1 "!=" "0"}}
				{{memWeeklyInfo1}}
			{{/xIf}}
		</td>
		<td class="{{#xIf memWeeklyInfo2 "==" "0"}}col_gray{{/xIf}}">
			{{#xIf memWeeklyInfo2 "!=" "0"}}
				{{memWeeklyInfo2}}
			{{/xIf}}
		</td>
		<td class="{{#xIf memWeeklyInfo3 "==" "0"}}col_gray{{/xIf}}">
			{{#xIf memWeeklyInfo3 "!=" "0"}}
				{{memWeeklyInfo3}}
			{{/xIf}}
		</td>
		<td class="{{#xIf memWeeklyInfo4 "==" "0"}}col_gray{{/xIf}}">
			{{#xIf memWeeklyInfo4 "!=" "0"}}
				{{memWeeklyInfo4}}
			{{/xIf}}
		</td>
		<td class="{{#xIf memWeeklyInfo5 "==" "0"}}col_gray{{/xIf}}">
			{{#xIf memWeeklyInfo5 "!=" "0"}}
				{{memWeeklyInfo5}}
			{{/xIf}}
		</td>
		<td class="{{#xIf memWeeklyInfo6 "==" "0"}}col_gray{{/xIf}}">
			{{#xIf memWeeklyInfo6 "!=" "0"}}
				{{memWeeklyInfo6}}
			{{/xIf}}
		</td>
		<td class="{{#xIf memWeeklyInfo7 "==" "0"}}col_gray{{/xIf}}">
			{{#xIf memWeeklyInfo7 "!=" "0"}}
				{{memWeeklyInfo7}}
			{{/xIf}}
		</td>
	</tr>
{{/each}}
</script>
<#include "/include/footer.ftl">