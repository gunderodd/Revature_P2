package com.store.app.model;

import java.util.List;

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

// general notes: 
// 1. add in not nullable later if we want


@Entity
@Table(name = "\"Order\"")
public class Order {
	
	@OneToMany(mappedBy = "order")
	private List<Order_Product> order_productList;
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	// user_id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "status")
	private String status;
	
	// Make this datetime object
	@Column(name = "created_at")
	private String created_at;

	
	
	// Constructors
	
	public Order() {
		super();
	}



	public Order(int id, User user, String status, String created_at) {
		super();
		this.id = id;
		this.user = user;
		this.status = status;
		this.created_at = created_at;
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
		this.user = user;
	}
	
	
	
	public String getStatus() {
		return status;
	}
	
	
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public String getCreated_at() {
		return created_at;
	}
	
	
	
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	// To String
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user.getId() + ", status=" + status + ", created_at=" + created_at + "]";
	}
	

}
