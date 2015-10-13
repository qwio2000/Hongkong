<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top"><h1>Drop</h1> <a href="#" class="btn_popup_close">close</a></div>
		<div class="popup_content">
		<form action="" id="dropMemberForm">
		<input type="hidden" name="memKey" value="${memKey }"/>
		<input type="hidden" name="memName" value="${memName }"/>
			<div class="pop_gm">
					<ul class="list02">
					<li>
						<label for="memName" class="tit2">Member Name</label>
						<strong>${memName }</strong>
					</li>
					<li>
						<label for="subj" class="tit2">What would you like to do?</label>
						<span class="radio_wrap"><input type="radio" value="${subj }" name="subj" id="subj" checked="checked"><label class="radio_label" for="subj"><span class="yellow">Drop</span> ${subj }</label></span>
					</li>
					<li>
						<label for="dropReason" class="tit2">Drop Reason</label>
						<select name="dropReason" id="dropReason" style="width:365px">
							<#list dropReasons as dropReason>
							<option value="${dropReason.dtlCD }">${dropReason.dtlCDNM }</option>
							</#list>
						</select>
					</li>
					<li>
						<label for="notes" class="tit2">Notes</label>
						<input type="text" id="notes" name="notes" class="searchInput" style="width:353px">
					</li>
				</ul>
				<div class="btnArea">
					<a href="javascript:dropMemberSubmit();"><span>Drop</span></a>
				</div>
			</div>
		</form>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">