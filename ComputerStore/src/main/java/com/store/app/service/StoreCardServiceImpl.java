package com.store.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.dao.StoreCardRepo;
import com.store.app.model.StoreCard;

@Service
public class StoreCardServiceImpl implements StoreCardService {
	
	// Access StoreCardRepo Bean
	private StoreCardRepo scr;
	// Access UserRepo Bean
//	private UserRepo ur;
	
	
	@Autowired
	public StoreCardServiceImpl(StoreCardRepo scr) {
		this.scr = scr;
//		this.ur = ur;
	}
	
	// Basic CRUD Methods...

	@Override
	public StoreCard createStoreCard(StoreCard s) {
		return scr.save(s);
	}

	@Override
	public StoreCard getStoreCardById(int id) {
		return scr.findById(id).get();
	}

	@Override
	public List<StoreCard> getAllStoreCards() {
		return scr.findAll();
	}

	@Override
	public StoreCard updateStoreCard(StoreCard s) {
		return scr.save(s);
	}

	@Override
	public void deleteStoreCardById(int id) {
		scr.deleteById(id);
	}
	
	// ...other methods:
	
}
