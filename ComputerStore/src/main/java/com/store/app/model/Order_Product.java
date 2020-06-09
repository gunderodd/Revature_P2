//package com.store.app.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "Order_Product")
//public class Order_Product {
//	
//	// user_id
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
//	private User user;
//	
//	// order_id
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "order_id")
//	private Order order;
//	
//	@Column(name = "quantity")
//	private int quantity;
//
//	// Constructors
//	
//	public Order_Product() {
//		super();
//	}
//	
//	public Order_Product(User user, Order order, int quantity) {
//		super();
//		this.user = user;
//		this.order = order;
//		this.quantity = quantity;
//	}
//	
//	// Getters and Setters
//
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	// To String
//	
//	@Override
//	public String toString() {
//		return "Order_Product [user=" + user.getId() + ", order=" + order.getId() + ", quantity=" + quantity + "]";
//	}
//	
//	
//
//}
