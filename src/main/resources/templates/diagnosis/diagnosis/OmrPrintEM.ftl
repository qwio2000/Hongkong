<#include "/function/diagnosis.ftl">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>INDIVIDUAL PROGRESS PRESCRIPTION REPORT</title>
<style type="text/css">
<!--
body
{
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
    font-family:Dotum;
    color:#000000;
    font-size:12px;
}
.style1 {
    color:#000000;
	font-size: 11px;
	font-weight: bold;
}
.style2 {
    color:#000000;
	font-size: 10px;
}
.style3 {
    color:#000000;
	font-size: 10px;
	font-weight: bold;
}
.style4 {
    color:#000000;
	font-size: 12px;
	font-weight: bold;
}
.style7 {
    color:#000000;
	font-size: 11px;
    line-height:120%;
}
.style9 {color:#000000;
	font-size: 12px;
	font-weight: bold;
}
.style11 {color:#000000;
	font-size: 12px;
    line-height:130%;
}
.style12 {
    color:#000000;
	font-size: 11;
    line-height:130%;
}
.style21 {
    color:#000000;
	font-size: 11px;
    line-height:120%;
	font-weight: bold;
}
.style22 {
    color:#000000;
	font-size: 11px;
}
.style23{
	font-size:13px;
	font-face:'';
	font-weight:bold
}

