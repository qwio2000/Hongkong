<#include "/include/popupheader.ftl">
<!-- Main Content -->
<style type="text/css">
	html, body{height:100%;width:100%;}
</style>
<script type="text/javascript">
function setCookie(name, value, expiredays){
	//24시간 기준
	var todayDate = new Date();
		todayDate.setDate(todayDate.getDate() + expiredays);
		document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";";
}

function closePop(){
	if ($("#popPrevent").is(":checked")){
		setCookie("mainPop", "done", 1);
	}
	self.close();
}
</script>
<div class="popup popup_main">
	<div class="popup_top"><h1>Pop-up Messages</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_jisa">
			<#assign margin = 5>
			<#list popupMsgs as popupMsg>
				<div class="tbl01 mt${margin }">
					<table style="table-layout: fixed;">
						<colgroup>
							<col width="120px" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<th>Title</th>
								<td class="left"><strong>${popupMsg.msgTitle }</strong></td>
							</tr>
							<tr>
								<td colspan="2" class="left col_con" style="word-break:break-all;">
									${popupMsg.msg }
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<#assign margin = 20>
			</#list>
		</div>
	</div>
	<div class="popup_bottom">
		<div class="not_tody list02">
			<span class="chk_s01"><input type="checkbox" id="popPrevent" onclick="javascript:closePop();"><label for="popPrevent">No More Popup Today</label></span>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">
