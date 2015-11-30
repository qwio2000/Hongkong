<#-- @ftlvariable name="loginInfo" type="com.jeiglobal.domain.auth.LoginInfo" -->
<#-- @ftlvariable name="jisaAuthInfo" type="com.jeiglobal.hk.auth.Authority" -->
<#-- @ftlvariable name="bmsAuthInfo" type="com.jeiglobal.hk.auth.Authority" -->
<#-- @ftlvariable name="imgPath" type="java.lang.String" -->
<#-- @ftlvariable name="cssPath type="java.lang.String" -->
<#-- @ftlvariable name="jsPath" type="java.lang.String" -->
<#-- @ftlvariable name="mainWeek" type="java.util.List" -->
<#import "/spring.ftl" as spring/>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<#include "/function/diagnosis.ftl">


<!DOCTYPE html>
<!--[if IE 7]><html lang="ko" class="ie7"><![endif]-->
<!--[if IE 8]><html lang="ko" class="ie8"><![endif]-->
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>Jaeneung Education</title>
		<link href="${cssPath}/diagnosisIppr/ENG/style.css" rel="stylesheet" type="text/css">
	</head>
	
	<link rel="stylesheet" type="text/css" href="${cssPath }/jquery-ui.1.11.4.min.css" />
	<#if headerCss?has_content>
	<#list headerCss as css>
		<link rel="stylesheet" type="text/css" href="${cssPath }/${css}.css" />
	</#list>
	</#if>
	<script type="text/javascript" src="${jsPath }/common/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${jsPath }/common/handlebars-3.0.3-min.js"></script>
	<script type="text/javascript" src="${jsPath }/common/common.js"></script>
	<script type="text/javascript" src="${jsPath }/common/jquery-ui.1.11.4.min.js"></script>
	<#if headerScript?has_content>
	<#list headerScript as script>
		<script type="text/javascript" src="${jsPath }/${script}.js"></script>
	</#list>
	</#if>
	<script type="text/javascript">
		var imgPath = '${imgPath}';
		var jisaCD = '${loginInfo.jisaCD}';
		var deptCD = '${loginInfo.deptCD}';
		var userType = '${loginInfo.userType}';
	</script>

