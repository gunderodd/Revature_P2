package com.store.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	// Access Service Bean
	@Autowired
	private UserService us;
	
	// Mappings
	
	
	
//	@PostMapping("/login")
//	public Cookie login(@RequestBody User u) {
//		// I'm guessing we're going to return a cookie that contains the username. -WK
//	}
	
	// I added request and response parameters for all of the get, update, and delete methods.
	// These may need to be changed to just HttpSession objects.
	// If we do these changes, these WILL NEED TO BE REFLECTED IN UserAspect!!!!!!
	
	@PostMapping("/user")
	public User createUser(@RequestBody User u) {
		// if the user has an access level greater than 0, send back an error
		return us.createUser(u);
	}
	
	@GetMapping("/user/id/{id}")
	public User getUserById(HttpSession session, @PathVariable("id") int id) {
		return us.getUserById(id);
	}
	
	@GetMapping("/user/username/{username}")
	public User getUserByUsername(HttpSession session, @PathVariable("username") String username) {
		return us.getUserByUsername(username);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(HttpSession session) {
		return us.getAllUsers();
	}
	
	@PutMapping("/user")
	public User updateUser(HttpSession session, @RequestBody User u) {
		return us.updateUser(u);
	}
	
	@DeleteMapping("/user/id/{id}") 
	public void deleteUser(HttpSession session, @PathVariable("id") int id) {
		us.deleteUserById(id);
	}
}
