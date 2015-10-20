package com.jeiglobal.hk.repository.promotionitem;

import java.util.List;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.promotionitem.PromotionCartItem;
import com.jeiglobal.hk.domain.promotionitem.PromotionItem;
import com.jeiglobal.hk.domain.promotionitem.PromotionOrderItem;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

/**
 * @since  2015-10-01
 * @author 이지은
 * @see Ja : 지사 / Fa : 가맹
 */
@PrimaryRepositoryAnnoInterface
public interface PromotionitemRepository {
	
	//Ja
	int promotionitemAdd(PromotionItem promo);
	List<PromotionItem> promotionitemList(LoginInfo logininfo);
	PromotionItem promotionitemOne(int itemCD);
	void promotionitemUpdate(PromotionItem promo);
	void promotionitemdelete(int itemCD);
	void promotionitemhisins(PromotionItem promo);
	
	//Fa
	void promotionitemCartIns(PromotionCartItem promoc);
	int promotionitemCartChk(PromotionCartItem promoc);
	void promotionitemCartUdt(PromotionCartItem promoc);
	List<PromotionCartItem> promotionitemCartList(LoginInfo logininfo);
	void promotionitemCartDel(int aidx);
	void promotionitemOrderMstIns(PromotionOrderItem promoo);
	void promotionitemOrderDtlIns(PromotionOrderItem promoo);
	void promotionitemCartAllDel(LoginInfo logininfo);
	List<PromotionOrderItem> promotionitemOrderList(LoginInfo logininfo);
	List<PromotionOrderItem> promotionitemOrderDtlList(int aidx);
	
	
}
