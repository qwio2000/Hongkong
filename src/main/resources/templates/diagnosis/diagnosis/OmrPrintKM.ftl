<#include "/function/diagnosis.ftl">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>개인별진단처방기록부</title>
	<link rel="stylesheet" type="text/css" href="${cssPath }/jquery-ui.1.11.4.min.css" />
	<#if headerCss?has_content>
	<#list headerCss as css>
		<link rel="stylesheet" type="text/css" href="${cssPath }/${css}.css" />
	</#list>
	</#if>
	<script type="text/javascript" src="${jsPath }/common/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${jsPath }/common/handlebars-3.0.3-min.js"></script>
	<script type="text/javascript" src="${jsPath }/common/common.js"></script>
	<script type="text/javascript" src="${jsPath }/common/ux.js"></script>
	<script type="text/javascript" src="${jsPath }/common/jquery-ui.1.11.4.min.js"></script>
	<#if headerScript?has_content>
		<#list headerScript as script>
			<script type="text/javascript" src="${jsPath }/${script}.js"></script>
		</#list>
	</#if>
		
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
	.style4 {
	    color:#000000;
		font-size: 12px;
		font-weight: bold;
	}
	.style7 {
	    color:#000000;
		font-size: 12px;
	    line-height:130%;
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
		font-size: 12px;
	    line-height:130%;
		font-weight: bold;
	}
	.style22 {
	    color:#000000;
		font-size: 11px;
		font-weight: bold;
	}
	
	.style23{
		font-size:15px;
		font-face:'';
		font-weight:bold
	}
	
	}
	-->
	</style>
</head>
<PAPER orientation="Portrait" n_up="1" size="A4">
<PAGE Margintop="13" Marginleft="10" Marginbottom="20" Marginright="10">

	<prnoff>
	<Footer1 margin="5mm">
		<!--
			<table width="696" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr><td height="5" align="center" valign="bottom"></td></tr>
				<tr><td align="center" valign="bottom"><img src="./HakSys/img/title_footer.gif"/> </td></tr>
			</table>
		-->
	</Footer>
	</prnoff>
<body>
<center>
<table width="696" border="0" align="center" cellpadding="0" cellspacing="0">
<!-- Page1 -->
	<tr>
		<td colspan="2" align="center"><font style="font-size:18px; font-face:'';font-weight:bold">개인별진단처방기록부(I)</font></td>	
	</tr>
	<tr>
		<td width="60%" height="50" valign="bottom"><img src="${imgPath}/diagnosis/title_sub_1.gif"/></td>
		<td width="40%" align="right" valign="bottom" class="style4">담당:</td>
	</tr>
</table>



<!-- 회원정보 -->
<table width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000'>
	<#if omrgicho??>
	<tr>
		<td width="87" height="22" align="center" bgcolor="c7c8ca" class="style4">1.회원번호</td>
		<td width="87" align="center" bgcolor="#FFFFFF" class="style7">${omrgicho.hkey}</td>
		<td width="87" align="center" bgcolor="c7c8ca" class="style4">4.생년월일</td>
		<td width="87" align="center" bgcolor="#FFFFFF" class="style7">${omrgicho.omrBirth}</td>
		<td width="87" align="center" bgcolor="c7c8ca" class="style4">7.평가종류</td>
		<td width="87" align="center" bgcolor="#FFFFFF" class="style7">${omrgicho.omrKindNM}</td>
		<td width="87" align="center" bgcolor="c7c8ca" class="style4">10.관리요일</td>
		<td width="87" align="center" bgcolor="#FFFFFF" class="style7">${omrgicho.omrYoil} (${omrgicho.omrYoilNM})</td>
	</tr>
	<tr>
		<td height="22" align="center" bgcolor="c7c8ca" class="style4">2.성&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;명</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">${omrgicho.MName} </td>
		<td align="center" valign="middle" bgcolor="c7c8ca" class="style4">5.실시일자</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">${omrgicho.omrDate}</td>
		<td align="center" bgcolor="c7c8ca" class="style4">8.선&nbsp;생&nbsp;님</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">${omrgicho.sname}</td>
		<td align="center" bgcolor="c7c8ca" class="style4">11.등&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;급</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">${omrgicho.omrGrd}</td>
	</tr>
	<tr>
		<td height="22" align="center" bgcolor="c7c8ca" class="style4">3.학&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;년</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">${omrgicho.omrHakNM}</td>
		<td align="center" bgcolor="c7c8ca" class="style4">6.처리일자</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">${omrgicho.regDate}</td>
		<td align="center" bgcolor="c7c8ca" class="style4">9.교&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;실</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td bgcolor="c7c8ca" class="style7">&nbsp;</td>
		<td bgcolor="#FFFFFF" class="style7">&nbsp;</td>
	</tr>
	<tr>
		<td height="38" align="center" bgcolor="c7c8ca" class="style4">12.S&nbsp;/&nbsp;P&nbsp;&nbsp;&nbsp;</td>
		<td colspan="7" valign="top" bgcolor="#FFFFFF" class="style7">
		${omrgicho.sp} <#if omrgicho.spnm != ""> : ${omrgicho.spnm} </#if>
		</td>
	</tr>
	</#if>
