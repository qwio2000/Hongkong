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
									<td>${gradeNM}</td>
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
					<div id="diagnosislist">다시 확인 바랍니다.</div>
					
					<div class="btnArea al_c">
						<a href="javascript:$.getIpprSave();"><span style="width: 115px;">Save</span></a>
						<a href="javascript:$.getReload();"><span style="width: 115px;">Cancle</span></a>
					</div>

				</div>
				<!-- //처방결과 입력 화면 -->
				
				<input type="hidden" id="omrdate" value="${omrdate}">
				<input type="hidden" id="Hkey" value="${memKey}">
				<input type="hidden" id="Kwamok" value="${subjname}">
				<input type="hidden" id="MFstName" value="${memName}">
				<input type="hidden" id="MLstName" value="">
				<input type="hidden" id="Skey" value="${empKey}">
				<input type="hidden" id="SName" value="${empName}">
				<input type="hidden" id="OmrGrd" value="${leveldung}">
				<input type="hidden" id="OmrHak" value="${gradeCD}">
				<input type="hidden" id="OmrBirth" value="${mBirthDay}">
				<input type="hidden" id="OmrKind" value="${OmrKind}">
				
				<input type="hidden" id="OmrDay1" value="${yoil1}">
				<input type="hidden" id="OmrDay2" value="${yoil2}">
				<input type="hidden" id="OmrStudyNum" value="${studyNum}">
				<input type="hidden" id="OmrBookNum" value="${bookNum}">				
				<input type="hidden" id="deptCd" value="${deptCd}">
				<input type="hidden" id="jisaCD" value="${jisaCD}">
				<input type="hidden" id="DeptName" value="">
				<input type="hidden" id="WorkID" value="${userId}">
				<input type="hidden" id="leveldung" value="${leveldung}">
				<input type="hidden" id="subjname" value="${subjname}">
				<input type="hidden" id="Rw" value="${readchk}">
				<input type="hidden" id="NOmr" value="${nomr}">
				<input type="hidden" id="testType" value="${testType}">
				
				<input type="hidden" id="lastOK" value="Y">
				
				<div id="inputAnswer"></div>
				
	</div>
	
<!--// Main Content -->


<#include "/include/popupfooter.ftl">