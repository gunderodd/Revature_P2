package com.store.app.controller;

import java.util.List;

import javax.servlet.http.Cookie;
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
	public ResponseEntity<Object> login(@RequestBody User u, HttpSession session, HttpServletResponse res) {
		try {
			User real = us.getUserByUsername(u.getUsername());
			if (real != null && real.getPassword().equals(u.getPassword())) {
				Cookie cookie = new Cookie("username",u.getUsername());
				cookie.setPath("/computerStore");
				res.addCookie(cookie);
				session.setAttribute("user", real);
				return new ResponseEntity<>(real, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			// TODO
			// LOG THE ERROR
			return new ResponseEntity<>("Invalid Login Credentials! Username: " + u.getUsername() + ", Password: " + u.getPassword(), HttpStatus.BAD_REQUEST);
		}
		// TODO
		// LOG BAD LOGIN ATTEMPT
		return new ResponseEntity<>("Invalid Login Credentials! Username: " + u.getUsername() + ", Password: " + u.getPassword(), HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<Object> logout(HttpSession session, HttpServletResponse res) {
		Cookie cookie = new Cookie("username",null);
		cookie.setPath("/computerStore");
		res.addCookie(cookie);
		session.invalidate();
		// TODO
		// going to have to fix this for the angular side, this is just a placeholder
		return new ResponseEntity<>("{ \"type\":\"redirect\",\"body\":\"index.html??\" }", HttpStatus.OK);
	}
	
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
