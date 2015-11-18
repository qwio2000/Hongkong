<#include "/include/header.ftl">

<link rel="stylesheet" href="${cssPath }/fullcalendar.css" />
<script type="text/javascript" src="${jsPath }/common/moment.min.js"></script>
<script type="text/javascript" src="${jsPath }/common/fullcalendar.min.js"></script>

<#-- Create constructor object -->
<#assign objectConstructor = "freemarker.template.utility.ObjectConstructor"?new()>
<#-- Call calendar constructor -->
<#assign clock = objectConstructor("java.util.GregorianCalendar")>
<#-- Call formatter constructor -->
<#assign mmddyy = objectConstructor("java.text.SimpleDateFormat","yyyy")>
<#-- Call getTime method to return the date in milliseconds-->
<#assign date = clock.getTime()>
<#-- Call format method to pretty print the date -->
<#assign now = mmddyy.format(date)>
<#setting number_format="0000">
<#assign now = now?number>


<!-- Main Content -->
<div class="content">


		
	<h2 class="conTit">Event Calender</h2>
		
	<div style="width:100%; height:35px; margin:10px 0 0 0;">
		<select name="month" id="month" value="" onchange="godate()" style="width:140px; height:30px; float:left;">
				<option value="01">January</option>
				<option value="02">February</option>
				<option value="03">March</option>
				<option value="04">April</option>
				<option value="05">May</option>
				<option value="06">June</option>
				<option value="07">July</option>
				<option value="08">August</option>
				<option value="09">September</option>
				<option value="10">October</option>
				<option value="11">November</option>
				<option value="12">December</option>
		</select>
		
		<select name="year" id="year" value="" onchange="godate()" style="width:140px; height:30px; float:left;">
			<#list  now-10..now+10  as yy > 
				<option value="${yy}" <#if (yy == now) > selected </#if> >${yy}</option>
				<#assign yy=yy+1?int>	
			</#list>
		</select>
		
		<button type="button" onclick="gotoday()">today</button>
	</div>
	
	

	<div id="showDetail" style="position:absolute; z-index:1000; left:20%; top:20%;"></div>
	
	<!-- event calender -->
	<div class="event_calender">
		
		
		<div class="fc fc-ltr fc-unthemed" id="calendar">
		</div>
		<script type="text/javascript">
		

		var today = new Date();
		var year = today.getFullYear();
		var month = today.getMonth();
  	  
		function godate(){
		 	$('#calendar').fullCalendar( 'gotoDate', document.getElementById("year").value + '-' + document.getElementById("month").value );
		}
		
		function gotoday(){
			$('#calendar').fullCalendar( 'today' );
			document.getElementById("year").value = year;
			document.getElementById("month").value = month+1;
		}

			$(document).ready(function() {
			
			var json_str = '${callist}' ;
			var jsondata = eval("(" + json_str + ")");
			
			document.getElementById("year").value = year;
			document.getElementById("month").value = month+1;
			
				$('#calendar').fullCalendar({
					header: {
						left: 'prev', //prev,next today
						center: 'title',
						right: 'next' //'month,basicWeek,basicDay'
					},
					editable: true,
					eventLimit: true,
					events: jsondata
					,dayClick: function(date, jsEvent, view) {
				        console.log(date.format());
				        location.href="/ja/community/calendarwrite?startdate=" + date.format();
				    }
				    ,eventClick: function(calEvent, jsEvent, view) {
				        //console.log('Event: ' + calEvent.aidx);
				          $.ajax({
						  method: "POST",
						  url: "/ja/community/calendardetail",
						  data:	{"aidx": calEvent.aidx} ,
						  success:function(data){   
					            $("#showDetail").html(data);
					            document.getElementById("showDetail").style.display = "";
					        }
						});
				    }
					
				});
				
			});
	
				
				function closepop(){
					document.getElementById("showDetail").style.display = "none";
					$("#showDetail").html("");
				}
				
		</script>
	</div>
	<!-- //event calender -->
	
</div>
<!--// Main Content -->

<#include "/include/footer.ftl">
