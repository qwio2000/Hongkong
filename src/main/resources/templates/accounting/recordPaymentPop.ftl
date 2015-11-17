<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>Record Payment</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_input">
			<!-- Add Chares Start -->
			<div id="addPayment" style="display:none;">
			<form id="recordPaymentForm" name="recordPaymentForm" action="" method="">
			<input type="hidden" name="deptCD" id="deptCD" value="${deptCD?default('') }">
			<input type="hidden" name="deptName" id="deptName" value="${deptName?default('') }">
			<input type="hidden" name="balance" id="balance" value="${balance?c }">
			<input type="hidden" name="currAmount" id="currAmount" value="${currAmount?c }">
			
			<div class="notice_date">Input Month: ${currentMonthName?default('') } ${currentYear?default('') }</div>
			<div class="tbl01 mt5" >
				<table>
					<colgroup>
						<col style="width:80px" />
						<col style="width:140px" />
						<col style="width:170px" />
						<col style="width:100x" />
						<col style="width:70px" />
						<col />
						<col style="width:120px" />
					</colgroup>
					<thead>
						<tr class="line">
							<th class="no_line">Balance</th>
							<th>Date</th>
							<th>Type</th>
							<th>Ref.Number</th>
							<th>Amount</th>
							<th>Memo</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr class="line2">
							<td class="no_line">${balance?default(0) }</td>
							<td>
								<input type="text" name="payMMDDYY" id="payMMDDYY" class="searchInput" style="width:80px" readOnly >
								<input type="hidden" name="payYMD" id="payYMD"/>
								<a class="btn_calendar" id="payDatePicker" style="cursor: pointer;">view calendar</a>
							</td>
							<td>
								<select name="payCD" id="payCD" style="width:150px">
									<option value="">-- SELECT A TYPE --</option>
									<#list payCDList as payCD>
										<option value="${payCD.dtlCD }" >${payCD.dtlCDNM }</option>
									</#list>
								</select>					
							</td>
							<td><input type="text" name="refNo" id="refNo" maxLength="30" class="searchInput" style="width:80px"></td>
							<td><input type="text" name="amount" id="amount" maxLength="6" class="searchInput" style="width:40px"></td>
							<td><input type="text" name="memo" id="memo" maxLength="100" class="searchInput" style="width:230px"></td>
							<td>
								<span class="btnArea mt0"><a href="javascript:;" id="saveRecordPayment"><span style="width:90px">Add Payment</span></a></span>
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
					<span class="btnArea mt0"><a id="recordPaymentSearchSubmit" href="javascript:;"><span style="width:70px">View</span></a></span>
					<span class="btnArea mt0"><a href="javascript:;" onClick="$.addPayment();" ><span style="width:95px">Add Payment</span></a></span>
				</div>			
				<div class="float_r">
					<div class="notice_state">Center : <em>${deptName?default('')}</em></div>
				</div>				
				</form>
			</div>
			<div class="tbl01 mt5">
				<table>
					<colgroup>
						<col style="width:100px" />
						<col style="width:100px" />
						<col style="width:120px" />
						<col style="width:100px" />
						<col />
						<col style="width:50px" />
					</colgroup>
					<thead>
						<tr class="line">
							<th class="no_line">Date</th>
							<th>Mathod</th>
							<th>Ref.No.</th>
							<th>Amount</th>
							<th colspan="2">Memo</th>
						</tr>
					</thead>
					<tbody>
						<#list recordPaymentList as list>
						<tr class="line2">
							<td class="no_line">${list.payYMD }</td>
							<td class="left">${list.payName }</td>
							<td>${list.refNo }</td>
							<td>${list.amount }</td>
							<td class="left">${list.memo }</td>
							<td class="no_line"><#if (list.delFlag == "Y") ><a href="javascript:$.deleteRecordPayment('${list.idx}','${list.deptCD}')" class="btn_delete">delete</a></#if></td>
						</tr>
						<#else>
						<tr><td colspan="5">no search results</td></tr>
						</#list>
						<#if (totCnt > 0) >
						<tr class="total line2">
							<td colspan="3" class="no_line">Grand Total</td>
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