package com.store.app.service;

import java.util.List;

import com.store.app.model.Product;

public interface ProductService {
	// CRUD
	
	// Create
	public Product createProduct(Product p);
	
	// Read
	public Product getProductById(int id);
	public Product getProductByName(String name);
	public List<Product> getAllProducts();
	
	// Update
	public Product updateProduct(Product p);
	
	// Delete
	public void deleteProductById(int id);

	public void updateProductStockByName(String name, int stock);
}
