<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top"><h1>Free Diagnosis</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
		<div class="popup_content">
			<div class="pop_gm">
			<form action="" id="memSubjStudyForm">
			<input type="hidden" id="key" name="key" value="${key }"/>
				<div class="list02">
					<ul>
						<li>
							<label for="subj">Subject : </label>
							<select name="subj" id="subj" style="width:105px;margin-left:3px">
								<#list freeDiagOtherSubjs as subj>
								<option value="${subj }">${subj }</option>
								</#list>
							</select>
						</li>
					</ul>
				</div>
				</form>
				<div class="btnArea">
					<a href="javascript:freeDiagOtherSubj();"><span>Free Diagnosis</span></a>
				</div>
			</div>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">