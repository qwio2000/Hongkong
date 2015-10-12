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
	<tr>
		<td width="87" height="22" align="center" bgcolor="c7c8ca" class="style4">1.회원번호</td>
		<td width="87" align="center" bgcolor="#FFFFFF" class="style7">AA281519</td>
		<td width="87" align="center" bgcolor="c7c8ca" class="style4">4.생년월일</td>
		<td width="87" align="center" bgcolor="#FFFFFF" class="style7">2007-11-27</td>
		<td width="87" align="center" bgcolor="c7c8ca" class="style4">7.평가종류</td>
		<td width="87" align="center" bgcolor="#FFFFFF" class="style7"> ()</td>
		<td width="87" align="center" bgcolor="c7c8ca" class="style4">10.관리요일</td>
		<td width="87" align="center" bgcolor="#FFFFFF" class="style7">2 (MON)</td>
	</tr>
	<tr>
		<td height="22" align="center" bgcolor="c7c8ca" class="style4">2.성&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;명</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">김윤서 Emily Kim </td>
		<td align="center" valign="middle" bgcolor="c7c8ca" class="style4">5.실시일자</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">2015-07-20</td>
		<td align="center" bgcolor="c7c8ca" class="style4">8.선&nbsp;생&nbsp;님</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">김수정 Crystal</td>
		<td align="center" bgcolor="c7c8ca" class="style4">11.등&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;급</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">I</td>
	</tr>
	<tr>
		<td height="22" align="center" bgcolor="c7c8ca" class="style4">3.학&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;년</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">4th</td>
		<td align="center" bgcolor="c7c8ca" class="style4">6.처리일자</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">2015-07-20</td>
		<td align="center" bgcolor="c7c8ca" class="style4">9.교&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;실</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td bgcolor="c7c8ca" class="style7">&nbsp;</td>
		<td bgcolor="#FFFFFF" class="style7">&nbsp;</td>
	</tr>
	<tr>
		<td height="38" align="center" bgcolor="c7c8ca" class="style4">12.S&nbsp;/&nbsp;P&nbsp;&nbsp;&nbsp;</td>
		<td colspan="7" valign="top" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
	</tr>
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
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td width="52" align="center" bgcolor="dadbdd" class="style4">학교진도</td>
				-->
			</tr>
			<tr>
				<td colspan="7" bgcolor="#000000"></td>
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style21">10①</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style21">&nbsp;3d ÷ 1d(몫:2d,r)</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style21">1 A</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style21">32103  </td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style21">30②</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style21">&nbsp;이분모대분수의 뺄셈(R)</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style21">1 B</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style21">51052  </td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>

		</table></td>
		<td width='4' bgcolor='#ffffff'>&nbsp;</td>
		<td width='346' valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" style="border:1px; border-style:solid; border-color:#000000;">
			<tr>
				<td width="34" height="22" align="center" bgcolor="c7c8ca" class="style4">번호</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="e3e4e6" class="style4">학습목표</td>
				<td width="1" bgcolor="#000000"></td>
				<td width="26" align="center" bgcolor="e3e4e6" class="style4">영역</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td width="52" align="center" bgcolor="dadbdd" class="style4">학교진도</td>
				-->
			</tr>
			<tr>
				<td colspan="7" bgcolor="#000000"></td>
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>


			<tr height="22">
				<td align="center" bgcolor="dadbdd"><p><span class="style7">&nbsp;</span></p></td>
				<td width="1" bgcolor="#000000"></td>
				<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				<!--
				<td width="1" bgcolor="#000000"></td>
				<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
				-->
			</tr>

		</table></td>
	</tr>
</table>

