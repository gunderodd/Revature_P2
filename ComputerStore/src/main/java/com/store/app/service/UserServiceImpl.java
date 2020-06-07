package com.store.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.dao.UserRepo;
import com.store.app.model.User;

@Service
public class UserServiceImpl implements UserService {
	private UserRepo ur;
	
	@Autowired
	public UserServiceImpl(UserRepo ur) {
		this.ur = ur;
	}

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
}
