<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top"><h1>Update Subject &amp; Visit schedule</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
		<div class="popup_content">
			<div class="pop_gm">
			<form action="" id="memSubjStudyForm">
			<input type="hidden" name="memKey" value="${memKey }"/>
				<div class="list02">
					<ul>
					<#list subjStudys as subjStudy>
						<li>
							<span class="chk_s01 tit3"><input type="checkbox" name="subj" value="${subjStudy.subj }" id="chk${subjStudy_index+1 }"><label for="chk${subjStudy_index+1 }">${subjStudy.subj }</label></span>
							<select name="studyNum" id="studyNum_${subjStudy.subj }" style="width:45px;" disabled>
								<#list 1..studyNum as i>
								<option value="${i }"<#if i == subjStudy.studyNum>selected</#if>>${i }</option>
								</#list>
							</select>
							<select name="yoil" id="yoil_${subjStudy.subj }" style="width:105px;margin-left:3px" disabled>
								<#list yoils as yoil>
								<option value="${yoil.dtlCD }"<#if yoil.dtlCD == subjStudy.yoil>selected</#if>>${yoil.dtlCDNME }</option>
								</#list>
							</select>
							<select name="manageTimes" id="manageTimes_${subjStudy.subj }" style="width:100px;margin-left:3px" disabled>
								<#list manageTimes as manageTime>
								<option value="${manageTime.dtlCD }"<#if manageTime.dtlCD == subjStudy.visitHours>selected</#if>>${manageTime.dtlCDNM }</option>
								</#list>
							</select>
<!-- 							<select name="" id="" style="width:105px;margin-left:3px"> -->
<!-- 								<option value="">Tuesday</option> -->
<!-- 								<option value="">Monday</option> -->
<!-- 							</select> -->
<!-- 							<select name="" id="" style="width:100px;margin-left:3px"> -->
<!-- 								<option value="">03:30 PM</option> -->
<!-- 							</select> -->
						</li>
					</#list>
					</ul>
				</div>
				</form>
				<div class="btnArea">
					<a href="javascript:memSubjStudyInfoSubmit();"><span>Save Information</span></a>
				</div>
			</div>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">