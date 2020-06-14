package com.store.app.service.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.dao.OrderRepo;
import com.store.app.model.Order;
import com.store.app.model.User;
import com.store.app.service.OrderService;


// Will it work to have one by user id and one by order id?

@Service
public class OrderServiceImpl implements OrderService {
	
	// Access OrderRepo Bean
	private OrderRepo or;
	
	@Autowired
	public OrderServiceImpl(OrderRepo or) {
		this.or = or;
	}

	// Basic CRUD Methods...
	
	@Override
	public Order createOrder(Order order) {
		return or.save(order);
	}

	@Override
	public Order getOrderByOrderId(int id) {
		return or.findById(id).get();
	}

	@Override
	public List<Order> getOrderByUser(User user) {
		return or.findByUser(user);
	}

	@Override
	public List<Order> getAllOrders() {
		return or.findAll();
	}

	@Override
	public Order updateOrder(Order order) {
		return or.save(order);
	}

	@Override
	public void deleteOrderById(int id) {
		or.deleteById(id);
	}

	// Other methods
	
	@Override
	public Order getCartByUser(User user) {
		List<Order> orders = or.findByUser(user);
		for (Order order : orders) {
			if (order.getStatus().equals("cart"))
				return order;
		}
		Order cart = new Order();
		cart.setUser(user);
		cart.setStatus("cart");
		cart.setCreatedAt(Date.from(Instant.now()));
		or.save(cart);
		return cart;
	}

	@Override
	public Order buyOrder(Order order) {
		
		// TODO Auto-generated method stub
		return null;
	}

}
