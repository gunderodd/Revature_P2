package com.store.app.service;

import java.util.List;

import com.store.app.model.OrderProduct;

public interface OrderProductService {
	// CRUD
	
	// Create
	public OrderProduct createOrderProduct(OrderProduct order_product);
	
	// Read
	public OrderProduct getOrderProductByOrderProductId(int id);
	public List<OrderProduct> getByOrderId(int id);
	public List<OrderProduct> getAllOrderProducts();
	
	// Update
	public OrderProduct updateOrderProduct(OrderProduct order_product);
	
	// Delete
	public void deleteOrderProductById(int id);
}
