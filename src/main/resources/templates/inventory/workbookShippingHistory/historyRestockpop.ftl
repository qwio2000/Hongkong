<#include "/include/popupheader.ftl">
<!-- Main Content -->
	<div class="popup">
		<div class="popup_top">
			<h1>${mmname } ${yy }</h1> 
			<a href="javascript:self.close();" class="btn_popup_close">close</a>
		</div>
		<div class="popup_content">
			<div class="pop_input">
				<!-- <div class="clearfix list02 pt20">
					<div class="float_l">
						<strong>Packing Ship</strong>
					</div>
				</div> -->
				<div class="tbl01 mt5">
					<table>
						<colgroup>
							<col width="110" />
							<col width="110"/>
							<col width="110"/>
							<col width="110" />
							<col width="110" />
						</colgroup>
						<thead>
							<tr>
								<th>SUBJECT</th>
								<th>SJIP</th>
								<th>RESTOCK</th>
								<th>REQUESTED</th>
								<th>TOTAL</th>
							</tr>
						</thead>
						<tbody>
							<#assign wbinoutshipSum = 0?number><#assign rewbinoutshipSum = 0?number><#assign totshipSum = 0?number>
							<#list list as listIndex>
							<tr>
								<td>${listIndex.subjname }</td>
								<td>${listIndex.inoutsignymdt }</td>
								<td>${listIndex.wbinoutship }</td>
								<td>${listIndex.rewbinoutship }</td>
								<td>${listIndex.totship }</td>
								<#assign wbinoutshipSum = wbinoutshipSum + listIndex.wbinoutship?number>
								<#assign rewbinoutshipSum = rewbinoutshipSum + listIndex.rewbinoutship?number>
								<#assign totshipSum = totshipSum + listIndex.totship?number>
							</tr>
							</#list>
							<tr class="total">
								<td colspan="2">TOTAL</td>								
								<td>${wbinoutshipSum }</td>
								<td>${rewbinoutshipSum }</td>
								<td>${totshipSum }</td>
							</tr>
							
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
<!--// Main Content -->
<#include "/include/popupfooter.ftl">