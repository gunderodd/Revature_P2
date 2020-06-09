package com.store.app.service;

import java.util.List;

import com.store.app.model.StoreCard;

public interface StoreCardService {
	// CRUD
	
	// Create
	public StoreCard createStoreCard(StoreCard s);
	
	// Read
	public StoreCard getStoreCardById(int id);
	public List<StoreCard> getAllStoreCards();
	
	// Update
	public StoreCard updateStoreCard(StoreCard s);
	
	// Delete
	public void deleteStoreCardById(int id);
	
}
