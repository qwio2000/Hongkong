<#include "/include/popupheader.ftl">
<!-- Main Content -->

<div class="popup">
	<div class="popup_top"><h1>Comments/Call Logs</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_jisa">
			<form action="" name="centerCommentCallForm" id="centerCommentCallForm">
			<input type="hidden" name="deptCD" id="deptCD"  value="${deptCD?default('')}"/>		
			<input type="hidden" id="pageNum" value="1"/>			
			<div class="tbl01">
				<table>
					<colgroup>
						<col width="130px" />
					</colgroup>
					<tbody>
						<tr>
							<th>User Name</th>
							<td class="left">${centerInfo.empName?default('') }</td>
						</tr>
						<tr>
							<th>Center Name</th>
							<td class="left">${centerInfo.deptName?default('') }</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="textarea_wrap">
				<textarea name="callNotes" id="callNotes" cols="30" rows="10" maxlength="500"></textarea>
				<span class="max">Max 500</span>
				<div class="max_char_txt">You have 500 chracters left</div>
			</div>
			<div class="btnArea">
				<a href="javascript:;" id="saveCenterCommentCall" ><span>ADD NOTE</span></a>
			</div>
			</form>
			<!-- 리스트 -->
			<div id="mainContent"></div>
			<div class="paging">
				<span id="pageNavi"></span>
			</div>			
		</div>
	</div>
</div>	
<!--// Main Content -->
<!--// Main Content -->
<script id="mainContentTemplate" type="text/x-handlebars-template">
<div class="tbl01">
	<table>
		<colgroup>
			<col width="150">
			<col width="*">
			<col width="30">
		</colgroup>
		<thead>
			<tr>
				<th>Date</th>
				<th>Notes</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
	{{#each commentCalls}}
		<tr>
			<td>{{callDate}}</td>
			<td class='left'>{{{callNotes}}}</td>
			<td>
				<a href="javascript:$.deleteCenterCommentCall('{{idx}}')" class="btn_delete">delete</a>
			</td>
		</tr>
	{{/each}}
		</tbody>
	</table>
</div>
</script>
<#include "/include/popupfooter.ftl">