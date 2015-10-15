<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top"><h1>New Appointment</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
		<div class="popup_content">
			<div class="pop_gm">
			<form action="" id="appointmentForm">
				<input type="hidden" name="memKey" value="${memKey }"/>
				<ul class="list02">
					<li>
						<label for="memName" class="tit">Student Name</label>
						<input type="text" id="memName" name="memName" class="searchInput" style="width:384px" value="${memName }" readonly="readonly">
					</li>
					<li>
						<label for="preferredYMD" class="tit">Preferred Time</label>
						<input type="text"  class="searchInput" style="width:233px" name="preferredYMD" id="preferredYMD" value="" readonly="readonly"/>
						<input type="hidden" id="hiddenPicker"/>
						<a class="btn_calendar" id="preferredYMDPicker" style="cursor: pointer;">view calendar</a>
						
						
						<select name="preferredTimes" id="preferredTimes" style="width:108px;margin-left:5px">
							<#list manageTimes as manageTime>
								<option value="${manageTime.dtlCD }">${manageTime.dtlCDNM }</option>
							</#list>
						</select>
					</li>
					<li>
						<label for="" class="tit">Notes</label>
						<input type="text" id="preferredNotes" name="preferredNotes" class="searchInput" style="width:384px" maxlength="500">
					</li>
					<li>
						<label for="" class="tit">Subject Interested</label>
						<#list subjects as subject>
						<#if subject_index == 5>
						<br/>
						</#if>
						<span class="chk_s01"><input type="checkbox" name="subj" value="${subject.subj }" id="chk${subject_index+1 }"><label for="chk${subject_index+1 }">${subject.subj }</label></span>
						</#list>
					</li>

				</ul>
				</form>
				<div class="btnArea">
					<a href="javascript:appointmentSubmit();"><span>Create Appointment</span></a>
				</div>
			</div>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">
