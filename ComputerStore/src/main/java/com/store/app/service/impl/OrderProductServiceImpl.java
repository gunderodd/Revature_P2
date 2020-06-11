package com.store.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.dao.OrderProductRepo;
import com.store.app.dao.OrderRepo;
import com.store.app.dao.ProductRepo;
import com.store.app.model.OrderProduct;
import com.store.app.service.OrderProductService;
import com.store.app.service.OrderService;

@Service
public class OrderProductServiceImpl implements OrderProductService {
	
	// Access OrderRepo Bean
	private OrderProductRepo opr;
	private OrderService os;
	
	@Autowired
	public OrderProductServiceImpl(OrderProductRepo opr) {
		this.opr = opr;
	}

	
	// Basic CRUD Methods...
	
	@Override
	public OrderProduct createOrderProduct(OrderProduct orderProduct) {
		return opr.save(orderProduct);
	}

	@Override
	public OrderProduct getOrderProductByOrderProductId(int id) {
		return opr.findById(id).get();
	}

	// this is our custom one
	
	@Override
	public List<OrderProduct> getByOrderId(int id) {
		return opr.findByOrder(os.getOrderByOrderId(id)).get();
	}

	@Override
	public List<OrderProduct> getAllOrderProducts() {
		return opr.findAll();
	}

	@Override
	public OrderProduct updateOrderProduct(OrderProduct orderProduct) {
		return opr.save(orderProduct);
	}

	@Override
	public void deleteOrderProductById(int id) {
		opr.deleteById(id);
		
	}

}
