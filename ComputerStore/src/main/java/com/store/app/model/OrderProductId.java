package com.store.app.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProductId implements Serializable {
	private static final long serialVersionUID = -6320247623065347911L;
	private int orderId;
	private int productId;
	
	public OrderProductId(int orderId, int productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "OrderProductId [orderId=" + orderId + ", productId=" + productId + "]";
	}
	
	
}
