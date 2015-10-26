<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<div class="clearfix">
		<form id="registForm" name="registForm" action="/fa/diagnosis/appointment" method="post">
		<input type="hidden" name="type" id="type" value="${type}">
		<input type="hidden" name="idx" id="idx" value="0">
		<div class="conLeft">
			<h2 class="conTit">Parent(Guardian) Information</h2>
			<ul class="memSearch">
				<li>
					<label for="gFstName">First Name <span class="must">*</span></label>
					<input type="text"  class="searchInput" name="gFstName" id="gFstName" style="width:334px" value="" maxlength='20'/>
				</li>
				<li>
					<label for="gLstName">Last Name <span class="must">*</span></label>
					<input type="text"  class="searchInput" name="gLstName" id="gLstName" style="width:334px" value="" maxlength='30'/>
				</li>
				<li>
					<label for="addr">Address <span class="must">*</span></label>
					<input type="text"  class="searchInput" name="addr" id="addr" style="width:334px" value="" maxlength='100'/>
				</li>
				<li>
					<label for="zip">Zipcode </label>
					<input type="text"  class="searchInput" name="zip" id="zip" style="width:334px" value="" maxlength='6' />
				</li>
				<li>
					<label for="city">City / State</label>
					<input type="text"  class="searchInput" name="city" id="city" style="width:168px" value="" maxlength='50' />
					<select name="stateCD" id="stateCD" style="width:162px">
						<option value="">STATE</option>
						<#list states as state>
							<option value="${state.stateCD }">${state.stateName }</option>
						</#list>
					</select>
				</li>
				<li>
					<label for="gEmail">Email</label>
					<input type="text" name="gEmail" id="gEmail" class="searchInput" style="width:334px" value="" maxlength='100'/>
				</li>
				<li>
					<label for="gPhone">Phone <span class="must">*</span></label>
					<input type="text" name="gPhone" id="gPhone" class="searchInput" style="width:334px" value="" maxlength='15'/>
				</li>
				<li>
					<label for="gCellPhone">Cell Phone <span class="must">*</span></label>
					<input type="text" name="gCellPhone" id="gCellPhone" class="searchInput" style="width:334px" value="" maxlength='15' />
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
					<input type="text"  class="searchInput" style="width:334px" name="mFstName" id="mFstName" value="" maxlength='20'/>
				</li>
				<li>
					<label for="mLstName">Last Name <span class="must">*</span></label>
					<input type="text"  class="searchInput" style="width:334px" name="mLstName" id="mLstName" value="" maxlength='30'/>
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
						<option value="${grade.dtlCD }">${grade.dtlCDNM }</option>
					</#list>
					</select>
				</li>
				<li>
					<label for="mEmail">Email</label>
					<input type="text" name="mEmail" id="mEmail" class="searchInput" style="width:334px" value="" maxlength='100'/>
				</li>
				<li>
					<label for="subj">Subject <span class="must">*</span></label>
					<select name="subj" id="subj">
					<#list subjectOfDepts as subj>
						<#if subj.digYN == "Y">
						<option value="${subj.subj }">${subj.subj }</option>
						</#if>
					</#list>
					</select>
				</li>
			</ul>
			<div class="btnArea">
				<a id="registBtn" style="cursor: pointer;"><span>Continue</span></a>
				<a href="/fa/diagnosis/diagnosis"><span>Cancel</span></a>
			</div>
		</div>
		</form>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
