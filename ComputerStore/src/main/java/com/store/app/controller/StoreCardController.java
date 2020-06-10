package com.store.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	public StoreCard createStoreCard(HttpSession session, @RequestBody StoreCard s) {
		// we need to fix this. Store cards can only be created when you have a valid User that the card can be attached to.
		return storecardservice.createStoreCard(s);
	}

	@GetMapping("/storedcard/{id}")
	public StoreCard getStoreCardById(HttpSession session, @PathVariable("card_id" )int id) {
		return storecardservice.getStoreCardById(id);
	}

	@GetMapping("/storecards")
	public List<StoreCard> getAllStoreCards(HttpSession session) {
		return storecardservice.getAllStoreCards();
	}

	@PutMapping("/storedcard")
	public StoreCard updateStoreCard(HttpSession session, @RequestBody StoreCard s) {
		return storecardservice.updateStoreCard(s);
	}

	@DeleteMapping("/storedcard/{id}")
	public void deleteStoreCardById(HttpSession session, @PathVariable("card_id")int id) {
		storecardservice.deleteStoreCardById(id);
	}

}
