<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>Update Appointment</h1> <a href="#" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_gm">
		<form id="appointmentForm">
			<input type="hidden" id="idx" value="${appointment.idx }"/>
			<ul class="list02">
				<li>
					<label for="memName" class="tit">Student Name</label>
					<span id="memName" class="text">${appointment.MFstName } ${appointment.MLstName }</span>
				</li>
				<li>
					<label for="preferredYMD" class="tit">Preferred Time</label>
					<input type="text" class="searchInput" style="width:220px" name="preferredYMD" id="preferredYMD" value="${appointment.convPreferredYMD }" readonly="readonly">
					<input type="hidden" id="hiddenPicker"/>
					<a class="btn_calendar" id="preferredYMDPicker" style="cursor: pointer;">view calendar</a>
					<select name="preferredTimes" id="preferredTimes" style="width:121px;margin-left:4px">
						<#list manageTimes as manageTime>
							<option value="${manageTime.dtlCD }" <#if manageTime.dtlCD == appointment.preferredTimes>selected</#if>>${manageTime.dtlCDNM }</option>
						</#list>
					</select>
				</li>
				<li>
					<label for="preferredNotes" class="tit">Notes</label>
					<input id="preferredNotes" name="preferredNotes" type="text" class="searchInput" style="width:384px" maxlength="500" value="${appointment.preferredNotes }">
				</li>
				<li>
					<label for="chk_s01" class="tit"><em>Subject Interested</em></label>
					<#list subjectOfDepts as subject>
						<#assign isCheck = 0>
						<#if appointment.subj?contains(",")>
							<#list appointment.subj?split(",") as subj>
								<#if subj == subject.subj>
									<#assign isCheck = 1>
								</#if>	
							</#list>
						<#else>
							<#if appointment.subj == subject.subj>
								<#assign isCheck = 1>
							</#if> 
						</#if>
						<span class="chk_s01"><input type="checkbox" name="subj" value="${subject.subj }" id="chk_${subject.subj }" <#if isCheck == 1>checked</#if>><label for="chk_${subject.subj }">${subject.subj }</label></span>
					</#list>
				</li>
			</ul>
			<div class="btnArea">
				<a href="javascript:appointmentUpdateSubmit();"><span>Update Appointment</span></a>
			</div>
		</form>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">
