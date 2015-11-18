<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>Add New User</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_jisa">
			<form action="" name="userForm" id="userForm">
			<input type="hidden" name="deptCD" id="deptCD"  value="${deptCD?default('')}"/>		
			<input type="hidden" name="userId" id="userId" value="${userId?default('')}"/>			
			<input type="hidden" name="statusCD" id="statusCD" value="${statusCD?default('')}"/>
			<input type="hidden" name="userType" id="userType" value="${userType?default('')}"/>
			<input type="hidden" name="jobFlag" id="jobFlag" value="${jobFlag?default('')}"/>
			
			<ul class="list02">
				<li>
					<label for="" class="tit">Center Name</label>
					<strong>${centerInfo.deptName }</strong>
				</li>

				<#if jobFlag == "myPage">
				<li>
					<label for="" class="tit">User ID</label>
					<input type="text" name="newUserId" id="newUserId" class="searchInput" style="width:175px"  maxlength='10' > <a href="javascript:;" onClick="$.userIdChk();" >ID중복체크</a>
					<input type="hidden" name="newUserIdConf" id="newUserIdConf" value=""/>
					<input type="hidden" name="userIdChk" id="userIdChk" value=""/>					
				</li>				
				<input type="hidden" name="dutyCD" id="dutyCD" value="J1"/><!-- 지사스탭 -->
				<#else>
				<li>				
					<label for="" class="tit">User ID</label>
					<strong>자동생성</strong>					
				</li>								
				<li>
					<label for="" class="tit">User Duty <span class="must">*</span></label>
					<select name="dutyCD" id="dutyCD" style="width:187px;margin-right:3px">
						<option value="">-선택-</option>
						<option value="F0">Center Director</option>
						<option value="F1">Center Staff</option>		
					</select>
				</li>
				</#if>				
				<li>
					<label for="" class="tit">User Privilege <span class="must">*</span></label>
					<select name="userLevel" id="userLevel" style="width:187px;margin-right:3px">
						<option value="">-선택-</option>
						<#list userLevelList as list>
						<option value="${list.dtlCD }">${list.dtlCDNM }</option>
						</#list>
					</select>
				</li>				
				<li>
					<label for="" class="tit">User's First Name <span class="must">*</span></label>
					<input type="text" name="userFstName" id="userFstName" class="searchInput" style="width:384px"  maxlength='20' >
				</li>
				<li>
					<label for="" class="tit">User's Last Name <span class="must">*</span></label>
					<input type="text" name="userLstName" id="userLstName"class="searchInput" style="width:384px"  maxlength='30' >
				</li>
				<li>
					<label for="" class="tit">Email Address</label>
					<input type="text" name="email" id="email" class="searchInput" style="width:384px"  maxlength='100' >
				</li>
				<li>
					<label for="" class="tit">Phone <span class="must">*</span></label>
					<input type="text" name="phone" id="phone" class="searchInput" style="width:384px"  maxlength='15' >
				</li>
				<li>
					<label for="" class="tit">Title</label>
					<input type="text" name="title" id="title" class="searchInput" style="width:384px"  maxlength='50' >
				</li>
				<li>
					<label for="" class="tit">Department</label>
					<input type="text" name="department" id="department" class="searchInput" style="width:384px"  maxlength='50' >
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