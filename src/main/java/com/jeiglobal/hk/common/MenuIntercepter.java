package com.jeiglobal.hk.common;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.web.context.*;
import org.springframework.util.*;
import org.springframework.web.servlet.handler.*;

import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.menu.*;
import com.jeiglobal.hk.service.menu.*;

public class MenuIntercepter extends HandlerInterceptorAdapter{
	
	@Autowired
	private MenuService menuService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		HttpSessionSecurityContextRepository hsscr = new HttpSessionSecurityContextRepository();
		HttpRequestResponseHolder hrrh = new HttpRequestResponseHolder(request, response);
		SecurityContext context = hsscr.loadContext(hrrh);
		Authentication authentication = context.getAuthentication();
		LoginInfo loginInfo = (LoginInfo) authentication.getPrincipal();
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String currentUrl = request.getRequestURI();
		if ("/error".equals(currentUrl)) {
			PrintWriter writer = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			String scriptMessage = "<script language='javascript'>alert('Controller에 등록된 RequestMapping이 존재하지 않습니다.');";
			scriptMessage += "history.back();</script>";
			writer.write(scriptMessage);
			return false;
		}
		List<GlobalMenu> menuList = menuService.menuList(0,loginInfo.getJisaCD(),loginInfo.getEmpKeyLvCD(),loginInfo.getDepMngCD(),"1");
		List<GlobalMenu> leftMenuList = new ArrayList<GlobalMenu>();
		
		if(menuList == null){
			if(authentication.getAuthorities().contains("SUPERADMIN")){
				return true;
			}
			
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
			}
			
			int menuCodeCnt = menuCode.length();
			
			if(!menuCode.isEmpty()){
				if(menuCodeCnt == 1){
					menuFirstCode = menuCode.substring(0,1);
				}else if(menuCodeCnt == 3){
					menuFirstCode = menuCode.substring(0,1);
					menuTwoCode = menuCode.substring(0,3);
				}else if(menuCodeCnt == 5){
					menuFirstCode = menuCode.substring(0,1);
					menuTwoCode = menuCode.substring(0,3);
					menuThreeCode =  menuCode.substring(0,5);
				}else{
					menuFirstCode = menuCode.substring(0,1);
					menuTwoCode = menuCode.substring(0,3);
					menuThreeCode =  menuCode.substring(0,5);
					menuFourCode =  menuCode.substring(0,7);
				}	
				
				for (GlobalMenu globalMenu : menuList) {
					String menuCodeTemp = globalMenu.getMMenuCode();
					if(!menuCodeTemp.isEmpty() && menuCodeTemp.startsWith(menuFirstCode)){
						leftMenuList.add(globalMenu);
					}
				}
			}else{
				PrintWriter writer = response.getWriter();
				response.setContentType("text/html;charset=UTF-8");
				String scriptMessage = "<script language='javascript'>alert('";
				boolean t = false;
				for (GrantedAuthority globalMenu : authentication.getAuthorities()) {
					if("SUPERADMIN".equals(globalMenu.getAuthority())){
						t = true;
					}
				}
				if(t){
					scriptMessage += "유효한 URL이 아닙니다. 관리자');";
				}else{
					scriptMessage += "유효한 URL이 아닙니다.');";
				}
				scriptMessage += "history.back();</script>";
				writer.write(scriptMessage);
				return false;
			}
			
			request.setAttribute("leftMenuList",leftMenuList);
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
