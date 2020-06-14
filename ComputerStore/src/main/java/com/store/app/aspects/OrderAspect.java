package com.store.app.aspects;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import com.store.app.exception.BusinessException;
import com.store.app.model.Order;
import com.store.app.model.User;

@Aspect
@Configuration
public class OrderAspect {
	
	// This checks if the user is an admin, or if the user owns the order that's being passed.
	@Before("execution(* com.store.app.controller.OrderController.get*(..)) "
			+ "&& execution(* com.store.app.controller.OrderController.delete*(..)) "
			+ "&& execution(* com.store.app.controller.OrderController.buy*(..)) "
			+ "&& execution(* com.store.app.controller.OrderController.clear*(..))")
	public void verifyUser(JoinPoint jp) {
		HttpSession session = (HttpSession) jp.getArgs()[0];
		Order order = null;
		int orderUserId = 0;
		
		// hacky but it works.
		try {
			order = (Order) jp.getArgs()[1];
			orderUserId = order.getUser().getId();
		} catch (Exception e) {}
		
		User u = null;
		try { // Check if the request is from someone who's logged in
			u = (User) session.getAttribute("user");
			if (!u.getAccessLevel().equals("emp") && u.getId() != orderUserId) {
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
