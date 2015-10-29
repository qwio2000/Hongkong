<#include "/include/header.ftl">

<!-- 적용시에는 아래 라이브러리를 header 에 넣을것~ 지금은 테스트~ -->
<link rel="stylesheet" type="text/css" href="${jsPath }/Nwagon/Nwagon.css" />
<script type="text/javascript" src="${jsPath }/Nwagon/Nwagon.js"></script>

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
		<div id="Nwagon"></div>
	<!-- 지역별 가맹점 수 현황 그래프 : end  -->
	
	
	<!-- 마감과목별 가맹점 수/분포 현황 : end  -->
	
	<!-- 상품별 과목 현황 Member에 있어야 하지만 일단 샘플이니까... : str  -->
	<h3 class="conTit" style="font-size:15px;">Member by Subject</h3>
		<div id="Nwagon2"></div>
	<!-- 상품별 과목 현황 : end  -->
	
</div>
<!--// Main Content -->

<script type="text/javascript">
	// 막대그래프
	// ※ 라벨텍스트 기울기 없애려면 :  Nwagon.js 에서 Nwagon.column.drawLables 함수 안에서 attributes 라는 변수에 'transform':'rotate(315,'+ x +','+ y + ')' 삭제할것. 
	//  텍스트가 길 경우에 글씨가 겹치는걸 방지하게 위해 기울기 설정되어있음.
	// 주의 : 1. 수치 뿌릴때 eval 처리할것. 
	//		  2. 데이터 처리시 오류가 난다면, 데이터를 새로운 Array 에 담아서 처리해볼것.
	var data = [50,70,20,44,62,31,5,2,80,0,0,10];
	var names = ['EunJeong','HanSol','InSook','Eom','Pearl','SeungMin','TJ','Taegyu','YongYong','YongYong','YongYong','YongYong'];
	var options = {
		'legend': {
			names: names
		},
		'dataset': {
			title: 'Centers by State',
			values: data,
			colorset: ['#001A7F', '#5586EB', "#9DCEFF"]
			// 참고 : 수치에 따라 색상이 변경 되도록 설정 된다.
		},
		'chartDiv': 'Nwagon',
		'chartType': 'column',
		'chartSize': { width: 900, height: 300 },
		'maxValue': 100,
		'increment': 20
	};
	Nwagon.chart(options);	
	
	
	//원형차트
	options = {
		'dataset':{
			title: 'Member by Subject',
			values:[35, 3 , 10, 0],
			colorset: ['#004C63', '#008299', "#6CEEFF", '#B4FFFF'],
			fields: ['MATH', 'KOREAN',  'PS MATH', 'READING'],
		},
		'donut_width' : 35,
		'core_circle_radius':50,
		'chartDiv': 'Nwagon2',
		'chartType': 'donut',
		//'chartType': 'pie',  //속 차있는 원형차트
		'chartSize': {width:700, height:400}
	};
	Nwagon.chart(options);
	
	
	

	
	
</script>
<#include "/include/footer.ftl">
