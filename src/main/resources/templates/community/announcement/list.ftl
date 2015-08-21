<#import "/spring.ftl" as spring/>
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
						<li class="current"><a href="/community/announcements"><@spring.message "Community.Announcement"/></a></li>
					</ul>
				</div>
				<div class="tab-A">
					<ul>
						<li class="first active"><a href="/community/announcements">알림</a></li>
					</ul>
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
