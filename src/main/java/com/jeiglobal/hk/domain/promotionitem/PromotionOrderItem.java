package com.jeiglobal.hk.domain.promotionitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @since  2015-10-01
 * @author Jieun
 * @see 판촉물 주문내역 Entity.
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionOrderItem {

	private Integer	aidx;
	private Integer	fidx;
	private String	jisaCD;
	private String	deptCD;
	private String	orderYMD;
	private String	orderNote;
	private Integer orderTotQty;
	private float	orderTotAmt;
	
	private Integer shipTotQty;
	private float	shipTotAmt;
	private String	shipYMD;
	private String	signDate;
	private String	signID;

	private Integer	itemCD;
	private String	itemName;
	private String	itemColor;
	private float	itemPrice;
	private String	itemUOM;
	private Integer	orderQty;
	private float	orderAmt;
	private Integer	shipQty;
	private float	shipAmt;
	
	private Integer	cartQty;
	private float	cartAmt;
	private String	regDate;
	private String	regID;
	private String	updDate;
	private String	updID;

}
