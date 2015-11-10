<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Payment Report</h2>
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
				<col style="width:80px" />
				<col />
				<col style="width:100px" />
				<col style="width:100px" />
				<col style="width:100px" />
				<col style="width:100px" />
				<col style="width:120px" />
			</colgroup>
			<thead>
				<tr>
					<th>State</th>
					<th>Center</th>
					<th>Date</th>
					<th>Method</th>
					<th>Ref.No.</th>
					<th>Amount</th>
					<th>Memo</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>MA</td>
					<td class="left">Burlington</td>
					<td>12/11/2014</td>
					<td>Check</td>
					<td>1011</td>
					<td>$646.43</td>
					<td></td>
				</tr>
				<tr>
					<td>MA</td>
					<td class="left">Burlington</td>
					<td>12/11/2014</td>
					<td>Check</td>
					<td>1011</td>
					<td>$646.43</td>
					<td></td>
				</tr>
				<tr class="total">
					<td colspan="5"></td>
					<td>$187,374.27</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>


</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
