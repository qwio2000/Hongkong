<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="content">
		<h2 class="conTit">Adjustment</h2>
		<div class="list02 pt20">
			<select name="jindoGubun" id="jindoGubunAdmin" style="width:365px">
				<option value="40" selected>Review</option>
				<option value="41">Skip week</option>
			</select>
		</div>
		<div class="clearfix mb60">
			<div class="conLeft2">
				<div class="tbl01"  style="height:529px;overflow-y:auto;">
					<table>
						<colgroup>
							<col width="100px" />
							<col width="100px "/>
							<col width="100px" />
							<col width="100px" />
							<col width="100px" />
							<col width="100px" />
						</colgroup>
						<thead>
							<tr>
								<th>Year/Month</th>
								<th>1W</th>
								<th>2W</th>
								<th>3W</th>
								<th>4W</th>
								<th>5W</th>
							</tr>
						</thead>
						<tbody>
						<#if adjustmentList?has_content>
							<#list adjustmentList as listIndex>
								<tr>
									<#assign yy = listIndex.yy><#assign mm = listIndex.mm>
									<td>${yy }/${mm }</td>
									<td>
										
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb1${listIndex_index }" onclick="javascript:$.getOnchangebokwkAdmin('${yy}','${mm}','1','${listIndex.juset1}','${jisaCD}','${subj}','${listIndex.jusetDung1}');" >
												<label class="radio_label" style="display:inline" for="wb1${listIndex_index }" > ${listIndex.juset1 }</label>
											</span>
										
									</td>
									<td>
										
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb2${listIndex_index }" onclick="javascript:$.getOnchangebokwkAdmin('${yy}','${mm}','2','${listIndex.juset2}','${jisaCD}','${subj}','${listIndex.jusetDung2}');" >
												<label class="radio_label" style="display:inline" for="wb2${listIndex_index }"> ${listIndex.juset2 }</label>
											</span>
										
									</td>
									<td>
										
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb3${listIndex_index }" onclick="javascript:$.getOnchangebokwkAdmin('${yy}','${mm}','3','${listIndex.juset3}','${jisaCD}','${subj}','${listIndex.jusetDung3}');" >
												<label class="radio_label" style="display:inline" for="wb3${listIndex_index }"> ${listIndex.juset3 }</label>
											</span>
									
									</td>
									<td>
										
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb4${listIndex_index }" onclick="javascript:$.getOnchangebokwkAdmin('${yy}','${mm}','4','${listIndex.juset4}','${jisaCD}','${subj}','${listIndex.jusetDung4}');" >
												<label class="radio_label" style="display:inline" for="wb4${listIndex_index }"> ${listIndex.juset4 }</label>
											</span>
										
									</td>
									<td>
										
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb5${listIndex_index }" onclick="javascript:$.getOnchangebokwkAdmin('${yy}','${mm}','5','${listIndex.juset5}','${jisaCD}','${subj}','${listIndex.jusetDung5}');" >
												<label class="radio_label" style="display:inline" for="wb5${listIndex_index }"> ${listIndex.juset5 }</label>
											</span>
										
									</td>
								</tr>
							</#list>
						<#else>
							<tr>
									<#assign yy = ayy><#assign mm = amm>
									<td>${yy }/${mm }</td>
									<td>
										<span class="radio_wrap">
											<input type="radio" value="wb" name="wb" id="wb10" onclick="javascript:$.getOnchangebokwkAdmin('${yy}','${mm}','1','','${jisaCD}','${subj}','');" >
											<label class="radio_label" style="display:inline" for="wb10" > </label>
										</span>
									</td>
									<td>
										<span class="radio_wrap">
											<input type="radio" value="wb" name="wb" id="wb11" onclick="javascript:$.getOnchangebokwkAdmin('${yy}','${mm}','2','','${jisaCD}','${subj}','');" >
											<label class="radio_label" style="display:inline" for="wb11" > </label>
										</span>
									</td>
									<td>
										<span class="radio_wrap">
											<input type="radio" value="wb" name="wb" id="wb12" onclick="javascript:$.getOnchangebokwkAdmin('${yy}','${mm}','3','','${jisaCD}','${subj}','');" >
											<label class="radio_label" style="display:inline" for="wb12" > </label>
										</span>
									</td>
									<td>
										<span class="radio_wrap">
											<input type="radio" value="wb" name="wb" id="wb13" onclick="javascript:$.getOnchangebokwkAdmin('${yy}','${mm}','4','','${jisaCD}','${subj}','');" >
											<label class="radio_label" style="display:inline" for="wb13" > </label>
										</span>
									</td>
									<td>
										<span class="radio_wrap">
											<input type="radio" value="wb" name="wb" id="wb14" onclick="javascript:$.getOnchangebokwkAdmin('${yy}','${mm}','5','','${jisaCD}','${subj}','');" >
											<label class="radio_label" style="display:inline" for="wb14" > </label>
										</span>
									</td>
							</tr>
						</#if>
						</tbody>
					</table>
				</div>
				<ul class="list04 pt30">
					<li>
						<input type="text" class="searchInput" style="width:100px" id='pYear' readonly> &nbsp; Year &nbsp;
						<input type="text" class="searchInput" style="width:100px" id='pMonth' readonly> &nbsp; Month &nbsp;
						<input type="text" class="searchInput" style="width:100px" id='pWeek' readonly> &nbsp; Week &nbsp;
						<input type="text" class="searchInput" style="width:100px" id='pSet' readonly> &nbsp; Set &nbsp;
					</li>
					<li>
						<span class="radio_wrap">
							<input type="radio" value="B" name="bokGubun" id="bokB" onClick="javascript:$.getRefreshSet();" >
							<label class="radio_label" for="bokB" > 범위복습</label>
						</span>
						<input type="text" class="searchInput" style="width:88px" id="setB1" readonly> ~ 
						<input type="text" class="searchInput" style="width:88px" id="setB3" readonly>
					</li>
					<li>
						<span class="radio_wrap">
							<input type="radio" value="S" name="bokGubun" id="bokS" onClick="javascript:$.getRefreshSet();"  checked>
							<label class="radio_label" for="bokS" > 선택복습</label>
						</span>
						<input type="text" class="searchInput" style="width:78px" id="setS1" readonly> , 
						<input type="text" class="searchInput" style="width:78px" id="setS2" readonly> , 
						<input type="text" class="searchInput" style="width:78px" id="setS3" readonly> , 
						<input type="text" class="searchInput" style="width:78px" id="setS4" readonly> , 
						<input type="text" class="searchInput" style="width:78px" id="setS5" readonly> 
					</li>
				</ul>
			</div>
			<div class="conRight2">
				<div class="lank_list" id="listSet" >
					<dl style="height:700px;overflow-y:auto;">
						<#assign fst = ""><#assign dungs = ""><#assign dungs2 = "">
						<#list dung as dungIndex>
							<#assign dungs2 = dungIndex.dung>
							<#if  dungs != dungs2 >
										</li>
									</ul>
								</dd>
							</#if>
							
							<#if fst = "" || dungs != dungs2>
								<dt>${dungIndex.dung } GRADE</dt>
								<dd style="height:153px">
									<ul>
										<li style="line">
										<#assign fst = "1">
										<#assign dungs = dungIndex.dung>	
							</#if>
										<span onClick="$.getSetbanAdmin('${dungIndex.cas_nset}')" style="cursor:pointer">${dungIndex.cas_nset }</span>
								
										
						</#list>
								</li>
							</ul>
						</dd>
					</dl>
				</div>
			</div>

			<input type="hidden" id="jisaCD" value="${jisaCD }">
			<input type="hidden" id="memKey" value="${memKey }">
			<input type="hidden" id="subj" value="${subj }">
			<input type="hidden" id="yoil" value="${yoil }">
			<input type="hidden" id="set1" value="">
			<input type="hidden" id="set2" value="">
			<input type="hidden" id="set3" value="">
			<input type="hidden" id="set4" value="">
			<input type="hidden" id="set5" value="">
			<input type="hidden" id="alertMsg1" value="${alertMsg1 }">
			<input type="hidden" id="alertMsg2" value="${alertMsg2 }">
			<input type="hidden" id="alertMsg3" value="${alertMsg3 }">
			
			
			<div class="btnArea">
				<a href="javascript:$.getJindoSaveAdmin();"><span>Save</span></a>
				<a href="#"><span>Cancel</span></a>
			</div>
		</div>
		
	
	
</div>



<!--// Main Content -->
<#include "/include/popupfooter.ftl">
