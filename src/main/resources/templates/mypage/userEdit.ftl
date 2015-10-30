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
			<input type="hidden" name="dutyCD" id="dutyCD"  value="${userInfo.dutyCD?default('')}"/>			
			<input type="hidden" name="userLevel" id="userLevel"  value="${userInfo.userLevel?default('')}"/>
			<input type="hidden" name="statusCD" id="statusCD"  value="${userInfo.statusCD?default('')}"/>
			<input type="hidden" name="oldUserPwd" id="oldUserPwd"  value="${userInfo.userPasswd?default('') }"/>
			<input type="hidden" name="pwdChgFlag" id="pwdChgFlag"  value=""/>
			
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
					<label for="" class="tit">Password <span class="must">*</span></label>
					<input type="password" name="userPwd" id="userPwd" class="searchInput" style="width:384px"  maxlength='20' >
				</li>
				<li>
					<label for="" class="tit">Retype Password <span class="must">*</span></label>
					<input type="password" name="reTypeUserPwd" id="reTypeUserPwd" class="searchInput" style="width:384px"  maxlength='20' >
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