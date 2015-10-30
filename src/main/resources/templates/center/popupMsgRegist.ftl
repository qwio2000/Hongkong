<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Create a Pop-up Messages</h2>
	<form action="" name="popupMsgForm" id="popupMsgForm">
	<input type="hidden" name="idx" id="idx" value="0">	
	<div class="clearfix">
		<div class="float_l lineB" style="width:380px">
			<div class="tbl01 pt10">
				<table>
					<colgroup>
						<col width="92">
						<col width="*">
					</colgroup>
					<tbody>
						<tr class="no_line">
							<td class="left"><span class="tit">From</span></td>
							<td class="left pl0">
								<input type="text" name="startMMDDYY" id="startMMDDYY" class="searchInput" style="width:230px" readOnly >
								<input type="hidden" name="startYMD" id="startYMD"/>
								<a class="btn_calendar" id="startYMDPicker" style="cursor: pointer;">view calendar</a>											
							</td>
						</tr>
						<tr class="no_line">
							<td class="left"><span class="tit">To</span></td>
							<td class="left pl0">
								<input type="text" name="endMMDDYY" id="endMMDDYY" class="searchInput" style="width:230px" readOnly >
								<input type="hidden" name="endYMD" id="endYMD"/>
								<a class="btn_calendar" id="endYMDPicker" style="cursor: pointer;">view calendar</a>	
							</td>
						</tr>
						<tr class="no_line">
							<td class="left"><span class="tit">Title</span></td>
							<td class="left pl0"><input type="text" name="msgTitle" id="msgTitle"  class="searchInput" style="width:265px" maxLength="200"/></td>
						</tr>
						<tr class="no_line">
							<td class="left valin_t"><span class="tit">Message</span></td>
							<td class="left pl0"><textarea name="msg" id="msg" maxlength="500" cols="30" rows="10" style="width:255px" class="tbl_textarea"></textarea></td>
						</tr>
						<tr class="no_line">
							<td></td>
							<td class="left pl0">
								<select name="stateCD" id="stateCD" style="width:277px">
									<option value="ALL">-- SELECT A REGION --</option>
									<#list centerStates as state>
										<option value="${state.stateCD }">${state.stateName }</option>
									</#list>		
								</select>								
							</td>
						</tr>
					</tbody>
				</table>
				<div class="btnArea btnArea_pop">
					<a href="/ja/centers/popupMsg" ><span style="width:110px">Cancle</span></a>
					<a href="javascript:;" id="savePopupMsg" ><span style="width:145px">Add Message</span></a>
				</div>
			</div>
		</div>
		<div class="float_l pl30"  id="mainContent" style="width:380px"></div>
	</div>
	</form>
</div>
<!--// Main Content -->		
	
<script id="mainContentTemplate" type="text/x-handlebars-template">
<div class="location_list">
	<div class="top">
		<span class="tit">Center</span>
	</div>
	<div class="all"><span class="chk_s01"><input type="checkbox" name="chkAll" id="chkAll" onClick="javascript:$.check_all('chkAll','chk');" ><label for="chkAll"><strong>ALL</strong></label></span></div>
	<ul>
		{{#each centerOfStateList}}
			<li><span class="chk_s01"><input type="checkbox" name="chk"  id="chk_{{deptCD}}" value="{{deptCD}}" ><label for="chk_{{deptCD}}">{{deptName}}</label></span></li>
		{{/each}}
	</ul>
</div>
</script>			
<#include "/include/footer.ftl">