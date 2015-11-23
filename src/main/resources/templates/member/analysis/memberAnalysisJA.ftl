<#include "/include/header.ftl">
<!-- Main Content -->
<!-- 적용시에는 아래 라이브러리를 header 에 넣을것~ 지금은 테스트~ -->
<link rel="stylesheet" type="text/css" href="${jsPath }/Nwagon/Nwagon.css" />
<script type="text/javascript" src="${jsPath }/Nwagon/Nwagon.js"></script>
<div class="content">
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
				<tr class="line2">
					<th class="no_line">JUL 2013</th>
					<td>0</td>
					<td>2</td>
					<td>0</td>
					<td><strong>2</strong></td>
					<td>0.00</td>
					<td>0.00</td>
				</tr>
				<tr class="line2">
					<th class="no_line">AUG 2013</th>
					<td>0</td>
					<td>2</td>
					<td>0</td>
					<td><strong>2</strong></td>
					<td>0.00</td>
					<td>0.00</td>
				</tr>
				<tr class="line2">
					<th class="no_line">SEP 2013</th>
					<td>0</td>
					<td>2</td>
					<td>0</td>
					<td><strong>2</strong></td>
					<td>0.00</td>
					<td>0.00</td>
				</tr>
			</tbody>
		</table>
	</div>
	<h2 class="conTit">By Grade</h2>
	<div class="tbl01 tbl_w100">
		<table>
			<thead>
				<tr class="bg_gray">
					<th class="b_r">Grade</th>
					<th>PK</th>
					<th>K</th>
					<th>1ST</th>
					<th>2ST</th>
					<th>3RD</th>
					<th>4TH</th>
					<th>5TH</th>
					<th>6TH</th>
					<th>7TH</th>
					<th>8TH</th>
					<th>9TH</th>
					<th>10TH</th>
					<th>11TH</th>
					<th>12TH</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="col_gray b_r">Count</td>
					<td>1</td>
					<td>1</td>
					<td>3</td>
					<td>4</td>
					<td>1</td>
					<td>7</td>
					<td>4</td>
					<td>2</td>
					<td>2</td>
					<td>0</td>
					<td>0</td>
					<td>1</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr>
					<td class="col_gray b_r">Radio</td>
					<td>2.63%</td>
					<td>2.63%</td>
					<td>7.89%</td>
					<td>10.53%</td>
					<td>2.63%</td>
					<td>18.42%</td>
					<td>10.53%</td>
					<td>5.26%</td>
					<td>5.26%</td>
					<td>0.00%</td>
					<td>0.00%</td>
					<td>2.63%</td>
					<td>0.00%</td>
					<td>0.00%</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="graphArea pt30">
		<img src="/public/img/temp/graph01.jpg" alt="" />
	</div>
	<h2 class="conTit">Member Analysis</h2>

	<div class="tbl01">
		<table>
			<colgroup>
				<col width="100">
				<col>
				<col width="230">
				<col width="230">
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
					<td class="no_line">1</td>
					<td>A</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="line2">
					<td class="no_line">2</td>
					<td>B</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="line2">
					<td class="no_line">3</td>
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
					<th rowspan="2" class="no_line" style="width:100px">Learning<br>Center</th>
					<th rowspan="2" style="width:100px">This month's <br>sale</th>
					<th colspan="2">1 subject(s)</th>
					<th colspan="2">2 subjects</th>
					<th colspan="2">3 subjects</th>
					<th colspan="2">4 subjects</th>
					<th colspan="2">5 subjects</th>
					<th colspan="2">At least 6<br>subjects</th>
				</tr>
				<tr class="line bg_gray">
					<th>Member<br>Count</th>
					<th>%</th>
					<th>Member<br>Count</th>
					<th>%</th>
					<th>Member<br>Count</th>
					<th>%</th>
					<th>Member<br>Count</th>
					<th>%</th>
					<th>Member<br>Count</th>
					<th>%</th>
					<th>Member<br>Count</th>
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
