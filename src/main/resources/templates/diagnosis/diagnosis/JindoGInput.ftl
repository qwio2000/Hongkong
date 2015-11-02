<div class="clearfix">
	<div class="conLeft">
		<h2 class="conTit">Wrong answer</h2>
		<div class="tbl01">
			<table>
			
				<tbody>
				<#list 1.. iOdabCnt as iOdabCntIndex>
					<tr>
						<#list 0.. iOdabFor as iOdabForIndex>
							<#if totalCnt gte ((iOdabForIndex*iOdabCnt)+iOdabCntIndex) >
								<#assign cntIndex = ((iOdabForIndex*iOdabCnt)+iOdabCntIndex) >
								<td>
									<#list omrChkG as omrChkGIndex >
										<#if omrChkGIndex.munno?number == cntIndex>
										<span class="n">${cntIndex}</span>
										<span class="chk_s01">
											<input type="checkbox" id="chk${cntIndex}_" onclick="$.getInputChkG('chk${cntIndex}_','${cntIndex}', '${omrChkGIndex.sset}');" />
											<label for="chk${cntIndex}_"></label>
										</span>		
										</#if>
									</#list>								
								</td>
							<#else>
								<td></td>
							</#if>									
						</#list>
					</tr>
				</#list>	
				</tbody>
			</table>
		</div>
	</div>
	<div class="conRight">
		<h2 class="conTit">Evaluation result </h2>
		<div class="tbl01">
			<table>
				<colgroup>
					<col width="50%" />
					<col width="50%" />
				</colgroup>
				<thead>
				<tr>
					<th>QUESTION NUMBER</th>
					<th>LOSS SET</th>
				</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2" class="p0" >
							<ul class="result_list" id="Odablist" >
								
							</ul>
						</td>
					</tr>
					<tr class="total">
						<td>TOTAL</td>
						<td id="totals">0</td>
					</tr>
				</tbody>
			</table>
		</div>
		
	</div>
</div>
