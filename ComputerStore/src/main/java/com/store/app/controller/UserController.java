package com.store.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.service.UserService;
import com.store.app.model.User;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserService us;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User u) {
		return us.createUser(u);
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return us.getUserById(id);
	}
	
	@GetMapping("/user/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return us.getUserByUsername(username);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return us.getAllUsers();
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User u) {
		return us.updateUser(u);
	}
	
	@DeleteMapping("/user/{id}") 
	public void deleteUser(@PathVariable("id") int id) {
		us.deleteUserById(id);
	}
}
