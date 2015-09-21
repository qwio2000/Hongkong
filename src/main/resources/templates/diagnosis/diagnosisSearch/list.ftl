<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Announcement</h2>
	<div class="tbl01">
		<table>
			<colgroup>
				<col width="50">
				<col width="50">
				<col width="*">
				<col width="100">
				<col width="100">
				<col width="100">
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
			<tbody>
				<#list page as page1>				
					<tr>
						<td></td>
						<td>${page1.MFirstName} ${page1.MLastName}</td>
						<td>${page1.kwamok}</td>
						<td>${page1.kwamok}</td>
						<td>${page1.kwamok}</td>
						<td>${page1.kwamok}</td>
						<td>${page1.kwamok}</td>
						<td>${page1.kwamok}</td>
					</tr>
					${page1.kwamok}<br/>
					${page1.MLastName}<br/>
				</#list>
			
			</tbody>
		</table>
	</div>
	
	<div class="paging">
		<span id="pageNavi"></span>
	</div>
	
</div>


<script type="text/javascript">
$(function(){
	$("#pageNavi").html($.pageUtil(${pageUtil.pageNum},${pageUtil.totalPageCnt},${pageUtil.rowBlockSize},${pageUtil.startPageNum},${pageUtil.endPageNum}));

});
	
</script>
<!--// Main Content -->
<#include "/include/footer.ftl">