</table>
<!-- 오답내용 -->
<table width="696" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor='#ffffff'>
	<tr>
		<td colspan=3 height='22' class="style23" align="center" bgcolor="#ffffff">오답 내용</td>
	</tr>
	<tr>
		<td width="346" valign="top">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="border:1px; border-style:solid; border-color:#000000;">
			<tr>
				<td width="34" height="22" align="center" bgcolor="c7c8ca" class="style4">번호</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="e3e4e6" class="style4">학습목표</td>
				<td width="1" bgcolor="#000000"></td>
				<td width="26" align="center" bgcolor="e3e4e6" class="style4">영역</td>			
			</tr>
			<tr>
				<td colspan="7" bgcolor="#000000"></td>
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
					
					<tr height="${odabWidth}">
						<td align="center" bgcolor="dadbdd"><p><span class="${OdabGubunStyle}">${omrOdabLeftIndex.odab1}${omrOdabLeftIndex.odab2NM}</span></p></td>
						<td bgcolor="#000000"></td>
						<td align="" bgcolor="#FFFFFF" class="${OdabGubunStyle}">&nbsp;${omrOdabLeftIndex.odabNM}</td>
						<td bgcolor="#000000"></td>
						<td align="center" bgcolor="#FFFFFF" class="${OdabGubunStyle}">${omrOdabLeftIndex.hakGubun}</td>
				
					</tr>
				</#list>
			
				<#if rowLeftCnt?number lt maxOdabLine>
					<#list rowLeftCnt.. maxOdabLine as maxOdabLineIndex>	
						<tr height="${odabWidth}">
							<td align="center" bgcolor="dadbdd"><p><span class="style21"></span></p></td>
							<td bgcolor="#000000"></td>
							<td align="" bgcolor="#FFFFFF" class="style21">&nbsp;</td>
							<td bgcolor="#000000"></td>
							<td align="center" bgcolor="#FFFFFF" class="style21"></td>
						</tr>
					</#list>
				</#if>

		</table></td>
		<td width='4' bgcolor='#ffffff'>&nbsp;</td>
		<td width='346' valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" style="border:1px; border-style:solid; border-color:#000000;">
			<tr>
				<td width="34" height="22" align="center" bgcolor="c7c8ca" class="style4">번호</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="e3e4e6" class="style4">학습목표</td>
				<td width="1" bgcolor="#000000"></td>
				<td width="26" align="center" bgcolor="e3e4e6" class="style4">영역</td>
			</tr>
			<tr>
				<td colspan="7" bgcolor="#000000"></td>
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
					<tr height="${odabWidth}">
						<td align="center" bgcolor="dadbdd"><p><span class="${OdabGubunStyle}">${omrOdabRightIndex.odab1}${omrOdabRightIndex.odab2NM}</span></p></td>
						<td bgcolor="#000000"></td>
						<td align="" bgcolor="#FFFFFF" class="${OdabGubunStyle}">&nbsp;${omrOdabRightIndex.odabNM}</td>
						<td bgcolor="#000000"></td>
						<td align="center" bgcolor="#FFFFFF" class="${OdabGubunStyle}">${omrOdabRightIndex.hakGubun}</td>
					</tr>
				</#list>
			
				<#if rowRightCnt?number lt maxOdabLine>
					<#list rowRightCnt.. maxOdabLine as maxOdabLineIndex>	
						<tr height="${odabWidth}">
							<td align="center" bgcolor="dadbdd"><p><span class="style21"></span></p></td>
							<td bgcolor="#000000"></td>
							<td align="" bgcolor="#FFFFFF" class="style21">&nbsp;</td>
							<td bgcolor="#000000"></td>
							<td align="center" bgcolor="#FFFFFF" class="style21"></td>
						</tr>
					</#list>
				</#if>
			

		</table></td>
	</tr>
</table>

