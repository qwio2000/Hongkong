<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit" id="yymm">Register / Drop Status(${.now?string("MMMM") } ${.now?string("yyyy") })</h2>
	<div class="list02 pt20 clearfix">
		<div class="float_l">
			<select name="searchYYMM" id="searchYYMM" style="width:162px">
			<#list searchYYMM as yymm>
				<option value="${yymm }">${yymm }</option>
			</#list>
			</select>
			<span class="btnArea"><a id="searchBtn" style="cursor: pointer;"><span style="width:70px">Go</span></a></span>
		</div>
	</div>
	<div class="tbl01 tbl_w100">
		<table>
			<thead>
				<tr class="line">
					<th rowspan="2" style="width:400px" class="no_line">Center Name</th>
					<th colspan="2">KM</th>
					<th colspan="2">KK</th>
					<th colspan="2">KG</th>
					<th colspan="2">EM</th>
					<th colspan="2">EE</th>
					<th colspan="2">KP</th>
					<th colspan="2">KS</th>
					<th colspan="2">PS</th>
					<th colspan="2">ER</th>
					<th colspan="2">CP</th>
					<th colspan="2">CL</th>
					<th colspan="2">EP</th>
					<th colspan="2">TOTAL</th>
				</tr>
				<tr class="line">
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
					<th>New</th>
					<th>Drop</th>
				</tr>
			</thead>
			<tbody id="mainContent">
			</tbody>
		</table>
	</div>
</div>
<!--// Main Content -->
<script id="memberStatusTemplate" type="text/x-handlebars-template">
{{#each list}}
	<tr class="line2">
		<td class="left pl10 no_line">{{deptName}}</td>
		<td>{{isEmpty kmnew}}</td>
		<td class="font_red">{{isEmpty kmdrop}}</td>
		<td>{{isEmpty kknew}}</td>
		<td class="font_red">{{isEmpty kkdrop}}</td>
		<td>{{isEmpty kgnew}}</td>
		<td class="font_red">{{isEmpty kgdrop}}</td>
		<td>{{isEmpty emnew}}</td>
		<td class="font_red">{{isEmpty emdrop}}</td>
		<td>{{isEmpty eenew}}</td>
		<td class="font_red">{{isEmpty eedrop}}</td>
		<td>{{isEmpty kpnew}}</td>
		<td class="font_red">{{isEmpty kpdrop}}</td>
		<td>{{isEmpty ksnew}}</td>
		<td class="font_red">{{isEmpty ksdrop}}</td>
		<td>{{isEmpty psnew}}</td>
		<td class="font_red">{{isEmpty psdrop}}</td>
		<td>{{isEmpty ernew}}</td>
		<td class="font_red">{{isEmpty erdrop}}</td>
		<td>{{isEmpty cpnew}}</td>
		<td class="font_red">{{isEmpty cpdrop}}</td>
		<td>{{isEmpty clnew}}</td>
		<td class="font_red">{{isEmpty cldrop}}</td>
		<td>{{isEmpty epnew}}</td>
		<td class="font_red">{{isEmpty epdrop}}</td>
		<td class="col_gray">{{isEmpty ttnew}}</td>
		<td class="col_gray font_red">{{isEmpty ttdrop}}</td>
	</tr>
{{/each}}
	<tr class="line2 total">
		<td class="no_line">TOTAL</td>
		<td>{{total.kmnew}}</td>
		<td class="font_red">{{total.kmdrop}}</td>
		<td>{{total.kknew}}</td>
		<td class="font_red">{{total.kkdrop}}</td>
		<td>{{total.kgnew}}</td>
		<td class="font_red">{{total.kgdrop}}</td>
		<td>{{total.emnew}}</td>
		<td class="font_red">{{total.emdrop}}</td>
		<td>{{total.eenew}}</td>
		<td class="font_red">{{total.eedrop}}</td>
		<td>{{total.kpnew}}</td>
		<td class="font_red">{{total.kpdrop}}</td>
		<td>{{total.ksnew}}</td>
		<td class="font_red">{{total.ksdrop}}</td>
		<td>{{total.psnew}}</td>
		<td class="font_red">{{total.psdrop}}</td>
		<td>{{total.ernew}}</td>
		<td class="font_red">{{total.erdrop}}</td>
		<td>{{total.cpnew}}</td>
		<td class="font_red">{{total.cpdrop}}</td>
		<td>{{total.clnew}}</td>
		<td class="font_red">{{total.cldrop}}</td>
		<td>{{total.epnew}}</td>
		<td class="font_red">{{total.epdrop}}</td>
		<td class="col_gray">{{total.ttnew}}</td>
		<td class="col_gray font_red">{{total.ttdrop}}</td>
	</tr>
</script>
<#include "/include/footer.ftl">
