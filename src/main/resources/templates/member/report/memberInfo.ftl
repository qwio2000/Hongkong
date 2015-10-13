<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top"><h1>Update Student Information</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
		<div class="popup_content">
		<form action="" id="memberInfoForm">
		<input type="hidden" name="memKey" value="${memKey }"/>
				<div class="pop_gm">
					<ul class="list02">
					<li>
						<label for="mFstName" class="tit">First Name</label>
						<input type="text" id="mFstName" name="mFstName" class="searchInput" style="width:384px" value="${memMst.MFstName }">
					</li>
					<li>
						<label for="mLstName" class="tit">Last Name</label>
						<input type="text" id="mLstName" name="mLstName" class="searchInput" style="width:384px" value="${memMst.MLstName }">
					</li>
					<li>
						<label for="mBirthDay" class="tit">DOB</label>
						<input type="text"  class="searchInput" style="width:348px" name="mBirthDay" id="mBirthDay" value="${memMst.MBirthDay }" readonly="readonly"/>
						<input type="hidden" id="hiddenPicker"/>
						<a class="btn_calendar" id="mBirthDayPicker" style="cursor: pointer;">view calendar</a>
					</li>
					<li>
						<label for="gradeCD" class="tit">Grade</label>
						<select name="gradeCD" id="gradeCD" style="width:396px">
						<#list grades as grade>
							<option value="${grade.dtlCD }" <#if grade.dtlCD == memMst.gradeCD?default('')>selected</#if>>${grade.dtlCDNM }</option>
						</#list>
						</select>
					</li>
					<li>
						<label for="schoolName" class="tit">School</label>
						<input type="text" id="schoolName" name="schoolName" class="searchInput" style="width:384px" value="${memMst.schoolName }">
					</li>
					<li>
						<label for="eContact" class="tit">Emrg Contact</label>
						<input type="text" id="eContact" name="eContact" class="searchInput" style="width:384px" value="${memMst.EContact }">
					</li>
					<li>
						<label for="ePhone" class="tit">Emrg Phone</label>
						<input type="text" id="ePhone" name="ePhone" class="searchInput" style="width:384px" value="${memMst.EPhone }">
					</li>
<!-- 추후 생각 -->
<!-- 					<li> -->
<!-- 						<label for="statusCD" class="tit">Status</label> -->
<!-- 						<select name="statusCD" id="statusCD" style="width:396px"> -->
<!-- 							<option value="1">Active</option> -->
<!-- 							<option value="2">Dropped</option> -->
<!-- 						</select> -->
<!-- 					</li> -->
					<li>
						<label for="remarks" class="tit">Remarks</label>
						<div class="textarea_wrap">
							<textarea name="remarks" id="remarks" cols="30" rows="10" style="width:373px">${memMst.remarks }</textarea>
							<span class="max">Max 500</span>
							<div class="max_char_txt">You have 500 chracters left</div>
						</div>
					</li>
				</ul>
				<div class="btnArea">
					<a href="javascript:memberInfoSubmit();"><span>Update Student Information</span></a>
				</div>
			</div>
			</form>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">