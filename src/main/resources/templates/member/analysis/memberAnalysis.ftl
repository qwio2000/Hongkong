<#include "/include/header.ftl">
<!-- Main Content -->
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
						<th>${grade.countOfGrades }</th>
					</#list>
				</tr>
				<tr>
					<td class="col_gray b_r">Radio</td>
					<#list analysisByGrade as grade>
						<th>${grade.ratio }%</th>
					</#list>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="graphArea pt30">
		<img src="${imgPath}/temp/graph01.jpg" alt="" />
	</div>
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
