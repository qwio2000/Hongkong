<#include "/function/diagnosis.ftl">

<meta http-equiv="Content-Type" content="text/html;charset=utf-8">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>Jei-Global.com</title>
<link href="${cssPath}/diagnosisIppr/ENG/style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor=white topmargin=0 leftmargin=0 marginwidth=0 marginheight=0>
<!----------------------------------월별진도상담기록부---------------------------------->
<table align="center" border="0" cellspacing="0" cellpadding="0" width="640">
	<tr>
		<td>
			<!----------------------------------월별진도상담기록부 title---------------------------------->
			<table cellspacing="0" cellpadding="0" width="640" border="0">
				<tr height="50">
					<td align="center" class="ver-m" colspan="2"><font size="5"><b><strong><L>月进度商谈记录表</L></strong></b></font></td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td width="50"></td>
					<td width="590" class="ver-m">
						<b><font size=2><strong>(${sdgicho.kwamok })</strong></font></b>
					</td>
				</tr>
			</table>
			<!----------------------------------회원정보---------------------------------->
			<table border="0" cellspacing="0" cellpadding="0" width="640">
				<tr>
					<td width="160" class="ver-m"></td>
					<td width="60" class="ver-m"></td>
					<td width="40" class="ver-m"></td>
					<td width="60" class="ver-m"><b>学习中心 :</b></td>
					<td width="120" class="ver-m">${sdgicho.skey }(${sdgicho.sname })</td>
					<td width="60" class="ver-m"><b>会员姓名  :</b></td>
					<td width="140" class="ver-m">${sdgicho.mfstname }&nbsp;${sdgicho.mlstname }&nbsp;(${sdgicho.hkey })</td>
				</tr>
				<tr>
					<td class="ver-m"></td>
					<td class="ver-m"><b>管理日 :</b></td>
					<td class="ver-m">&nbsp;</td>
					<td class="ver-m"><b>学习期间 :</b></td>
					<td class="ver-m">${sdgicho.hakgigan }个月</td>
					<td class="ver-m"><b>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:</b></td>
					<td class="ver-m">${sdgicho.gradenm }</td>
				</tr>
			</table>
			<table>
				<tr>
					<td class="ver-m"><font size=2.5><b>${sdgicho.sdmm?number }月学习内容及正确率</b></font></td>
				</tr>
			</table>
			<!----------------------------------월학습내용---------------------------------->
			<table border="1" cellspacing="0" cellpadding="0" width="640" bordercolorlight="LightCyan" bordercolorlight=White>
				<tr>
					<td width="50" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">月/周次</td>
					<td width="40" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">Set</td>
					<td width="430" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">学习内容 </td>
					<td width="40" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">答错数</td>
					<td width="40" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">题数</td>
					<td width="40" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">正确率</td>
				</tr>
				
				<#assign mm = ""><#assign sdset = ""><#assign yetext = ""><#assign errtot = ""><#assign itemtot = ""><#assign pcnt = "">
				<#list 0.. 4 as forIndex>
					<tr>
						<#list sdwolhak as sdwolhakIndex>		
							<#if forIndex_index?number+1 = sdwolhakIndex.sdwk?number>
								<#assign sdset = sdset+' '+sdwolhakIndex.sdset+'<br/>'>
								<#assign yetext = yetext+' '+sdwolhakIndex.yetext+'<br/>'>
								<#assign errtot = errtot+' '+sdwolhakIndex.errtot+'<br/>'>
								<#assign itemtot = itemtot+' '+sdwolhakIndex.itemtot+'<br/>'>
								<#assign pcnt = pcnt+' '+sdwolhakIndex.pcnt+'<br/>'>
							</#if>	
							<#assign mm = sdwolhakIndex.sdmm>	
						</#list>
						<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
							${mm}/${forIndex_index?number+1 }
						</td>
						<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
							${sdset }<#assign sdset = "">
						</td>
						<td bordercolorlight="LightCyan" class="ver-m">
							${yetext }<#assign yetext = "">
						</td>
						<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
							${errtot }<#assign errtot = "">
						</td>					
						<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
							${itemtot }<#assign itemtot = "">			
						</td>					
						<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
							${pcnt }<#assign pcnt = "">							
						</td>	
					</tr>
				</#list>
					
			</table>
			<!-------------------------------형성평가 오답내용 분석---------------------------------->
			


			<table border="0" cellspacing="0" cellpadding="0" width="640">
				<tr>
					<td colspan=9 height="20" class="counsel-m"><font size=2.5 ><b><STRONG>形成评价错答内容分析</STRONG></b></font></td>
				</tr>
			</table>
			<table border="1" cellspacing="0" cellpadding="0" width="640" bordercolorlight="LightCyan" bordercolorlight=White>
				<tr>
					<td width="50" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">月/周次</td>
					<td width="40" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">Set</td>
					<td width="430" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">薄弱部分的学习内容</td>
					<td width=65 align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">答错数</td>
					<td width=60 align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">题数</td>
				</tr>
				<#assign sdsetdung1 = ""><#assign sdsetdung2 = ""><#assign sderrtotsum = 0>
				<#list sdwolhak as sdwolhakIndex>
					<#if (sdwolhakIndex.sdwk = "2") && (sdwolhakIndex.sdsort = "1")>
						<#assign sdsetdung1 = sdwolhakIndex.sdset?substring(0,1)>
					</#if>
					<#if (sdwolhakIndex.sdwk = "2") && (sdwolhakIndex.sdsort = "2")>
						<#assign sdsetdung2 = sdwolhakIndex.sdset?substring(0,1)>
					</#if>
					<#assign sderrtotsum = sderrtotsum?number + sdwolhakIndex.errtot?number>
				</#list>
			
				<#if subj?substring(1,2) = "M" && (sdsetdung1 = "A" || sdsetdung1 = "B" || sdsetdung1 = "C"  || sdsetdung2 = "A" || sdsetdung2 = "B" || sdsetdung2 = "C") || (subj = "KP" && (sdsetdung1 = "A" ||sdsetdung1 = "B" || sdsetdung1 = "C" || sdsetdung1 = "D" || sdsetdung2 = "A" || sdsetdung2 = "B" ||sdsetdung2 = "C" || sdsetdung2 = "D" ) )	>
						<tr>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
							<td bordercolorlight="LightCyan" height="100" class="ver-m"><br><br>&nbsp;该会员的学习内容中没有形成评价。<br>&nbsp;请家长继续给予更多的关心和鼓励。<br><br></td>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
						</tr>
				<#else>
					<#if sderrtotsum = 0>
						<tr>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
							<td bordercolorlight="LightCyan" height="100" class="ver-m"><br><br>&nbsp;形成评价结果显示，会员的学习中没有薄弱环节，进行得非常好。<br>&nbsp;请家长继续给予关心和鼓励，保证会员能够始终实现完全学习。<br><br></td>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
						</tr>
					<#else>
						<#list sderr as sderrIndex>
						<tr>
							<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
								${sderrIndex.sdmm }/${sderrIndex.sdwk }
							</td>
							<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
								${sderrIndex.sdset }
							</td>
							<td bordercolorlight="LightCyan" height="25" class="ver-m">
								&nbsp;${sderrIndex.sdset_ect }
							</td>
							<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
								<#if sderrIndex.sdset_e?number = 0> &nbsp; <#else>${sderrIndex.sdset_e }</#if>								
							</td>
							<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
								<#if sderrIndex.sdset_q?number = 0> &nbsp; <#else>${sderrIndex.sdset_q?number }</#if>																
							</td>
						</tr>
						</#list>
					</#if>
				</#if>
			</table>
			
			<!----------------------------------진도현황(금월/예상)---------------------------------->
			<table border="0" cellspacing="0" cellpadding="0" width="640">
				<tr>
					<td colspan="9" height="20" class="counsel-m"><font size=2.5><b><STRONG>进度情况（本月/预计） </STRONG></b></font></td>
				</tr>
			</table>
			<table border="1" cellspacing="0" cellpadding="0" width="640" bordercolorlight="LightCyan">
				<tr>
					<td width="50" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">月/周次</td>
					<td width="40" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">Set</td>
					<td width="495" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">学习内容 </td>
					<td width="57" align="center" bordercolorlight="LightCyan" height="20" class="counsel-m">学习领域</td>
				</tr>
			<!---상담월+1----------------------------------------------------------------------------------->
			<#assign jset = ""><#assign yetext = ""><#assign yetext = ""><#assign ed = "">
			<#list 0.. 4 as forIndex>
				<#list jindo as jindoIndex>		
					<#if (convYYMM1 = jindoIndex.yy+"-"+jindoIndex.mm) && (forIndex_index?number+1 = jindoIndex.wk?number)>
						<#assign jset = jset+' '+jindoIndex.jset+'<br/>'>
						<#assign yetext = yetext+' '+jindoIndex.yetext+'<br/>'>
						<#assign ed = ed+' '+jindoIndex.ed+'<br/>'>
					</#if>
				</#list>
				<tr>
					<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
						${convYYMM1?substring(0,1) }/${forIndex_index+1 }
					</td>
					<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
						${jset }<#assign jset = "">
					</td>
					<td bordercolorlight="LightCyan" height="25" class="ver-m">
						&nbsp;${yetext }<#assign yetext = "">
					</td>
					<td align="center" bordercolorlight="LightCyan" class="counsel-m">
						${ed }<#assign ed = "">
					</td>
				</tr>
			</#list>
			<!---상담월+2----------------------------------------------------------------------------------->
			<#assign jset = ""><#assign yetext = ""><#assign yetext = ""><#assign ed = "">
			<#list 0.. 4 as forIndex>
				<#list jindo as jindoIndex>		
					<#if (convYYMM2 = jindoIndex.yy+"-"+jindoIndex.mm) && (forIndex_index?number+1 = jindoIndex.wk?number)>
						<#assign jset = jset+' '+jindoIndex.jset+'<br/>'>
						<#assign yetext = yetext+' '+jindoIndex.yetext+'<br/>'>
						<#assign ed = ed+' '+jindoIndex.ed+'<br/>'>
					</#if>
				</#list>
				<tr>
					<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
						${convYYMM1?substring(0,1) }/${forIndex_index+1 }
					</td>
					<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
						${jset }<#assign jset = "">
					</td>
					<td bordercolorlight="LightCyan" height="25" class="ver-m">
						&nbsp;${yetext }<#assign yetext = "">
					</td>
					<td align="center" bordercolorlight="LightCyan" class="counsel-m">
						${ed }<#assign ed = "">
					</td>
				</tr>
			</#list>
			<!---상담월+3----------------------------------------------------------------------------------->
			<#assign jset = ""><#assign yetext = ""><#assign yetext = ""><#assign ed = "">
			<#list 0.. 4 as forIndex>
				<#list jindo as jindoIndex>		
					<#if (convYYMM3 = jindoIndex.yy+"-"+jindoIndex.mm) && (forIndex_index?number+1 = jindoIndex.wk?number)>
						<#assign jset = jset+' '+jindoIndex.jset+'<br/>'>
						<#assign yetext = yetext+' '+jindoIndex.yetext+'<br/>'>
						<#assign ed = ed+' '+jindoIndex.ed+'<br/>'>
					</#if>
				</#list>
				<tr>
					<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
						${convYYMM1?substring(0,1) }/${forIndex_index+1 }
					</td>
					<td align="center" bordercolorlight="LightCyan" height="25" class="ver-m">
						${jset }<#assign jset = "">
					</td>
					<td bordercolorlight="LightCyan" height="25" class="ver-m">
						&nbsp;${yetext }<#assign yetext = "">
					</td>
					<td align="center" bordercolorlight="LightCyan" class="counsel-m">
						${ed }<#assign ed = "">
					</td>
				</tr>
			</#list>
			</table>
			
			<!--------------------------------월 학습환경---------------------------------------->			
			<#if sdgicho.sdmm?number = 11>
				<#assign nxtsdmm = "12">							
			<#elseif sdgicho.sdmm?number = 12>
				<#assign nxtsdmm = "1">
			<#else>
				<#assign nxtsdmm = sdgicho.sdmm?number+1>
			</#if>			
			<table border="0" cellspacing="0" cellpadding="0" width="640">
				<tr>
					<td colspan="9" height="20" class="ver-m"><b><font size=2.5><strong>(${nxtsdmm })月的学习环境</strong></font></b></td>
				</tr>
			</table>
			<table border=1 cellspacing="0" cellpadding="0" width="640" bordercolorlight="LightCyan">
				<tr height="80">
					<td width="640" bordercolorlight="LightCyan" class="ver-m">
					 &nbsp;
					<#if (sdgicho.wolhak = "Y") && !(subj = "EM" || subj = "EE")>
						${setdata }						
					</#if>
					</td>
				</tr>
			</table>
			<table border="0" cellspacing="0" cellpadding="0" width="640" >
				<tr height="24">
					<td width="640" bordercolorlight="LightCyan" class="ver-m"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
