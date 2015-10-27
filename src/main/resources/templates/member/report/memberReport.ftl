<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<div class="clearfix">
				<div class="conLeft">
					<h2 class="conTit">Parent(Guardian) Information</h2>
					<div class="tbl01">
						<table>
							<colgroup>
								<col width="107px" />
								<col />
							</colgroup>
							<tbody>
								<tr>
									<th class="left">First Name</th>
									<td class="left">${guardianInfo.GFstName?default('') }</td>
								</tr>
								<tr>
									<th class="left">Last Name</th>
									<td class="left">${guardianInfo.GLstName?default('') }</td>
								</tr>
								<tr>
									<th class="left">Address</th>
									<td class="left">${guardianInfo.addr?default('') }</td>
								</tr>
								<tr>
									<th>Email</th>
									<td class="left"><a href="#" class="link">${guardianInfo.GEmail?default('') }</a> 
									<#if guardianInfo.GEmail?default('') != ''><img src="${imgPath }/icon_mail.png" alt="mail" /></#if> 
									</td>
								</tr>
								<tr>
									<th>Phone</th>
									<td class="left">${guardianInfo.GPhone?default('') }</td>
								</tr>
								<tr>
									<th>Cell Phone</th>
									<td class="left">${guardianInfo.GCellPhone?default('') }</td>
								</tr>
							</tbody>
						</table>
					</div>
					<input type="hidden" id="memKey" value="${memKey?default('') }"/>
					<input type="hidden" id="memKeys" value="${memKeys?default('') }"/>
					<div class="btnArea_icon clearfix">
						<!-- class= tooltip 추가, title=아이콘설명 추가 하면 동작 -->
						<a href="javascript:guardianInfoPop();" class="btn_info tooltip" title="<@spring.message 'member.report.tooltip.guardianupdate'/>"></a>
						<a href="/fa/members/regist/new?type=3&memKey=${memKey }" class="btn_member tooltip"  title="<@spring.message 'member.report.tooltip.siblingregist'/>"></a>
						<a href="#" class="btn_doc tooltip"  title="<@spring.message 'member.report.tooltip.siblingfreediag'/>"></a>
						<span class="tooltip_Area"></span>
					</div>
				</div>
				<div class="conRight">
					<h2 class="conTit">Student Information</h2>
					<#list memberReportInfos as info>
					<div class="tbl01">
						<table>
							<colgroup>
								<col width="107px" />
								<col />
							</colgroup>
							<tbody>
								<tr>
									<th class="left">First Name</th>
									<td class="left">${info.MFstName?default('') }</td>
								</tr>
								<tr>
									<th class="left">Last Name</th>
									<td class="left">${info.MLstName?default('') }</td>
								</tr> 
								<tr>
									<th class="left">DOB</th>
									<td class="left">${info.MBirthDay?default('') }</td>
								</tr>
								<tr>
									<th class="left">Grade</th>
									<td class="left">${info.gradeName?default('') }</td>
								</tr>
								<tr>
									<th class="left">School</th>
									<td class="left">${info.schoolName?default('') }</td>
								</tr>
								<tr>
									<th class="left">Email</th>
									<td class="left">${info.MEmail?default('') }</td>
								</tr>
								<tr>
									<th class="left">Emrg Contact</th>
									<td class="left">${info.EContact?default('') }</td>
								</tr>
								<tr>
									<th class="left">Emrg Phone</th>
									<td class="left">${info.EPhone?default('') }</td>
								</tr>
								<tr>
									<th class="left">Reg Date</th>
									<td class="left">${info.regDate?string('MM/dd/yyyy') }</td>
								</tr>
								<tr>
									<th class="left">Status</th>
									<td class="left">${info.statusName?default('') }</td>
								</tr>
								<tr>
									<th class="left">Remarks</th>
									<td class="left">${info.remarks?default('') }</td>
								</tr>
								<#list info.memberReportSubjInfos as subj>
								<tr class="subject">
									<td colspan="2" class="left">
										<a href="#" class="btn_graph">${subj.subj?default('') }</a>
									<#if subj.statusCD == "1">
										<span class="info_line">Since ${subj.convertRegistYMD }</span>
										<span class="info_line">${subj.yoilName?default('') }</span>
										<span class="info_line">${subj.visitHourName?default('') }</span>
									<#else>
										<span class="info_line">Drop Date : ${subj.convertDropYMD?default('') }</span>
										<!-- 퇴회 상태 IPPR -->
										<#if subj.digYN == 'Y' && subj.omrDate != ''>
											<span class="info_line"><a href="javascript:$.openIpprPost('${subj.jisaCD }','${subj.omrDate }','${subj.memKey }','0','${subj.subj }', '${subj.subj?substring(0,1) }', 'Y', 'ipprDiv');" class="blue">IPPR</a></span>
										<#else>
											<span class="info_line gray">IPPR</span>
										</#if>
										<!-- 퇴회 취소 -->
										<#if subj.isCancle == 'true'>
											<span class="info_line"><a href="javascript:dropCancelMember('${subj.memKey }','${subj.subj }', '${subj.convertDropYMD?default('') }');" class="blue">DROP.CANCEL</a></span>
										<#else>
											<span class="info_line gray">DROP.CANCEL</span>
										</#if>
									</#if>
									</td>
								</tr>
								<#if subj.statusCD == "1">
								<tr class="subject">
									<td colspan="2">
										<!-- DIAG -->
										<#if subj.digYN == 'Y'>
											<span class="info_line_first"><a href="javascript:$.openPop('/fa/diagnosis/ippr?memKey=${subj.memKey }&subj=${subj.subj }&freejindan=', 'FilePop', 'width=1024,height=800,left=300,scrollbars=yes,resizable=yes');" class="blue">DIAG</a></span>
										<#else>
											<span class="info_line_first gray">DIAG</span>
										</#if>
										<!-- IPPR -->
										<#if subj.digYN == 'Y' && subj.omrDate != ''>
											<span class="info_line"><a href="javascript:$.openIpprPost('${subj.jisaCD }','${subj.omrDate }','${subj.memKey }','0','${subj.subj }', '${subj.subj?substring(0,1) }', 'Y', 'ipprDiv');" class="blue">IPPR</a></span>
										<#else>
											<span class="info_line gray">IPPR</span>
										</#if>
										<!-- MPR -->
										<#if subj.digYN == 'Y'>
											<span class="info_line"><a href="#" class="blue">MPR</a></span>
										<#else>
											<span class="info_line gray">MPR</span>
										</#if>
										<span class="info_line"><a href="javascript:dropMember('${subj.memKey }','${subj.subj }','${info.MFstName?default('') } ${info.MLstName?default('') }','${subj.convertRegistYMD }','${subj.isCancle }','${.now?string('MM/dd/yyyy') }');" class="blue">DROP</a></span>
										<#if subj.isCancle == 'true'>
											<span class="info_line"><a href="javascript:registCancel('${subj.memKey }','${subj.subj }')" class="blue">REG.CANCEL</a></span>
										<#else>
											<span class="info_line gray">REG.CANCEL</span>
										</#if>
									</td>
								</tr>
								</#if>
								</#list>
							</tbody>
						</table>
					</div>
					<div class="btnArea_icon clearfix">
						<!-- class= tooltip 추가, title=아이콘설명 추가 하면 동작 -->
						<a href="javascript:addCommentCall('${info.memKey }','${info.MFstName} ${info.MLstName }');" class="btn_talk tooltip" title="<@spring.message 'member.report.tooltip.commentcall'/>"></a>
						<a href="javascript:addAppointment('${info.memKey }','${info.MFstName} ${info.MLstName }');" class="btn_clock tooltip" title="<@spring.message 'member.report.tooltip.appointment'/>"></a>
						<a href="javascript:setMemberInfo('${info.memKey }')" class="btn_info tooltip" title="<@spring.message 'member.report.tooltip.memberinfoupdate'/>"></a>
						<a href="javascript:setMemSubjStudyInfo('${info.memKey }')" class="btn_date tooltip" title="<@spring.message 'member.report.tooltip.manageUpdate'/>"></a>
						<a href="/fa/members/regist/new?type=2&memKey=${info.memKey?default('') }" class="btn_doc_add tooltip" title="<@spring.message 'member.report.tooltip.othersubjectregist'/>"></a>
						<a href="javascript:getIpprs('${info.memKey }','${info.MFstName} ${info.MLstName }')" class="btn_all f_right tooltip" title="<@spring.message 'member.report.tooltip.ippr'/>"></a>
						<span class="tooltip_Area"></span>
					</div>
					</#list>
				</div>
			</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">