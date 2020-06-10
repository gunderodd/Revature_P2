package com.store.app.service;

import java.util.List;

import com.store.app.model.Order_Product;

public interface Order_ProductService {
	// CRUD
	
	// Create
	public Order_Product createOrder_Product(Order_Product order_product);
	
	// Read
	public Order_Product getOrderProductByOrderProductId(int id);
	public Order_Product getByOrderId(int id);
	public List<Order_Product> getAllOrderProducts();
	
	// Update
	public Order_Product updateOrderProduct(Order_Product order_product);
	
	// Delete
	public void deleteOrderProductById(int id);
}
