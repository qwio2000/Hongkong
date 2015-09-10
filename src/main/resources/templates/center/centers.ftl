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
					<li class="home"><a href="/">Home</a> &gt; </li>
					<li><a href="/ja/centers">Centers</a> &gt; </li>
					<li class="current"><a href="/ja/centers">Search</a></li>
				</ul>
			</div>
			<div class="tab-A">
				<ul>
					<li class="first active"><a href="/ja/centers">Center Search</a></li>
				</ul>
			</div>
			<div class="tbl-type-D" style="margin-top: 50px;">
				<table style="width:100%;border: 0;">
					<colgroup>
						<col width="5%">
						<col width="5%">
						<col width="30%">
						<col width="10%">
						<col width="10%">
						<col width="15%">	
						<col width="15%">	
						<col width="5%">	
						<col width="5%">	
					</colgroup>
					<thead>
						<tr>
							<th></th>
							<th>ST</th>
							<th>Center Name</th>
							<th>Member</th>
							<th>Subject</th>
							<th>Director</th>
							<th>Phone</th>
							<th>Status</th>
							<th></th>
						</tr>
					</thead>
					<tbody id=mainContent>
						<tr>
							<td>1</td>
							<td>SI</td>
							<td>HQ</td>
							<td>41</td>
							<td>53</td>
							<td>HDQ조직장</td>
							<td>010-1111-1111</td>
							<td>Active</td>
							<td><a href="/ja/centers/login?memberId=00713">Login</a></td>
						</tr>
						<tr>
							<td>2</td>
							<td>SI</td>
							<td>Shenzhen</td>
							<td>22</td>
							<td>22</td>
							<td>심천조직장</td>
							<td>010-2222-2222</td>
							<td>Active</td>
							<td><a href="/ja/centers/login?memberId=00718">Login</a></td>
						</tr>
					</tbody>
				</table>
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