</head>
<body bgcolor=white topmargin=0 leftmargin=0 marginwidth=0 marginheight=0>
	<center>
	<br><br><br><br>
	<table align=center border=0 cellspacing=0 cellpadding=0 width=640 height="30">
		<tr>
			<td height="30"> &nbsp; </td>
		</tr>
	</table>

		
		
	<table cellspacing=0 cellpadding=0 width=640 border=0 height="30">
		<tr>
			<td align=center colspan="2"><font size=4><b>个人进度处方记录表</b></font></td>
		</tr>
		<tr>
			<td><br></td>
		</tr>
		<tr>
			<td WIDTH="450"><font size=3><b>CL(CL)</b></font></td>
			<TD WIDTH="190" ALIGN="right">学习中心 : ?????????????</TD>
		</tr>
		<TR>
			<TD WIDTH="450" ALIGN="right"></TD>							
			<TD WIDTH="190" ALIGN="right">教室 : ????????????</td>
		</TR>
	</table>
	</center>
	<table align=center border=0 cellspacing=0 cellpadding=0 width=640 height=870>
		<TR valign="top">
			<td>
				<table border=1 cellspacing=0 cellpadding=0 width=640 bordercolorlight=LightCyan bordercolorlight=White>
					<tr>
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White><b>会员编号</b></td>
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White><b>会员姓名</b></td>
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White><b>年级</b></td>
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White><b>出生年月日</b></td>
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White><b>处理日期</b></td>
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White><b>诊断种类</b></td>
						<td width=100 align="center" bordercolorlight=LightCyan bordercolorlight=White><b>管理日</b></td>
					</tr>
					<tr>
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;${omrgicho.hkey }</td>
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;${omrgicho.MName }&nbsp;</td>
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;${omrgicho.omrHakNM }</td>                 
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;${omrgicho.omrBirth }</td>
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;${omrgicho.omrDate }</td>
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;${omrgicho.omrKindNM } / ${omrgicho.omrGrd }</td>											
						<td width=90 align="center" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;${omrgicho.omrYoilNM }</td>
					</tr>
				</table>
				<br>
				<table border=0 cellspacing=0 cellpadding=0 width=640>             
					<tr>
						<td colspan=2 align="left"><font size=3><b>♣按领域分析  </b></font></td>
					</tr>             
					<tr height=180 width="640">
						<td width="440" align=center>
							<!-- 차트들어가야됨!! -->
							<div class="row">
							    <div class="col col-4"><div id="chart"></div></div>
							</div>
						</td>               
						 <#assign sung = (range.jung?number/range.tot?number) * 100><!--  gt :> , gte : >= , lt < , lte <= -->
						 <#if sung?number gte 90>
							<#assign tsung = "非常优秀">
						 <#else>
							<#if (sung?number gte 80) && (sung?number lt 90)>
								<#assign tsung = "优秀">								
							<#else>
								<#if (sung?number gte 60) && (sung?number lt 80)>
									<#assign tsung = "一般">									
								<#else>
									<#assign tsung = "表明需进一步努力">									
								</#if>
							</#if>
						 </#if>
						<td width="200" align=center>
						
							<table border=0 cellspacing=0 cellpadding=0 height="40" width=200>
								<tr>
									<td align="center"><b> 成就率:${sung } %</b></td>
								</tr>
							</table>
							<table border=0 cellspacing=0 cellpadding=0 width=200 bordercolorlight=LightCyan bordercolorlight=White>
								<TR>
									<TD>
										<img src="${imgPath}/diagnosis/ENG/report_01.gif" WIDTH=13 HEIGHT=22></TD>
									<TD>
										<img src="${imgPath}/diagnosis/ENG/report_02.gif" WIDTH=100% HEIGHT=22></TD>
									<TD>
										<img src="${imgPath}/diagnosis/ENG/report_03.gif" WIDTH=11 HEIGHT=22></TD>
								</TR>
								<tr>
									<TD background="${imgPath}/diagnosis/ENG/report_04.gif">
										<img src="${imgPath}/diagnosis/ENG/report_04.gif" WIDTH=13 HEIGHT=22>
									</TD>
									<td align="left">&nbsp;诊断结果的综合成就率<B>${tsung }。</b>
										<#if kwamok?substring(1,2) != "L">
											<#if (sung?number < 100) && (sung?number > 0)>
												<b>${rangehl.hsprt?replace("<BR>"," ") }</b>领域掌握得最好。
											</#if>
										</#if>
										
									</td>
									<TD background="${imgPath}/diagnosis/ENG/report_06.gif">
										<img src="${imgPath}/diagnosis/ENG/report_06.gif" WIDTH=11 HEIGHT=22>
									</TD>
								</tr>
								<TR>
									<TD>
										<img src="${imgPath}/diagnosis/ENG/report_07.gif" WIDTH=13 HEIGHT=20></TD>
									<TD>
										<img src="${imgPath}/diagnosis/ENG/report_08.gif" WIDTH=100% HEIGHT=20></TD>
									<TD>
										<img src="${imgPath}/diagnosis/ENG/report_09.gif" WIDTH=11 HEIGHT=20></TD>
								</TR>
							</table>
						</td>                 
					</tr>             
				</table>
				<table border=1 cellspacing=0 cellpadding=0 width=640 bordercolorlight=LightCyan bordercolorlight=White>
					<tr width=640>
						<td width="90" align=center bordercolorlight=LightCyan bordercolorlight=White>领域</td>
					<#if kwamok?substring(1,2) = "K">					
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[1]독서<BR>&nbsp;&nbsp;&nbsp;&nbsp;기초</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[2]초기<BR>&nbsp;&nbsp;&nbsp;&nbsp;독서</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[3]독해<BR>&nbsp;&nbsp;&nbsp;&nbsp;(초)</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[4]표기</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[5]작문<BR>&nbsp;&nbsp;&nbsp;&nbsp;(초)</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[6]정보<BR>&nbsp;&nbsp;&nbsp;&nbsp;이용</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[7]국어<BR>&nbsp;&nbsp;&nbsp;&nbsp;지식</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[8]독해<BR>&nbsp;&nbsp;&nbsp;&nbsp;(중)</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[9]작문<BR>&nbsp;&nbsp;&nbsp;&nbsp;(중)</td>
					</#if>
					<#if kwamok?substring(1,2) = "E">	
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[1]基础阅读</td>
						<td width="60" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[2]拼读规则</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[3]阅读理解</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[4]会话</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[5]语法</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[6]信息应用</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="52" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
					</#if>
					<#if kwamok?substring(1,2) = "P">	
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[1]기초<BR>&nbsp;&nbsp;&nbsp;&nbsp;지식</td>
						<td width="55" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[2]언어</td>
						<td width="55" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[3]수</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[4]공간<BR>&nbsp;&nbsp;&nbsp;&nbsp;지각</td>
						<td width="55" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[5]기억</td>
						<td width="55" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[6]분석</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[7]논리<BR>&nbsp;&nbsp;&nbsp;&nbsp;형식</td>
						<td width="60" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[8]창의적<br>&nbsp;사고</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[9]문제<BR>&nbsp;&nbsp;&nbsp;&nbsp;해결</td>
					</#if>
					<#if kwamok?substring(1,2) = "G">	
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[1]독서<BR>&nbsp;&nbsp;&nbsp;&nbsp;기초</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[2]초기<BR>&nbsp;&nbsp;&nbsp;&nbsp;독서</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
					</#if>
					<#if kwamok?substring(1,2) = "L">	
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>[1]基础阅读</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
						<td width="56" height="35" align=center valign="top" bordercolorlight=LightCyan bordercolorlight=White>&nbsp;</td>
					</#if>
						<td width="56" height="35" align=center bordercolorlight=LightCyan bordercolorlight=White>合计</td>
					</tr>
					<tr width=640>
						<td align=center bordercolorlight=LightCyan bordercolorlight=White>答对数/答题数</td>
						<td align=center bordercolorlight=LightCyan bordercolorlight=White>&nbsp;<#if (range.tot1?number != 0)>${range.r1}/${range.tot1}</#if></td>
						<td align=center bordercolorlight=LightCyan bordercolorlight=White>&nbsp;<#if (range.tot2?number != 0)>${range.r2}/${range.tot2}</#if></td>
						<td align=center bordercolorlight=LightCyan bordercolorlight=White>&nbsp;<#if (range.tot3?number != 0)>${range.r3}/${range.tot3}</#if></td>
						<td align=center bordercolorlight=LightCyan bordercolorlight=White>&nbsp;<#if (range.tot4?number != 0)>${range.r4}/${range.tot4}</#if></td>
						<td align=center bordercolorlight=LightCyan bordercolorlight=White>&nbsp;<#if (range.tot5?number != 0)>${range.r5}/${range.tot5}</#if></td>
						<td align=center bordercolorlight=LightCyan bordercolorlight=White>&nbsp;<#if (range.tot6?number != 0)>${range.r6}/${range.tot6}</#if></td>
						<td align=center bordercolorlight=LightCyan bordercolorlight=White>&nbsp;<#if (range.tot7?number != 0)>${range.r7}/${range.tot7}</#if></td>
						<td align=center bordercolorlight=LightCyan bordercolorlight=White>&nbsp;<#if (range.tot8?number != 0)>${range.r8}/${range.tot8}</#if></td>
						<td align=center bordercolorlight=LightCyan bordercolorlight=White>&nbsp;<#if (range.tot9?number != 0)>${range.r9}/${range.tot9}</#if></td>
						<td align=center bordercolorlight=LightCyan bordercolorlight=White>${range.jung}/${range.tot}</td>
					</tr>
				</table>
				<br>
				<table border=0 cellspacing=0 cellpadding=0 width=640>             
					<tr>
						<td align="left"><font size=3><b>♣预计进度</b></font>
						</td>
					</tr>             
				</table>
				
				<table border=1 cellspacing=0 cellpadding=0 width=640 bordercolorlight=LightCyan bordercolorlight=White>
					<tr width=640>
						<td width=25 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>周次</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM1?substring(5,7)?number }月</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM2?substring(5,7)?number }月</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM3?substring(5,7)?number }月</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM4?substring(5,7)?number }月</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM5?substring(5,7)?number }月</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM6?substring(5,7)?number }月</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM7?substring(5,7)?number }月</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM8?substring(5,7)?number }月</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM9?substring(5,7)?number }月</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM10?substring(5,7)?number }月</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM11?substring(5,7)?number }月</td>
						<td width=49 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>${startYYMM.ryYMM12?substring(5,7)?number }月</td>
					</tr>
					<tr width=640>
						<td width=30 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>1</td>					
						<#assign jindoCnt = 0>
						<#if jindo1??>
							<#list jindo1 as jindo1Index>
								<#assign jindoCnt = jindo1Index_index+1>
								<#if jindo1Index.rset1 = ""><#assign rset1 = "&nbsp;"><#else><#assign rset1 = UFNDisplayJinSetC(omrgicho.kwamok,jindo1Index.rset1,jindo1Index.rset21)></#if>
								<#if jindo1Index.rset2 = ""><#assign rset2 = ""><#else><#assign rset2 = UFNDisplayJinSetC(omrgicho.kwamok,jindo1Index.rset2,jindo1Index.rset22)></#if>
								<td align="center" bordercolorlight="LightCyan" bordercolorlight="White">${rset1}<#if rset2 != ""></br>${rset2 }</#if></td>
							</#list>
						</#if>
						<#if jindoCnt < 12>	
							<#list jindoCnt+1.. 12 as rowIndex>
							<td align="center" bordercolorlight="LightCyan" bordercolorlight="White">&nbsp;</td>
							</#list>	
						</#if>
					</tr>
					<tr width=640>
						<td width=30 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>2</td>
						<#assign jindoCnt = 0>
						<#if jindo2??>
							<#list jindo2 as jindo2Index>
								<#assign jindoCnt = jindo2Index_index+1>
								<#if jindo2Index.rset1 = ""><#assign rset1 = "&nbsp;"><#else><#assign rset1 = UFNDisplayJinSetC(omrgicho.kwamok,jindo2Index.rset1,jindo2Index.rset21)></#if>
								<#if jindo2Index.rset2 = ""><#assign rset2 = ""><#else><#assign rset2 = UFNDisplayJinSetC(omrgicho.kwamok,jindo2Index.rset2,jindo2Index.rset22)></#if>
								<td align="center" bordercolorlight="LightCyan" bordercolorlight="White">${rset1}<#if rset2 != ""></br>${rset2 }</#if></td>
							</#list>
						</#if>
						<#if jindoCnt < 12>	
							<#list jindoCnt+1.. 12 as rowIndex>
							<td align="center" bordercolorlight="LightCyan" bordercolorlight="White">&nbsp;</td>
							</#list>	
						</#if>
					</tr>             
					<tr width=640>
						<td width=30 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>3</td>
						<#assign jindoCnt = 0>
						<#if jindo3??>
							<#list jindo3 as jindo3Index>
								<#assign jindoCnt = jindo3Index_index+1>
								<#if jindo3Index.rset1 = ""><#assign rset1 = "&nbsp;"><#else><#assign rset1 = UFNDisplayJinSetC(omrgicho.kwamok,jindo3Index.rset1,jindo3Index.rset21)></#if>
								<#if jindo3Index.rset2 = ""><#assign rset2 = ""><#else><#assign rset2 = UFNDisplayJinSetC(omrgicho.kwamok,jindo3Index.rset2,jindo3Index.rset22)></#if>
								<td align="center" bordercolorlight="LightCyan" bordercolorlight="White">${rset1}<#if rset2 != ""></br>${rset2 }</#if></td>
							</#list>
						</#if>
						<#if jindoCnt < 12>	
							<#list jindoCnt+1.. 12 as rowIndex>
							<td align="center" bordercolorlight="LightCyan" bordercolorlight="White">&nbsp;</td>
							</#list>	
						</#if>
					</tr>             
					<tr width=640>
						<td width=30 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>4</td>
						<#assign jindoCnt = 0>
						<#if jindo4??>
							<#list jindo4 as jindo4Index>
								<#assign jindoCnt = jindo4Index_index+1>
								<#if jindo4Index.rset1 = ""><#assign rset1 = "&nbsp;"><#else><#assign rset1 = UFNDisplayJinSetC(omrgicho.kwamok,jindo4Index.rset1,jindo4Index.rset21)></#if>
								<#if jindo4Index.rset2 = ""><#assign rset2 = ""><#else><#assign rset2 = UFNDisplayJinSetC(omrgicho.kwamok,jindo4Index.rset2,jindo4Index.rset22)></#if>
								<td align="center" bordercolorlight="LightCyan" bordercolorlight="White">${rset1}<#if rset2 != ""></br>${rset2 }</#if></td>
							</#list>
						</#if>
						<#if jindoCnt < 12>	
							<#list jindoCnt+1.. 12 as rowIndex>
							<td align="center" bordercolorlight="LightCyan" bordercolorlight="White">&nbsp;</td>
							</#list>	
						</#if>
					</tr>             
					<tr width=640>
						<td width=30 align=center bordercolorlight=LightCyan bordercolorlight=White bgcolor=LightGrey>5</td>
						<#assign jindoCnt = 0>
						<#if jindo5??>
							<#list jindo5 as jindo5Index>
								<#assign jindoCnt = jindo5Index_index+1>
								<#if jindo5Index.rset1 = ""><#assign rset1 = "&nbsp;"><#else><#assign rset1 = UFNDisplayJinSetC(omrgicho.kwamok,jindo5Index.rset1,jindo5Index.rset21)></#if>
								<#if jindo5Index.rset2 = ""><#assign rset2 = ""><#else><#assign rset2 = UFNDisplayJinSetC(omrgicho.kwamok,jindo5Index.rset2,jindo5Index.rset22)></#if>
								<td align="center" bordercolorlight="LightCyan" bordercolorlight="White">${rset1}<#if rset2 != ""></br>${rset2 }</#if></td>
							</#list>
						</#if>
						<#if jindoCnt < 12>	
							<#list jindoCnt+1.. 12 as rowIndex>
							<td align="center" bordercolorlight="LightCyan" bordercolorlight="White">&nbsp;</td>
							</#list>	
						</#if>
					</tr>             
				</table>
				<br>
				<table border=1 cellspacing=0 cellpadding=0 width=640 bordercolorlight=LightCyan bordercolorlight=White>             
					<tr>
						<td width="20" height="20" align="center">月</td>
						<td width="20" height="20" align="center">周次</td>
						<td width="30" height="20" align="center">管理日</td>
						<td width="40" height="20" align="center">学习教材</td>
						<td width="550" height="20" align="center">重点学习内容</td>
					</tr>
					<#assign nextCnt = 0>
					<#if next??>
						<#list next as nextIndex>
						<#assign nextCnt = nextCnt?number + 1>
						<tr>
							<td height="30" align="center">&nbsp;${nextIndex.rmm }</td>
							<td height="30" align="center">&nbsp;${nextIndex.rweek }</td>
							<td height="30" align="center">&nbsp;${nextIndex.ryoil }</td>
							<td height="30" align="center">
						    <#assign rset = UFNDisplayJinSetC(omrgicho.kwamok,nextIndex.rset,nextIndex.rset2)>
						    ${rset }
						    </font></td>
							<td height="30" align="left">&nbsp; ${nextIndex.ynm }</td>
						</tr>
						</#list>
					</#if>
					<#if nextCnt < 9>	
						<#list nextCnt+1.. 9 as rowIndex>
						<tr>
							<td height="30" align="center">&nbsp;</td>
							<td height="30" align="center">&nbsp;</td>
							<td height="30" align="center">&nbsp;</td>
							<td height="30" align="center">&nbsp;</td>
							<td height="30" align="left">&nbsp;</td>
						</tr>
						</#list>	
					</#if>
					
					
					
				</table>     
			</td>
		</tr>
	</table>	

	<#if (omrgicho.pan = "하위") || (sung?number >= 100)>
	<#else>	
	<br><br><br><br><br><br>
	<table align=center border=0 cellspacing=0 cellpadding=0 width=640 height="30">
		<tr>
			<td height="30"> &nbsp; </td>
		</tr>
	</table>
	<table align=center border=0 cellspacing=0 cellpadding=0 width=640 height=972>   
		<TR valign="top">
			<TD>								
				<table cellspacing=0 cellpadding=0 width=640 border=0>              
					<tr>
						<td align="left"><font size=3><b>♣错答分析</b></font>
						</td>
						<td align="right">${omrgicho.hkey }</font>
						</td>
					</tr>             
				</table>
				<table border="1" cellspacing="0" cellpadding="0" width=640 bordercolorlight=LightCyan bordercolorlight=White  celloptimize="vertical" Vcellrepeat="1">
					<tr>
						<td width="50" align="center"><b>领域</B></td>
						<td width="50" align="center"><b>题号</B></td>
						<td width="480" align="center"><b>错答内容分析</B></td>
						<td width="60" align="center">&nbsp;</td>
					</TR>
					<#if omrOdab??>
						<#assign rangecnt = 1><#assign rangecntfor = 0>
						<#list omrOdab as omrOdabIndex>
							<tr>
								<#if omrOdabIndex_index+1 = rangecnt+rangecntfor>
									<td width="50" ROWSPAN ="${omrOdabIndex.cnt }" valign="middle" align="center" >${omrOdabIndex.sprt }</td>
									<#assign rangecntfor = rangecntfor+omrOdabIndex.cnt?number>
								</#if>
							
								<td width="50" align="center">${omrOdabIndex.odab1 }${UFNDisplayOdab(omrOdabIndex.odab2) }
								</td>
								<td width="480" align="left">&nbsp;${omrOdabIndex.odabnm }</td>
								<td width="60" align="center">&nbsp;${omrOdabIndex.odabschool }</td>
							</tr>  
						</#list>					
					</#if>
				</table>         
			</td>
		</tr>
	</table>
	</#if>

