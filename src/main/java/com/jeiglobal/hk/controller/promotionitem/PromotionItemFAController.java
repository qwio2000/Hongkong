package com.jeiglobal.hk.controller.promotionitem;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.promotionitem.PromotionItem;
import com.jeiglobal.hk.service.promotionitem.PromotionitemService;


/**
 * @since  2015-10-01
 * @author 이지은
 *
 */

@Slf4j
@Controller
public class PromotionItemFAController {

	@Autowired
	private PromotionitemService promotionitemservice;
		
	
	//리스트 가져오기
	@RequestMapping(value={"/fa/promoitem/promoitemfalist","/fa/promoitem"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String List(Model model, @ModelAttribute LoginInfo loginInfo) {
		String userType = loginInfo.getUserType();
		log.debug("Getting List Page, UserType : {}", userType);
		
		List<PromotionItem> promolist = promotionitemservice.promotionitemList(loginInfo.getJisaCD());
		model.addAttribute("list", promolist);
		
		return "promotionitem/Falist";
	}
	
	
}
