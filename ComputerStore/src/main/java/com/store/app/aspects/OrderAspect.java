package com.store.app.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class OrderAspect {
	
	// get, update, delete
	// only controlled by admin or user associated with the order
}
