<#include "/include/header.ftl">
<#macro zeroNonDisplay arg>
	<#if arg != 0>
		${arg }
	</#if>
</#macro>
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Drop Analysis (Year ${searchYY?default(.now?string("yyyy")) })</h2>
	<form id="dropAnalysisForm" action="/ja/members/analysis/drop" method="get">
	<div class="list02 pt20 clearfix">
		<div class="float_l">
			<select name="searchYY" id="searchYY" style="width:162px">
				<#list years as year>
					<option value="${year }" <#if year == searchYY?default(.now?string("yyyy"))>selected</#if>>${year }</option>
				</#list>
			</select>
			<span class="btnArea mt0"><a href="javascript:$('#dropAnalysisForm').submit();"><span style="width:70px">Go</span></a></span>
		</div>
	</div>
	</form>
	<#if drops?reverse[0].totalDrop gt 0 >
	<div id="chart-content" class="graphArea pt10" style="height: 400px;"></div>
	<script>
	
	var chart = jui.include("chart.builder");

	chart("#chart-content", {
	    axis : [{
	        x : {
	            type : "block",
	            domain : [ 
	                      	<#list dropReasons as reason>
			      	        	<#if reason_index != 0>,</#if>
			      	            "${reason.dtlCDNM}"
		      	       		</#list>
	                      ],
	            textRotate : function(chart, grid){ return -8;},
	            line : true,
	            orient : "Right"
	        },
	        y : {
	            type : "range",
	            domain : [ 0, 100],
	            step : 5
	        },
	        data : [
	            { value : ${drops?reverse[0].dropCnt01} },
	            { value : ${drops?reverse[0].dropCnt02} },
	            { value : ${drops?reverse[0].dropCnt03} },
	            { value : ${drops?reverse[0].dropCnt04} },
	            { value : ${drops?reverse[0].dropCnt05} },
	            { value : ${drops?reverse[0].dropCnt06} },
	            { value : ${drops?reverse[0].dropCnt07} },
	            { value : ${drops?reverse[0].dropCnt08} },
	            { value : ${drops?reverse[0].dropCnt09} },
	            { value : ${drops?reverse[0].dropCnt10} },
	        ]
	    }],
	    brush : [{
	        type : "column",
	        outerPadding : 20,
	        target : "value"
	    }]
	});
	</script>
	</#if>
	<div class="tbl01">
		<table>
			<colgroup>
				<col />
				<col style="width:75px" />
				<col style="width:75px" />
				<col style="width:75px" />
				<col style="width:75px" />
				<col style="width:75px" />
				<col style="width:75px" />
				<col style="width:75px" />
				<col style="width:75px" />
				<col style="width:75px" />
				<col style="width:75px" />
				<col style="width:75px" />
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line">Center Name</th>
					<#list dropReasons as reason>
						<th>${reason.dtlCDNM }</th>
					</#list>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<#list drops as drop>
				<#if drop?has_next>
				<tr class="line2">
					<td class="left pl10 no_line"><a href="javascript:dropDetail('${searchYY?default(.now?string('yyyy')) }','${drop.deptCD }','${drop.deptName }');">${drop.deptName }</a></td>
					<td><@zeroNonDisplay drop.dropCnt01 /></td>
					<td><@zeroNonDisplay drop.dropCnt02 /></td>
					<td><@zeroNonDisplay drop.dropCnt03 /></td>
					<td><@zeroNonDisplay drop.dropCnt04 /></td>
					<td><@zeroNonDisplay drop.dropCnt05 /></td>
					<td><@zeroNonDisplay drop.dropCnt06 /></td>
					<td><@zeroNonDisplay drop.dropCnt07 /></td>
					<td><@zeroNonDisplay drop.dropCnt08 /></td>
					<td><@zeroNonDisplay drop.dropCnt09 /></td>
					<td><@zeroNonDisplay drop.dropCnt10 /></td>
					<td><@zeroNonDisplay drop.totalDrop /></td>
				</tr>
				<#else>
					<tr class="total line2">
						<td class="no_line">${drop.deptName }</td>
						<td>${drop.dropCnt01 }</td>
						<td>${drop.dropCnt02 }</td>
						<td>${drop.dropCnt03 }</td>
						<td>${drop.dropCnt04 }</td>
						<td>${drop.dropCnt05 }</td>
						<td>${drop.dropCnt06 }</td>
						<td>${drop.dropCnt07 }</td>
						<td>${drop.dropCnt08 }</td>
						<td>${drop.dropCnt09 }</td>
						<td>${drop.dropCnt10 }</td>
						<td>${drop.totalDrop }</td>
					</tr>
				</#if>
				</#list>
			</tbody>

		</table>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
