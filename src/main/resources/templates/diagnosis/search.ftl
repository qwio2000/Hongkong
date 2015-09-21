<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Diagnosis Search</h2>
	<form id="diagnosisSearchForm" action="/fa/diagnosis/diagnosisSearch/search" method="get">		
		<ul class="memSearch" <#if loginInfo.userType == "JA"> style="float:right;"</#if>>
			<li>
				<label for="Status">Status</label>
				<select name="status" id="status">
					<option value="01">Diagnosis</option>
					<option value="02">Free Diagnosis</option>
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
		</ul>
	<div class="btnArea">
		<a href=""><span>Reset</span></a>
		<a href="javascript:$('#diagnosisSearchForm').submit();"><span>Search Members</span></a>
	</div>
	</form>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">