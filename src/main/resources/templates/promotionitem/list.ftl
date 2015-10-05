<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">PromotionItem List</h2>
	<form id="PromotionItem" action="/ja/promoitem/promoitemlist" method="get">		
		<ul class="memSearch" <#if loginInfo.userType == "JA"> style="float:right;"</#if>>
			<a href="/ja/promoitem/addpage">글쓰기</a>
		</ul>
	</form>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">