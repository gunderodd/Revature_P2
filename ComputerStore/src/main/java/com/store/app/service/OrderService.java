package com.store.app.service;

import java.util.List;

import com.store.app.model.Order;

public interface OrderService {
	// CRUD
	
	// Create
	public Order createOrder(Order order);
	
	// Read
	public Order getOrderByOrderId(int id);
	public Order getOrderByUserId(int user_id);
	public List<Order> getAllOrders();
	
	// Update
	public Order updateOrder(Order order);
	
	// Delete
	public void deleteOrderById(int id);

}