<!-- 영역별 분석 -->
	<!-- 영역명가져오기 -->
	<#assign range1 = ""><#assign range2 = ""><#assign range3 = ""><#assign range4 = ""><#assign range5 = "">
	<#if rangeAllGet??> 
		<#assign range1 = "(1)"+rangeAllGet.range1><#assign range2 = "(2)"+rangeAllGet.range2>
		<#assign range3 = "(3)"+rangeAllGet.range3><#assign range4 = "(4)"+rangeAllGet.range4>
		<#assign range5 = "(5)"+rangeAllGet.range5>
	</#if>
	<!-- 문항수 -->
	<#assign tot1 = 0><#assign tot2 = 0><#assign tot3 = 0><#assign tot4 = 0><#assign tot5 = 0>
	<#if range??> 
		<#assign tot1 = range.tot1><#assign tot2 = range.tot2><#assign tot3 = range.tot3><#assign tot4 = range.tot4><#assign tot5 = range.tot5>
	</#if>
	<!-- 맞은수 -->
	<#assign r1 = 0><#assign r2 = 0><#assign r3 = 0><#assign r4 = 0><#assign r5 = 0>
	<#if range??> 
		<#assign r1 = range.r1><#assign r2 = range.r2><#assign r3 = range.r3><#assign r4 = range.r4><#assign r5 = range.r5>
	</#if>
	<!-- 성취율 -->
	<#assign Complet1 = 0><#assign Complet2 = 0><#assign Complet3 = 0><#assign Complet4 = 0><#assign Complet5 = 0>
		<#if range??> 
		<#if r1?number != 0><#assign Complet1 = ((r1?number/tot1?number) * 100)?int></#if>
		<#if r2?number != 0><#assign Complet2 = ((r2?number/tot2?number) * 100)?int></#if>  
		<#if r3?number != 0><#assign Complet3 = ((r3?number/tot3?number) * 100)?int></#if>  
		<#if r4?number != 0><#assign Complet4 = ((r4?number/tot4?number) * 100)?int></#if>  
		<#if r5?number != 0><#assign Complet5 = ((r5?number/tot5?number) * 100)?int></#if>  
	</#if>
	<!-- 영역별 그래프길이 -->
	<#assign Graph1 = 0><#assign Graph2 = 0><#assign Graph3 = 0><#assign Graph4 = 0><#assign Graph5 = 0>
	<#if range??> 
		<#assign Graph1 = Complet1?number * 1.8>
		<#assign Graph2 = Complet2?number * 1.8>
		<#assign Graph3 = Complet3?number * 1.8>
		<#assign Graph4 = Complet4?number * 1.8>
		<#assign Graph5 = Complet5?number * 1.8>
	</#if>
	<!-- 총계 -->
	<#assign totAll = 0><#assign rAll = 0><#assign totComplet = 0><#assign totGraph = 0>
	<#if range??> 
		<#assign totAll = range.totAll> <!-- 전체문항수 -->
		<#assign rAll = range.RAll>		<!-- 전체맞은수 -->
		<#if rAll?number != 0><#assign totComplet = (rAll?number/totAll?number * 100)?int></#if>  	<!-- 종합성취율 -->	
		<#assign totGraph = totComplet?number * 1.8>		
	</#if>	

<table width="696" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor='#ffffff'>
	<tr>
		<td colspan='3' height='22' class="style23" align="center" bgcolor="#ffffff">영역별 분석</td>
	</tr>
	<tr>
		<td width='3' bgcolor="#FFFFFF"></td>
		<td>
			<table width="690" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
				<tr>
					<td width='85' height="35" align="center" bgcolor="c7c8ca" class="style4">영역</td>
					<td width="50" align="center" bgcolor="dfe0e2" class="style4">맞은수/<br>문항수</td>
					<td width="205" align="center" bgcolor="dfe0e2" class="style4">
						<table width="100%" cellpadding="0" cellspacing="0">
							<tr><td align="center" class="style4">성취도(%)</td></tr>
							<tr><td><img src="${imgPath}/diagnosis/bg_number.gif" width="100%" border="0"></td></tr>
						</table>
					</td>
					<td width='85' align="center" bgcolor="c7c8ca" class="style4">영역</td>
					<td width="50" align="center" bgcolor="dfe0e2" class="style4">맞은수/<br>문항수</td>
					<td width="205" align="center" bgcolor="dfe0e2" class="style4">
						<table width="100%" cellpadding="0" cellspacing="0">
							<tr><td align="center" class="style4">성취도(%)</td></tr>
							<tr><td><img src="${imgPath}/diagnosis/bg_number.gif" width="100%" border="0"></td></tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="35" align="center" bgcolor="dfe0e2" class="style7">${range1}</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">${r1}/${tot1}</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">
							<#if Complet1?number != 0>						
							<img src="${imgPath}/diagnosis/bar_red.gif" height="15" border="0" align="absmiddle" width="${Graph1}">&nbsp;<span class="style12">${Complet1}</span>
							<#else>
								&nbsp;
							</#if>
							
					</td>						
					<td align="center" bgcolor="dfe0e2" class="style7">${range4}</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">${r4}/${tot4}</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">	
							<#if Complet4?number != 0>								
							<img src="${imgPath}/diagnosis/bar_red.gif" height="15" border="0" align="absmiddle" width="${Graph4}">&nbsp;<span class="style12">${Complet4}</span>
							<#else>
								&nbsp;
							</#if>					
					</td>
				</tr>
				<tr>
					<td height="35" align="center" bgcolor="dfe0e2" class="style7">${range2}</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">${r2}/${tot2}</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">	
							<#if Complet2?number != 0>					
							<img src="${imgPath}/diagnosis/bar_red.gif" height="15" border="0" align="absmiddle" width="${Graph2}">&nbsp;<span class="style12">${Complet2}</span>
							<#else>
								&nbsp;
							</#if>			
					</td>
					<td align="center" bgcolor="dfe0e2" class="style7">${range5}</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">${r5}/${tot5}</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">
							<#if Complet5?number != 0>							
							<img src="${imgPath}/diagnosis/bar_red.gif" height="15" border="0" align="absmiddle" width="${Graph5}">&nbsp;<span class="style12">${Complet5}</span>
							<#else>
								&nbsp;
							</#if>				
					</td>
				</tr>
				<tr>
					<td height="35" align="center" bgcolor="dfe0e2" class="style7">${range3}</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">${r3}/${tot3}</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">
							<#if Complet3?number != 0>						
							<img src="${imgPath}/diagnosis/bar_red.gif" height="15" border="0" align="absmiddle" width="${Graph3}">&nbsp;<span class="style12">${Complet3}</span>
							<#else>
								&nbsp;
							</#if>				
					</td>
					<td align="center" bgcolor="dfe0e2" class="style7">총계</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">${rAll}/${totAll}</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">
						<#if totComplet?number != 0>		
						<img src="${imgPath}/diagnosis/bar_blue.gif" height="15" border="0" align="absmiddle" width="${totGraph}">&nbsp;<span class="style12">${totComplet}</span>
						<#else>
							&nbsp;
						</#if>
					</td>
				</tr>
			</table>
		</td>
		<td width='3' bgcolor="#FFFFFF"></td>
	</tr>
