<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<div class="clearfix">
		<!-- current_month -->
		<div class="last_month">
			<h2 class="conTit"><#if loginInfo.userType == "JA" >By Subject<#else>Current Month</#if></h2>
			<div class="tbl01" style="width:456px">
				<table>
					<colgroup>
						<col style="width:127px">
						<col style="width:80px">
						<col style="width:80px">
						<col style="width:90px">
						<col style="width:80px">
					</colgroup>
					<thead>
						<tr>
							<th class="left">Subject</th>
							<th>Begin</th>
							<th>Register</th>
							<th>Drop</th>
							<th style="padding-right:20px">Current</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="5" class="p0">
								<ul class="month_list">
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
																																				<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
																		
								</ul>
							</td>
						</tr>
						<tr class="total">
							<td class="left">TOTAL</td>
							<td>42</td>
							<td>1</td>
							<td>1</td>
							<td>42</td>
						</tr>						
					</tbody>
				</table>
			</div>
		</div>		
		<!-- //current_month -->
		<#if loginInfo.userType == "JA" >
		<!-- By Center -->
		<div class="last_month">
			<h2 class="conTit">By Center</h2>
			<div class="tbl01" style="width:456px">
				<table>
					<colgroup>
						<col style="width:27px">
						<col style="width:100px">
						<col style="width:80px">
						<col style="width:80px">
						<col style="width:90px">
						<col style="width:80px">
					</colgroup>
					<thead>
						<tr>
							<th class="left">State</th>
							<th class="left">Center</th>
							<th>Begin</th>
							<th>Register</th>
							<th>Drop</th>
							<th style="padding-right:20px">Current</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="6" class="p0">
								<ul class="month_list">
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
																																				<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
																		
								</ul>
							</td>
						</tr>
						<tr class="total">
							<td class="left">TOTAL</td>
							<td>42</td>
							<td>42</td>
							<td>1</td>
							<td>1</td>
							<td>42</td>
						</tr>						
					</tbody>
				</table>
			</div>
		</div>
		<!-- //By Center -->
		</#if>
		<#if loginInfo.userType == "FA" >
		<!-- 가맹점 Last 6 Months -->
		<div class="last_month">
			<h2 class="conTit">Last 6 Months</h2>
			<div class="tbl01" style="width:456px">
				<table>
					<colgroup>
						<col style="width:127px">
						<col style="width:80px">
						<col style="width:80px">
						<col style="width:90px">
						<col style="width:80px">
						<col style="width:80px">
						<col style="width:80px">
					</colgroup>
					<thead>
						<tr>
							<th class="left">Subject</th>
							<th>Apr</th>
							<th>May</th>
							<th>Jun</th>
							<th>Jul</th>
							<th>Aug</th>
							<th style="padding-right:20px">Sep</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="7" class="p0">
								<ul class="month_list">
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">ENGLISH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">READING</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">PS MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">BRAIN SAFARI</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
									<li>
										<span class="col subject">MATH</span>
										<span class="col">23</span>
										<span class="col">0</span>
										<span class="col">1</span>
										<span class="col">22</span>
									</li>
								</ul>
							</td>
						</tr>
						<tr class="total">
							<td class="left">TOTAL</td>
							<td>42</td>
							<td>1</td>
							<td>1</td>
							<td>42</td>
							<td>42</td>
							<td>42</td>
						</tr>									
					</tbody>
				</table>
			</div>
		</div>
		<!-- //Last 6 Months -->
		</#if>

				
	</div>
	<!-- Amnouncement -->
	<div class="amnounce all">
		<h2 class="conTit">Amnouncement</h2>
		<div class="list01">
			<ul class="clear">
				<li><a href="#"><span class="title">· JKL Online Traning, L & M file and new Workbooks &nbsp;<img src="${imgPath }/icon_new.png" alt="new" /></span><span class="date">07/30/2014</span></a></li>
				<li><a href="#"><span class="title">· JKL Online Traning, L & M file and new Workbooks &nbsp;<img src="${imgPath }/icon_new.png" alt="new" /></span><span class="date">07/30/2014</span></a></li>
				<li><a href="#"><span class="title">· JKL Online Traning, L & M file and new Workbooks &nbsp;<img src="${imgPath }/icon_new.png" alt="new" /></span><span class="date">07/30/2014</span></a></li>
				<li><a href="#"><span class="title">· JKL Online Traning, L & M file and new Workbooks</span><span class="date">07/30/2014</span></a></li>
				<li><a href="#"><span class="title">· JKL Online Traning, L & M file and new Workbooks</span><span class="date">07/30/2014</span></a></li>
				<li><a href="#"><span class="title">· JKL Online Traning, L & M file and new Workbooks</span><span class="date">07/30/2014</span></a></li>
				<li><a href="#"><span class="title">· JKL Online Traning, L & M file and new Workbooks</span><span class="date">07/30/2014</span></a></li>
			</ul>
		</div>
	</div>
	<!-- //Amnouncement -->
	<!-- event calender -->
	<div class="event_calender">
		<link rel="stylesheet" href="${cssPath }/fullcalendar.css" />
		<script type="text/javascript" src="${jsPath }/common/moment.min.js"></script>
		<script type="text/javascript" src="${jsPath }/common/fullcalendar.min.js"></script>		
		<h2 class="conTit">Event Calender</h2>
		<div class="fc fc-ltr fc-unthemed" id="calendar">
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#calendar').fullCalendar({
					header: {
						left: 'prev', //prev,next today
						center: 'title',
						right: 'next' //'month,basicWeek,basicDay'
					},
					defaultDate: '2015-02-24',
					editable: true,
					eventLimit: true, // allow "more" link when too many events
					events: [
						{
							title: 'All Day Event',
							start: '2015-09-20'
						},
						{
							title: 'Long Event',
							start: '2015-09-25',
							end: '2015-09-30'
						},
						{
							id: 999,
							title: 'Repeating Event',
							start: '2015-09-25T16:00:00',
							end: '2015-09-30T16:00:00',
							color: '#257e4a'
						},
						{
							id: 999,
							title: 'Repeating Event',
							start: '2015-02-16T16:00:00'
						},
						{
							title: 'Conference',
							start: '2015-02-11',
							end: '2015-02-13'
						},
						{
							title: 'Meeting',
							start: '2015-02-12T10:30:00',
							end: '2015-02-12T12:30:00',
							color: '#257e4a'
						},
						{
							title: 'Lunch',
							start: '2015-02-12T12:00:00'
						},
						{
							title: 'Meeting',
							start: '2015-02-12T14:30:00'
						},
						{
							title: 'Happy Hour',
							start: '2015-02-12T17:30:00'
						},
						{
							title: 'Dinner',
							start: '2015-02-12T20:00:00'
						},
						{
							title: 'Birthday Party',
							start: '2015-02-13T07:00:00'
						},
						{
							title: 'Click for Google',
							url: 'http://google.com/',
							start: '2015-02-28'
						}
					]
				});
				//메인팝업
				var idx = '${idxs?default("")}';
				if(idx != ''){
					popupOpen(idx);
				}
			});
			function popupOpen(idx){
				function getCookie(name){
					var nameOfCookie = name + "=";
					var x = 0;
					while (x <= document.cookie.length){
						var y = (x + nameOfCookie.length);
						if (document.cookie.substring(x, y) == nameOfCookie){
						if ((endOfCookie = document.cookie.indexOf(";", y)) == -1){
						endOfCookie = document.cookie.length;
						}
						return unescape (document.cookie.substring(y, endOfCookie));
						}
						x = document.cookie.indexOf (" ", x) + 1;
						if (x == 0) break;
					}
					return "";
				}
				if (getCookie("mainPop") != "done"){
					$.openPop('/fa/popupMsg?idxs='+idx, 'mainPop', 'width=625,height=450,scrollbars=yes,resizable=no');
				}
			}
		</script>
	</div>
	<!-- //event calender -->
</div>
<!--// Main Content -->
<#include "/include/footer.ftl">