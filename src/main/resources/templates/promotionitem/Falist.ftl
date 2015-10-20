<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Promotional Items</h2>
			
		
		<!-- str : Order - 주문내역-->
		<h3 class="conTit_sub">Order history</h3>
		
		<#assign ordersize=orderlist?size>
		
		<#if ( ordersize > 0 ) >
		<div class="tbl01 mt0">
				<table>
					<colgroup>
						<col width="100" />
						<col width="80" />
						<col width="70" />
						<col width="70" />
						<col width="70" />
						<col width="70" />
						<col />
					</colgroup>
					<thead>
						<tr>
							<th>Order Date</th>
							<th>Ref.#</th>
							<th>OrderQty</th>
							<th>OrderAmt</th>
							<th>ShipQty</th>
							<th>ShipAmt</th>
							<th>Note</th>
						</tr>
					</thead>
					<tbody>
					
						<#list orderlist as orderlist>
						<tr>
							<td>${orderlist.orderYMD}</td>
							<td><a href="javascript:orderdtllist('${orderlist.aidx}')" class="blue">#${orderlist.aidx}</a></td>
							<td>${orderlist.orderTotQty}</td>
							<td>$${orderlist.orderTotAmt}</td>
							<td>${orderlist.shipTotQty}</td>
							<td>$${orderlist.shipTotAmt}</td>
							<td class="left">${orderlist.orderNote}</td>
						</tr>
						</#list>
					</tbody>
				</table>
			</div>
		<#else>
			No Order History
		</#if>
			
		<!-- end : Order - 주문내역-->	
		
		<!-- str : Cart - 카트내역(장바구니)-->
		<form name="PromotionOrderItem" action="/fa/promoitem/promoitemfaorder" method="post">
		<#assign cartsize=cartlist?size>
		<h3 class="conTit_sub icon_cart">You have ${cartsize} items in your cart.</h3>
		
		<#if ( cartsize > 0 ) >
		
		<div class="tbl01 mt0">
				<table>
					<thead>
						<tr>
							<th>Item Name</th>
							<th>Color</th>
							<th>Price</th>
							<th>Qty</th>
							<th>Amount</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<#list cartlist as cartlist>
						<tr>
							<td class="left"><a class="line">${cartlist.itemName}</a></td>
							<td>${cartlist.itemColor}</td>
							<td>$${cartlist.itemPrice}/${cartlist.itemUOM}</td>
							<td>${cartlist.cartQty}</td>
							<td>$${cartlist.cartAmt}</td>
							<td><a href="/fa/promoitem/promoitemfacartdel?aidx=#{cartlist.aidx}" class="btn_delete">delete</a></td>
						</tr>
						</#list>
					</tbody>
				</table>
			</div>
			
				
			<ul class="list02 pt10">
				<li>
					<span class="tit" style="width:35px">Note</span> <input type="text" class="searchInput" name="orderNote" id="orderNote" style="width:712px" /> 
					<span class="btnArea">
						<a href="javascript:document.PromotionOrderItem.submit();"><span style="width:180px">Submit Order Request</span></a>
					</span>
				</li>
			</ul>
			</#if>
			
		</form>	
		<!-- end : Cart - 카트내역(장바구니)-->
		
		<!-- str : 리스트 -->
		<form name="PromotionCartItem" action="/fa/promoitem/promoitemfacartadd" method="post">
		<div class="tbl01 mt50">
		<table>
			<colgroup>
				<col width="190px" />
				<col />
				<col width="220px" />
			</colgroup>
			<tbody>
		<#list list as list>
			<tr class="line2">
				<td class="no_line"><span class="p_img_wrap">
					 <#if (list.itemfile1NameConvert)??>
						<img src="/public/promotion/${list.itemfile1NameConvert}" width="150" />
					 <#else>
					 	<img src="/public/img/icon_delete.png"  />
					 </#if> 
				</span></td>
				<td class="left valin_t">
					
					<ul class="product_list">
						<li>
							<em>${list.itemName}</em> 
							<span class="txt">${list.itemDescription}</span>
						</li>
						<li><span class="tit">Color : </span> ${list.itemColor}</li>
						<li><span class="tit">Price : </span> $${list.itemPrice} /<#if (list.itemPerUnit)??>
																( ${list.itemPerUnit}	pcs. )					
															</#if> ${list.itemUOM} 
						</li>
					</ul>
				</td>
				<td class="valin_t">
					<div class="wrap_order">
						<span class="qty">Order Qty</span> 
						
						<select name="scQty_${list.itemCD}" id="scQty_${list.itemCD}" style="width:108px">
							<#list 1..100 as i>
								<option value="${i}">${i}</option>
							</#list>
						</select> ${list.itemUOM}
					<div class="btnArea">
						<a href="javascript:cartAdd('${list.itemCD}','${list.itemName}','${list.itemColor}','${list.itemPrice}','${list.itemUOM}');"><span style="width:170px">Add to Cart</span></a>
					</div>
				</td>
			</td>
		</tr>
		</#list>
		</tbody>
	</table>
	
	<input type="hidden" name="itemCD" id="itemCD" value="" />
	<input type="hidden" name="itemName" id="itemName" value="" />
	<input type="hidden" name="itemColor" id="itemColor" value="" />
	<input type="hidden" name="itemPrice" id="itemPrice" value="" />
	<input type="hidden" name="itemUOM" id="itemUOM" value="" />
	<input type="hidden" name="cartQty" id="cartQty" value="" />
	<input type="hidden" name="cartAmt" id="cartAmt" value="0" />
	
	</form>
	<!-- end : 리스트 -->
		
		
	
</div>
<div class="popbg" id="popbg"></div>
<div class="popcontainer" id="popcontainer"></div>
<!--// Main Content -->
<style type="text/css">
	.popbg {position:absolute; top:0; left:0; width:100%; height:100%; background:#000; opacity:.5; filter:alpha(opacity=50); z-index:100; display:none;}
	.popcontainer {position:absolute;  top: 10%; left: 10%; padding: 20px 25px; z-index:105; display:none; background-color:#fff; width:70%;}
</style>

<script type="text/javascript">
	function cartAdd(itemCD,itemName,itemColor,itemPrice,itemUOM){
		document.PromotionCartItem.itemCD.value = itemCD;
		document.PromotionCartItem.itemName.value = itemName;
		document.PromotionCartItem.itemColor.value = itemColor;
		document.PromotionCartItem.itemPrice.value = itemPrice;
		document.PromotionCartItem.itemUOM.value = itemUOM;
		document.PromotionCartItem.cartQty.value = document.getElementById("scQty_"+ itemCD).value ;
		document.PromotionCartItem.cartAmt.value = eval(document.getElementById("scQty_"+ itemCD).value * itemPrice) ;
		document.PromotionCartItem.submit();
	}
	
	function orderdtllist(aidx){
		document.getElementById("popbg").style.display = "block";
		document.getElementById("popcontainer").style.display = "block";
		$.ajax({
		  url: "/fa/promoitem/promoitemfaorderpop",
		  type: "POST",
		  data: {aidx : aidx}
		}).done(function(data) {
		  $("#popcontainer").append(data);
		});
	}
	
	function closepop(){
		document.getElementById("popbg").style.display = "none";
		document.getElementById("popcontainer").style.display = "none";
		$("#popcontainer").html("");
	}

</script>

<#include "/include/footer.ftl">