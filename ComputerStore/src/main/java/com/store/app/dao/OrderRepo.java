package com.store.app.dao;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.app.model.Order;
import com.store.app.model.User;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
	public List<Order> findByUser(User user);
}
