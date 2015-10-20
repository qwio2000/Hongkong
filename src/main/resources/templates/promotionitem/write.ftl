<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Promotional Items</h2>
	<#if bordtype = 'modify' >
		<p class="path">Inventory &gt; Promotional Items &gt; Update</p>
	<#else>
		<p class="path">Inventory &gt; Promotional Items &gt; Add</p>
	</#if>
	 
	<#if bordtype = 'modify' >
		<form name="PromotionItem" action="/ja/promoitem/update" enctype="multipart/form-data"  method="post" >
		
		<div class="clearfix">
			
			<div class="float_l" style="width:200px">
				<div class="item_img">
					<#if promo.itemfile1NameConvert?exists>
						<img src="/public/promotion/${promo.itemfile1NameConvert}" alt="" style="width:150px;"/>
					<#else>
					</#if>
				</div>
			</div>
			<div class="float_r" style="width:760px">
				<ul class="list02">
					<li>
						<label for="" class="tit">Item Name</label>
						<span class="text_value"><input type="text" id="itemName" name="itemName" value="${promo.itemName}" style="width:384px"/></span>
					</li>
					<li>
						<label for="" class="tit">Description</label> 
						<span class="textarea_wrap">
							<textarea name="itemDescription" id="itemDescription" cols="30" rows="10" style="width:374px">${promo.itemDescription}</textarea>
						</span>
					</li>
					<li>
						<label for="" class="tit">Color</label>
						<input type="text" class="searchInput" name="itemColor" id="itemColor" style="width:384px" value="${promo.itemColor}">
					</li>
					<li>
						<label for="" class="tit">Price($)</label>
						<input type="text" class="searchInput" name="itemPrice" id="itemPrice" style="width:384px" value="${promo.itemPrice}">
					</li>
						<li>
						<label for="" class="tit">UOM</label>
						<select name="itemUOM" id="itemUOM" onchange="checkUOM();" value="${promo.itemUOM}" style="width:395px">
								<option value="EACH">EACH</option>
								<option value="PCS">PCS.</option>
								<option value="DOZEN">DOZEN</option>
								<option value="BOX">BOX</option>
								<option value="CASE">CASE</option>
								<option value="BAG">BAG</option>
								<option value="SET">SET</option>
						</select>
					</li>
					<li>
						<label for="" class="tit">Stock</label>
						<input type="text" id="itemStock" name="itemStock" value="${promo.itemStock}" style="width:150px;"/> Pcs.
					</li>
					<li>
						<label for="" class="tit">Picture1</label>
						<div class="attach">
							<input type="text" style="width:300px;" id="multipartFile1" <#if promo.itemfile1NameConvert?exists> value="${promo.itemfile1NameConvert}" </#if> class="file_input_textbox" readonly="">
							<div class="file_input_div">
								<input type="button" value="Search" class="file_input_button" id="">
								<input type="file" id="multipartFile1" name="multipartFile" class="file_input_hidden"/> 
							</div>
						</div>
					</li>
					<li>
						<label for="" class="tit">Picture2</label>
						<div class="attach">
							<input type="text" style="width:300px;" id="multipartFile2" <#if promo.itemfile2NameConvert?exists> value="${promo.itemfile2NameConvert}" </#if> class="file_input_textbox" readonly="">
							<div class="file_input_div">
								<input type="button" value="Search" class="file_input_button" id="">
								<input type="file" id="multipartFile2" name="multipartFile" class="file_input_hidden"/> 
							</div>
						</div>
					</li>
					<li>
						<label for="" class="tit">Picture3</label>
						<div class="attach">
							<input type="text" style="width:300px;" id="multipartFile3" <#if promo.itemfile3NameConvert?exists> value="${promo.itemfile3NameConvert}" </#if> class="file_input_textbox" readonly="">
							<div class="file_input_div">
								<input type="button" value="Search" class="file_input_button" id="">
								<input type="file" id="multipartFile3" name="multipartFile" class="file_input_hidden"/> 
							</div>
						</div>
					</li>
					<li>
						<label for="" class="tit">Visible</label>
						<span class="radio_wrap"><input type="radio" id="itemVisible" name="itemVisible" value="Y" <#if promo.itemVisible = 'Y' > checked </#if> ><label class="radio_label" for="visible1"> Yes</label></span>
						<span class="radio_wrap"><input type="radio" id="itemVisible" name="itemVisible" value="N" <#if promo.itemVisible ='N' > checked  </#if>/><label class="radio_label" for="visible2"> No</label></span>
					</li>
				</ul>
			</div>
		</div>

			<div class="btnArea">
				<a href="/ja/promoitem/promoitemlist"><span>Cancle</span></a> <a href="javascript:document.PromotionItem.submit();"><span>Update Item Info</span></a>
			</div>
		</div>
				
		<input type="hidden" value="${promo.itemCD}" name="itemCD" id="itemCD" />
		</form>
	<#else>
		<form name="PromotionItem" action="/ja/promoitem/add" enctype="multipart/form-data"  method="post" >
			<ul class="list02">
				<li>
					<label for="" class="tit">Item Name</label>
					<input type="text" id="itemName" name="itemName" class="searchInput" style="width:384px"/>
				</li>
				<li>
					<label for="" class="tit">Description</label> 
					<span class="textarea_wrap">
						<textarea  id="itemDescription" name="itemDescription"  cols="30" rows="10" style="width:374px"></textarea>
					</span>
				</li>
				<li>
					<label for="" class="tit">Color</label>
					<input type="text" class="searchInput" style="width:384px" id="itemColor" name="itemColor">
				</li>
				<li>
					<label for="" class="tit">Price($)</label>
					<input type="text" class="searchInput" style="width:384px" id="itemPrice" name="itemPrice" value="0">
				</li>
				<li>
				<label for="" class="tit">UOM</label>
					<select name="itemUOM" id="itemUOM" onchange="checkUOM();" style="width:395px; float:left;">
							<option value="EACH">EACH</option>
							<option value="PCS">PCS.</option>
							<option value="DOZEN">DOZEN</option>
							<option value="BOX">BOX</option>
							<option value="CASE">CASE</option>
							<option value="BAG">BAG</option>
							<option value="SET">SET</option>
					</select>
					<div id="visibleUOM" style="display:none; width:150px;float:left; margin-left:10px;">
						<input type="text" class="searchInput" style="width:150px;" id="itemPerUnit" name="itemPerUnit" > pcs.
					</div>
				</li>
				<li>
					<label for="" class="tit">Stock</label>
					<input type="text" class="searchInput" style="width:150px" id="itemStock" name="itemStock"> Pcs.
				</li>
				<li>
					<label for="" class="tit">Picture1</label>
					<div class="attach">
						<input type="text" style="width:300px;" id="" name="" class="file_input_textbox" readonly="">
						<div class="file_input_div">
							<input type="button" value="Search" class="file_input_button" id="">
							<input type="file" class="file_input_hidden" id="multipartFile1" name="multipartFile">
						</div>
					</div>
				</li>
				<li>
					<label for="" class="tit">Picture2</label>
					<div class="attach">
						<input type="text" style="width:300px;" id="" name="" class="file_input_textbox" readonly="">
						<div class="file_input_div">
							<input type="button" value="Search" class="file_input_button" id="">
							<input type="file" class="file_input_hidden" id="multipartFile2" name="multipartFile">
						</div>
					</div>
				</li>
				<li>
					<label for="" class="tit">Picture3</label>
					<div class="attach">
						<input type="text" style="width:300px;" id="" name="" class="file_input_textbox" readonly="">
						<div class="file_input_div">
							<input type="button" value="Search" class="file_input_button" id="">
							<input type="file" class="file_input_hidden" id="multipartFile3" name="multipartFile">
						</div>
					</div>
				</li>
				<li>
					<label for="" class="tit">Visible</label>
					<span class="radio_wrap"><input type="radio" value="Y" id="itemVisible" name="itemVisible" checked><label class="radio_label" for="visible1"> Yes</label></span>
					<span class="radio_wrap"><input type="radio" value="N" id="itemVisible" name="itemVisible"><label class="radio_label" for="visible2"> No</label></span>
				</li>
			</ul>
			<div class="btnArea">
				<a href="/ja/promoitem/promoitemlist"><span>Cancle</span></a> <a href="javascript:document.PromotionItem.submit();"><span>Add Item</span></a>
			</div>
		</div>
		</form>
	
	</#if>
</div>
<!--// Main Content -->
<script type="text/javascript">
	function checkUOM(){
		var item = document.getElementById("itemUOM").value ;
		if(item ==  "PCS" || item ==  "BOX"  || item ==  "CASE" || item ==  "BAG" || item ==  "SET" ){
			document.getElementById("visibleUOM").style.display = "";
		}else{
			document.getElementById("visibleUOM").style.display = "none";
		}
	}


</script>
<#include "/include/footer.ftl">
