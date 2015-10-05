<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">PromotionItem ADD</h2>
	<form id="PromotionItem" action="/ja/promoitem/add" method="post">		
		<br/>
			item Name <input type="text" id="itemname" name="itemname" /> <br/>
			Description <input type="text" id="itemdescription" name="itemdescription" /> <br/>
			color <input type="text" id="itemcolor" name="itemcolor" /> <br/>
			Price <input type="text" id="itemprice" name="itemprice" /> <br/>
			UOM <input type="text" id="itemuom" name="itemuom" /> <br/>
			stock <input type="text" id="itemstock" name="itemstock" /> <br/>
			picture 1 <input type="file" id="itemfile1name" name="itemfile1name" /> <br/>
			picture 2 <input type="file" id="itemfile2name" name="itemfile2name" /> <br/>
			picture 3 <input type="file" id="itemfile3name" name="itemfile3name" /> <br/>
			Visible <input type="radio" id="itemvisible" name="itemvisible" value="Y"/>YES 
			<input type="radio" id="itemvisible" name="itemvisible" value="N" checked/>NO
			
			<br/>
			<br/>
			<br/>
			<a href="#"><input type="button" value="글쓰기"/></a>
	</form>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">