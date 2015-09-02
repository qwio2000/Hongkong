package com.jeiglobal.hk.common.exception;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;


import com.jeiglobal.hk.utils.*;

@Controller
public class ErrorHandler implements ErrorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);
	private final String ERROR_VIEW_PATH = "/error/";
	private String errorPath;
	private ErrorAttributes errorAttributes;
	private MessageSourceAccessor messageSourceAccessor;
		
	@RequestMapping(value = "${error.path:/error}")
	public String error(Model model, HttpServletRequest request, Locale locale) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		Map<String, Object> body = errorAttributes.getErrorAttributes(requestAttributes, true);
		Iterator<String> keys = body.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			LOGGER.debug("Key : {}, Value : {}",key, body.get(key));
		}
		String view = ERROR_VIEW_PATH;
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		if(body.get("status") != null) {
			try {
				status = HttpStatus.valueOf((Integer) body.get("status"));
			} catch(Exception ignore) { } 
		}
		String message = messageSourceAccessor.getMessage("error." + status, null, locale);
		if(message != null) {
			body.put("message", message);
		}
		LOGGER.error("Error Status : {}, Message : {}", status, message);
		LOGGER.error("Error Status : {}, Message : {}", status, message);
		model.addAttribute("error", status.getReasonPhrase());
		model.addAttribute("message", message);
		if(HttpStatus.NOT_FOUND.equals(status)){
			view += "error404";
		}else{
			view += "error500";
		}
		return view;
	}

	@Override
	public String getErrorPath() {
		return errorPath;
	}
	
	
	@Value("${error.path:/error}")
	public void setErrorPath(String errorPath) {
		this.errorPath = errorPath;
	}

	@Autowired
	public void setErrorAttributes(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}
	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSourceAccessor = new MessageSourceAccessor(messageSource);
	}

}