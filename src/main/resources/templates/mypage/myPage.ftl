<#include "/include/header.ftl">
<script type="text/javascript">
<!--
	if ("${chk}"=="N") {
		alert("정보가 없습니다.");
		history.back();
		//location.href = "/ja/centers/centerSearch";
	}
//-->
</script>
<!-- Main Content -->		
<div class="content">
	<div class="clearfix">
		<div class="conLeft">
			<h2 class="conTit">Information</h2>
			<div class="tbl01">
				<table>
					<colgroup>
						<col width="155px" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th>User</th>
							<td class="left"><div class="clearfix"><span class="area_left">${userInfo.userId}</span> <span class="area_right"><a href="javascript:$.openMyEditUser('${userInfo.deptCD}','${userInfo.userId}');" class="btn_icon btn_info"></a></span></div></td>
						</tr>						
						<tr>
							<th>Email Address</th>
							<td class="left">${userInfo.email?default('')}</td>
						</tr>
						<tr>
							<th>Phone Number</th>
							<td class="left">${userInfo.phone?default('')}</td>
						</tr>
						<tr>
							<th>Username</th>
							<td class="left">${userInfo.userName}</td>
						</tr>												
					</tbody>
				</table>
			</div>
		</div>
		<#if userInfo.dutyCD == "J0">
		<div class="conRight">
			<h2 class="conTit">Users</h2>
			<#list userList as list>
			<div class="tbl01">
				<table>
					<colgroup>
						<col width="155px" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th class="left">User</th>
							<td class="left"><div class="clearfix"><span class="area_left">${list.userId}</span> <span class="area_right"><a href="javascript:$.openEditUser('${list.deptCD}','${list.userId}','myPage');" class="btn_icon btn_info"></a></span></div></td>
						</tr>
						<tr>
							<th class="left">User Level</th>
							<td class="left">${list.userLevelName}</td>
						</tr>
						<tr>
							<th class="left">Email Address</th>
							<td class="left">${list.email}</td>
						</tr>
						<tr>
							<th class="left">Username</th>
							<td class="left">${list.userName}</td>
						</tr>						
						<tr>
							<th class="left">Status</th>
							<td class="left">${list.userStatusName}</td>
						</tr>
					</tbody>
				</table>
			</div>
			</#list>
			<div class="btnArea_txt">
				<a href="javascript:$.openAddNewUser('${centerInfo.deptCD}','${centerInfo.addUserFlag}','myPage');" class="btn_doc">add new user</a>
			</div>
		</div>
		</#if>
	</div>
</div>
		
<!--// Main Content -->
<#include "/include/footer.ftl">		