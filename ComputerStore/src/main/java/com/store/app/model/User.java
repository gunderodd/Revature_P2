package com.store.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// Ethan note: I think we should change this to 
// User singular (but if we do use escapes for reserved keyword

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="userId")
@Entity
@Table(name = "Users")
public class User {
	
	@OneToOne(mappedBy = "user")
	private StoreCard storecard;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orderList;
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	// later, make unique
	@Column(name = "username", nullable = false)
	// regex, username must have a letter
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	// 0 - Customer
	// 1 - Employee
	// 2 - Administrator
	@Column(name = "access_level", nullable = false)
	private int accessLevel;
	
	// Constructors
	
	public User() {
		super();
	}

	public User(int userId, String username, String password, int accessLevel) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.accessLevel = accessLevel;
	}

	// Getters and Setters

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	
	public StoreCard getStorecard() {
		return storecard;
	}

	public void setStorecard(StoreCard storecard) {
		this.storecard = storecard;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", accessLevel=" + accessLevel
				+ "]";
	}
	
	
}
