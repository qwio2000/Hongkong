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
			<input type="hidden" name="deptCD" id="deptCD" value="${centerInfo.deptCD?default('')}"/>
			<input type="hidden" name="deptType" id="deptType" value="${centerInfo.deptType?default('')}"/>
			<input type="hidden" name="memType" id="memType" value="${centerInfo.memType?default('')}"/>
			<input type="hidden" name="feeType" id="feeType" value="${centerInfo.feeType?default('')}"/>
			<input type="hidden" name="contractTerm" id="contractTerm" value="${centerInfo.contractTerm?default('')}"/>
			<input type="hidden" name="contractMMDDYY" id="contractMMDDYY" value="${centerInfo.contractDate?default('')}" />
			<input type="hidden" name="contractDate" id="contractDate"/>						
			<input type="hidden" name="openMMDDYY" id="openMMDDYY" value="${centerInfo.openDate?default('')}" />
			<input type="hidden" name="openDate" id="openDate"/>
			<input type="hidden" name="statusCD" id="statusCD" value="${centerInfo.statusCD?default('')}" />
			<input type="hidden" name="rtyType" id="rtyType" value="${centerInfo.rtyType?default('')}" />
						
			<ul class="list02">
				<li>
					<label for="" class="tit">Center Name <span class="must">*</span></label>
					<input type="text" name="deptName" id="deptName" value="${centerInfo.deptName?default('')}" class="searchInput" style="width:384px" maxlength="50" readOnly/>					
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