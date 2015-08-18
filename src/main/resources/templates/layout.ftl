<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>${title?default('')}</title>
<link rel="stylesheet" type="text/css" href="/public/css/common.css" />
<link rel="stylesheet" type="text/css" href="/public/css/layout_center.css" />
<link rel="stylesheet" type="text/css" href="/public/css/jquery-ui.1.11.4.min.css" />
<#if headerCss?has_content>
	<#list headerCss as css>
		<link rel="stylesheet" type="text/css" href="/public/css/${css}.css" />
	</#list>
</#if>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.3/handlebars.min.js"></script>
<script type="text/javascript" src="/public/js/common.js"></script>
<#if headerScript?has_content>
	<#list headerScript as script>
		<script type="text/javascript" src="/public/js/${script}.js"></script>
	</#list>
</#if>
</head>
<script type="text/javascript">
$(function(){
	//family site
	$('.fmTitle').click(function(e) {
		var target = $(this).attr('href');
		$(target).slideDown();
		$(target).find('.btn-close').click(function() {
			$(target).slideUp();
		});
	});
});
</script>

<body>
<a href="#primary_content" class="skip-nav">본문 컨텐츠 바로가기</a>
<div id="wrapper">
	<!-- header -->
	<div id="header">
		<div class="content">
			<h1 class="logo"><a href="/"><img src="/public/img/common/logo_header.gif" alt="재능Global" /></a></h1>
			<div class="notice">
			</div>
			<div class="login-info">
				<dl>
				</dl>
				<div class="btn-join-state">
					<a href="/logout"><img src="/public/img/common/btn_gnb_logout.gif" alt="로그아웃" /></a>
				</div>
			</div>
			<ul class="lnb">
				<li><a href="/memberCard"><#if menuFirstCode?exists && menuFirstCode?string  == "1"><img src="/public/img/common/lnb_01_on.gif" alt="회원관리" /><#else><img src="/public/img/common/lnb_01_off.gif" alt="회원관리" /></#if></a></li>
				<li><a href="/subul"><#if menuFirstCode?exists && menuFirstCode?string  == "2"><img src="/public/img/common/lnb_02_on.gif" alt="교재수불" /><#else><img src="/public/img/common/lnb_02_off.gif" alt="교재수불" /></#if></a></li>
				<li><a href="/siljuk"><#if menuFirstCode?exists && menuFirstCode?string  == "3"><img src="/public/img/common/lnb_03_on.gif" alt="실적현황" /><#else><img src="/public/img/common/lnb_03_off.gif" alt="실적현황" /></#if></a></li>
				<li><a href="/board"><#if menuFirstCode?exists && menuFirstCode?string  == "4"><img src="/public/img/common/lnb_04_on.gif" alt="커뮤니티" /><#else><img src="/public/img/common/lnb_04_off.gif" alt="커뮤니티" /></#if></a></li>
			</ul>
		</div>
	</div>
	<!-- //header -->

	<!-- container -->
	<div id="container">
		<div id="content">
			<div class="side-content">
				<p class="msg2"> <strong><@security.authentication property="principal.empName" ></@security.authentication></strong>님 환영합니다.</p>
				<div class="mb-state">
					<h3><img src="/public/img/today/tit_mb_state.gif" alt="센터현황" /></h3>
					<a href="#none" class="more"><img src="/public/img/common/icon_more.gif" alt="더보기" /></a>
					<ul>
						<li>
							<a href="#none">- 금월 입회과목 <em>00</em> 명</a> <img src="/public/img/common/icon_new_white.gif" alt="NEW" />
						</li>
						<li>
							<a href="#none">- 금월 퇴회과목 <em>00</em> 명</a>
						</li>
						<li>
							<a href="#none">- 금월 생일회원 <em>00</em> 명</a>
						</li>
						<li>
							<a href="#none">- 금월 미납과목 <em>00</em> 명</a>
						</li>
					</ul>
				</div>
				<#--include "/leftMenu.ftl"-->
				<div class="banner-section">
					<a href="#none"><img src="/public/img/common/bn_side_02.gif" alt="" /></a>
					<a href="#none"><img src="/public/img/common/bn_side_03.gif" alt="" /></a>
				</div>
			</div>
			<div id="primary_content" class="primary-content">
				</div>
			</div>
		</div>
	<form name="frm1" action="" method="post">
		<input type="hidden" name="mKey" value=""/>
		<input type="hidden" name="sKey" value=""/>
		<input type="hidden" name="kwamok" value=""/>
	</form>
	</div>
	<!-- //container -->

	<!-- footer -->
	<#include "/footer.ftl">
	<!-- //footer -->
</body>
</html>
