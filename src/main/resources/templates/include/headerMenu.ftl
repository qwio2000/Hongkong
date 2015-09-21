<#if loginInfo??>
	<#assign permLevel = loginInfo.userType?lower_case>
	<#if permLevel == "fa">
		<#assign titleName = loginInfo.deptName + ' Centre'/>
	<#elseif permLevel == "ja">
		<#assign titleName = 'HongKong'/>
	</#if>
</#if>
<div class="headerWrap">
	<div class="header">
		<input type="hidden" value="${menuFirstCode }" id="menuFirstCode"/>
		<a href="/logout"/><div class="logout"><strong>Logout</strong></div></a>
		<#if jisaAuthInfo??>
		<a href="/returnjisa"/><div class="logout"><strong>JISA</strong></div></a>
		</#if>
		<#if bmsAuthInfo??>
		<a href="/returnbms"/><div class="logout"><strong>BMS</strong></div></a>
		</#if>
		<h1><a href="/${permLevel }"><img src="${imgPath }/logo.png" alt="JEI Corporate HQ(JEI Korea)" /></a><span>${titleName } (${loginInfo.userFstName }${loginInfo.userLstName?default('') })</span></h1>
		<span class="utilInfo">Server Time : ${.now?string.medium_short} <br>System Week #2[9/6, 15-9, 12/15]</span>
<!-- 		<span class="utilInfo">Server Time : Sep 6, 2015 10:07 PM <br>System Week #2[9/6, 15-9, 12/15]</span> -->
		<ul class="gnb">
			<#list menuMap as menuList>
			<li <#if menuList[0].MMenuCode == menuFirstCode>class="active"</#if>>
				<#list menuList as menu>
					<#if menu.MParentIdx == 1>
						<a href="${menu.MMenuLink }" <#if menu.MMenuCode == menuFirstCode>class='on'</#if>>${menu.MMenuName }<span <#if menu.MMenuCode == menuFirstCode>class="on"</#if>></span></a>
						<#if menu.MHasChildren == "1">
							<ul class="gnbsub">
						</#if>
					<#else>
						<li><a href="${menu.MMenuLink }">${menu.MMenuName }</a></li>
					</#if>
				</#list>
				<#if menuList?size != 1>
					</ul>
				</#if>
			</li>
			</#list>
		</ul>
	</div>
</div>