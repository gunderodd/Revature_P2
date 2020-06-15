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
	
	// Mappings
	
		// create
	@PostMapping("/order")
	public Order createOrder(@RequestBody Order order) {
		return os.createOrder(order);
	}
	
		//read
	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return os.getAllOrders();
	}
	
	@GetMapping("/order/{id}")
	public Order getOrderByOrderId(@PathVariable("id") int id) {
		return os.getOrderById(id);
	}
	
	@GetMapping("/orders/{user_id}")
	public List<Order> getOrdersByUserId(@PathVariable("user_id") int user_id) {
		User user = us.getUserById(user_id);
		return os.getOrderByUser(user);
	}
	
	@PostMapping("/getusercart")
	public Order getUserCart(@RequestBody String[] args) {
		User user;
		try {
			user = us.getUserByUsername(args[0]);
			if (user == null || !(user.getPassword().equals(args[1]))) {
				// TODO LOG
				throw new BusinessException("You cannot get your cart with incorrect login information");
			}
		} catch (IndexOutOfBoundsException | NumberFormatException e ) {
			// TODO LOG
			throw new BusinessException("Incorrect information passed");
		}
		return os.getCartByUser(user);
	}
	
		//update
	@PutMapping("/order")
	public Order updateOrder(@RequestBody Order order) {
		return os.updateOrder(order);
	}
	
	@PutMapping("/buycart")
	public Order buyCart(@RequestBody String[] args) {
		User user;
		try {
			user = us.getUserByUsername(args[0]);
			if (user == null || !(user.getPassword().equals(args[1]))) {
				// TODO LOG
				throw new BusinessException("You cannot get your cart with incorrect login information");
			}
		} catch (IndexOutOfBoundsException | NumberFormatException e ) {
			// TODO LOG
			throw new BusinessException("Incorrect information passed");
		}
		
		
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
		User user;
		try {
			user = us.getUserByUsername(args[0]);
			if (user == null || !(user.getPassword().equals(args[1]))) {
				// TODO LOG
				throw new BusinessException("You cannot get your cart with incorrect login information");
			}
		} catch (IndexOutOfBoundsException | NumberFormatException e ) {
			// TODO LOG
			throw new BusinessException("Incorrect information passed");
		}
		
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
	
		//delete
	@DeleteMapping("/order/{id}")
	public void deleteOrder(@PathVariable("id") int id) {
		os.deleteOrderById(id);
	}
	
}
