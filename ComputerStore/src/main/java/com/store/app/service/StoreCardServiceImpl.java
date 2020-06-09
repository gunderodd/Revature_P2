package com.store.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.dao.StoreCardRepo;
import com.store.app.model.StoreCard;

@Service
public class StoreCardServiceImpl implements StoreCardService {
	
	// Access StoreCardRepo Bean
	private StoreCardRepo repo;
	
	@Autowired
	public StoreCardServiceImpl(StoreCardRepo repo) {
		this.repo = repo;
	}
	
	// Basic CRUD Methods...

	@Override
	public StoreCard createStoreCard(StoreCard s) {
		return repo.save(s);
	}

	@Override
	public StoreCard getStoreCardById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<StoreCard> getAllStoreCards() {
		return repo.findAll();
	}

	@Override
	public StoreCard updateStoreCard(StoreCard s) {
		return repo.save(s);
	}

	@Override
	public void deleteStoreCardById(int id) {
		repo.deleteById(id);
	}
	
	// ...other methods:
	
}
