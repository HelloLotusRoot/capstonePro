package com.example.demo.controller;

import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.Marker_userMapper;
import com.example.demo.model.Marker_user;

@RestController
public class Marker_userController {

	private Marker_userMapper mapper;
	
	public Marker_userController(Marker_userMapper mapper) {
		this.mapper = mapper;
	}
	
	@MessageMapping(value = "/markers/users")
	@SendTo(value = "/topic/markers/users")
	public String getMarker_userList(String marker) {
		return marker;
		//return mapper.getMarker_userList();
	}
			
/*	@GetMapping(value = "/markers/users")
	public List<Marker_user> getMarker_userList() {
		return mapper.getMarker_userList();
	}
	
	@PostMapping(value = "/markers/users")
	public void postMarker_user(@RequestBody Marker_user marker_userInsert) {
		mapper.insertMarker_user(marker_userInsert);
	}
	
//	@PatchMapping(value = "/markers/users/{userid}")
//	public void patchMarker_user(@PathVariable("userid") String userid, @RequestBody Marker_user marker_userUpdate) {
//		mapper.updateMarker_user(marker_userUpdate);
//	}
	
	@DeleteMapping(value = "/markers/users/{userid}")
	public void deleteMarker_user(@PathVariable("userid") String userid) {
		mapper.deleteMarker_user(userid);
	}
	
	@PutMapping(value = "/user/{id}")
	public void putUser(@PathVariable("id") String id, @RequestBody Marker_user marker_userUpdate) {
	mapper.updateMarker_user(marker_userUpdate);
	}
	*/
}