img {border:0;}
.styledm {width:648px;text-align:center; border-left:1px solid #000;font:10px Dotum; border-collapse:collapse;}
.styledm caption {display:none;}
.styledm tfoot {font-weight:bold; background-color:#F5F7F9;}
.styledm th {padding:6px 0 3px 0; background-color:#99c2ff; border-top:1px solid #000; border-left:1px solid #000; border-right:1px solid #000; font:11px dotum; font-weight:bold;}

.styledm td {padding:4px 0 2px 0; border-top:1px dashed #000;border-right:1px solid #000;}
.styledm th, td.line{border-bottom:solid 1px #000;}
.styledm td.dotted_line{border-bottom:dashed 1px #d0d0d0;border-right:dashed 1px #d0d0d0;}

.styledm td em{color:#ff0000;font-weight:bold;font-style:normal;}
.styledm td.ranking {font-weight:bold;}
.styledm td.graph_line{padding:0;margin:0;text-align:left;}

/*.styledm td p.graph {width:172px;height:15px;font-size:0;background-color:#a5a5d2;float:left;}*/
.styledm td p.graph{width:105px;float:left;}
.styledm td span.blue {height:15px;background:url(${imgPath}/diagnosis/ENG/bg_blue.gif) repeat-x;font-size:0;float:left;}
.styledm td span.gray {height:13px;background-color:#999999;border:solid 1px #333;font-size:0;float:left;}
.styledm td span.num{float:right;margin-top:-15px;background-color:#fff;width:15px;height:15px;padding-left:3px}
-->
</style>
</head>

<body>
<center>
<!-- Page1 -->
<table width="648" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center" height="10"></td>
	</tr>
</table>
<table width="648" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center"><font style="font-size:17px; font-face:'';font-weight:bold">INDIVIDUAL PROGRESS PRESCRIPTION REPORT(I)</font></td>
	</tr>
	<tr>
		<td height="20" width="30%" align="left" valign="bottom" class="style4"></td>
		<td width="30%" align="left" valign="bottom" class="style4"></td>
		<td width="40%" align="right" valign="bottom" class="style4">Center : HQ</td>
	</tr>
</table>

<!-- 회원정보 -->
<table width="648" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000'>
	<tr>
		<td width="93" height="20" align="center" bgcolor="#99c2ff" class="style1">Name</td>
		<td width="79" align="center" bgcolor="#99c2ff" class="style1">Date of Birth</td>
		<td width="79" align="center" bgcolor="#99c2ff" class="style1">Grade</td>
		<td width="79" align="center" bgcolor="#99c2ff" class="style1">Member ID</td>
		<td width="79" align="center" bgcolor="#99c2ff" class="style1">Subject</td>
		<td width="79" align="center" bgcolor="#99c2ff" class="style1">Level</td>
		<td width="79" align="center" bgcolor="#99c2ff" class="style1">Test Type</td>
		<td width="79" align="center" bgcolor="#99c2ff" class="style1">Input Date</td>
	</tr>
	<tr>
		<td height="20" align="center" bgcolor="#FFFFFF" class="style1">${omrgicho.MName } </td>
		<td align="center" bgcolor="#FFFFFF" class="style1">${omrgicho.omrBirth }</td>
		<td align="center" bgcolor="#FFFFFF" class="style1">${omrgicho.omrHakNM }</td>
		<td align="center" valign="middle" bgcolor="#FFFFFF" class="style1">${omrgicho.hkey }</td>
		<td align="center" bgcolor="#FFFFFF" class="style1">Math</td>
		<td align="center" bgcolor="#FFFFFF" class="style1">${omrgicho.omrGrd }</td>
		<td align="center" bgcolor="#FFFFFF" class="style1">${omrgicho.omrKindNM }</td>
		<td align="center" bgcolor="#FFFFFF" class="style1">${omrgicho.omrDate }</td>
	</tr>
	<tr>
		<td height="20" align="center" bgcolor="#FFFFFF" class="style1">S/P</td>
		<td colspan="7" bgcolor="#FFFFFF" class="style7" style="padding:0 0 0 3">${omrgicho.sp} <#if omrgicho.spnm != ""> : ${omrgicho.spnm} </#if></td>
	</tr>
</table>

<!-- 오답내용 -->
<br>
<table width="648" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor='#ffffff'>
	<tr>
		<td colspan="3" height='20' class="style23" align="center" bgcolor="#ffffff">CONTENTS OF ERRORS</td>
	</tr>
	<tr>
		<td width="325" valign="top">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="border:1px; border-style:solid; border-color:#000000;">
			<tr>
				<td width="34" height="22" align="center" bgcolor="#99c2ff" class="style1">No.</td>
				<td width="1" bgcolor="#000000"></td>
				<td width="258" align="center" bgcolor="#99c2ff" class="style1">Objectives</td>
				<td width="1" bgcolor="#000000"></td>
				<td width="30" align="center" bgcolor="#99c2ff" class="style3">Domain</td>
			</tr>
			<tr>
				<td colspan="5" bgcolor="#000000"></td>
			</tr>

			<#assign rowLeftCnt = 0>
				<#list omrOdabLeft as omrOdabLeftIndex >
					<#assign rowLeftCnt = omrOdabLeftIndex_index+1>
					<#assign hakGubunDung = omrOdabLeftIndex.hakGubun?substring(1,omrOdabLeftIndex.hakGubun?length)>
					<#if hakGubunDung = "A" || hakGubunDung = "B">
						<#assign OdabGubunStyle = "style21">
					<#else>
						<#assign OdabGubunStyle = "style7">					
					</#if>	
					<#if omrOdabLeftIndex_index%2 = 0>
						<#assign addBG = "#FFFFFF">
					<#else>
						<#assign addBG = "#dadbdd">
					</#if>
					<tr height="${odabWidth}">
						<td align="center" bgcolor="${addBG }"><p><span class="${OdabGubunStyle}">${omrOdabLeftIndex.odab1}${omrOdabLeftIndex.odab2NM}</span></p></td>
						<td bgcolor="#000000"></td>
						<td align="" bgcolor="${addBG }" class="${OdabGubunStyle}">${omrOdabLeftIndex.odabNM}</td>
						<td bgcolor="#000000"></td>
						<td align="center" bgcolor="${addBG }" class="${OdabGubunStyle}">${omrOdabLeftIndex.hakGubun}</td>
					</tr>
				</#list>

				<#if rowLeftCnt?number lt maxOdabLine>
					<#list rowLeftCnt.. maxOdabLine as maxOdabLineIndex>
						<#if maxOdabLineIndex%2 = 0>
							<#assign addBG = "#FFFFFF">
						<#else>
							<#assign addBG = "#dadbdd">
						</#if>	
						<tr height="${odabWidth}">
							<td align="center" bgcolor="${addBG }"><p><span class="style21"></span></p></td>
							<td bgcolor="#000000"></td>
							<td align="" bgcolor="${addBG }" class="style21">&nbsp;</td>
							<td bgcolor="#000000"></td>
							<td align="center" bgcolor="${addBG }" class="style21"></td>
						</tr>
					</#list>
				</#if>

		</table>
		</td>
		<td width='1' bgcolor='#ffffff'></td>
		<td width='324' valign="top">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="border:1px; border-style:solid; border-color:#000000;">
			<tr>
				<td width="34" height="22" align="center" bgcolor="#99c2ff" class="style1">No.</td>
				<td width="1" bgcolor="#000000"></td>
				<td width="257" align="center" bgcolor="#99c2ff" class="style1">Objectives</td>
				<td width="1" bgcolor="#000000"></td>
				<td width="30" align="center" bgcolor="#99c2ff" class="style3">Domain</td>
			</tr>
			<tr>
				<td colspan="5" bgcolor="#000000"></td>
			</tr>



			<#assign rowRightCnt = 0>
				<#list omrOdabRight as omrOdabRightIndex >
					<#assign rowRightCnt = omrOdabRightIndex_index+1>
					<#assign hakGubunDung = omrOdabRightIndex.hakGubun?substring(1,omrOdabRightIndex.hakGubun?length)>
					<#if hakGubunDung = "A" || hakGubunDung = "B">
						<#assign OdabGubunStyle = "style21">
					<#else>
						<#assign OdabGubunStyle = "style7">					
					</#if>	
					<#if omrOdabRightIndex_index%2 = 0>
						<#assign addBG = "#FFFFFF">
					<#else>
						<#assign addBG = "#dadbdd">
					</#if>	
					<tr height="${odabWidth}">
						<td align="center" bgcolor="${addBG }"><p><span class="${OdabGubunStyle}">${omrOdabRightIndex.odab1}${omrOdabRightIndex.odab2NM}</span></p></td>
						<td bgcolor="#000000"></td>
						<td align="" bgcolor="${addBG }" class="${OdabGubunStyle}">&nbsp;${omrOdabRightIndex.odabNM}</td>
						<td bgcolor="#000000"></td>
						<td align="center" bgcolor="${addBG }" class="${OdabGubunStyle}">${omrOdabRightIndex.hakGubun}</td>
					</tr>
				</#list>
			
				<#if rowRightCnt?number lt maxOdabLine>
					<#list rowRightCnt.. maxOdabLine as maxOdabLineIndex>	
						<#if maxOdabLineIndex%2 = 0>
							<#assign addBG = "#FFFFFF">
						<#else>
							<#assign addBG = "#dadbdd">
						</#if>
						<tr height="${odabWidth}">
							<td align="center" bgcolor="${addBG }"><p><span class="style21"></span></p></td>
							<td bgcolor="#000000"></td>
							<td align="" bgcolor="${addBG }" class="style21">&nbsp;</td>
							<td bgcolor="#000000"></td>
							<td align="center" bgcolor="${addBG }" class="style21"></td>
						</tr>
					</#list>
				</#if>

		</table>
		</td>
	</tr>
</table>

<!-- 영역별 분석 -->
<!-- 영역명가져오기 -->
	<#assign range1 = ""><#assign range2 = ""><#assign range3 = ""><#assign range4 = ""><#assign range5 = ""><#assign range6 = "">
	<#if rangeAllGet??> 
		<#assign range1 = "(1)"+rangeAllGet.range1><#assign range2 = "(2)"+rangeAllGet.range2>
		<#assign range3 = "(3)"+rangeAllGet.range3><#assign range4 = "(4)"+rangeAllGet.range4>
		<#assign range5 = "(5)"+rangeAllGet.range5><#assign range6 = "(6)"+rangeAllGet.range6>
	</#if>
	<!-- 문항수 -->
	<#assign tot1 = 0><#assign tot2 = 0><#assign tot3 = 0><#assign tot4 = 0><#assign tot5 = 0><#assign tot6 = 0>
	<#if range??> 
		<#assign tot1 = range.tot1><#assign tot2 = range.tot2><#assign tot3 = range.tot3><#assign tot4 = range.tot4><#assign tot5 = range.tot5><#assign tot6 = range.tot6>
	</#if>
	<!-- 맞은수 -->
	<#assign r1 = 0><#assign r2 = 0><#assign r3 = 0><#assign r4 = 0><#assign r5 = 0><#assign r6 = 0>
	<#if range??> 
		<#assign r1 = range.r1><#assign r2 = range.r2><#assign r3 = range.r3><#assign r4 = range.r4><#assign r5 = range.r5><#assign r6 = range.r6>
	</#if>
	<!-- 성취율 -->
	<#assign Complet1 = 0><#assign Complet2 = 0><#assign Complet3 = 0><#assign Complet4 = 0><#assign Complet5 = 0><#assign Complet6 = 0>
	<#if range??> 
		<#if r1?number != 0><#assign Complet1 = ((r1?number/tot1?number) * 100)?int></#if>
		<#if r2?number != 0><#assign Complet2 = ((r2?number/tot2?number) * 100)?int></#if>  
		<#if r3?number != 0><#assign Complet3 = ((r3?number/tot3?number) * 100)?int></#if>  
		<#if r4?number != 0><#assign Complet4 = ((r4?number/tot4?number) * 100)?int></#if>  
		<#if r5?number != 0><#assign Complet5 = ((r5?number/tot5?number) * 100)?int></#if>  
		<#if r6?number != 0><#assign Complet6 = ((r6?number/tot6?number) * 100)?int></#if>
	</#if>
	<!-- 영역별 그래프길이 -->
	<#assign Graph1 = 0><#assign Graph2 = 0><#assign Graph3 = 0><#assign Graph4 = 0><#assign Graph5 = 0><#assign Graph6 = 0>
	<#if range??> 
		<#assign Graph1 = Complet1?number * 0.9>
		<#assign Graph2 = Complet2?number * 0.9>
		<#assign Graph3 = Complet3?number * 0.9>
		<#assign Graph4 = Complet4?number * 0.9>
		<#assign Graph5 = Complet5?number * 0.9>
		<#assign Graph6 = Complet6?number * 0.9>
	</#if>
	<!-- 총계 -->
	<#assign totAll = 0><#assign rAll = 0><#assign totComplet = 0><#assign totGraph = 0>
	<#if range??> 
		<#assign totAll = range.totAll> <!-- 전체문항수 -->
		<#assign rAll = range.RAll>		<!-- 전체맞은수 -->
		<#if rAll?number != 0><#assign totComplet = (rAll?number/totAll?number * 100)?int></#if>  	<!-- 종합성취율 -->
		<#assign totGraph = totComplet?number * 0.9>		
	</#if>	

<!-- 학습수준분석 -->
<br>
<table width="648" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor='#ffffff'>
	<tr>
		<td height='20' class="style23" align="center" bgcolor="#ffffff">ANALYSIS BY DOMAINS</td>
	</tr>
	<tr>
		<td valign="top">
			<!-- 영역별 분석 -->

			<table width="100%" cellspacing="0" class="styledm" summary="ANALYSIS BY DOMAINS">
			<caption>ANALYSIS BY DOMAINS</caption>
			<colgroup>
			<col width="144px">
			<col width="60px">
			<col width="120px">
			<col width="144px">
			<col width="60px">
			<col width="120px">
			</colgroup>
			<thead>
			 <tr>
			  <th scope="col">Learning Domain</th>
			  <th scope="col">Correct/<br>Total</th>
			  <th scope="col">Achievement(%)</th>
			  <th scope="col">Learning Domain</th>
			  <th scope="col">Correct/<br>Total</th>
			  <th scope="col">Achievement(%)</th>
			 </tr>
			</thead>
			<tbody>
				<tr>
					<td align="center">${range1}</td>
					<td>${r1}/${tot1}</td>
					<td class="graph_line" align="left">
						<p class="graph">	
							<#if (Complet1?number != 0) && (tot1?number > 4)>						
							<img src="${imgPath}/diagnosis/ENG/bg_blue.gif" height="15" border="0" align="absmiddle" width="${Graph1}">&nbsp;<span class="style12">${Complet1}</span>
							<#else>
								&nbsp;
							</#if>							
						</p>
					</td>
					<td align="center">${range4}</td>
					<td>${r4}/${tot4}</td>
					<td class="graph_line" align="left">
						<p class="graph">
							<#if (Complet4?number != 0) && (tot4?number > 4)>						
							<img src="${imgPath}/diagnosis/ENG/bg_blue.gif" height="15" border="0" align="absmiddle" width="${Graph4}">&nbsp;<span class="style12">${Complet4}</span>
							<#else>
								&nbsp;
							</#if>	
						</p>
					</td>
				</tr>
				<tr>
					<td align="center">${range2}</td>
					<td>${r2}/${tot2}</td>
					<td class="graph_line" align="left">
						<p class="graph">
							<#if (Complet2?number != 0) && (tot2?number > 4)>						
							<img src="${imgPath}/diagnosis/ENG/bg_blue.gif" height="15" border="0" align="absmiddle" width="${Graph2}">&nbsp;<span class="style12">${Complet2}</span>
							<#else>
								&nbsp;
							</#if>	
						</p>
					</td>
					<td align="center">${range5}</td>
					<td>${r5}/${tot5}</td>
					<td class="graph_line" align="left">
						<p class="graph">
							<#if (Complet5?number != 0) && (tot5?number > 4)>						
							<img src="${imgPath}/diagnosis/ENG/bg_blue.gif" height="15" border="0" align="absmiddle" width="${Graph5}">&nbsp;<span class="style12">${Complet5}</span>
							<#else>
								&nbsp;
							</#if>
						</p>
					</td>
				</tr>
				<tr>
					<td align="center">${range3}</td>
					<td>${r3}/${tot3}</td>
					<td class="graph_line" align="left">
						<p class="graph">
							<#if (Complet3?number != 0) && (tot3?number > 4)>						
							<img src="${imgPath}/diagnosis/ENG/bg_blue.gif" height="15" border="0" align="absmiddle" width="${Graph3}">&nbsp;<span class="style12">${Complet3}</span>
							<#else>
								&nbsp;
							</#if>
						</p>
					</td>
					<td class="line" align="center">${range6}</td>
					<td class="line">${r6}/${tot6}</td>
					<td class="line" align="left">
						<p class="graph">
							<#if (Complet6?number != 0) && (tot6?number > 4)>						
							<img src="${imgPath}/diagnosis/ENG/bg_blue.gif" height="15" border="0" align="absmiddle" width="${Graph6}">&nbsp;<span class="style12">${Complet6}</span>
							<#else>
								&nbsp;
							</#if>
						</p>
					</td>
				</tr>
				<tr>
					<td class="line" align="center">Total</td>
					<td class="line">${rAll}/${totAll}</td>
					<td class="graph_line line">
						<p class="graph">
						<img src="${imgPath}/diagnosis/bar_blue.gif" height="15" border="0" align="absmiddle" width="${totGraph}">&nbsp;<span class="style12">${totComplet}</span>					
						</p>
					</td>
				</tr>

			</tbody>
			</table>
		</td>
	</tr>
</table>

<!-- Page2 -->

<div style="page-break-before: always;">
   <!--[if IE 7]><br style="height:0; line-height:0"><![endif]-->
   <!--[if IE 8]><br style="height:0; line-height:0"><![endif]-->
</div>
<table width="648" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center" height="10"></td>
	</tr>
</table>
<table width="648" border="0" align="center" cellpadding="0" cellspacing="1">
	<tr>
		<td colspan="3" align="center"><font style="font-size:17px; font-face:'';font-weight:bold">INDIVIDUAL PROGRESS PRESCRIPTION REPORT(II)</font></td>
	</tr>
	<tr>
		<td width="40%" height="20" valign="bottom"></td>
		<td width="30%" align="right" valign="bottom" class="style4">Name:${omrgicho.MName }</td>
		<td width="30%" align="right" valign="bottom" class="style4">Member ID:${omrgicho.hkey }</td>
	</tr>
</table>


<table width="648" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="ffffff">
	<tr>
		<td colspan=9 height='20' class="style23" align="center" bgcolor="ffffff">ANALYSIS OF ERRORS</td>
	</tr>
</table>
<!-- 학습내용별 분석 -->
<table width="648" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="ffffff">
	<tr>
		<td bgcolor="#ffffff" colspan=7 style="color:#000000;"><span class="style4">[Analysis By Objective]</span> <span class="style12"> Identities the lacking skills and prescribes workbooks for improvement</span></td>
	</tr>
</table>
<table width="648" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="000000">
	<tr>
		<td width="498" height="20"  align="center" bgcolor="#99c2ff" class="style1">Objectives</td>
		<td width="150" height="" align="center" bgcolor="#99c2ff" class="style1">Prescribed Workbooks</td>
	</tr>
	
	<#assign odabStr = ""><#assign odabSet = ""><#assign odabGrp = ""><#assign SpaceLine = ""><#assign iDisplayCnt = 0>
	<#if odab12?? && !((omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위") >
		<#list odab12 as odab12Index>
			<#if odabGrp != odab12Index.odabGrp && odabGrp != "">
				<#if ((iDisplayCnt/2)?int * 2) = iDisplayCnt>
					<#assign addBG = "#FFFFFF">
				<#else>
					<#assign addBG = "#dadbdd">
				</#if>			
				<tr>
					<td align="" height="19" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">${odabStr}</td>
					<td align="" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">${odabSet}</td>
				</tr>
		
				${SpaceLine}
				<#assign odabStr = ""><#assign odabSet = ""><#assign odabGrp = ""><#assign iDisplayCnt = iDisplayCnt?number+1>							
			</#if>
				<#assign odabGrp = odab12Index.odabGrp>
				<#if odabStr?length = 0><#assign comstring = ""><#else><#assign comstring = ","></#if>
				<#assign odabStr = odabStr + comstring + odab12Index.odabNM>		
				<#assign odabSet = odab12Index.setList>
				<#if omrgicho.kwamok = "EM" || omrgicho.kwamok = "W">
					<#assign odabStr = odabStr + "(" + odab12Index.odab1 + UFNDisplayOdab(odab12Index.odab2) +")">
				</#if>
		</#list>
	</#if>
	
	<#if odab12?? && !((omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위") >
		<#if ((iDisplayCnt/2)?int * 2) = iDisplayCnt>
			<#assign addBG = "#FFFFFF">
		<#else>
			<#assign addBG = "#dadbdd">
		</#if>		
		<tr>
			<td align="" height="19" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">${odabStr}</td>
			<td align="" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">${odabSet}</td>
		</tr>
		${SpaceLine}
		<#assign iDisplayCnt = iDisplayCnt?number+1>
	</#if>
	
	<#if iDisplayCnt?number < 3>
		<#list iDisplayCnt+1.. 3 as iDisplayCntIndex>
			<#if iDisplayCnt?number = 1>
				<#if (omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위">
					<#assign odabStr = "Retake the diagnostic test.">
				<#else>
					<#assign odabStr = "There are no lacking skills based on the Analysis by Objective. Therefore no workbooks are prescribed.">
				</#if>
			<#else>
				<#assign odabStr = "&nbsp;">
			</#if>
			<#if ((iDisplayCntIndex?number/2)?int * 2) = iDisplayCntIndex?number>
				<#assign addBG = "#FFFFFF">
			<#else>
				<#assign addBG = "#dadbdd">
			</#if>
				<tr>
					<td align="" height="19" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">${odabStr}</td>
					<td align="" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">$nbsp;</td>
				</tr>
				${SpaceLine}
		</#list>
	</#if>
	
</table>

<!-- 오답 사례별 분석 -->
<table width="648" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="ffffff">
	<tr>
		<td bgcolor="#ffffff" colspan=7 style="color:#000000;"><span class="style4">[Analysis By Answer Selection]</span> <span class="style12">Identities the cause and rationale by analyzing the wrong answer selection</span></td>
	</tr>
</table>
<table width="648" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="000000">
	<tr>
		<td height="19" width="453" align="center" bgcolor="#99c2ff" class="style1">Comments Of Errors</td>
		<td height="" width="45" align="center" bgcolor="#99c2ff" class="style1">Type</td>
		<td height="" width="150" align="center" bgcolor="#99c2ff" class="style1">Prescribed Workbooks</td>
	</tr>

	<#assign odabStr = ""><#assign odabSet = ""><#assign odabGrp = ""><#assign odabStr2 = ""><#assign iDisplayCnt = 0>
	<#if odab4?? && !((omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위") >
		<#list odab4 as odab4Index>
			<#if odabGrp != odab4Index.scode && odabGrp != "">
				<#if ((iDisplayCnt/2)?int * 2) = iDisplayCnt>
					<#assign addBG = "#FFFFFF">
				<#else>
					<#assign addBG = "#dadbdd">
				</#if>	
				<tr>
					<td align="" height="19" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">${odabStr}(${odabStr2})</td>
					<td align="center" bgcolor="${addBG }" class="style7">${odabGrp}</td>
					<td align="" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">${odabSet}</td>
				</tr>
				${SpaceLine}
				<#assign odabStr = ""><#assign odabSet = ""><#assign odabGrp = ""><#assign odabStr2 = ""><#assign iDisplayCnt = iDisplayCnt?number+1>							
			</#if>
				<#assign odabGrp = odab4Index.scode>
				<#assign odabStr = odab4Index.odab_nm>		
				<#assign odabSet = odab4Index.setlist>
				<#if odabStr2?length = 0><#assign comstring = ""><#else><#assign comstring = ","></#if>
				<#if omrgicho.kwamok = "KM" || omrgicho.kwamok = "W">
					<#assign odabStr2 = odabStr2 + comstring + odab4Index.odab1?number + UFNDisplayOdab(odab4Index.odab2)>
				</#if>
		</#list>
	</#if>
	<#if odab4?? && !((omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위") >
		<#if ((iDisplayCnt/2)?int * 2) = iDisplayCnt>
			<#assign addBG = "#FFFFFF">
		<#else>
			<#assign addBG = "#dadbdd">
		</#if>	
		<tr>
			<td align="" height="19" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">${odabStr}(${odabStr2})</td>
			<td align="center" bgcolor="${addBG }" class="style7">${odabGrp}</td>
			<td align="" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">${odabSet}</td>
		</tr>
		${SpaceLine}
		<#assign iDisplayCnt = iDisplayCnt?number+1>
	</#if>
	
	<#if iDisplayCnt?number < 3>
		<#list iDisplayCnt+1.. 3 as iDisplayCntIndex>			
			<#if iDisplayCnt?number = 1>
				<#if (omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위">
					<#assign odabStr = "Retake the diagnostic test.">
				<#else>
					<#assign odabStr = "There are no lacking skills based on the Analysis by Answer Selection. Therefore no workbooks are prescribed.">
				</#if>
			<#else>
				<#assign odabStr = "&nbsp;">
			</#if>
			<#if ((iDisplayCntIndex?number/2)?int * 2) = iDisplayCntIndex?number>
				<#assign addBG = "#FFFFFF">
			<#else>
				<#assign addBG = "#dadbdd">
			</#if>
				<tr>
					<td align="" height="19" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">${odabStr}</td>
					<td align="center" bgcolor="${addBG }" class="style7">&nbsp;</td>
					<td align="" bgcolor="${addBG }" class="style7" style="padding:0 0 0 3">&nbsp;</td>
				</tr>
				${SpaceLine}
		</#list>
	</#if>
	
</table>

<!-- 처방프로그램 -->

<table width="648" border="0" align="center" cellpadding="0" cellspacing="0" >
	<tr>
		<td align='center' class="style23" height="20">PRESCRIPTION PROGRAM</td>
	<tr>
</table>
<table width="648" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000'>
	<tr>
		
		<td width="46" height="19" align="center" bgcolor="#99c2ff" class="style1">Week</td>
		<td width="51" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM1?substring(5,7)?number)}</td>
		<td width="50" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM2?substring(5,7)?number)}</td>
		<td width="51" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM3?substring(5,7)?number)}</td>
		<td width="50" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM4?substring(5,7)?number)}</td>
		<td width="50" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM5?substring(5,7)?number)}</td>
		<td width="50" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM6?substring(5,7)?number)}</td>
		<td width="50" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM7?substring(5,7)?number)}</td>
		<td width="50" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM8?substring(5,7)?number)}</td>
		<td width="50" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM9?substring(5,7)?number)}</td>
		<td width="50" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM10?substring(5,7)?number)}</td>
		<td width="50" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM11?substring(5,7)?number)}</td>
		<td width="50" align="center" bgcolor="#99c2ff" class="style1">${UFNDisplayMonth(startYYMM.ryYMM12?substring(5,7)?number)}</td>
	</tr>
			
	<tr>
		<td width="" height="19" align="center" bgcolor="#99c2ff" class="style1">1</td>
		<#assign jindoCnt = 0>
		<#if jindo1??>
			<#list jindo1 as jindo1Index>
				<#assign jindoCnt = jindo1Index_index+1>
				<#if jindo1Index.rset = ""><#assign rset = "&nbsp;"><#else><#assign rset = UFNDisplayJinSetE(omrgicho.kwamok,jindo1Index.rset)></#if>
				<td width="" align="center" bgcolor="#FFFFFF" class="style7">${rset}<#if omrgicho.sp?string = rset?string><font color="#FF0000">▼</font></#if></td>
			</#list>
		</#if>
		<#if jindoCnt < 12>	
			<#list jindoCnt+1.. 12 as rowIndex>
			<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
			</#list>	
		</#if>
			
	</tr>

	<tr>
		<td width="" height="19" align="center" bgcolor="#99c2ff" class="style1">2</td>
		<#assign jindoCnt = 0>
		<#if jindo2??>
			<#list jindo2 as jindo2Index>
				<#assign jindoCnt = jindo2Index_index+1>
				<#if jindo2Index.rset = ""><#assign rset = "&nbsp;"><#else><#assign rset = UFNDisplayJinSetE(omrgicho.kwamok,jindo2Index.rset)></#if>
				<td width="" align="center" bgcolor="#dadbdd" class="style7">${rset}<#if omrgicho.sp?string = rset?string><font color="#FF0000">▼</font></#if></td>
			</#list>
		</#if>
		<#if jindoCnt < 12>	
			<#list jindoCnt+1.. 12 as rowIndex>
			<td width="" align="center" bgcolor="#dadbdd" class="style7">&nbsp;</td>
			</#list>	
		</#if>
	</tr>

	<tr>
		<td width="" height="19" align="center" bgcolor="#99c2ff" class="style1">3</td>
		<#assign jindoCnt = 0>
		<#if jindo3??>
			<#list jindo3 as jindo3Index>
				<#assign jindoCnt = jindo3Index_index+1>
				<#if jindo3Index.rset = ""><#assign rset = "&nbsp;"><#else><#assign rset = UFNDisplayJinSetE(omrgicho.kwamok,jindo3Index.rset)></#if>
				<td width="" align="center" bgcolor="#FFFFFF" class="style7">${rset}<#if omrgicho.sp?string = rset?string><font color="#FF0000">▼</font></#if></td>
			</#list>
		</#if>
		<#if jindoCnt < 12>	
			<#list jindoCnt+1.. 12 as rowIndex>
			<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
			</#list>	
		</#if>
	</tr>

	<tr>
		<td width="" height="19" align="center" bgcolor="#99c2ff" class="style1">4</td>
		<#assign jindoCnt = 0>
		<#if jindo4??>
			<#list jindo4 as jindo4Index>
				<#assign jindoCnt = jindo4Index_index+1>
				<#if jindo4Index.rset = ""><#assign rset = "&nbsp;"><#else><#assign rset = UFNDisplayJinSetE(omrgicho.kwamok,jindo4Index.rset)></#if>
				<td width="" align="center" bgcolor="#dadbdd" class="style7">${rset}<#if omrgicho.sp?string = rset?string><font color="#FF0000">▼</font></#if></td>
			</#list>
		</#if>
		<#if jindoCnt < 12>	
			<#list jindoCnt+1.. 12 as rowIndex>
			<td width="" align="center" bgcolor="#dadbdd" class="style7">&nbsp;</td>
			</#list>	
		</#if>
	</tr>

	<tr>
		<td width="" height="19" align="center" bgcolor="#99c2ff" class="style1">5</td>
		<#assign jindoCnt = 0>
		<#if jindo5??>
			<#list jindo5 as jindo5Index>
				<#assign jindoCnt = jindo5Index_index+1>
				<#if jindo5Index.rset = ""><#assign rset = "&nbsp;"><#else><#assign rset = UFNDisplayJinSetE(omrgicho.kwamok,jindo5Index.rset)></#if>				
				<td width="" align="center" bgcolor="#FFFFFF" class="style7">${rset}<#if omrgicho.sp?string = rset?string><font color="#FF0000">▼</font></#if></td>
			</#list>
		</#if>
		<#if jindoCnt < 12>	
			<#list jindoCnt+1.. 12 as rowIndex>
			<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
			</#list>	
		</#if>
	</tr>

