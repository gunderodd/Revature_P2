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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// This whole table maps out the ManyToMany relationship
// between Orders/Products

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
@Table(name = "Order_Product")
public class OrderProduct {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;
	
	// quantity is the number of products 
	@Column(name = "quantity")
	private int quantity;

	// Constructors
	
	public OrderProduct() {
		super();
	}

	public OrderProduct(int id, Order order, Product product, int quantity) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	// Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		setOrder(order, true);
	}
	
	public void setOrder(Order order, boolean reciprocate) {
		this.order = order;
		if (reciprocate)
			order.addOrderProduct(this, false);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		setProduct(product, true);
	}
	
	public void setProduct(Product product, boolean reciprocate) {
		this.product = product;
		if (reciprocate)
			product.addOrderProduct(this, false);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", order=" + order + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
	public boolean equals(OrderProduct other) {
		if (other.getId() == this.id)
			return true;
		return false;
	}
}
