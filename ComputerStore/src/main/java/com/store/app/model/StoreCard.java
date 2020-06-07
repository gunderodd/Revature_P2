package com.store.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StoreCard")
public class StoreCard {
	
	@Id
	@Column(name = "card_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int card_id;
	
	@Column
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "user_id")
	private int user_id;
	
	@Column(name = "balance", nullable = false)
	private double balance;
	
	// Constructors
	
	public StoreCard() {
		super();
	}
	
	public StoreCard(int card_id, int user_id, double balance) {
		super();
		this.card_id = card_id;
		this.user_id = user_id;
		this.balance = balance;
	}
	
	// Getters and Setters
	
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
		return "StoreCard [card_id=" + card_id + ", user_id=" + user_id + ", balance=" + balance + "]";
	}
	
	

}