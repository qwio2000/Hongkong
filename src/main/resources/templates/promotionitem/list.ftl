<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">PromotionItem Items</h2>
	<form id="PromotionItem" action="/ja/promoitem/promoitemlist" method="get">	
	
			<div class="clearfix pb10 pt30">
				<div class="float_l">
					<div class="btnArea_txt p0"><a href="/ja/promoitem/addpage" class="btn_doc m0">Add New</a></div>
				</div>
			</div>

		
	
		
		<div class="tbl01 mt0">
		<#list list as list>
		<table>
			<colgroup>
				<col width="170px" />
				<col />
				<col width="200px"  />
				<col width="45px" />
			</colgroup>
			<tbody>
			<tr class="line2">
				<td class="no_line">
					<span class="p_img_wrap">
						 <#if (list.itemfile1NameConvert)??>
							<img src="/public/promotion/${list.itemfile1NameConvert}" width="150" />
						 <#else>
						 	<img src="/public/img/icon_delete.png"  />
						 </#if> 
					 </span>
				</td>
				<td class="left valin_t">
					<ul class="product_list">
						<li>
							<em>${list.itemName}</em> 
							<span class="txt">${list.itemDescription}</span>
						</li>
						<li><span class="tit">Color :</span>${list.itemColor} </li>
						<li><span class="tit">Price :</span>$${list.itemPrice}/${list.itemUOM} 
						 <#if (list.itemPerUnit)??>
							( ${list.itemPerUnit}	pcs.)					
						</#if> </li>
					</ul>
				</td>
				
				<td  class="left valin_t">
					<ul class="product_list">
						<li><span class="tit">Visible :</span>${list.itemVisible}</li>
						<li><span class="tit">Stock :</span>${list.itemStock} Pcs.</li>
					</ul>
					<div class="btnArea_txt p0">
						<a href="/ja/promoitem/modipage?itemCD=${list.itemCD}" class="btn_info">Update Item Info</a>
					</div>
				</td>
				<#if list.aidx == "Y" >					
					<td>
					</td>	
				<#else>
					<td>
						<a href="/ja/promoitem/delitem?itemCD=${list.itemCD}" class="btn_delete">delete</a>
					</td>	
				</#if> 
				
				
			
		</tr>
		</table>
		</#list>
	
	
		
		
		
		
	</form>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">
