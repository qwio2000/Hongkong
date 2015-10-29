<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<div class="clearfix">
				<div class="conLeft">
					<h2 class="conTit">Parent(Guardian) Information</h2>
					<input type="hidden" id="hkey" value="${memberReportFreeDiagInfos[0].hkey?default('') }"/>
					<input type="hidden" id="hkeys" value="${hKeys?default('') }"/>
					<div class="tbl01">
						<table>
							<colgroup>
								<col width="107px" />
								<col />
							</colgroup>
							<tbody>
								<tr>
									<th class="left">First Name</th>
									<td class="left">${memberReportFreeDiagInfos[0].GFstName?default('') }</td>
								</tr>
								<tr>
									<th class="left">Last Name</th>
									<td class="left">${memberReportFreeDiagInfos[0].GLstName?default('') }</td>
								</tr>
								<tr>
									<th class="left">Address</th>
									<td class="left">${memberReportFreeDiagInfos[0].addr?default('') }</td>
								</tr>
								<tr>
									<th>Email</th>
									<td class="left"><a href="#" class="link">${memberReportFreeDiagInfos[0].GEmail?default('') }</a> 
									<#if memberReportFreeDiagInfos[0].GEmail?default('') != ''><img src="${imgPath }/icon_mail.png" alt="mail" /></#if> 
									</td>
								</tr>
								<tr>
									<th>Phone</th>
									<td class="left">${memberReportFreeDiagInfos[0].GPhone?default('') }</td>
								</tr>
								<tr>
									<th>Cell Phone</th>
									<td class="left">${memberReportFreeDiagInfos[0].GCellPhone?default('') }</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="btnArea_icon clearfix">
						<!-- class= tooltip 추가, title=아이콘설명 추가 하면 동작 -->
						<a href="javascript:guardianInfoPop('02');" class="btn_info tooltip" title="<@spring.message 'member.report.tooltip.guardianupdate'/>"></a>
						 <a href="/fa/diagnosis/appointment/new?type=02&hkey=${memberReportFreeDiagInfos[0].hkey?default('') }" class="btn_doc tooltip"  title="<@spring.message 'member.report.tooltip.siblingfreediag'/>"></a>
						<span class="tooltip_Area"></span>
					</div>
				</div>
				<div class="conRight">
					<h2 class="conTit">Student Information</h2>
					<#list memberReportFreeDiagInfos as info>
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
									<td class="left">${info.omrBirth?default('') }</td>
								</tr>
								<tr>
									<th class="left">Grade</th>
									<td class="left">${info.omrHakName?default('') }</td>
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
									<td class="left">Free Diagnosed</td>
								</tr>
								<#if info.memberReportFreeDiagSubjInfos??>
								<#list info.memberReportFreeDiagSubjInfos as subj>
								<tr class="subject">
									<td colspan="2" class="left">
									<a href="#" class="btn_graph">${subj.kwamok?default('') }</a>
									<#if subj.memKey != ''>
									<span class="info_line"><span class="info_line_first">[ <a href="/fa/members/regist/new?type=2&memKey=${subj.memKey }&freeSubj=${subj.kwamok}&freeOmrDate=${subj.omrDate}&freeHkey=${subj.hkey}" class="blue">REGISTER</a> ]</span></span>
									<#else>
									<span class="info_line"><span class="info_line_first">[ <a href="/fa/members/regist/new?type=&appIdx=${subj.aidx }&freeSubj=${subj.kwamok}&freeOmrDate=${subj.omrDate}&freeHkey=${subj.hkey}" class="blue">REGISTER</a> ]</span></span>
									</#if>
									<span class="info_line"></span>
									<!-- DIAG -->
									<#if subj.digYN == 'Y'>
										<#if subj.memKey != ''>
										<span class="info_line_first"><a href="javascript:$.openPop('/fa/diagnosis/ippr?memKey=${subj.memKey }&subj=${subj.kwamok }&freejindan=I', 'FilePop', 'width=1024,height=800,left=300,scrollbars=yes,resizable=yes');" class="blue">DIAG</a></span>
										<#else>
										<span class="info_line_first"><a href="javascript:$.openPop('/fa/diagnosis/ippr?memKey=${subj.aidx }&subj=${subj.kwamok }&freejindan=A', 'FilePop', 'width=1024,height=800,left=300,scrollbars=yes,resizable=yes');" class="blue">DIAG</a></span>
										</#if>
									<#else>
										<span class="info_line_first gray">DIAG</span>
									</#if>
									<!-- IPPR -->
									<#if subj.digYN == 'Y' && subj.omrDate != ''>
										<span class="info_line"><a href="javascript:$.openIpprPost('${subj.jisaCD }','${subj.omrDate }','${subj.hkey }','1','${subj.kwamok }', '${subj.kwamok?substring(0,1) }', 'Y', 'ipprDiv');" class="blue">IPPR</a></span>
									<#else>
										<span class="info_line gray">IPPR</span>
									</#if>
									</td>
								</tr>
								</#list>
								</#if>
							</tbody>
						</table>
					</div>
					<div class="btnArea_icon clearfix">
						<!-- class= tooltip 추가, title=아이콘설명 추가 하면 동작 -->
						<#if info.memKey != ''>
							<#assign key = info.memKey>
						<#else>
							<#assign key = info.hkey>
						</#if>
						<a href="javascript:addCommentCall('${key }','${info.MFstName} ${info.MLstName }');" class="btn_talk tooltip" title="<@spring.message 'member.report.tooltip.commentcall'/>"></a>
						<!--<a href="javascript:setMemberInfo('${info.memKey }')" class="btn_info tooltip" title="<@spring.message 'member.report.tooltip.memberinfoupdate'/>"></a>
						<a href="javascript:setMemSubjStudyInfo('${info.memKey }')" class="btn_date tooltip" title="<@spring.message 'member.report.tooltip.manageUpdate'/>"></a>
						<a href="/fa/members/regist/new?type=2&memKey=${info.memKey?default('') }" class="btn_doc_add tooltip" title="<@spring.message 'member.report.tooltip.othersubjectregist'/>"></a>
						<a href="javascript:getIpprs('${info.memKey }','${info.MFstName} ${info.MLstName }')" class="btn_all f_right tooltip" title="<@spring.message 'member.report.tooltip.ippr'/>"></a>-->
						<span class="tooltip_Area"></span>
					</div>
					</#list>
				</div>
			</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">