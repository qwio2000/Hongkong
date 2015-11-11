<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>Record Charges</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_input">
			<!-- Add Chares Start -->
			<div id="addCharge" style="display:none;">
			<form id="recordChargeForm" name="recordChargeForm" action="" method="">
			<input type="hidden" name="deptCD" id="deptCD" value="${deptCD }">
			<input type="hidden" name="idx" id="idx" value="">
			<div class="notice_date">Input Month: ${currentMonthName?default('') } ${currentYear?default('') }</div>
			<div class="tbl01 mt5" >
				<table>
					<colgroup>
						<col style="width:150px" />
						<col style="width:220px" />
						<col style="width:100px" />
						<col />
						<col style="width:120px" />
					</colgroup>
					<thead>
						<tr class="line">
							<th class="no_line">Date</th>
							<th>Type</th>
							<th>Amount</th>
							<th>Memo</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr class="line2">
							<td class="no_line">
								<input type="text" name="chargeMMDDYY" id="chargeMMDDYY" class="searchInput" style="width:90px" readOnly >
								<input type="hidden" name="chargeYMD" id="chargeYMD"/>
								<a class="btn_calendar" id="chargeDatePicker" style="cursor: pointer;">view calendar</a>
							</td>
							<td class="left">
								<select name="chargeCD" id="chargeCD" style="width:180px">
									<option value="">-- SELECT A TYPE --</option>
									<#list chargeCDList as chargeCD>
										<option value="${chargeCD.dtlCD }" >${chargeCD.dtlCDNM }</option>
									</#list>
								</select>					
							</td>
							<td><input type="text" name="amount" id="amount" maxLength="6" class="searchInput" style="width:70px"></td>
							<td class="left">
								<input type="text" name="memo" id="memo" maxLength="100" class="searchInput" style="width:300px">
							</td>
							<td>
								<span class="btnArea mt0"><a href="javascript:;" id="saveRecordCharge"><span style="width:90px">Add Charge</span></a></span>
							</td>							
						</tr>
					</tbody>
				</table>
				<br />			
			</div>
			</form>		
			</div>
			<!-- Add Chares End -->	
			
			<div class="list02 pt20 clearfix">
				<form id="searchForm" name="searchForm" action="" method="">			
				<div class="float_l">
					<select name="selYY" id="selYY" style="width:100px">
						<#list selYY?number..selYY?number-2 as i>
							<option value="${i?c }" <#if i == selYY?number>selected</#if>>${i?c }</option>
						</#list>				
					</select>
					<select name="selMM" id="selMM" style="width:162px">
						<#list months as month>
							<option value="${month.monthNum }" <#if month.monthNum == selMM>selected</#if> >${month.monthStr }</option>
						</#list>				
					</select>
					<span class="btnArea mt0"><a id="recordChargeSearchSubmit" href="javascript:;"><span style="width:70px">View</span></a></span>
					<span class="btnArea mt0"><a href="javascript:;" onClick="$.addCharge();" ><span style="width:95px">Add Charge</span></a></span>
				</div>			
				</form>
			</div>
			<div class="tbl01 mt5">
				<table>
					<colgroup>
						<col style="width:150px" />
						<col style="width:220px" />
						<col style="width:100px" />
						<col />
						<col style="width:50px" />
					</colgroup>
					<thead>
						<tr class="line">
							<th class="no_line">Date</th>
							<th>Type</th>
							<th>Amount</th>
							<th colspan="2">Memo</th>
						</tr>
					</thead>
					<tbody>
						<#list recordChargeList as list>
						<tr class="line2">
							<td class="no_line">${list.chargeYMD }</td>
							<td class="left">${list.chargeName }</td>
							<td>${list.amount }</td>
							<td class="left">${list.memo }</td>
							<td class="no_line"><#if (list.mgYY == currentYear && list.mgMM == currentMonth) ><a href="javascript:$.deleteRecordCharge('${list.idx}')" class="btn_delete">delete</a></#if></td>
						</tr>
						<#else>
						<tr><td colspan="5">no search results</td></tr>
						</#list>
						<#if (totCnt > 0) >
						<tr class="total line2">
							<td colspan="2" class="no_line">Grand Total</td>
							<td>${totAmount }</td>
							<td colspan="2" ></td>
						</tr>
						</#if>						
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">