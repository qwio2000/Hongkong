<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">BizLead : ${centerLead.contactFstName } ${centerLead.contactFstName }</h2>
	<div class="tbl01">
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
					<th>Contact First Name</th>
					<td class="left"><input type="text" id="contactFstName" name="contactFstName" value="${centerLead.contactFstName }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td class="left"><input type="text" id="contactLstName" name="contactLstName" value="${centerLead.contactLstName }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Email Address</th>
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
					<th>Phone</th>
					<td class="left"><input type="text" id="phone" name="phone" value="${centerLead.phone }" class="searchInput" style="width:304px"></td>
				</tr>
				<tr>
					<th>Cell Phone</th>
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
					<select name="statusCD" id="statusCD" style="width:314px">
						<#list leadStatus as status>
							<option value="${status.dtlCD }" <#if status.dtlCD == centerLead.statusCD> selected </#if>>${status.dtlCDNM }</option>
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
				<!-- 여기부터 -->
				<tr>
					<th rowspan="2">How did you hear about JEI?</th>
					<td class="left"  style="border-bottom:0">
						<select name="" id="" style="width:314px">
							<option value="">JEI Parent</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="left">
						<div class="list02 rel_line">
							<span class="tit">Please describe</span>
							<input type="text" value="We use to go to JEI Montgomery" class="searchInput" style="width:470px">
						</div>
					</td>
				</tr>
				<tr>
					<th>Area(s) / Region(s) Interested</th>
					<td class="left"><input type="text" value="" class="searchInput" style="width:630px"></td>
				</tr>
				<tr>
					<th>Notes</th>
					<td class="left">
						<div class="textarea_wrap">
							<textarea name="" id="" cols="30" rows="10" style="width:620px">Heard that Montgomery center is disconnected. So..</textarea>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="btnArea">
		<a href="#"><span>Cancel</span></a> <a href="#"><span>Update Infomation</span></a>
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