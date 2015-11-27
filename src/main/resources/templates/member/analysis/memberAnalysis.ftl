<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<div class="list02 pt20 clearfix mt20">
		<div class="float_l">
		<form action="/fa/members/analysis" id="analysisForm">
			<select name="searchYYMM" id="searchYYMM" style="width:162px">
			<#list YYMMs as yymm>
				<option value="${yymm }" <#if searchYYMM == yymm>selected</#if>>${yymm }</option>
			</#list>
			</select>
			<span class="btnArea"><a href="javascript:$('#analysisForm').submit();"><span style="width:70px">Go</span></a></span>
		</form>
		</div>
	</div>
	<h2 class="conTit">Members by Month</h2>
	<div class="tbl01">
		<table>
			<colgroup>
				<col />
				<col style="width:130px" />
				<col style="width:130px" />
				<col style="width:130px" />
				<col style="width:130px" />
				<col style="width:130px" />
				<col style="width:130px" />
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line"></th>
					<th>Begin</th>
					<th>Enroll</th>
					<th>Drop</th>
					<th>End</th>
					<th>Enroll <br />Rate</th>
					<th>Drop <br />Rate</th>
				</tr>
			</thead>
			<tbody>
			<#if memberByMonths?has_content>
			<#list memberByMonths as member>
				<tr class="line2">
					<th class="no_line" style="padding-left: 0px; text-align: center;">${member.displayYYMM }</th>
					<td>${member.subjBegin }</td>
					<td>${member.subjNew }</td>
					<td>${member.subjDrop }</td>
					<td><strong>${member.subjEnd }</strong></td>
					<td>${member.subjNewRate?string("##0.00")}</td>
					<td>${member.subjDropRate?string("##0.00") }</td>
				</tr>
			</#list>
			<#else>
				<tr>
					<td colspan="7">No Contents</td>
				</tr>
			</#if>
			</tbody>
		</table>
	</div>
	<h2 class="conTit">By Subject</h2>
	<div class="clearfix">
	<div class="tbl01 float_l" style="width:500px;">
		<table>
			<colgroup>
				<col style="width:33%" />
				<col style="width:33%" />
				<col style="width:33%" />
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line">Subject</th>
					<th>Count</th>
					<th>Ratio</th>
				</tr>
			</thead>
			<tbody>
			<#list bySubject as subject>
				<tr class="line2">
					<th class="no_line" style="text-align: center;padding-left: 0px;">${subject.subj }</th>
					<td>${subject.subjEnd }</td>
					<td>${subject.subjRatio?string("##0.00") }%</td>
				</tr>
			</#list>
			<#if !bySubject?has_content>
			<tr>
				<td colspan="3">No Contents</td>
			</tr>
			</#if>
			</tbody>
		</table>
	</div>
	<div class="graphArea float_r">
		<div id="chart-content" style="width:400px;height:300px;" ></div>
	</div>
	</div>
<script>
var chart = jui.include("chart.builder");
var names = {
	<#list bySubject as subject>
		<#if subject_index != 0>
		,
		</#if>
		${subject.subj}: "${subject.subj}"
	</#list>
};
<#if bySubject?has_content>
// The SVG icon of style components can be used in chart
chart("#chart-content", {
    icon: {
        type: "jennifer",
        path: "/public/js/jui/img/icon-list.ttf"
    },
    
    padding : 50,
    axis : {
        data : [
            {
	            <#list bySubject as subject>
	        		<#if subject_index != 0>
	        		,
	        		</#if>
	        		${subject.subj}: ${subject.subjEnd}
	        	</#list>
            }
        ]
    },
    brush : {
        type : "pie",
        format : function(k, v) {
            return names[k] + ": " + v;
        },
        showText : true
    },
    widget : [
    	{
            type : "title",
            text : "Subject"
        }, {
            type : "tooltip",
            orient : "left",
            format : function(k, v) {
                return this.icon("label") + v;
            }
        }, {
            type : "legend",
            icon : "{chart}",
            format : function(k) {
                return names[k];
            }
        }
    ]
});
</#if>
</script>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
