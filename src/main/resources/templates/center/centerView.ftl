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
			<h2 class="conTit">Center Information</h2>
			<div class="tbl01">
				<table>
					<colgroup>
						<col width="155px" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th class="left">Center Type</th>
							<td class="left">${centerInfo.deptTypeName?default('')} ${centerInfo.memTypeName?default('')} ${centerInfo.feeTypeName?default('')}</td>
						</tr>
						<tr>
							<th class="left">Center Code</th>
							<td class="left">${centerInfo.deptCD?default('')}</td>
						</tr>
						<tr>
							<th class="left">Center Name</th>
							<td class="left">${centerInfo.deptName?default('')}</td>
						</tr>
						<tr>
							<th class="left">Director</th>
							<td class="left">${centerInfo.empName?default('')}</td>
						</tr>
						<tr>
							<th class="left" rowspan="2">Address</th>
							<td class="left">${centerInfo.zip?default('')}</td>
						</tr>
						<tr>
							<td class="left">${centerInfo.addr?default('')}</td>
						</tr>
						<tr>
							<th>Email Address</th>
							<td class="left">${centerInfo.email?default('')}</td>
						</tr>
						<tr>
							<th>Phone Number</th>
							<td class="left">${centerInfo.phone?default('')}</td>
						</tr>
						<tr>
							<th>Fax Number</th>
							<td class="left">${centerInfo.fax?default('')}</td>
						</tr>
						<tr>
							<th>Contact Date</th>
							<td class="left">${centerInfo.contractDate?default('')}</td>
						</tr>
						<tr>
							<th>Open Date</th>
							<td class="left">${centerInfo.openDate?default('')}</td>
						</tr>
						<tr>
							<th>Royalty Charge</th>
							<td class="left">${centerInfo.rtyType?default('')} (${centerInfo.rtyTypeName?default('')})</td>
						</tr>
						<tr>
							<th>Center Infomation <br />has been set</th>
							<td class="left">Hours, tuition, subjects. <strong>YES</strong></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="clearfix btnArea_txt">
				<a href="javascript:$.openCenterCallLog('${centerInfo.deptCD}');" class="btn_member">Comments/Call Logs</a>
				<a href="javascript:$.openCenterInfoUpd('${centerInfo.deptCD}');" class="btn_info" style="padding-left:38px"> Update Center Infomation</a>
			</div>
			<div class="clearfix btnArea_set">
				<a href="javascript:$.openCenterSetBusinessClassroomHours('${centerInfo.deptCD}','${centerInfo.OHoursStart}','${centerInfo.OHoursEnd}','${centerInfo.CHoursStart}','${centerInfo.CHoursEnd}');" class="btn btn_set">Set Business / Classroom Hours</a>
				<a href="javascript:$.openCenterSetSubjPreference('${centerInfo.deptCD}');" class="btn btn_set">Set Subject Preference - subject(s) that this center offers</a>
				<span class="btn btn_set"><span class="t">Set Restock Qty : </span>
					<span class="c">
						<#list centerInfo.openSubj?split(",") as subj>
							<a href="javascript:$.goCenterSetRestockQty('${centerInfo.deptCD}','${subj}');">[${subj}]</a>
						</#list>
					</span>
				</span>
				<a href="javascript:$.openCenterSetTuitionMatrix('${centerInfo.deptCD}');" class="btn btn_set">Set Tuition Matrix</a>
			</div>
		</div>
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
							<td class="left"><div class="clearfix"><span class="area_left">${list.userId}</span> <span class="area_right"><a href="javascript:$.openEditUser('${list.userId}');" class="btn_icon btn_info"></a></span></div></td>
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
							<th class="left">Password</th>
							<td class="left"><a href="javascript:$.userPwdClear('${list.userId}');" class="">[Clear]</a></td>
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
				<a href="javascript:$.openAddNewUser('${centerInfo.deptCD}');" class="btn_doc">add new user</a>
			</div>
		</div>
	</div>
</div>
		
<!--// Main Content -->
<#include "/include/footer.ftl">		