<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<div class="list02 pt20 clearfix mt20">
		<div class="float_l">
		<form action="/fa/members/analysis/grade" id="analysisForm">
			<select name="searchYYMM" id="searchYYMM" style="width:162px">
			<#list YYMMs as yymm>
				<option value="${yymm }" <#if searchYYMM?default('') == yymm>selected</#if>>${yymm }</option>
			</#list>
			</select>
			<select name="subj" id="subj" style="width:162px">
				<option value="TT" <#if searchSubj?default('TT') == 'TT'>selected</#if>>ALL</option>
			<#list subjs as subj>
				<option value="${subj }" <#if searchSubj?default('TT') == subj>selected</#if>>${subj }</option>
			</#list>
			</select>
			<span class="btnArea"><a href="javascript:$('#analysisForm').submit();"><span style="width:70px">Go</span></a></span>
		</form>
		</div>
	</div>
	<h2 class="conTit">By Grade</h2>
	<div class="tbl01 tbl_w100">
		<table>
			<thead>
				<tr class="bg_gray">
					<th class="b_r">Grade</th>
					<#list byGrade as grade>
						<th>${grade.gradeCDNM }</th>
					</#list>
					<#if !byGrade?has_content><th colspan="2">No Content</th></#if>
				</tr>
			</thead>
			<tbody>
			<#assign totalCnt = 0>
				<tr>
					<td class="col_gray b_r">Count</td>
					<#list byGrade as grade>
						<td>${grade.membersCnt }</td>
					<#assign totalCnt = totalCnt + grade.membersCnt>
					</#list>
					<#if !byGrade?has_content><td colspan="2">No Content</td></#if>
				</tr>
				<tr>
					<td class="col_gray b_r">Radio</td>
					<#list byGrade as grade>
						<td>${grade.membersRate?string("##0.00") }%</td>
					</#list>
					<#if !byGrade?has_content><td colspan="2">No Content</td></#if>
				</tr>
			</tbody>
		</table>
	</div>
	<#if totalCnt gt 0 >
	<h2 class="conTit">Grades By Members</h2>
		<div id="chart-content" class="graphArea pt30" style="height: 400px;"></div>
		
	<script>
	var chart = jui.include("chart.builder");

	chart("#chart-content", {
	    axis : [{
	        x : {
	            type : "block",
	            domain : "grade"
	        },
	        y : {
	            type : "range",
	            domain : "value",
	            step : 5
	        },
	        data : [
	        <#list byGrade as grade>
	        	<#if grade_index != 0>,</#if>
	            { grade : "${grade.gradeCDNM}", value : ${grade.membersCnt} }
	       	</#list>
	        ]
	    }],
	    brush : [{
	        type : "column",
	        outerPadding : 10,
	        target : "value"
	    }]
	});
	
	</script>
	</#if>
	<#if searchSubj?default('TT') != 'TT'>
	<h2 class="conTit">By Subject Grade</h2>
	<div class="tbl01">
		<table>
			<colgroup>
				<col width="100" />
				<col />
				<col width="300" />
				<col width="300" />
			</colgroup>
			<thead>
				<tr class="line">
					<th rowspan="2" class="no_line">Num</th>
					<th rowspan="2">Level</th>
					<th colspan="2">Subject</th>
				</tr>
				<tr class="line">
					<th>Number</th>
					<th>%</th>
				</tr>
			</thead>
			<tbody>
				<#list byWbGrade as wbGrade>
				<tr class="<#if wbGrade_index == 0>total </#if>line2">
					<td class="no_line"><#if wbGrade_index != 0>${wbGrade_index }</#if></td>
					<td>${wbGrade.wbGrade }</td>
					<td>${wbGrade.subjCnt }</td>
					<td>${wbGrade.subjRate?string("##0.00") }</td>
				</tr>
				</#list>
			</tbody>
		</table>
	</div>
	</#if>
	<h2 class="conTit">By Multi Subject</h2>
	<div class="tbl01 tbl_w100">
		<table>
			<thead>
				<tr class="line">
					<th rowspan="2" class="no_line" style="width:100px">Learning<br />Center</th>
					<th rowspan="2" style="width:100px">This month's <br />sale</th>
					<th colspan="2">1 subject(s)</th>
					<th colspan="2">2 subjects</th>
					<th colspan="2">3 subjects</th>
					<th colspan="2">4 subjects</th>
					<th colspan="2">5 subjects</th>
					<th colspan="2">At least 6<br />subjects</th>
				</tr>
				<tr class="line bg_gray">
					<th>Member<br />Count</th>
					<th>%</th>
					<th>Member<br />Count</th>
					<th>%</th>
					<th>Member<br />Count</th>
					<th>%</th>
					<th>Member<br />Count</th>
					<th>%</th>
					<th>Member<br />Count</th>
					<th>%</th>
					<th>Member<br />Count</th>
					<th>%</th>
				</tr>
			</thead>
			<tbody>
				<tr class="line2">
					<td class="no_line">${multiSubj.deptName }</td>
					<td>${multiSubj.monthSale?default('0') }</td>
					<td>${multiSubj.multi1?default('0') }</td>
					<td>${multiSubj.multi1Rate?default('0')?string("##0.00") }</td>
					<td>${multiSubj.multi2?default('0') }</td>
					<td>${multiSubj.multi2Rate?default('0')?string("##0.00") }</td>
					<td>${multiSubj.multi3?default('0') }</td>
					<td>${multiSubj.multi3Rate?default('0')?string("##0.00") }</td>
					<td>${multiSubj.multi4?default('0') }</td>
					<td>${multiSubj.multi4Rate?default('0')?string("##0.00") }</td>
					<td>${multiSubj.multi5?default('0') }</td>
					<td>${multiSubj.multi5Rate?default('0')?string("##0.00") }</td>
					<td>${multiSubj.multi6?default('0') }</td>
					<td>${multiSubj.multi6Rate?default('0')?string("##0.00") }</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