</table>
<br>
<br>
<!-- Page2 -->
<table width="696" border="0" align="center" cellpadding="0" cellspacing="1"  style='page-break-before:always' table Celloptimize="None">
	<tr>
		<td height="5" colspan="2"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><font style="font-size:18px; font-face:'';font-weight:bold">개인별진단처방기록부(II)</font></td>
		<!--<td colspan="2" align="center"><img src="./HakSys/img/title_2.gif"/></td>-->
	</tr>
	<tr>
		<td width="60%" height="50" valign="bottom"><img src="${imgPath}/diagnosis/title_sub_1.gif"/></td>
		<td width="40%" align="right" valign="bottom" class="style4">회원번호:AA281519</td>
	</tr>
</table>


<table Celloptimize="vertical" width="696" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="ffffff">
	<tr>
		<td colspan=9 height='22' class="style23" align="center" bgcolor="ffffff">오답 내용 분석<!--<img src="./HakSys/img/title_odab_bunsuk.gif">--></td>
	</tr>
</table>
<!-- 학습내용별 분석 -->
<table Celloptimize="vertical" width="696" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="ffffff">
	<tr>
		<td bgcolor="#ffffff" colspan=7 style="color:#000000;"><span class="style4">[학습내용별 분석]</span> <span class="style12">평가 문항을 연관된 학습내용별로 구분하여 각 내용별 결손이 생긴 것에 대해 보충해야 할 세트를 제시하였습니다.</span></td>
	</tr>
</table>

<table Celloptimize="vertical" width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="000000">
	<tr>
		<td height="22"  align="center" bgcolor="c7c8ca" class="style4">학습목표</td>
		<td height=""  width="190" align="center" bgcolor="dadbdd" class="style4">처방 세트</td>
	</tr>
	<#assign odabStr = ""><#assign odabSet = ""><#assign odabGrp = ""><#assign SpaceLine = ""><#assign iDisplayCnt = 0>
	<#if odab12?? && !((omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위") >
		<#list odab12 as odab12Index>
			<#if odabGrp != odab12Index.odabGrp && odabGrp != "">
			
				<tr>
					<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;${odabStr}</td>
					<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;${odabSet}</td>
				</tr>
				${SpaceLine}
				<#assign odabStr = ""><#assign odabSet = ""><#assign odabGrp = ""><#assign iDisplayCnt = iDisplayCnt?number+1>							
			</#if>
				<#assign odabGrp = odab12Index.odabGrp>
				<#if odabStr?length = 0><#assign comstring = ""><#else><#assign comstring = ","></#if>
				<#assign odabStr = odabStr + comstring + odab12Index.odabNM>		
				<#assign odabSet = odab12Index.setList>
				<#if omrgicho.kwamok = "KM" || omrgicho.kwamok = "W">
					<#assign odabStr = odabStr + "(" + odab12Index.odab1 + UFNDisplayOdab(odab12Index.odab2) +")">
				</#if>
		</#list>
	</#if>
	
	<#if odab12?? && !((omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위") >
		<tr>
			<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;${odabStr}</td>
			<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;${odabSet }</td>
		</tr>
		${SpaceLine}
		<#assign iDisplayCnt = iDisplayCnt?number+1>
	</#if>
	
	<#if iDisplayCnt?number < 3>
		<#list iDisplayCnt+1.. 3 as iDisplayCntIndex>
			<#if iDisplayCnt?number = 1>
				<#if (omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위">
					<#assign odabStr = "평가를 다시 실시하도록 합니다.">
				<#else>
					<#assign odabStr = "해당 분석 내용이 없습니다.">
				</#if>
			<#else>
				<#assign odabStr = "&nbsp;">
			</#if>
				<tr>
					<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;${odabStr}</td>
					<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				</tr>
				${SpaceLine}
		</#list>
	</#if>
</table>

