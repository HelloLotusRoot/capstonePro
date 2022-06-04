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
		shuttleMap.put("1", new Shuttle("1", 35.26776117458882, 129.08035439908352));
		shuttleMap.put("2", new Shuttle("2", 35.26922971980435, 129.07722740970405));
		shuttleMap.put("3", new Shuttle("3", 35.26915372204809, 129.07719250493824));
		shuttleMap.put("4", new Shuttle("4", 35.26722494629348, 129.0803571673331 ));
		shuttleMap.put("5", new Shuttle("5", 35.27289419398142, 129.09257027925634));
		shuttleMap.put("6", new Shuttle("6", 35.26080393868117, 129.08822163293786));
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

	private Map<String, Admin> adminMap;
	
	@PostConstruct
	public void init2() {
		adminMap = new HashMap<String, Admin>();
		adminMap.put("asd", new Admin("asd", "asd"));
	}
		
	@PostMapping(value = "/admin/markers/shuttlebus")
	public List<Shuttle> postAdminShuttle(@RequestBody Admin admin) {
		String id = admin.getId();
		String pw = admin.getPw();
		if(adminMap.containsKey(id) && adminMap.containsKey(pw)) {
			shuttleMap.put("1", new Shuttle("1", 35.26776117458882, 129.08035439908352));
			shuttleMap.put("2", new Shuttle("2", 35.26922971980435, 129.07722740970405));
			shuttleMap.put("3", new Shuttle("3", 35.26915372204809, 129.07719250493824));
			shuttleMap.put("4", new Shuttle("4", 35.26722494629348, 129.0803571673331 ));
			shuttleMap.put("5", new Shuttle("5", 35.27289419398142, 129.09257027925634));
			shuttleMap.put("6", new Shuttle("6", 35.26080393868117, 129.08822163293786));
			return new ArrayList<Shuttle>(shuttleMap.values());
		}	
		else 
			throw new CustomException(ErrorCode.DATA_NOT_FOUND); 
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
	
}
