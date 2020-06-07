package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.app.model.StoreCard;

public interface StoreCardRepo extends JpaRepository<StoreCard, Integer>{
	
}
