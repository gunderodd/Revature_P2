package com.store.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.app.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	public Optional<Product> findByName(String name);

}
