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
										<#assign qty = stocqty?number - stableqty?number>
										<#if wbdungIndex_index = 0>
											<td class="no_line">${dungListIndex.wbname }</td>
										<#else>
											<td>${dungListIndex.wbname }</td>
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
									
					<tr class="line2 total">
						<#list wbdung as wbdungIndex>
							<#if wbdungIndex_index = 0>
								<td colspan="2" class="no_line">152</td>
							<#else>
								<td colspan="2" >152</td>
							</#if>
						</#list>
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