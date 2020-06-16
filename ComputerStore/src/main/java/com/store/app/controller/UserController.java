package com.store.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.exception.BusinessException;
import com.store.app.model.User;
import com.store.app.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	@Autowired
	private UserService us;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(HttpSession session, @RequestBody String[] args) {
		try {
			User real = us.getUserByUsername(args[0]);
			if (real != null && real.getPassword().equals(args[1])) {
				return new ResponseEntity<>(real, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			throw new BusinessException("Invalid Login Credentials! Username: " +args[0] + ", Password: " + args[1]);
		}
		throw new BusinessException("Invalid Login Credentials! Username: " +args[0] + ", Password: " + args[1]);
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User u) {
		u.setAccessLevel("cust");
		return us.createUser(u);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(HttpSession session) {
		return us.getAllUsers();
	}
}
