package com.store.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// This whole table maps out the ManyToMany relationship
// between Orders/Products

@Entity
@Table(name = "Order_Product")
public class Order_Product {
	
	@Id
	@Column(name = "orderProduct_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
		
	// order_id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;
	
	// product_id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;
	
	// quantity is the number of products 
	@Column(name = "quantity")
	private int quantity;

	// Constructors
	
	public Order_Product() {
		super();
	}

	public Order_Product(Order order, Product product, int quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	// Getters and Setters
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// To String

	@Override
	public String toString() {
		return "Order_Product [order=" + order + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
}
