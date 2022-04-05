package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.User_accountMapper;
import com.example.demo.model.User_account;

@RestController
public class User_accountController {

	private User_accountMapper mapper;
	
	public User_accountController(User_accountMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping(value = "/users/{user_id}")
	public User_account getUser_account(@PathVariable("user_id") String user_id) {
		return mapper.getUser_account(user_id);
	}
	
	@GetMapping(value = "/users/all")
	public List<User_account> getUser_accountList() {
		return mapper.getUser_accountList();
	}
	
	@PostMapping(value = "/users/")
	public void postUser_account(@RequestBody User_account user_insert) {
		mapper.insertUser_account(user_insert);
	}
		
	@PatchMapping(value = "/users/{user_id}")
	public void patchUser_account(@PathVariable("user_id") String user_id, @RequestBody User_account user_update) {
		mapper.updateUser_account(user_update);
	}
	
	@DeleteMapping("/users/{user_id}")
	public void deleteUser_account(@PathVariable("user_id") String user_id) {
		mapper.deleteUser_account(user_id);
	}
}
