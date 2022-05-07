package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value = "/user")
	public User getUser(@PathVariable("id") String id) {
		return mapper.getUser(id);
	}
	
	@GetMapping(value = "/user/all")
	public List<User> getUserList() {
		return mapper.getUserList();
	}
	
	@PostMapping(value = "/user")
	public User postUser(@RequestBody User userInsert) {
		mapper.insertUser(userInsert);
		return userInsert;
	}
	
//	@PatchMapping(value = "/user/{id}")
//	public void patchUser(@PathVariable("id") String id, @RequestBody User userUpdate) {
//		mapper.updateUser(userUpdate);
//	}
	
	@DeleteMapping(value = "/user/{id}")
	public User deleteUser(@PathVariable("id") String id) {
		User userDelete = mapper.getUser(id);
		mapper.deleteUser(id);
		return userDelete;
	}
	
	@PutMapping(value = "/user")
	public User putUser(@PathVariable("id") String id, @RequestBody User userUpdate) {
		mapper.updateUser(userUpdate);
		return userUpdate;
	}
}
