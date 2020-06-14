package com.store.app.dao;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.app.model.Order;
import com.store.app.model.OrderProduct;
import com.store.app.model.Product;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Integer> {
	public List<OrderProduct> findByOrder(Order o);
	public List<OrderProduct> findByProduct(Product p);
//	public Optional<OrderProduct> findByOrderProductId(int orderProductId);
}