</table>

<!-- 예상진도 -->
<table width="648" border="0" align="center" cellpadding="0" cellspacing="0" >
	<tr>
		<td align='center' class="style23" height="20">PROGRESS SCHEDULE</td>
	<tr>
</table>
<table width="648" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000'>
<#assign jinMM = ""><#assign jinStr = ""><#assign idisplayCnt = 0>
	<#if next??>
		<#list next as nextIndex>
			<#if (jinMM != nextIndex.rmm) && (jinMM != "")>
				<#assign idisplayCnt = idisplayCnt?number + 1>
				<tr height=80 valign="top">
					<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>${UFNDisplayMonth(jinMM?number)}</td>
					<td width="90%" align="" bgcolor="#ffffff" class="style7">${jinStr}</td>
				</tr>
				<#if idisplayCnt?number = 3>
					<#break>
				</#if>
				<#assign jinMM = ""><#assign jinStr = "">
			</#if>
			<#assign jinMM = nextIndex.rmm>
			<#if jinStr = ""><#assign nbspNM = "&nbsp;"><#else><#assign nbspNM = "<br>&nbsp;"></#if>	
			<#if nextIndex.rset = "Z999">
				<#assign jinStr = jinStr + nbspNM +  UFNDisplayJinSet(omrgicho.kwamok, nextIndex.rset) + " : Congratulations on the completion of JEI Math">
			<#else>
				<#assign jinStr = jinStr + nbspNM +  UFNDisplayJinSet(omrgicho.kwamok, nextIndex.rset) + ":" + nextIndex.ynm>
			</#if>		
						
		</#list>
		<#if idisplayCnt?number < 3>
			<tr height=80 valign="top">
				<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>${UFNDisplayMonth(jinMM?number)}</td>
				<td width="90%" align="" bgcolor="#ffffff" class="style7">${jinStr}</td>
			</tr>
			<#assign idisplayCnt = idisplayCnt?number + 1>
		</#if>
	</#if>
	<#assign aDateTime = .now>
	<#assign aDate = aDateTime?date>	
	<#assign dateMM = aDate?iso_utc?substring(5,7)>
	<#if idisplayCnt?number < 3>
		<#if jinMM = "">
			<#assign jinMM = dateMM>
		<#else>
			<#if jinMM?number = 12>
				<#assign jinMM = "1" >
			<#else>
				<#assign jinMM = jinMM?number+1 >
			</#if>
		</#if>
		
		<#list idisplayCnt.. 2 as idisplayCntIndex>
			<#if idisplayCnt = 0>
				<#assign jinStr =  "Retake the diagnostic test.">
			<#else>
				<#assign jinStr =  "&nbsp;">
			</#if>
			<tr height=80 valign="top">
				<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>${UFNDisplayMonth(jinMM?number)}</td>
				<td width="90%" align="" bgcolor="#ffffff" class="style7">${jinStr}</td>
			</tr>
			<#if jinMM?number = 12>
				<#assign jinMM = "1" >
			<#else>
				<#assign jinMM = jinMM?number+1 >
			</#if>
		</#list>
		
	</#if>

</table>
</center>
</body>
</html>