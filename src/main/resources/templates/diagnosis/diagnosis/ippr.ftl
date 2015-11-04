<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top">
			<h1>Input I.P.P.R</h1> 
			<a href="javascript:self.close();" class="btn_popup_close">close</a>
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
										<td>${ippr.mfstname}&nbsp;${ippr.mlstname}</td>
										<td>${ippr.gradeNM}</td>
										<td>${ippr.subjname}</td>
										<td>
											<select name="leveldung" id="leveldung" <#if leveldung != ""> disabled="disabled" </#if> >
											<#list level as levelfor>
												<#if leveldung == levelfor.gradeCD >
													<option value="${levelfor.gradeCD}" selected="selected" >${levelfor.gradeCD}</option>
												<#else>
													<option value="${levelfor.gradeCD}">${levelfor.gradeCD}</option>
												</#if>
												
											</#list> 
										</select>
										</td>
										<td>${ippr.inputdate}</td>
										
										<input type="hidden" id="jisaCD" name="jisaCD" value="${ippr.jisaCD}">
										<input type="hidden" id="deptCd" name="deptCd" value="${ippr.deptCd}">
										<input type="hidden" id="memKey" name="memKey" value="${memKey}">
										<input type="hidden" id="mfstname" name="mfstname" value="${ippr.mfstname}">
										<input type="hidden" id="mlstname" name="mlstname" value="${ippr.mlstname}">
										<input type="hidden" id="gradeNM" name="gradeNM" value="${ippr.gradeNM}">
										<input type="hidden" id="subjname" name="subjname" value="${ippr.subjname}">
										<input type="hidden" id="subj" name="subj" value="${subj}">
										<input type="hidden" id="inputdate" name="inputdate" value="${ippr.inputdate}">
										<input type="hidden" id="mBirthDay" name="mBirthDay" value="${ippr.MBirthDay}">
										<input type="hidden" id="gradeCD" name="gradeCD" value="${ippr.gradeCD}">
										<input type="hidden" id="yoil" name="yoil" value="${ippr.yoil}">
										<input type="hidden" id="studyNum" name="studyNum" value="${ippr.studyNum}">
										<input type="hidden" id="bookNum" name="bookNum" value="${ippr.bookNum}">
										<input type="hidden" id="freejindan" name="freejindan" value="${freejindan}">
									</#if>
									</tr>
								</tbody>
							</table>
						</div>
						<ul class="input_list">
							<li>
								<span class="tit">Test Type</span> 
								
								<span class="radio_wrap"><input type="radio" name="testType" value="${testType }" id="testchk01"  <#if testType != "3"> checked </#if> disabled="disabled" /><label for="testchk01">Diagosis</label></span>
								<span class="radio_wrap"><input type="radio" name="testType" value="${testType }" id="testchk02"  <#if testType == "3"> checked </#if> disabled="disabled" /><label for="testchk02">ACH</label></span>
							</li>
							<li>
								<span class="tit">Read / WorkBook</span> 
								<span class="radio_wrap"><input type="radio" name="readchk" value="1" id="readchk01" checked /><label for="readchk01">YES</label></span>
								<span class="radio_wrap"><input type="radio" name="readchk" value="2" id="readchk02" /><label for="readchk02">NO</label></span>
							</li>
							<li>
								<span class="tit">Prescription by Learning Objective</span> 
								<span class="radio_wrap"><input type="radio" name="nomr" value="1" id="nomrchk01" checked/><label for="nomrchk01">YES</label></span>
								<span class="radio_wrap"><input type="radio" name="nomr" value="2" id="nomrchk02" /><label for="nomrchk02">NO</label></span>
							</li>
						</ul>
						<div class="btnArea">
							<a href="javascript:$.getipprinput();"><span>Next</span></a>
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