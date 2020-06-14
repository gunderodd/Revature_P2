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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// general notes: 
// 1. add in not nullable later if we want

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
@Table(name = "Orders")
public class Order {
	
	@OneToMany(mappedBy = "order")
	private List<OrderProduct> orderProductList;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	// "cart" or "bought"
	@Column(name = "status")
	private String status;
	
	@Column(name = "createdAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	
	// Constructors
	public Order() {
		super();
	}
	
	public Order(int id, User user, String status, Date createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.status = status;
		this.createdAt = createdAt;
	}
	
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		setUser(user, true);
	}
	public void setUser(User user, boolean reciprocate) {
		this.user = user;
		if (reciprocate) {
			user.addOrder(this, false);
		}
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
	public void addOrderProduct(OrderProduct op) {
		this.addOrderProduct(op, true);
	}
	public void addOrderProduct(OrderProduct op, boolean reciprocate) {
		if (op != null) {
			if (this.orderProductList.contains(op)) {
				this.orderProductList.set(orderProductList.indexOf(op), op);
			} else {
				this.orderProductList.add(op);
			}
			if (reciprocate) 
				op.setOrder(this, false);
		}
	}
	public void removeOrderProduct(OrderProduct op) {
		this.orderProductList.remove(op);
		op.setOrder(null);
	}
	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}

	
	@Override
	public String toString() {
		return "Order [orderProductList=" + orderProductList + ", id=" + id + ", user=" + user + ", status=" + status
				+ ", createdAt=" + createdAt + "]";
	}

	public boolean equals(Order other) {
		if (other.getId() == this.id)
			return true;
		return false;
	}
}