<!-- 학습기능별 분석 -->
<br>
<table Celloptimize="vertical" width="696" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="ffffff">
	<tr height=5><td bgcolor='#ffffff'></td></tr>
		<td bgcolor="#ffffff" colspan=7 style="color:#000000;"><span class="style4">[학습기능별 분석]</span> <span class="style12">평가 문항을 기능별로 구분하여 각 기능에 결손이 생긴 것에 대해 보충해야 할 세트를 제시하였습니다.</span></td>
	</tr>
</table>
<table Celloptimize="vertical" width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="000000">
	<tr>
		<td height="22"  align="center" bgcolor="c7c8ca" class="style4">학습목표</td>
		<td height=""  width="190" align="center" bgcolor="dadbdd" class="style4">처방 세트</td>
	</tr>
	
	<#assign odabStr = ""><#assign odabSet = ""><#assign odabGrp = ""><#assign odabStr2 = ""><#assign iDisplayCnt = 0>
	<#if odab2?? && !((omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위") >
		<#list odab2 as odab2Index>
			<#if odabGrp != odab2Index.odabGrp && odabGrp != "">
			
				<tr>
					<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;${odabStr}(${odabStr2})</td>
					<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;${odabSet}</td>
				</tr>
				${SpaceLine}
				<#assign odabStr = ""><#assign odabSet = ""><#assign odabGrp = ""><#assign odabStr2 = ""><#assign iDisplayCnt = iDisplayCnt?number+1>							
			</#if>
				<#assign odabGrp = odab2Index.odabGrp>
				<#assign odabStr = odab2Index.dbdes>		
				<#assign odabSet = odab2Index.omrSet>
				<#if odabStr2?length = 0><#assign comstring = ""><#else><#assign comstring = ","></#if>
				<#if omrgicho.kwamok = "KM" || omrgicho.kwamok = "W">
					<#assign odabStr2 = odabStr2 + comstring + odab2Index.odab1?number + UFNDisplayOdab(odab2Index.odab2)>
				</#if>
		</#list>
	</#if>
	<#if odab2?? && !((omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위") >
		<tr>
			<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;${odabStr}(${odabStr2})</td>
			<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;${odabSet }</td>
		</tr>
		${SpaceLine}
		<#assign iDisplayCnt = iDisplayCnt?number+1>
	</#if>
	
	<#if iDisplayCnt?number < 3>
		<#list iDisplayCnt+1.. 3 as iDisplayCntIndex>
			<#if iDisplayCnt?number = 1>
				<#if (omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위">
					<#assign odabStr = "평가를 다시 실시하도록 합니다.">
				<#else>
					<#assign odabStr = "해당 분석 내용이 없습니다.">
				</#if>
			<#else>
				<#assign odabStr = "&nbsp;">
			</#if>
				<tr>
					<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;${odabStr}</td>
					<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				</tr>
				${SpaceLine}
		</#list>
	</#if>
</table>

<!-- 오답 사례별 분석 -->
<br>
<table Celloptimize="vertical" width="696" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="ffffff">
	<tr height=5><td bgcolor='#ffffff'></td></tr>
		<td bgcolor="#ffffff" colspan=7 style="color:#000000;"><span class="style4">[오답사례별 분석]</span> <span class="style12">오답문항의 보기를 세부적으로 분류하여 무엇을 몰라서 왜 틀렸는지 제시하고, 보충해야 할 세트를 제시하였습니다.</span></td>
	</tr>
</table>
<table Celloptimize="vertical" width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="000000">
	<tr>
		<td height="22" width="436" align="center" bgcolor="c7c8ca" class="style4">오답 사례</td>
		<td height="" width="70" align="center" bgcolor="dadbdd" class="style4">오답유형</td>
		<td height="" width="190" align="center" bgcolor="dadbdd" class="style4">처방 세트</td>
	</tr>
	
	
	<#assign odabStr = ""><#assign odabSet = ""><#assign odabGrp = ""><#assign odabStr2 = ""><#assign iDisplayCnt = 0>
	<#if odab4?? && !((omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위") >
		<#list odab4 as odab4Index>
			<#if odabGrp != odab4Index.scode && odabGrp != "">
				<tr>
					<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;${odabStr}(${odabStr2})</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;${odabGrp}</td>
					<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;${odabSet}</td>
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
		<tr>
			<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;${odabStr}(${odabStr2})</td>
			<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;${odabGrp}</td>
			<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;${odabSet}</td>
		</tr>
		${SpaceLine}
		<#assign iDisplayCnt = iDisplayCnt?number+1>
	</#if>
	
	<#if iDisplayCnt?number < 3>
		<#list iDisplayCnt+1.. 3 as iDisplayCntIndex>
			<#if iDisplayCnt?number = 1>
				<#if (omrgicho.pan = "상위" && omrgicho.bosetsu="0") || omrgicho.pan = "하위">
					<#assign odabStr = "평가를 다시 실시하도록 합니다.">
				<#else>
					<#assign odabStr = "해당 분석 내용이 없습니다.">
				</#if>
			<#else>
				<#assign odabStr = "&nbsp;">
			</#if>
				<tr>
					<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;${odabStr}</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
					<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				</tr>
				${SpaceLine}
		</#list>
	</#if>
</table>



