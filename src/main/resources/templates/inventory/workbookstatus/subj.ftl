<#include "/include/header.ftl">
<!-- Main Content -->
	<div class="content">
		<h2 class="conTit">Workbook Status(Center)</h2>
		<div class="list02 pt20">
			Calgary : 
			<select name="" id="" style="width:200px">
				<#list subjlist as subjlistIndex>
					<#if subj == subjlistIndex.subj>
						<option value="${subjlistIndex.jisacd },${subjlistIndex.deptcd },${subjlistIndex.subj }" selected="selected">${subjlistIndex.subjnm }</option>
					<#else>
						<option value="${subjlistIndex.jisacd },${subjlistIndex.deptcd },${subjlistIndex.subj }">${subjlistIndex.subjnm }</option>
					</#if>
				</#list>
			</select>
		</div>
		<div class="clearfix list02 pt20">
			<div class="float_l">
				<span class="status_txt">Click inventory qty to view history.</span>
			</div>
			<div class="float_r">
				<div class="clearfix btnArea_txt_top">
					<a href="#" class="btn_print2">Print</a>
					<a href="#" class="btn_delivery">Ship Inventory</a>
					<a href="#" class="btn_info" style="padding-left:38px">Adjust Inventory</a>
					<a href="#" class="btn_set last">Set Restock Qty</a>
				</div>
			</div>
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
						<td class="col_n"><a href="#">4</a></td>
						<td>B-DIAG</td>
						<td class="col_n"><a href="#"><span class="font_red">4</span><i>(-3)</i></a></td>
						<td>C-DIAG</td>
						<td class="col_n"><a href="#"><span class="font_blue">10</span><i>(3)</i></a></td>
						<td>D-DIAG</td>
						<td class="col_n"><a href="#"><span class="font_red">4</span><i>(-8)</i></a></td>
						<td>E-DIAG</td>
						<td class="col_n"><a href="#">10</a></td>
						<td>F-DIAG</td>
						<td class="col_n"><a href="#">10</a></td>
						<td>G-DIAG</td>
						<td class="col_n"><a href="#">10</a></td>
						<td>H-DIAG</td>
						<td class="col_n"><a href="#">10</a></td>
						<td>I-DIAG</td>
						<td class="col_n"><a href="#">10</a></td>
						<td>G-DIAG</td>
						<td class="col_n"><a href="#"><span class="font_red">4</span><i>(-3)</i></a></td>
						<td>K-DIAG</td>
						<td class="col_n"><a href="#">5</a></td>
						<td>L-DIAG</td>
						<td class="col_n"><a href="#">4</a></td>
					</tr>
					<tr class="line2">
						<td class="no_line">A-REV</td>
						<td class="col_n">4</td>
						<td>B01</td>
						<td class="col_n">4</td>
						<td>C-DIAG</td>
						<td class="col_n">10</td>
						<td>D-DIAG</td>
						<td class="col_n">10</td>
						<td>E-DIAG</td>
						<td class="col_n">10</td>
						<td>F-DIAG</td>
						<td class="col_n">10</td>
						<td>G-DIAG</td>
						<td class="col_n">10</td>
						<td>H-DIAG</td>
						<td class="col_n">10</td>
						<td>I-DIAG</td>
						<td class="col_n">10</td>
						<td>G-DIAG</td>
						<td class="col_n"><span class="font_red">4</span><i>(-2)</i></td>
						<td>K-DIAG</td>
						<td class="col_n">5</td>
						<td>L-DIAG</td>
						<td class="col_n">4</td>
					</tr>
					<tr class="line2">
						<td class="no_line">A-REV</td>
						<td class="col_n">4</td>
						<td>B01</td>
						<td class="col_n">4<i>(2)</i></td>
						<td>C-DIAG</td>
						<td class="col_n">4<i>(-2)</i></td>
						<td>D-DIAG</td>
						<td class="col_n">10</td>
						<td>E-DIAG</td>
						<td class="col_n">10</td>
						<td>F-DIAG</td>
						<td class="col_n">4<i>(-2)</i></td>
						<td>G-DIAG</td>
						<td class="col_n">10</td>
						<td>H-DIAG</td>
						<td class="col_n">10</td>
						<td>I-DIAG</td>
						<td class="col_n">10</td>
						<td>G-DIAG</td>
						<td class="col_n">10</td>
						<td>K-DIAG</td>
						<td class="col_n">5</td>
						<td>L-DIAG</td>
						<td class="col_n">4</td>
					</tr>
					<tr class="line2">
						<td class="no_line"></td>
						<td class="col_n"></td>
						<td>B01</td>
						<td class="col_n">4<i>(2)</i></td>
						<td>C-DIAG</td>
						<td class="col_n">4<i>(-2)</i></td>
						<td></td>
						<td class="col_n"></td>
						<td>E-DIAG</td>
						<td class="col_n">10</td>
						<td>F-DIAG</td>
						<td class="col_n">4<i>(-2)</i></td>
						<td>G-DIAG</td>
						<td class="col_n">10</td>
						<td>H-DIAG</td>
						<td class="col_n">10</td>
						<td>I-DIAG</td>
						<td class="col_n">10</td>
						<td>G-DIAG</td>
						<td class="col_n">10</td>
						<td></td>
						<td class="col_n"></td>
						<td></td>
						<td class="col_n"></td>
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
			<div class="pt20">
				Total: <strong>1,995</strong>
			</div>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/footer.ftl">