package com.store.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.dao.Order_ProductRepo;
import com.store.app.model.Order_Product;

@Service
public class Order_ProductServiceImpl implements Order_ProductService {
	
	// Access OrderRepo Bean
	private Order_ProductRepo opr;
	
	@Autowired
	public Order_ProductServiceImpl(Order_ProductRepo opr) {
		this.opr = opr;
	}

	
	// Basic CRUD Methods...
	
	@Override
	public Order_Product createOrder_Product(Order_Product order_product) {
		return opr.save(order_product);
	}

	@Override
	public Order_Product getOrderProductByOrderProductId(int id) {
		return opr.findById(id).get();
	}

	// this is our custom one
	
	@Override
	public Order_Product getByOrderId(int id) {
		return opr.findByOrderId(id).get();
	}

	@Override
	public List<Order_Product> getAllOrderProducts() {
		return opr.findAll();
	}

	@Override
	public Order_Product updateOrderProduct(Order_Product order_product) {
		return opr.save(order_product);
	}

	@Override
	public void deleteOrderProductById(int id) {
		opr.deleteById(id);
		
	}

}