<!-- Page3 -->
<table width="696" border="0" align="center" cellpadding="0" cellspacing="0"  style='page-break-before:always'>
	<tr>
		<td height="5" colspan="2"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><font style="font-size:18px; font-face:'';font-weight:bold">개인별진단처방기록부(III)</font></td>
		<!--<td colspan="2" align="center"><img src="./HakSys/img/title_3.gif"/></td>-->
	</tr>
	<tr>
		<td width="60%" height="50" valign="bottom"><img src="${imgPath}/diagnosis/title_sub_1.gif"/></td>
		<td width="40%" align="right" valign="bottom" class="style4">회원번호:${omrgicho.hkey }</td>
	</tr>
</table>

<!-- 학습수준분석 -->

<table width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000' >
	<tr>
		<td height="22" align="center" colspan="4" bgcolor="dadbdd"><span class="style4">학습수준분석</span></td>
		<td align="center" bgcolor="#dadbdd" class="style4" colspan="3">학습 수준 분석 기준</td>
	</tr>
	<tr>
		<td width="156" height="22" align="center" bgcolor="c7c8ca"><span class="style4">구분</span></td>
		<td width="20" align="center" bgcolor="#c7c8ca" class="style4">상</td>
		<td width="20" align="center" bgcolor="#c7c8ca" class="style4">중</td>
		<td width="20" align="center" bgcolor="#c7c8ca" class="style4">하</td>
		<td width="160" align="center" bgcolor="#c7c8ca" class="style4">상</td>
		<td width="160" align="center" bgcolor="#c7c8ca" class="style4">중</td>
		<td width="160" align="center" bgcolor="#c7c8ca" class="style4">하</td>
	</tr>
	<tr>
		<td width="" height="22" align="" bgcolor="dadbdd"><span class="style22">&nbsp;실시진단의 수준</span></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7"><#if sooJun.silSu1 = "2">♣<#else>&nbsp;</#if></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7"><#if sooJun.silSu1 = "1">♣<#else>&nbsp;</#if></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7"><#if sooJun.silSu1 = "0">♣<#else>&nbsp;</#if></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style12">실시등급>학습출발점 가정 등급</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style12">실시등급=학습출발점 가정 등급</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style12">실시등급<학습출발점 가정 등급</td>
	</tr>
	<tr>
		<td width="" height="22" align="" bgcolor="dadbdd"><span class="style22">&nbsp;이전 등급까지의 학습정도</span></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7"><#if sooJun.silSu2 = "2">♣<#else>&nbsp;</#if></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7"><#if sooJun.silSu2 = "1">♣<#else>&nbsp;</#if></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7"><#if sooJun.silSu2 = "0">♣<#else>&nbsp;</#if></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">A+B의 90% 이상</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">80% 이상 90% 미만</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">80% 미만</td>
	</tr>
	<tr>
		<td width="" height="22" align="" bgcolor="dadbdd"><span class="style22">&nbsp;실시등급까지의 학습정도</span></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7"><#if sooJun.silSu3 = "2">♣<#else>&nbsp;</#if></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7"><#if sooJun.silSu3 = "1">♣<#else>&nbsp;</#if></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7"><#if sooJun.silSu3 = "0">♣<#else>&nbsp;</#if></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">A+B+C+D의 80% 이상</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">50% 이상 80% 미만</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">50% 미만</td>
	</tr>
</table>

<br>

<!-- 총평 -->
<#if (omrgicho.pan = "상위" && omrgicho.bosetsu?number = 0) || omrgicho.pan = "하위">
	<!-- 상위재진,하위재진일 경우 -->
	<#assign omrChongExceptNM = "">
	<#if omrgicho.pan = "상위">
		<#assign omrChongExceptNM = "상위 등급을 다시 진단합니다.">
	<#else>
		<#assign omrChongExceptNM = "하위 등급을 다시 진단합니다.">
	</#if>
	<table width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000' >
		<tr>
			<td width="40" height="30" align="center" bgcolor="#FFFFFF"><span class="style4">총평</span></td>
			<td bgcolor="#FFFFFF" class="style7">&nbsp;${omrChongExceptNM}</td>
		</tr>
	</table>
