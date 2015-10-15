<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Search Center</h2>
	<form id="searchForm" name="searchForm" action="/${loginInfo.userType?lower_case }/centers/centerSearchResults" method="get">
	<input type="hidden" id="userType" value="${loginInfo.userType }"/>
	
	<ul class="memSearch" style="float:left;">
		<li>
			<label for="centerName">Center Name</label>
			<input id="deptName" type="text" name="deptName" class="searchInput" style="width: 334px;">
		</li>
		<li>
			<label for="centerCity">City</label>
			<input id="city" type="text" name="city" class="searchInput" style="width: 334px;">
		</li>
		<li>
			<label for="centerState">State</label>
			<select name="stateCD" id="stateCD">
				<option value="">All</option>
				<#list centerStates as state>
					<option value="${state.stateCD }">${state.stateName }</option>
				</#list>
			</select>
		</li>
		<li>
			<label for="centerStatus">Status</label>
			<select name="statusCD" id="statusCD">
				<option value="">All</option>
				<#list statusCDList as status>
					<option value="${status.dtlCD }" <#if status.dtlCD == "1">selected</#if>>${status.dtlCDNM }</option>
				</#list>
			</select>
		</li>
	</ul>
	<div class="btnArea">
		<a id="searchInit" href="#"><span>Reset</span></a>
		<a id="searchSubmit" href="#"><span>Search Learning Centers</span></a>		
	</div>
	</form>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">