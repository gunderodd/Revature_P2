package com.store.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.model.StoreCard;
import com.store.app.service.StoreCardService;

@CrossOrigin
@RestController
public class StoreCardController {
	
	//Access Service Bean
	
	@Autowired
	private StoreCardService storecardservice;
	
	// Mappings
	
	@PostMapping("/storecard")
	public StoreCard createStoreCard(@RequestBody StoreCard s) {
		return storecardservice.createStoreCard(s);
	}

	@GetMapping("/storedcard/{id}")
	public StoreCard getStoreCardById(@PathVariable("card_id" )int id) {
		return storecardservice.getStoreCardById(id);
	}

	@GetMapping("/storecards")
	public List<StoreCard> getAllStoreCards() {
		return storecardservice.getAllStoreCards();
	}

	@PutMapping("/storedcard")
	public StoreCard updateStoreCard(@RequestBody StoreCard s) {
		return storecardservice.updateStoreCard(s);
	}

	@DeleteMapping("/storedcard/{id}")
	public void deleteStoreCardById(@PathVariable("card_id")int id) {
		storecardservice.deleteStoreCardById(id);
	}

}
