package com.store.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.store.app.dao.UserRepo;
import com.store.app.model.User;
import com.store.app.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ComputerStoreApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserService us;
	
	@MockBean
	private UserRepo ur;
	
	@Test
	public void getAllUsers() {
//		int id = 20;
		when(ur.findAll()).thenReturn(Stream.of(new User(45,"testuser","testtuser","cust")).collect(Collectors.toList()));
		assertEquals(1, us.getAllUsers().size());
	}

}