<#else>
	<!-- 종합성취도 -->
	<#assign omrCompleteNM = "">
	<#if totComplet?number gte 90>
		<#assign omrCompleteNM = "매우 우수합니다.">
	<#elseif (totComplet?number gte 80) && (totComplet?number lt 90)>
		<#assign omrCompleteNM = "우수합니다.">
	<#elseif (totComplet?number gte 60) && (totComplet?number lt 80)>
		<#assign omrCompleteNM = "보통입니다.">
	<#else>
		<#assign omrCompleteNM = "노력이 필요합니다.">		
	</#if>
	<!-- 실시진단의수준 -->
	<#assign soojun1NM = "">
	<#if sooJun.silSu1?number = 2>
		<#assign soojun1NM = "높은">
	<#elseif sooJun.silSu1?number = 1>
		<#assign soojun1NM = "알맞은">
	<#elseif sooJun.silSu1?number = 0>
		<#assign soojun1NM = "낮은">
	</#if>

	<!-- 이전등급까지의 학습정도 -->
	<#assign soojun2NM = "">
	<#if sooJun.silSu2?number = 2>
		<#assign soojun2NM = "우수하고">
	<#elseif sooJun.silSu2?number = 1>
		<#assign soojun2NM = "보통이고">
	<#elseif sooJun.silSu2?number = 0>
		<#assign soojun2NM = "낮고">
	</#if>
	
	<!-- 실시등급까지의 학습정도 -->
	<#assign soojun3NM = "">
	<#if sooJun.silSu3?number = 2>
		<#assign soojun3NM = "우수합니다">
	<#elseif sooJun.silSu3?number = 1>
		<#assign soojun3NM = "보통입니다">
	<#elseif sooJun.silSu3?number = 0>
		<#assign soojun3NM = "부족합니다">
	</#if>

	<!-- 학교진도의 학습정도 -->
	<#assign soojun4NM = "">
	<#if sooJun.silSu4?number = 2>
		<#assign soojun4NM = "우수합니다">
	<#elseif sooJun.silSu4?number = 1>
		<#assign soojun4NM = "보통입니다">
	<#elseif sooJun.silSu4?number = 0>
		<#assign soojun4NM = "부족합니다">
	</#if>
	
	<table width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000' >
		<tr>
			<td width="40" height="80" align="center" bgcolor="#FFFFFF"><span class="style4">총평</span></td>
			<td width="656" bgcolor="#FFFFFF">
				<table width="656" border="0" align="right" cellpadding="0" cellspacing="0" bgcolor='#FFFFFF' >
					<tr>
						<td width="5"></td>
						<td class="style7">
						<span class="style4">${omrgicho.MName }</span> 회원의 진단평가 결과 종합성취도는 ${totComplet?int}%로 <span class="style4">${omrCompleteNM}</span>
						학년(나이)에 비해 <span class="style4">${soojun1NM}</span> 등급을 평가하였습니다.
						또한
						<#if sooJun.silSu2?number != 9>						
						이전 등급까지의 학습정도는 <span class="style4">${soojun2NM}</span>
						</#if>
						실시등급까지의 학습정도는 <span class="style4">${soojun3NM}</span>
						<br>학습이 필요한 미세한 결손까지 찾아내어 알맞은 학습출발점을 제시하였습니다. 제시된 처방 프로그램에 맞게 재능스스로수학을
						성실히 진행하면 수학실력을 높일 수 있습니다.
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</#if>





<!-- 처방프로그램 -->
<table width="696" border="0" align="center" cellpadding="0" cellspacing="0" >
	<tr>
		<td align='center' class="style23" height="22">처방 프로그램<!--<img src='./HakSys/img/title_program.gif'>--></td>
	<tr>
