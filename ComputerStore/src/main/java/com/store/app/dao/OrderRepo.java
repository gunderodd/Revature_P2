package com.store.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.app.model.Order;
import com.store.app.model.User;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
	List<Order> findByUser(User user);
	
	// explain to me again why we can but don't have to do the list thing here?
	
}
