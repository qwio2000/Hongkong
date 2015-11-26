<#include "/include/header.ftl">
<!-- Main Content -->
	<div class="content">
		<h2 class="conTit">Workbook Status(Center) &gt; Ship to Cerritos</h2>
		<div class="list02 pt20 clearfix">
			<div class="float_l">
				<select name="subjShip" id="subjShip" style="width:200px">
				<#if inoutreqymd?has_content>
					<#list inoutreqymd as inoutreqymdIndex>
						<#if additionalworkbook == inoutreqymdIndex.inoutreqymd>
							<option value="${inoutreqymdIndex.jisaCD },${inoutreqymdIndex.deptCD},${inoutreqymdIndex.inoutreqymd }" selected="selected">${inoutreqymdIndex.inoutreqymdt }</option>
						<#else>
							<option value="${inoutreqymdIndex.jisaCD },${inoutreqymdIndex.deptCD},${inoutreqymdIndex.inoutreqymd }">${inoutreqymdIndex.inoutreqymdt }</option>
						</#if>
							
					</#list>
				<#else>
					<option value=""></option>
				</#if>
				</select>
				<span class="btnArea mt0">
					<a href="javascript:$.getShipTCUpt('D')">
						<span style="width:285px">Delete Requests from selected Date</span>
					</a>
				</span>
			</div>
		</div>
		<div class="clearfix list02 pt20">
			<div class="float_l">
				Enter actual shipping qty and click <strong>[confirm &amp; Ship Workbook]</strong> Button.
			</div>
		</div>
		<div class="tbl01 mt5">
			<table>
				<colgroup>
					<col width="130" />
					<col width="130" />
					<col width="130" />
					<col width="100" />
					<col width="80" />
					<col />
				</colgroup>
				<thead>
					<tr>
						<th>Request Date</th>
						<th>Subject</th>
						<th>Level</th>
						<th>OrderQty</th>
						<th>ShipQty</th>
						<th>Note</th>
					</tr>
				</thead>
				<tbody>
					<#assign aidx = ""><#assign wbinoutshipSum = 0?number>
					<#list shiplist as shiplistIndex>
						<#assign aidx = shiplistIndex.aidx >
						<#assign fidx = shiplistIndex.fidx >
						<tr>
							<td>${shiplistIndex.inoutreqymdt }</td>
							<td>${shiplistIndex.subjnm }</td>
							<td>${shiplistIndex.wbname }</td>
							<td>
								<a href="javascript:$.getEditmodify('${aidx }','modify');" class="btn_modify" id="modify_${aidx }">modify</a>
								<input type="text" value="${shiplistIndex.wbinoutship }" style="width:25px" readonly class="no_line" id="OrderQty_${aidx }" />
						
								<span class="btnArea mt0" id="edit_${aidx }" style="display:none" >
									<a href="javascript:$.getEditmodify('${aidx }','edit');"><span style="width:40px">Edit</span></a>
								</span>
								
							</td>
							<td>
								<input type="text" value="${shiplistIndex.wbinoutship }" id="ShipQty_${aidx }"  aidx="${aidx }" fidx="${fidx }" style="width:25px" readonly class="no_line" />
							</td>
							<td class="left">${shiplistIndex.inoutreqnote }</td>
						</tr>
						<#assign wbinoutshipSum = wbinoutshipSum + shiplistIndex.wbinoutship?number>
					</#list>
					
					<tr class="total">
						<td></td>
						<td></td>
						<td></td>
						<td><div id="OrderQtysum">${wbinoutshipSum }</div></td>
						<td><div id="ShipQtysum">${wbinoutshipSum }</div></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div id="allset"></div>
				
		<ul class="list02 mt20">
			<li>
				<label for="" class="tit">Ship Date</label>
				<input type="text" class="searchInput" id="searchInput" style="width:180px" readonly>
				<input type="hidden" id="inOutSignYMD">
				<a href="javascript:$.getBtnCalendar();" class="btn_calendar">view calendar</a>
				<input type="hidden" id="hiddenPicker"/>
				<span class="btnArea">
					<a href="javascript:$.getShipTCUpt('U')"><span>Confirm & Ship Workbook</span></a>
				</span>
			</li>
		</ul>
	</div>
<!--// Main Content -->
<#include "/include/footer.ftl">