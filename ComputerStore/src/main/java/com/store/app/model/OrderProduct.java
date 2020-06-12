package com.store.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// This whole table maps out the ManyToMany relationship
// between Orders/Products

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="orderProductId")
@Entity
@Table(name = "Order_Product")
public class OrderProduct {
	@EmbeddedId 
	private OrderProductId orderProductId;
	
	@MapsId("orderId")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;
	
	@MapsId("productId")
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

	public OrderProduct(Order order, Product product, int quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	// Getters and Setters
	
	public OrderProductId getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(OrderProductId orderProductId) {
		this.orderProductId = orderProductId;
	}
	
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

	// toString

	@Override
	public String toString() {
		return "Order_Product [order=" + order + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
}
