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

@Entity
@Table(name = "StoreCard")
public class StoreCard {
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Id
	@Column(name = "card_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int card_id;
	
	@Column(name = "balance", nullable = false)
	private double balance;
	
	// Constructors
	
	// a useless comment
	public StoreCard() {
		super();
	}
	
	public StoreCard(User user, int card_id, double balance) {
		super();
		this.user = user;
		this.card_id = card_id;
		this.balance = balance;
	}
	
	
	// Getters and Setters
	
	
	public int getCard_id() {
		return card_id;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
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
		return "StoreCard [card_id=" + card_id + ", balance=" + balance + " " + ", user_id=" + user.getId() + "]";
	}
	

	
	

}