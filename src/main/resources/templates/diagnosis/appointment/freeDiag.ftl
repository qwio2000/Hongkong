<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<div class="clearfix">
		<form id="registForm" name="registForm" action="/fa/diagnosis/appointment" method="post">
		<div class="conLeft">
			<h2 class="conTit">Parent(Guardian) Information</h2>
			<ul class="memSearch">
				<li>
					<label for="gFstName">First Name <span class="must">*</span></label>
					<input type="text"  class="searchInput" name="gFstName" id="gFstName" style="width:334px" value="${appointment.GFstName?default('') }" maxlength='20' disabled="disabled"/>
				</li>
				<li>
					<label for="gLstName">Last Name <span class="must">*</span></label>
					<input type="text"  class="searchInput" name="gLstName" id="gLstName" style="width:334px" value="${appointment.GLstName?default('') }" maxlength='30' disabled="disabled"/>
				</li>
				<li>
					<label for="addr">Address <span class="must">*</span></label>
					<input type="text"  class="searchInput" name="addr" id="addr" style="width:334px" value="${appointment.addr?default('') }" maxlength='100' disabled="disabled"/>
				</li>
				<li>
					<label for="zip">Zipcode </label>
					<input type="text"  class="searchInput" name="zip" id="zip" style="width:334px" value="${appointment.zip?default('') }" maxlength='6'  disabled="disabled"/>
				</li>
				<li>
					<label for="city">City / State</label>
					<input type="text"  class="searchInput" name="city" id="city" style="width:151px" value="${appointment.city?default('') }" maxlength='50'  disabled="disabled"/>
					<#list states as state>
						<#if state.stateCD == appointment.stateCD>
							<#assign stateName = state.stateName>
						<#else>
							<#assign stateName = "">
						</#if> 
					</#list>
						<input type="text"  class="searchInput" name="stateCD" id="stateCD" style="width:166px" value="${stateName?default('') }" maxlength='100' disabled="disabled"/>
				</li>
				<li>
					<label for="gEmail">Email</label>
					<input type="text" name="gEmail" id="gEmail" class="searchInput" style="width:334px" value="${appointment.GEmail?default('') }" maxlength='100' disabled="disabled"/>
				</li>
				<li>
					<label for="gPhone">Phone <span class="must">*</span></label>
					<input type="text" name="gPhone" id="gPhone" class="searchInput" style="width:334px" value="${appointment.GPhone?default('') }" maxlength='15' disabled="disabled"/>
				</li>
				<li>
					<label for="gCellPhone">Cell Phone <span class="must">*</span></label>
					<input type="text" name="gCellPhone" id="gCellPhone" class="searchInput" style="width:334px" value="${appointment.GCellPhone?default('') }" maxlength='15'  disabled="disabled"/>
				</li>
			</ul>
			<div class="question_list">
				<p>· Why do you wish to entoll your child?</p>
				<ul>
					<#list registWhys as registWhy>
						<#if registWhy.dtlCD == "99">
						<li>
							<span class="radio_wrap">
								<input type="radio" value="${registWhy.dtlCD }" name="registWhy" id="registWhy_num${registWhy_index+1 }" <#if registWhy.dtlCD == appointment.registWhy?default('')>checked</#if>/>
								<label class="radio_label" for="registWhy_num${registWhy_index+1 }"> Other,please explain</label>
								<input type="text"  class="searchInput" name="registWhyEtc" id="registWhyEtc" style="width:280px" value="${appointment.registWhyEtc?default('') }" <#if appointment.registWhyEtc?default('') == ''>disabled</#if> maxlength='30'/>
							</span>
						</li>
						<#else>
						<li>
							<span class="radio_wrap">
								<input type="radio" value="${registWhy.dtlCD }" name="registWhy" id="registWhy_num${registWhy_index+1 }" <#if registWhy.dtlCD == appointment.registWhy?default('')>checked</#if>/>
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
								<input type="radio" value="${registHow.dtlCD }" name="registHow" id="registHow_num${registHow_index+1 }" <#if registHow.dtlCD == appointment.registHow?default('')>checked</#if>/>
								<label class="radio_label" for="registHow_num${registHow_index+1 }"> Other,please explain</label>
								<input type="text"  class="searchInput" name="registHowEtc" id="registHowEtc" style="width:280px" value="${appointment.registHowEtc?default('') }" <#if appointment.registHowEtc?default('') == ''>disabled</#if> maxlength='30'/>
							</span>
						</li>
						<#else>
						<li>
							<span class="radio_wrap">
								<input type="radio" value="${registHow.dtlCD }" name="registHow" id="registHow_num${registHow_index+1 }" <#if registHow.dtlCD == appointment.registHow?default('')>checked</#if>/>
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
					<input type="text"  class="searchInput" style="width:334px" name="mFstName" id="mFstName" value="${appointment.MFstName?default('') }" maxlength='20' disabled="disabled"/>
				</li>
				<li>
					<label for="mLstName">Last Name <span class="must">*</span></label>
					<input type="text"  class="searchInput" style="width:334px" name="mLstName" id="mLstName" value="${appointment.MLstName?default('') }" maxlength='30' disabled="disabled"/>
				</li>
				<li>
					<label for="dobMonth">DOB <span class="must">*</span></label>
					<#list months as month>
						<#if month.monthNum == currentMonth>
							<input type="text"  class="searchInput" style="width:114px" name="dobMonth" id="dobMonth" value="${month.monthStr }" maxlength='10' disabled="disabled"/>
						</#if>
					</#list>
					<#list 1..maxDays as i>
						<#if i == currentDay>
							<#if i lt 10>
							<input type="text"  class="searchInput" style="width:100px" name="dobDay" id="dobDay" value="0${i }" maxlength='10' disabled="disabled"/>
							<#else>
							<input type="text"  class="searchInput" style="width:100px" name="dobDay" id="dobDay" value="${i }" maxlength='10' disabled="disabled"/>
							</#if>
						</#if>
					</#list>
					<input type="text"  class="searchInput" style="width:88px" name="dobYear" id="dobYear" value="${currentYear?c }" maxlength='4' disabled="disabled"/>
				</li>
				<li>
					<label for="gradeCD">Grade <span class="must">*</span></label>
					<#list grades as grade>
						<#if grade.dtlCD == appointment.gradeCD>
							<input type="text"  class="searchInput" style="width:334px" name="gradeCD" id="gradeCD" value="${grade.dtlCDNM }" maxlength='10' disabled="disabled"/>
						</#if>
					</#list>
				</li>
				<li>
					<label for="mEmail">Email</label>
					<input type="text" name="mEmail" id="mEmail" class="searchInput" style="width:334px" value="${appointment.MEmail?default('') }" maxlength='100' disabled="disabled"/>
				</li>
				<li>
					<label for="subj">Subject <span class="must">*</span></label>
					<#list subjectOfDepts as subj>
						<#if subj.subj == appointment.subj>
						<input type="text"  class="searchInput" style="width:334px" name="dobDay" id="dobDay" value="${subj.subj }" maxlength='10' disabled="disabled"/>
						</#if>
					</#list>
				</li>
			</ul>
			<div class="btnArea">
				<a id="registBtn" style="cursor: pointer;"><span>Free Diag</span></a>
			</div>
		</div>
		</form>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
