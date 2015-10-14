<#include "/include/header.ftl">
<!-- Main Content -->
<#if type == "1">
	<#if memAppointment??>
		<#if memAppointment.memKey == "">
			<#assign info = memAppointment>
		</#if>	
	<#else>
		<#assign info = memMst>
	</#if>
<#elseif type == "2">
	<#assign info = memMst>
<#elseif type == "3">
	<#assign info = guardianInfo>
</#if>
<div class="content">
	<div class="clearfix">
		<form id="registForm" name="registForm" action="/fa/members" method="post">
		<input type="hidden" name="type" value="${type }">
		<input type="hidden" name="memKey" value="${memKey?default('') }">
		<input type="hidden" id="appIdx" name="appIdx" value="${appIdx?default('0') }">
		<div class="conLeft">
			<h2 class="conTit">Parent(Guardian) Information</h2>
			<ul class="memSearch">
				<li>
					<label for="gFstName">First Name <span class="must">*</span></label>
					<input type="text"  class="searchInput" name="gFstName" id="gFstName" style="width:334px" value="${info.GFstName?default('') }" <#if type != '1'>readonly</#if> maxlength='20'/>
				</li>
				<li>
					<label for="gLstName">Last Name <span class="must">*</span></label>
					<input type="text"  class="searchInput" name="gLstName" id="gLstName" style="width:334px" value="${info.GLstName?default('') }" <#if type != '1'>readonly</#if> maxlength='30'/>
				</li>
				<li>
					<label for="addr">Address <span class="must">*</span></label>
					<input type="text"  class="searchInput" name="addr" id="addr" style="width:334px" value="${info.addr?default('') }" maxlength='100'/>
				</li>
				<li>
					<label for="zip">Zipcode</label>
					<input type="text"  class="searchInput" name="zip" id="zip" style="width:334px" value="${info.zip?default('') }" maxlength='6'/>
				</li>
				<li>
					<label for="city">City / State</label>
					<input type="text"  class="searchInput" name="city" id="city" style="width:168px" value="${info.city?default('') }" maxlength='50'/>
					<select name="stateCD" id="stateCD" style="width:162px">
						<option value="">STATE</option>
						<#list states as state>
							<option value="${state.stateCD }" <#if info.stateCD?default('') == state.stateCD>selected</#if>>${state.stateName }</option>
						</#list>
					</select>
				</li>
				<li>
					<label for="gEmail">Email</label>
					<input type="text" name="gEmail" id="gEmail" class="searchInput" style="width:334px" value="${info.GEmail?default('') }" maxlength='100'/>
				</li>
				<li>
					<label for="gPhone">Phone <span class="must">*</span></label>
					<input type="text" name="gPhone" id="gPhone" class="searchInput" style="width:334px" value="${info.GPhone?default('') }" maxlength='15'/>
				</li>
				<li>
					<label for="gCellPhone">Cell Phone <span class="must">*</span></label>
					<input type="text" name="gCellPhone" id="gCellPhone" class="searchInput" style="width:334px" value="${info.GCellPhone?default('') }" maxlength='15'/>
				</li>
			</ul>
			<div class="question_list">
				<p>· Why do you wish to entoll your child?</p>
				<ul>
					<#list registWhys as registWhy>
						<#if registWhy.dtlCD == "99">
						<li>
							<span class="radio_wrap">
								<input type="radio" value="${registWhy.dtlCD }" name="registWhy" id="registWhy_num${registWhy_index+1 }" <#if registWhy.dtlCD == info.registWhy?default('')>checked</#if>/>
								<label class="radio_label" for="registWhy_num${registWhy_index+1 }"> Other,please explain</label>
								<input type="text"  class="searchInput" name="registWhyEtc" id="registWhyEtc" style="width:280px" value="${info.registWhyEtc?default('') }" <#if info.registWhyEtc?default('') == ''>disabled</#if> maxlength='30'/>
							</span>
						</li>
						<#else>
						<li>
							<span class="radio_wrap">
								<input type="radio" value="${registWhy.dtlCD }" name="registWhy" id="registWhy_num${registWhy_index+1 }" <#if registWhy.dtlCD == info.registWhy?default('')>checked</#if>/>
								<label class="radio_label" for="registWhy_num${registWhy_index+1 }"> ${registWhy.dtlCDNM }</label>
							</span>
						</li>
						</#if>
					</#list>
				</ul>
			</div>

			<div class="question_list">
				<p>· How did you hear about JEI Learning Centers?</p>
				<ul>
					<#list registHows as registHow>
						<#if registHow.dtlCD == "99">
						<li>
							<span class="radio_wrap">
								<input type="radio" value="${registHow.dtlCD }" name="registHow" id="registHow_num${registHow_index+1 }" <#if registHow.dtlCD == info.registHow?default('')>checked</#if>/>
								<label class="radio_label" for="registHow_num${registHow_index+1 }"> Other,please explain</label>
								<input type="text"  class="searchInput" name="registHowEtc" id="registHowEtc" style="width:280px" value="${info.registHowEtc?default('') }" <#if info.registHowEtc?default('') == ''>disabled</#if> maxlength='30'/>
							</span>
						</li>
						<#else>
						<li>
							<span class="radio_wrap">
								<input type="radio" value="${registHow.dtlCD }" name="registHow" id="registHow_num${registHow_index+1 }" <#if registHow.dtlCD == info.registHow?default('')>checked</#if>/>
								<label class="radio_label" for="registHow_num${registHow_index+1 }"> ${registHow.dtlCDNM }</label>
							</span>
						</li>
						</#if>
					</#list>
				</ul>
			</div>

		</div>
		<div class="conRight">
			<h2 class="conTit">Student Information</h2>
			<ul class="memSearch">
				<li>
					<label for="mFstName">First Name <span class="must">*</span></label>
					<input type="text"  class="searchInput" style="width:334px" name="mFstName" id="mFstName" value="${info.MFstName?default('') }" <#if type == '2'>readonly</#if> maxlength='20'/>
				</li>
				<li>
					<label for="mLstName">Last Name <span class="must">*</span></label>
					<input type="text"  class="searchInput" style="width:334px" name="mLstName" id="mLstName" value="${info.MLstName?default('') }" <#if type == '2'>readonly</#if> maxlength='30'/>
				</li>
				<li>
					<label for="dobMonth">DOB <span class="must">*</span></label>
					<select name="dobMonth" id="dobMonth" style="width:98px;margin-right:3px">
						<#list months as month>
							<option value="${month.monthNum }" <#if month.monthNum == currentMonth>selected</#if>>${month.monthStr }</option>
						</#list>
					</select>
					<select name="dobDay" id="dobDay" style="width:98px;margin-right:3px">
						<#list 1..maxDays as i>
							<#if i lt 10>
							<option value="0${i }" <#if i == currentDay>selected</#if>>0${i }</option>
							<#else>
							<option value="${i }" <#if i == currentDay>selected</#if>>${i }</option>
							</#if>
						</#list>
					</select>
					<input type="text"  class="searchInput" style="width:88px" name="dobYear" id="dobYear" value="${currentYear?c }" maxlength='4'/>
					<input type="hidden" id="hiddenPicker"/>
					<a class="btn_calendar" id="dobDatePicker" style="cursor: pointer;">view calendar</a>
				</li>
				<li>
					<label for="gradeCD">Grade <span class="must">*</span></label>
					<select name="gradeCD" id="gradeCD">
						<option value=""></option>
					<#list grades as grade>
						<option value="${grade.dtlCD }" <#if grade.dtlCD == info.gradeCD?default('')>selected</#if>>${grade.dtlCDNM }</option>
					</#list>
					</select>
				</li>
				<li>
					<label for="schoolName">School <span class="must">*</span></label>
					<input type="text" name="schoolName" id="schoolName" class="searchInput" style="width:334px" value="${info.schoolName?default('') }" maxlength='50'/>
				</li>
				<li>
					<label for="mEmail">Email</label>
					<input type="text" name="mEmail" id="mEmail" class="searchInput" style="width:334px" value="${info.MEmail?default('') }" maxlength='100'/>
				</li>
				<li>
					<label for="eContact">Emrg Contact</label>
					<input type="text" name="eContact" id="eContact" class="searchInput" style="width:334px" value="${info.EContact?default('') }" maxlength='50'/>
				</li>
				<li>
					<label for="ePhone">Emrg Phone</label>
					<input type="text" name="ePhone" id="ePhone" class="searchInput" style="width:334px" value="${info.EPhone?default('') }" maxlength='15'/>
				</li>
				<li>
					<span class="textarea_wrap"><label for="remarks">Remarks</label> <textarea name="remarks" id="remarks" cols="15" rows="10" maxlength="500">${info.remarks?default('') }</textarea><span class="max">Max 500</span><span class="max_char_txt">You have 500 chracters left</span></span>
				</li>
			</ul>
			<div class="select_list">
				<p>Select Subject(s) and visit hour(s)</p>
				<ul>
				<#if registSubjects??>
				<#list registSubjects as registSubject>
					<#if registSubject.memKey?? && registSubject.statusCD == "1">
						<li>
							<span class="chk_s01"><img src="${imgPath }/btn_check2_on.png" alt="" /> <label for="yoil">${registSubject.subj }</label></span>
							<select name="yoil" id="yoil" style="width:116px;margin-right:3px" disabled>
									<option value="${registSubject.yoil }" >${registSubject.yoilName }</option>
							</select>
							<select name="manageTime" id="manageTime" style="width:110px" disabled>
									<option value="${registSubject.visitHours }" >${registSubject.visitHoursName }</option>
							</select>
						</li>
					<#else>
						<li>
							<input type="hidden" id="studyNum_${registSubject.subj }" name="studyNum" value="${registSubject.subjStudyNum }" disabled/>
							<input type="hidden" id="monthNum_${registSubject.subj }" name="monthNum" value="${registSubject.subjMonthNum }" disabled/>
							<input type="hidden" id="bookNum_${registSubject.subj }" name="bookNum" value="${registSubject.subjBookNum }" disabled/>
							<input type="hidden" id="isResume_${registSubject.subj }" name="isResume" value="${registSubject.statusCD?default('1') }" disabled/>
							<#if appSubjs??>
							<span class="chk_s01"><input type="checkbox" name="subj" value="${registSubject.subj }" id="chk_${registSubject.subj }" 
								<#list appSubjs as appSubj><#if appSubj == registSubject.subj>checked</#if> </#list> />
							<#else>
							<span class="chk_s01"><input type="checkbox" name="subj" value="${registSubject.subj }" id="chk_${registSubject.subj }" />
							</#if>
							<#if registSubject.memKey?? && registSubject.statusCD == "2">
								<label for="chk_${registSubject.subj }"><font color="blue">${registSubject.subj }</font></label>
							<#else>
								<label for="chk_${registSubject.subj }">${registSubject.subj }</label>
							</#if>
							</span>
							<select name="firstManageDate" id="firstManageDate_${registSubject.subj }" style="width:116px;margin-right:3px" disabled>
								<#list firstManageDates as manageDate>
									<option value="${manageDate }" >${manageDate }</option>
								</#list>
							</select>
							<select name="manageTime" id="manageTime_${registSubject.subj }" style="width:110px;" disabled>
								<#list manageTimes as manageTime>
									<option value="${manageTime.dtlCD }">${manageTime.dtlCDNM }</option>
								</#list>
							</select>
							<input type="text"  class="searchInput" name="fee" id="fee_${registSubject.subj }" style="width:53px;" readonly="readonly" disabled/>
							<#if registSubject.subjDigYN == "Y">
							<a href="javascript:$.openPop('/fa/diagnosis/ippr?memKey=${info.memKey }&subj=${registSubject.subj }&freejindan=', 'FilePop', 'width=1024,height=800,left=300,scrollbars=yes,resizable=yes');">DIAG</a>
							</#if>
						</li>
					</#if>
				</#list>
				<#else>
					<#list subjectOfDepts as subject>
						<li>
							<input type="hidden" id="studyNum_${subject.subj }" name="studyNum" value="${subject.studyNum }" disabled/>
							<input type="hidden" id="monthNum_${subject.subj }" name="monthNum" value="${subject.monthNum }" disabled/>
							<input type="hidden" id="bookNum_${subject.subj }" name="bookNum" value="${subject.bookNum }" disabled/>
							<input type="hidden" id="isResume_${subject.subj }" name="isResume" value="1" disabled/>
							<#if appSubjs??>
							<span class="chk_s01"><input type="checkbox" name="subj" value="${subject.subj }" id="chk_${subject.subj }" 
								<#list appSubjs as appSubj><#if appSubj == subject.subj>checked</#if> </#list> />
							<#else>
							<span class="chk_s01"><input type="checkbox" name="subj" value="${subject.subj }" id="chk_${subject.subj}"/>
							</#if>
								<label for="chk_${subject.subj}">${subject.subj }</label>
							</span>
							<select name="firstManageDate" id="firstManageDate_${subject.subj }" style="width:120px;margin-right:3px" disabled>
								<#list firstManageDates as manageDate>
									<option value="${manageDate }" >${manageDate }</option>
								</#list>
							</select>
							<select name="manageTime" id="manageTime_${subject.subj }" style="width:120px;" disabled>
								<#list manageTimes as manageTime>
									<option value="${manageTime.dtlCD }">${manageTime.dtlCDNM }</option>
								</#list>
							</select>
							<input type="text" name="fee" id="fee_${subject.subj }" class="searchInput" style="width:61px;" readonly="readonly" disabled/>
						</li>
					</#list> 
				</#if>
				</ul>
			</div>
			<div class="btnArea">
				<a id="registBtn" style="cursor: pointer;"><span>Save Information</span></a>
				<a href="/fa/members/regist"><span>Cancel</span></a>
			</div>
		</div>
		</form>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
