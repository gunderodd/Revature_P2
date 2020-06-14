package com.store.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.app.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	public Optional<User> findByUsername(String username);
//	public Optional<User> findByUserId(int userId);
}
