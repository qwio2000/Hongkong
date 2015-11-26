<#include "/include/header.ftl">
<#macro zeroNonDisplay arg>
	<#if arg != 0>
		${arg }
	</#if>
</#macro>
<!-- Main Content -->
<div class="content">
	<form id="searchForm" name="searchForm" action="/ja/members/analysis/subject" method="GET">	
	<input type="hidden" id="searchYYMM" name="searchYYMM" value="${.now?string('yyyy-MM') }"/>
	<ul class="memSearch">
		<li>
			<label for=""><a href="javascript:;" onClick="$.openDeptSearch();">조직찾기</a></label>
			<input type="text" name="deptName" id="deptName" value="${deptName }" class="searchInput" style="width:230px" onClick="$.openDeptSearch();" readOnly />
			<input type="hidden" name="deptCD" id="deptCD" value="${deptCD }">
		</li>
		<li>
			<label for="searchYY">검색기간</label>
			<select name="searchYY" id="searchYY" style="width:242px">
			<#list years as year>
				<option value="${year }" <#if searchYY == year>selected</#if>>${year }</option>
			</#list>
			</select>
		</li>
	</ul>
	<div class="btnArea">
		<a id="subjectReportSubmit" href="javascript:;"><span>검색</span></a>
		<a id="subjectReportInit" href="javascript:;"><span style="width:110px">Reset</span></a>
	</div>	
	</form>
	<h2 class="conTit">Members by Programs</h2>
	<div class="tbl01">
		<table>
			<thead>
				<tr class="line">
					<th rowspan="2"  class="no_line" style="width:72px">Program</th>
					<#list displayYears as disYear>
						<th colspan="12">${disYear }</th>
					</#list>
				</tr>
				<tr class="line bg_gray">
				<#list 1..2 as i>
					<#list months as month>
						<th style="width:38px">${month.monthStr }</th>
					</#list>
				</#list>
				</tr>
			</thead>
			<tbody>
			<#list subjectReport as report>
				<#if report.subj != 'TT'>
				<tr class="line2">
					<th class="no_line no_left">${report.subjShortName }</th>
					<td><@zeroNonDisplay report.prevMgMM01/></td>
					<td><@zeroNonDisplay report.prevMgMM02/></td>
					<td><@zeroNonDisplay report.prevMgMM03/></td>
					<td><@zeroNonDisplay report.prevMgMM04/></td>
					<td><@zeroNonDisplay report.prevMgMM05/></td>
					<td><@zeroNonDisplay report.prevMgMM06/></td>
					<td><@zeroNonDisplay report.prevMgMM07/></td>
					<td><@zeroNonDisplay report.prevMgMM08/></td>
					<td><@zeroNonDisplay report.prevMgMM09/></td>
					<td><@zeroNonDisplay report.prevMgMM10/></td>
					<td><@zeroNonDisplay report.prevMgMM11/></td>
					<td><@zeroNonDisplay report.prevMgMM12/></td>
					<td><@zeroNonDisplay report.mgMM01/></td>
					<td><@zeroNonDisplay report.mgMM02/></td>
					<td><@zeroNonDisplay report.mgMM03/></td>
					<td><@zeroNonDisplay report.mgMM04/></td>
					<td><@zeroNonDisplay report.mgMM05/></td>
					<td><@zeroNonDisplay report.mgMM06/></td>
					<td><@zeroNonDisplay report.mgMM07/></td>
					<td><@zeroNonDisplay report.mgMM08/></td>
					<td><@zeroNonDisplay report.mgMM09/></td>
					<td><@zeroNonDisplay report.mgMM10/></td>
					<td><@zeroNonDisplay report.mgMM11/></td>
					<td><@zeroNonDisplay report.mgMM12/></td>
				</tr>
				</#if>
			</#list>
			<#list subjectReport as report>
				<#if report.subj == 'TT'>
				<tr class="line2 total">
					<th class="no_line">${report.subjShortName }</th>
					<td>${report.prevMgMM01}</td>
					<td>${report.prevMgMM02}</td>
					<td>${report.prevMgMM03}</td>
					<td>${report.prevMgMM04}</td>
					<td>${report.prevMgMM05}</td>
					<td>${report.prevMgMM06}</td>
					<td>${report.prevMgMM07}</td>
					<td>${report.prevMgMM08}</td>
					<td>${report.prevMgMM09}</td>
					<td>${report.prevMgMM10}</td>
					<td>${report.prevMgMM11}</td>
					<td>${report.prevMgMM12}</td>
					<td>${report.mgMM01}</td>
					<td>${report.mgMM02}</td>
					<td>${report.mgMM03}</td>
					<td>${report.mgMM04}</td>
					<td>${report.mgMM05}</td>
					<td>${report.mgMM06}</td>
					<td>${report.mgMM07}</td>
					<td>${report.mgMM08}</td>
					<td>${report.mgMM09}</td>
					<td>${report.mgMM10}</td>
					<td>${report.mgMM11}</td>
					<td>${report.mgMM12}</td>
				</tr>
				</#if>
			</#list>
			</tbody>
		</table>
	</div>
	<h2 class="conTit">Subject Report</h2>
	<div class="list02 pt20 clearfix">
		<div class="float_l">
			Compare to past 
			<select name="pastMonth" id="pastMonth" style="width:80px">
				<option value="0"></option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
			</select>
			month(s) &nbsp;&nbsp;
			<span class="btnArea mt0"><a href="javascript:;" id="subjectReportBtn"><span style="width:70px">Run</span></a></span>
		</div>

	</div>
	<div class="tbl01 mt5">
		<table>
			<colgroup>
				<col width="40px"/>
				<col />
				<col />
				<#list subjs as subj>
					<col width="50px"/>
				</#list>
				<col width="80px"/>
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line" style="width:40px"></th>
					<th colspan="2">Center Name</th>
					<#list subjs as subj>
						<th style="width:50px">${subj }</th>
					</#list>
					<th style="width:80px">Total</th>
				</tr>
			</thead>
			<tbody id="mainContent">
			</tbody>
		</table>
	</div>
</div>
<!--// Main Content -->
<script id="subjReportTemplate" type="text/x-handlebars-template">
	{{#each subjReports}}
		{{#if @last}}
			<tr class="line2 total">
				<td colspan="3" class="no_line">TOTAL</td>
			{{#each splitAry}}
				<td>{{this}} <br /><span class="f_small">({{getRate ../totEnd this}}%)</span></td>
			{{/each}}
				<td>{{totEnd}}</td>
			</tr>
		{{else}}
			<tr class="line2">
				<td class="no_line">{{inc @index}}</td>
				<td class="left">{{deptName}}</td>
				<td class="no_line left" style="width:60px">{{mgYYMM}}</td>
			{{#each splitAry}}
				<td>{{zeroNonDisplay this}}</td>
			{{/each}}
				<td class="col_gray">{{totEnd}}</td>
			</tr>
			{{#if subs}}
				{{#each subs}}
					<tr class="line2">
						<td colspan="2"  class="no_line"></td>
						<td  class="no_line rel_line left">{{mgYYMM}}</td>
					{{#each splitAry}}
						<td>{{zeroNonDisplay this}}</td>
					{{/each}}
						<td class="col_gray">{{totEnd}}</td>
					</tr>
				{{/each}}
			{{/if}}
		{{/if}}
	{{else}}
		<tr>
			<td colspan="16">no search results</td>
		</tr>
	{{/each}}
</script>
<#include "/include/footer.ftl">
