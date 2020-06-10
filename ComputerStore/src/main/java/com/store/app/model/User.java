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
	private int accessLevel;
	
	// Constructors
	
	public User() {
		super();
	}

	public User(int id, String username, String password, int accessLevel) {
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

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	// To String
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", accessLevel=" + accessLevel
				+ "]";
	}
	
	
}
