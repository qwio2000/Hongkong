<#include "/include/header.ftl">

<!-- 적용시에는 아래 라이브러리를 header 에 넣을것~ 지금은 테스트~ -->
<script type="text/javascript" src="${jsPath }/jui/jui.chart.min.js"></script>

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Centers Analysis</h2>
	
	<!-- 마감과목별 가맹점 수/분포 현황 : str  -->
	<h3 class="conTit" style="font-size:15px;">Centers by Subject Numbers</h3><br/>
	<div class="tbl01 mt0">
		<table>
			<colgroup>
				<col width="170px" />
				<col />
			</colgroup>
			<tbody>
			<tr class="line2">
				<th rowspan="2" class="no_line">
					subject
				</th>
				<th colspan="12">2014</th>
			</tr>
			<tr class="line2">
				<th>Jan</th>
				<th>Feb</th>
				<th>Mar</th>
				<th>Apr</th>
				<th>May</th>
				<th>Jun</th>
				<th>Jul</th>
				<th>Aug</th>
				<th>Sep</th>
				<th>Oct</th>
				<th>Nov</th>
				<th>Dec</th>
			</tr>
			<tr class="line2">
				<th class="no_line">0-40</th>
				<td>31</td>
				<td>31</td>
				<td>31</td>
				<td>31</td>
				<td>31</td>
				<td>31</td>
				<td>31</td>
				<td>31</td>
				<td>31</td>
				<td>31</td>
				<td>31</td>
				<td>31</td>
			</tr>
				
			</tbody>
		</table>	
	
	</div>
	<!-- 마감과목별 가맹점 수/분포 현황 : end  -->
	
	<!-- 지역별 가맹점 수 현황 그래프 : str  -->
	<h3 class="conTit" style="font-size:15px;">Centers by State</h3>
	<div id="chart-content" style="height:400px; ">
	
	</div>
	<!-- 지역별 가맹점 수 현황 그래프 : end  -->
	
</div>
<!--// Main Content -->

<script type="text/javascript">

	var chart = jui.include("chart.builder");
	chart("#chart-content", {
	    axis : {
	        x : {
	            type : "block",
	            domain : [ "AB", "BC", "CD", "EF", "BC", "CD", "EF", "BC", "CD", "EF" ]
	        },
	        y : {
	            type : "range",
	            domain : "total"
	        },
	        c : {
	            type : "grid3d"
	        },
	        data : [
	            { total: 20 },
	            { total: 15 },
	            { total: 15 },
	            { total: 15 },
	            { total: 15 },
	            { total: 5 },
	            { total: 5 },
	            { total: 5 },
	            { total: 5 },
	            { total: 18 }
	        ],
	        depth : 20,
	        degree : 30
	    },
	    brush : {
	        type : "column3d",
	        outerPadding : 10,
	        innerPadding : 5 ,
	        colors : [("#486AAE")]
	    },
	    widget : [{
	        type : "tooltip"
	    }]
	});
		
</script>
<#include "/include/footer.ftl">
