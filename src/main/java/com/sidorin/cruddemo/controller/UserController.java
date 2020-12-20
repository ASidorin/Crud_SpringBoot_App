package com.sidorin.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sidorin.cruddemo.model.User;
import com.sidorin.cruddemo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public String findAll(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user-list";
	}
	
	@GetMapping("/user-create")
	public String createUserForm(User user) {
		return "user-create";
	}
	
	@PostMapping("/user-create")
	public String createUser(User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}
	
	
	@GetMapping("user-delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userService.deleteById(id);
		return "redirect:/users";
	}
	
	@GetMapping("/user-update/{id}")
	public String updateUserForm(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "/user-update";
	}
	
	@PostMapping("/user-update")
	public String updateUser(User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}

}
