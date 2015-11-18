<#include "/include/header.ftl">


<link rel="stylesheet" href="${cssPath }/jquery.timepicker.css" />
<script type="text/javascript" src="${jsPath }/jquery.timepicker.min.js"></script>

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Event Calendar</h2>
		<p class="path">Community &gt; Calendar &gt; Add</p>
	
		<form name="Calendar" action="/ja/community/calendaradd" method="post" >
			<ul class="list02">
				<li>
					<label for="" class="tit">Title</label>
					<input type="text" id="title" name="title" class="searchInput" style="width:384px"/>
				</li>
				<li>
					<label for="" class="tit">Date</label>
					<input type="text" class="searchInput" style="width:384px" id="start" name="start" value="${startdate}" readonly>
					To
					<input type="text" class="searchInput" style="width:384px" id="end" name="end" readonly>
				</li>
				<li>
					<label for="" class="tit">Time</label>
					<input type="text" class="searchInput" style="width:384px" id="starttime" name="starttime" >
					To
					<input type="text" class="searchInput" style="width:384px" id="endtime" name="endtime" >
				</li>
				<li>
				<label for="" class="tit">Color</label>
					<select name="color" id="color" style="width:395px; float:left;">
							<option value="#FFD9FA">Pink</option>
							<option value="#DAD9FF">purple</option>
							<option value="#D9E5FF">skyblue</option>
							<option value="#E4F7BA">green</option>
							<option value="#FAECC5">brown</option>
							<option value="#FFD8D8">red</option>
					</select>
				</li>
				<li>
					<label for="" class="tit">Description</label> 
					<span class="textarea_wrap">
						<textarea  id="itemDescription" name="itemDescription"  cols="30" rows="10" style="width:374px"></textarea>
					</span>
				</li>
			</ul>
			<div class="btnArea">
				<a href="/ja/community/calendar"><span>Cancle</span></a> <a href="#"><span>Add Event</span></a>
			</div>
		</div>
		</form>
	
</div>
<!--// Main Content -->
<script type="text/javascript">
	
$(function() {
    $( "#end" ).datepicker({
	    dateFormat: 'yy-mm-dd'
	  });
    $('#starttime').timepicker({ 'timeFormat': 'H:i:s' });
    $('#endtime').timepicker({ 'timeFormat': 'H:i:s' });
});
</script>
<#include "/include/footer.ftl">
