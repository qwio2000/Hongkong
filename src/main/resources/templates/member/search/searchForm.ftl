<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Member Search</h2>
	<form id="memberSearchForm" action="/${loginInfo.userType?lower_case }/members/searchResults" method="get">
	<input type="hidden" id="userType" value="${loginInfo.userType }"/>
	<#if loginInfo.userType == "JA">
	<ul class="memSearch" style="float:left;">
		<li>
			<label for="centerName">Center Name</label>
			<input id="centerName" type="text" name="centerName" class="searchInput" style="width: 334px;">
		</li>
		<li>
			<label for="centerCity">Center City</label>
			<input id="centerCity" type="text" name="centerCity" class="searchInput" style="width: 334px;">
		</li>
		<li>
			<label for="centerState">Center State</label>
			<select name="centerState" id="centerState">
				<option value="">All</option>
				<#list centerStates as state>
					<option value="${state.stateCD }">${state.stateName }</option>
				</#list>
			</select>
		</li>
		<li>
			<label for="centerZipcode">Center Zipcode</label>
			<input id="centerZipcode" type="text" name="centerZipcode" class="searchInput" style="width: 334px;">
		</li>
	</ul>
	</#if>
	<ul class="memSearch" <#if loginInfo.userType == "JA"> style="float:right;"</#if>>
		<li>
			<label for="memberStatus">Member Status</label>
			<select name="memberStatus" id="memberStatus">
				<option value="">All</option>
				<#list memberStatuses as status>
					<option value="${status.dtlCD }" <#if status.dtlCD == "1">selected</#if>>${status.dtlCDNM }</option>
				</#list>
			</select>
		</li>
		<li>
			<label for="lastName">Last Name</label>
			<input id="lastName" type="text" name="lastName" class="searchInput" style="width: 334px;">
		</li>
		<li>
			<label for="firstName">First Name</label>
			<input id="firstName" type="text" name="firstName" class="searchInput" style="width: 334px;">
		</li>
		<li>
			<label for="homePhone">Home Phone</label>
			<input id="homePhone" type="text" name="homePhone" class="searchInput" style="width: 334px;">
		</li>
		<li>
			<label for="cellPhone">Cell Phone</label>
			<input id="cellPhone" type="text" name="cellPhone" class="searchInput" style="width: 334px;">
		</li>
		<li>
			<label for="email">Email</label>
			<input id="email" type="text" name="email" class="searchInput" style="width: 334px;">
		</li>
		<li>
			<label for="grade">Grade</label>
			<select name="grade" id="grade">
				<option value="">All</option>
				<#list grades as grade>
					<option value="${grade.dtlCD }">${grade.dtlCDNM }</option>
				</#list>
			</select>
		</li>
		<li>
			<label for="subject">Subject</label>
			<select name="subject" id="subject">
				<option value="">All</option>
				<#list subjects as subject>
					<option value="${subject.dtlCD }">${subject.dtlCDNM }</option>
				</#list>
			</select>
		</li>
		<li class="last">
			<label for="">Class Day</label>
			<ul class="classDay">
				<li><input type="checkbox" id="sun" name="classDay" value="1"/><label for="sun"><span></span>Sunday</label></li>
				<li><input type="checkbox" id="mon" name="classDay" value="2"/><label for="mon"><span></span>Monday</label></li>
				<li><input type="checkbox" id="tue" name="classDay" value="3"/><label for="tue"><span></span>Tuesday</label></li>
				<li><input type="checkbox" id="wed" name="classDay" value="4"/><label for="wed"><span></span>Wednesday</label></li>
				<li><input type="checkbox" id="thu" name="classDay" value="5"/><label for="thu"><span></span>Thursday</label></li>
				<li><input type="checkbox" id="fri" name="classDay" value="6"/><label for="fri"><span></span>Friaday</label></li>
				<li><input type="checkbox" id="sat" name="classDay" value="7"/><label for="sat"><span></span>Saturday</label></li>
			</ul>
		</li>
	</ul>
	<div class="btnArea">
		<a href="javascript:location.reload();"><span>Reset</span></a>
		<a id="memberSearchBtn" href="#"><span>Search Members</span></a>
	</div>
	</form>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">