<!-- 영역별 분석 -->

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
					<td height="35" align="center" bgcolor="dfe0e2" class="style7">(1)수와 연산</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">105/107</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">
						
							<img src="${imgPath}/diagnosis/bar_red.gif" height="15" border="0" align="absmiddle" width="176.4">&nbsp;<span class="style12">98</span></td>
						
					<td align="center" bgcolor="dfe0e2" class="style7">(4)확률과 통계</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">
						4/4
					</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">
						
							<img src="${imgPath}/diagnosis/bar_red.gif" height="15" border="0" align="absmiddle" width="180">&nbsp;<span class="style12">100</span>
						
					</td>
				</tr>
				<tr>
					<td height="35" align="center" bgcolor="dfe0e2" class="style7">(2)도형</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">
						36/36
					</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">
						
							<img src="${imgPath}/diagnosis/bar_red.gif" height="15" border="0" align="absmiddle" width="180">&nbsp;<span class="style12">100</span>
						
					</td>
					<td align="center" bgcolor="dfe0e2" class="style7">(5)규칙성과<br>문제해결</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">
						41/41
					</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">
						
							<img src="${imgPath}/diagnosis/bar_red.gif" height="15" border="0" align="absmiddle" width="180">&nbsp;<span class="style12">100</span>
						
					</td>
				</tr>
				<tr>
					<td height="35" align="center" bgcolor="dfe0e2" class="style7">(3)측정</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">
						34/34
					</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">
						
							<img src="${imgPath}/diagnosis/bar_red.gif" height="15" border="0" align="absmiddle" width="180">&nbsp;<span class="style12">100</span>
						
					</td>
					<td align="center" bgcolor="dfe0e2" class="style7">총계</td>
					<td align="center" bgcolor="#FFFFFF" class="style7">220/222</td>
					<td bgcolor="#FFFFFF" class="style7" style="background:#fff url(${imgPath}/diagnosis/bg_barline.gif) repeat-y 0 0;">
						<img src="${imgPath}/diagnosis/bar_blue.gif" height="15" border="0" align="absmiddle" width="178.2">&nbsp;<span class="style12">99</span>
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
	
	<tr>
		<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;이분모대분수의 뺄셈(R)(30②)</td>
		<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;I06    </td>
	</tr>
	
	<tr>
		<td align="center" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
	</tr>
	
	<tr>
		<td align="center" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
	</tr>
	
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
	
	<tr>
		<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;양의 분수의 뺄셈 (R)(30②)</td>
		<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;I06    </td>
	</tr>
	
	<tr>
		<td align="center" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
	</tr>
	
	<tr>
		<td align="center" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
	</tr>
	
</table>

<!-- 학교 진도 고려학습 -->
<!--
<br><table Celloptimize="vertical" width="696" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="ffffff">
	<tr height=5><td bgcolor='#ffffff'></td></tr>
		<td bgcolor="#ffffff" colspan=7 style="color:#000000;"><span class="style4">[학교진도 고려학습]</span> <span class="style12">해당 학기와 이전 학기 학교진도와 관련한 학습의 결손이 무엇인지 파악하여 제시하였습니다.</span></td>
	</tr>
</table>
<table Celloptimize="vertical" width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="000000">
	<tr>
		<td height="22"  align="center" bgcolor="c7c8ca" class="style4">학습목표</td>
		<td height=""  width="190" align="center" bgcolor="dadbdd" class="style4">학교 진도</td>
	</tr>

	<tr>
		<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;3d ÷ 1d(몫:2d,r)(10①)</td>
		<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;3학년 2학기 10월</td>
	</tr>
	
	<tr>
		<td align="center" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td align="" bgcolor="#FFFFFF" class="style7"></td>
	</tr>
	
	<tr>
		<td align="center" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td align="" bgcolor="#FFFFFF" class="style7"></td>
	</tr>
	
