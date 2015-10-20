package com.jeiglobal.hk.service.promotionitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.promotionitem.PromotionCartItem;
import com.jeiglobal.hk.domain.promotionitem.PromotionItem;
import com.jeiglobal.hk.domain.promotionitem.PromotionOrderItem;
import com.jeiglobal.hk.repository.promotionitem.PromotionitemRepository;

/**
 * @since 2015-10-14
 * @author 이지은
 **/
@Service
public class PromotionitemService {
	
	@Autowired
	private PromotionitemRepository promotionitemrepo;
	
	public int promotionitemAdd(PromotionItem promo){
		return promotionitemrepo.promotionitemAdd(promo);
	};
	
	public List<PromotionItem> promotionitemList(LoginInfo logininfo){
		return promotionitemrepo.promotionitemList(logininfo);
	};
	
	public PromotionItem PromotionitemOne(int itemCD){
		return promotionitemrepo.promotionitemOne(itemCD);
	};
	
	public void promotionitemUpdate(PromotionItem promo){
		promotionitemrepo.promotionitemUpdate(promo);
	};
	
	public void promotionitemdelete(int itemCD){
		promotionitemrepo.promotionitemdelete(itemCD);
	};
	
	public void promotionitemhisins(PromotionItem promo){
		promotionitemrepo.promotionitemhisins(promo);
	};
	
	public void promotionitemCartIns(PromotionCartItem promoc){
		promotionitemrepo.promotionitemCartIns(promoc);
	}
	
	public int promotionitemCartChk(PromotionCartItem promoc){
		return promotionitemrepo.promotionitemCartChk(promoc);
	};
	
	public void promotionitemCartUdt(PromotionCartItem promoc){
		promotionitemrepo.promotionitemCartUdt(promoc);
	};
	
	public List<PromotionCartItem> promotionitemCartList(LoginInfo logininfo){
		return promotionitemrepo.promotionitemCartList(logininfo);
	};
	
	public void promotionitemCartDel(int aidx){
		promotionitemrepo.promotionitemCartDel(aidx);
	};
	
	public void promotionitemOrderMstIns(PromotionOrderItem promoo){
		promotionitemrepo.promotionitemOrderMstIns(promoo);
	};
	
	public void promotionitemOrderDtlIns(PromotionOrderItem promoo){
		promotionitemrepo.promotionitemOrderDtlIns(promoo);
	};
	
	public void promotionitemCartAllDel(LoginInfo logininfo){
		promotionitemrepo.promotionitemCartAllDel(logininfo);
	};
	
	public List<PromotionOrderItem> promotionitemOrderList(LoginInfo logininfo){
		return promotionitemrepo.promotionitemOrderList(logininfo);
	};
	public List<PromotionOrderItem> promotionitemOrderDtlList(int aidx){
		return promotionitemrepo.promotionitemOrderDtlList(aidx);
	};
	
}
