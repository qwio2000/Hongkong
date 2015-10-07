<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">PromotionItem ADD</h2>
	 
	<#if bordtype = 'modify' >
		 <form name="PromotionItem" action="/ja/promoitem/update" enctype="multipart/form-data"  method="post" >
			<br/>
				item Name <input type="text" id="itemName" name="itemName" value="${promo.itemName}"/> <br/>
				Description 
				<textarea   id="itemDescription" name="itemDescription" style="width: 100%; height:100px;">
				${promo.itemDescription}</textarea>
				<br/>
				color <input type="text" id="itemColor" name="itemColor" value="${promo.itemColor}"/> <br/>
				Price <input type="text" id="itemPrice" name="itemPrice"  value="${promo.itemPrice}"/> <br/>
				UOM 					<select name="itemUOM" id="itemUOM" onchange="checkUOM();" value="${promo.itemUOM}">
												<option value="EACH">EACH</option>
												<option value="PCS">PCS.</option>
												<option value="DOZEN">DOZEN</option>
												<option value="BOX">BOX</option>
												<option value="CASE">CASE</option>
												<option value="BAG">BAG</option>
												<option value="SET">SET</option>
										</select>
										<div id="visibleUOM" style="display:none;">
											<input type="text" id="itemPerUnit" name="itemPerUnit"  <#if (list.itemPerUnit)??> value="${promo.itemPerUnit}" <#else> value="0" </#if> /> Pcs.
										</div>	
											<br/>
				stock <input type="text" id="itemStock" name="itemStock" value="${promo.itemStock}" />Pcs. <br/>
				picture 1 <input type="file" id="multipartFile1" name="multipartFile" /> 
				<#if promo.itemfile1NameConvert?exists> <input type="checkbox" id="delchk1" name="delchk1" value="${promo.itemfile1NameConvert}" onclick="fucdelchk('1')"/>delete </#if> 
				<br/>
				picture 2 <input type="file" id="multipartFile2" name="multipartFile" /> 
				<#if promo.itemfile2NameConvert?exists> <input type="checkbox" id="delchk2" name="delchk2"  value="${promo.itemfile2NameConvert}" onclick="fucdelchk('2')"/>delete  </#if> 
				<br/>
				picture 3 <input type="file" id="multipartFile3" name="multipartFile" /> 
				<#if promo.itemfile3NameConvert?exists> <input type="checkbox" id="delchk3" name="delchk3"  value="${promo.itemfile3NameConvert}" onclick="fucdelchk('3')"/>delete  </#if> 
				<br/>
				Visible <input type="radio" id="itemVisible" name="itemVisible" value="Y" <#if promo.itemVisible = 'Y' > checked </#if> />YES 
				<input type="radio" id="itemVisible" name="itemVisible" value="N" <#if promo.itemVisible ='N' > checked  </#if>/>NO
				
				<br/>
				<br/>
				<br/>
				<input type="hidden" id="itemCD" name="itemCD" value="${promo.itemCD}" />
				
				<input type="hidden" id="Itemfile1NameConvert" name="Itemfile1NameConvert" value="" />
				<input type="hidden" id="Itemfile2NameConvert" name="Itemfile2NameConvert" value="" />
				<input type="hidden" id="Itemfile3NameConvert" name="Itemfile3NameConvert" value="" />
				
				<button>글수정</button>
		</form>
	<#else>
		<form name="PromotionItem" action="/ja/promoitem/add" enctype="multipart/form-data"  method="post" >
			<br/>
				item Name <input type="text" id="itemName" name="itemName" /> <br/>
				Description 
				<textarea   id="itemDescription" name="itemDescription" >
				</textarea>
				<br/>
				color <input type="text" id="itemColor" name="itemColor" /> <br/>
				Price <input type="text" id="itemPrice" name="itemPrice" value="0"/> <br/>
				UOM 					<select name="itemUOM" id="itemUOM" onchange="checkUOM();">
												<option value="EACH">EACH</option>
												<option value="PCS">PCS.</option>
												<option value="DOZEN">DOZEN</option>
												<option value="BOX">BOX</option>
												<option value="CASE">CASE</option>
												<option value="BAG">BAG</option>
												<option value="SET">SET</option>
										</select>
										<div id="visibleUOM" style="display:none;">
											<input type="text" id="itemPerUnit" name="itemPerUnit" /> Pcs.
										</div>	
											<br/>
				stock <input type="text" id="itemStock" name="itemStock" />Pcs. <br/>
				picture 1 <input type="file" id="multipartFile1" name="multipartFile" /> <br/>
				picture 2 <input type="file" id="multipartFile2" name="multipartFile" /> <br/>
				picture 3 <input type="file" id="multipartFile3" name="multipartFile" /> <br/>
				Visible <input type="radio" id="itemVisible" name="itemVisible" value="Y"/>YES 
				<input type="radio" id="itemVisible" name="itemVisible" value="N" checked/>NO
				
				<br/>
				<br/>
				<br/>
				<button>글쓰기</button>
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
	
	function fucdelchk(gubun){
		switch (gubun) {
			case "1" :
				if(document.getElementById("delchk1").checked == true){
					document.getElementById("Itemfile1NameConvert").value =	document.getElementById("delchk1").value;
				}else{
					document.getElementById("Itemfile1NameConvert").value =	"";
				}
				break;
				
			case "2" :
				if(document.getElementById("delchk2").checked == true){
					document.getElementById("Itemfile2NameConvert").value =	document.getElementById("delchk2").value;
				}else{
					document.getElementById("Itemfile2NameConvert").value =	"";
				}
				break;
				
			case "3" :
				if(document.getElementById("delchk3").checked == true){
					document.getElementById("Itemfile3NameConvert").value =	document.getElementById("delchk3").value;
				}else{
					document.getElementById("Itemfile3NameConvert").value =	"";
				}
				break;
				
			default :
				break;
		}
	}
</script>
<#include "/include/footer.ftl">