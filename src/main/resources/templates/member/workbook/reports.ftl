<#include "/include/header.ftl">
<!-- Main Content -->
<#assign curYear = .now?string('yyyy')>
<#assign curMonth = .now?string('MM')>
<#assign yy = curYear?number - 1>
<div class="content">
	<h2 class="conTit">Workbook Report</h2>
		<div class="list02 pt20 clearfix">
			<div class="float_l">
				<input type="hidden" id="pageNum" value="1"/>
				<select name="month" id="month" style="width:162px">
					<#list months as month>
						<option value="${month.monthNum }" <#if curMonth == month.monthNum>selected</#if>>${month.monthStr }</option>
					</#list>
				</select>
				<select name="year" id="year" style="width:162px">
				<#list 1..3 as i>
					<option value="${yy?c }" <#if yy?c == curYear>selected</#if>>${yy?c }</option>
					<#assign yy = yy + 1>
				</#list>
				</select>
				<select name="week" id="week" style="width:210px">
					<option value="5">5 Week View</option>
					<option value="10">10 Week View</option>
				</select>
				<select name="subj" id="subj" style="width:162px">
					<option value="">All Subjects</option>
					<#list subjs as subj>
						<option value="${subj }">${subj }</option>
					</#list>
				</select>
				<span class="btnArea"><a href="javascript:$.getWorkbookReport();"><span style="width:70px">View</span></a></span>
			</div>
			<div class="float_r">
				<a href="javascript:window.print();" class="btn_print m0">Print</a>
			</div>
		</div>
		<div class="tbl01 mt5">
			<table id="mainContent">
			</table>
		</div>
	<div class="paging">
		<span id="pageNavi"></span>
	</div>
</div>
<!--// Main Content -->
<!--//TODO Appointment 데이터 추가 시 추가 작업 필요 -->
<script id="workbookScript" type="text/x-handlebars-template">
<colgroup>
	<col width="35" />
	<col width="130" />
	<col width="50" />
	<col width="100" />
	<col width="60" />
	<col width="60" />
	<col width="60" />
	<col width="60" />
	<col width="60" />
	<col width="60" />
{{#xIf week "==" 10}}
	<col width="60" />
	<col width="60" />
	<col width="60" />
	<col width="60" />
	<col width="60" />
{{else}}
	<col />
{{/xIf}}
</colgroup>
<thead>
	<tr class="line">
		<th class="no_line"></th>
		<th>Member</th>
		<th>Grade</th>
		<th>Time</th>
		<th>Subject</th>
		<th>{{monthName.[0]}}.<br/>WK1</th>
		<th>{{monthName.[0]}}.<br/>WK2</th>
		<th>{{monthName.[0]}}.<br/>WK3</th> 
		<th>{{monthName.[0]}}.<br/>WK4</th>
		<th>{{monthName.[0]}}.<br/>WK5</th>
{{#xIf week "==" 10}}         
		<th>{{monthName.[1]}}.<br/>WK1</th>
		<th>{{monthName.[1]}}.<br/>WK2</th>
		<th>{{monthName.[1]}}.<br/>WK3</th> 
		<th>{{monthName.[1]}}.<br/>WK4</th>
		<th>{{monthName.[1]}}.<br/>WK5</th>
{{else}}
		<th></th>
{{/xIf}}
	</tr>
</thead>
<tbody>
{{#each workbooks}}
	<tr class="line2">
		<td class="no_line" rowspan="{{workbookSubjInfos.length}}">{{inc @index}}</td>
		<td class="left pl5" rowspan="{{workbookSubjInfos.length}}"><a href="/fa/members/reports/{{memKey}}" class="icon_search">{{mfstName}} {{mlstName}}</a></td>
		<td rowspan="{{workbookSubjInfos.length}}">{{gradeName}}</td>
	{{#each workbookSubjInfos}}
		{{#xIf @index "==" 0}}
			<td>{{yoilName}} {{visitHoursName}}</td>
			<td class="left pl5">
				<a href="#" class="subject_graph">{{subj}}</a>
			</td>
			<td><a href="#">{{set1}}</a></td>
			<td><a href="#">{{set2}}</a></td>
			<td><a href="#">{{set3}}</a></td>
			<td><a href="#">{{set4}}</a></td>
			<td><a href="#">{{set5}}</a></td>
			{{#xIf ../../../week "==" 10}}
				<td><a href="#">{{set6}}</a></td>
				<td><a href="#">{{set7}}</a></td>
				<td><a href="#">{{set8}}</a></td>
				<td><a href="#">{{set9}}</a></td>
				<td><a href="#">{{set10}}</a></td>
			{{else}}
				<td></td>
			{{/xIf}}
		{{else}}
			</tr>
			<tr class="line2">
				<td>{{yoilName}} {{visitHoursName}}</td>
				<td class="left pl5">
					<a href="#" class="subject_graph">{{subj}}</a>
				</td>
				<td><a href="#">{{set1}}</a></td>
				<td><a href="#">{{set2}}</a></td>
				<td><a href="#">{{set3}}</a></td>
				<td><a href="#">{{set4}}</a></td>
				<td><a href="#">{{set5}}</a></td>
				{{#xIf  ../../../week "==" 10}}
					<td><a href="#">{{set6}}</a></td>
					<td><a href="#">{{set7}}</a></td>
					<td><a href="#">{{set8}}</a></td>
					<td><a href="#">{{set9}}</a></td>
					<td><a href="#">{{set10}}</a></td>
				{{else}}
					<td></td>
				{{/xIf}}
			</tr>
		{{/xIf}}
	{{/each}}
	</tr>
{{/each}}
</tbody>
</script>
<#include "/include/footer.ftl">