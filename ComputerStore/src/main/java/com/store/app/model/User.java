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

// Ethan note: I think we should change this to 
// User singular (but if we do use escapes for reserved keyword

@Entity
@Table(name = "Users")
public class User {
	
	@OneToOne(mappedBy = "user")
	private StoreCard storecard;
	

	@OneToMany(mappedBy = "user")
	private List<Order> orderList;
	
	// getters and setters for orderList?
	public List<Order> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
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
	private int access_level;
	
	// Constructors
	
	public User() {
		super();
	}

	public User(int id, String username, String password, int access_level) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.access_level = access_level;
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

	public int getAccess_level() {
		return access_level;
	}

	public void setAccess_level(int access_level) {
		this.access_level = access_level;
	}

	// To String
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", access_level=" + access_level
				+ "]";
	}
	
	
}
