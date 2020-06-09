package com.store.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.app.model.Order_Product;

public interface Order_ProductRepo extends JpaRepository<Order_Product, Integer> {
	public Optional<Order_Product> findByOrderId(int id);
}