package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public User getUser(@PathVariable("id") String id) {
		return mapper.getUser(id);
	}
	
	@GetMapping(value = "/markers/users")
	public List<User> getUserList() {
		return mapper.getUserList();
	}
	
	@PostMapping(value = "/markers/users")
	public void postUser(@RequestBody User userInsert) {
		mapper.insertUser(userInsert);
	}
	
	@PatchMapping(value = "/markers/users/{id}")
	public void patchUser(@PathVariable("id") String id, @RequestBody User userUpdate) {
		mapper.updateUser(userUpdate);
	}
	
	@DeleteMapping(value = "/markers/users/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		mapper.deleteUser(id);
	}
	
}
