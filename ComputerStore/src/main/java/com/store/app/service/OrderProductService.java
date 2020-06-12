package com.store.app.service;

import java.util.List;

import com.store.app.model.OrderProduct;

public interface OrderProductService {
	// CRUD
	
	// Create
	public OrderProduct createOrderProduct(OrderProduct op);
	
	// Read
	public OrderProduct getOrderProductByOrderProductId(int id);
	public List<OrderProduct> getByOrderId(int id);
	public List<OrderProduct> getAllOrderProducts();
	
	// Update
	public OrderProduct updateOrderProduct(OrderProduct op);
	
	// Delete
	public void deleteOrderProductById(int id);
	public void deleteOrderProduct(OrderProduct op);
}
