package com.store.app.model;

import java.util.List;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// general notes: 
// 1. add in not nullable later if we want


@Entity
@Table(name = "Orders")
public class Order {
	
	@OneToMany(mappedBy = "order")
	private List<OrderProduct> orderProductList;
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "createdAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	
	// Constructors
	public Order() {
		super();
	}
	public Order(int orderId, User user, String status, Date createdAt) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.status = status;
		this.createdAt = createdAt;
	}
	
	// Getters and Setters
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}
	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}
	// toString
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user_id=" + user.getUserId() + ", status=" + status + ", createdAt=" + createdAt + "]";
	}
}
