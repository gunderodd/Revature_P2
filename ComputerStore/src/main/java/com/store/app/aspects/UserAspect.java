package com.store.app.aspects;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import com.store.app.exception.BusinessException;
import com.store.app.model.User;

@Aspect
@Configuration
public class UserAspect {
//	final Logger L = Logger.getLogger(UserAspect.class);
	
	
	@Before("execution(* com.store.app.controller.UserController.get*(..)) "
			+ "&& execution(* com.store.app.controller.UserController.delete*(..)) "
			+ "&& execution(* com.store.app.controller.UserController.update*(..))")
	public void beforeGet(JoinPoint jp) {
		HttpSession session = (HttpSession) jp.getArgs()[0];
		User u = null;
		try { // Check if the request is from someone who's logged in
			u = (User) session.getAttribute("user");
		} catch (NullPointerException e) {
			// TODO LOG EXCEPTION
			throw new BusinessException("You are not logged in. Please log in before trying to access this resource.");
		}
		
		// please someone come up with something better here lol (lines 35 - 40)
		// I think this is a little too hacky, but it works for all get methods, so....
		String pathVar = "";
		int pathVarInt = 0;
		try {
			pathVar = jp.getArgs()[1].toString();
			pathVarInt = Integer.parseInt(pathVar);
		} catch (Exception e) {}
		if (u.getAccessLevel() < 1 && u.getId() != pathVarInt && u.getUsername().equals(pathVar)) {
			// TODO LOG EXCEPTION
			throw new BusinessException("You do not have a high enough access level to view this resource.");
		}
	}

	
//	@AfterThrowing("execution(* com.store.app.controller.UserController.get*(..))")
//	public void getThrower(JoinPoint jp) {
//		System.out.println("oh boy we threw something and now we're in afterthrowing");
//	}
	
	
}
