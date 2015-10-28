<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Appointment</h2>
	<div class="clearfix pb10 pt30">
		<div class="float_l">
			<div class="btnArea_txt p0"><a href="/fa/diagnosis/appointment/search" class="btn_doc m0">New Appointment</a></div>
		</div>
	</div>
	<div class="tbl01 mt0">
		<input type="hidden" id="pageNum" value="1"/>
		<input type="hidden" id="type" value="01"/>
		<table>
			<colgroup>
				<col width="30">
				<col width="130">
				<col width="50">
				<col width="70">
				<col width="*">
				<col width="100">
				<col width="140">
				<col width="150">
			</colgroup>
			<thead>
				<tr>
					<th></th>
					<th>Name</th>
					<th>Grade</th>
					<th>Subject</th>
					<th>Guardian/Parent</th>
					<th>Phone</th>
					<th>Date/Time</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody id="mainContent">
			</tbody>
		</table>
	</div>
	<div class="paging">
		<span id="pageNavi"></span>
	</div>
</div>
<!--// Main Content -->
<script id="memAppointmentTemplate" type="text/x-handlebars-template">
{{#each appointments}}
	<tr>
		<td>{{inc @index}}</td>
		<td class="left pl10"><a href="#"><img src="{{imgPath}}/ico_name.png" alt="">{{mfstName}} {{mlstName}}</a></td>
		<td>{{gradeName}}</td>
		<td>{{splitSubj subj}}</td>
		<td class="left pl10">{{gfstName}} {{glstName}}<br />{{preferredNotes}}</td>
		<td>{{gphone}}</td>
		<td>{{convPreferredYMD}} {{timeName}}</td>
		<td>
			<div class="btnArea_icon2">
				<a href="/fa/members/regist/new?type=&appIdx={{idx}}" class="btn_doc_add">입회입력</a>
				<a href="javascript:$.openPop('/fa/diagnosis/ippr?memKey={{idx}}&subj={{getSubj subj 0}}&freejindan=A', 'FilePop', 'width=1024,height=800,left=300,scrollbars=yes,resizable=yes');" class="btn_doc2">무료진단입력</a>
				<a href="javascript:updateAppointmentPop('{{idx}}')" class="btn_info">내용수정</a>
				<a href="javascript:deleteAppointment('{{idx}}');" class="btn_del">명단삭제</a>
			</div>
		</td>
	</tr>
{{else}}
	<tr>
		<td colspan="8">no search results</td>
	</tr>
{{/each}}
</script>
<#include "/include/footer.ftl">