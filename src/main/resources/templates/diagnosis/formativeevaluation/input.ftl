<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Workbook Report</h2>
	<div class="tbl01">
		<table>
			<colgroup>
				<col width="150" />
				<col />
				<col width="150" />
				<col />
				<col width="150" />
				<col />
			</colgroup>
			<tbody>
				<tr class="line2">
					<th class="left no_line">Subject</th>
					<td class="left">${subj }</td>
					<th class="left">Member Number</th>
					<td class="left">${memKey }</td>
					<th class="left">Member Name</th>
					<td class="left">${mfstname } ${mlstname }</td>
				</tr>
				<tr class="line2">
					<th class="left no_line">YYYY/MM</th>
					<td class="left">${yy }/${mm }</td>
					<th class="left">월학습환경</th>
					<td class="left" colspan="3">
						<span class="radio_wrap"><input type="radio" value="Y" name="wolhak" id="visible1" checked=""><label class="radio_label" for="visible1"> Yes</label></span>
						<span class="radio_wrap"><input type="radio" value="N" name="wolhak" id="visible2" ><label class="radio_label" for="visible2"> No</label></span>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="tbl01">
		<table>
			<colgroup>
				<col />
				<col />
				<#list 1.. 16 as juCntIndex>
					<col width="60" />		
				</#list>
				
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line">주차</th>
					<th>진도</th>
					<#list 1.. 18 as juCntIndex>
					<th>${juCntIndex_index+1 }</th>					
					</#list>
				</tr>
			</thead>
			
			<tbody>
				<!-- 1주차 -->
				<tr class="line2">
					<td class="no_line" rowspan="2">${mm }/1</td>
					<#if wolJinDo1??>
						<#assign wolJinDo1Cnt = 0>
						<#list wolJinDo1 as wolJinDo1Index>
							<#assign wolJinDo1Cnt = wolJinDo1Index_index+1>
							<#if wolJinDo1Index.wkseq?number = 1>
								<#if wolJinDo1Index_index == 0><td>${wolJinDo1Index.wbset }</td></#if>
								<td>
									<select name="setsubq11${wolJinDo1Index_index }" id="setsubq11${wolJinDo1Index_index }" style="width:50px">
									<#list 0.. wolJinDo1Index.setsubq?number as setsubqIndex>
										<option value="">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo1Cnt < 18>	
								<#list wolJinDo1Cnt+1.. 18 as rowIndex>
								<td></td>
								</#list>	
							</#if>
					<#else>
						<#if wolJinDo1Cnt < 19>	
							<#list wolJinDo1Cnt+1.. 19 as rowIndex>
							<td></td>
							</#list>	
						</#if>
					</#if>
				</tr>
				<tr class="line2">
					<#if wolJinDo1??>
						<#assign wolJinDo1Cnt = 0>
						<#list wolJinDo1 as wolJinDo1Index>
							<#assign wolJinDo1Cnt = wolJinDo1Index_index+1>
							<#if wolJinDo1Index.wkseq?number = 2>
								<#if wolJinDo1Index_index == 0><td>${wolJinDo1Index.wbset }</td></#if>
								<td>
									<select name="setsubq12${wolJinDo1Index_index }" id="setsubq12${wolJinDo1Index_index }" style="width:50px">
									<#list 0.. wolJinDo1Index.setsubq?number as setsubqIndex>
										<option value="">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo1Cnt < 18>	
								<#list wolJinDo1Cnt+1.. 18 as rowIndex>
								<td></td>
								</#list>	
							</#if>
					<#else>
						<#if wolJinDo1Cnt < 19>	
							<#list wolJinDo1Cnt+1.. 19 as rowIndex>
							<td></td>
							</#list>	
						</#if>
					</#if>
				</tr>	
				
				
				
					
			</tbody>
		</table>
	</div>
	<div class="btnArea">
		<a href="#"><span>Save</span></a>
		<a href="#"><span>Close</span></a>
	</div>
</div>




<!--// Main Content -->
<#include "/include/footer.ftl">
