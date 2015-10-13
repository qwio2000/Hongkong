package com.jeiglobal.hk.domain.promotionitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionItem {

	private int		itemCD;
	private String	jisaCD;
	private String	itemName;
	private String	itemDescription	;
	private String	itemColor;
	private float	itemPrice;
	private Integer itemPerUnit;
	private String	itemUOM;
	private Integer	itemStock;
	private String	itemfile1Name;
	private String	itemfile1NameConvert;
	private long	itemfile1Size;
	private String	itemfile1Url;
	private String	itemfile1Ext;
	private String	itemfile2Name;
	private String	itemfile2NameConvert;
	private long	itemfile2Size;
	private String	itemfile2Url;
	private String	itemfile2Ext;
	private String	itemfile3Name;
	private String	itemfile3NameConvert;
	private long	itemfile3Size;
	private String	itemfile3Url;
	private String	itemfile3Ext;
	private String	itemVisible;
	private String	regDate;
	private String	regID;
	private String	updDate;
	private String	updID;
	
	// 임시
	private String aidx;
	
	//파일
	private MultipartFile[] multipartFile;
	

}
