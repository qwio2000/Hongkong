<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Announcement</h2>
	<form id="viewForm">
		<input type="hidden" name="boardIdx" id="boardIdx" value="${article.boardIdx }">
	</form>
	<div class="tbl01">
		<table width="100%" cellSpacing="0" summary="">
			<colgroup>
				<col width="100">
				<col width="*">
				<col width="80">
				<col width="120">
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td>
						<div class="td-left">${article.boardSubject }</div>
					</td>
					<th>작성자</th>
					<td>${article.memberId }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<div class="td-left">
							<#list article.attachFiles as attachFile>
								<a href="/fa/community/announcements/${article.boardIdx }/${attachFile.fileIdx }?fileName=${attachFile.fileName}&fileOriginalName=${attachFile.fileOriginalName}">${attachFile.fileOriginalName }</a>
								<#if attachFile_has_next><br/></#if>
							</#list>
						</div>
					</td>
					<th>등록일</th>
					<td>${article.boardRegDate }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">
						<div class="td-left" style="height: 300px;">${article.boardContent }</div>
					</td>
				</tr>
			</tbody>
		</table>
		<br/>
		<form method="post" name="commentForm" id="commentForm" action="/fa/community/announcements/${article.boardIdx}/comment">
		<table width="100%" cellSpacing="0" summary="">
			<colgroup>
				<col width="100">
				<col width="*">
				<col width="80">
				<col width="120">
			</colgroup>
			<tbody>
				<tr>
					<th>댓글</th>
					<td colspan="2"><div class="td-left"><input type="text" style="width: 700px;" name="commentContent" id="commentContent" class="text"></div></td>
					<td>
						<span class="button btn-type-C">
							<a id="commentSubmit" style="cursor: pointer;">등록</a>
						</span>
					</td>
				</tr>
			</tbody>
		</table>
		</form>
		<table width="100%" cellSpacing="0" summary="">
			<colgroup>
				<col width="100">
				<col width="*">
				<col width="80">
				<col width="120">
			</colgroup>
			<tbody id="commentsContent">
				<#list comments as comment>
				<tr>
					<th>${comment.memberId }<br/>${comment.commentRegDate}</th>
					<td colspan="2"><div class="td-left">${comment.commentContent }</div></td>
					<td>
					<#if loginInfo.userId == comment.memberId >
						<span class="button btn-type-C">
							<a href="javascript:$.commentDelete('${comment.commentIdx }');">삭제</a>
						</span>
					</#if>
					</td>
				</tr>
				</#list>
			</tbody>
		</table>
		<div class="mgt-20">
		<#if loginInfo.userId == article.memberId >
			<span class="button btn-type-J">
				<a href="/fa/community/announcements/${article.boardIdx }/edit">수정</a>
			</span>
			<span class="button btn-type-J">
				<a id="deleteBtn" style="cursor: pointer;">삭제</a>
			</span>
		</#if>
			<span class="button float-r btn-type-I">
				<a href="/fa/community/announcements?pageNum=${pageNum }">목록</a>
			</span>
		</div>
	</div>
</div>
<!--// Main Content -->
<script id="commentsTemplate" type="text/x-handlebars-template">
	{{#each comments}}
		<tr>
			<th>{{memberId }}<br/>{{commentRegDate}}</th>
			<td colspan="2"><div class="td-left">{{{commentContent }}}</div></td>
			<td>
			{{#xIf ../loginInfo.userId "==" memberId}}
				<span class="button btn-type-C">
					<a href="javascript:$.commentDelete('{{commentIdx }}');">삭제</a>
				</span>
			{{/xIf}}
			</td>
		</tr>
	{{else}}
		<tr>
			<td colspan="5">데이터가 없습니다.</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl">