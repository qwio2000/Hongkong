<!DOCTYPE html>
<!--[if IE 7]><html lang="ko" class="ie7"><![endif]-->
<!--[if IE 8]><html lang="ko" class="ie8"><![endif]-->
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link rel="stylesheet" type="text/css" href="${cssPath }/common.css" />
	<script type="text/javascript" src="${jsPath }/common/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${jsPath }/common/ux.js"></script>
</head>
<body>
	<div class="popup" style="background-color:#fff;">
		<div class="popup_top"><h1>Event Calendar </h1> <a href="javascript:closepop()" class="btn_popup_close">close</a></div>
		<div class="popup_content">
			<div class="pop_gm">
				<div class="tbl01">
					<table>
						<colgroup>
							<col width="20" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>Name</th>
							<td>${calone.title}</td>
						</tr>
						<tr>
							<th>Date</th>
							<td><#if calone.start?exists> ${calone.start?date} </#if>  ~ <#if calone.end?exists> ${calone.end?date}</#if></td>
						</tr>
						<tr>
							<th>Time</th>
							<td><#if calone.starttime?exists>${calone.starttime  }</#if> ~ <#if calone.endtime?exists>${calone.endtime  }</#if></td>
						</tr>
						<tr>
							<th>Description</th>
							<td>${calone.description}</td>
						</tr>						
					</table>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
