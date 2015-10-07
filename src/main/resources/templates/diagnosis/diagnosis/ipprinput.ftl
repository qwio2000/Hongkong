<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top">
			<h1>Input I.P.P.R</h1> 
			<a href="#" class="btn_popup_close">close</a>
		</div>
		
		
			<div class="popup_content">
				<div class="conWrap">
					<!-- 처방결과 입력 화면 -->
					<div class="tbl01">
						<table>
							<colgroup>
								<col>
								<col style="width:16%">
								<col style="width:16%">
								<col style="width:16%">
								<col style="width:16%">
								<col style="width:16%">
							</colgroup>
							<thead>
								<tr>
									<th>Name</th>
									<th>Grade</th>
									<th>Subject</th>
									<th>Level</th>
									<th>Test Type</th>
									<th>Date of Birth</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${memName}</td>
									<td>${grade}</td>
									<td>${subjname}</td>
									<td>${leveldung}</td>
									<td><#if testType == "1"> Diagnosis <#else> ACH </#if></td>
									<td>${mBirthDay}</td>
								</tr>
							</tbody>
						</table>
					</div>
					
					
					<ul class="input_list">
						<li>
							<span class="tit">Read / WorkBook: </span> 
							<span><#if readchk == "1">YES<#else>NO</#if></span>
						</li>
						<li>
							<span class="tit">Prescription by Learning Objective : </span> 
							<span><#if nomr == "1">YES<#else>NO</#if></span>
						</li>
					</ul>
					<!-- //처방결과 입력 화면 -->
					
					
					
					<!-- 오답 입력 -->
					<div id="diagnosislist">111</div>
					

				</div>
				<!-- //처방결과 입력 화면 -->
				
				<input type="hidden" id="jisaCD" value="${jisaCD}">
				<input type="hidden" id="leveldung" value="${leveldung}">
				<input type="hidden" id="subjname" value="${subjname}">
				
				
	</div>
	
<!--// Main Content -->


<#include "/include/popupfooter.ftl">