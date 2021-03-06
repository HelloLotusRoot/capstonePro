package com.example.demo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CustomException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.model.Admin;
import com.example.demo.model.Shuttle;

@RestController
public class ShuttleController {
	
	private Map<String, Shuttle> shuttleMap;
	
	@PostConstruct
	public void init() { // 값 초기화
		shuttleMap = new HashMap<String, Shuttle>();
	}
	
	@GetMapping(value = "/markers/shuttlebus/all")
	public List<Shuttle> getShuttle() {
		return new ArrayList<Shuttle>(shuttleMap.values());
	}
	
	@GetMapping(value = "/markers/shuttlebus/{busid}")
	public Shuttle getShuttle(@PathVariable("busid") String busid) {
		return shuttleMap.get(busid);
	}
	
	@PostMapping(value = "/markers/shuttlebus")
	public Shuttle postShuttle(@RequestBody Shuttle shuttleInsert) {
		String busid = shuttleInsert.getBusid();
		if(shuttleMap.containsKey(busid)) {
			putShuttle(busid, shuttleInsert);
		}
		else 
			shuttleMap.put(busid, shuttleInsert);
			return shuttleMap.get(busid);
	}

	@PutMapping(value = "/markers/shuttlebus/{busid}")
	public Shuttle putShuttle(@PathVariable("busid") String busid, @RequestBody Shuttle shuttleUpdate) {
			if(shuttleMap.containsKey(busid)) {
				shuttleMap.replace(busid, shuttleUpdate);
				return shuttleMap.get(busid);
			}
			else 
				throw new CustomException(ErrorCode.DATA_NOT_FOUND); 
	}
	
	@DeleteMapping(value = "/markers/shuttlebus/{busid}")
	public Shuttle deleteShuttle(@PathVariable("busid") String busid) {
		Shuttle shuttleDelete = shuttleMap.get(busid);
		shuttleMap.remove(busid);
		return shuttleDelete;
	}
	
	private Map<String, Admin> adminMap;
	
	@PostConstruct
	public void init2() {
		adminMap = new HashMap<String, Admin>();
		adminMap.put("asd", new Admin("asd", "asd"));
	}
		
	@PostMapping(value = "/admin/markers/shuttlebus")
	public void postAdminShuttle(@RequestBody Admin admin) {
		String id = admin.getId();
		String pw = admin.getPw();
		if(adminMap.containsKey(id) && adminMap.containsKey(pw)) {
			shuttleMap.clear();
		}	
		else 
			throw new CustomException(ErrorCode.DATA_NOT_FOUND); 
	}
	
	@GetMapping(value = "/admins/all")
	public List<Admin> getAdminList() {
		return new ArrayList<Admin>(adminMap.values()); 
	}
	
	@GetMapping(value = "/admins/{id}")
	public Admin getAdmin(@PathVariable("id") String id) {
		return adminMap.get(id);
	}
	
	@PostMapping(value = "/admins")
	public void postAdmin(@RequestBody Admin adminInsert) {
		String insertId = adminInsert.getId();
		adminMap.put(insertId, adminInsert);
	}
	
	@PutMapping(value = "/admins/{id}")
	public void putAdmin(@PathVariable("id") String id, @RequestBody String pwUpdate) {
		Admin admin = adminMap.get(id);
		admin.setPw(pwUpdate);
	}
	
	@DeleteMapping(value = "/admins/{id}")
	public void deleteAdmin(@PathVariable("id") String id) {
		adminMap.remove(id);
	}
	
}
