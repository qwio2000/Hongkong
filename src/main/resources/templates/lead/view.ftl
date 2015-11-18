<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">BizLead : ${centerLead.contactFstName } ${centerLead.contactLstName }</h2>
	<div class="list02 clearfix">
		<div class="float_r">
			<div class="btnArea_txt p0"><a href="/ja/leads/edit/${centerLead.idx }" class="btn_info m0"><span class="hidden">modify</span></a></div>
		</div>
	</div>
	<div class="tbl01 mt5">
	<input type="hidden" id="idx" value="${centerLead.idx }">
		<table>
			<colgroup>
				<col width="210px">
				<col>
			</colgroup>
			<tbody>
				<tr>
					<th>Current status</th>
					<td class="left">
						<select name="statusCD" id="statusCD" style="width:314px">
							<#list leadStatus as status>
								<option value="${status.dtlCD }" <#if status.dtlCD == centerLead.statusCD> selected </#if>>${status.dtlCDNM }</option>
							</#list>
						</select>
					</td>
				</tr>
				<tr>
					<th>Name</th>
					<td class="left">${centerLead.contactFstName } ${centerLead.contactLstName }</td>
				</tr>
				<tr>
					<th>Email Address</th>
					<td class="left"><a href="mailto:${centerLead.contactEmail }" class="link">${centerLead.contactEmail } <img src="/public/img/icon_mail.png" alt="mail"></a></td>
				</tr>
				<tr>
					<th>Partner</th>
					<td class="left">${centerLead.partnerFstName } ${centerLead.partnerLstName }</td>
				</tr>
				<tr>
					<th>Email Address</th>
					<td class="left"><a href="mailto:${centerLead.partnerEmail }" class="link">${centerLead.partnerEmail } <img src="/public/img/icon_mail.png" alt="mail"></a></td>
				</tr>
				<tr>
					<th>Phone</th>
					<td class="left">${centerLead.phone }</td>
				</tr>
				<tr>
					<th>Cell Phone</th>
					<td class="left">${centerLead.cellPhone }</td>
				</tr>
				<tr>
					<th>Address</th>
					<td class="left">${centerLead.addr }</td>
				</tr>
				<tr>
					<th>City</th>
					<td class="left">${centerLead.city }</td>
				</tr>
				<tr>
					<th>State</th>
					<td class="left">${centerLead.stateName }</td>
				</tr>
				<tr>
					<th>Zipcode</th>
					<td class="left">${centerLead.zip }</td>
				</tr>
				<tr>
					<th>Country</th>
					<td class="left">${centerLead.country }</td>
				</tr>
				<tr>
					<th>How did you hear about JEI?</th>
					<td class="left">${centerLead.howHearName }<#if centerLead.howHearMore != ''>(${centerLead.howHearMore })</#if></td>
				</tr>
				<tr>
					<th>Area(s) / Region(s) Interested</th>
					<td class="left">${centerLead.areaInterested }</td>
				</tr>
				<tr>
					<th>Notes</th>
					<td class="left">${centerLead.notes }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="list02 clearfix mt20">
		<div class="float_l"><span class="tit">Notes</span><input type="text" id="notes" name="notes" class="searchInput" style="width:720px" maxlength="400"></div>
		<div class="float_r">
			<span class="btnArea mt0"><a href="javascript:addNewNote();"><span style="width:70px">Log It</span></a></span>
		</div>
	</div>
	<div class="tbl01">
		<table>
			<colgroup>
				<col width="200" />
				<col />
				<col width="120" />
			</colgroup>
			<thead>
				<tr>
					<th>Date</th>
					<th>Notes</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="mainContent"></tbody>
		</table>
	</div>
</div>
<!--// Main Content -->
<script id="notesTemplate" type="text/x-handlebars-template">
	{{#each notes}}
	<tr>
		<td>{{noteDate}}</td>
		<td class="left">{{notes}}</td>
		<td>[{{regID}}]</td>
	</tr>
	{{else}}
		<tr>
			<td colspan="3">No Notes.</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl">