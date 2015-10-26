<#include "/include/popupheader.ftl">
<script type="text/javascript">
<!--
	if ("${chk}"=="N") {
		alert("정보가 없습니다.");
		self.close();
	}
//-->
</script>
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>Update Enter Information</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_jisa">
			<form action="" name="centerForm" id="centerForm">
			<input type="hidden" name="deptType" id="deptType" value=""/>
			<input type="hidden" name="memType" id="memType" value=""/>
			<input type="hidden" name="feeType" id="feeType" value=""/>			
			<ul class="list02">
				<li>
					<label for="" class="tit">Center Type <span class="must">*</span></label>
					<select name="centerType" id="centerType" style="width:396px">
						<option value="">-- SELECT A CENTER TYPE(사업+회비 형태) --</option>
						<#list centerTypeList as list>
							<option value="${list.centerType }" <#if list.centerType == centerInfo.deptType +','+ centerInfo.memType +','+ centerInfo.feeType >selected</#if> >${list.centerTypeName }</option>
						</#list>				
						
					</select>
				</li>
				<li>
					<label for="" class="tit">Center Code <span class="must">*</span></label>
					<input type="text" name="deptCD" id="deptCD"  value="${centerInfo.deptCD?default('')}" class="searchInput" style="width:384px" readOnly />
				</li>
				<li>
					<label for="" class="tit">Center Name <span class="must">*</span></label>
					<input type="text" name="deptName" id="deptName" value="${centerInfo.deptName?default('')}" class="searchInput" style="width:384px" maxlength="50" />					
				</li>
				<li>
					<label for="" class="tit">Director’s First Name <span class="must">*</span></label>
					<input type="text" name="empFstName" id="empFstName" value="${centerInfo.empFstName?default('')}"  class="searchInput" style="width:384px" maxlength="20" />					
				</li>
				<li>
					<label for="" class="tit">Director’s Last Name <span class="must">*</span></label>
					<input type="text" name="empLstName" id="empLstName" value="${centerInfo.empLstName?default('')}" class="searchInput" style="width:384px" maxlength="30" />					
				</li>
				<li>
					<label for="" class="tit">Address</label>
					<input type="text" name="addr" id="addr" value="${centerInfo.addr?default('')}" class="searchInput" style="width:384px" maxlength="100" />					
				</li>
				<li>
					<label for="" class="tit">City</label>
					<input type="text" name="city" id="city" value="${centerInfo.city?default('')}" class="searchInput" style="width:384px" maxlength="50" />					
				</li>
				<li>
					<label for="" class="tit">State  <span class="must">*</span>/ Zipcode</label>
					<select name="stateCD" id="stateCD" style="width:187px;margin-right:3px">
						<option value="">-- SELECT A STATE --</option>
						<#list centerStates as state>
							<option value="${state.stateCD }" <#if state.stateCD == centerInfo.stateCD>selected</#if> >${state.stateName }</option>
						</#list>
					</select>						
					<input type="text" name="zip" id="zip" value="${centerInfo.zip?default('')}" class="searchInput" style="width:190px" maxlength="6" />
				</li>
				<li>
					<label for="" class="tit">Email Address</label>
					<input type="text" name="email" id="email" value="${centerInfo.email?default('')}" class="searchInput" style="width:384px" maxlength="100" />
				</li>
				<li>
					<label for="" class="tit">Phone Number <span class="must">*</span></label>
					<input type="text" name="phone" id="phone" value="${centerInfo.phone?default('')}" class="searchInput" style="width:384px" maxlength="15" />
				</li>
				<li>
					<label for="" class="tit">Fax Number</label>
					<input type="text" name="fax" id="fax" value="${centerInfo.fax?default('')}" class="searchInput" style="width:384px" maxlength="15" />
				</li>
				<li>
					<label for="" class="tit">Contract Date <span class="must">*</span></label>
					<select name="contractTerm" id="contractTerm" style="width:97px">
						<option value="">-- Term --</option>
						<#list 1..3 as i>
						<option value="${i}" <#if i == centerInfo.contractTerm>selected</#if> >${i}</option>
						</#list>
					</select>											
					<input type="text" name="contractMMDDYY" id="contractMMDDYY" value="${centerInfo.contractDate?default('')}" class="searchInput" style="width:248px" readOnly >
					<input type="hidden" name="contractDate" id="contractDate"/>
					<a class="btn_calendar" id="contractDatePicker" style="cursor: pointer;">view calendar</a>
				</li>
				<li>
					<label for="" class="tit">Open Date</label>
					<input type="text" name="openMMDDYY" id="openMMDDYY" value="${centerInfo.openDate?default('')}" class="searchInput" style="width:348px" readOnly >
					<input type="hidden" name="openDate" id="openDate"/>
					<a class="btn_calendar" id="openDatePicker" style="cursor: pointer;">view calendar</a>					
				</li>
				<li>
					<label for="" class="tit">Status <span class="must">*</span></label>
					<#list statusCDList as list>
					<span class="radio_wrap"><input type="radio" value="${list.dtlCD }" name="statusCD" id="statusCD${list.dtlCD }"  <#if list.dtlCD == centerInfo.statusCD>checked</#if> ><label class="radio_label" for="statusCD${list.dtlCD }"> ${list.dtlCDNM }</label></span>
					</#list>					
				</li>
				<li>
					<label for="" class="tit">Royalty Charge <span class="must">*</span><a href="javascript:;" onClick="$.openRoyaltyGroupInfo();" class="btn_q">?</a></label>
					<#list rtyTypeList as list>
					<span class="radio_wrap"><input type="radio" value="${list.dtlCD }" name="rtyType" id="Group${list.dtlCD }" <#if list.dtlCD == centerInfo.rtyType>checked</#if> ><label class="radio_label" for="Group${list.dtlCD }"> ${list.dtlCDNME }</label></span>
					</#list>
				</li>
			</ul>
			<div class="btnArea">
				<a href="javascript:;" id="saveCenterInfo" ><span>Save Center Information</span></a>
			</div>
			</form>			
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">