package com.store.app.service;

import java.util.List;

import com.store.app.model.User;

public interface UserService {
	// CRUD
	
	// Create
	public User createUser(User u);
	
	// Read
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public List<User> getAllUsers();
	
	// Update
	public User updateUser(User u);
	
	// Delete
	public void deleteUserById(int id);
}
