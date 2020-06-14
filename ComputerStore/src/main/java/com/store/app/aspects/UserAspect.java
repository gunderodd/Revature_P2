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
	
	
	@Before("execution(* com.store.app.controller.UserController.get*(..))"
			+ "&& execution(* com.store.app.controller.UserController.delete*(..))")
	public void beforeGet(JoinPoint jp) {
		HttpSession session = (HttpSession) jp.getArgs()[0];
		User u = null;
		// please someone come up with something better here lol
		// I think this is a little too hacky, but it works for all get methods, so....
		String pathVar = "";
		int pathVarInt = 0;
		try {
			pathVar = jp.getArgs()[1].toString();
			pathVarInt = Integer.parseInt(pathVar);
		} catch (Exception e) {}
		
		try { // Check if the request is from someone who's logged in
			u = (User) session.getAttribute("user");
			if (!u.getAccessLevel().equals("emp") && u.getId() != pathVarInt && !u.getUsername().equals(pathVar)) {
				// TODO LOG EXCEPTION
				throw new BusinessException("You do not have a high enough access level to view this resource.");
			}
		} catch (NullPointerException e) {
			// TODO LOG EXCEPTION
			throw new BusinessException("You are not logged in. Please log in before trying to access this resource.");
		}
	}
	
	@Before("execution(* com.store.app.controller.UserController.update*(..))")
	public void beforeUpdate(JoinPoint jp) {
		HttpSession session = (HttpSession) jp.getArgs()[0];
		User updated = (User) jp.getArgs()[1];
		User u = null;
		try { // Check if the request is from someone who's logged in
			u = (User) session.getAttribute("user");
			if (!u.getAccessLevel().equals("emp") && u.getId() != updated.getId() && !u.getUsername().equals(updated.getUsername())) {
				// TODO LOG EXCEPTION
				throw new BusinessException("You do not have a high enough access level to update this resource.");
			} else if (u.getAccessLevel() != updated.getAccessLevel()) {
				// TODO LOG HUGE WARNING, USER JUST TRIED TO UPDATE THEIR ACCESS LEVEL
				throw new BusinessException("You do not have a high enough access level to update this resource.");
			}
		} catch (NullPointerException e) {
			// TODO LOG EXCEPTION
			throw new BusinessException("You are not logged in. Please log in before trying to update this resource.");
		}
	}
	
	// need an aspect that runs each time we are given a User object.
	// need to ensure that the User's information is all valid before bothering to do checks etc.
	
}
