package com.store.app.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.store.app.exception.BusinessException;
import com.store.app.model.Product;
import com.store.app.model.User;
import com.store.app.service.ProductService;
import com.store.app.service.UserService;

@Aspect
@Configuration
public class OrderProductAspect {
	@Autowired
	ProductService ps;
	@Autowired
	UserService us;
	
	// checks if we're logged in before doing anything
	@Before("execution(* com.store.app.controller.OrderProductController.*OrderProduct(..))")
	public void checkIfLoggedIn(JoinPoint jp) {
		String[] args = (String[]) jp.getArgs()[0];
		try {
			Product product = ps.getProductById(Integer.parseInt(args[0]));
			int quantity = Integer.parseInt(args[1]);
			User real = us.getUserByUsername(args[2]);
			if (real == null || !(real.getPassword().equals(args[3]))) {
				// TODO LOG
				throw new BusinessException("You cannot add to cart without proper authentification");
			}
			if (quantity < 0) {
				// TODO LOG
				throw new BusinessException("You cannot set a quantity to a negative number.");
			}
			if (product == null) {
				// TODO LOG
				throw new BusinessException("You cannot create an OrderProduct with a null product");
			}
		} catch (IndexOutOfBoundsException | NumberFormatException e ) {
			// TODO LOG
			throw new BusinessException("Incorrect information passed");
		}
	}
}
