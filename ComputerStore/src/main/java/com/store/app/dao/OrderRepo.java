package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.app.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
	
	// explain to me again why we can but don't have to do the list thing here?
	
}
