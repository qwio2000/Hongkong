<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="content">
		<h2 class="conTit">Adjustment</h2>
		<div class="list02 pt20">
			<select name="jindoGubun" id="jindoGubun" style="width:365px">
				<option value="40">Review</option>
				<option value="41" selected>Skip week</option>
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
												<input type="radio" value="wb" name="wb" id="wb1${listIndex_index }" onclick="javascript:$.getOnchangedangwk('${yy}','${mm}','1','${listIndex.juset1}','${jisaCD}','${subj}','${listIndex.jusetDung1}');" >
												<label class="radio_label" for="wb1${listIndex_index }" > ${listIndex.juset1 }</label>
											</span>
										<#else>
											${listIndex.juset1 }
										</#if>
									</td>
									<td>
										<#if listIndex.juset2YN == "Y">
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb2${listIndex_index }" onclick="javascript:$.getOnchangedangwk('${yy}','${mm}','2','${listIndex.juset2}','${jisaCD}','${subj}','${listIndex.jusetDung2}');" >
												<label class="radio_label" for="wb2${listIndex_index }"> ${listIndex.juset2 }</label>
											</span>
										<#else>
											${listIndex.juset2 }
										</#if>
									</td>
									<td>
										<#if listIndex.juset3YN == "Y">
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb3${listIndex_index }" onclick="javascript:$.getOnchangedangwk('${yy}','${mm}','3','${listIndex.juset3}','${jisaCD}','${subj}','${listIndex.jusetDung3}');" >
												<label class="radio_label" for="wb3${listIndex_index }"> ${listIndex.juset3 }</label>
											</span>
										<#else>
											${listIndex.juset3 }
										</#if>
									</td>
									<td>
										<#if listIndex.juset4YN == "Y">
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb4${listIndex_index }" onclick="javascript:$.getOnchangedangwk('${yy}','${mm}','4','${listIndex.juset4}','${jisaCD}','${subj}','${listIndex.jusetDung4}');" >
												<label class="radio_label" for="wb4${listIndex_index }"> ${listIndex.juset4 }</label>
											</span>
										<#else>
											${listIndex.juset4 }
										</#if>
									</td>
									<td>
										<#if listIndex.juset5YN == "Y">
											<span class="radio_wrap">
												<input type="radio" value="wb" name="wb" id="wb5${listIndex_index }" onclick="javascript:$.getOnchangedangwk('${yy}','${mm}','5','${listIndex.juset5}','${jisaCD}','${subj}','${listIndex.jusetDung5}');" >
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
				</ul>
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
			
			
			<div class="btnArea">
				<a href="javascript:$.getJindoSave();"><span>Save</span></a>
				<a href="#"><span>Cancel</span></a>
			</div>
		</div>
		
	
	
</div>



<!--// Main Content -->
<#include "/include/popupfooter.ftl">
