package com.jeiglobal.hk.util;

import java.util.*;

import org.springframework.context.*;

public class MessageSourceAccessor {

	private MessageSource messageSource;

	public MessageSourceAccessor(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String getMessage(String code, Locale locale) {
		return messageSource.getMessage(code, null, null, locale);
	}

	public String getMessage(String code, Object[] args, Locale locale) {
		return messageSource.getMessage(code, args, null, locale);
	}

	public String getMessage(MessageSourceResolvable resolvable, Locale locale) {
		try {
			return messageSource.getMessage(resolvable, locale);
		} catch (NoSuchMessageException e) {
			return "No Message";
		}
	}

}
