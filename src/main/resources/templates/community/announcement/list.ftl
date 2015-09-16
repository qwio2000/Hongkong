<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Announcement</h2>
	<div class="tbl01">
		<div class="mgt-20 search-class">
			<input name='pageNum' id="pageNum" type='hidden' value='${pageNum }' />
			<fieldset>
				<legend></legend>
				<p>
					<select name='searchField' id="searchField" style="width: 75px;"
						title="검색조건선택">
						<option value='boardSubject'>제목</option>
						<option value='boardContent'>내용</option>
						<option value='memberId'>작성자</option>
					</select> <input name='searchValue' id="searchValue" type="text"
						class="text" style="width: 300px;" title="" value='' /> <span
						class="button"><input type="button" id="searchBtn"
						title="검색버튼" value="검색" /></span>
				</p>
			</fieldset>
		</div>
		<h1 class="mgt-20"></h1>
		<p>
			* 총 <strong id="totalCnt">0</strong>건
		</p>
		<div class="tbl-type-D">
			<table style="width: 100%; border: 0;">
				<colgroup>
					<col width="5%">
					<col width="*%">
					<col width="20%">
					<col width="15%">
					<col width="5%">
				</colgroup>
				<thead>
					<tr>
						<th>NO</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody id=mainContent></tbody>
			</table>
		</div>
		<div class="paging">
			<span id="pageNavi"></span>
		</div>
		<div class="btn-box float-r">
			<span class="button btn-type-I"><a
				href="/fa/community/announcements/new">글쓰기</a></span>
		</div>
	</div>
</div>
<!--// Main Content -->
<script id="announcementsTemplate" type="text/x-handlebars-template">
	{{#each articles}}
		<tr>
			<td>{{boardNo @index}}</td>
			<td>
				<p class="tb_1">
					<a href='/fa/community/announcements/{{boardIdx}}?pageNum={{../pageInfo.pageNum}}'>{{{boardSubject}}}</a>
				</p>
			</td>
			<td>{{memberId}}</td>
			<td>{{boardRegDate}}</td>
			<td>{{boardReadCount}}</td>
		</tr>
	{{else}}
		<tr>
			<td colspan="5">데이터가 없습니다.</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl"> 