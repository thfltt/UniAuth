package com.dianrong.common.uniauth.cas.handler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jasig.cas.web.flow.AuthenticationExceptionHandler;

public class UniauthAuthenticationExceptionHandler extends AuthenticationExceptionHandler {
	
	@PostConstruct
	public void init(){
		List<Class<? extends Exception>> superErrorList = super.getErrors();
		List<Class<? extends Exception>> errorList = new ArrayList<Class<? extends Exception>>();
		errorList.addAll(superErrorList);
		errorList.add(com.dianrong.common.uniauth.cas.exp.FreshUserException.class);
		errorList.add(com.dianrong.common.uniauth.cas.exp.MultiUsersFoundException.class);
		errorList.add(com.dianrong.common.uniauth.cas.exp.UserPasswordNotMatchException.class);
		super.setErrors(errorList);
	}
}
