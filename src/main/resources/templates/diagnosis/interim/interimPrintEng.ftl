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
					<td align="center" class="ver-m" colspan="2">
						<font size="5"><b><strong><L>PROGRESS COUNSELING REPORT</L></strong></b></font>
					></td>
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
					<td width="90" class="ver-m"></td>
					<td width="100" class="ver-m"><b>Franchisee :</b></td>
					<td width="120" class="ver-m">${sdgicho.skey }(${sdgicho.sname })</td>
					<td width="90" class="ver-m"><b>>Member Name :</b></td>
					<td class="ver-m" colspan="3">${sdgicho.mfstname }&nbsp;${sdgicho.mlstname }&nbsp;(${sdgicho.hkey })</td>
				</tr>
				<tr>
					<td class="ver-m"><font size=2><b></b></font></td>					
					<td class="ver-m"><b>Learning Period :</b></td>		
					<td class="ver-m">${sdgicho.hakgigan }</td>
					<td class="ver-m"><b>>School YR :</b></td>
					<td class="ver-m"><b>Visit Day :</b></td>					
					<td class="ver-m">&nbsp;${sdgicho.cyoilnm }</td>
				</tr>
			</table>
			<table>
				<tr>
					<td class="ver-m"><font size=2.5><b>Learning Objectives & Achievement Level</b></font></td>							
				</tr>
			</table>
			<!----------------------------------월학습내용---------------------------------->
			<table border="1" cellspacing="0" cellpadding="0" width="640" bordercolorlight="LightCyan" bordercolorlight=White>
				<tr>
					<td width="35" align="center" bordercolorlight="LightCyan" height="20" class="ver-m">M/W</td>					
					<td width="35" align="center" bordercolorlight="LightCyan" height="20" class="ver-m">SET</td>					
					<td width="440" align="center" bordercolorlight="LightCyan" height="20" class="ver-m">LEARNING OBJECTIVES</td>					
					<td width="40" align="center" bordercolorlight="LightCyan" height="20" class="ver-m">I</td>					
					<td width="40" align="center" bordercolorlight="LightCyan" height="20" class="ver-m">Q</td>					
					<td width="50" align="center" bordercolorlight="LightCyan" height="20" class="ver-m">%</td>			
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
					<td colspan=9 height="20" class="ver-m"><font size=2.5 ><b><strong>COUNSELING ANALYSIS OF ERRORS</strong></b></font></td>			
				</tr>
			</table>
			<table border="1" cellspacing="0" cellpadding="0" width="640" bordercolorlight="LightCyan" bordercolorlight=White>
				<tr>
					<td width="35" align="center" bordercolorlight="LightCyan" height="25" class="ver-m">M/W</td>					
					<td width="35" align="center" bordercolorlight="LightCyan" height="25" class="ver-m">SET</td>					
					<td width="440" align="center" bordercolorlight="LightCyan" height="25" class="ver-m">DEFICIENT LEARNING OBJECTIVES</td>					
					<td width="70" align="center" bordercolorlight="LightCyan" height="25" class="ver-m">I</td>					
					<td width="65" align="center" bordercolorlight="LightCyan" height="25" class="ver-m">Q</td>				
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
							<td bordercolorlight="LightCyan" height="100" class="ver-m"><br><br>&nbsp;Not available ' for interim tests.<br>&nbsp;Thank you for your continuous concern and encouragement for your child＇s success.<br><br></td>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
						</tr>
				<#else>
					<#if sderrtotsum = 0>
						<tr>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
							<td align="center" bordercolorlight="LightCyan" height="100" class="ver-m">&nbsp;</td>
							<td bordercolorlight="LightCyan" height="100" class="ver-m">
							<br><br>&nbsp;The student has completed the interim test without any errors.
							<br>&nbsp;Additionally, constant help and support from parents are essential
							<br>&nbsp;for your child’s academic performance.<br><br></td>
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
					<td colspan=9 height="20" class="ver-m"><font size=2.5><b><strong>Progress Status (Monthly Preview)</strong></b></font></td>				
				</tr>
			</table>
			<table border="1" cellspacing="0" cellpadding="0" width="640" bordercolorlight="LightCyan">
				<tr>
					<td width="35" align="center" bordercolorlight="LightCyan" height="20" class="ver-m">M/W</td>					
					<td width="35" align="center" bordercolorlight="LightCyan" height="20" class="ver-m">SET</td>					
					<td width=570 align="center" bordercolorlight="LightCyan" height="20" class="ver-m">LEARNING OBJECTIVES</td>				
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
					<td colspan="9" height="20" class="ver-m"><b><font size=2.5><strong>To JEI Parents</strong></font></b></td>
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
