<#include "/include/header.ftl">

<!-- Main Content -->
<div class="content">
	<h2 class="conTit">Record Payment</h2>
	<div class="list02 pt20 clearfix">
		<div class="float_l">
			Input Month : January 2015
		</div>
	</div>
	<div class="tbl01 mt5">
		<table>
			<colgroup>
				<col width="155" />
				<col />
				<col width="116" />
				<col width="80" />
				<col width="150" />
				<col width="110" />
				<col width="150" />
				<col width="130" />
			</colgroup>
			<thead>
				<tr class="line">
					<th class="no_line">Center</th>
					<th>Balance</th>
					<th>Type</th>
					<th>Ref.Number</th>
					<th>Payment Date</th>
					<th>Amount</th>
					<th>Memo</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr class="line2">
					<td class="no_line left pl10">Aberdeen-Matawan</td>
					<td>$0.00</td>
					<td>
						<select name="" id="" style="width:100px">
							<option value="">Check</option>
							<option value="">Credit Card</option>
							<option value="">Cash</option>
						</select>
					</td>
					<td>
						<input type="text" class="searchInput" style="width:50px">
					</td>
					<td>
						<input type="text" class="searchInput" style="width:90px">
						<a href="#" class="btn_calendar">view calendar</a>
					</td>
					<td>
						$ <input type="text" class="searchInput" style="width:70px">
					</td>
					<td>
						<input type="text" class="searchInput" style="width:120px">
					</td>
					<td>
						<div class="tbl_btn">
							<span class="btnArea"><a href="#"><span style="width:50px">Record</span></a></span>
							<span class="btnArea"><a href="#" data-rel="record1" class="btn_list"><span style="width:40px">View</span></a></span>
						</div>
					</td>
				</tr>
				<tr class="line2 record1" style="display:none">
					<td colspan="2" class="no_line left"><span class="line">Posted 01/08/2015</span></td>
					<td>Check</td>
					<td>1115</td>
					<td>01/08/2015</td>
					<td>$1,690.11</td>
					<td colspan="3"></td>
				</tr>
				<tr class="line2 record1" style="display:none">
					<td colspan="2" class="no_line left"><span class="line">Posted 01/09/2015</span></td>
					<td>Check</td>
					<td>1115</td>
					<td>01/09/2015</td>
					<td>$10,690.11</td>
					<td colspan="3"></td>
				</tr>
				<tr class="line2">
					<td class="no_line left pl10">Allentown</td>
					<td>$0.00</td>
					<td>
						<select name="" id="" style="width:100px">
							<option value="">Check</option>
							<option value="">Credit Card</option>
							<option value="">Cash</option>
						</select>
					</td>
					<td>
						<input type="text" class="searchInput" style="width:50px">
					</td>
					<td>
						<input type="text" class="searchInput" style="width:90px">
						<a href="#" class="btn_calendar">view calendar</a>
					</td>
					<td>
						$ <input type="text" class="searchInput" style="width:70px">
					</td>
					<td>
						<input type="text" class="searchInput" style="width:120px">
					</td>
					<td>
						<div class="tbl_btn">
							<span class="btnArea"><a href="#"><span style="width:50px">Record</span></a></span>
							<span class="btnArea"><a href="#" data-rel="record2" class="btn_list"><span style="width:40px">View</span></a></span>
						</div>
					</td>
				</tr>
				<tr class="line2 record2" style="display:none">
					<td colspan="2" class="no_line left"><span class="line">Posted 01/09/2015</span></td>
					<td>Check</td>
					<td>1115</td>
					<td>01/09/2015</td>
					<td>$10,690.11</td>
					<td colspan="3"></td>
				</tr>
			</tbody>
		</table>
	</div>
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
