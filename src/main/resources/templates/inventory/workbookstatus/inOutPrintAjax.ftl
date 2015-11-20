
				<div class="clearfix pt20">
					<div class="float_l">
					Ship to Calgary : ${subjnm } (${subj })   <!-- ENGLISH (EE) -->
					</div>
					<#if pgubun == "P">
					<div class="float_r">
					Printed on ${date } <!-- 1/28/2015 at 12:00AM -->
					</div>
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
							<#assign chk = "0"><#assign wbinoutcal = "0"><#assign wbinoutship = "0">
							<#list setlist as setlistIndxe>
								<tr class="line2">
									<#list wbdung as wbdungIndex>				
										<#list setlistIndxe.dungList as dungListIndex>
											<#if wbdungIndex == dungListIndex.wbgrade>
												
												<#assign wbinoutship = dungListIndex.wbinoutship> <!-- 실제 발송량 -->
												<#assign wbinoutcal = dungListIndex.wbinoutcal>  <!-- 전산 산정량 -->
												
												
												<#if wbdungIndex_index = 0>
													<td class="no_line">${dungListIndex.wbname }</td>
												<#else>
													<td>${dungListIndex.wbname }</td>
												</#if>
												
													<td class="col_n"> 				<!--  gt :> , gte : >= , lt < , lte <= -->
														<#if wbinoutship != "0" || wbinoutcal != "0">
														${wbinoutship }(${wbinoutcal })
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
						</tbody>
					</table>
				</div>
		
		