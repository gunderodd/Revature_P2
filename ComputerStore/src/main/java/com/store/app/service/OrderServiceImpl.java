package com.store.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.dao.OrderRepo;
import com.store.app.model.Order;


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
	public Order getOrderByUserId(int user_id) {
		return or.findById(user_id).get();
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
	
	// ...and other Methods:

}
