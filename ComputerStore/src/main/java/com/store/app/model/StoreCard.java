package com.store.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Adding User to the constructor?

@Entity
@Table(name = "StoreCard")
public class StoreCard {
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Id
	@Column(name = "card_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cardId;
	
	@Column(name = "balance", nullable = false)
	private double balance;
	
	// Constructors
	
	public StoreCard() {
		super();
	}
	
	public StoreCard(User user, int cardId, double balance) {
		super();
		this.user = user;
		this.cardId = cardId;
		this.balance = balance;
	}
	
	
	// Getters and Setters
	
	
	public int getCardId() {
		return cardId;
	}
	
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	//To String
	@Override
	public String toString() {
		return "StoreCard [cardId=" + cardId + ", balance=" + balance + " " + ", user_id=" + user.getUserId() + "]";
	}

}