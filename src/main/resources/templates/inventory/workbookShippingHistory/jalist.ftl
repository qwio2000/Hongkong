<#include "/include/header.ftl">
<!-- Main Content -->
	<div class="content">
		<h2 class="conTit">Shipping History</h2>
		<div class="list02 pt20 clearfix">
			<div class="float_l">
				<select name="yyjaRestock" id="yyjaRestock" style="width:162px">
					<#list yylist as yylistIndex>
						<#if yy == yylistIndex>
							<option value="${yylistIndex }" selected="selected">${yylistIndex }</option>
						<#else>
							<option value="${yylistIndex }">${yylistIndex }</option>
						</#if>
					</#list>
				</select>			
			</div>
		</div>
		<div class="tbl01 mt5">
			<table>
				<colgroup>
					<col width="30">
					<col width="80">
					<col width="10">
					<col width="10">
					<col width="10">
					<col width="10">
					<col width="10">
					<col width="10">
					<col width="10">
					<col width="10">
					<col width="10">
					<col width="10">
					<col width="10">
					<col width="10">
					<col width="10">
					<col width="10">
					<!-- <col width="60"> -->
				</colgroup>
				<thead>
					<tr class="line">
						<th rowspan="2" class="no_line">ST</th>
						<th rowspan="2">Center Name</th>
						<th class="font_blue" colspan="14">Shipped Qty.</th>
						<!-- <th rowspan="2">Audit Date</th> -->						
					</tr>	
					<tr class="line">	
						<th>JAN</th>
						<th>FEB</th>
						<th>MAR</th>
						<th>APR</th>
						<th>MAY</th>
						<th>JUN</th>
						<th>JUL</th>
						<th>AUG</th>
						<th>SEP</th>
						<th>OCT</th>
						<th>NOV</th>
						<th>DEC</th>
						<th>TOTAL</th>						
						<th>AVG.<br/>Subj.</th>
					</tr>					
				</thead>
				<tbody>
					<#assign wbinoutshipSum = 0?number>
					<#list shlist as shlistIndex>
						<tr class="line2">
							<td class="no_line">${shlistIndex.st }</td>
							<td>${shlistIndex.centername }</td>							
							<#list shlistIndex.dtlList as dtlListIndex>
								<td>
									<#if dtlListIndex.wbinoutship != "0">
										<a href="javascript:$.openPop('/fa/inventory/historyRestockpop?jisaCD=${shlistIndex.jisaCD }&deptCD=${shlistIndex.deptCD }&yy=${yy }&mm=${dtlListIndex.mon }','historyRestockPopup','width=924,height=700,left=300,scrollbars=yes,resizable=yes')">
										${dtlListIndex.wbinoutship?number }
										</a>
									</#if>
								</td>
								<#assign wbinoutshipSum = wbinoutshipSum + dtlListIndex.wbinoutship?number>
							</#list>
							<td>${wbinoutshipSum }<#assign wbinoutshipSum = 0?number></td>
							<td>${shlistIndex.avgsubj }</td>
						</tr>
					</#list>
				</tbody>
			</table>
		</div>
		
	</div>
<!--// Main Content -->
<#include "/include/footer.ftl">