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
								<input type="checkbox" id="chk${cntIndex}_" value ="${cntIndex}" onclick="$.getInputChk('chk${cntIndex}_','${cntIndex}', '${cntIndex}','');"/>
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