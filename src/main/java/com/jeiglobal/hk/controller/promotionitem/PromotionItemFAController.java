package com.jeiglobal.hk.controller.promotionitem;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeiglobal.hk.domain.auth.LoginInfo;
import com.jeiglobal.hk.domain.promotionitem.PromotionCartItem;
import com.jeiglobal.hk.domain.promotionitem.PromotionItem;
import com.jeiglobal.hk.domain.promotionitem.PromotionOrderItem;
import com.jeiglobal.hk.service.promotionitem.PromotionitemService;


/**
 * @since	2015-10-01
 * @author	이지은
 * @see		가맹점 컨트롤러. 지사와 분리함. 구분해서 사용할 것.
 * 			가맹점은 주로, 장바구니 & 주문 .
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
		
		List<PromotionItem> promolist = promotionitemservice.promotionitemList(loginInfo);
		model.addAttribute("list", promolist);
		
		List<PromotionCartItem> cartlist = promotionitemservice.promotionitemCartList(loginInfo);
		model.addAttribute("cartlist", cartlist);
		
		List<PromotionOrderItem> orderlist = promotionitemservice.promotionitemOrderList(loginInfo);
		model.addAttribute("orderlist", orderlist);
		
		return "promotionitem/Falist";
	}
	
	//판촉물 장바구니 넣기
	@RequestMapping(value={"/fa/promoitem/promoitemfacartadd","/fa/promoitem"}, method={RequestMethod.POST,RequestMethod.HEAD})
	public String CartAdd(Model model, @ModelAttribute LoginInfo loginInfo, @ModelAttribute PromotionCartItem promo) {
		String userType = loginInfo.getUserType();
		log.debug("판촉물 장바구니 입력, UserType : {}", userType);
		
		promo.setJisaCD(loginInfo.getJisaCD());
		promo.setDeptCD(loginInfo.getDeptCD());
		promo.setRegID(loginInfo.getUserId());
		int chkcnt = promotionitemservice.promotionitemCartChk(promo);
		if(chkcnt < 1){
			promotionitemservice.promotionitemCartIns(promo);
		}else{
			promotionitemservice.promotionitemCartUdt(promo);
		}
		return "redirect:/fa/promoitem/promoitemfalist";
	}
	
	//판촉물 장바구니 내역 삭제
	@RequestMapping(value={"/fa/promoitem/promoitemfacartdel","/fa/promoitem"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String CartDel(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam Integer aidx) {
		String userType = loginInfo.getUserType();
		log.debug("판촉물 장바구니 삭제, UserType : {}", userType);
		promotionitemservice.promotionitemCartDel(aidx);
		return "redirect:/fa/promoitem/promoitemfalist";
	}
	
	
	//판촉물 주문하기
	@RequestMapping(value={"/fa/promoitem/promoitemfaorder","/fa/promoitem"}, method={RequestMethod.POST,RequestMethod.HEAD})
	public String CartOrder(Model model, @ModelAttribute LoginInfo loginInfo, @ModelAttribute PromotionOrderItem promoo) {
		String userType = loginInfo.getUserType();
		log.debug("판촉물 주문하기, UserType : {}", userType);
		promoo.setJisaCD(loginInfo.getJisaCD());
		promoo.setDeptCD(loginInfo.getDeptCD());
		promoo.setRegID(loginInfo.getUserId());
		// Mst 입력후, aidx 리턴. 바로 model 넣어주면 된다.
		promotionitemservice.promotionitemOrderMstIns(promoo);
		promotionitemservice.promotionitemOrderDtlIns(promoo);
		// 주문 입력 후, 기존 카트 내역 삭제 해줄것.
		promotionitemservice.promotionitemCartAllDel(loginInfo);
		
		return "redirect:/fa/promoitem/promoitemfalist";
	}
	
	//판촉물 상세 주문내역 팝업
	@RequestMapping(value={"/fa/promoitem/promoitemfaorderpop","/fa/promoitem"}, method={RequestMethod.POST,RequestMethod.HEAD})
	public String OrderPop(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam Integer aidx) {
		String userType = loginInfo.getUserType();
		log.debug("판촉물 상세 주문내역 팝업, UserType : {}", userType);
		List<PromotionOrderItem> orderdtllist =	promotionitemservice.promotionitemOrderDtlList(aidx);
		model.addAttribute("orderdtllist", orderdtllist);
		model.addAttribute("ordernum", aidx);
		return "promotionitem/orderpop";
	}
	
	
}
