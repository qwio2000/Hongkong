<div style='page-break-before:always'>	
	<div class="clearfix pt20">
		<div class="float_l" style="width:550px">Ship to Calgary : ${subjnm } (${subj })   <!-- ENGLISH (EE) --></div>
		<#if pgubun == "P">
		<div class="float_r" style="width:230px;">Printed on  ${date }<!-- 1/28/2015 at 12:00AM --></div>
		</#if>
	</div>
		
	<div class="tbl01 mt5 tbl_status">
		<table>
			<thead>
				<tr class="line">
					<#list wbdung as wbdungIndex>
						<#if wbdungIndex_index = 0>
							<th colspan="2" class="no_line">${wbdungIndex }</th>
						<#else>
							<th colspan="2">${wbdungIndex }</th>
						</#if>
					</#list>
				</tr>
			</thead>
			<tbody>
				<#assign chk = "0"><#assign qty = "0"><#assign stocqty = "0"><#assign stableqty = "0">
				<#list setlist as setlistIndxe>
					<tr class="line2">
						<#list wbdung as wbdungIndex>				
							<#list setlistIndxe.dungList as dungListIndex>
								<#if wbdungIndex == dungListIndex.wbgrade>
									
									<#assign stocqty = dungListIndex.stocqty>
									<#assign stableqty = dungListIndex.stableqty>
									<#assign qty = stocqty?number - stableqty?number>  <!-- 현재재고 - 적정재고 -->
									<#if wbdungIndex_index = 0>
										<td class="no_line">${dungListIndex.wbname }</td>
									<#else>
										<td>${dungListIndex.wbname }</td>
									</#if>
										<td class="col_n"> 				<!--  gt :> , gte : >= , lt < , lte <= -->
											<#if stableqty?number gt stocqty?number>
												${qty?replace("-","") }
											</#if>
										</td>
									<#assign chk = "1">
								</#if>					
							</#list>
							
							<#if chk == "0">
								<#if wbdungIndex_index = 0>
									<td class="no_line col_gray"></td>
								<#else>
									<td class="col_gray"></td>
								</#if>
								<td class="col_n col_gray"></td>
							</#if>
							<#assign chk = "0">
						</#list>
					</tr>
				</#list>
				
				<#assign stocqtySum = 0?number><#assign stocqtySumTot = 0?number>
					<tr class="line2 total">
						<#list wbdung as wbdungIndex>
							<#list setlist as setlistIndex>
								<#list setlistIndex.dungList as dungListIndex>
										<#if wbdungIndex == dungListIndex.wbgrade>
											<#assign stocqty = dungListIndex.stocqty>
											<#assign stableqty = dungListIndex.stableqty>
											<#assign qty = stocqty?number - stableqty?number>  <!-- 현재재고 - 적정재고 -->
											<#if stableqty?number gt stocqty?number>
												<#assign stocqtySum = stocqtySum + qty?replace("-","")?number>	
											</#if>
										</#if>
								</#list>
							</#list>
						
							<#if wbdungIndex_index = 0>	
								<td colspan="2" class="no_line">${stocqtySum }</td>
							<#else>
								<td colspan="2" >${stocqtySum }</td>
							</#if>
							<#assign stocqtySumTot = stocqtySumTot+stocqtySum>
							<#assign stocqtySum = 0?number>
						</#list>
					</tr>
			</tbody>
		</table>
		<div class="pt20">
			Total: <strong>${stocqtySumTot }</strong>
		</div>
	</div>
</div>