</body>


<script type="text/javascript">
	$(document).ready(function () {
			var dominArry= "";	
			var dominString = "";			
		
			
			var rangeArry= "";
			var rangeString = "";	
			
			var rangeallArry= "";
			var rangeallString = "";
			
	
			
			<#if (range.tot1?number != 0)>
				dominString = dominString + "[1],"
				rangeString = rangeString + (${range.r1}*1.0/${range.tot1}) * 100 + ","
				rangeallString = rangeallString + ${range.all1} + ","
			</#if>
			<#if (range.tot2?number != 0)>
				dominString = dominString + "[2],"
				rangeString = rangeString + (${range.r2}*1.0/${range.tot2}) * 100 + ","
				rangeallString = rangeallString + ${range.all2} + ","
			</#if>
			<#if (range.tot3?number != 0)>
				dominString = dominString + "[3],"
				rangeString = rangeString + (${range.r3}*1.0/${range.tot3}) * 100 + ","
				rangeallString = rangeallString + ${range.all3} + ","
			</#if>
			<#if (range.tot4?number != 0)>
				dominString = dominString + "[4],"
				rangeString = rangeString + (${range.r4}*1.0/${range.tot4}) * 100 + ","
				rangeallString = rangeallString + ${range.all4} + ","
			</#if>
			<#if (range.tot5?number != 0)>
				dominString = dominString + "[5],"
				rangeString = rangeString + (${range.r5}*1.0/${range.tot5}) * 100 + ","
				rangeallString = rangeallString + ${range.all5} + ","
			</#if>
			<#if (range.tot6?number != 0)>
				dominString = dominString + "[6],"
				rangeString = rangeString + (${range.r6}*1.0/${range.tot6}) * 100 + ","
				rangeallString = rangeallString + ${range.all6} + ","
			</#if>
			<#if (range.tot7?number != 0)>
				dominString = dominString + "[7],"
				rangeString = rangeString + (${range.r7}*1.0/${range.tot7}) * 100 + ","
				rangeallString = rangeallString + ${range.all7} + ","
			</#if>
			<#if (range.tot8?number != 0)>
				dominString = dominString + "[8],"
				rangeString = rangeString + (${range.r8}*1.0/${range.tot8}) * 100 + ","
				rangeallString = rangeallString + ${range.all8} + ","
			</#if>
			<#if (range.tot9?number != 0)>
				dominString = dominString + "[9],"
				rangeString = rangeString + (${range.r9}*1.0/${range.tot9}) * 100 + ","
				rangeallString = rangeallString + ${range.all9} + ","
			</#if>
			
			dominArry 	 = dominString.split(",");
			rangeArry 	 = rangeString.split(",");
			rangeallArry = rangeallString.split(",");
		
		 	var data = [];
			var domain = [];
	            
			for(var i = 0 ; i < dominArry.length-1 ; i++){
					domain.push('"'+dominArry[i]+'"' )
					data.push({ "나의성취율" : parseInt(rangeArry[i]), "전체회원평균" : rangeallArry[i]} )
			}

			var domain = domain ;
			var data = data ;
			var width =  440;
			var height = 240;
		   
		   jei.getprintChart(domain, data, width, height);
	});
</script>

</html>









