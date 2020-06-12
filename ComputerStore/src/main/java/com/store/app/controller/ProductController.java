package com.store.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.model.Product;
import com.store.app.service.ProductService;

@CrossOrigin
@RestController
public class ProductController {
	
	// Access Service Bean
	@Autowired
	private ProductService ps;
	
	// Mappings
	
		@PostMapping("/product")
		public Product createProduct(@RequestBody Product p) {
			return ps.createProduct(p);
		}
		
		@GetMapping("/product/{id}")
		public Product getProductById(@PathVariable("id") int id) {
			return ps.getProductById(id);
		}
		
		@GetMapping("/product/{name}")
		public Product getProductByName(@PathVariable("name") String name) {
			return ps.getProductByName(name);
		}
		
		@GetMapping("/products")
		public List<Product> getAllProducts() {
			return ps.getAllProducts();
		}
		
		@PutMapping("/product")
		public Product updateProduct(@RequestBody Product p) {
			return ps.updateProduct(p);
		}
		
		@PutMapping("/product/{name}/{stock}")
		public void updateProductStockByName(@PathVariable("name") String name, @PathVariable("stock") int stock) {
			ps.updateProductStockByName(name, stock);
		}
		
		@DeleteMapping("/product/{id}") 
		public void deleteProduct(@PathVariable("id") int id) {
			ps.deleteProductById(id);
		}

}
