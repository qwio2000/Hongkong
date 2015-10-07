package com.jeiglobal.hk.service.promotionitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.domain.promotionitem.PromotionItem;
import com.jeiglobal.hk.repository.promotionitem.PromotionitemRepository;

@Service
public class PromotionitemService {
	
	@Autowired
	private PromotionitemRepository promotionitemrepo;
	
	public int promotionitemAdd(PromotionItem promo){
		return promotionitemrepo.promotionitemAdd(promo);

	}
	
	public List<PromotionItem> promotionitemList(){
		return promotionitemrepo.promotionitemList();
	}
	
	public PromotionItem PromotionitemOne(int itemCD){
		return promotionitemrepo.promotionitemOne(itemCD);
	}
	
	public void promotionitemUpdate(PromotionItem promo){
		promotionitemrepo.promotionitemUpdate(promo);
	}
}
