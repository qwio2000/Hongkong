package com.jeiglobal.hk.controller.promotionitem;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeiglobal.hk.domain.auth.LoginInfo;


/**
 * @since  2015-10-01
 * @author 이지은
 *
 */

@Slf4j
@Controller
public class PromotionItemController {
	
	//페이징 범위
	private static final int PAGE_BLOCK_SIZE = 10;
	//한 페이지에 출력할 게시물 개수
	private static final int PAGE_SIZE = 10;
	
	
	@RequestMapping(value={"/ja/promoitem/promoitemlist","/ja/promoitem"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String List(@ModelAttribute LoginInfo loginInfo) {
		String userType = loginInfo.getUserType();
		log.debug("Getting List Page, UserType : {}", userType);
		
		return "promotionitem/list";
	}
	
	
	@RequestMapping(value={"/ja/promoitem/addpage","/ja/promoitem"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String Addpage(@ModelAttribute LoginInfo loginInfo) {
		String userType = loginInfo.getUserType();
		log.debug("Getting Write Page, UserType : {}", userType);
		
		return "promotionitem/write";
	}

}
