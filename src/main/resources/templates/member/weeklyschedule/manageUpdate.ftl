<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup" style="min-width:300px">
		<div class="popup_top"><h1>${memName }(${memSubjStudy.subj })</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
		<div class="popup_content">
			<form id="manageUpdateForm">
			<input type="hidden" name="memKey" value="${memSubjStudy.memKey }"/>
			<input type="hidden" name="subj" value="${memSubjStudy.subj }"/>
			<div class="pop_gm">
				<ul class="list02">
					<li>
						<select name="yoil" id="yoil" style="width:130px">
							<#list yoils as yoil>
								<option value="${yoil.dtlCD }" <#if yoil.dtlCD == memSubjStudy.yoil> selected</#if>>${yoil.dtlCDNME }</option>
							</#list>
						</select>
						<select name="manageTime" id="manageTime" style="width:100px">
							<#list manageTimes as manageTime>
								<option value="${manageTime.dtlCD }" <#if manageTime.dtlCD == memSubjStudy.visitHours> selected</#if>>${manageTime.dtlCDNM }</option>
							</#list>
						</select>
					</li>
				</ul>
				<div class="btnArea">
					<a href="javascript:changeManageInfoSubmit();"><span style="width:120px">Save</span></a>
					<a href="javascript:self.close();" class="btn_close"><span style="width:90px">Cancel</span></a>
				</div>
			</div>
			</form>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">