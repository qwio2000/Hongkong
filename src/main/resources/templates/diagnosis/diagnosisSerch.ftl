<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Diagnosis Search</h2>
	<form id="diagnosisSearchForm" action="/fa/diagnosis/diagnosisSerch/search" method="get">		
		<ul class="memSearch" <#if loginInfo.userType == "JA"> style="float:right;"</#if>>
			<li>
				<label for="Status">Status</label>
				<select name="Status" id="Status">
					<option value="01">Diagnosis</option>
					<option value="02">Free Diagnosis</option>
				</select>
			</li>
			<li>
				<label for="LastName">Last Name</label>
				<input id="LastName" type="text" name="LastName" class="searchInput" style="width: 334px;">
			</li>
			<li>
				<label for="FirstName">First Name</label>
				<input id="FirstName" type="text" name="FirstName" class="searchInput" style="width: 334px;">
			</li>
			<li>
				<label for="HomePhone">Home Phone</label>
				<input id="HomePhone" type="text" name="HomePhone" class="searchInput" style="width: 334px;">
			</li>
			<li>
				<label for="CellPhone">Cell Phone</label>
				<input id="CellPhone" type="text" name="CellPhone" class="searchInput" style="width: 334px;">
			</li>
			<li>
				<label for="Email">Email</label>
				<input id="Email" type="text" name="Email" class="searchInput" style="width: 334px;">
			</li>
			<li>
				<label for="Grade">Grade</label>
				<select name="Grade" id="Grade">
					<option value="">All</option>
					<#list grades as grade>
						<option value="${grade.dtlCD }">${grade.dtlCDNM }</option>
					</#list>
				</select>
			</li>
			<li>
				<label for="Subject">Subject</label>
				<select name="Subject" id="Subject">
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