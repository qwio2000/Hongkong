<#include "/include/header.ftl">
<!-- Main Content -->
	<div class="content">
		<h2 class="conTit">Workbook Status(Center)</h2>
		<div class="list02 pt20">
			Calgary : 
			<select name="subjgo" id="subjgo" style="width:200px">
				<#list subjlist as subjlistIndex>
					<#if subj == subjlistIndex.subj>
						<option value="${subjlistIndex.jisaCD },${subjlistIndex.deptCD },${subjlistIndex.subj },${gubun}" selected="selected">${subjlistIndex.subjnm }</option>
					<#else>
						<option value="${subjlistIndex.jisaCD },${subjlistIndex.deptCD },${subjlistIndex.subj },${gubun}">${subjlistIndex.subjnm }</option>
					</#if>
				</#list>
			</select>
		</div>
		
		<div class="clearfix list02 pt20">
			<div class="float_l">
				<span class="status_txt">Enter actural shipping qty and click <strong>[Confrim & Ship Inventory]</strong> button</span>
			</div>
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
												<#if stableqty?number == stocqty?number >  <!-- 적정재고 = 현재재고  "검정색"-->
													<input type="text" style="width:20px" id="input_${wbdungIndex }_${dungListIndex.caskey }"  value="" caskey="${dungListIndex.caskey }" wbgrade="${dungListIndex.wbgrade }" />
												<#elseif stableqty?number lt stocqty?number>  <!-- 적정재고 < 현재재고  "파란색"-->
													<input type="text" style="width:20px" id="input_${wbdungIndex }_${dungListIndex.caskey }"  value="" caskey="${dungListIndex.caskey }" wbgrade="${dungListIndex.wbgrade }" />
												<#elseif stableqty?number gt stocqty?number>  <!-- 적정재고 > 현재재고  "빨간색"-->
													<input type="text" style="width:20px" id="input_${wbdungIndex }_${dungListIndex.caskey }"  value="${qty?replace("-","") }" caskey="${dungListIndex.caskey }" wbgrade="${dungListIndex.wbgrade }" />
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
		
		<input type="hidden" id="jisaCD" value="${jisaCD }">
		<input type="hidden" id="deptCD" value="${deptCD }">
		<input type="hidden" id="subj" value="${subj }">
		<div id="allset" style=""></div>
		
		<div class="btnArea">
			<a href="javascript:$.getShipInventorySave();"><span>Confirm &amp; Ship Inventory</span></a>
		</div>
	
		
	</div>
<!--// Main Content -->
<#include "/include/footer.ftl">