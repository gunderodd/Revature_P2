package com.store.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	// Access Service Bean
	@Autowired
	private UserService us;
	
	// Mappings
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(HttpSession session, @RequestBody String[] args) {
		try {
			User real = us.getUserByUsername(args[0]);
			if (real != null && real.getPassword().equals(args[1])) {
				return new ResponseEntity<>(real, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			// TODO
			// LOG THE ERROR
			return new ResponseEntity<>("Invalid Login Credentials! Username: " +args[0] + ", Password: " + args[1], HttpStatus.BAD_REQUEST);
		}
		// TODO
		// LOG BAD LOGIN ATTEMPT
		return new ResponseEntity<>("Invalid Login Credentials! Username: " + args[0] + ", Password: " + args[1], HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<Object> logout(HttpSession session, HttpServletResponse res) {
		return new ResponseEntity<>("You have successfully logged out, have a nice day!", HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User u) {
		u.setAccessLevel("cust");
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
