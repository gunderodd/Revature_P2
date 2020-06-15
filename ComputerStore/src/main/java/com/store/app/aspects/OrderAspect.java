package com.store.app.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.store.app.exception.BusinessException;
import com.store.app.model.User;
import com.store.app.service.UserService;

@Aspect
@Configuration
public class OrderAspect {
	@Autowired
	UserService us;
	
	// This checks if the user is an admin, or if the user owns the order that's being passed.
	@Before("execution(* com.store.app.controller.OrderController.*UserCart(..))")
	public void verifyUser(JoinPoint jp) {
		String[] args = (String[]) jp.getArgs()[0];
		User user;
		try {
			user = us.getUserByUsername(args[0]);
			if (user == null || !(user.getPassword().equals(args[1]))) {
				// TODO LOG
				throw new BusinessException("You cannot get your cart with incorrect login information");
			}
		} catch (IndexOutOfBoundsException | NumberFormatException e ) {
			// TODO LOG
			throw new BusinessException("Incorrect information passed");
		}
	}
}
