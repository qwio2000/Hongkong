<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top"><h1>Add Note</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
		<div class="popup_content">
			<div class="pop_jisa">
				<div class="tbl01">
					<table>
						<colgroup>
							<col width="130px" />
						</colgroup>
						<tbody>
							<tr>
								<th>Center Name</th>
								<td class="left">${loginInfo.deptName }</td>
							</tr>
							<tr>
								<th>Member Name</th>
								<td class="left">${memName }</td>
							</tr>
						</tbody>
					</table>
				</div>
				<form id="commentCallForm">
				<input type="hidden" name="memKey" id="memKey" value="${memKey }"/>
				<input type="hidden" name="memName" value="${memName }"/>
				<input type="hidden" name="pageNum" id="pageNum" value="1"/>
				<div class="textarea_wrap">
					<textarea name="callNotes" id="callNotes" cols="30" rows="10" maxlength="500"></textarea>
					<span class="max">Max 500</span>
					<div class="max_char_txt">You have 500 chracters left</div>
				</div>
				<div class="btnArea">
					<a href="javascript:commentCallSubmit();"><span>ADD NOTE</span></a>
				</div>
				</form>
				<div id="mainContent"></div>
				<div class="paging">
					<span id="pageNavi"></span>
				</div>
			</div>
		</div>
	</div>
<!--// Main Content -->
<script id="commentCallTemplate" type="text/x-handlebars-template">
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
				<a href="javascript:deleteCommentCall('{{idx}}')" class="btn_delete">delete</a>
			</td>
		</tr>
	{{/each}}
		</tbody>
	</table>
</div>
</script>
<#include "/include/popupfooter.ftl">