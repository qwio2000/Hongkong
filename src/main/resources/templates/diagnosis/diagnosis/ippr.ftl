<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top">
			<h1>Input I.P.P.R</h1> 
			<a href="#" class="btn_popup_close">close</a>
		</div>
		
		<form id="ipprinput" action="/fa/diagnosis/ipprinput" method="post">
			<div class="popup_content">
				<div class="pop_input">
					<h2 class="conTit">Input I.P.P.R.</h2>
					<!-- 처방 등급 선택 -->
					<div class="conWrap">
						<div class="tbl01">
							<table>
								<colgroup>
									<col style="width:20%">
									<col style="width:20%">
									<col style="width:20%">
									<col style="width:20%">
									<col style="width:20%">
								</colgroup>
								<thead>
									<tr>
										<th>Name</th>
										<th>Grade</th>
										<th>Subject</th>
										<th>Level</th>
										<th>Input date</th>
									</tr>
								</thead>
								<tbody>
									<tr>
									<#if ippr??>
										<td>${ippr.memName}</td>
										<td>${ippr.gradeNM}</td>
										<td>${ippr.subjname}</td>
										<td>
											<select name="leveldung" id="leveldung">
											<#list level as levelfor>
												<option value="${levelfor.gradeCD}">${levelfor.gradeCD}</option>
											</#list> 
										</select>
										</td>
										<td>${ippr.inputdate}</td>
										
										<input type="hidden" id="jisaCD" name="jisaCD" value="${jisaCD}">
										<input type="hidden" id="memKey" name="memKey" value="${memKey}">
										<input type="hidden" id="memName" name="memName" value="${ippr.memName}">
										<input type="hidden" id="gradeNM" name="gradeNM" value="${ippr.gradeNM}">
										<input type="hidden" id="subjname" name="subjname" value="${ippr.subjname}">
										<input type="hidden" id="inputdate" name="inputdate" value="${ippr.inputdate}">
										<input type="hidden" id="mBirthDay" name="mBirthDay" value="${ippr.MBirthDay}">
										<input type="hidden" id="gradeCD" name="gradeCD" value="${ippr.gradeCD}">
										<input type="hidden" id="yoil" name="yoil" value="${ippr.yoil}">
										<input type="hidden" id="studyNum" name="studyNum" value="${ippr.studyNum}">
										<input type="hidden" id="bookNum" name="bookNum" value="${ippr.bookNum}">
									</#if>
									</tr>
								</tbody>
							</table>
						</div>
						<ul class="input_list">
							<li>
								<span class="tit">Test Type</span> 
								<span class="radio_wrap"><input type="radio" name="testType" value="1" id="chk01" checked /><label for="chk01">Diagosis</label></span>
								<span class="radio_wrap"><input type="radio" name="TestType" value="3" id="chk02" /><label for="chk02">ACH</label></span>
							</li>
							<li>
								<span class="tit">Read / WorkBook</span> 
								<span class="radio_wrap"><input type="radio" name="readchk" value="1" id="chk01" checked /><label for="chk01">YES</label></span>
								<span class="radio_wrap"><input type="radio" name="readchk" value="2" id="chk02" /><label for="chk02">NO</label></span>
							</li>
							<li>
								<span class="tit">Prescription by Learning Objective</span> 
								<span class="radio_wrap"><input type="radio" name="nomr" value="1" id="chk03" checked/><label for="chk03">YES</label></span>
								<span class="radio_wrap"><input type="radio" name="nomr" value="2" id="chk04" /><label for="chk04">NO</label></span>
							</li>
						</ul>
						<div class="btnArea">
							<a href="javascript:$('#ipprinput').submit();"><span>Next</span></a>
							<a href=""><span>Cancel</span></a>
						</div>
					</div>
					<!-- //처방 등급 선택 -->
				</div>
			</div>
		</form>
	</div>
	
<!--// Main Content -->
<#include "/include/popupfooter.ftl">