<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Search Center</h2>
	<form id="centerSearchForm" action="/${loginInfo.userType?lower_case }/centers/searchResults" method="get">
	<input type="hidden" id="userType" value="${loginInfo.userType }"/>
	<ul class="memSearch" style="float:left;">
		<li>
			<label for="centerName">Center Name</label>
			<input id="centerName" type="text" name="centerName" class="searchInput" style="width: 334px;">
		</li>
		<li>
			<label for="centerCity">City</label>
			<input id="centerCity" type="text" name="centerCity" class="searchInput" style="width: 334px;">
		</li>
		<li>
			<label for="centerState">State</label>
			<select name="centerState" id="centerState">
				<option value="">All</option>
				<#list centerStates as state>
					<option value="${state.stateCD }">${state.stateName }</option>
				</#list>
			</select>
		</li>
		<li>
			<label for="centerStatus">Status</label>
			<select name="centerStatus" id="memberStatus">
				<option value="">All</option>
				<#list statusCDList as status>
					<option value="${status.dtlCD }" <#if status.dtlCD == "1">selected</#if>>${status.dtlCDNM }</option>
				</#list>
			</select>
		</li>		
		
	</ul>
	<div class="btnArea">
		<a href=""><span>Reset</span></a>
		<a id="centerSearchBtn" href="#"><span>Search Learning Centers</span></a>
	</div>
	</form>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">