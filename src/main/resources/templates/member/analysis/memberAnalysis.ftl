<#include "/include/header.ftl">
<!-- Main Content -->
<!-- 적용시에는 아래 라이브러리를 header 에 넣을것~ 지금은 테스트~ -->
<link rel="stylesheet" type="text/css" href="${jsPath }/Nwagon/Nwagon.css" />
<script type="text/javascript" src="${jsPath }/Nwagon/Nwagon.js"></script>
<div class="content">
	<h2 class="conTit">By Grade</h2>
	<div class="tbl01 tbl_w100">
		<table>
			<thead>
				<tr class="bg_gray">
					<th class="b_r">Grade</th>
					<#list analysisByGrade as grade>
						<th>${grade.dtlCDNM }</th>
					</#list>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="col_gray b_r">Count</td>
					<#list analysisByGrade as grade>
						<td>${grade.countOfGrades }</td>
					</#list>
				</tr>
				<tr>
					<td class="col_gray b_r">Radio</td>
					<#list analysisByGrade as grade>
						<td>${grade.ratio }%</td>
					</#list>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- 등급별 회원 수 현황 그래프 : str  -->
	<h2 class="conTit">Grades By Members</h2>
		<div id="gradesByMembers" class="graphArea pt30"></div>
	<!-- 등급별 회원 수 현황 그래프 : end  -->
	<script type="text/javascript">
	// 막대그래프
	// ※ 라벨텍스트 기울기 없애려면 :  Nwagon.js 에서 Nwagon.column.drawLables 함수 안에서 attributes 라는 변수에 'transform':'rotate(315,'+ x +','+ y + ')' 삭제할것. 
	//  텍스트가 길 경우에 글씨가 겹치는걸 방지하게 위해 기울기 설정되어있음.
	// 주의 : 1. 수치 뿌릴때 eval 처리할것. 
	//		  2. 데이터 처리시 오류가 난다면, 데이터를 새로운 Array 에 담아서 처리해볼것.
	var data = [<#list analysisByGrade as grade><#if grade_index != 0>,</#if>${grade.countOfGrades?number }</#list>];
	var names = [<#list analysisByGrade as grade><#if grade_index != 0>,</#if>'${grade.dtlCDNM }'</#list>];
	var options = {
		'legend': {
			names: names
		},
		'dataset': {
			title: 'Grades by Members',
			values: data,
			colorset: ['#5586EB']
		},
		'chartDiv': 'gradesByMembers',
		'chartType': 'column',
		'chartSize': { width: 960, height: 365 },
		'increment': 5
	};
	Nwagon.chart(options);	
	</script>
	<div class="tbl01">
		<table>
			<colgroup>
				<col width="100" />
				<col />
				<col width="230" />
				<col width="230" />
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
				<tr class="total line2">
					<td class="no_line"></td>
					<td>Total</td>
					<td>14</td>
					<td>100</td>
				</tr>
				<tr class="line2">
					<td  class="no_line">1</td>
					<td>A</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="line2">
					<td  class="no_line">2</td>
					<td>B</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="line2">
					<td  class="no_line">3</td>
					<td>C</td>
					<td>0</td>
					<td>0</td>
				</tr>
			</tbody>
		</table>
	</div>
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
					<td class="no_line">HQ</td>
					<td>36</td>
					<td>29</td>
					<td>80.56</td>
					<td>7</td>
					<td>19.44</td>
					<td>0</td>
					<td>0.00</td>
					<td>0</td>
					<td>0.00</td>
					<td>0</td>
					<td>0.00</td>
					<td>0</td>
					<td>0.00</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