</table>
-->
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

	<tr>
		<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;피제수의 자릿값이 제수의 자릿값보다 작을 때, 몫을 잘못 처리하였거나 몫의 자리잡기를 잘못하였다.(10①)</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;DW 15</td>
		<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;H09    , H14    </td>
	</tr>
	
	<tr>
		<td align="" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;대분수에서 받아내림을 잘못 하였다.(30②)</td>
		<td align="center" bgcolor="#FFFFFF" class="style7">&nbsp;SF 02</td>
		<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;I06    </td>
	</tr>
	
	<tr>
		<td align="center" height="22" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td align="" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
	</tr>
	
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
		<td width="40%" align="right" valign="bottom" class="style4">회원번호:AA281519</td>
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
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">♣</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style12">실시등급>학습출발점 가정 등급</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style12">실시등급=학습출발점 가정 등급</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style12">실시등급<학습출발점 가정 등급</td>
	</tr>
	<tr>
		<td width="" height="22" align="" bgcolor="dadbdd"><span class="style22">&nbsp;이전 등급까지의 학습정도</span></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">♣</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">A+B의 90% 이상</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">80% 이상 90% 미만</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">80% 미만</td>
	</tr>
	<tr>
		<td width="" height="22" align="" bgcolor="dadbdd"><span class="style22">&nbsp;실시등급까지의 학습정도</span></td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">♣</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">A+B+C+D의 80% 이상</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">50% 이상 80% 미만</td>
		<td width="" align="center" bgcolor="#FFFFFF" class="style7">50% 미만</td>
	</tr>
</table>

<br>

<!-- 총평 -->


<table width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000' >
	<tr>
		<td width="40" height="80" align="center" bgcolor="#FFFFFF"><span class="style4">총평</span></td>
		<td width="656" bgcolor="#FFFFFF">
			<table width="656" border="0" align="right" cellpadding="0" cellspacing="0" bgcolor='#FFFFFF' >
				<tr>
					<td width="5"></td>
					<td class="style7">
					<span class="style4">김윤서 Emily Kim </span> 회원의 진단평가 결과 종합성취도는 99%로 <span class="style4">매우 우수합니다.</span>
					학년(나이)에 비해 <span class="style4">높은</span> 등급을 평가하였습니다.
					또한
					
					이전 등급까지의 학습정도는 <span class="style4">우수하고</span>
					
					실시등급까지의 학습정도는 <span class="style4">우수합니다.</span>
					
					<!--학교 진도의 학습정도는 <span class="style4">우수합니다.</span>-->
					
					<br>학습이 필요한 미세한 결손까지 찾아내어 알맞은 학습출발점을 제시하였습니다. 제시된 처방 프로그램에 맞게 재능스스로수학을
					성실히 진행하면 수학실력을 높일 수 있습니다.
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>



<!-- 처방프로그램 -->
<table width="696" border="0" align="center" cellpadding="0" cellspacing="0" >
	<tr>
		<td align='center' class="style23" height="22">처방 프로그램<!--<img src='./HakSys/img/title_program.gif'>--></td>
	<tr>
</table>
<table width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000'>
	<tr>
		<td width="60" height="22" align="center" bgcolor="c7c8ca" class="style4">주</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">7월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">8월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">9월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">10월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">11월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">12월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">1월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">2월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">3월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">4월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">5월</td>
		<td width="60" align="center" bgcolor="#dadbdd" class="style4">6월</td>
	</tr>
			
	<tr>
		<td width="" height="22" align="center" bgcolor="#dadbdd" class="style4">1</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7"></td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7"></td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J05</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7"></td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J14</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7"></td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7"></td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

	</tr>

	<tr>
		<td width="" height="22" align="center" bgcolor="#dadbdd" class="style4">2</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7"></td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">H14</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J06</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J10</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J15</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J19</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J총필</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

	</tr>

	<tr>
		<td width="" height="22" align="center" bgcolor="#dadbdd" class="style4">3</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7"></td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">I06</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J07</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J11</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J16</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J20</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7"></td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

	</tr>

	<tr>
		<td width="" height="22" align="center" bgcolor="#dadbdd" class="style4">4</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7"></td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J03</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J08</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J12</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J17</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J24</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7"></td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

	</tr>

	<tr>
		<td width="" height="22" align="center" bgcolor="#dadbdd" class="style4">5</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">H09</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J04</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J09</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J13</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J18</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">J총괄</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7"></td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

		<td width="" align="center" bgcolor="#FFFFFF" class="style7">&nbsp;</td>

	</tr>

</table>

