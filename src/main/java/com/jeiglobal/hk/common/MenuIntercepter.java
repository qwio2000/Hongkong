package com.jeiglobal.hk.common;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.http.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.web.context.*;
import org.springframework.util.*;
import org.springframework.web.servlet.handler.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.menu.*;
import com.jeiglobal.hk.service.menu.*;
/**
 * 
 * 클래스명 : MenuIntercepter.java
 *
 * 작성일 : 2015. 9. 7.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 컨트롤러에 가기 전 메뉴에 관련된 정보를 처리하는 인터셉터
 */
@Slf4j
public class MenuIntercepter extends HandlerInterceptorAdapter{
	
	@Autowired
	private MenuService menuService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSessionSecurityContextRepository hsscr = new HttpSessionSecurityContextRepository();
		HttpRequestResponseHolder hrrh = new HttpRequestResponseHolder(request, response);
		SecurityContext context = hsscr.loadContext(hrrh);
		Authentication authentication = context.getAuthentication();
		LoginInfo loginInfo = (LoginInfo) authentication.getPrincipal();
		log.debug("loginInfo : {}", loginInfo);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String currentUrl = request.getRequestURI();
		List<GlobalMenu> menuList = menuService.menuList(0,loginInfo.getJisaCD(),loginInfo.getUserType(),loginInfo.getUserLevel(),"1", loginInfo.getUserId());
		List<GlobalMenu> headerMenuList = new ArrayList<GlobalMenu>();
		List<List<GlobalMenu>> menus = new ArrayList<List<GlobalMenu>>();
		if(menuList == null){
			return false;
		}else{
			String menuCode = "";
			String menuFirstCode = "";
			String menuTwoCode = "";
			String menuThreeCode = "";
			String menuFourCode = "";
			
			AntPathMatcher ant = new AntPathMatcher();
			
			if("ROOT".equals(menuList.get(0).getMMenuName())){
				menuList.remove(0);
			}
			for (GlobalMenu globalMenu : menuList) {
				if(ant.match(globalMenu.getMAntPattern(),currentUrl)){
					menuCode = globalMenu.getMMenuCode();
				}
				if(globalMenu.getMMenuCode().length() == 1){
					headerMenuList.add(globalMenu);
				}
			}
			
			//헤더 메뉴 정렬
			Collections.sort(headerMenuList, new Comparator<GlobalMenu>() {
				@Override
				public int compare(GlobalMenu arg0, GlobalMenu arg1) {
					return Integer.parseInt(arg0.getMMenuCode()) < Integer.parseInt(arg1.getMMenuCode()) ? -1 : 
						Integer.parseInt(arg0.getMMenuCode()) > Integer.parseInt(arg1.getMMenuCode()) ? 1:0;
				}
			});
			int menuCodeCnt = menuCode.length();
			
			if(!menuCode.isEmpty() || 
					"/ja".equalsIgnoreCase(currentUrl) || "/fa".equalsIgnoreCase(currentUrl)){
				if(menuCodeCnt == 1){
					menuFirstCode = menuCode.substring(0,1);
				}else if(menuCodeCnt == 3){
					menuFirstCode = menuCode.substring(0,1);
					menuTwoCode = menuCode.substring(0,3);
				}else if(menuCodeCnt == 5){
					menuFirstCode = menuCode.substring(0,1);
					menuTwoCode = menuCode.substring(0,3);
					menuThreeCode =  menuCode.substring(0,5);
				}else if(menuCodeCnt == 7){
					menuFirstCode = menuCode.substring(0,1);
					menuTwoCode = menuCode.substring(0,3);
					menuThreeCode =  menuCode.substring(0,5);
					menuFourCode =  menuCode.substring(0,7);
				}	
				
				for (int i = 0; i < headerMenuList.size(); i++) {
					List<GlobalMenu> tempMenuList = new ArrayList<GlobalMenu>();
					tempMenuList.add(headerMenuList. get(i));
					for (GlobalMenu menu : menuList) {
						if(headerMenuList.get(i).getMIdx() == menu.getMParentIdx()){
							tempMenuList.add(menu);
						}
					}
					menus.add(tempMenuList);
				}
			}else{
				log.debug("Invalid Url : {}", currentUrl);
				
				PrintWriter writer = response.getWriter();
				response.setContentType("text/html;charset=UTF-8");
				String scriptMessage = "<script language='javascript'>alert('";
				scriptMessage += "유효한 URL이 아닙니다.');";
				scriptMessage += "history.back();</script>";
				writer.write(scriptMessage);
				return false;
			}
			request.setAttribute("menuMap",menus);
			request.setAttribute("headerMenuList",headerMenuList);
			request.setAttribute("menuCode",menuCode);
			request.setAttribute("menuFirstCode",menuFirstCode);
			request.setAttribute("menuTwoCode",menuTwoCode);
			request.setAttribute("menuThreeCode",menuThreeCode);
			request.setAttribute("menuFourCode",menuFourCode);
			request.setAttribute("currentUrl",currentUrl);
			request.setAttribute("nowDate",sdf.format(cal.getTime()));
			return true;
		}
	}
	
}
