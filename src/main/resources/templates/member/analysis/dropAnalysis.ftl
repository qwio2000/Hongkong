<#include "/include/header.ftl">
<!-- Main Content -->
<!-- 적용시에는 아래 라이브러리를 header 에 넣을것~ 지금은 테스트~ -->
<link rel="stylesheet" type="text/css" href="${jsPath }/Nwagon/Nwagon.css" />
<script type="text/javascript" src="${jsPath }/Nwagon/Nwagon.js"></script>
<div class="content">
	<h2 class="conTit">Drop Analysis (Year 2014)</h2>
	<div class="list02 pt20 clearfix">
		<div class="float_l">
			<select name="" id="" style="width:162px">
				<option value="">2014</option>
			</select>
			<span class="btnArea mt0"><a href="#"><span style="width:70px">Go</span></a></span>
		</div>
	</div>
	<div class="graphArea pt10">
		<img src="/public/img/temp/graph01.jpg" alt="">
	</div>
	<div class="tbl01">
		<table>
			<colgroup>
				<col style="width:50px" />
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
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line">State</th>
					<th>Center Name</th>
					<th>Too much <br />activity</th>
					<th>Want to <br />try other programs</th>
					<th>Lack of Progress</th>
					<th>Quality of the instructors</th>
					<th>Quality of instructors</th>
					<th>Financial difficulty</th>
					<th>Due to <br />Vacation</th>
					<th>Due to <br />moving</th>
					<th>Other</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<tr class="line2">
					<td class="no_line">Tx</td>
					<td class="left pl10"><a href="">Austin</a></td>
					<td>22</td>
					<td>4</td>
					<td>1</td>
					<td></td>
					<td></td>
					<td>3</td>
					<td>8</td>
					<td>3</td>
					<td>4</td>
					<td>45</td>
				</tr>
				<tr class="line2">
					<td class="no_line">Tx</td>
					<td class="left pl10"><a href="">Katy-Richmond</a></td>
					<td>22</td>
					<td>4</td>
					<td>1</td>
					<td></td>
					<td></td>
					<td>3</td>
					<td>8</td>
					<td>3</td>
					<td>4</td>
					<td>45</td>
				</tr>
				<tr class="total line2">
					<td colspan="2" class="no_line">TOTAL</td>
					<td>2,243[2]</td>
					<td>124[1]</td>
					<td>1</td>
					<td></td>
					<td></td>
					<td>3</td>
					<td>8</td>
					<td>3</td>
					<td>4</td>
					<td>4,515</td>
				</tr>
			</tbody>

		</table>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
