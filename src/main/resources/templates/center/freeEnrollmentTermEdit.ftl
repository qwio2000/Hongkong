<#include "/include/header.ftl">
<script type="text/javascript">
<!--
	if ("${chk}"=="N") {
		alert("정보가 없습니다.");
		history.back();
	}
//-->
</script>
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Edit New Event</h2>
	<form action="" name="freeEnrollForm" id="freeEnrollForm">	
	<input type="hidden" name="idx" id="idx" value="${idx?default('') }">			
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
							<td class="left"><span class="tit">Type</span></td>
							<td class="left pl0">
								<select name="freeType" id="freeType" style="width:277px">
									<option value="">-- SELECT A TYPE --</option>
									<#list freeTypeList as list>
										<option value="${list.dtlCD }" <#if list.dtlCD == freeEnrollInfo.freeType?default('') >selected</#if>>${list.dtlCDNM }</option>
									</#list> 
								</select>											
							</td>
						</tr>
						<tr class="no_line">
							<td class="left"><span class="tit">Title</span></td>
							<td class="left pl0"><input type="text" name="freeTitle" id="freeTitle" value="${freeEnrollInfo.freeTitle?default('') }"  class="searchInput" style="width:265px" maxLength="200"/></td>
						</tr>	
						<tr class="no_line">
							<td class="left"><span class="tit">Begin</span></td>
							<td class="left pl0">
								<input type="text" name="startMMDDYY" id="startMMDDYY" value="${freeEnrollInfo.startYMD?default('') }" class="searchInput" style="width:230px" readOnly >
								<input type="hidden" name="startYMD" id="startYMD"/>
								<a class="btn_calendar" id="startYMDPicker" style="cursor: pointer;">view calendar</a>							
							</td>
						</tr>
						<tr class="no_line">
							<td class="left"><span class="tit">End</span></td>
							<td class="left pl0">
								<input type="text" name="endMMDDYY" id="endMMDDYY"  value="${freeEnrollInfo.endYMD?default('') }" class="searchInput" style="width:230px" readOnly >
								<input type="hidden" name="endYMD" id="endYMD"/>
								<a class="btn_calendar" id="endYMDPicker" style="cursor: pointer;">view calendar</a>							
							</td>
						</tr>
						<tr class="no_line">
							<td class="left"><span class="tit">Region</span></td>
							<td class="left pl0">
								<select name="stateCD" id="stateCD" style="width:277px">
									<option value="ALL">-- SELECT A REGION --</option>
									<#list centerStates as state>
										<option value="${state.stateCD }" <#if state.stateCD == freeEnrollInfo.stateCD?default('') >selected</#if>>${state.stateName }</option>
									</#list>										
								</select>							
							</td>
						</tr>				
					</tbody>
				</table>
				<div class="btnArea">	
					<#if freeEnrollInfo.delFlag?default('') == "Y">
						<a href="/ja/centers/freeEnrollmentTermEdit?idx=${idx?default('') }" ><span style="width:110px">Reset</span></a>					
						<a href="javascript:;" id="saveFreeEnrollInfo" ><span>Save Event Information</span></a>
					<#else>			
						<a href="/ja/centers/freeEnrollmentTerm" ><span style="width:110px">Cancle</span></a>
						<a href="javascript:alert('수정기간이 지났습니다.');"  ><span>Save Event Information</span></a>
					</#if>
				</div>
				<br />
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
			<li><span class="chk_s01"><input type="checkbox" name="chk"  id="chk_{{deptCD}}" value="{{deptCD}}" {{#xIf deptCD "==" compareDeptCD }}checked{{/xIf}} ><label for="chk_{{deptCD}}">{{deptName}}</label></span></li>
		{{/each}}
	</ul>
</div>
</script>			
<#include "/include/footer.ftl">