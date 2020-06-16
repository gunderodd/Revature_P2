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
				throw new BusinessException("You cannot add to cart without proper authentification. Invalid information: username: " + args[2] + " & password: " + args[3]);
			}
			if (quantity < 0) {
				throw new BusinessException("You cannot set a quantity to a negative number. quantity: " + quantity + "username: " + args[2]);
			}
			if (product == null) {
				throw new BusinessException("You cannot create an OrderProduct with a null product. productId: " + args[0] + " quantity: " + quantity + "username: " + args[2]);
			}
		} catch (IndexOutOfBoundsException | NumberFormatException e ) {
			String s = "";
			int loops = args.length;
			if (loops > 5)
				loops = 5;
			for (int i = 0; i < loops; i++) {
				s = s.concat(" ");
				s = s.concat(args[i]);
			}
			throw new BusinessException("Incorrect information passed. information: [ " + s + "] should be: [ productId, quantity, username, password ]");
		}
	}
}
