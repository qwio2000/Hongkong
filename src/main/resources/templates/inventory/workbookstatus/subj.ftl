<#include "/include/header.ftl">
<!-- Main Content -->
	<div class="content">
		<h2 class="conTit">Workbook Status(Center)</h2>
		<div class="list02 pt20">
			Calgary : 
			<select name="subjgo" id="subjgo" style="width:200px">
				<#list subjlist as subjlistIndex>
					<#if subj == subjlistIndex.subj>
						<option value="${subjlistIndex.jisaCD },${subjlistIndex.deptCD },${subjlistIndex.subj },'' " selected="selected">${subjlistIndex.subjnm }</option>
					<#else>
						<option value="${subjlistIndex.jisaCD },${subjlistIndex.deptCD },${subjlistIndex.subj },'' ">${subjlistIndex.subjnm }</option>
					</#if>
				</#list>
			</select>
		</div>
		<#if userType == "JA">
		<div class="clearfix list02 pt20">
			<div class="float_l">
				<span class="status_txt">Click inventory qty to view history.</span>
			</div>
			<div class="float_r">
				<div class="clearfix btnArea_txt_top">
					<a href="/ja/inventory/workbookstatusPrint?jisaCD=${jisaCD }&deptCD=${deptCD}&subj=${subj}&gubun=print" class="btn_print2">Print</a>
					<a href="/ja/inventory/workbookstatusSubj?jisaCD=${jisaCD }&deptCD=${deptCD}&subj=${subj}&gubun=ship" class="btn_delivery">Ship Inventory</a>
					<a href="/ja/inventory/workbookstatusSubj?jisaCD=${jisaCD }&deptCD=${deptCD}&subj=${subj}&gubun=adjust" class="btn_info" style="padding-left:38px">Adjust Inventory</a>
					<a href="/ja/inventory/workbookstatusSubj?jisaCD=${jisaCD }&deptCD=${deptCD}&subj=${subj}&gubun=setrestockqty" class="btn_set last">Set Restock Qty</a>
				</div>
			</div>
		</div>
		</#if>
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
					<#list setlist as setlistIndex>
						<tr class="line2">
							<#list wbdung as wbdungIndex>				
								<#list setlistIndex.dungList as dungListIndex>
									<#if wbdungIndex == dungListIndex.wbgrade>
										
										<#assign stocqty = dungListIndex.stocqty>
										<#assign stableqty = dungListIndex.stableqty>
										<#assign qty = stocqty?number - stableqty?number>
										<#if wbdungIndex_index = 0>
											<td class="no_line">
												<a href="javascript:$.openPop('/ja/inventory/workbookstatusInventorySet?jisaCD=${jisaCD }&deptCD=${deptCD }&subj=${subj }&casKey=${dungListIndex.caskey }','workbookstatusInventorySet','width=924,height=700,left=300,scrollbars=yes,resizable=yes')">
												${dungListIndex.wbname }
												</a>
											</td>
										<#else>
											<td>
												<a href="javascript:$.openPop('/ja/inventory/workbookstatusInventorySet?jisaCD=${jisaCD }&deptCD=${deptCD }&subj=${subj }&casKey=${dungListIndex.caskey }','workbookstatusInventorySet','width=924,height=700,left=300,scrollbars=yes,resizable=yes')">
												${dungListIndex.wbname }
												</a>
											</td>
										</#if>
											<td class="col_n"> 				<!--  gt :> , gte : >= , lt < , lte <= -->
												<#if stableqty?number == stocqty?number >  <!-- 적정재고 = 현재재고  "검정색"-->
													${stocqty }
												<#elseif stableqty?number lt stocqty?number>  <!-- 적정재고 < 현재재고  "파란색"-->
													<span class="font_blue">${stocqty }</span><i>(${qty })</i>
												<#elseif stableqty?number gt stocqty?number>  <!-- 적정재고 > 현재재고  "빨간색"-->
													<span class="font_red">${stocqty }</span><i>(${qty })</i>
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
											<#assign stocqtySum = stocqtySum + dungListIndex.stocqty?number>	
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
<!--// Main Content -->
<#include "/include/footer.ftl">