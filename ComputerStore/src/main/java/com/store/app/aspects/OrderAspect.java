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
public class OrderAspect {
	
	@Before("execution(* com.store.app.controller.UserController.get*(..))"
			+ "&& execution(* com.store.app.controller.UserController.delete*(..))")
	public void beforeGet(JoinPoint jp) {
		HttpSession session = (HttpSession) jp.getArgs()[0];
		int userId = (Integer) jp.getArgs()[1];
		User u = null;
		
		try { // Check if the request is from someone who's logged in
			u = (User) session.getAttribute("user");
			if (u.getAccessLevel() < 1 && u.getUserId() != userId) {
				// TODO LOG EXCEPTION
				throw new BusinessException("You do not have a high enough access level to view this resource.");
			}
		} catch (NullPointerException e) {
			// TODO LOG EXCEPTION
			throw new BusinessException("You are not logged in. Please log in before trying to access this resource.");
		}
	}
	
	// get, update, delete
	// only controlled by admin or user associated with the order
}
