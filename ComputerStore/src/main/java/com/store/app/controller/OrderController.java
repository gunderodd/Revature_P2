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

import com.store.app.model.Order;
import com.store.app.service.OrderService;


// Why are we accessing an instance of the interface? how does
// that let us use the methods?

// any with id don't work, why?
// how to have user_id mapped, not user object? as in what is returned from postman

@CrossOrigin
@RestController
public class OrderController {

	// Access Bean Service
	@Autowired
	public OrderService os;
	
	// Mappings
	
		// create
	@PostMapping("/order")
	public Order createUser(@RequestBody Order order) {
		return os.createOrder(order);
	}
	
		//read
	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return os.getAllOrders();
	}
	
	@GetMapping("/order{id}")
	public Order getOrderByOrderId(@PathVariable("id") int id) {
		return os.getOrderByOrderId(id);
	}
	
	@GetMapping("/order{user_id}")
	public Order getOrderByUserId(@PathVariable("user_id") int user_id) {
		return os.getOrderByUserId(user_id);
	}
	
		//update
	@PutMapping("/order")
	public Order updateOrder(@RequestBody Order order) {
		return os.updateOrder(order);
	}
	
		//delete
	@DeleteMapping("/order{id}")
	public void deleteOrder(@PathVariable("id") int id) {
		os.deleteOrderById(id);
	}
	
}
