<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top"><h1>Update Guardian Information</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
		<div class="popup_content">
			<form id="guardianForm" action="/fa/members/reports/guardian" method="post">
			<input type="hidden" name="memKeys" value="${memKeys?default('') }"/>
			<div class="pop_gm">
					<ul class="list02">
					<li>
						<label for="gFstName" class="tit">First Name</label>
						<input type="text" id="gFstName" name="gFstName" class="searchInput" style="width:384px" value="${guardianInfos.GFstName?default('') }" maxlength='20'>
					</li>
					<li>
						<label for="gLstName" class="tit">Last Name</label>
						<input type="text" id="gLstName" name="gLstName" class="searchInput" style="width:384px" value="${guardianInfos.GLstName?default('') }" maxlength='30'>
					</li>
					<li>
						<label for="addr" class="tit">Address</label>
						<input type="text" id="addr" name="addr" class="searchInput" style="width:384px" value="${guardianInfos.addr?default('') }" maxlength='100'>
						<span class="next_input">
							<input type="text" id="city" name="city" class="searchInput" style="width:118px;margin-right:3px" placeholder="City" value="${guardianInfos.city?default('') }" maxlength='50'>
							<select name="stateCD" id="stateCD" style="width:121px;margin-right:3px">
								<option value="">STATE</option>
								<#list states as state>
									<option value="${state.stateCD }" <#if guardianInfos.stateCD == state.stateCD>selected</#if>>${state.stateName }</option>
								</#list>
							</select>
							<input type="text" id="zip" name="zip" class="searchInput" style="width:118px" placeholder="Zip" value="${guardianInfos.zip?default('') }" maxlength='6'>
						</span>
					</li>
					<li>
						<label for="gEmail" class="tit">Email</label>
						<input type="text" id="gEmail" name="gEmail" class="searchInput" style="width:384px" value="${guardianInfos.GEmail?default('') }" maxlength='100'>
					</li>
					<li>
						<label for="gPhone" class="tit">Phone</label>
						<input type="text" id="gPhone" name="gPhone" class="searchInput" style="width:384px" value="${guardianInfos.GPhone?default('') }" maxlength='15'>
					</li>
					<li>
						<label for="gCellPhone" class="tit">Cell Phone</label>
						<input type="text" id="gCellPhone" name="gCellPhone" class="searchInput" style="width:384px" value="${guardianInfos.GCellPhone?default('') }" maxlength='15'>
					</li>
				</ul>
				<div class="btnArea">
					<a href="javascript:guardianInfoSubmit();"><span>Update Guardian Information</span></a>
				</div>
			</div>
			</form>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">
