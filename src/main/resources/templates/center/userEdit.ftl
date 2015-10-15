<#include "/include/popupheader.ftl">
<!-- Main Content -->

<div class="popup">
	<div class="popup_top"><h1>Edit User</h1> <a href="javascript:self.close();" class="btn_popup_close">close</a></div>
	<div class="popup_content">
		<div class="pop_jisa">
			<ul class="list02">
				<li>
					<label for="" class="tit">Center Name</label>
					<strong>Auburndale-Whtestone</strong>
				</li>
				<li>
					<label for="" class="tit">User Privilege</label>
					<select name="" id="" style="width:187px;margin-right:3px">
						<option value="">Instructor</option>
					</select>
				</li>
				<li>
					<label for="" class="tit">User's First Name</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">User's Last Name</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Email Address</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Phone</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Cell Phone</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Title</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Department</label>
					<input type="text" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Password</label>
					<input type="password" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Retype Password</label>
					<input type="password" class="searchInput" style="width:384px">
				</li>
				<li>
					<label for="" class="tit">Status</label>
					<span class="radio_wrap"><input type="radio" value="y" name="Status" id="Active" checked=""><label class="radio_label" for="Active"> Active</label></span>
					<span class="radio_wrap"><input type="radio" value="y" name="Status" id="Inactive" checked=""><label class="radio_label" for="Inactive"> Inactive</label></span>
				</li>
			</ul>
			<div class="btnArea">
				<a href="#"><span>Save User Information</span></a>
			</div>
		</div>
	</div>
</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">