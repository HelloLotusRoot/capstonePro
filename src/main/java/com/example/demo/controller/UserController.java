package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@RestController
public class UserController {

	private UserMapper mapper;
	
	public UserController(UserMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping(value = "/markers/users")
	public List<User> getUserList() {
		return mapper.getUserList();
	}
	
	@PostMapping(value = "/markers/users")
	public void postUser(@Request) {
		
	}
	
	@PatchMapping(value = "/markers/users/{id}")
	public void patchUser(@PathVariable("id") String id) {
		
	}
	
	@DeleteMapping(value = "/markers/users/{id}")
	
}
