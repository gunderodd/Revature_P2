package com.store.app.service;

import java.util.List;

import com.store.app.model.Order;
import com.store.app.model.User;

public interface OrderService {
	// CRUD
	
	// Create
	public Order createOrder(Order order);
	
	// Read
	public Order getOrderByOrderId(int id);
	public List<Order> getOrderByUser(User user);
	public List<Order> getAllOrders();
	public Order getCartByUser(User user);
	
	// Update
	public Order updateOrder(Order order);
	public Order buyOrder(Order order);
	
	// Delete
	public void deleteOrderById(int id);

	

}
