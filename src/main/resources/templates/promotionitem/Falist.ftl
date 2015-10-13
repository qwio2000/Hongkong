<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">PromotionItem List</h2>
	<form id="PromotionItem" action="/fa/promoitem/promoitemfalist" method="get">		
		<ul class="memSearch" <#if loginInfo.userType == "FA"> style="float:right;"</#if>>
			<a href="/ja/promoitem/addpage">글쓰기</a>
		</ul>
		
		
		<!--주문내역-->
		<div>
					
		</div>
		
		<!--카트내역(장바구니)-->
		<div>
		
		</div>
		
		
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
					<strong>Order Qty:</strong>:  
						<select name="scQty" id="scQty_1">
							<#list 1..100 as i>
								<option value="${i}">${i}</option>
							</#list>
						</select>
					<br>
					<div style="margin-top:10px;">
						<input type="button" value="Add to Cart" onclick="cartAdd('1');" style="width:120px;">
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