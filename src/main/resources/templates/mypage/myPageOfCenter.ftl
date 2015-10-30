<#include "/include/header.ftl">
<script type="text/javascript">
<!--
	if ("${chk}"=="N") {
		alert("정보가 없습니다.");
		history.back();
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
							<th class="left">Address</th>
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
							<td class="left">Hours : <strong>${centerInfo.hoursFlag?default('')}</strong>, subjects : <strong>${centerInfo.openSubjFlag?default('')}</strong> , tuition : <strong>YES</strong></td>
						</tr>				
					</tbody>
				</table>
			</div>
			<#if loginInfo.empKey == centerInfo.empKey>
			<div class="clearfix btnArea_txt">
				<a href="javascript:$.openCenterInfoUpd('${centerInfo.deptCD?default('')}');" class="btn_info" style="padding-left:38px"> Update Center Infomation</a>
			</div>
			<div class="clearfix btnArea_set">
				<a href="javascript:$.openCenterSetBusinessClassroomHours('${centerInfo.deptCD?default('')}','${centerInfo.OHoursStart?default('')}','${centerInfo.OHoursEnd?default('')}','${centerInfo.CHoursStart?default('')}','${centerInfo.CHoursEnd?default('')}');" class="btn btn_set">Set Business / Classroom Hours</a>
			</div>
			</#if>
		</div>
		<div class="conRight">
			<h2 class="conTit">Users</h2>
			<div class="tbl01">
				<table>
					<colgroup>
						<col width="155px" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th class="left">User</th>
							<td class="left">
								<div class="clearfix">
									<span class="area_left">${userInfo.userId?default('')}</span>
									<span class="area_right"><a href="javascript:$.openEditUser('${userInfo.deptCD?default('')}','${userInfo.userId?default('')}');" class="btn_icon btn_info"></a></span>
								</div>
							</td>
						</tr>
						<tr>
							<th class="left">User Level</th>
							<td class="left">${userInfo.userLevelName?default('')}</td>
						</tr>						
						<tr>
							<th class="left">Email Address</th>
							<td class="left">${userInfo.email?default('')}</td>
						</tr>
						<tr>
							<th class="left">Username</th>
							<td class="left">${userInfo.userName?default('')}</td>
						</tr>	
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
		
<!--// Main Content -->
<#include "/include/footer.ftl">		