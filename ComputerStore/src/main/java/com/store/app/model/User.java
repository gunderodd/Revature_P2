package com.store.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// Ethan note: I think we should change this to 
// User singular (but if we do use escapes for reserved keyword

//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
@Table(name = "Users")
public class User {
	
	@OneToMany(mappedBy = "user")
	@JsonBackReference
	private List<Order> orderList;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	// "cust" - Customer
	// "emp" - Employee
	@Column(name = "access_level", nullable = false)
	private String accessLevel;
	
	// Constructors
	
	public User() {
		super();
	}

	public User(int id, String username, String password, String accessLevel) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.accessLevel = accessLevel;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	public List<Order> getOrderList() {
		return orderList;
	}
	
	public void addOrder(Order o) {
		this.addOrder(o, true);
	}
	
	public void addOrder(Order o, boolean reciprocate) {
		if (o != null) {
			if (this.orderList.contains(o)) {
				this.orderList.set(this.getOrderList().indexOf(o), o);
			} else {
				this.orderList.add(o);
			}
			if (reciprocate)
				o.setUser(this, false);
		}
	}
	
	public void removeOrder(Order o) {
		this.orderList.remove(o);
		o.setUser(null);
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "User [orderList=" + orderList + ", id=" + id + ", username=" + username + ", password=" + password
				+ ", accessLevel=" + accessLevel + "]";
	}
	
	public boolean equals(User other) {
		if (other.getId() == this.id)
			return true;
		return false;
	}
}
