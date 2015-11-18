package com.jeiglobal.hk.domain.community;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @since  2015-11-03
 * @author Jieun
 * @see 캘린더 엔티티
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {

	private Integer	aidx;

	private String 	title;
	private Date 	start;
	private Date 	end;
	private String 	color;
	private String 	description;
	private String 	starttime;
	private String 	endtime;
	
	private String	jisaCD;
	private String	deptCD;
	private String	regDate;
	private String	regID;
	
	private String YYMM;

}
