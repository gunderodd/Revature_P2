package com.store.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.dao.UserRepo;
import com.store.app.model.User;
import com.store.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	// Access Repo Bean
	private UserRepo ur;
	
	@Autowired
	public UserServiceImpl(UserRepo ur) {
		this.ur = ur;
	}
	
	// Basic CRUD Methods...

	@Override
	public User createUser(User u) {
		return ur.save(u);
	}

	@Override
	public User getUserById(int id) {
		return ur.findById(id).get();
	}
	
	@Override
	public User getUserByUsername(String username) {
		return ur.findByUsername(username).get();
	}

	@Override
	public List<User> getAllUsers() {
		return ur.findAll();
	}

	@Override
	public User updateUser(User u) {
		return ur.save(u);
	}

	@Override
	public void deleteUserById(int id) {
		ur.deleteById(id);
	}
	
	// ...Other Methods:
	
}
