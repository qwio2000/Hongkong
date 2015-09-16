<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Announcement</h2>
	<div class="tbl01">
	<form id="announcementFrm" action="/fa/community/announcements/${article?if_exists.boardIdx?default("") }" method="POST" enctype="multipart/form-data">
	<table width="100%" cellSpacing="0" summary="">
		<colgroup>
			<col width="95">
			<col width="300">
			<col width="130">
			<col width="130">
			<col width="*px">
		</colgroup>						
		<tbody>
		<tr>
			<th>제목</th>
			<td colspan="3">
				<div class="td-left">
					<input name='boardSubject' id='boardSubject' type="text" class="text"  style="width: 820px;" value='${article?if_exists.boardSubject?default("") }' />                                                                
				</div>
			</td>
		</tr>
		<tr>
			<th>파일첨부</th>
			<td colspan="3">
				<div class="td-left">
					<#if article??>
						<div id="attachFile1">
						<#if article?if_exists.attachFiles[0]?if_exists.fileOriginalName??>
							<a class="attachFileDeleteBtn" style="cursor: pointer;" onclick="$.fileDelete('${article?if_exists.boardIdx?default("") }','${article?if_exists.attachFiles[0]?if_exists.fileIdx}','1');"><img width="10px" height="10px" src="${imgPath }/community/announcement/btn_gal_close.png"/></a>
							${article?if_exists.attachFiles[0]?if_exists.fileOriginalName }
						<#else>
							<input type="file" name="attachFile" class="attachFile"/>
						</#if>
						</div>
						<div id="attachFile2">
						<#if article?if_exists.attachFiles[1]?if_exists.fileOriginalName??>
						<a class="attachFileDeleteBtn" style="cursor: pointer;" onclick="$.fileDelete('${article?if_exists.boardIdx?default("") }','${article?if_exists.attachFiles[1]?if_exists.fileIdx}','2');"><img width="10px" height="10px" src="${imgPath }/community/announcement/btn_gal_close.png"/></a>
							${article.attachFiles[1]?if_exists.fileOriginalName }
						<#else>
							<input type="file" name="attachFile" class="attachFile"/>
						</#if>
						</div>
					<#else>
						<div id="attachFile1">
							<input type="file" name="attachFile" class="attachFile"/>
						</div>
						<div id="attachFile2">
							<input type="file" name="attachFile" class="attachFile"/>
						</div>
					</#if>
				</div>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td class="pd-0" colSpan="3">
				<textarea id='boardContent' name='boardContent' cols='94' rows='15' style="width: 810px;">${article?if_exists.boardContent?default("") }</textarea>
			</td>
		</tr>
		</tbody>
	</table>
	</form>
</div>
<div class="btn-box float-r">
	<span class="button btn-type-I"><a id="submitBtn" style="cursor: pointer;"><#if article??>수정<#else>등록</#if></a></span>
	<span class="button btn-type-J"><a href="/fa/community/announcements" >취소</a></span>
</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
