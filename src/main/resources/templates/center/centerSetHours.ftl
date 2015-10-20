<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>SetBusiness Hours</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_jisa">
			<form action="" name="centerHoursForm" id="centerHoursForm">
			<input type="hidden" name="deptCD" value="${deptCD?default('')}"/>		
			<div class="tbl01">
				<table>
					<colgroup>
						<col width="0px" />
						<col width="270px" />
						<col width="270px" />
					</colgroup>
					<thead>
						<tr>
							<th></th>
							<th>Operating Hours</th>
							<th>Class Hours</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td class="left">
								<select name="oHoursStart" id="oHoursStart" style="width:100px">
									<option value="">-선택-</option>								
									<#list centerTimes as list>
									<option value="${list.dtlCD }"<#if list.dtlCD == oHoursStart>selected</#if>>${list.dtlCDNM }</option>
									</#list>
								</select>
								<select name="oHoursEnd" id="oHoursEnd" style="width:100px">
									<option value="">-선택-</option>
									<#list centerTimes as list>
									<option value="${list.dtlCD }"<#if list.dtlCD == oHoursEnd>selected</#if>>${list.dtlCDNM }</option>
									</#list>
								</select>
							</td>
							<td class="left">
								<select name="cHoursStart" id="cHoursStart" style="width:100px">
									<option value="">-선택-</option>
									<#list centerTimes as list>
									<option value="${list.dtlCD }"<#if list.dtlCD == cHoursStart>selected</#if>>${list.dtlCDNM }</option>
									</#list>
								</select>
								<select name="cHoursEnd" id="cHoursEnd" style="width:100px">
									<option value="">-선택-</option>
									<#list centerTimes as list>
									<option value="${list.dtlCD }"<#if list.dtlCD == cHoursEnd>selected</#if>>${list.dtlCDNM }</option>
									</#list>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btnArea">
				<a href="javascript:;" id="saveCenterHours" ><span>Update Center Hour</span></a>
			</div>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">