<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<div class="clearfix">
		<form id="registForm" name="registForm" action="/fa/diagnosis/appointment" method="post">
		<input type="hidden" name="idx" id="idx" value="${info.idx?default(0) }">
		<input type="hidden" name="type" id="type" value="${type}">
		<div class="conLeft">
			<h2 class="conTit">Parent(Guardian) Information</h2>
			<ul class="memSearch">
				<li>
					<label for="gFstName">First Name <#if type == "01"><span class="must">*</span></#if></label>
					<input type="text"  class="searchInput" name="gFstName" id="gFstName" style="width:334px" value="${info.GFstName?default('') }" <#if type != '01'>readonly</#if> maxlength='20'/>
				</li>
				<li>
					<label for="gLstName">Last Name <#if type == "01"><span class="must">*</span></#if></label>
					<input type="text"  class="searchInput" name="gLstName" id="gLstName" style="width:334px" value="${info.GLstName?default('') }" <#if type != '01'>readonly</#if> maxlength='30'/>
				</li>
				<li>
					<label for="addr">Address <#if type == "01"><span class="must">*</span></#if></label>
					<input type="text"  class="searchInput" name="addr" id="addr" style="width:334px" value="${info.addr?default('') }" maxlength='100' <#if type != '01'>readonly</#if>/>
				</li>
				<li>
					<label for="zip">Zipcode </label>
					<input type="text"  class="searchInput" name="zip" id="zip" style="width:334px" value="${info.zip?default('') }" maxlength='6' <#if type != '01'>readonly</#if>/>
				</li>
				<li>
					<label for="city">City / State</label>
					<input type="text"  class="searchInput" name="city" id="city" style="width:168px" value="${info.city?default('') }" maxlength='50' <#if type != '01'>readonly</#if>/>
					<select name="stateCD" id="stateCD" style="width:162px" <#if type != '01'>onFocus='this.initialSelect = this.selectedIndex;' onChange='this.selectedIndex = this.initialSelect;'</#if>>
						<option value="">STATE</option>
						<#list states as state>
							<option value="${state.stateCD }" <#if state == info.stateCD?default('')>selected</#if> >${state.stateName }</option>
						</#list>
					</select>
				</li>
				<li>
					<label for="gEmail">Email</label>
					<input type="text" name="gEmail" id="gEmail" class="searchInput" style="width:334px" value="${info.GEmail?default('') }" maxlength='100' <#if type != '01'>readonly</#if>/>
				</li>
				<li>
					<label for="gPhone">Phone <#if type == "01"><span class="must">*</span></#if></label>
					<input type="text" name="gPhone" id="gPhone" class="searchInput" style="width:334px" value="${info.GPhone?default('') }" maxlength='15' <#if type != '01'>readonly</#if>/>
				</li>
				<li>
					<label for="gCellPhone">Cell Phone <#if type == "01"><span class="must">*</span></#if></label>
					<input type="text" name="gCellPhone" id="gCellPhone" class="searchInput" style="width:334px" value="${info.GCellPhone?default('') }" maxlength='15' <#if type != '01'>readonly</#if>/>
				</li>
			</ul>
		</div>
		<div class="conRight">
			<h2 class="conTit">Student Information</h2>
			<ul class="memSearch">
				<li>
					<label for="mFstName">First Name <#if type != "03"><span class="must">*</span></#if></label>
					<input type="text"  class="searchInput" style="width:334px" name="mFstName" id="mFstName" value="${info.MFstName?default('') }" <#if type == '03'>readonly</#if> maxlength='20'/>
				</li>
				<li>
					<label for="mLstName">Last Name <#if type != "03"><span class="must">*</span></#if></label>
					<input type="text"  class="searchInput" style="width:334px" name="mLstName" id="mLstName" value="${info.MLstName?default('') }" <#if type == '03'>readonly</#if> maxlength='30'/>
				</li>
				<li>
					<label for="dobMonth">DOB <#if type != "03"><span class="must">*</span></#if></label>
					<select name="dobMonth" id="dobMonth" style="width:98px;margin-right:3px" <#if type == '03'>onFocus='this.initialSelect = this.selectedIndex;' onChange='this.selectedIndex = this.initialSelect;'</#if>>
						<#list months as month>
							<option value="${month.monthNum }" <#if month.monthNum == currentMonth>selected</#if>>${month.monthStr }</option>
						</#list>
					</select>
					<select name="dobDay" id="dobDay" style="width:98px;margin-right:3px" <#if type == '03'>onFocus='this.initialSelect = this.selectedIndex;' onChange='this.selectedIndex = this.initialSelect;'</#if>>
						<#list 1..maxDays as i>
							<#if i lt 10>
							<option value="0${i }" <#if i == currentDay>selected</#if>>0${i }</option>
							<#else>
							<option value="${i }" <#if i == currentDay>selected</#if>>${i }</option>
							</#if>
						</#list>
					</select>
					<input type="text"  class="searchInput" style="width:88px" name="dobYear" id="dobYear" value="${currentYear?c }" maxlength='4' <#if type == '03'>readonly</#if>/>
					<input type="hidden" id="hiddenPicker"/>
					<a class="btn_calendar" id="dobDatePicker" style="cursor: pointer;">view calendar</a>
				</li>
				<li>
					<label for="gradeCD">Grade <#if type != "03"><span class="must">*</span></#if></label>
					<select name="gradeCD" id="gradeCD" <#if type == '03'>onFocus='this.initialSelect = this.selectedIndex;' onChange='this.selectedIndex = this.initialSelect;'</#if>>
						<option value=""></option>
					<#list grades as grade>
						<option value="${grade.dtlCD }" <#if grade.dtlCD == info.gradeCD?default('')>selected</#if>>${grade.dtlCDNM }</option>
					</#list>
					</select>
				</li>
				<li>
					<label for="schoolName">School <#if type != "03"><span class="must">*</span></#if></label>
					<input type="text" name="schoolName" id="schoolName" class="searchInput" style="width:334px" value="${info.schoolName?default('') }" maxlength='50' <#if type == '03'>readonly</#if>/>
				</li>
				<li>
					<label for="mEmail">Email</label>
					<input type="text" name="mEmail" id="mEmail" class="searchInput" style="width:334px" value="${info.MEmail?default('') }" maxlength='100' <#if type == '03'>readonly</#if>/>
				</li>
				<li>
					<label for="eContact">Emrg Contact</label>
					<input type="text" name="eContact" id="eContact" class="searchInput" style="width:334px" value="${info.EContact?default('') }" maxlength='50' <#if type == '03'>readonly</#if>/>
				</li>
				<li>
					<label for="ePhone">Emrg Phone</label>
					<input type="text" name="ePhone" id="ePhone" class="searchInput" style="width:334px" value="${info.EPhone?default('') }" maxlength='15' <#if type == '03'>readonly</#if>/>
				</li>
				<li>
					<label for="preferredYMD" class="tit">Preferred Time <span class="must">*</span></label>
					<input type="text" class="searchInput" style="width:170px" id="preferredYMD" name="preferredYMD" readonly="readonly">
					<input type="hidden" id="hiddenPrePicker"/>
					<a class="btn_calendar" id="preferredYMDPicker" style="cursor: pointer;">view calendar</a>
					<select name="preferredTimes" id="preferredTimes" style="width:121px;margin-left:4px">
						<#list manageTimes as manageTime>
							<option value="${manageTime.dtlCD }">${manageTime.dtlCDNM }</option>
						</#list>
					</select>
				</li>
				<li>
					<label for="preferredNotes" class="tit">Notes <span class="must">*</span></label>
					<input type="text" class="searchInput" style="width:334px" name="preferredNotes" id="preferredNotes">
				</li>
				<li>
					<label for="subj" class="tit"><em>Subject Interested <span class="must">*</span></em></label>
					<div style="width:345px; float:right;">
					<#list subjectOfDepts as subject>
						<#if type == "03">
							<#assign check = '0'>
							<#list info.subj?split(',') as subj>
								<#if subj == subject.subj>
									<span class="chk_s01"><input type="checkbox" name="subj" value="${subject.subj }" id="chk${subject_index+1 }" disabled><label style="width: 50px;" for="chk${subject_index+1 }">${subject.subj }</label></span>
									<#assign check = '1'>
								</#if>
							</#list>
							<#if check != '1'>
								<span class="chk_s01"><input type="checkbox" name="subj" value="${subject.subj }" id="chk${subject_index+1 }" ><label style="width: 50px;" for="chk${subject_index+1 }">${subject.subj }</label></span>
							</#if>
						<#else>
							<span class="chk_s01"><input type="checkbox" name="subj" value="${subject.subj }" id="chk${subject_index+1 }" ><label style="width: 50px;" for="chk${subject_index+1 }">${subject.subj }</label></span>
						</#if>
					</#list>
					</div>
				</li>
			</ul>
			<div class="btnArea">
				<a id="registBtn" style="cursor: pointer;"><span>Save Information</span></a>
				<a href="/fa/diagnosis/appointment"><span>Cancel</span></a>
			</div>
		</div>
		</form>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
