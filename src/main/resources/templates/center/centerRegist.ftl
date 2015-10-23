<#include "/include/header.ftl">
<!-- Main Content -->

<div class="content">
	<h2 class="conTit">Add New Center</h2>
	<ul class="list02 pt30">
	<form action="" name="centerForm" id="centerForm">
	<input type="hidden" name="deptCD" id="deptCD"  value="${deptCD?default('')}"/>
	<input type="hidden" name="statusCD" id="statusCD" value=""/>
	<input type="hidden" name="deptType" id="deptType" value=""/>
	<input type="hidden" name="memType" id="memType" value=""/>
	<input type="hidden" name="feeType" id="feeType" value=""/>	
		<li>
			<label for="" class="tit">Center Type <span class="must">*</span></label>
			<select name="centerType" id="centerType" style="width:323px">
				<option value="">-- SELECT A CENTER TYPE(사업+회비 형태) --</option>
				<#list centerTypeList as list>
					<option value="${list.centerType }">${list.centerTypeName }</option>
				</#list>				
			</select>	 		
		</li>		
		<li>
			<label for="" class="tit">Center Name <span class="must">*</span></label>
			<input type="text" name="deptName" id="deptName" class="searchInput" style="width:312px" maxlength="50" />
		</li>
		<li>
			<label for="" class="tit">Center Code</label>
			<strong>자동생성</strong>
		</li>
		<li>
			<label for="" class="tit">Director’s First Name <span class="must">*</span></label>
			<input type="text" name="empFstName" id="empFstName" class="searchInput" style="width:312px" maxlength="20" />
		</li>
		<li>
			<label for="" class="tit">Director’s Last Name <span class="must">*</span></label>
			<input type="text" name="empLstName" id="empLstName" class="searchInput" style="width:312px" maxlength="30" />
		</li>
		<li>
			<label for="" class="tit">Address </label>
			<input type="text" name="addr" id="addr" class="searchInput" style="width:312px" maxlength="100" />
		</li>
		<li>
			<label for="" class="tit">Zipcode</label>
			<input type="text" name="zip" id="zip" class="searchInput" style="width:312px" maxlength="6" />
		</li>
		<li>
			<label for="" class="tit">City</label>
			<input type="text" name="city" id="city" class="searchInput" style="width:312px" maxlength="50" />
		</li>
		<li>
			<label for="" class="tit">State <span class="must">*</span></label>
			<select name="stateCD" id="stateCD" style="width:323px">
				<option value="">-- SELECT A STATE --</option>
				<#list centerStates as state>
					<option value="${state.stateCD }">${state.stateName }</option>
				</#list>
			</select>			
		</li>
		<li>
			<label for="" class="tit">Email Address</label>
			<input type="text" name="email" id="email" class="searchInput" style="width:312px" maxlength="100" />
		</li>
		<li>
			<label for="" class="tit">Phone Number <span class="must">*</span></label>
			<input type="text" name="phone" id="phone" class="searchInput" style="width:312px" maxlength="15" />
		</li>
		<li>
			<label for="" class="tit">Fax Number</label>
			<input type="text" name="fax" id="fax" class="searchInput" style="width:312px" maxlength="15" />
		</li>
		<li>
			<label for="" class="tit">Contract Date <span class="must">*</span></label>
			<select name="contractTerm" id="contractTerm" style="width:97px">
				<option value="">-- Term --</option>
				<#list 1..3 as i>
				<option value="${i}">${i}</option>
				</#list>				
			</select>									
			<input type="text" name="contractMMDDYY" id="contractMMDDYY" class="searchInput" style="width:175px" readOnly >
			<input type="hidden" name="contractDate" id="contractDate"/>
			<a class="btn_calendar" id="contractDatePicker" style="cursor: pointer;">view calendar</a>	
		</li>
		<li>
			<label for="" class="tit">Open Date</label>
			<input type="text" name="openMMDDYY" id="openMMDDYY" class="searchInput" style="width:275px" readOnly >
			<input type="hidden" name="openDate" id="openDate"/>
			<a class="btn_calendar" id="openDatePicker" style="cursor: pointer;">view calendar</a>
		</li>
		<li>
			<label for="" class="tit">Royalty Charge <span class="must">*</span><a href="javascript:;" onClick="$.openRoyaltyGroupInfo();" class="btn_q">?</a></label>
			<#list rtyTypeList as list>
			<span class="radio_wrap"><input type="radio" value="${list.dtlCD }" name="rtyType" id="Group${list.dtlCD }" ><label class="radio_label" for="Group${list.dtlCD }"> ${list.dtlCDNME }</label></span>
			</#list>		
		</li>
	</ul>
	</form>
	<div class="btnArea">
		<a href="javascript:;" id="saveCenterInfo" ><span>Save Center Information</span></a>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">