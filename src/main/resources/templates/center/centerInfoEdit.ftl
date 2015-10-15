<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="popup">
	<div class="popup_top"><h1>Update Enter Information</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_jisa">
			<ul class="list02">
				<li>
					<label for="" class="tit">Center Type</label>
					<select name="" id="" style="width:396px">
						<option value="">CENTER</option>
					</select>
				</li>
				<li>
					<label for="" class="tit">Center Code</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Center Name</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Director’s First Name</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Director’s Last Name</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Address 1</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Address 2</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">City</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">State / Zipcode</label>
					<select name="" id="" style="width:187px;margin-right:3px">
						<option value="">New Jersey</option>
					</select>
					<input type="text" class="searchInput" style="width:190px">
				</li>
				<li>
					<label for="" class="tit">Email Address</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Phone Number</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Fax Number</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Contract Date</label>
					<input type="text" class="searchInput" style="width:348px">
					<a href="#" class="btn_calendar">view calendar</a>
				</li>
				<li>
					<label for="" class="tit">Open Date</label>
					<input type="text" class="searchInput" style="width:348px">
					<a href="#" class="btn_calendar">view calendar</a>
				</li>
				<li>
					<label for="" class="tit">Status</label>
					<span class="radio_wrap"><input type="radio" value="y" name="Status" id="Active" checked=""><label class="radio_label" for="Active"> Active</label></span>
					<span class="radio_wrap"><input type="radio" value="y" name="Status" id="Inactive" checked=""><label class="radio_label" for="Inactive"> Inactive</label></span>
				</li>
				<li>
					<label for="" class="tit">Royalty Charge</label>
					<span class="radio_wrap"><input type="radio" value="y" name="rc" id="Group1" checked=""><label class="radio_label" for="Group1"> Group1</label></span>
					<span class="radio_wrap"><input type="radio" value="y" name="rc" id="Group2" checked=""><label class="radio_label" for="Group2"> Group2</label></span>
				</li>
			</ul>
			<div class="btnArea">
				<a href="#"><span>Save Center Information</span></a>
			</div>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">