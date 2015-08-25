<#include "/include/header.ftl">
<body>
<a href="#primary_content" class="skip-nav">본문 컨텐츠 바로가기</a>
<div id="wrapper">
	<#include "/include/headerMenu.ftl">
	<!-- container -->
	<div id="container">
		<div id="content">
			<div class="side-content">
				<#include "/include/leftContents.ftl">
				<#include "/include/leftMenu.ftl">
				<div class="banner-section">
					<a href="#none"><img src="/public/img/common/bn_side_02.gif" alt="" /></a>
					<a href="#none"><img src="/public/img/common/bn_side_03.gif" alt="" /></a>
				</div>
			</div>
			<div id="primary_content" class="primary-content">
				<div class="page-path">
					<ul>
						<li class="home"><a href="#none">Home</a> &gt; </li>
						<li><a href="#none">Community</a> &gt; </li>
						<li class="current"><a href="/community/announcements">Announcements</a></li>
					</ul>
				</div>
				<div class="tab-A">
					<ul>
						<li class="first active"><a href="/community/announcements">알림</a></li>
					</ul>
				</div>
				<br/><br/>
				<form id="viewForm">
					<input type="hidden" name="boardIdx" id="boardIdx" value="${article.boardIdx }">
				</form>
				<div class="tbl-type-F">
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
									<div class="td-left">첨부파일</div>
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
					<div class="mgt-20">
					<#if loginInfo.memberId == article.memberId >
						<span class="button btn-type-J">
							<a href="/community/announcements/${article.boardIdx }/edit">수정</a>
						</span>
						<span class="button btn-type-J">
							<a id="deleteBtn">삭제</a>
						</span>
					</#if>
						<span class="button float-r btn-type-I">
							<a href="/community/announcements?pageNum=${pageNum }">목록</a>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //container -->
	<!-- footer -->
	<#include "/include/footer.ftl">
	<!-- //footer -->
</div>
</body>
</html>
