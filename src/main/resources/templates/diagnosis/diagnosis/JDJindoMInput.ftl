<#if (subjname == "M") && ( (leveldung == "A") || (leveldung == "B") || (leveldung == "C")  ) >  <!--  gt :> , gte : >= , lt < , lte <= -->
	<div class="tbl01 m_tbl">
		<table>
			<thead>
				<tr>
				<#list 0.. iOdabFor as iOdabForIndex>
					<th>item</th>
				</#list>
				</tr>
			</thead>
			<tbody>
			<#list 1.. iOdabCnt as iOdabCntIndex>
				<tr>
					<#list 0.. iOdabFor as iOdabForIndex>
		
						<#if totalCnt gte ((iOdabForIndex*iOdabCnt)+iOdabCntIndex) >
						<#assign cntIndex = ((iOdabForIndex*iOdabCnt)+iOdabCntIndex) >
						<td>
							<span class="n">${cntIndex}</span>
							<span class="chk_s01">
								<input type="checkbox" id="chk${cntIndex}_" value ="${cntIndex}" onclick="$.getInputChkMath('chk${cntIndex}','${cntIndex}', '${cntIndex}','');"/>
								<label for="chk${cntIndex}_"></label>
							</span>				
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
<#else>
	<div class="tbl01 m_tbl">
		<table>
			<colgroup>
				<col width="10%" />
				<col width="9%" />
				<col width="9%" />
				<col width="9%" />
				<col width="9%" />
				<col width="9%" />
				<col width="9%" />
				<col width="9%" />
				<col width="9%" />
				<col width="9%" />
				<col width="9%" />
			</colgroup>
			<thead>
				<tr>
					<th rowspan="2" class="b_r">NO</th>
					<th colspan="10">Member's choice</th>
				</tr>
				<tr>
					<th>1</th>
					<th>2</th>
					<th>3</th>
					<th>4</th>
					<th>5</th>
					<th>6</th>
					<th>7</th>
					<th>8</th>
					<th>9</th>
					<th>10</th>
				</tr>
			</thead>
			<tbody>
				
			<#list jdSys8070P as Line>	
				<tr>
					<td>${Line_index+1 }</td>			
					<#list 1.. Line.junghang?number as junghangIndex>	
							
					<td>
						<#if Line.jungdab?number == junghangIndex>
						<span class="chk_s01">
							<input type="checkbox" id="chk${Line_index+1 }_${junghangIndex}" value="${Line_index+1 }|${junghangIndex}" disabled />
							<label for="chk${Line_index+1 }_${junghangIndex}"></label>
						</span>
						<#else>
						<span class="chk_s01">
							<input type="checkbox" id="chk${Line_index+1 }_${junghangIndex}" value ="${Line_index+1 }|${junghangIndex}" onclick="$.getInputChkMath('chk${Line_index+1 }_','${Line_index+1 }|${junghangIndex}','${Line_index+1 }','${junghangIndex}');"/>
							<label for="chk${Line_index+1 }_${junghangIndex}"></label>
						</span>
						</#if>
					</td>
					</#list>
				
					<#list Line.junghang?number+1.. iOdabCnt  as junghangIndex>
						<td></td>
					</#list>
					
				</tr>
			</#list>
			</tbody>
		</table>
	</div>
</#if>	