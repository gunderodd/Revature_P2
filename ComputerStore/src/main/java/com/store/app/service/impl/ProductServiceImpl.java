package com.store.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.dao.ProductRepo;
import com.store.app.model.Product;
import com.store.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	// Access Repo Bean
	private ProductRepo pr;
	
	@Autowired
	public ProductServiceImpl(ProductRepo pr) {
		this.pr = pr;
	}
	
	
	// Basic CRUD Methods...

	@Override
	public Product createProduct(Product p) {
		return pr.save(p);
	}

	@Override
	public Product getProductById(int id) {
		return pr.findById(id).get();
	}

	@Override
	public Product getProductByName(String name) {
		return pr.findByName(name);
	}

	@Override
	public List<Product> getAllProducts() {
		return pr.findAll();
	}

	@Override
	public Product updateProduct(Product p) {
		return pr.save(p);
	}

	@Override
	public void deleteProductById(int id) {
		pr.deleteById(id);
	}


	@Override
	public void updateProductStockByName(String name, int stock) {
		Product product = pr.findByName(name);
		product.setStock(stock);
		pr.save(product);
		
	}
	
	// ...Other Methods:


}
