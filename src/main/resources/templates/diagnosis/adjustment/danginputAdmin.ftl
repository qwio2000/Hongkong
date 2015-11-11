<#include "/include/popupheader.ftl">
<!-- Main Content -->
<div class="content">
		<h2 class="conTit">Adjustment</h2>
		<div class="list02 pt20">
			<select name="jindoGubun" id="jindoGubunAdmin" style="width:365px">
				<option value="40">Review</option>
				<option value="41" selected>Skip week</option>
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
											<span class="chk_s01">
												<input type="checkbox" value="${listIndex.juset1 }" name="wb" id="dset${yy }${mm }1" yy="${yy }" mm="${mm }" wk="1" onclick="javascript:$.getOnchangedangwkAdmin('${yy}','${mm}','1','${listIndex.juset1}','${jisaCD}','${subj}','${listIndex.jusetDung1}');" >
												<label class="radio_label" for="dset${yy }${mm }1"><span onclick="javascript:$.getSetDelAdmin('${yy}','${mm}','1');" id="choiceset${yy }${mm }1">${listIndex.juset1 }</span></label>
											</span>
									</td>
									<td>
											<span class="chk_s01">
												<input type="checkbox" value="${listIndex.juset2 }" name="wb" id="dset${yy }${mm }2" yy="${yy }" mm="${mm }" wk="2" onclick="javascript:$.getOnchangedangwkAdmin('${yy}','${mm}','2','${listIndex.juset2}','${jisaCD}','${subj}','${listIndex.jusetDung2}');" >
												<label class="radio_label"  for="dset${yy }${mm }2"><span onclick="javascript:$.getSetDelAdmin('${yy}','${mm}','2');" id="choiceset${yy }${mm }2">${listIndex.juset2 }</span></label>
											</span>
									</td>
									<td>
											<span class="chk_s01">
												<input type="checkbox" value="${listIndex.juset3 }" name="wb" id="dset${yy }${mm }3" yy="${yy }" mm="${mm }" wk="3" onclick="javascript:$.getOnchangedangwkAdmin('${yy}','${mm}','3','${listIndex.juset3}','${jisaCD}','${subj}','${listIndex.jusetDung3}');" >
												<label class="radio_label"  for="dset${yy }${mm }3"><span onclick="javascript:$.getSetDelAdmin('${yy}','${mm}','3');" id="choiceset${yy }${mm }3">${listIndex.juset3 }</span></label>
											</span>
									</td>
									<td>
											<span class="chk_s01">
												<input type="checkbox" value="${listIndex.juset4 }" name="wb" id="dset${yy }${mm }4" yy="${yy }" mm="${mm }" wk="4" onclick="javascript:$.getOnchangedangwkAdmin('${yy}','${mm}','4','${listIndex.juset4}','${jisaCD}','${subj}','${listIndex.jusetDung4}');" >
												<label class="radio_label"  for="dset${yy }${mm }4"><span onclick="javascript:$.getSetDelAdmin('${yy}','${mm}','4');" id="choiceset${yy }${mm }4">${listIndex.juset4 }</span></label>
											</span>
									</td>
									<td>
											<span class="chk_s01">
												<input type="checkbox" value="${listIndex.juset5 }" name="wb" id="dset${yy }${mm }5" yy="${yy }" mm="${mm }" wk="5" onclick="javascript:$.getOnchangedangwkAdmin('${yy}','${mm}','5','${listIndex.juset5}','${jisaCD}','${subj}','${listIndex.jusetDung5}');" >
												<label class="radio_label"  for="dset${yy }${mm }5"><span onclick="javascript:$.getSetDelAdmin('${yy}','${mm}','5');" id="choiceset${yy }${mm }5">${listIndex.juset5 }</span></label>
											</span>
									</td>
								</tr>
							</#list>
						<#else>
								<tr>
									<#assign yy = ayy><#assign mm = amm>
									<td>${yy }/${mm }</td>
									<td>
											<span class="chk_s01">
												<input type="checkbox" value="" name="wb" id="dset${yy }${mm }1" yy="${yy }" mm="${mm }" wk="1" onclick="javascript:$.getOnchangedangwkAdmin('${yy}','${mm}','1','','${jisaCD}','${subj}','');" >
												<label class="radio_label"  for="dset${yy }${mm }1"><span onclick="javascript:$.getSetDelAdmin('${yy}','${mm}','5');" id="choiceset${yy }${mm }1"></span></label>
											</span>
									</td>
									<td>
											<span class="chk_s01">
												<input type="checkbox" value="" name="wb" id="dset${yy }${mm }2" yy="${yy }" mm="${mm }" wk="2" onclick="javascript:$.getOnchangedangwkAdmin('${yy}','${mm}','2','','${jisaCD}','${subj}','');" >
												<label class="radio_label"  for="dset${yy }${mm }2"><span onclick="javascript:$.getSetDelAdmin('${yy}','${mm}','2');" id="choiceset${yy }${mm }2"></span></label>
											</span>
									</td>
									<td>
											<span class="chk_s01">
												<input type="checkbox" value="" name="wb" id="dset${yy }${mm }3" yy="${yy }" mm="${mm }" wk="3" onclick="javascript:$.getOnchangedangwkAdmin('${yy}','${mm}','3','','${jisaCD}','${subj}','');" >
												<label class="radio_label"  for="dset${yy }${mm }3"><span onclick="javascript:$.getSetDelAdmin('${yy}','${mm}','3');" id="choiceset${yy }${mm }3"></span></label>
											</span>
									</td>
									<td>
											<span class="chk_s01">
												<input type="checkbox" value="" name="wb" id="dset${yy }${mm }4" yy="${yy }" mm="${mm }" wk="4" onclick="javascript:$.getOnchangedangwkAdmin('${yy}','${mm}','4','','${jisaCD}','${subj}','');" >
												<label class="radio_label"  for="dset${yy }${mm }4"><span onclick="javascript:$.getSetDelAdmin('${yy}','${mm}','4');" id="choiceset${yy }${mm }4"></span></label>
											</span>
									</td>
									<td>
											<span class="chk_s01">
												<input type="checkbox" value="" name="wb" id="dset${yy }${mm }5" yy="${yy }" mm="${mm }" wk="5" onclick="javascript:$.getOnchangedangwkAdmin('${yy}','${mm}','5','','${jisaCD}','${subj}','');" >
												<label class="radio_label"  for="dset${yy }${mm }5"><span onclick="javascript:$.getSetDelAdmin('${yy}','${mm}','5');" id="choiceset${yy }${mm }5"></span></label>
											</span>
									</td>
								</tr>
						</#if>
						</tbody>
					</table>
				</div>
				<ul class="list04 pt30">
					<li>
						<input type="hidden" class="searchInput" style="width:100px" id='minYear' readonly>
						<input type="hidden" class="searchInput" style="width:100px" id='minMonth' readonly>
						<input type="hidden" class="searchInput" style="width:100px" id='minWeek' readonly>
						
						<input type="text" class="searchInput" style="width:100px" id='pYear' readonly> &nbsp; Year &nbsp;
						<input type="text" class="searchInput" style="width:100px" id='pMonth' readonly> &nbsp; Month &nbsp;
						<input type="text" class="searchInput" style="width:100px" id='pWeek' readonly> &nbsp; Week &nbsp;
						<input type="hidden" class="searchInput" style="width:100px" id='pSet' readonly>
						
						
						<div id="allset" style="display:none"></div>
					</li>
				</ul>
			</div>
			
			<div class="conRight2">
				<div class="lank_list" id="listSet" >
					<dl style="height:600px;overflow-y:auto;">
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
										<span onClick="$.getSetbanDangAdmin('${dungIndex.cas_nset }')" style="cursor:pointer">${dungIndex.cas_nset }</span>
								
										
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
