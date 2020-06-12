package com.store.app.aspects;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.store.app.exception.BusinessException;
import com.store.app.model.StoreCard;
import com.store.app.model.User;

@Aspect
public class StoreCardAspect {
	
	// This checks if the user owns the card being update, or if they're an admin
	@Before("execution(* com.store.app.controller.StoreCardController.update*(..))")
	public void beforeGet(JoinPoint jp) {
		HttpSession session = (HttpSession) jp.getArgs()[0];
		StoreCard storeCard = (StoreCard) jp.getArgs()[1];
		User u = null;
		try {
			u = (User) session.getAttribute("user");
			if (u.getAccessLevel() < 1 && u.toString().compareTo(storeCard.getUser().toString()) != 0) {
				// TODO LOG EXCEPTION
				throw new BusinessException("You do not have a high enough access level to access this resource.");
			}
		} catch (NullPointerException e) {
			// TODO LOG
			throw new BusinessException("You are not logged in. Please log in before trying to access this resource.");
		}
	}
	
	// check if the user is logged in before creating a card for them
	@Before("execution(* com.store.app.controller.StoreCardController.create*(..))")
	public void beforeCreate(JoinPoint jp) {
		HttpSession session = (HttpSession) jp.getArgs()[0];
		StoreCard storecard = (StoreCard) jp.getArgs()[1];
		// TODO stub
	}
}
