<!-- header -->
<#if loginInfo??>
	<#assign permLevel = loginInfo.empKeyLvCD?lower_case>
	<#if permLevel == "fa">
		<#assign url = '/' + permLevel + '/members'/>
	<#elseif permLevel == "ja">
		<#assign url = '/' + permLevel + '/centers'/>
	</#if>
</#if>
<div id="header">
	<div class="content">
		<h1 class="logo"><a href="${url }"><img src="/public/img/common/logo_header.gif" alt="재능Global" /></a></h1>
	<div class="login-info">
		<@security.authorize ifAnyGranted="SUPERADMIN">
		<div class="btn-join-state">
			<a href="/adminManager/menuIndex"><img src="/public/img/common/btn_go.gif" alt="메뉴관리" /></a>
		</div>
		</@security.authorize>
		<#if bmsAuthInfo??>
		<div class="btn-join-state">
			<span>
				<a href="/returnbms"><font style="color: white;">본사 </font><img src="/public/img/common/btn_go.gif" alt="본사" /></a>
			</span>
		</div>
		</#if>
		<#if jisaAuthInfo??>
		<div class="btn-join-state">
			<span>
				<a href="/returnjisa"><font style="color: white;">지사 </font><img src="/public/img/common/btn_go.gif" alt="지사" /></a>
			</span>
		</div>
		</#if>
		<div class="btn-join-state">
			<a href="/logout"><img src="/public/img/common/btn_gnb_logout.gif" alt="로그아웃" /></a>
		</div>
	</div>
	<ul class="lnb">
	<#if headerMenuList?has_content>
		<#list headerMenuList as headerMenu>
			<li><a href="${headerMenu.MMenuLink }"><span style="margin-right: 20px;font-size: 15px;color: white;<#if headerMenu.MMenuCode == menuFirstCode>font-weight:bold;</#if>">${headerMenu.MMenuName }</span></a></li>
			</#list>
		</#if>
		</ul>
	</div>
</div>
<!-- //header -->