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
					<div class="btnArea_icon clearfix">
						<!-- class= tooltip 추가, title=아이콘설명 추가 하면 동작 -->
						<a href="#" class="btn_info tooltip" title="학부모 정보 추가/수정">학부모 정보 추가/수정</a>
						<a href="#" class="btn_member tooltip"  title="형제 회원 입회">형제 회원 입회</a>
						<a href="#" class="btn_doc tooltip"  title="형제회원 무료진단 입력">형제회원 무료진단 입력</a>
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
										<span class="info_line"><a href="#" class="<#if subj.digYN == 'Y'>blue<#else>gray</#if>">IPPR</a></span>
										<#if subj.isCancle == 'true'>
										<span class="info_line"><a href="#" class="blue">DROP.CANCLE</a></span>
										</#if>
										</#if>
									</td>
								</tr>
								<#if subj.statusCD == "1">
								<tr class="subject">
									<td colspan="2">
										<span class="info_line_first"><a href="#" class="<#if subj.digYN == 'Y'>blue<#else>gray</#if>">DIAG</a></span>
										<span class="info_line"><a href="#" class="<#if subj.digYN == 'Y'>blue<#else>gray</#if>">IPPR</a></span>
										<span class="info_line"><a href="#" class="<#if subj.digYN == 'Y'>blue<#else>gray</#if>">MPR</a></span>
										<span class="info_line"><a href="#" class="blue">DROP</a></span>
										<span class="info_line"><a href="#" class="<#if subj.isCancle == 'true'>blue<#else>gray</#if>">REG.CANCLE</a></span>
									</td>
								</tr>
								</#if>
								</#list>
							</tbody>
						</table>
					</div>
					<div class="btnArea_icon clearfix">
						<!-- class= tooltip 추가, title=아이콘설명 추가 하면 동작 -->
						<a href="#" class="btn_talk tooltip" title="회원/학부모 상담이력 입력">회원/학부모 상담이력 입력</a>
						<a href="#" class="btn_clock tooltip"  title="입회상담 약속 입력">입회상담 약속 입력</a>
						<a href="#" class="btn_info tooltip"  title="회원 정보 추가 수정 ">회원 정보 추가 수정 </a>
						<a href="#" class="btn_date tooltip"  title="관리 횟수/요일/시간 변경">관리 횟수/요일/시간 변경</a>
						<a href="/fa/members/regist/new?type=2&memKey=${info.memKey?default('') }" class="btn_doc_add tooltip"  title="타과목 입회">타과목 입회</a>
						<span class="tooltip_Area"></span>
					</div>
					</#list>
				</div>
			</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">