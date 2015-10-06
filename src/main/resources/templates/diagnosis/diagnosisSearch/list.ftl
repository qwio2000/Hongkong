<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Announcement</h2>
	
<h1 class="mgt-20"></h1>
<p>
	* 총 <strong id="totalCnt">0</strong>건
</p>
				<div class="tbl01">
					<table>
						<colgroup>
							<col width="50">
							<col width="100">
							<col width="40">
							<col width="40">
							<col width="100">
							<col width="100">
							<col width="80">
							<col width="80">
						</colgroup>
						<thead>
							<tr>
								<th></th>
								<th>Member</th>
								<th>Grade</th>
								<th>Subject</th>
								<th>Guarduan/parent</th>
								<th>Phone</th>
								<th>Status</th>
								<th>Diagnosed</th>
							</tr>
						</thead>
						<tbody id="diagnosislist">
					
						</tbody>
					</table>
				</div>
				
				<div class="paging">
					<span id="pageNavi"></span>
				</div>
	
		<INPUT TYPE="hidden" value="${page}" id="pageNum">
		<INPUT TYPE="hidden" value="${pagecnt}" id="pagecnt">
		<INPUT TYPE="hidden" value="${jisaCD}" id="jisaCD">
		<INPUT TYPE="hidden" value="${deptCd}" id="deptCd">
		<INPUT TYPE="hidden" value="${status}" id="status">
		<INPUT TYPE="hidden" value="${lastName}" id="lastName">
		<INPUT TYPE="hidden" value="${firstName}" id="firstName">
		<INPUT TYPE="hidden" value="${homePhone}" id="homePhone">
		<INPUT TYPE="hidden" value="${cellPhone}" id="cellPhone">
		<INPUT TYPE="hidden" value="${email}" id="email">
		<INPUT TYPE="hidden" value="${grade}" id="grade">
		<INPUT TYPE="hidden" value="${subject}" id="subject">

</div>


<!--// Main Content -->


<script id="listTemplate" type="text/x-handlebars-template">
	{{#each page}}
		<tr>
			<td>{{boardNo @index}}</td>
			<td>{{mfirstName}}{{mlastName}}</td>
			<td>{{grade}}</td>
			<td>{{subjname}}</td>
			<td>{{gfstName}}{{glstName}}</td>
			<td>{{ephone}}</td>
			<td>{{statusNM}}</td>
			<td>{{omrDate}}</td>
		</tr>
	{{else}}
		<tr>
			<td colspan="8">데이터가 없습니다.</td>
		</tr>
	{{/each}}
</script>


<#include "/include/footer.ftl">
