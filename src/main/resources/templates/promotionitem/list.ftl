<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">PromotionItem List</h2>
	<form id="PromotionItem" action="/ja/promoitem/promoitemlist" method="get">		
		<ul class="memSearch" <#if loginInfo.userType == "JA"> style="float:right;"</#if>>
			<a href="/ja/promoitem/addpage">글쓰기</a>
		</ul>
		
		
	
		
		
		<#list list as list>
		<table width="100%" cellpadding="10" cellspacing="0" style="border-top:2px solid silver;">
			<tr>
				<td style="width:150px;">
					 <#if (list.itemfile1NameConvert)??>
						<img src="/public/promotion/${list.itemfile1NameConvert}" width="150" />
						
					 <#else>
					 <center>
					 	<img src="/public/img/icon_delete.png"  />
					 </center>	
					 </#if> 
				</td>
				<td class="gridCell" valign="top">
					<strong>${list.itemName}</strong>
					
						<div style="padding-left:10px;">${list.itemDescription}</div>
					
						<br><strong>Color</strong>: ${list.itemColor}
					
					<br>
					<strong>Price</strong>: ${list.itemStock}/${list.itemUOM} 
						 <#if (list.itemPerUnit)??>
							( ${list.itemPerUnit}	pcs.)					
						</#if> 
					
				</td>
				
				
				<td class="gridCell" valign="top" style="width:150px; ">
					<strong>Visible</strong>:  ${list.itemVisible}<br>
					<div style="color:black">
						<strong>Stock</strong>: ${list.itemStock} Pcs.<br>
					</div>
					<div style="margin-top:10px;">
						<a href="/ja/promoitem/modipage?itemCD=${list.itemCD}">
							Update Item Info
						</a><br/>
						<#if (list.aidx)??>
						<#else>
							<a href="/ja/promoitem/delitem?itemCD=${list.itemCD}">Delete Item</a>	
						</#if> 
					</div>
				</td>
			</td>
		</tr>
		</table>
		<#else>
			No Result.
		</#list>
	
	
		
		
		
		
	</form>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
