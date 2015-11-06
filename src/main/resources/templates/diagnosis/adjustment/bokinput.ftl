<#include "/include/header.ftl">
<!-- Main Content -->
<div class="content">
		<h2 class="conTit">Adjustment</h2>
		<div class="list02 pt20">
			<select name="" id="" style="width:365px">
				<option value="">Review</option>
				<option value="">Skip week</option>
			</select>
		</div>
		<div class="clearfix mb60">
			<div class="conLeft2">
				<div class="tbl01">
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
							<#list adjustmentList as listIndex>
								<tr>
									<#assign yy = listIndex.yy><#assign mm = listIndex.mm>
									<td>${listIndex.yy }/${listIndex.mm }</td>
									<td>
										<#if listIndex.juset1YN == "Y">
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb1${listIndex_index }" onclick="javascript:$.getOnchangewk('${yy}','${mm}','1','${listIndex.juset1}','${jisaCD}','${subj}','${listIndex.jusetDung1}');" >
												<label class="radio_label" for="wb1${listIndex_index }" > ${listIndex.juset1 }</label>
											</span>
										<#else>
											${listIndex.juset1 }
										</#if>
									</td>
									<td>
										<#if listIndex.juset2YN == "Y">
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb2${listIndex_index }" onclick="javascript:$.getOnchangewk('${yy}','${mm}','2','${listIndex.juset2}','${jisaCD}','${subj}','${listIndex.jusetDung2}');" >
												<label class="radio_label" for="wb2${listIndex_index }"> ${listIndex.juset2 }</label>
											</span>
										<#else>
											${listIndex.juset2 }
										</#if>
									</td>
									<td>
										<#if listIndex.juset3YN == "Y">
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb3${listIndex_index }" onclick="javascript:$.getOnchangewk('${yy}','${mm}','3','${listIndex.juset3}','${jisaCD}','${subj}','${listIndex.jusetDung3}');" >
												<label class="radio_label" for="wb3${listIndex_index }"> ${listIndex.juset3 }</label>
											</span>
										<#else>
											${listIndex.juset3 }
										</#if>
									</td>
									<td>
										<#if listIndex.juset4YN == "Y">
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb4${listIndex_index }" onclick="javascript:$.getOnchangewk('${yy}','${mm}','4','${listIndex.juset4}','${jisaCD}','${subj}','${listIndex.jusetDung4}');" >
												<label class="radio_label" for="wb4${listIndex_index }"> ${listIndex.juset4 }</label>
											</span>
										<#else>
											${listIndex.juset4 }
										</#if>
									</td>
									<td>
										<#if listIndex.juset5YN == "Y">
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb5${listIndex_index }" onclick="javascript:$.getOnchangewk('${yy}','${mm}','5','${listIndex.juset5}','${jisaCD}','${subj}','${listIndex.jusetDung5}');" >
												<label class="radio_label" for="wb5${listIndex_index }"> ${listIndex.juset5 }</label>
											</span>
										<#else>
											${listIndex.juset5 }
										</#if>
									</td>
								</tr>
							</#list>
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
						<input type="text" class="searchInput" style="width:88px" id="setB2" readonly>
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
					
				</div>
			</div>
			<div class="btnArea">
				<a href="#"><span>Save</span></a>
				<a href="#"><span>Cancel</span></a>
			</div>
		</div>
		
	
	
</div>



<!--// Main Content -->
<#include "/include/footer.ftl">
