package com.example.demo.controller;

//import java.sql.Date;
import java.util.List;

//import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public User_account postUser_account(@RequestBody User_account user_accountInsert) {
		mapper.insertUser_account(user_accountInsert);
		return user_accountInsert;
	}
		
//	@PatchMapping(value = "/users/{user_id}")
//	public void patchUser_account(@PathVariable("user_id") String user_id, @RequestBody User_account user_update) {
//		mapper.updateUser_account(user_update);
//	}
	
	@DeleteMapping("/users/{user_id}")
	public User_account deleteUser_account(@PathVariable("user_id") String user_id) {
		User_account user_accountDelete = mapper.getUser_account(user_id);
		mapper.deleteUser_account(user_id);
		return user_accountDelete;
	}
	
	@PutMapping(value = "/users/{user_id}")
	public User_account putUser_account(@PathVariable("user_id") String user_id, @RequestBody User_account user_accountUpdate) {
		mapper.updateUser_account(user_accountUpdate);
		return user_accountUpdate;
	}
	
//	@PutMapping(value = "/users/{user_id}")
//	public void putUser_account(@RequestBody("id_num") int id_num, @PathVariable("user_id") String user_id, @Param("name") String name, @Param("password") String password, @Param("phone") String phone, @Param("nickname") String nickname, @Param("profile_img") String profile_img, @Param("mail") String mail, @Param("bank") String bank, @Param("account_num") String account_num, @Param("dntry_date") Date entry_Date) {
//		mapper.updateUser_account(id_num, user_id, name, password, phone, nickname, profile_img, mail, bank, account_num, entry_date);
//	}
}
