<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">New Leads</h2>
	<form id="leadForm">
	<ul class="list02 pt30">
		<li>
			<label for="contactFstName" class="tit2">Contact First Name <span class="must">*</span></label>
			<input type="text" id="contactFstName" name="contactFstName" class="searchInput" style="width:373px" />
		</li>
		<li>
			<label for="contactLstName" class="tit2">Last Name <span class="must">*</span></label>
			<input type="text" id="contactLstName" name="contactLstName" class="searchInput" style="width:373px" />
		</li>
		<li>
			<label for="contactEmail" class="tit2">Email Address <span class="must">*</span></label>
			<input type="text" id="contactEmail" name="contactEmail" class="searchInput" style="width:373px" />
		</li>
		<li>
			<label for="partnerFstName" class="tit2">Partner First Name</label>
			<input type="text" id="partnerFstName" name="partnerFstName" class="searchInput" style="width:373px" />
		</li>
		<li>
			<label for="partnerLstName" class="tit2">Last Name</label>
			<input type="text" id="partnerLstName" name="partnerLstName" class="searchInput" style="width:373px" />
		</li>
		<li>
			<label for="partnerEmail" class="tit2">Email Address</label>
			<input type="text" id="partnerEmail" name="partnerEmail" class="searchInput" style="width:373px" />
		</li>
		<li>
			<label for="phone" class="tit2">Phone <span class="must">*</span></label>
			<input type="text" id="phone" name="phone" class="searchInput" style="width:373px" />
		</li>
		<li>
			<label for="cellPhone" class="tit2">Cell Phone <span class="must">*</span></label>
			<input type="text" id="cellPhone" name="cellPhone" class="searchInput" style="width:373px;" />
		</li>
		<li>
			<label for="addr" class="tit2">Address</label>
			<input type="text" id="addr" name="addr" class="searchInput" style="width:373px;" />
		</li>
		<li>
			<label for="city" class="tit2">City</label>
			<input type="text" id="city" name="city" class="searchInput" style="width:373px;" />
		</li>
		<li>
			<label for="stateCD" class="tit2">State</label>
			<select name="stateCD" id="stateCD" style="width:383px">
				<option value="">선택</option>
				<#list centerStates as state>
					<option value="${state.stateCD }">${state.stateName }</option>
				</#list>
			</select>
		</li>
		<li>
			<label for="zip" class="tit2">Zipcode</label>
			<input type="text" id="zip" name="zip" class="searchInput" style="width:373px;" />
		</li>
		<li>
			<label for="country" class="tit2">Country</label>
			<input type="text" id="country" name="country" class="searchInput" style="width:373px;" />
		</li>
		<li>
			<label for="howHear" class="tit2">How did you hear about JEI?</label>
			<select name="howHear" id="howHear" style="width:383px">
				<option value="">선택</option>
				<#list howHears as howHear>
					<option value="${howHear.dtlCD }">${howHear.dtlCDNM }</option>
				</#list>
			</select>
		</li>
		<li>
			<label for="areaInterested" class="tit2">Area(s)/Region(s) Interested</label>
			<input type="text" id="areaInterested" name="areaInterested" class="searchInput" style="width:373px" />
		</li>
		<li>
			<label for="notes" class="tit2">Notes</label>
			<div class="textarea_wrap">
				<textarea name="notes" id="notes" cols="30" rows="10" style="width:363px" maxlength="300"></textarea>
			</div>
		</li>
	</ul>
	</form>
	<div class="btnArea">
		<a href="javascript:addNewLead();"><span>Add New Lead</span></a>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">