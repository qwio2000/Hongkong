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
	<div class="popup_top"><h1>Edit User</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_jisa">
			<form action="" name="userForm" id="userForm">
			<input type="hidden" name="deptCD" id="deptCD"  value="${deptCD?default('')}"/>		
			<ul class="list02">
				<li>
					<label for="" class="tit">Center Name</label>
					<strong>${userInfo.deptName?default('') }</strong>
				</li>
				<li>
					<label for="" class="tit">User ID</label>
					<input type="text" name="userId" id="userId" value="${userInfo.userId?default('') }" class="searchInput" style="width:384px"  readOnly maxlength='20' >
				</li>				
				<li>
					<label for="" class="tit">User Duty <span class="must">*</span></label>
					<select name="dutyCD" id="dutyCD" style="width:187px;margin-right:3px">
						<option value="">-선택-</option>
						<option value="F0" <#if userInfo.dutyCD == "F0">selected</#if> >Center Director</option>
						<option value="F1" <#if userInfo.dutyCD == "F1">selected</#if> >Center Staff</option>		
					</select>
				</li>
				<li>
					<label for="" class="tit">User Privilege <span class="must">*</span></label>
					<select name="userLevel" id="userLevel" style="width:187px;margin-right:3px">
						<option value="">-선택-</option>
						<#list userLevelList as list>
						<option value="${list.dtlCD }" <#if list.dtlCD == userInfo.userLevel>selected</#if> >${list.dtlCDNM }</option>
						</#list>
					</select>
				</li>	
				<li>
					<label for="" class="tit">User's First Name <span class="must">*</span></label>
					<input type="text" name="userFstName" id="userFstName" value="${userInfo.userFstName?default('') }" class="searchInput" style="width:384px"  maxlength='20' >
				</li>
				<li>
					<label for="" class="tit">User's Last Name <span class="must">*</span></label>
					<input type="text" name="userLstName" id="userLstName" value="${userInfo.userLstName?default('') }" class="searchInput" style="width:384px"  maxlength='30' >
				</li>
				<li>
					<label for="" class="tit">Email Address</label>
					<input type="text" name="email" id="email" value="${userInfo.email?default('') }" class="searchInput" style="width:384px"  maxlength='100' >
				</li>
				<li>
					<label for="" class="tit">Phone <span class="must">*</span></label>
					<input type="text" name="phone" id="phone" value="${userInfo.phone?default('') }" class="searchInput" style="width:384px"  maxlength='15' >
				</li>
				<li>
					<label for="" class="tit">Title</label>
					<input type="text" name="title" id="title" value="${userInfo.title?default('') }" class="searchInput" style="width:384px"  maxlength='50' >
				</li>
				<li>
					<label for="" class="tit">Department</label>
					<input type="text" name="department" id="department" value="${userInfo.departMent?default('') }" class="searchInput" style="width:384px"  maxlength='50' >
				</li>
				<li>
					<label for="" class="tit">Password</label>
					<input type="hidden" name="userPwd" id="userPwd"  value="${userInfo.userPasswd?default('') }"/>
					<strong><a href="javascript:$.userPwdClear('');" class="">[Clear] </a></strong>
				</li>
				
				<li>
					<label for="" class="tit">Status</label>
					<span class="radio_wrap"><input type="radio" value="1" name="statusCD" id="Active" <#if userInfo.statusCD == "1">checked</#if> ><label class="radio_label" for="Active"> Active</label></span>
					<span class="radio_wrap"><input type="radio" value="0" name="statusCD" id="Inactive" <#if userInfo.statusCD == "0">checked</#if> ><label class="radio_label" for="Inactive"> Inactive</label></span>
				</li>
			</ul>
			<div class="btnArea">
				<a href="javascript:;" id="saveUserInfo" ><span>Save User Information</span></a>
			</div>
			</form>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">