<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">BizLead : ${centerLead.contactFstName } ${centerLead.contactLstName }</h2>
	<div class="tbl01">
	<form id="leadForm">
	<input type="hidden" id="idx" name="idx" value="${centerLead.idx }"/>
		<table>
			<colgroup>
				<col width="210px">
				<col>
			</colgroup>
			<tbody>
				<tr>
					<th>Current status <span class="must">*</span></th>
					<td class="left">
						<select name="statusCD" id="statusCD" style="width:314px">
							<#list leadStatus as status>
								<option value="${status.dtlCD }" <#if status.dtlCD == centerLead.statusCD> selected </#if>>${status.dtlCDNM }</option>
							</#list>
						</select>
					</td>
				</tr>
				<tr>
					<th>Contact First Name <span class="must">*</span></th>
					<td class="left"><input type="text" id="contactFstName" name="contactFstName" value="${centerLead.contactFstName }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Last Name <span class="must">*</span></th>
					<td class="left"><input type="text" id="contactLstName" name="contactLstName" value="${centerLead.contactLstName }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Email Address <span class="must">*</span></th>
					<td class="left"><input type="text" id="contactEmail" name="contactEmail" value="${centerLead.contactEmail }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Partner First Name</th>
					<td class="left"><input type="text" id="partnerFstName" name="partnerFstName" value="${centerLead.partnerFstName }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td class="left"><input type="text" id="partnerLstName" name="partnerLstName" value="${centerLead.partnerLstName }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Email Address</th>
					<td class="left"><input type="text" id="partnerEmail" name="partnerEmail" value="${centerLead.partnerEmail }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Phone <span class="must">*</span></th>
					<td class="left"><input type="text" id="phone" name="phone" value="${centerLead.phone }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Cell Phone <span class="must">*</span></th>
					<td class="left"><input type="text" id="cellPhone" name="cellPhone" value="${centerLead.cellPhone }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Address</th>
					<td class="left"><input type="text" id="addr" name="addr" value="${centerLead.addr }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>City</th>
					<td class="left"><input type="text" id="city" name="city" value="${centerLead.city }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>State</th>
					<td class="left">
					<select name="stateCD" id="stateCD" style="width:314px">
						<option value="">선택</option>
						<#list centerStates as state>
							<option value="${state.stateCD }" <#if state.stateCD == centerLead.stateCD> selected </#if>>${state.stateName }</option>
						</#list>
					</select>
					</td>
				</tr>
				<tr>
					<th>Zipcode</th>
					<td class="left"><input type="text" id="zip" name="zip" value="${centerLead.zip }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Country</th>
					<td class="left"><input type="text" id="country" name="country" value="${centerLead.country }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th rowspan="2">How did you hear about JEI?</th>
					<td class="left"  style="border-bottom:0">
						<select name="howHear" id="howHear" style="width:314px">
							<option value="">선택</option>
							<#list howHears as howHear>
								<option value="${howHear.dtlCD }" <#if howHear.dtlCD == centerLead.howHear> selected </#if>>${howHear.dtlCDNM }</option>
							</#list>
						</select>
					</td>
				</tr>
				<tr>
					<td class="left">
						<div class="list02 rel_line">
							<span class="tit">Please describe</span>
							<input type="text" id="howHearMore" name="howHearMore" value="${centerLead.howHearMore }" class="searchInput" style="width:470px">
						</div>
					</td>
				</tr>
				<tr>
					<th>Area(s) / Region(s) Interested</th>
					<td class="left"><input type="text" id="areaInterested" name="areaInterested" value="${centerLead.areaInterested }" class="searchInput" style="width:630px"></td>
				</tr>
				<tr>
					<th>Notes</th>
					<td class="left">
						<div class="textarea_wrap">
							<textarea name="notes" id="notes" cols="30" rows="10" style="width:620px">${centerLead.notes }</textarea>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	<div class="btnArea">
		<a href="/ja/leads/${centerLead.idx }"><span>Cancel</span></a> 
		<a href="javascript:updateLead();"><span>Update Infomation</span></a>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">