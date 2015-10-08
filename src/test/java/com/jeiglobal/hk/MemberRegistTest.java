package com.jeiglobal.hk;

import java.util.regex.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;

import com.jeiglobal.hk.service.member.*;
import com.jeiglobal.hk.utils.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HongkongProjectApplication.class)
@WebAppConfiguration
public class MemberRegistTest {
	
	@Autowired
	MessageSourceAccessor accessor;
	@Autowired
	MemberRegistService service;
	
	@Test
	public void 정규식테스트(){
		String regex = "^[a-zA-Z]{2}[0-9]{6}";
		assertThat(true, is(matched(regex, "AA123123")));
		assertThat(false, is(matched(regex, "HK00006")));
		assertThat(false, is(matched(regex, "00000060")));
	}
	
	private boolean matched(String regex, String inputTxt) {
		return Pattern.matches(regex, inputTxt);
	}
	
	@Test
	public void 첫관리방문일테스트() throws Exception {
//		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yy");
//		Calendar cal = Calendar.getInstance();
//		cal.set(2015, 8, 1);
//		for (int i = 1; i < 40; i++) {
//			List<String> weekStrings = CommonUtils.weekCalendar(sdf.format(cal.getTime()));
//			cal.add(Calendar.DATE, 1);
//		}
		
//		List<String> list = service.getFirstManageDates("08");
//		for (String string : list) {
//			System.out.println(string);
//		}
	}
	@Test
	public void 회비가져오기() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(sdf.parse("2015-09-01"));
//		for (int i = 0; i < 31; i++) {
//			int calcFee = service.getCalcFee(sdf.format(cal.getTime()),"00021","1");
//			System.out.println("첫관리방문일 : "+sdf.format(cal.getTime())+", 회비 : "+calcFee);
//			cal.add(Calendar.DATE, 1);
//		}
	}
	
}
