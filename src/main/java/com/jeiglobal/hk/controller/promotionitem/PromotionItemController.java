package com.jeiglobal.hk.controller.promotionitem;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
public class PromotionItemController {
	
	@Autowired
	private PromotionitemService promotionitemservice;
	
	@Value("${uploadpath.promotionitem}")
	private String promotionitempath;
	
	
	//리스트 가져오기
	@RequestMapping(value={"/ja/promoitem/promoitemlist","/ja/promoitem"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String List(Model model, @ModelAttribute LoginInfo loginInfo) {
		String userType = loginInfo.getUserType();
		log.debug("Getting List Page, UserType : {}", userType);
		
		List<PromotionItem> promolist = promotionitemservice.promotionitemList(loginInfo.getJisaCD());
		model.addAttribute("list", promolist);
		
		return "promotionitem/list";
	}
	
	
	// 글쓰기 페이지
	@RequestMapping(value={"/ja/promoitem/addpage","/ja/promoitem"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String Addpage(Model model, @ModelAttribute LoginInfo loginInfo) {
		String userType = loginInfo.getUserType();
		log.debug("Getting Write Page, UserType : {}", userType);
		model.addAttribute("bordtype", "write");
		return "promotionitem/write";
	}
	

	// 글 쓰기
	@RequestMapping(value={"/ja/promoitem/add","/ja/promoitem"}, method={RequestMethod.POST,RequestMethod.HEAD})
	public String Add(Model model, @ModelAttribute LoginInfo loginInfo,
				@ModelAttribute PromotionItem promo) throws IllegalStateException, IOException {
		String userType = loginInfo.getUserType();
		log.debug("Getting ADD, UserType : {}", userType);
		//log.debug("= 값 확인하기 => " + promo);
		
		
		promo.setJisaCD(loginInfo.getJisaCD());
		
		MultipartFile[] file = promo.getMultipartFile();
				
		for(int i=0;i<file.length;i++){
			
		    // 파일 최종 업로드
		    if (!file[i].isEmpty()) {
		        try {
		        	
		        	 // 파일명뒤에 날짜 붙이기위한 날짜
				    DecimalFormat df  = new DecimalFormat("00");
					Calendar calendar = new GregorianCalendar(Locale.KOREA);
					String tmpdate = Integer.toString(calendar.get(Calendar.YEAR))  + df.format(calendar.get(Calendar.MONTH) + 1) + df.format(calendar.get(Calendar.DATE));
				    String tmptime = "" +  calendar.get(Calendar.HOUR_OF_DAY) + "" + calendar.get(Calendar.MINUTE) + "" + calendar.get(Calendar.SECOND);
				    
				    // 파일명 %,@ 와 같은 부호 공백으로 채우기.
				    String name=file[i].getOriginalFilename().trim().replaceAll("%", "").replaceAll("@", "");
				    //System.out.println("업로드 파일명 ==> "+ name);

				    // 파일 확장명 체크하기. 나중에 구현해도 될듯... ㅋㅋㅋㅋㅋㅋㅋ
					String fileType = file[i].getContentType();
					if(!fileType.equalsIgnoreCase("jpeg") && !fileType.equalsIgnoreCase("bmp") && !fileType.equalsIgnoreCase("gif") && !fileType.equalsIgnoreCase("png")) {
						//log.debug("이미지 파일만 올라가도록 튕기기.");
					}
					
		        	// 기본 디렉토리 경로. 없으면 생성할수 있도록.
					File f = new File(promotionitempath);
					if(!f.exists()) {	f.mkdirs(); }
					//System.out.println("디렉토리 경로 =>> " + promotionitempath);
					
					// 파일명 날짜+시+분+초 로 붙여서 재생성
					String finalFnm = promotionitempath + tmpdate + tmptime + name ;
					//System.out.println("파일명 찍어보기 = : " + finalFnm);
		        	file[i].transferTo(new File(finalFnm));
		        	
				    
		        	switch (i) {
		            case 0 : 
		            	promo.setItemfile1Name(name);
		            	promo.setItemfile1NameConvert(tmpdate + tmptime + name);
		            	promo.setItemfile1Size(file[i].getSize());
		            	promo.setItemfile1Ext(fileType);
		            	break;
		            case 1 : 
		            	promo.setItemfile2Name(name);
		            	promo.setItemfile2NameConvert(tmpdate + tmptime + name);
		            	promo.setItemfile2Size(file[i].getSize());
		            	promo.setItemfile2Ext(fileType);
		            	break;
		            case 2 : 
		            	promo.setItemfile3Name(name);
		            	promo.setItemfile3NameConvert(tmpdate + tmptime + name);
		            	promo.setItemfile3Size(file[i].getSize());
		            	promo.setItemfile3Ext(fileType);
		            break;
		           
		            default : break;
		          }
		        	
		        } catch (Exception e) {
		    		log.debug("오류 : "+e);
		        }
		    } else {
		       System.out.println("빈파일임 ㅋㅋ");
		    }
		}
		
		
		promo.setRegID(loginInfo.getUserId());
		
		int result;
		result = promotionitemservice.promotionitemAdd(promo);
		
		model.addAttribute("result", result);
		
		return "redirect:/ja/promoitem/promoitemlist";
	}


	// 글수정 페이지
	@RequestMapping(value={"/ja/promoitem/modipage","/ja/promoitem"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String Modifypage(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam int itemCD) {
		String userType = loginInfo.getUserType();
		log.debug("Getting Write Page, UserType : {}", userType);
		
		PromotionItem promo = promotionitemservice.PromotionitemOne(itemCD);
		model.addAttribute("promo", promo);
		model.addAttribute("bordtype", "modify");
		return "promotionitem/write";
	}
	
	
	// 글 수정하기
	@RequestMapping(value={"/ja/promoitem/update","/ja/promoitem"}, method={RequestMethod.POST,RequestMethod.HEAD})
	public String Update(Model model, @ModelAttribute LoginInfo loginInfo,
				@ModelAttribute PromotionItem promo) throws IllegalStateException, IOException {
		String userType = loginInfo.getUserType();
		log.debug("글 업데이트, UserType : {}", userType);
		
    	//System.out.println("promo.getItemfile1NameConvert()====> " + promo.getItemfile1NameConvert());
    	
    	if(promo.getItemfile1NameConvert() != null || promo.getItemfile1NameConvert() != ""){
        	promo.setItemfile1Name(null);
        	promo.setItemfile1NameConvert(null);
        	promo.setItemfile1Size(0);
        	promo.setItemfile1Ext(null);
        	new File(promotionitempath + promo.getItemfile1NameConvert()).delete();
    	}
    	
    	if(promo.getItemfile2NameConvert() != null || promo.getItemfile1NameConvert() != ""){
        	promo.setItemfile2Name(null);
        	promo.setItemfile2NameConvert(null);
        	promo.setItemfile2Size(0);
        	promo.setItemfile2Ext(null);
        	new File(promotionitempath + promo.getItemfile2NameConvert()).delete();
    	}
    	
    	if(promo.getItemfile3NameConvert() != null || promo.getItemfile1NameConvert() != ""){
        	promo.setItemfile3Name(null);
        	promo.setItemfile3NameConvert(null);
        	promo.setItemfile3Size(0);
        	promo.setItemfile3Ext(null);
    		new File(promotionitempath + promo.getItemfile3NameConvert()).delete();
    	}

		MultipartFile[] file = promo.getMultipartFile();
				
		for(int i=0;i<file.length;i++){
			
		    // 파일 최종 업로드
		    if (!file[i].isEmpty()) {
		        try {
		        	
		        	 // 파일명뒤에 날짜 붙이기위한 날짜
				    DecimalFormat df  = new DecimalFormat("00");
					Calendar calendar = new GregorianCalendar(Locale.KOREA);
					String tmpdate = Integer.toString(calendar.get(Calendar.YEAR))  + df.format(calendar.get(Calendar.MONTH) + 1) + df.format(calendar.get(Calendar.DATE));
				    String tmptime = "" +  calendar.get(Calendar.HOUR_OF_DAY) + "" + calendar.get(Calendar.MINUTE) + "" + calendar.get(Calendar.SECOND);
				    
				    // 파일명 %,@ 와 같은 부호 공백으로 채우기.
				    String name=file[i].getOriginalFilename().trim().replaceAll("%", "").replaceAll("@", "");
				    //System.out.println("업로드 파일명 ==> "+ name);

				    // 파일 확장명 체크하기. 나중에 구현해도 될듯... ㅋㅋㅋㅋㅋㅋㅋ
					String fileType = file[i].getContentType();
					if(!fileType.equalsIgnoreCase("jpeg") && !fileType.equalsIgnoreCase("bmp") && !fileType.equalsIgnoreCase("gif") && !fileType.equalsIgnoreCase("png")) {
						//log.debug("이미지 파일만 올라가도록 튕기기.");
					}
					
		        	// 기본 디렉토리 경로. 없으면 생성할수 있도록.
					File f = new File(promotionitempath);
					if(!f.exists()) {	f.mkdirs(); }
					//System.out.println("디렉토리 경로 =>> " + promotionitempath);
					
					// 파일명 날짜+시+분+초 로 붙여서 재생성
					String finalFnm = promotionitempath + tmpdate + tmptime + name ;
					//System.out.println("파일명 찍어보기 = : " + finalFnm);
		        	file[i].transferTo(new File(finalFnm));
		        	
		        	switch (i) {
		            case 0 : 
		            	promo.setItemfile1Name(name);
		            	promo.setItemfile1NameConvert(tmpdate + tmptime + name);
		            	promo.setItemfile1Size(file[i].getSize());
		            	promo.setItemfile1Ext(fileType);
		            	break;
		            case 1 : 
		            	promo.setItemfile2Name(name);
		            	promo.setItemfile2NameConvert(tmpdate + tmptime + name);
		            	promo.setItemfile2Size(file[i].getSize());
		            	promo.setItemfile2Ext(fileType);
		            	break;
		            case 2 : 
		            	promo.setItemfile3Name(name);
		            	promo.setItemfile3NameConvert(tmpdate + tmptime + name);
		            	promo.setItemfile3Size(file[i].getSize());
		            	promo.setItemfile3Ext(fileType);
		            break;
		           
		            default : break;
		          }
		        	
		        } catch (Exception e) {
		    		log.debug("오류 : "+e);
		        }
		    } else {
		       System.out.println("빈파일임 ㅋㅋ");
		    }
		}
		
		
		promo.setUpdID(loginInfo.getUserId());
		
		promotionitemservice.promotionitemUpdate(promo);
		
		return "redirect:/ja/promoitem/promoitemlist";
	}
	
	
	// 글수정 페이지
	@RequestMapping(value={"/ja/promoitem/delitem","/ja/promoitem"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String DeletePromotion(Model model, @ModelAttribute LoginInfo loginInfo, @RequestParam int itemCD) {
		String userType = loginInfo.getUserType();
		log.debug("Getting Write Page, UserType : {}", userType);
		PromotionItem promo = promotionitemservice.PromotionitemOne(itemCD);
		// 히스토리 입력
		promotionitemservice.promotionitemhisins(promo);
		// 삭제
		promotionitemservice.promotionitemdelete(itemCD);
		return "redirect:/ja/promoitem/promoitemlist";
	}
	

	
}
