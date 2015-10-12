package com.jeiglobal.hk.repository.promotionitem;

import java.util.List;

import com.jeiglobal.hk.domain.promotionitem.PromotionItem;
import com.jeiglobal.hk.repository.PrimaryRepositoryAnnoInterface;

@PrimaryRepositoryAnnoInterface
public interface PromotionitemRepository {
	
	int promotionitemAdd(PromotionItem promo);
	List<PromotionItem> promotionitemList();
	PromotionItem promotionitemOne(int itemCD);
	void promotionitemUpdate(PromotionItem promo);
}
