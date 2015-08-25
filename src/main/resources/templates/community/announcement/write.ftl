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
				<div class="tbl-type-F">
					<form id="announcementFrm" action="/community/announcements" method="POST">
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
					<span class="button btn-type-I"><a id="submitBtn" ><#if article??>수정<#else>등록</#if></a></span>
					<span class="button btn-type-J"><a href="/community/announcements">취소</a></span>
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
