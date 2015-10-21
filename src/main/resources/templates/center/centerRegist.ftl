<#include "/include/header.ftl">
<!-- Main Content -->

<div class="content">
	<h2 class="conTit">Add New Center</h2>
	<ul class="list02 pt30">
	<form action="" name="centerForm" id="centerForm">
	<input type="hidden" name="deptCD" value="${deptCD?default('')}"/>	
		<li>
			<label for="" class="tit">Center Type</label>
			<select name="" id="" style="width:110px">
				<option value=""></option>
			</select>
			<select name="" id="" style="width:110px">
				<option value=""></option>
			</select>
			<select name="" id="" style="width:100px">
				<option value=""></option>
			</select>			
		</li>
		<li>
			<label for="" class="tit">Center Name</label>
			<input type="text" class="searchInput" style="width:312px" />
		</li>
		<li>
			<label for="" class="tit">Center Code</label>
			<input type="text" class="searchInput" style="width:312px" />
		</li>
		<li>
			<label for="" class="tit">Director’s First Name</label>
			<input type="text" class="searchInput" style="width:312px" />
		</li>
		<li>
			<label for="" class="tit">Director’s Last Name</label>
			<input type="text" class="searchInput" style="width:312px" />
		</li>
		<li>
			<label for="" class="tit">Address 1</label>
			<input type="text" class="searchInput" style="width:312px" />
		</li>
		<li>
			<label for="" class="tit">Zipcode</label>
			<input type="text" class="searchInput" style="width:312px" />
		</li>
		<li>
			<label for="" class="tit">City</label>
			<input type="text" class="searchInput" style="width:312px" />
		</li>
		<li>
			<label for="" class="tit">State</label>
			<select name="stateCD" id="stateCD" style="width:323px">
				<option value="">-- SELECT A STATE --</option>
				<#list centerStates as state>
					<option value="${state.stateCD }">${state.stateName }</option>
				</#list>
			</select>			
		</li>
		<li>
			<label for="" class="tit">Email Address</label>
			<input type="text" class="searchInput" style="width:312px" />
		</li>
		<li>
			<label for="" class="tit">Phone Number</label>
			<input type="text" class="searchInput" style="width:312px" />
		</li>
		<li>
			<label for="" class="tit">Fax Number</label>
			<input type="text" class="searchInput" style="width:312px" />
		</li>
		<li>
			<label for="" class="tit">Contract Date</label>
			<input type="text" class="searchInput" style="width:275px">
			<a href="#" class="btn_calendar">view calendar</a>
		</li>
		<li>
			<label for="" class="tit">Open Date</label>
			<input type="text" class="searchInput" style="width:275px">
			<a href="#" class="btn_calendar">view calendar</a>
		</li>
		<li>
			<label for="" class="tit">Royalty Charge <a href="javascript:;" onClick="$.openRoyaltyGroupInfo();" class="btn_q">?</a></label>
			<span class="radio_wrap"><input type="radio" value="y" name="rc" id="Group1" checked=""><label class="radio_label" for="Group1"> Group1</label></span>
			<span class="radio_wrap"><input type="radio" value="y" name="rc" id="Group2" checked=""><label class="radio_label" for="Group2"> Group2</label></span>
		</li>
	</ul>
	</form>
	<div class="btnArea">
		<a href="javascript:;" id="saveCenterInfo" ><span>Save Center Information</span></a>
	</div>
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">