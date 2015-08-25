package com.jeiglobal.hk.common;

import javax.servlet.*;

import org.springframework.web.*;
import org.springframework.web.filter.*;

public class WebInitializer implements WebApplicationInitializer{

	@Override
    public void onStartup(ServletContext aServletContext) throws ServletException
    {       
		System.out.println("=========================");
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*"); 
    }
	
}
