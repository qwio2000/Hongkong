<#include "/include/header.ftl">
<!-- Main Content -->
	<div class="content">
		<h2 class="conTit">Workbook Status(Center)</h2>
		<div class="list02 pt20">
			Ship to Calgary : 
			<select name="subjRAW" id="subjRAW" style="width:200px">
				<#list subjlist as subjlistIndex>
					<#if subj == subjlistIndex.subj>
						<option value="${subjlistIndex.jisaCD },${subjlistIndex.deptCD },${subjlistIndex.subj } " selected="selected">${subjlistIndex.subjnm }</option>
					<#else>
						<option value="${subjlistIndex.jisaCD },${subjlistIndex.deptCD },${subjlistIndex.subj } ">${subjlistIndex.subjnm }</option>
					</#if>
				</#list>
			</select>
		</div>
		<#if subj != "">
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
					<#assign chk = "0"><#assign qty = "0"><#assign stocqty = "0"><#assign stableqty = "0"><#assign saveYN = "N"><#assign inoutreqnote = "">
					<#list setlist as setlistIndex>
						<tr class="line2">
							<#list wbdung as wbdungIndex>				
								<#list setlistIndex.dungList as dungListIndex>
									<#if wbdungIndex == dungListIndex.wbgrade>	
										<#assign wbinoutcal = dungListIndex.wbinoutcal> <!--  긴급교재 입력 저장값 -->
										<#if setlistIndex.inoutreqnote != "">
											<#assign saveYN = "Y">
											<#assign inoutreqnote = setlistIndex.inoutreqnote > 
										</#if>	
										<#if wbinoutcal == "0">
											<#assign wbinoutcal = "">
										</#if>		
										<#if wbdungIndex_index = 0>
											<td class="no_line">												
												${dungListIndex.wbname }												
											</td>
										<#else>
											<td>												
												${dungListIndex.wbname }												
											</td>
										</#if>
											<td class="col_n"> 				<!--  gt :> , gte : >= , lt < , lte <= -->
												<input type="text" style="width:20px" name="" id="input_${wbdungIndex }_${dungListIndex.caskey }"  value="${wbinoutcal }" caskey="${dungListIndex.caskey }" wbgrade="${dungListIndex.wbgrade }" />
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
		
		<div class="tbl01 mt5 tbl_status">
			<table>
				<tbody>
					<tr class="line2">
						<td class="no_line">Reason : </td>
						<td class="col_n" style="width:90%">
							<input type="text" name="inOutReqNote" id="inOutReqNote" value="${inoutreqnote }" style="width:100%"/>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<input type="hidden" id="jisaCD" value="${jisaCD }">
		<input type="hidden" id="deptCD" value="${deptCD }">
		<input type="hidden" id="subj" value="${subj }">
		<div id="allset" style=""></div>
		<#if saveYN == "N">
			<div class="btnArea">
				<a href="javascript:$.getRequestAWSave();"><span>Confirm &amp; Request Inventory</span></a>
			</div>
		</#if>
		</#if>
	</div>
<!--// Main Content -->
<#include "/include/footer.ftl">