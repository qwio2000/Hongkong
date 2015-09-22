package com.jeiglobal.hk;

import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;

import com.jeiglobal.hk.service.member.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HongkongProjectApplication.class)
@WebAppConfiguration
public class MemberRegistTest {
	
	@Autowired
	MemberRegistService service;
	
//	@Test
//	public void 첫관리방문일테스트() throws ParseException {
//		List<String> list = service.getFirstManageDates("08");
//		for (String string : list) {
//			System.out.println(string);
//		}
//	}
//	@Test
//	public void 회비가져오기() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(sdf.parse("2015-09-01"));
//		for (int i = 0; i < 31; i++) {
//			int calcFee = service.getCalcFee(sdf.format(cal.getTime()),"00021","1");
//			System.out.println("첫관리방문일 : "+sdf.format(cal.getTime())+", 회비 : "+calcFee);
//			cal.add(Calendar.DATE, 1);
//		}
//	}
	
}
