<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Member Search</h2>
	<ul class="memSearch">
		<li>
			<label for="">Member Status</label>
			<select name="" id="">
				<option value="">All</option>
			</select>
		</li>
		<li>
			<label for="">Last Name</label>
			<input type="text" style="width:346px">			
		</li>
		<li>
			<label for="">First Name</label>
			<input type="text" style="width:346px">			
		</li>
		<li>
			<label for="">Home Phone</label>
			<input type="text" style="width:346px">			
		</li>
		<li>
			<label for="">Cell Phone</label>
			<input type="text" style="width:346px">			
		</li>
		<li>
			<label for="">Email</label>
			<input type="text" style="width:346px">			
		</li>
		<li>
			<label for="">Grade</label>
			<select name="" id="">
				<#list codeDtls as codeDtl>
					<option value="${codeDtl.dtlCD}">${codeDtl.dtlCDNM}</option>
				</#list>
			</select>
		</li>
		<li>
			<label for="">Subject</label>
			<select name="" id="">
				<#list codeSubject as Subject>
					<option value="${Subject.dtlCD}">${Subject.dtlCDNM}</option>
				</#list>
			</select>			
		</li>
		<li class="last">
			<label for="">Class Day</label>
			<ul class="classDay">
				<li><input type="checkbox" id="mon"/><label for="mon"><span></span>Monday</label></li>
				<li><input type="checkbox" id="tue"/><label for="tue"><span></span>Tuesday</label></li>
				<li><input type="checkbox" id="wed"/><label for="wed"><span></span>Wednesday</label></li>
				<li><input type="checkbox" id="thu"/><label for="thu"><span></span>Thursday</label></li>
				<li><input type="checkbox" id="fri"/><label for="fri"><span></span>Friaday</label></li>
				<li><input type="checkbox" id="sat"/><label for="sat"><span></span>Saturday</label></li>
			</ul>
		</li>
	</ul>
	<div class="btnArea">
		<a href=""><span>Reset</span></a>
		<a href=""><span>Search Members</span></a>
	</div>
</div>

<!--// Main Content -->
<#include "/include/footer.ftl">