</table>
<table width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000'>
	<tr>
		<td width="60" height="22" align="center" bgcolor="c7c8ca" class="style4">주</td>
		
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM1?substring(5,7)?number}월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM2?substring(5,7)?number}월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM3?substring(5,7)?number}월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM4?substring(5,7)?number}월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM5?substring(5,7)?number}월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM6?substring(5,7)?number}월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM7?substring(5,7)?number}월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM8?substring(5,7)?number}월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM9?substring(5,7)?number}월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM10?substring(5,7)?number}월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM11?substring(5,7)?number}월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">${startYYMM.ryYMM12?substring(5,7)?number}월</td>
	</tr>
			
	<tr>
		<td width="" height="22" align="center" bgcolor="#dadbdd" class="style4">1</td>
		<#assign jindoCnt = 0>
		<#if jindo1??>
			<#list jindo1 as jindo1Index>
				<#assign jindoCnt = jindo1Index_index+1>
				<#if jindo1Index.rset = ""><#assign rset = "&nbsp;"><#else><#assign rset = UFNDisplayJinSet(omrgicho.kwamok,jindo1Index.rset)></#if>
				<#if omrgicho.sp?string = rset?string><#assign bgcolor = "#696969"><#else><#assign bgcolor = "#FFFFFF"></#if>
				<td width="" align="center" bgcolor="${bgcolor}" class="style7">${rset}</td>
			</#list>
		</#if>
		<#if jindoCnt < 12>	
			<#list jindoCnt+1.. 12 as rowIndex>
			<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
			</#list>	
		</#if>
	</tr>
	<tr>
		<td width="" height="22" align="center" bgcolor="#dadbdd" class="style4">2</td>
		<#assign jindoCnt = 0>
		<#if jindo2??>
			<#list jindo2 as jindo2Index>
				<#assign jindoCnt = jindo2Index_index+1>
				<#if jindo2Index.rset = ""><#assign rset = "&nbsp;"><#else><#assign rset = UFNDisplayJinSet(omrgicho.kwamok,jindo2Index.rset)></#if>
				<#if omrgicho.sp?string = rset?string><#assign bgcolor = "#696969"><#else><#assign bgcolor = "#FFFFFF"></#if>
				<td width="" align="center" bgcolor="${bgcolor}" class="style7">${rset}</td>
			</#list>
		</#if>
		<#if jindoCnt < 12>	
			<#list jindoCnt+1.. 12 as rowIndex>
			<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
			</#list>	
		</#if>
	</tr>
	<tr>
		<td width="" height="22" align="center" bgcolor="#dadbdd" class="style4">3</td>
		<#assign jindoCnt = 0>
		<#if jindo3??>
			<#list jindo3 as jindo3Index>
				<#assign jindoCnt = jindo3Index_index+1>
				<#if jindo3Index.rset = ""><#assign rset = "&nbsp;"><#else><#assign rset = UFNDisplayJinSet(omrgicho.kwamok,jindo3Index.rset)></#if>
				<#if omrgicho.sp?string = rset?string><#assign bgcolor = "#696969"><#else><#assign bgcolor = "#FFFFFF"></#if>
				<td width="" align="center" bgcolor="${bgcolor}" class="style7">${rset}</td>
			</#list>
		</#if>
		<#if jindoCnt < 12>	
			<#list jindoCnt+1.. 12 as rowIndex>
			<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
			</#list>	
		</#if>
	</tr>
	<tr>
		<td width="" height="22" align="center" bgcolor="#dadbdd" class="style4">4</td>
		<#assign jindoCnt = 0>
		<#if jindo4??>
			<#list jindo4 as jindo4Index>
				<#assign jindoCnt = jindo4Index_index+1>
				<#if jindo4Index.rset = ""><#assign rset = "&nbsp;"><#else><#assign rset = UFNDisplayJinSet(omrgicho.kwamok,jindo4Index.rset)></#if>
				<#if omrgicho.sp?string = rset?string><#assign bgcolor = "#696969"><#else><#assign bgcolor = "#FFFFFF"></#if>
				<td width="" align="center" bgcolor="${bgcolor}" class="style7">${rset}</td>
			</#list>
		</#if>
		<#if jindoCnt < 12>	
			<#list jindoCnt+1.. 12 as rowIndex>
			<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
			</#list>	
		</#if>
	</tr>
	<tr>
		<td width="" height="22" align="center" bgcolor="#dadbdd" class="style4">5</td>
		<#assign jindoCnt = 0>
		<#if jindo5??>
			<#list jindo5 as jindo5Index>
				<#assign jindoCnt = jindo5Index_index+1>
				<#if jindo5Index.rset = ""><#assign rset = "&nbsp;"><#else><#assign rset = UFNDisplayJinSet(omrgicho.kwamok,jindo5Index.rset)></#if>
				<#if omrgicho.sp?string = rset?string><#assign bgcolor = "#696969"><#else><#assign bgcolor = "#FFFFFF"></#if>
				<td width="" align="center" bgcolor="${bgcolor}" class="style7">${rset}</td>
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
<table width="696" border="0" align="center" cellpadding="0" cellspacing="0" >
	<tr>
		<td align='center' class="style23" height="22">예상 진도</td>
	<tr>
</table>
<table width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000'>
	<#assign jinMM = ""><#assign jinStr = ""><#assign idisplayCnt = 0>
	<#if next??>
		<#list next as nextIndex>
			<#if (jinMM != nextIndex.rmm) && (jinMM != "")>
				<#assign idisplayCnt = idisplayCnt?number + 1>
				<tr height=80 valign="top">
					<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>${jinMM?number}월</td>
					<td width="90%" align="" bgcolor="#ffffff" class="style7">${jinStr}</td>
				</tr>
				<#if idisplayCnt?number = 6>
					<#break>
				</#if>
				<#assign jinMM = ""><#assign jinStr = "">
			</#if>
			<#assign jinMM = nextIndex.rmm>
			<#if jinStr = ""><#assign nbspNM = "&nbsp;"><#else><#assign nbspNM = "<br>&nbsp;"></#if>				
			<#assign jinStr = jinStr + nbspNM +  UFNDisplayJinSet(omrgicho.kwamok, nextIndex.rset) + ":" + nextIndex.ynm>			
		</#list>
		<#if idisplayCnt?number < 6>
			<tr height=80 valign="top">
				<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>${jinMM?number}월</td>
				<td width="90%" align="" bgcolor="#ffffff" class="style7">${jinStr}</td>
			</tr>
			<#assign idisplayCnt = idisplayCnt?number + 1>
		</#if>
	</#if>
	<#assign aDateTime = .now>
	<#assign aDate = aDateTime?date>	
	<#assign dateMM = aDate?iso_utc?substring(5,7)>
	<#if idisplayCnt?number < 6>
		<#if jinMM = "">
			<#assign jinMM = dateMM>
		<#else>
			<#if jinMM?number = 12>
				<#assign jinMM = "1" >
			<#else>
				<#assign jinMM = jinMM?number+1 >
			</#if>
		</#if>
		
		<#list idisplayCnt.. 5 as idisplayCntIndex>
			<#if idisplayCnt = 0>
				<#assign jinStr =  "해당 분석 내용이 없습니다">
			<#else>
				<#assign jinStr =  "&nbsp;">
			</#if>
			<tr height=80 valign="top">
				<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>${jinMM?number}월</td>
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

