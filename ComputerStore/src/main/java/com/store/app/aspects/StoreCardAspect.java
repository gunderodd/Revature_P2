package com.store.app.aspects;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.store.app.exception.BusinessException;
import com.store.app.model.User;

@Aspect
public class StoreCardAspect {
	
	@Before("execution(* com.store.app.controller.StoreCardController.get*(..)) "
			+ "&& execution(* com.store.app.controller.StoreCardController.delete*(..)) "
			+ "&& execution(* com.store.app.controller.StoreCardController.update*(..))")
	public void beforeGet(JoinPoint jp) {
		HttpSession session = (HttpSession) jp.getArgs()[0];
		User u = null;
		try {
			u = (User) session.getAttribute("user");
		} catch (NullPointerException e) {
			// TODO LOG
			throw new BusinessException("You are not logged in. Please log in before trying to access this resource.");
		}
		
		// logic to check if the user is either an employee/admin or if they're the owner of the card goes here
	}
}
