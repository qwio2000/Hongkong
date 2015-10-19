package com.jeiglobal.hk.domain.promotionitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @since  2015-10-01
 * @author Jieun
 * @see 판촉물 장바구니(Cart) Entity.
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionCartItem {

	private Integer	aidx;
	private String	jisaCD;
	private String	deptCD;
	private String	cartYMD;
	private Integer itemCD;
	private String	itemName;
	private String	itemColor;
	private float	itemPrice;
	private String	itemUOM;
	private Integer	cartQty;
	private float	cartAmt;
	private String	regDate;
	private String	regID;

}
