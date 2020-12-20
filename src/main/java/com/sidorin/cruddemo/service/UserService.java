package com.sidorin.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidorin.cruddemo.model.User;
import com.sidorin.cruddemo.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findById(Long id) {
		return userRepository.getOne(id);
		
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
		
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

}
