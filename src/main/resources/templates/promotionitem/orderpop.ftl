<!DOCTYPE html>
<!--[if IE 7]><html lang="ko" class="ie7"><![endif]-->
<!--[if IE 8]><html lang="ko" class="ie8"><![endif]-->
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link rel="stylesheet" type="text/css" href="${cssPath }/common.css" />
	<script type="text/javascript" src="${jsPath }/common/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${jsPath }/common/ux.js"></script>
</head>
<body>



	<div class="popup">
		<div class="popup_top"><h1>Promotional Item Order Ref.# ${ordernum } </h1> <a href="javascript:closepop()" class="btn_popup_close">close</a></div>
		<div class="popup_content">
			<div class="pop_gm">
				<div class="tbl01">
					<table>
						<colgroup>
							<col width="90" />
							<col width="150" />
							<col width="100" />
							<col width="80" />
							<col width="80" />
							<col width="90" />
							<col width="50" />
							<col />
						</colgroup>
						<thead>
							<tr>
								<th>Order Date</th>
								<th>Item Name</th>
								<th>Color</th>
								<th>Price</th>
								<th>OrderQty</th>
								<th>Ship Date</th>
								<th>ShipQty</th>
								<th>Note</th>
							</tr>
						</thead>
						<tbody>
						
						<#list orderdtllist as orderlist>
							<tr>
								<td>${orderlist.regDate?substring(0,10)}</td>
								<td>${orderlist.itemName}</td>
								<td>${orderlist.itemColor}</td>
								<td>$${orderlist.itemPrice}</td>
								<td>${orderlist.orderQty}</td>
								<td>${orderlist.regDate?substring(0,10)}</td>
								<td>${orderlist.shipTotQty}</td>
								<td class="left">${orderlist.orderNote}</td>
							</tr>
						</#list>
						
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
