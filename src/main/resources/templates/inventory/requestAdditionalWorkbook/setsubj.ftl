<#include "/include/header.ftl">
<!-- Main Content -->
	<div class="content">
		<h2 class="conTit">Workbook Status(Center)</h2>
		<div class="list02 pt20">
			Ship to Calgary : 
			<select name="" id="" style="width:200px">
				<#list subjlist as subjlistIndex>
					<#if subj == subjlistIndex.subj>
						<option value="${subjlistIndex.jisaCD },${subjlistIndex.deptCD },${subjlistIndex.subj },'' " selected="selected">${subjlistIndex.subjnm }</option>
					<#else>
						<option value="${subjlistIndex.jisaCD },${subjlistIndex.deptCD },${subjlistIndex.subj },'' ">${subjlistIndex.subjnm }</option>
					</#if>
				</#list>
			</select>
		</div>
		
		<div class="tbl01 mt5 tbl_status">
			<table>
				<thead>
					<tr class="line">
						<th colspan="2" class="no_line">A</th>
						<th colspan="2">B</th>
						<th colspan="2">C</th>
						<th colspan="2">D</th>
						<th colspan="2">E</th>
						<th colspan="2">F</th>
						<th colspan="2">G</th>
						<th colspan="2">H</th>
						<th colspan="2">I</th>
						<th colspan="2">J</th>
						<th colspan="2">K</th>
						<th colspan="2">L</th>
					</tr>
				</thead>
				<tbody>
					<tr class="line2">
						<td class="no_line">A-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>B-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>C-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>D-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>E-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>F-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>G-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>H-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>I-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>G-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>K-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>L-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
					</tr>
					<tr class="line2">
						<td class="no_line">A-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>B-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>C-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>D-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>E-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>F-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>G-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>H-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>I-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>G-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>K-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>L-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
					</tr>
					<tr class="line2">
						<td class="no_line">A-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>B-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>C-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>D-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>E-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>F-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>G-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>H-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>I-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>G-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>K-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>L-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
					</tr>
					<tr class="line2">
						<td class="no_line">A-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>B-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>C-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>D-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>E-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>F-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>G-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>H-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>I-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>G-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>K-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
						<td>L-DIAG</td>
						<td class="col_n"><input type="text" style="width:20px" /></td>
					</tr>
					<tr class="line2 total">
						<td colspan="2" class="no_line">152</td>
						<td colspan="2">152</td>
						<td colspan="2">152</td>
						<td colspan="2">152</td>
						<td colspan="2">152</td>
						<td colspan="2">152</td>
						<td colspan="2">152</td>
						<td colspan="2">152</td>
						<td colspan="2">152</td>
						<td colspan="2">152</td>
						<td colspan="2">152</td>
						<td colspan="2">152</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btnArea">
			<a href="#"><span>Confirm &amp; Ship Inventory</span></a>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/footer.ftl">