<!-- 예상진도 -->
<table width="696" border="0" align="center" cellpadding="0" cellspacing="0" >
	<tr>
		<td align='center' class="style23" height="22">예상 진도<!--<img src='./HakSys/img/title_jindo.gif'>--></td>
	<tr>
</table>
<table width="696" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor='#000000'>

	<tr height=80 valign="top">
		<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>7월</td>
		<td width="90%" align="" bgcolor="#ffffff" class="style7">&nbsp;H09 :나눗셈의 도입, (두, 세 자리 수)÷(두 자리 수)(몫:한 자리 수)</td>
	</tr>

	<tr height=80 valign="top">
		<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>8월</td>
		<td width="90%" align="" bgcolor="#ffffff" class="style7">&nbsp;H14 :(네, 다섯 자리 수)÷(세 자리 수)(몫:두, 세 자리 수), 크기 비교, 미지수 구하기<br>&nbsp;I06 :분모가 다른 분수의 뺄셈(최소공배수 이용), 덧ㆍ뺄셈의 혼합셈, 응용문제<br>&nbsp;J03 :거듭제곱과 지수, 소인수분해, 십진법, 이진법<br>&nbsp;J04 :이상과 이하, 초과와 미만, 수의 범위 나타내기</td>
	</tr>

	<tr height=80 valign="top">
		<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>9월</td>
		<td width="90%" align="" bgcolor="#ffffff" class="style7">&nbsp;J05 :똑같이 쌓기, 여러 가지 모양 만들고 규칙 찾기, 규칙을 정하여 여러 가지 모양 만들기<br>&nbsp;J06 :사용된 쌓기나무의 개수, 위ㆍ앞ㆍ옆에서 본 모양 알아보기<br>&nbsp;J07 :원기둥의 인식 및 전개도, 원뿔의 인식, 회전체<br>&nbsp;J08 :원주와 원주율, 원주 구하기, 원의 넓이<br>&nbsp;J09 :원기둥의 겉넓이와 부피</td>
	</tr>

	<tr height=80 valign="top">
		<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>10월</td>
		<td width="90%" align="" bgcolor="#ffffff" class="style7">&nbsp;J10 :경우의 수, 순서가 다른 짝짓기 방법으로 경우의 수 구하기, 순서가 있는 경우의 수<br>&nbsp;J11 :수형도 그려 경우의 수 알기, 확률<br>&nbsp;J12 :자연수의 사칙혼합계산<br>&nbsp;J13 :정수의 인식(양수, 음수), 크기 비교, 순서</td>
	</tr>

	<tr height=80 valign="top">
		<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>11월</td>
		<td width="90%" align="" bgcolor="#ffffff" class="style7">&nbsp;J14 :정수의 덧셈, 뺄셈, 덧셈과 뺄셈의 혼합계산<br>&nbsp;J15 :정수의 곱셈, 나눗셈, 곱셉의 교환법칙ㆍ결합법칙, 사칙혼합계산<br>&nbsp;J16 :분수의 사칙혼합계산, 소수의 사칙혼합계산<br>&nbsp;J17 :유리수의 인식, 정수와 유리수의 관계, 크기 비교<br>&nbsp;J18 :유리수의 덧셈, 뺄셈, 덧셈과 뺄셈의 혼합계산</td>
	</tr>

	<tr height=80 valign="top">
		<td width="10%" height="22" align="center" bgcolor="dadbdd" class="style4" valign='middle'>12월</td>
		<td width="90%" align="" bgcolor="#ffffff" class="style7">&nbsp;J19 :유리수의 곱셈, 나눗셈, 사칙혼합계산<br>&nbsp;J20 :말 ↔ 식, 등식, 부등식으로 나타내기, 문자를 사용하여 식을 간단히 쓰는 방법 알기<br>&nbsp;J24 :이항과 역수를 활용한 방정식의 해, 응용문제<br>&nbsp;J총괄:J등급 총괄 평가 교재입니다.</td>
	</tr>

</table>
</center>
</body>
</html>

