<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Charge Report</h2>
	<div class="list02 pt20 clearfix">
		<div class="float_l">
			<select name="" id="" style="width:100px">
				<option value="">2014</option>
			</select>
			<select name="" id="" style="width:162px">
				<option value="">December</option>
			</select>
			<span class="btnArea mt0"><a href="#"><span style="width:70px">Search</span></a></span>
		</div>
	</div>
	<div class="tbl01 mt5">
		<table>
			<colgroup>
				<col style="width:70px" />
				<col />
				<col style="width:80px" />
				<col style="width:150px" />
				<col style="width:120px" />
				<col style="width:350px" />
			</colgroup>
			<thead>
				<tr>
					<th>State</th>
					<th>Center</th>
					<th>Date</th>
					<th>Type</th>
					<th>Amount</th>
					<th>Memo</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="7" class="left col_bold"><em>CANADA</em></td>
				</tr>
				<tr>
					<td>AB</td>
					<td class="left">calgary</td>
					<td>12/11/2014</td>
					<td>Freight</td>
					<td>$646.43</td>
					<td class="left">March workbooks</td>
				</tr>
				<tr>
					<td>AB</td>
					<td class="left">calgary</td>
					<td>12/11/2014</td>
					<td>Chargeable Items</td>
					<td>$646.43</td>
					<td class="left">Inventory Restock; Summer Flyer and Poster</td>
				</tr>
				<tr>
					<td>BC</td>
					<td class="left">Coquitlam</td>
					<td>12/11/2014</td>
					<td>Other Credit / Debit</td>
					<td>$646.43</td>
					<td class="left">Inventory Restock; Summer Flyer and Poster</td>
				</tr>
				<tr class="total">
					<td colspan="4"></td>
					<td>$187,374.27</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>


</div>

<!--// Main Content -->
<#include "/include/footer.ftl">
