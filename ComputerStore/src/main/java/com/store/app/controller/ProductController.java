package com.store.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.model.Product;
import com.store.app.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
	@Autowired
	private ProductService ps;
		
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return ps.getProductById(id);
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return ps.getAllProducts();
	}

	@PutMapping("/product/{name}/{stock}")
	public Product updateProductStockByName(@PathVariable("name") String name, @PathVariable("stock") int stock) {
		return ps.updateProductStockByName(name, stock);
	}
}
