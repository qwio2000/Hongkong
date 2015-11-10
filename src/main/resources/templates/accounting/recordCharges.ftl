<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Record Charges</h2>
	<div class="list02 pt20 clearfix">
		<div class="float_l">
			Input Month : April 2015
		</div>
	</div>
	<ul class="list05 mt10">
		<li>
			<label for="" class="tit">JEI New York Branch</label>
			<div class="input_col">
				<select name="" id="" style="width:180px">
					<option value="">Royalty Credit/Debit</option>
				</select>
			</div>
			<div class="input_col">
				<input type="text" class="searchInput" style="width:90px">
				<a href="#" class="btn_calendar">view calendar</a>
			</div>
			<div class="input_col">
				$ <input type="text" class="searchInput" style="width:70px">
			</div>
			<div class="input_col">
				<input type="text" class="searchInput" style="width:140px">
			</div>
			<div class="input_col_last">
				<div class="tbl_btn">
					<span class="btnArea"><a href="#"><span style="width:95px">Add Charge</span></a></span>
					<span class="btnArea"><a href="#" class="btn_list" data-rel="record1"><span style="width:40px">View</span></a></span>
				</div>
			</div>
		</li>
		<li style="display:none" class="record1">
			<div class="tbl01 mt0 pb10">
				<table>
					<colgroup>
						<col style="width:35px" />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col style="width:100px" />
					</colgroup>
					<thead>
						<tr class="line">
							<th class="no_line"></th>
							<th>Royalty <br />Credit / Debit</th>
							<th>Chargeable <br />Items</th>
							<th>Freight</th>
							<th>LateFee</th>
							<th>Other <br />Credit / Debit</th>
							<th>Tax Allocation <br />Credit</th>
							<th>Minimum Royalty <br />Charge</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<tr class="line2">
							<td class="no_line">
								<a href="#" class="btn_icon_one btn_doc2">View detail</a>
							</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td class="col_gray">$0.00</td>
						</tr>
					</tbody>
				</table>
			</div>
		</li>
		<li>
			<label for="" class="tit">Austin</label>
			<div class="input_col">
				<select name="" id="" style="width:180px">
					<option value="">Royalty Credit/Debit</option>
				</select>
			</div>
			<div class="input_col">
				<input type="text" class="searchInput" style="width:90px">
				<a href="#" class="btn_calendar">view calendar</a>
			</div>
			<div class="input_col">
				$ <input type="text" class="searchInput" style="width:70px">
			</div>
			<div class="input_col">
				<input type="text" class="searchInput" style="width:140px">
			</div>
			<div class="input_col_last">
				<div class="tbl_btn">
					<span class="btnArea"><a href="#"><span style="width:95px">Add Charge</span></a></span>
					<span class="btnArea"><a href="#" class="btn_list" data-rel="record2"><span style="width:40px">View</span></a></span>
				</div>
			</div>
		</li>
		<li style="display:none" class="record2">
			<div class="tbl01 mt0 pb10">
				<table>
					<colgroup>
						<col style="width:35px" />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col style="width:100px" />
					</colgroup>
					<thead>
						<tr class="line">
							<th class="no_line"></th>
							<th>Royalty <br />Credit / Debit</th>
							<th>Chargeable <br />Items</th>
							<th>Freight</th>
							<th>LateFee</th>
							<th>Other <br />Credit / Debit</th>
							<th>Tax Allocation <br />Credit</th>
							<th>Minimum Royalty <br />Charge</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<tr class="line2">
							<td class="no_line">
								<a href="#" class="btn_icon_one btn_doc2">View detail</a>
							</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td>$0.00</td>
							<td class="col_gray">$0.00</td>
						</tr>
					</tbody>
				</table>
			</div>
		</li>
	</ul>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		//view버튼 클릭시 data-rel 속성에 있는 클래스 값을 가진 tr을 나타냄
		$('.btn_list').click(function(e){
			viewRecord($(this), $(this).attr('data-rel'))
		});
	});
	function viewRecord(btn, tr_class){
		var tr = $('.'+tr_class);
		if(tr.css('display') == 'none'){
			btn.addClass('on');
			tr.attr('style','');
		}else{
			btn.removeClass('on');
			tr.css('display','none');
		}
	}
</script>
<!--// Main Content -->
<#include "/include/footer.ftl">
