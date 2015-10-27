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
				<input type="hidden" name="jisaCD" id="jisaCD" value="${jisaCD }">
				<input type="hidden" name="deptCD" id="deptCD" value="${deptCD }">
				<input type="hidden" name="memKey" id="memKey" value="${memKey }">
				<input type="hidden" name="subj" id="subj" value="${subj }">
				<input type="hidden" name="yy" id="yy" value="${yy }">
				<input type="hidden" name="mm" id="mm" value="${mm }">				
			</tbody>
		</table>
	</div>
	<div class="tbl01">
		<table>
			<colgroup>
				<col width="40"/>
				<col width="40"/>
				<#list 1.. 16 as juCntIndex>
					<col width="48" />		
				</#list>
				
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line">주차</th>
					<th>진도</th>

					<#list noArrer as noArrerIndex>
					<th>${noArrerIndex}</th>					
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
							<#if wolJinDo1Index.wkseq?number = 1>
								<#assign wolJinDo1Cnt = wolJinDo1Cnt+1>
								<#if wolJinDo1Index.setques == "01"><td>${wolJinDo1Index.wbset }</td><#assign wolJinDo1Cnt = wolJinDo1Cnt+1></#if>
								<td>
									<select name="setsubq11${wolJinDo1Index_index }" id="setsubq11${wolJinDo1Index_index }" style="width:50px">
									<#list 0.. wolJinDo1Index.setsubq?number as setsubqIndex>
										<option value="${wolJinDo1Index.wk },${wolJinDo1Index.wkseq },${wolJinDo1Index.setques },${wolJinDo1Index.setsubq },${setsubqIndex_index}">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo1Cnt < 19>	
								<#list wolJinDo1Cnt+1.. 19 as rowIndex>
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
							<#if wolJinDo1Index.wkseq?number = 2>
								<#assign wolJinDo1Cnt = wolJinDo1Cnt+1>
								<#if wolJinDo1Index.setques == "01"><td>${wolJinDo1Index.wbset }</td><#assign wolJinDo1Cnt = wolJinDo1Cnt+1></#if>
								<td>
									<select name="setsubq12${wolJinDo1Index_index }" id="setsubq12${wolJinDo1Index_index }" style="width:50px">
									<#list 0.. wolJinDo1Index.setsubq?number as setsubqIndex>
										<option value="${wolJinDo1Index.wk },${wolJinDo1Index.wkseq },${wolJinDo1Index.setques },${wolJinDo1Index.setsubq },${setsubqIndex_index}">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo1Cnt < 19>	
								<#list wolJinDo1Cnt+1.. 19 as rowIndex>
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
				
				<!-- 2주차 -->
				<tr class="line2">
					<td class="no_line" rowspan="2">${mm }/2</td>
					<#if wolJinDo2??>
						<#assign wolJinDo2Cnt = 0>
						<#list wolJinDo2 as wolJinDo2Index>							
							<#if wolJinDo2Index.wkseq?number = 1>
								<#assign wolJinDo2Cnt = wolJinDo2Cnt+1>
								<#if wolJinDo2Index.setques == "01"><td>${wolJinDo2Index.wbset }</td><#assign wolJinDo2Cnt = wolJinDo2Cnt+1></#if>
								<td>
									<select name="setsubq21${wolJinDo2Index_index }" id="setsubq21${wolJinDo2Index_index }" style="width:50px">
									<#list 0.. wolJinDo2Index.setsubq?number as setsubqIndex>
										<option value="${wolJinDo2Index.wk },${wolJinDo2Index.wkseq },${wolJinDo2Index.setques },${wolJinDo2Index.setsubq },${setsubqIndex_index}">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo2Cnt < 19>	
								<#list wolJinDo2Cnt+1.. 19 as rowIndex>
								<td></td>
								</#list>	
							</#if>
					<#else>
						<#if wolJinDo2Cnt < 19>	
							<#list wolJinDo2Cnt+1.. 19 as rowIndex>
							<td></td>
							</#list>	
						</#if>
					</#if>
				</tr>
				<tr class="line2">
					<#if wolJinDo2??>
						<#assign wolJinDo2Cnt = 0>
						<#list wolJinDo2 as wolJinDo2Index>							
							<#if wolJinDo2Index.wkseq?number = 2>
								<#assign wolJinDo2Cnt = wolJinDo2Cnt+1>
								<#if wolJinDo2Index.setques == "01"><td>${wolJinDo2Index.wbset }</td><#assign wolJinDo2Cnt = wolJinDo2Cnt+1></#if>
								<td>
									<select name="setsubq22${wolJinDo2Index_index }" id="setsubq22${wolJinDo2Index_index }" style="width:50px">
									<#list 0.. wolJinDo2Index.setsubq?number as setsubqIndex>
										<option value="${wolJinDo2Index.wk },${wolJinDo2Index.wkseq },${wolJinDo2Index.setques },${wolJinDo2Index.setsubq },${setsubqIndex_index}">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo2Cnt < 19>	
								<#list wolJinDo2Cnt+1.. 19 as rowIndex>
								<td></td>
								</#list>	
							</#if>
					<#else>
						<#if wolJinDo2Cnt < 19>	
							<#list wolJinDo2Cnt+1.. 19 as rowIndex>
							<td></td>
							</#list>	
						</#if>
					</#if>
				</tr>	
				
				<!-- 3주차 -->
				<tr class="line2">
					<td class="no_line" rowspan="2">${mm }/3</td>
					<#if wolJinDo3??>
						<#assign wolJinDo3Cnt = 0>
						<#list wolJinDo3 as wolJinDo3Index>							
							<#if wolJinDo3Index.wkseq?number = 1>
								<#assign wolJinDo3Cnt = wolJinDo3Cnt+1>
								<#if wolJinDo3Index.setques == "01"><td>${wolJinDo3Index.wbset }</td><#assign wolJinDo3Cnt = wolJinDo3Cnt+1></#if>
								<td>
									<select name="setsubq31${wolJinDo3Index_index }" id="setsubq31${wolJinDo3Index_index }" style="width:50px">
									<#list 0.. wolJinDo3Index.setsubq?number as setsubqIndex>
										<option value="${wolJinDo3Index.wk },${wolJinDo3Index.wkseq },${wolJinDo3Index.setques },${wolJinDo3Index.setsubq },${setsubqIndex_index}">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo3Cnt < 19>	
								<#list wolJinDo3Cnt+1.. 19 as rowIndex>
								<td></td>
								</#list>	
							</#if>
					<#else>
						<#if wolJinDo3Cnt < 19>	
							<#list wolJinDo3Cnt+1.. 19 as rowIndex>
							<td></td>
							</#list>	
						</#if>
					</#if>
				</tr>
				<tr class="line2">
					<#if wolJinDo3??>
						<#assign wolJinDo3Cnt = 0>
						<#list wolJinDo3 as wolJinDo3Index>							
							<#if wolJinDo3Index.wkseq?number = 2>
								<#assign wolJinDo3Cnt = wolJinDo3Cnt+1>
								<#if wolJinDo3Index.setques == "01"><td>${wolJinDo3Index.wbset }</td><#assign wolJinDo3Cnt = wolJinDo3Cnt+1></#if>
								<td>
									<select name="setsubq32${wolJinDo3Index_index }" id="setsubq32${wolJinDo3Index_index }" style="width:50px">
									<#list 0.. wolJinDo3Index.setsubq?number as setsubqIndex>
										<option value="${wolJinDo3Index.wk },${wolJinDo3Index.wkseq },${wolJinDo3Index.setques },${wolJinDo3Index.setsubq },${setsubqIndex_index}">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo3Cnt < 19>	
								<#list wolJinDo3Cnt+1.. 19 as rowIndex>
								<td></td>
								</#list>	
							</#if>
					<#else>
						<#if wolJinDo3Cnt < 19>	
							<#list wolJinDo3Cnt+1.. 19 as rowIndex>
							<td></td>
							</#list>	
						</#if>
					</#if>
				</tr>
					
				<!-- 4주차 -->
				<tr class="line2">
					<td class="no_line" rowspan="2">${mm }/3</td>
					<#if wolJinDo4??>
						<#assign wolJinDo4Cnt = 0>
						<#list wolJinDo4 as wolJinDo4Index>							
							<#if wolJinDo4Index.wkseq?number = 1>
								<#assign wolJinDo4Cnt = wolJinDo4Cnt+1>
								<#if wolJinDo4Index.setques == "01"><td>${wolJinDo4Index.wbset }</td><#assign wolJinDo4Cnt = wolJinDo4Cnt+1></#if>
								<td>
									<select name="setsubq41${wolJinDo4Index_index }" id="setsubq41${wolJinDo4Index_index }" style="width:50px">
									<#list 0.. wolJinDo4Index.setsubq?number as setsubqIndex>
										<option value="${wolJinDo4Index.wk },${wolJinDo4Index.wkseq },${wolJinDo4Index.setques },${wolJinDo4Index.setsubq },${setsubqIndex_index}">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo4Cnt < 19>	
								<#list wolJinDo4Cnt+1.. 19 as rowIndex>
								<td></td>
								</#list>	
							</#if>
					<#else>
						<#if wolJinDo4Cnt < 19>	
							<#list wolJinDo4Cnt+1.. 19 as rowIndex>
							<td></td>
							</#list>	
						</#if>
					</#if>
				</tr>
				<tr class="line2">
					<#if wolJinDo4??>
						<#assign wolJinDo4Cnt = 0>
						<#list wolJinDo4 as wolJinDo4Index>							
							<#if wolJinDo4Index.wkseq?number = 2>
								<#assign wolJinDo4Cnt = wolJinDo4Cnt+1>
								<#if wolJinDo4Index.setques == "01"><td>${wolJinDo4Index.wbset }</td><#assign wolJinDo4Cnt = wolJinDo4Cnt+1></#if>
								<td>
									<select name="setsubq42${wolJinDo4Index_index }" id="setsubq42${wolJinDo4Index_index }" style="width:50px">
									<#list 0.. wolJinDo4Index.setsubq?number as setsubqIndex>
										<option value="${wolJinDo4Index.wk },${wolJinDo4Index.wkseq },${wolJinDo4Index.setques },${wolJinDo4Index.setsubq },${setsubqIndex_index}">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo4Cnt < 19>	
								<#list wolJinDo4Cnt+1.. 19 as rowIndex>
								<td></td>
								</#list>	
							</#if>
					<#else>
						<#if wolJinDo4Cnt < 19>	
							<#list wolJinDo4Cnt+1.. 19 as rowIndex>
							<td></td>
							</#list>	
						</#if>
					</#if>
				</tr>	
				
				<!-- 5주차 -->
				<tr class="line2">
					<td class="no_line" rowspan="2">${mm }/3</td>
					<#if wolJinDo5??>
						<#assign wolJinDo5Cnt = 0>
						<#list wolJinDo5 as wolJinDo5Index>							
							<#if wolJinDo5Index.wkseq?number = 1>
								<#assign wolJinDo5Cnt = wolJinDo5Cnt+1>
								<#if wolJinDo5Index.setques == "01"><td>${wolJinDo5Index.wbset }</td><#assign wolJinDo5Cnt = wolJinDo5Cnt+1></#if>
								<td>
									<select name="setsubq51${wolJinDo5Index_index }" id="setsubq51${wolJinDo5Index_index }" style="width:50px">
									<#list 0.. wolJinDo5Index.setsubq?number as setsubqIndex>
										<option value="${wolJinDo5Index.wk },${wolJinDo5Index.wkseq },${wolJinDo5Index.setques },${wolJinDo5Index.setsubq },${setsubqIndex_index}">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo5Cnt < 19>	
								<#list wolJinDo5Cnt+1.. 19 as rowIndex>
								<td></td>
								</#list>	
							</#if>
					<#else>
						<#if wolJinDo5Cnt < 19>	
							<#list wolJinDo5Cnt+1.. 19 as rowIndex>
							<td></td>
							</#list>	
						</#if>
					</#if>
				</tr>
				<tr class="line2">
					<#if wolJinDo5??>
						<#assign wolJinDo5Cnt = 0>
						<#list wolJinDo5 as wolJinDo5Index>							
							<#if wolJinDo5Index.wkseq?number = 2>
								<#assign wolJinDo5Cnt = wolJinDo5Cnt+1>
								<#if wolJinDo5Index.setques == "01"><td>${wolJinDo5Index.wbset }</td><#assign wolJinDo5Cnt = wolJinDo5Cnt+1></#if>
								<td>
									<select name="setsubq52${wolJinDo5Index_index }" id="setsubq52${wolJinDo5Index_index }" style="width:50px">
									<#list 0.. wolJinDo5Index.setsubq?number as setsubqIndex>
										<option value="${wolJinDo5Index.wk },${wolJinDo5Index.wkseq },${wolJinDo5Index.setques },${wolJinDo5Index.setsubq },${setsubqIndex_index}">${setsubqIndex_index }</option>
									</#list>
									</select>
								</td>
							</#if>
						</#list>
							<#if wolJinDo5Cnt < 19>	
								<#list wolJinDo5Cnt+1.. 19 as rowIndex>
								<td></td>
								</#list>	
							</#if>
					<#else>
						<#if wolJinDo5Cnt < 19>	
							<#list wolJinDo5Cnt+1.. 19 as rowIndex>
							<td></td>
							</#list>	
						</#if>
					</#if>
				</tr>		
					
			</tbody>
		</table>
	</div>
	<div id="odabs"></div>
	<div class="btnArea">
		<a href="javascript:$.getSDInput();"><span>Save</span></a>
		<a href="#"><span>Close</span></a>
	</div>
</div>




<!--// Main Content -->
<#include "/include/footer.ftl">
