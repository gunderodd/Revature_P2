package com.store.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
		return os.getOrderByOrderId(id);
	}
	
	@GetMapping("/orders/{user_id}")
	public List<Order> getOrdersByUserId(@PathVariable("user_id") int user_id) {
		User user = us.getUserById(user_id);
		return os.getOrderByUser(user);
	}
	
	@GetMapping("/cart/{user_id}")
	public Order getCartByUserId(@PathVariable("user_id") int user_id) {
		User user = us.getUserById(user_id);
		return os.getCartByUser(user);
	}
	
		//update
	@PutMapping("/order")
	public Order updateOrder(@RequestBody Order order) {
		return os.updateOrder(order);
	}
	
	@PutMapping("/buyCart")
	public Order buyOrder(HttpSession session, @RequestBody Order order) {
		//TODO aspect
		if (order.getStatus().equals("cart")) {
			for (OrderProduct op : order.getOrderProductList()) {
				if (op.getQuantity() > op.getProduct().getStock()) {
					throw new BusinessException("You are trying to buy too much of this product:" + op.getProduct().getName());
				}
			}
			for (OrderProduct op: order.getOrderProductList()) {
				Product p = op.getProduct();
				p.setStock(p.getStock() - op.getQuantity());
				ps.updateProduct(p);
			}
			order.setStatus("bought");
			os.updateOrder(order);
			return order;
		} else {
			throw new BusinessException("You cannot buy an order not marked as \"cart\"");
		}
	}
	
		//delete
	@DeleteMapping("/order/{id}")
	public void deleteOrder(@PathVariable("id") int id) {
		os.deleteOrderById(id);
	}
	
}
