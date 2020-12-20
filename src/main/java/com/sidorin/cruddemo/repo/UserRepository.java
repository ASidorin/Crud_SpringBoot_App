package com.sidorin.cruddemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidorin.cruddemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
