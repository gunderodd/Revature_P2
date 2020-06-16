package com.store.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.exception.BusinessException;
import com.store.app.model.Order;
import com.store.app.model.OrderProduct;
import com.store.app.model.Product;
import com.store.app.model.User;
import com.store.app.service.OrderProductService;
import com.store.app.service.OrderService;
import com.store.app.service.ProductService;
import com.store.app.service.UserService;

// Why are we accessing an instance of the interface? how does
// that let us use the methods?

// any with id don't work, why?
// how to have user_id mapped, not user object? as in what is returned from postman

@CrossOrigin(origins = "*")
@RestController
public class OrderController {

	// Access Bean Service
	@Autowired
	public OrderService os;
	@Autowired
	public UserService us;
	@Autowired
	public ProductService ps;
	@Autowired
	public OrderProductService ops;
	
	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return os.getAllOrders();
	}
	
	@GetMapping("/orders/{id}")
	public List<Order> getOrdersByUserId(@PathVariable("id") int id) {
		User user = us.getUserById(id);
		return os.getOrderByUser(user);
	}
	
	@PostMapping("/getusercart")
	public Order getUserCart(@RequestBody String[] args) {
		User user = us.getUserByUsername(args[0]);
		return os.getCartByUser(user);
	}
	
	@PutMapping("/buycart")
	public Order buyUserCart(@RequestBody String[] args) {
		User user = us.getUserByUsername(args[0]);
		Order cart = os.getCartByUser(user);
		if (cart.getOrderProductList().isEmpty()) {
			throw new BusinessException("You cannot purchase an empty cart!");
		}
		cart.setStatus("bought");
		os.updateOrder(cart);
		return cart;
	}
	
	@PutMapping("/clearcart")
	public Order clearUserCart(@RequestBody String[] args) {
		User user = us.getUserByUsername(args[0]);		
		Order cart = os.getCartByUser(user);	
		while (!(cart.getOrderProductList().isEmpty())) {
			OrderProduct op = cart.getOrderProductList().get(0);
			Product product = op.getProduct();
			product.setStock(product.getStock() + op.getQuantity());
			product.removeOrderProduct(op);
			cart.removeOrderProduct(op);
			ps.updateProduct(product);
			ops.deleteOrderProduct(op);
		}
		return cart;
	}
}
